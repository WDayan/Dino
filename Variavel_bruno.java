class Variavel{
 private int valor;
 private char nome[] = new char[10];
 
 public void SetVariavel (int a) // a= valor
 {
    valor = a;
 }
 public int GetVariavel ()
 {
	return valor;
 }
 public void Imprime ()
 {
	System.out.println("valor"+valor);
 }
 
 }