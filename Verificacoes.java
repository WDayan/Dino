class Verificacoes{
	private double valor1, valor2;
	private boolean b;
	private int linhaF;
	
	public int getLinha(){
		return this.linhaF;
	}
	
	public void setLinha(int linha){
		this.linhaF = linha;
	}
	
	public static int giraAteNaoCaracter(String s, int i){ //Recebe alguma posicao do Caracter
		char c;
		c = s.charAt(i);
		for(i = i + 1; Character.isLetter(c); i++)
			c = s.charAt(i);
		return i - 1;
	}
	
	public static int giraAteNaoNumero(String s, int i){//Recebe alguma posicao do Numero.
		char c;
		c = s.charAt(i);
		for(i = i + 1; Character.isDigit(c); i++)
			c = s.charAt(i);
		return i - 1;
	}
	
	public static String achaTodoONome(String s, int i){ //Recebe a posicao do 1° Caracter! Devolve o nome encontrado.
		char c;
		String nome = new String();
		c = s.charAt(i);
		while(Character.isLetter(c)){
			nome += c;
			i++;
			c = s.charAt(i);
		}
		return nome.toString();	
	}
	
	public static double achaTodoONumero(String s, int i){ //Recebe a 1° posicao do Numero. Devolve o Numero, já em Double.
		char c;
		String numero = new String();
		c = s.charAt(i);
		while(Character.isDigit(c)){
			numero += c;
			i++;
			c = s.charAt(i);
		}
		return Double.parseDouble(numero);	
	}
	
	public static int achaPrimeiroNumero(String s, int i){ //Recebe alguma posicao, só para quando achar a 1° posicao do numero.
		char c;
		c = s.charAt(i);
		while(Character.isDigit(c) == false){
			i++;
			c = s.charAt(i);
		}
		return i;		
	}
	
	
	public int giraAteEscopo(String s, int i, String pg[], int linha){ //Se o IF der FALSE, ele vai girar até sair do escopo. Recebe qualquer posicao dentro do IF!!
		char c;
		int escopo = 0;
		linhaF = linha; //F de final. Que será alterada.
		while(s.charAt(i) != '{'){//Acha o primeiro escopo.
			i++;
		}
		if(b){//Saberá se o IF mais recente eh FALSE ou TRUE. 
			return i+1;
		}
		else{
			for(i += 1, escopo = 1; pg[linhaF] != null && escopo > 0; linhaF++){
				s = pg[linhaF];
				if(linhaF > linha)
					i = 0;
				for(i = i; escopo > 0 && i < s.length(); i++){//Vai achar o escopo, e devolver a posicao que deve continuar.
					c = s.charAt(i);
					//System.out.println("Char = "+c);
					if(c == '{')
						escopo ++;
					else if(c == '}')
						escopo --;
				}
			}
		}
		return i;
	}
	
	
	public boolean seIf(Variavel v[], String s, int i){//precisa receber a posicao da string no comeco dos (   Faz a comparação e devolve TRUE or FALSE.
		char c;
		int op = 1, parte = 1;
		String aux = new String();
		double tmp;
		c = s.charAt(i);
		for(i = i + 1; c != ')'; i++){
			if(Character.isLetter(c)){
				aux = Verificacoes.achaTodoONome(s, i-1);
				i = Verificacoes.giraAteNaoCaracter(s, i-1);
				if(parte == 1)
					valor1 = v[Variavel.achaVariavel(v, aux)].getValor();
				else
					valor2 = v[Variavel.achaVariavel(v, aux)].getValor();
				aux = "";
			}
			else if(Character.isDigit(c)){
				tmp = Verificacoes.achaTodoONumero(s, i-1);
				i = Verificacoes.giraAteNaoNumero(s, i-1);
				if(parte == 1)
					valor1 = tmp;
				else
					valor2 = tmp;
				aux = "";
			}
			else if(c == '=' || c == '<' || c == '>' || c == '!'){
				op = i - 1;
				parte = 2;
				i++;
			}
			c = s.charAt(i);
		}
		c = s.charAt(op);
		switch(c){
		case '<':
			if(s.charAt(op + 1) == '='){
				if(valor1 <= valor2){
					b = true;
				}
				else
					b = false;
			}
			else if(valor1 < valor2)
				b = true;
			else
				b = false;
			break;
		case '>':
			if(s.charAt(op + 1) == '='){
				if(valor1 >= valor2)
					b = true;
				else
					b = false;
			}
			else if(valor1 > valor2)
				b = true;
			else
				b = false;
			break;
		case '=':
			if(valor1 == valor2)
				b = true;
			else
				b = false;
			break;
		case '!':
			if(valor1 != valor2)
				b = true;
			else
				b = false;
			break;	
		}	
		return b;
	}

	public boolean ehIf(String s, int i){ //Recebe a posicao no I. Devolve TRUE or FALSE
		if(s.charAt(i) == 'i' && s.charAt(i+1) == 'f' && (s.charAt(i+2) == ' ' || s.charAt(i+2) == '('))
			return true;
		return false;	
	}
	
	public boolean ehDo(String s, int i){ //verifica se eh um laco (inicio). Devolve TRUE or FALSE
		String nomeDo = new String("do");
		if (nomeDo.regionMatches(0, s, i, 2) && (s.charAt(i+2) == ' ' || s.charAt (i+2) == '{') )
			return true;
		return false;

	}

	public boolean ehWhile(String s, int i){ //verifica se eh um laco (fim). Devolve TRUE or FALSE
		String nomeWhile = new String("while");
		if (nomeWhile.regionMatches(0, s, i, 5) && (s.charAt(i+5) == ' ' || s.charAt (i+5) == '(') )
			return true;
		return false;
	}
	
	public boolean lerScanner(String s, int i){
	String nomeLer = new String("ler");
	if (nomeLer.regionMatches(0, s, i, 3) && (s.charAt(i+3) == ' ' || s.charAt(i+3) ==';'))
		return true;
	return false;
	}
}