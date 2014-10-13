class Operacoes{
	private double a,b;
	private double[] valores = new double[30];
			
	public double subtrai(){
		return a - b;
	}
	public double soma(){
		return a + b;
	}
	public double multiplica(){
		return a * b;
	}
	public double divide(){
		return a / b;
	}
	
	
	public String achaDouble(String s, int posicao){//Venha a String inteira, e a posicao do começo do numero.
		String result = new String();
		char c;
		do{
			c = s.charAt(posicao);
			if(c == '+' || c == ')' || c == '-' || c == '(' || c == '*' || c == '/' || c == ';')
				posicao = s.length();
			else{
				result += c;
				posicao++;
			}
		}while(posicao < s.length());
		return result.toString();
	}

	public double fazDouble(String s){//Só devolve o número Double já encontrado.
		return Double.parseDouble(s);
	}
	
	public int prioridade(char c){//Pra saber dos operadores qual tem a maior prioridade
		if(c == '(')
			return 1;
		else if(c == '+' || c == '-')
			return 2;
		else if(c == '*' || c == '/') //O Outro caso quando eh * ou /
			return 3;
		return 0;
	}
	
	public String deletaChar(String s, int i){//Recebe a String e a posicao do CHAR que deve ser deletada.
		int j;
		String nova = new String();
		for(j = 0;j < i; j++)//Deleta o ultimo caracter.
			nova += s.charAt(j);
		return nova.toString();	
	}
	
	public double valorLetra(char c){// Recebe um Char, e de acordo com o char, devolve a posicao no vetor valores!
		int i = - 1;
		switch(c){
			case 'a': i = 0; break;
			case 'b': i = 1; break;
			case 'c': i = 2; break;
			case 'd': i = 3; break;
			case 'e': i = 4; break;
			case 'f': i = 5; break;
			case 'g': i = 6; break;
			case 'h': i = 7; break;
			case 'i': i = 8; break;
			case 'j': i = 9; break;
			case 'k': i = 10; break;
			case 'l': i = 11; break;
			case 'm': i = 12; break;
			case 'n': i = 13; break;
			case 'o': i = 14; break;
			case 'p': i = 15; break;
			case 'q': i = 16; break;
			case 'r': i = 17; break;
			case 's': i = 18; break;
			case 't': i = 19; break;
			case 'u': i = 20; break;
			case 'v': i = 21; break;
			case 'w': i = 22; break;
			case 'x': i = 23; break;
			case 'y': i = 24; break;
			case 'z': i = 25; break;
		}
			if(i < 0)
				return - 1;
		return valores[i];	
	}
	
	

	
	public double calcula(String s, int i, Variavel v[]){ //Recebe a string que vai calcular, a posicao que começa o calculo, e o conjunto de variaveis.
		//infixaToPosfixa!!
		char c;
		int posicao, keep = 1,indice=0;
		String letras = new String("abcdefghijklmnopqrstuvwxyz");
		String pilhaInfixa = new String();
		String result = new String();
		String aux = new String();
		c = s.charAt(i);
		i++;
		for(posicao = 0; i < s.length() || c != ';'; i++){
			if(Character.isLetter(c)){//Se encontrar uma letra,
				aux += c;
				i++;
				c = s.charAt(i-1);
				while(Character.isLetter(c)){//vai varrer até encontrar todo o nome da Variavel.
					aux += c;
					i++;
					c = s.charAt(i-1);
				}
				result += letras.charAt(indice); //Depois irá colocar um nome temporário, no resultado, deixando tudo como a+b+c-d/e ..... y;
				valores[indice] = v[Variavel.achaVariavel(v, aux)].getValor(); //Vai pegar o valor dessa variável e guardá-lo tbm!
				indice++;
				c = s.charAt(i-1);
				aux = "";
			}
			if(Character.isDigit(c) == true){
				aux += c;
				c = s.charAt(i);
				while(Character.isDigit(c) == true){
					aux += c;
					i++;
					c = s.charAt(i);
				}
				result += letras.charAt(indice);
				valores[indice] = fazDouble(aux);
				indice++;
				c = s.charAt(i);
				aux = "";
			}
			else if(c == ' ')
				i = i;
			else if(c == '*' || c == '/' || c == '+' || c == '-'){
				if(posicao > 0 && (prioridade(pilhaInfixa.charAt(posicao-1)) >= prioridade(c))){
						result += pilhaInfixa.charAt(posicao-1);
						pilhaInfixa = deletaChar(pilhaInfixa, posicao-1);
						posicao--;
					}
				pilhaInfixa += c;
				posicao++;
			}
			else if(c == '('){
				pilhaInfixa += c;
				posicao++;
			}
			else if(c == ')'){
				do{
					result += pilhaInfixa.charAt(posicao-1);
					pilhaInfixa = deletaChar(pilhaInfixa, posicao-1);
					posicao--;
					c = pilhaInfixa.charAt(posicao-1);
				}while(c != '(');
				pilhaInfixa = deletaChar(pilhaInfixa, posicao-1);
				posicao--;
			}
		if(i < s.length()){
			c = s.charAt(i);
			}
		}
		
		while(posicao > 0){
			result += pilhaInfixa.charAt(posicao-1);
			posicao--;
		}
		//Até aqui vai a infixaToPosfixa!!!
		
		//Começa Posfixa!!!
		double [] pilha = new double[100];
		posicao = 0;	
		for(i = 0; i < result.length(); i++){
			c = result.charAt(i);
			if(Character.isLetter(c)){
				pilha[posicao] = valorLetra(c);
				posicao++;
			}
			else if(c == '+' || c == '-' || c == '*' || c == '/'){
					a = pilha[posicao-2];
					b = pilha[posicao-1];
					posicao -= 2;
					switch(c){
						case '+':
							pilha[posicao] = soma();
							posicao++;
							break;
						case '-':
							pilha[posicao] = subtrai();
							posicao++;
							break;
						case '*':
							pilha[posicao] = multiplica();
							posicao++;
							break;
						case '/':
							pilha[posicao] = divide();
							posicao++;
							break;
					}
				}
			}
		return pilha[0]; //Devolve o resultado
	}
		
		
		
		
		
}	
	
	
	
	
	
	