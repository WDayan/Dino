class Saida{



	public void imprima(Variavel v[], String s, int i){ //Funcao não faz a verificação se realmente eh um imprima. <-- REVER!!!!!!//Precisa receber no 1° (
		char c; //O problema aqui, eh que se ele quiser imprimir o NOME da variavel, na verdade irá imprimir o VALOR dela. Por causa dos "" Que não consegui testar ainda
		//System.out.println(s);
		String aux = new String();
		double valor;
		int indice = 0, tmp;
		c = s.charAt(i);
		for(i = i+1; c != ';' && i < s.length(); i++){
				if(Character.isLetter(c)){
					for(i = i; c != ')' && c != '+' && i < s.length(); i++){
						if(c == '"')
							i = i;
						else
							aux += c;
						c = s.charAt(i);
					}
					tmp = Variavel.achaVariavel(v, aux);
					if(tmp == - 1)
						System.out.print(aux);
					else
						System.out.print(v[tmp].getValor());
					aux = "";
					if(i == s.length()){
						System.out.print(" ");
						return ;
					}
				}
				if(c == '+'){
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
							indice = Variavel.achaVariavel(v, aux);
							if(indice == - 1)
								System.out.print(aux);
							else
								System.out.print(v[indice].getValor());
							aux = "";
						
						}
						i++;
						c = s.charAt(i);
						if(c == '+')
							i++;
					}
				}
			c = s.charAt(i);
		}
		System.out.print("\n");
	}
	
	public static int giraAtePrimeiroParenteses(String s, int i){ //Recebe alguma posicao antes do (, e vai girar até a 1° ocorrência de (.
		char c;
		c = s.charAt(i);
		for(i += 1; c != '('; i++)
			c = s.charAt(i);
		return i;
	}
	
	public static int giraAteUltimoParenteses(String s, int i){ //Recebe alguma posicao, vai girar até achar um )
		char c;
		c = s.charAt(i);
		for(i += 1; c != ')'; i++)
			c = s.charAt(i);
		return i;
	}

	public boolean ehImprima(String s, int i){ //Função não está testada ainda.
		String Imprima = new String("imprima");
		if(Imprima.regionMatches(0, s, i, 7)){
		if(s.charAt(i - 1) == ';' || s.charAt(i - 1) == ' ' || s.charAt(i - 1) == '}')
			return true;
		}
		return false;
	}
	
	public boolean ehImprimaNumero(String s, int i){
		String Imprima = new String("imprimaNumero");
		if(Imprima.regionMatches(0, s, i, 13)){
			if(s.charAt(i - 1) == ';' || s.charAt(i - 1) == ' ' || s.charAt(i - 1) == '}')
				return true;
		}
		return false;	
	}
	public void imprimaNumero(double num){
		System.out.println(num);
	}
	
}














