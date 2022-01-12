package principal;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 * Está clase implementará la segunda ventana de nuestro restaurante, esta ventana es de 
 * verificación del pedido
 * @author mario
 */
public class Ventana2 
{
	/***** Atributos *****/
	private static JDialog ventana2;
	private static JFrame padre;
	
	// Solo tendremos dos botones, el de confirmar y el de cancelar
	private JButton confirmar;
	private JButton cancelar;
	
	
    /***** Constructor *****/ 
	public Ventana2(JFrame ventanaPadre)
	{
		padre = ventanaPadre;
		/**** Añadimos los componenetes a sus respectivos paneles y después a la ventana ****/
		// Ventana 2, tiene la misma configuración que el padre
		ventana2 = new JDialog(ventanaPadre, "Confirmar comanda", true);
		Ventana1.obtenerConfiguracion(ventana2);
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER);// Creamos un FlowLayout para facilitar colocar los elementos
		layout.setVgap(ventana2.getY()/3);
		layout.setHgap(50);
		ventana2.setLayout(layout);
		// Al cerrarse la ventana2 al pulsar x vuelva a la ventana1
		ventana2.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				Ventana1.reset();
//				Ventana1.hacerVisible();
				ventana2.setVisible(false);
			}
			public void windowClosed(WindowEvent e) {
				Ventana1.reset();
//				Ventana1.hacerVisible();
				ventana2.setVisible(false);
			}
		});
		
		// Confirmar
		confirmar = new JButton("Confirmar");
		confirmar.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e)
	        {
				confirmado();
	        }
		});
		
		// Cancelar
		cancelar = new JButton("Cancelar");
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				cancelado();
			}
		});
		
		// Añadimos los botones a la ventana
		ventana2.add(confirmar);
		ventana2.add(cancelar);
	}
	
    /***** Métodos *****/
	public static void confirmado()
	{
		ventana2.setVisible(false);
		try {
			Principal.crearVentana3();
		}catch (Exception e) {
		}
		Ventana3.hacerVisible();
	}
	public static void cancelado()
	{
		ventana2.setVisible(false);
		Ventana1.reset();
//		Ventana1.hacerVisible();
	}
	public static void hacerVisible()
	{
		ventana2.setLocation(Ventana1.getVentana().getX(), Ventana1.getVentana().getY());
		ventana2.setVisible(true);
	}
}
