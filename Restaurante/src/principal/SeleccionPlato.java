package principal;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class SeleccionPlato 
{
	/***** ATRIBUTOS *****/
	private static JDialog ventana4;
	private static String platosPrimero[] = {"Sopa", "Ensalada", "Potaje"};
	private static String platosSegundo[] = {"Filete", "Paella", "Filete de pollo"};
	private static String platosPostre[] = {"Helado", "Natillas", "Tarta"};
	
	/*
	 * La estructura que va seguir esta ventana es la siguente:
	 * Contendra tres botones cuyo texto será modificado según la opcion que se haya
	 * selecionado en la Ventana1, además contendrá imagenes para aumentar la claridad
	 */
	// Botones
	private static JButton primeraOpcion = new JButton();
	private static JButton segundaOpcion = new JButton();
	private static JButton terceraOpcion = new JButton();
	
//	private static JLabel primeraImagen, segundaImagen, terceraImagen;
	
	/***** CONSTRUCTORES *****/
	public SeleccionPlato(JFrame padre)
	{
		// Ventana
		ventana4 = new JDialog(padre, "Seleccionar Plato", true);
		ventana4.setBounds(300, 300, 400, 300);
		ventana4.add(Box.createVerticalGlue());
		
		// Botones
		ventana4.add(primeraOpcion);
		ventana4.add(segundaOpcion);
		ventana4.add(terceraOpcion);
		
		ventana4.setVisible(false);
	}
	
	/***** MÉTODOS *****/
	public static void recibirOpcion(String plato)
	{
		switch(plato)
		{
			case "primero":
				primeraOpcion.setText(platosPrimero[0]);
				segundaOpcion.setText(platosPrimero[1]);
				terceraOpcion.setText(platosPrimero[2]);
				break;
			case "segundo":
				primeraOpcion.setText(platosSegundo[0]);
				segundaOpcion.setText(platosSegundo[1]);
				terceraOpcion.setText(platosSegundo[2]);
				break;
			case "postre":
				primeraOpcion.setText(platosPostre[0]);
				segundaOpcion.setText(platosPostre[1]);
				terceraOpcion.setText(platosPostre[2]);
				break;
		}
		ventana4.setVisible(true);
	}
}
