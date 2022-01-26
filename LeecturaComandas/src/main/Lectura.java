package main;

import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Recibirá por argumentos el directorio comandas para posteriormente
 * sacar por pantalla las comandas contenidas en dicho directorio
 * @author mario
 */
public class Lectura
{
	public static void main(String[] args) throws Exception
	{
		String rutaComandas = args[0];
		File carpetaComandas = new File(rutaComandas);
		
		if(!carpetaComandas.exists())
			throw new Exception("El directorio introducido no existe");
	
		String comandas[] = carpetaComandas.list();
		
		// Creamos una expresion regular para que solo sean leídos los ficheros que la cumplan
		Pattern pat = Pattern.compile("^Comanda.*xml$");
		
		for(String nombreComanda : comandas)
		{
			Matcher mat = pat.matcher(nombreComanda);
			if(!mat.matches())
				continue;
			System.out.println(nombreComanda);
			File comanda = new File(rutaComandas + "\\" + nombreComanda);
			Scanner lector = new Scanner(comanda);
			while(lector.hasNext())
				System.out.println("\t" + lector.nextLine());
			
			lector.close();
		}
	}
}
