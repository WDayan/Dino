class Variavel{
	private int j, indice;
	private String nome;
	private double valor;
	private boolean bv;
	
	public void setJ(int J){
		this.j = J;
	}
	public int getJ(){
		return this.j;
	}
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
	public char getNome(){
		return this.nome;
	}
	public void setValor(double v){
		this.valor = v;
	}
	public double getValor(){
		return this.valor;
	}
	
	public int ehInt(){
		String s = new String();
		int correto = 1;
		bv=correto == 1;
		j = this.i;
		if(this.v[j+2] == 't' && (this.v[j-1] == ' ' || this.v[j-1] == ';')){
			j += 2;
			while(bv){
				j++;
				if(this.v[j] == ' '){ //Se v[j] = ESPAÇO,
					j = j;			  //Continua girando, até achar algo diferente.
				}
				else if(this.v[j] == '='){ //Se for igual a "=" preciso fazer outro processo.
					this.vars[indice].setNome(s); //Se chegou no "=" é porque já encontrou o nome da variavel.
					correto = 0; //Programa chama comando da Classe ATRIBUIÇÃO.
				}
				else{//se não entrou em nenuhm IF, quer dizer que achou o nome da Variavel.
					s.concat(this.v[j]);
				}
			}	
		}
		indice++;
		return correto; //Se voltar 1 é porque deu tudo certo.
	}
  
  }
