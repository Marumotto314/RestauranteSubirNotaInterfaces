package principal;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Está clase implementará la última ventana de nuestro restaurante, la que se mostrará una vez confirmado el resumen del 
 * pedido
 * @author mario
 */
public class Ventana3
{
	/***** Atributos *****/
	private static JDialog ventana3;
	
	// JLabels con los platos escogidos 
	private static JLabel primero;
	private static JLabel segundo;
	private static JLabel postre;
	
	// JPanels que contendrán los JLabels
	private static JPanel panelPrimero = new JPanel();
	private static JPanel panelSegundo = new JPanel();
	private static JPanel panelPostre = new JPanel();
	
    /***** Constructor *****/
	public Ventana3()
	{
		// Ventana 3
		ventana3 = new JDialog(Ventana1.getVentana(), "Resúmen", true);
		Ventana1.obtenerConfiguracion(ventana3);
		Font fuente = new Font("Arial", Font.PLAIN, 20);
		ventana3.setLayout(new BoxLayout(ventana3.getContentPane(), BoxLayout.Y_AXIS));
		ventana3.add(Box.createVerticalGlue());
		// Al cerrarse la ventana2 al pulsar x vuelva a la ventana1
		ventana3.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				Ventana1.reset();
				reset();
				Ventana1.hacerVisible();
				ventana3.setVisible(false);
			}
			public void windowClosed(WindowEvent e) {
				Ventana1.reset();
				reset();
				Ventana1.hacerVisible();
				ventana3.setVisible(false);
			}
		});
		
		
		// JLabels
		primero = new JLabel("- Primero: ");
		segundo = new JLabel("- Segundo: ");
		postre = new JLabel("- Postre: ");
		
		primero.setFont(fuente);
		segundo.setFont(fuente);
		postre.setFont(fuente);
		
		panelPrimero.add(primero);
		panelSegundo.add(segundo);
		panelPostre.add(postre);
		
		ventana3.add(panelPrimero);
		ventana3.add(panelSegundo);
		ventana3.add(panelPostre);
	
	}
	
    /***** Métodos *****/
	public static void actualizarPlatos()
	{
		primero.setText("- Primero: " + Ventana1.getPrimeroElegido());
		segundo.setText("- Segundo: " + Ventana1.getSegundoElegido());
		postre.setText("- Postre: " + Ventana1.getPostreElegido());
	}
	// Resetea los valores para la siguiente comanda
	private static void reset()
	{
		primero.setText(" ");;
		segundo.setText(" ");;
		postre.setText(" ");;
	}
	public static void hacerVisible()
	{
		ventana3.setLocation(Ventana1.getVentana().getX(), Ventana1.getVentana().getY());
		ventana3.setVisible(true);
	}
}