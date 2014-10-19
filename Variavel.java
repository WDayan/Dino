class Variavel{
	public String nome;
	private double valor;
	
	public void setValor(double v){
		this.valor = v;
	}
	public double getValor(){
		return this.valor;
	}
	public void setNome(String s){
		this.nome = s;
	}
	public String getNome(){
		return this.nome.toString();
	}

	public static boolean ehDouble(String s, int i){//Recebe no 'd'. Devolve TRUE caso: for crianção de variavel. se não FALSE
		String Double = new String("double ");
		if(Double.regionMatches(0, s, i, 7))//Função teste se a string DOUBLE  é igual a região que eu defini da string S.
				return true;
		return false;
	}
	
	public static String novaVariavel(String s, int comeco, int ultimo){ //Recebe o começo e o final da variavel, e devolve o nome dela.
		String aux = new String();
		while(comeco <= ultimo){
			if(s.charAt(comeco) == ' ') //Para ignorar espacos.
				comeco = comeco;
			else
				aux += s.charAt(comeco);//Se não for espaco, eh a minha variavel.
			comeco++;	
		}
		return aux.toString();
	
	
	}
	
	public static int achaNovaVariavel(String s, int comeco){ //Acha a ultima posicao da variavel.
		int ultimo = comeco;
		boolean feito = true;//Só existe pra ficar girando no WHILE.
		char c;
		while(feito){
			c = s.charAt(ultimo);
			if(c == ' '){
				ultimo = ultimo; //Se encontrar espaco não faz nada.
			}
			else if(c == ','){ //Se for , já encontrou o que queria.
				return ultimo - 1;
			}
			else if(c == ';'){ //Se for ; já encontrou o que queria.
				return ultimo - 1;
			}
			ultimo++;		
		}
		return 0;
	}

	public static int achaVariavel(Variavel v[], String s){//Recebe o conjunto de variaveis, e a variavel a ser procurada. Devolve o indice da variavel passada. Se não devole -1.
		int i;
		for(i = 0; v[i].nome != null; i++){ 
			if(v[i].nome.equals(s)){
				return i;		
			}
		}
		return - 1;
	}
	
	public static String qualVariavelParaAtribuir(String s, int i){//Recebe a String, e a posicao exata do '='. Irá voltar, e encontrar a variavel antes do '=' !! Devolve o Nome da Variavel.
		String aux = new String();
		char c = s.charAt(i);
		for(i -= 1; Character.isLetter(c) == false; i--){
			c = s.charAt(i);
		}
		for(i = i, c = s.charAt(i + 1); Character.isLetter(c) == true; i--){
			if(i == -1)
				break;
			c = s.charAt(i);
		}
		if(Character.isLetter(c) == false){
			i++;
		}
		for(i += 2, c = s.charAt(i-1); Character.isLetter(c); i++){
			aux += c;
			c = s.charAt(i);
		}
		return aux.toString();
	}
	
	public void atribuicao(Variavel v[], String nome, double valor){//Recebe as variaveis, o NOME duma delas, e o valor para colocar.
		v[Variavel.achaVariavel(v, nome)].setValor(valor);	
	}





	
}

