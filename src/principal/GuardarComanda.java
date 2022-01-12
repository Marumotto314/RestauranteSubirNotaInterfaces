package principal;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Clase que ser� llamada por Principal para sacar por pantalla el resumen del pedido con formato csv,
 * la clase padre es la encargada de redireccionar la salida a un fichero .csv
 * @author mario
 */
public abstract class GuardarComanda
{
	private static File comandas;
	private static final String FORMATO_XML = 
			  "<comanda fecha=\"%s\">\r\n"
			+ "	<primero>%s</primero>\r\n"
			+ "	<segundo>%s</segundo>\r\n"
			+ "	<postre>%s</postre>\r\n"
			+ "</comanda>\n";
	/*
	 *  Funcionalidad b�sica, nos guarda el elemento comanda correctamente 
	 *  Es necesario hacer modificaciones para que nos a�ada el elemento ra�z del xml
	 *  
	 *  Para solucionar el tema del elemento ra�z vamos a hacer que se cierre cuando la aplicaci�n se cierra
	 *  por el usuario y cuando se vuelva a inciar machacaremos el fichero.
	 *  Podemos hac
	 */
	public static void actualizarRegistro(String primero, String segundo, String postre)
	{
		try	{
			String fecha = fechaActual();
			comandas = new File(".//RegistroComandas.xml");

			boolean creado = comandas.createNewFile();// Antes de crearlo comprueba si existe
			FileOutputStream escritor = new FileOutputStream(comandas, true);
			if(creado)
				escritor.write( "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n</registro>".getBytes());
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
