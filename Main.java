class Main{ //Teste para a classe Variavel
public static void main ( String args []){	
	String s = new String("main(){  double a,b;double     abacaxi;  if(a > b){ if(b == abacaxi){ if(abacaxi >= a){  imprima(testando  a = +a);} }  } double j;   imprimaNumero(22);  imprima(j);  ");
	Variavel[] vars = new Variavel[500];
	Operacoes op = new Operacoes();
	Verificacoes v = new Verificacoes();
	Saida sair = new Saida();
	char c;
	int ultimo, indice = 0,comeco,x, i;
	double tmp;
	
	for(x = 0; x < 30; x++) //Para criar Variaveis mais rapidamente.
		vars[x] = new Variavel();
		
	for(ultimo = 0;ultimo < s.length(); ultimo++){
		c = s.charAt(ultimo);
		//Testa no caso de NOVA VARIAVEL
		if(Variavel.ehDouble(s, ultimo)){//Vai descobrir se o que encontrou realmente eh uma criação de variavel DOUBLE.
			comeco = ultimo + 7;
			while(s.charAt(comeco - 1) != ';'){
				if(x < (indice + 10)){
					for(x = x; x < (indice + 20); x++) //Método utilizado para criar mais variaveis ao longo do caminho.
						vars[x] = new Variavel();				
				}
				ultimo = Variavel.achaNovaVariavel(s, comeco);//Pega o inicio da variavel, e vai até encontrar o fim dela
				vars[indice].setNome(Variavel.novaVariavel(s, comeco, ultimo));//Pega o inicio da variavel e o fim dela, apenas faz a atribuiição.
				comeco = ultimo + 2;
				indice++;
			}
			vars[0].setValor(4);
			vars[1].setValor(2);
			vars[2].setValor(2);
		}
		//Testa no caso de ATRIBUICAO
		//else if(c == '='){
		
		
		//}
		//Testa no caso de IF
		else if(v.ehIf(s, ultimo)){ //Se for um IF. A função descobre se realmente eh IF
			ultimo = Saida.giraAtePrimeiroParenteses(s, ultimo); //Vai girar até encontrar o 1° (, e devolver a próxima posicao, ou seja, depois do (
			if(v.seIf(vars, s, ultimo)) //Vai descobrir se o IF do programa eh TRUE or FALSE
				ultimo = v.giraAteEscopo(s, ultimo); //Se for TRUE, vai girar até o {
			else
				ultimo = v.giraAteEscopo(s, ultimo); //Se for FALSE, vai girar até sair desse IF, e dos IF dentro dele.	
		}
		//Testa no caso de IMPRIMA
		else if(sair.ehImprima(s, ultimo)){//Se for um IMPRIMA
			if(sair.ehImprimaNumero(s, ultimo)){ //Se for ImprimaNumero.
				ultimo = Saida.giraAtePrimeiroParenteses(s, ultimo);//Ultimo recebe a próxima posicao depois da 1° ocorrência de (
				tmp = Verificacoes.achaTodoONumero(s, Verificacoes.achaPrimeiroNumero(s, ultimo)); //Achará a 1° posicao do numero, depois achará o n°. Depois imprime ele.
				sair.imprimaNumero(tmp);//Imprime o numero encontrado.
				ultimo = Saida.giraAteUltimoParenteses(s, ultimo) - 1; //Gira até achar ). devolve a próxima posicao. (-1 porque no FOR será atualizado.)
			}
			else{//Se não for ImprimaNumero será só Imprima.
				ultimo = Saida.giraAtePrimeiroParenteses(s, ultimo);
				sair.imprima(vars, s, ultimo);
				ultimo = Saida.giraAteUltimoParenteses(s, ultimo);
			}
			
		
		}
	
	}//Colchetes do FOR.
	
	
	/*String calc = new String("    if(a < b){  a + b }; ");
	for(i = 0; calc.charAt(i) != '('; i++){
	}
	
	
	if(v.seIf(vars, calc, i)){
		i = v.giraAteEscopo(calc, i);
		double result = op.calcula(calc, i, vars);
		//System.out.println("Resultado = "+result);
		Saida sair = new Saida();
		String r = new String("Resultado  = ");
		sair.imprima(vars,r, 0);
		
		sair.imprimaNumero(result);
		
	}*/
	

	
	
	
	
	}
}







