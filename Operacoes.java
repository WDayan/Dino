class Operacoes{
	double a,b,tmp;
	int ai, bi, tmpi;
	
	public double subtrai(){
		return a - b;
	}
	public double soma(){
		return a - b;
	}
	public double multiplica(){
		return a * b;
	}
	public double divide(){
		return a / b;
	}

	public double fazDouble(String s, int comeco, int ultimo){//String , começo do Numero e Final dele
		char c;
		int i;
		String aux = new String();		
		for(i = comeco; i <= ultimo; i++){
			c = s.charAt(i);
			aux += c;
		}
		return Double.parseDouble(aux);
	}
	public int fazInt(String s, int comeco, int ultimo){//String , começo do Numero e Final dele
		char c;
		int i;
		String aux = new String();
		for(i = comeco;i <= ultimo; i++){
				c = s.charAt(i);
				aux += c;
		}
		return Integer.parseInt(aux);
	
	}
	
	public static int prioridade(char c){
		if(c == '(')
			return 1;
		else if(c == '+' || c == '-')
			return 2;
		else if(c == '*' || c == '/') //O Outro caso quando eh * ou /
			return 3;
		return 0;
	}
	
	public String deletaChar(String s, int i){
		int j;
		String nova = new String();
		for(j = 0;j < i; j++)//Deleta o ultimo caracter.
			nova += s.charAt(j);
			
		return nova.toString();	
	}
	
	public String infixaToPosfixa(String s, int i){
		char c;
		int posicao = 0, keep = 1;
		String pilha = new String();
		String result = new String();
		c = s.charAt(i);
		do{
			if(Character.isLetter(c))
				result += c;
			else if(Character.isDigit(c))
				result += c;
			else if(c == ' ')
				i = i;
			else if(c == '*' || c == '/' || c == '+' || c == '-'){
				if(posicao > 0 && (Operacoes.prioridade(pilha.charAt(posicao-1)) >= (Operacoes.prioridade(c)))){
						result += pilha.charAt(posicao-1);
						System.out.println("Resultado = "+result);
						System.out.println("Pilha no For = "+pilha);
						pilha = deletaChar(pilha, posicao-1);
						posicao--;
					}
				
				pilha += c;
				posicao++;
				System.out.println("Pilha = "+pilha);
			}
			else if(c == '('){
				pilha += c;
				posicao++;
			}
			else if(c == ')'){
				do{
					result += pilha.charAt(posicao-1);
					pilha = deletaChar(pilha, posicao-1);
					posicao--;
					c = pilha.charAt(posicao-1);
				}while(c != '(');
				pilha = deletaChar(pilha, posicao-1);
				if(posicao == 1)
					posicao = posicao;
				else
					posicao--;
				System.out.println("Posicao = "+posicao);
				System.out.println("Logo depois de Posicao PILHA = "+pilha);
				
								
			}
		i++;
		if(i < s.length())
			c = s.charAt(i);
		else 
			c = ';';
		}while(c != ';');
		
		posicao--;
		while(posicao >= 0){
			result += pilha.charAt(posicao);
			posicao--;
		}
		System.out.println("Pos fixa = "+result);
		return result.toString();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*public boolean ehDouble(String s, int i){// i = Posicao do NUMERO.
		int gira = 2,int j = i;
		char c;
		boolean b = true, achou = true;
		while(gira > 1){
			i--; //Do numero encontrado, vai para ESQUERDA, em busca de todo o numero.
			c = s.charAt(i);
			if(Character.isDigit(c)){
				i = i;
				achou = false; //Se achou eh FALSE, ele achou! hahaha
			}
			else if(Character.isDigit(s.charAt(i+2))){ // Faz o mesmo teste que acima, só com i + 2.
				i = i + 2;
				c = s.charAt(i+1);
				achou = false;
			}			
			else if(c = '.'){
				while(gira > 1){
					i--;
					c = s.charAt(i);
					if(Character.isDigit(c)){
						i = i;
					}
					else{
						tmp = fazDouble(s, i + 1, j);//achou algo != de Numero, precisa do indice anterior. i + 1 ---  I = Começo do Numero. J = Fim do Numero
						return b; 
					}
				}
			}
			else if((c == '*' || c == '/' || c == '+' || c == '-' || c == ' ' || c == ')' || c == '(' ) && achou){//quer dizer que a precisa procurar a DIREITA.
				while(gira > 1){
					j++; //Precisa procurar a DIREITA
					s.charAt(j);
					if(Character.isDigit(c)){
						j = j;
					}
					else if(c = '.'){
						while(gira > 1){
							j++;
							c = s.charAt(j);
							if(Character.isDigit(c)){
								j = j;
							}
							else{
								tmp = fazDouble(s, i+1, j-1);//achou algo != de Numero, precisa do indice anterior.
								return b;
							}
						}
					}
					else{
						gira = 1;
						tmp1 = fazInt(s, i+1, j-1);
						return b = false;
					}
				}
			}
			else{
				gira = 1;
				tmpi = fazInt(s,i+1,j);
				return b = false;
			}		
		}
		return b;	
	}
	

	/*public double opera(String s, int i){
	/*String s, na posição I tem um =, ou seja, preciso resolver
	tudo o que vier e devolver só o resultado dessa bagaça.
		int j = i + 1, keep = 2, indice1, indice2,k,espaco;
		char c = s.charAt(i);
		for(j; c != ';'; j++){
			c = s.charAt(j);
			if(c == ')'){//acha o final de ( ) 
				k = j;
				while(keep > 1){
					k--; //Volta até encontrar o começo dos ( )
					c = s.charAt(k);
					if(c == '('){
						while(keep > 1){ //Keep só existe pra continuar girando.
							j--;//J Precisa voltar, para verificar o que existe dentro dos ( ).
						switch(c){
							c = s.charAt(j);
						case ' ':
								j = j; // Ignorar ESPACOS.
							break;
						case '*': // Caso encontre um multiplicação dentro dos ( ) ==> Ordem de PREFERÊNCIA.
								c = s.charAt(j-1);
								if(c == ' '){
									espaco = j-2;
									while(c == ' '){ // Gira para ignorar todo ESPACO
										espaco--;
										c = s.charAt(espaco);
									}
								}							
								//espaco = j-1; // Depois de tirar os ESPACOS, vamos ver o que sobrou. E isso para a ESQUERDA do *
								else if(c == ')'){ //Se encontrou um ) precisa vasculhar para a direita.
									c = s.charAt(j+1)
									if(c == ' '){
										espaco = j + 2;
										while(c == ' '){ //Serve para ignorar todo ESPACO.
											espaco++;
											c = s.charAt(espaco);
										}
									}
									else if(isLetter(c)){
										//Achou uma variavel.
									}
									else if(Character.isDigit(c)){
										if(ehDouble(s, espaco)){
											b = tmp;
										}
									}
								}
								else if(isLetter(c)){
									//Achou uma variavel.Precisa testar caso encontre ( ). Funciona também ?
								}
								else if(Character.isDigit(c)){ // Caso seja um número
									if(ehDouble(s, espaco)){ //Caso seja Double
										b = tmp;
									}
									else{// Se não for double eh INT.
										tmpi = fazInt(s, espaco);
										bi = tmpi; // bi eh a variavel B INT.
									}
								}
							break;
						case '/':
						
						
							break;
						case '+':
						
							break;
						case '-':


							break;
						
							}
						}
						}
					}
						
					}
					else if(){
					
					}
					if(isLetter(c) == true)
				}
			
			}

		
		
		}
	
	
	
	
	}*/



}







