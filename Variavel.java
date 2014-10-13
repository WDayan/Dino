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
	//public Variavel getVariavel(){
	//	return this.variavel;
	//}
	//public void setVariavel(Variavel j){
	//	this.Variavel = j;
	//}
	public static boolean ehDouble(String s, int i){
		String Double = new String("double ");
		if(Double.regionMatches(0, s, i, 7)) //Função teste se a string DOUBLE  é igual a região que eu defini da string S.
			return true;
		else
			return false;
	}
	
	public static String novaVariavel(String s, int comeco, int ultimo){//Recebe  a String, o começo da variavel, e até a , ou o ;
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
	
	public static int achaNovaVariavel(String s, int comeco){ //Recebe a string e o começo da Criação, método serve para separa cada variavel, as virgulas, e ;'s ....
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

	public static int achaVariavel(Variavel v[], String s){ //Recebe todas as variaveis, e o NOME de uma variavel. Aí faz a busca e retorna o INDICE da variavel buscada!!!
		int i;
		for(i = 0; v[i].nome != null; i++){ 
			if(v[i].nome.equals(s)){
				return i;		
			}
		}
		return - 1;
	}







	
}

