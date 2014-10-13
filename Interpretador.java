import java.util.Scanner;
import java.io.*;

class Interpretador 
{
    public static void main(String args[]) 
	{
        File f;
        Scanner s;
        String linhas[] = new String[2000]; // arquivo pode ter, no máximo, 2000 linhas.
        
		try 
		{
            // Referencia o arquivo. args[0] conterá os dados passados pela linha de comando.
            f = new File(args[0]);
            // Mandamos o Scanner ler a partir do arquivo.
            s = new Scanner(f);
            
            int i = 0;
            while(s.hasNext()) 
			{
                linhas[i] = s.nextLine();
                i++;
            }        
		}
	}
}