class Expressoes{



	public int resolve(String s, int i){
	/*String s, na posição I tem um =, ou seja, preciso resolver
	tudo o que vier e devolver só o resultado dessa bagaça.*/
		Subtracao sub = new Sutracao();
		int j = i + 1, keep = 2, indice1, indice2,k;
		char c = s.charAt(i);
		for(j; c != ';'; j++){
			c = s.charAt(j);
			if(c == ' ')
				j = j; //Não faz nada, encontrou um ESPACO.
			if(c == '('){
				k = j;
				while(keep > 1){
					j++
					c = charAt(j);
					if(c == ' ')
						j = j;
					else if(c == ')'){
					
					}					
					else if(c == '*'){
						if(c=charAt() )
					}
					else if(c == '/'){
					
					}
					else if(c == '+'){
					
					}
					else if(c == '-'){
					
					}
					
					
				}
			}
		
		
		}
	
	
	
	
	}



}