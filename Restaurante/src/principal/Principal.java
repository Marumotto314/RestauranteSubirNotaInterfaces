package principal;

import java.io.IOException;

/**
 * Está clase creará la interfaz del restaurante utilizando las clases Ventana1, Ventana2, Ventana3
 * @author mario
 */
public class Principal
{
	// Creamos las ventanas que instanciaremos cuando sea necesario
	static Ventana1 v1;
	static Ventana2 v2;
	static Ventana3 v3;
	
	public static void main(String[] args)
	{
		// Creamos las ventanas v1 y v2
		v1 = new Ventana1();
		v2 = new Ventana2(Ventana1.getVentana());
		v3 = new Ventana3();
	}
	/*
	 * Utilizamos este método para que la ventana3 se generé cuando se haya confirmado el pedido, porque si la
	 * creamos antes cogerá los valores que haya al instanciar las opciones que no es ninguno
	 */
	public static void crearVentana3() throws IOException
	{
		Ventana3.actualizarPlatos();
		
		GuardarComanda.actualizarRegistro(Ventana1.getPrimeroElegido(), Ventana1.getSegundoElegido(), Ventana1.getPostreElegido());
	}
}
