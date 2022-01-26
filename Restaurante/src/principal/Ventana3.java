package principal;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
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
	private static JButton volver;
	
	// JPanels que contendrán los JLabels
	private static JPanel panelPrimero = new JPanel();
	private static JPanel panelSegundo = new JPanel();
	private static JPanel panelPostre = new JPanel();
	private static JPanel panelVolver = new JPanel();
	
	// Tamaño ventana
	static final int SIZE_X = 400;
	static final int SIZE_Y = 300;
	
    /***** Constructor *****/
	public Ventana3()
	{
		// Ventana 3
		ventana3 = new JDialog(Ventana1.getVentana(), "Resúmen", true);
		ventana3.setBounds(Ventana1.getVentana().getX(), Ventana1.getVentana().getY(), SIZE_X, SIZE_Y);
		ventana3.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		Font fuente = new Font("Arial", Font.PLAIN, 20);
		ventana3.setLayout(new BoxLayout(ventana3.getContentPane(), BoxLayout.Y_AXIS));
		ventana3.add(Box.createVerticalGlue());
		// Al cerrarse la ventana2 al pulsar x vuelva a la ventana1
		ventana3.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				terminarResumen();
			}
			public void windowClosed(WindowEvent e) {
				terminarResumen();
			}
		});
		
		
		// JLabels
		primero = new JLabel("·Primero: ");
		segundo = new JLabel("·Segundo: ");
		postre = new JLabel("·Postre: ");
		
		volver = new JButton("Volver");
		volver.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e)
	         {
				terminarResumen();
	         }
		});
		
		primero.setFont(fuente);
		segundo.setFont(fuente);
		postre.setFont(fuente);
		volver.setFont(fuente);
		
		panelPrimero.add(primero);
		panelSegundo.add(segundo);
		panelPostre.add(postre);
		panelVolver.add(volver);
		
		ventana3.add(panelPrimero);
		ventana3.add(panelSegundo);
		ventana3.add(panelPostre);
		ventana3.add(panelVolver);
	
	}
	
    /***** Métodos *****/
	public static void actualizarPlatos()
	{
		primero.setText("·Primero: " + Ventana1.getPrimeroElegido());
		segundo.setText("·Segundo: " + Ventana1.getSegundoElegido());
		postre.setText("·Postre: " + Ventana1.getPostreElegido());
	}
	private static void terminarResumen()
	{
		Ventana1.reset();
		reset();
		ventana3.setVisible(false);
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
		/*
		 * Las coodenadas del dialogo se desplazan según se desplaze el padre
		 */
		JFrame padre = Ventana1.getVentana();
		Dimension d = padre.getSize();
		int coordX = padre.getX() + (int)d.getWidth() / 2 - SIZE_X/2;
		int coordY = padre.getY() + (int)d.getHeight() / 2 - SIZE_Y/2;
		ventana3.setLocation(coordX, coordY);
		ventana3.setVisible(true);
	}
}