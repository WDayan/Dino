import java.util.Scanner;
import java.io.*;

class Dino 
{
    public static void main(String args[]) throws Exception
	{
	// -------------------- INICIO DA LEITURA DO ARQUIVO.dino --------------------
		File dino;
		String prg[] = new String[500]; // arquivo pode ter, no máximo, 500 linhas.
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
	// -------------------- FIM DA LEITURA DO ARQUIVO.dino -------------------- o nome da String com o programa eh "prg"
	Interpretador x;
	x = new Interpretador();
	x.interpreta(prg);
	}
}   