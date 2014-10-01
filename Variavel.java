import javax.swing.*;
class Variavel{
	private int indice, j;
	public String nome;
	private double valor;
	private boolean bv;
	
	/*public void setJ(int J){
		this.j = J;
	}
	public int getJ(){
		return this.j;
	}*/
	public void setIndice(int ind){
		this.indice = ind;
	}
	public int getIndice(){
		return this.indice;
	}
	public void setBv(boolean b){
		this.bv = b;
	}
	public boolean getBv(){
		return this.bv;
	}
	public void setNome(String s){
		this.nome = s;
	}
	public String getNome(){
		return this.nome.toString();
	}
	
	public static boolean ehDouble(String s, int i){
		String Double = new String("double ");
		if(Double.regionMatches(0, s, i, 7))
			return true;
		else
			return false;
	}
	
	public static int giraAteVirgula(String s, int i){//Método pode ser usado caso encontre uma atribuição no meio de declarações.
		char c;
		do{
			i++;
			c = s.charAt(i);		
		}while(c != ',');
		
		return i;
	}
	

	public static boolean ehInt(String s, int i){//Quando encontra i de INT essa função descobre se eh. Mas apenas no primeiro caso.
		String inteiro = new String("int ");
		//String aux = new String();
		if(inteiro.regionMatches(0, s, i, 4))
			return true;
		else
			return false;
		
	}

		


	
}



	/*Código que encontra o nome da Variavel depois do INT.
	i += 3;
	while(correto < 2){
		i++;
		c = s.charAt(i);
		if(c == ' ')
			i = i;
		else if(c == ';'){
			this.nome = aux;
			correto = 3;
		}
		else if(c == ','){
			this.nome = aux;
			correto = 3;
			this.virgula = true;
		}
		else{
			aux += c;
		}
	}*/

