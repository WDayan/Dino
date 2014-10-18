class Saida{



	public void imprima(Variavel v[], String s, int i){ //Funcao não faz a verificação se realmente eh um imprima. <-- REVER!!!!!!//Precisa receber no 1° (
		char c; //O problema aqui, eh que se ele quiser imprimir o NOME da variavel, na verdade irá imprimir o VALOR dela. Por causa dos "" Que não consegui testar ainda
		//System.out.println(s);
		String aux = new String();
		double valor;
		int indice = 0, tmp;
		c = s.charAt(i);
		for(i += 1; c != ';' && i < s.length(); i++){
				if(c == '"'){
					c = s.charAt(i);
					for(i += 1; c != '"'; i++){
						aux += c;
						c = s.charAt(i);
					}
					System.out.print(aux);
					aux = "";
				}
				if(c == '+'){
					c = s.charAt(i);
					while(c != ')' && c != '+'){
						if(Character.isLetter(c)){
							aux = Verificacoes.achaTodoONome(s, i);
							//System.out.println("\n\nAqui"+aux);
							System.out.print(v[Variavel.achaVariavel(v, aux)].getValor());
							aux = "";
							i = Verificacoes.giraAteNaoCaracter(s, i) - 1;
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

	public boolean ehImprima(String s, int i){ //Recebe no 'i'. Devolve TRUE caso: for imprima(); se não FALSE
		String Imprima = new String("imprima");
		if(Imprima.regionMatches(0, s, i, 7))
			return true;
		return false;
	}
	
	public boolean ehImprimaNumero(String s, int i){//Recebe no 'i'. Devolve TRUE caso: for imprimaNumero(); se não FALSE
		String Imprima = new String("imprimaNumero");
		if(Imprima.regionMatches(0, s, i, 13))
				return true;
		return false;	
	}
	public void imprimaNumero(double num){//Recebe só UM n° para ser impresso.
		System.out.println(num);
	}
	
}














