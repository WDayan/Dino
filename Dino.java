/*
	Interpretador de codigos v1.0
	Use esse programa em Java para interpretar codigos .dino. 
	Está incluido na pasta raiz deste programa um manual de operacao (manual operação linguagem dino).
	Para interpretar um codigo use: java Dino arquivo.dino
	Desenvolvido por: 
		Bruno Dall Orsoletta – email br-bruno@hotmail.com
		Dayan Weber – email weber.dayan@gmail.com
*/
import java.util.Scanner;
import java.io.*;

class Dino 
{
    public static void main(String args[]) throws Exception
	{
	// -------------------- Inicio da leitura do programa .dino --------------------
		File dino;
		String prg[] = new String[500]; // arquivo pode ter, no maximo, 500 linhas e 500 variaveis.
		Scanner ler;
		
		try 
		{ 
			dino = new File(args[0]);
			ler = new Scanner(dino);
            int cursor = 0;
            while(ler.hasNext()) 
			{
				prg[cursor] = ler.nextLine();
				cursor ++;
            }
		} 
		catch (IOException e) 
		{	 
            System.out.println("Nao consegui ler o arquivo: " + (args.length > 0 ? args[0] : "(desconhecido)"));
            System.out.println("Uso -> java Dino arquivo.dino");
		}
	// -------------------- Fim da leitura do programa .dino -------------------- 
	
	//O nome da String com o programa eh "prg"
	
	// ----------------------- caso de teste, imprimi string .dino
	// Interpretador x;
	// x = new Interpretador();
	// x.interpreta(prg);
	// -----------------------------------------------------------

	//--------------------Comecando a executar o programa---------------------- Nome da String s.
		System.out.println(" -------------------------- \n Interpretador .dino - v1.0 \n -------------------------- ");
//		System.out.println(" Interpretador .dino - v1.0 "); // imprime informacoess do interpretador

	
	// inicio da declaracao das variaveis	
	
		String kScanner = new String();
		Variavel[] vars = new Variavel[500];
		int salva_do[] = new int[10];
		Operacoes op = new Operacoes();
		Verificacoes v = new Verificacoes();
		Saida sair = new Saida();
		String s = new String();
		char c;
		int ultimo, indice = 0,comeco,y, i, linha, parou, countl = 0;;
		double tmp;
	// fim da declaracao das variaveis
	
		for(y = 0; y < 30; y++) //Para criar Variaveis mais rapidamente.
			vars[y] = new Variavel();
		for(linha = 0; prg[linha] != null; linha++){
			s = prg[linha];
			parou = 2;
			for(ultimo = 0; ultimo < s.length() && parou > 1; ultimo++){
				c = s.charAt(ultimo);
				//Testa no caso de NOVA VARIAVEL
				if(Variavel.ehDouble(s, ultimo)){//Vai descobrir se o que encontrou realmente eh uma criação de variavel DOUBLE.
					comeco = ultimo + 7;
					while(s.charAt(comeco - 1) != ';'){
						if(y < (indice + 10)){
							for(y = y; y < (indice + 20); y++) //Método utilizado para criar mais variaveis ao longo do caminho.
								vars[y] = new Variavel();				
						}
						ultimo = Variavel.achaNovaVariavel(s, comeco);//Pega o inicio da variavel, e vai até encontrar o fim dela
						vars[indice].setNome(Variavel.novaVariavel(s, comeco, ultimo));//Pega o inicio da variavel e o fim dela, apenas faz a atribuiição.
						comeco = ultimo + 2;
						indice++;
					}
				}
				//Testa no caso de ATRIBUICAO
				else if(c == '='){
					comeco = ultimo;
					int entrou = 0, cont = 0, temNegativo = 0, num = 0;
					for(c = s.charAt(comeco), comeco += 1; c != ';'; comeco++){
						if(Character.isDigit(c)){
							comeco = Verificacoes.giraAteNaoNumero(s, comeco-1);
							cont++;
							num = 1;
						}
						if(Character.isLetter(c)){
							comeco = Verificacoes.giraAteNaoCaracter(s, comeco-1);
							cont++;
							num = 0;
						}
						if(c == '-')
							temNegativo++;
						//Teste no caso Scanner
						if (v.lerScanner(s, comeco)){
							Scanner ler2;
							ler2 = new Scanner(System.in);
							kScanner = ler2.nextLine();
							vars[Variavel.achaVariavel(vars, Variavel.qualVariavelParaAtribuir(s, v.achaIgual(s, ultimo)))].atribuicao(op.fazDouble(kScanner));
							entrou = 1;
							break;
						}
						c = s.charAt(comeco);				
					}
					if(cont > 1){
							vars[Variavel.achaVariavel(vars, Variavel.qualVariavelParaAtribuir(s, ultimo-1))].atribuicao(op.calcula(s, ultimo, vars));//Aqui no caso de ser a + b -3 / 14 .......
							entrou = 1;
					}
					else if(temNegativo == 1 && num > 0){
						vars[Variavel.achaVariavel(vars, (Variavel.qualVariavelParaAtribuir(s, ultimo-1)))].atribuicao(Verificacoes.achaNumeroNegativo(s, ultimo));
						entrou = 1;
					}
					if(entrou < 1){ //Entrou serve para saber se existe uma conta, se nao existir eh só atribuir o valor.
						comeco = ultimo;
						for(c = s.charAt(comeco), comeco += 1; c != ';'; comeco++){
							if(Character.isLetter(c)){
								vars[Variavel.achaVariavel(vars, Variavel.qualVariavelParaAtribuir(s, ultimo-1))].atribuicao(vars[Variavel.achaVariavel(vars, Verificacoes.achaTodoONome(s, comeco-1))].getValor());
								break;
							}
							else if(Character.isDigit(c)){
								vars[Variavel.achaVariavel(vars, Variavel.qualVariavelParaAtribuir(s, ultimo-1))].atribuicao(Verificacoes.achaTodoONumero(s, comeco-1));
								break;
							}
							c = s.charAt(comeco);
						}
						for(c = s.charAt(comeco), comeco += 1; c != ';'; comeco++){
							c = s.charAt(comeco);
						}
					}
					ultimo = comeco - 1;
				}
				//Testa no caso de IF
				else if(v.ehIf(s, ultimo)){ //Se for um IF. A função descobre se realmente eh IF
					ultimo = Saida.giraAtePrimeiroParenteses(s, ultimo); //Vai girar até encontrar o 1° (, e devolver a próxima posicao, ou seja, depois do (
					if(v.seIf(vars, s, ultimo, 1)) //Vai descobrir se o IF do programa eh TRUE or FALSE
						ultimo = v.giraAteEscopo(s, ultimo, prg, linha); //Se for TRUE, vai girar até o {
					else{
						ultimo = v.giraAteEscopo(s, ultimo, prg, linha); //Se for FALSE, vai girar até sair desse IF, e dos IF dentro dele.	
						linha = v.getLinha()-1;
						parou = 0;
					}
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
				//Teste no caso DO - faz o controle da quantidade de lacos.
				else if (v.ehDo(s, ultimo)) {
					salva_do[0+countl] = linha;
					salva_do[1+countl] = ultimo+2;
					countl += 2;
				}
				//Teste no caso While - faz o controle do laco e determina o fim.
				else if (v.ehWhile(s, ultimo)) {
					int k1;
					k1 = Saida.giraAtePrimeiroParenteses(s, ultimo);
					if (v.seIf(vars, s, k1, 5)) {
						linha = salva_do[countl-2];
						ultimo = salva_do[countl-1];
						char j = s.charAt(ultimo);
						//System.out.println("char = "+j );
					}
					else
						countl -= 2;
				}
			}
		}
	}
}	