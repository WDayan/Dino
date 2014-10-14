class Saida{



	public void imprima(Variavel v[], String s, int i){ //Funcao não faz a verificação se realmente eh um imprima. Recebe as variaveis, a String, e a posicao que começa o IMPRIMA
		char c;
		System.out.println(s);
		String aux = new String();
		double valor;
		c = s.charAt(i);
		for(i = i+1; c != ';'; i++){
			switch(c){
				case '"':
					c = s.charAt(i);
					for(i = i + 1; c != '"'; i++){
						aux += c;
						c = s.charAt(i);
					}
					System.out.print(aux);
					aux = "";
					break;
				case '+':
					c = s.charAt(i);
					while(c != ')' && c != '+'){
						if(c == ' ')
							i = i;
						if(c == ')')
							break;
						if(Character.isLetter(c)){
							aux += c;
							c = s.charAt(i+1);
							while(Character.isLetter(c)){
								i++;
								aux += c;
								c = s.charAt(i+1);
							}
							valor = v[Variavel.achaVariavel(v, aux)].getValor();
							System.out.print(valor);
							aux = "";
						}
						i++;
						c = s.charAt(i);
						if(c == '+')
							i++;
					}
					break;
			}
			c = s.charAt(i);
		}
		System.out.print("\n");
	}
	

	public boolean ehImprima(String s, int i){ //Função não está testada ainda.
		if(s.charAt(i - 1) == ';' || s.charAt(i - 1) == ' ')
			return true;
		return false;
	}
	public void imprimaNumero(double num){//Recebe um único numero a ser impresso.
		System.out.println(num);
	}
	
}














