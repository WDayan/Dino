class MainVariavel{ //Teste para a classe Variavel
public static void main ( String args []){	
	String s = new String("main(){  int a,b;intabacaxi;        int cobra;double h,homem,teste;");
	String aux = new String();
	Variavel[] vars = new Variavel[500];
	char c;
	int i,indice = 0,j,x;
	boolean empty = false;
	
	for(x = 0; x < 150; x++) //Para criar Variaveis mais rapidamente.
		vars[x] = new Variavel();
	for(i = 0;i < s.length(); i++){
		c = s.charAt(i);
		if(c == 'i' && (s.charAt(i-1) == ' ' || s.charAt(i-1) == ';')){//Testa se antes do I tem ESPACO ou ;
			aux = "";
			if(Variavel.ehInt(s, i)){ //Vai descobrir se o que encontrou realmente eh uma criação de variavel.
				j = i + 4;
				if(x > (indice + 20)){
					for(x = x; x < (indice + 80); x++)
						vars[x] = new Variavel();				
				}
				while(c != ';'){//Se sim, começa a fazer atribuições.
					c = s.charAt(j);
					if(c == ','){
						vars[indice].setNome(aux);
						indice++;
						empty = true;
					}
					else if(c == '='){
						vars[indice].setNome(aux);
						indice++;
						empty = true;
						//Chamar função atribuição.
						j = Variavel.giraAteVirgula(s, i);
					}
					else if(c == ' ')
						j = j;
					else if(c == ';'){
						vars[indice].setNome(aux);
						indice++;
						j--;
						empty = false;
					}
					else{
						if(empty){
							empty = false;
							aux = "";
						}
						aux += c;
					}
					j++;
				}
				i = j;
			}
		}
		else if(c == 'd' && (s.charAt(i-1) == ' ' || s.charAt(i-1) == ';')){//Testa se antes do D tem ESPACO ou ;
			aux = "";
			if(Variavel.ehDouble(s, i)){//Vai descobrir se o que encontrou realmente eh uma criação de variavel DOUBLE.
				j = i + 7;
				if(x < (indice + 20)){
					for(x = x; x < (indice + 80); x++)
						vars[x] = new Variavel();				
				}
				while(c != ';'){
					i = j;
					c = s.charAt(j);
					if(c == ','){
						vars[indice].setNome(aux);
						indice++;
						empty = true;
					}
					else if(c == '='){
						vars[indice].setNome(aux);
						indice++;
						empty = true;
						//Chama a Função atribuição.
						j = Variavel.giraAteVirgula(s, i);
					}
					else if(c == ' ')
						j = j;
					else if(c == ';'){
						vars[indice].setNome(aux);
						indice++;
						empty = true;
						j--;
					}
					else{
						if(empty){
							empty = false;
							aux = "";
						}
						aux += c;				
					}
					j++;
				}			
			}
		}
		
		
		
	}//Colchetes do FOR.
	int k;
	for(k = 0;k < indice; k++)
		System.out.println("Variavel "+k+" = "+vars[k].getNome());
}



}







