package principal;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Clase que será llamada por Principal para sacar por pantalla el resumen del pedido con formato csv,
 * la clase padre es la encargada de redireccionar la salida a un fichero .csv
 * @author mario
 */
public abstract class GuardarComanda
{
	private static File directorioComandas;
	private static final String FORMATO_XML = 
			  "<comanda fecha=\"%s\">\r\n"
			+ "	<primero>%s</primero>\r\n"
			+ "	<segundo>%s</segundo>\r\n"
			+ "	<postre>%s</postre>\r\n"
			+ "</comanda>\n";
	/*
	 *  Funcionalidad básica, nos guarda el elemento comanda correctamente 
	 *  Es necesario hacer modificaciones para que nos añada el elemento raíz del xml
	 *  
	 *  Creará una carpeta donde irá guardando las comandas
	 */
	public static void actualizarRegistro(String primero, String segundo, String postre)
	{
		try	{
			directorioComandas = new File(".//Comandas");
			if(!directorioComandas.exists())
				directorioComandas.mkdir();
			
				
			String fecha = fechaActual();
			/*
			 * Utilizamos los milisegundos para que nunca haya dos comandas con el mismo nombre y la fecha
			 * para que luego sea más fácil saber de que día son unas comandas sin tener que abrir el archivo
			 */
			String nombreFichero = ".//Comandas//Comanda " + fechaActual().substring(0, 10) + " "+ System.currentTimeMillis() + ".xml";
			File comandas = new File(nombreFichero);

			comandas.createNewFile();// Antes de crearlo comprueba si existe
			FileOutputStream escritor = new FileOutputStream(comandas);
			escritor.write( "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n".getBytes());
			escritor.write(String.format(FORMATO_XML, fecha, primero, segundo, postre).getBytes());
			
			escritor.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	private static String fechaActual() 
	{
		SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		return formatter.format(date);
	}
}
