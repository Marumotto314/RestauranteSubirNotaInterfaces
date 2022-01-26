package principal;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * Lo ideal sería almacenar los botones y los labels en arrays
 * También se puede hacer un enum, u otra clase, para los platos, y que cada plato tenga asignada 
 * la imagen correspondiente
 */
public class SeleccionPlato 
{
	/***** ATRIBUTOS *****/
	private static JDialog ventana4;
	private static JFrame padre;
	private static String platosPrimero[] = {"Sopa", "Ensalada", "Espaguetis"};
	private static String platosSegundo[] = {"Filete", "Paella", "Filete de pollo"};
	private static String platosPostre[] = {"Helado", "Natillas", "Tarta"};
	private static String platoActual;
	
	// Tamaño ventana
	static final int SIZE_X = 370;
	static final int SIZE_Y = 350;
	
	/*
	 * La estructura que va seguir esta ventana es la siguente:
	 * Contendra tres botones cuyo texto será modificado según la opcion que se haya
	 * selecionado en la Ventana1, además contendrá imagenes para aumentar la claridad
	 */
	// Botones
	private static JButton primeraOpcion, segundaOpcion, terceraOpcion;
	
	// Fotos
	private static JLabel primeraImagen, segundaImagen, terceraImagen;
	// Rutas de las fotos (posteriormente seran cambiada para funcionar con jar)
	private static String primeros[] = 
		{
				"recursos\\primeros\\sopa.png",
				"recursos\\primeros\\ensalada.png",
				"recursos\\primeros\\espaguetis.png"
		};
	private static String segundos[] = 
		{
				".\\recursos\\segundos\\filete.png",
				".\\recursos\\segundos\\paella.png",
				".\\recursos\\segundos\\filete pollo.png"
		};
	private static String postres[] = 
		{
				".\\recursos\\postres\\helado.png",
				".\\recursos\\postres\\natillas.png",
				".\\recursos\\postres\\tarta.png"
		};
	
	/***** CONSTRUCTORES *****/
	public SeleccionPlato(JFrame ventanaPadre)
	{
		// Ventana
		padre = ventanaPadre;
		ventana4 = new JDialog(padre, "Seleccionar Plato", true);
		ventana4.setBounds(300, 300, SIZE_X, SIZE_Y);
		ventana4.setResizable(false);
		ventana4.setLayout(new GridLayout(3, 2));
		
		// Botones
		primeraOpcion = new JButton("Primera Opcion");
		segundaOpcion = new JButton("Segunda Opcion");
		terceraOpcion = new JButton("Tercera Opcion");
		
		eventosEscuchaBotones();
		
		// Imagenes
		primeraImagen = new JLabel();
		segundaImagen = new JLabel();
		terceraImagen = new JLabel();

		primeraImagen.setIcon(new ImageIcon(primeros[0]));
		segundaImagen.setIcon(new ImageIcon(primeros[1]));
		terceraImagen.setIcon(new ImageIcon(primeros[2]));
		
		// Añadimos boton + imagen
		ventana4.add(primeraOpcion);
		ventana4.add(primeraImagen);
		
		ventana4.add(segundaOpcion);
		ventana4.add(segundaImagen);
		
		ventana4.add(terceraOpcion);		
		ventana4.add(terceraImagen);
		
		ventana4.setVisible(false);
	}
	
	/***** MÉTODOS *****/
	public static void recibirOpcion(String plato)
	{
		platoActual = plato;
		/*
		 * Las coodenadas del dialogo se desplazan según se desplaze el padre
		 */
		Dimension d = padre.getSize();
		int coordX = padre.getX() + (int)d.getWidth() / 2 - SIZE_X/2;
		int coordY = padre.getY() + (int)d.getHeight() / 2 - SIZE_Y/2;
		ventana4.setLocation(coordX, coordY);
		
		switch(plato)
		{
			case "primero":
				primeraOpcion.setText(platosPrimero[0]);
				segundaOpcion.setText(platosPrimero[1]);
				terceraOpcion.setText(platosPrimero[2]);
				
				primeraImagen.setIcon(new ImageIcon(primeros[0]));
				segundaImagen.setIcon(new ImageIcon(primeros[1]));
				terceraImagen.setIcon(new ImageIcon(primeros[2]));
				break;
			case "segundo":
				primeraOpcion.setText(platosSegundo[0]);
				segundaOpcion.setText(platosSegundo[1]);
				terceraOpcion.setText(platosSegundo[2]);
				
				primeraImagen.setIcon(new ImageIcon(segundos[0]));
				segundaImagen.setIcon(new ImageIcon(segundos[1]));
				terceraImagen.setIcon(new ImageIcon(segundos[2]));
				break;
			case "postre":
				primeraOpcion.setText(platosPostre[0]);
				segundaOpcion.setText(platosPostre[1]);
				terceraOpcion.setText(platosPostre[2]);
				
				primeraImagen.setIcon(new ImageIcon(postres[0]));
				segundaImagen.setIcon(new ImageIcon(postres[1]));
				terceraImagen.setIcon(new ImageIcon(postres[2]));
				break;
		}
		ventana4.setVisible(true);
	}
	private static void eventosEscuchaBotones()
	{
		primeraOpcion.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e)
	         {
	            switch(platoActual)
	            {
	            	case "primero":
	            		Ventana1.setPlatos(platoActual, platosPrimero[0]);
	            		break;
	            	case "segundo":
	            		Ventana1.setPlatos(platoActual, platosSegundo[0]);
	            		break;
	            	case "postre":
	            		Ventana1.setPlatos(platoActual, platosPostre[0]);
	            		break;
	            }
	            ventana4.setVisible(false);
	         }
		});
		
		segundaOpcion.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e)
	         {
	            switch(platoActual)
	            {
	            	case "primero":
	            		Ventana1.setPlatos(platoActual, platosPrimero[1]);
	            		break;
	            	case "segundo":
	            		Ventana1.setPlatos(platoActual, platosSegundo[1]);
	            		break;
	            	case "postre":
	            		Ventana1.setPlatos(platoActual, platosPostre[1]);
	            		break;
	            }
	            ventana4.setVisible(false);
	         }
		});
		
		terceraOpcion.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e)
	         {
	            switch(platoActual)
	            {
	            	case "primero":
	            		Ventana1.setPlatos(platoActual, platosPrimero[2]);
	            		break;
	            	case "segundo":
	            		Ventana1.setPlatos(platoActual, platosSegundo[2]);
	            		break;
	            	case "postre":
	            		Ventana1.setPlatos(platoActual, platosPostre[2]);
	            		break;
	            		
	            }
	            ventana4.setVisible(false);
	         }
		});
	}
}
