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

	public double fazDouble(String s, int comeco, int ultimo){
		char c;
		int i;
		String aux = new String();		
		for(comeco; i <= ultimo; i++){
			c = s.charAt(i);
			aux += c;
		}
		return Double.parseDouble(aux);
	}
	public boolean ehDouble(String s, int i){
		int gira = 2,int j = i;
		char c;
		boolean b = true;
		while(gira > 1){
			i--;
			c = s.charAt(i);
			if(Character.isDigit(c)){
				i = i;
			}
			else if(c = '.'){
				while(gira > 1){
					i--;
					c = s.charAt(i);
					if(Character.isDigit(c)){
						i = i;
					}
					else{
						tmp = fazDouble(s,i,j);
						return b;
					}
				}
			}
			else{
				gira = 1;
				return b = false;
			}		
		}
		return b;	
	}
	
	public boolean ehInt(int i){
	
	
	
	}

	public double opera(String s, int i){
	/*String s, na posição I tem um =, ou seja, preciso resolver
	tudo o que vier e devolver só o resultado dessa bagaça.*/
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
							c = s.charAt(j);
							if(c == ' '){
								j = j; // Ignorar ESPACOS.
							}
							if(c = '*'){ // Caso encontre um multiplicação dentro dos ( ) ==> Ordem de PREFERÊNCIA.
								if(c == ' '){
									while(c == ' '){ // Gira para ignorar todo ESPACO
										espaco--;
										c = s.charAt(espaco);
									}
								}							
								espaco = j-1; // Depois de tirar os ESPACOS, vamos ver o que sobrou. E isso para a ESQUERDA do *
								c = s.charAt(espaco);
								if(isLetter(c) == true){
									//Achou uma variavel.Precisa testar caso encontre ( ). Funciona também ?
								}
								else if(Character.isDigit(c)){ // Caso seja um número
									if(ehDouble(s, espaco)){ //Caso seja Double
										b = tmp;
									}
									else// Se não for double eh INT.
										bi = tmp; // bi eh a variavel B INT.
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
	
	
	
	
	}



}







