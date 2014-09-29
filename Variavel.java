import javax.swing.*;
class Variavel{
	private int indice, j;
	private String nome;
	private double valor;
	private boolean bv;
	
/*	public void setJ(int J){
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
	//public char getNome(){
		//return this.nome;
	//}

	public void ehInt(String s, int i){//Quando encontra i de INT precisa jogar nessa função.
		String nova = new String();
		String inteiro = new String("int ");
		String aux = new String();
		int correto = 1;
		char c;
		if(inteiro.regionMatches(0, s, i, 4)){
			i += 3;
			while(correto < 2){
				i++;
				c = s.charAt(i);
				if(c == ' ')
					i = i;
				else if(c == ';'){
					System.out.println("If do ; i = "+i);
					nova = aux;
					correto = 3;
					System.out.println("Nova = "+nova);
				}
				else if(c == ','){
				System.out.println("If do , i = "+i);
					nova = aux;
				}
				else{
					System.out.println("C = "+c);
					aux += c;
					System.out.println("Aux = "+aux);
				}
			}
		}
		System.out.println("Resultado foi\n\n"+nova);
		//return nova;
	}


	
}