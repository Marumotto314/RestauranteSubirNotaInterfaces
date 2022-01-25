package principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Está clase implementará la primera ventana de nuestro restaurante que contendrá las opciones de los 
 * platos
 * @author mario
 */
public class Ventana1
{
	/***** Atributos *****/
	// JFrame que contendra todo
	private static JFrame ventana1; 
	
	// Creamos paneles que contendran un texto y un ComboBox respectivo a cada plato
	private static JPanel primero;
	private static JPanel segundo;
	private static JPanel postre;
	private static JPanel terminar;

	// Primero
	private static JLabel textoPrimero = new JLabel("Primero: ");
	private static String platosPrimero[] = {" ", "Sopa", "Ensalada", "Potaje"};
    private static JComboBox comboPrimero = new JComboBox(platosPrimero);
    // Segundo 
    private static JLabel textoSegundo = new JLabel("Segundo: ");
    private static String platosSegundo[] = {" ", "Filete", "Paella", "Filete de pollo"};
    private static JComboBox comboSegundo = new JComboBox(platosSegundo);
    // Postre
    private static JLabel textoPostre = new JLabel("Postre: ");
    private static String platosPostre[] = {" ", "Helado", "Natillas", "Tarta"};
    private static JComboBox comboPostre = new JComboBox(platosPostre);
    
    // Enviar a cocina
    private static JButton enviarCocina;
    
    // Variables donde se guardaran las opciones escogidas
    private static String primeroElegido;
    private static String segundoElegido;
    private static String postreElegido;
    
    /***** Constructor *****/
	public Ventana1()
	{
		/**** Añadimos los componenetes a sus respectivos paneles y después a la ventana ****/
		// Ventana
		ventana1 = new JFrame("Menú");
		ventana1.setBounds(300, 300, 400, 300);
		ventana1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana1.setLayout(new BoxLayout(ventana1.getContentPane(), BoxLayout.Y_AXIS));
		ventana1.add(Box.createVerticalGlue());
		
		// Primero
		primero = new JPanel();
		primero.add(textoPrimero);
		primero.add(comboPrimero);
		
		// Segundo 
		segundo = new JPanel();
		segundo.add(textoSegundo);
		segundo.add(comboSegundo);
		
		// Postre
		postre = new JPanel();
		postre.add(textoPostre);
		postre.add(comboPostre);
		
		// Enviar a cocina
		terminar = new JPanel();
		enviarCocina = new JButton("Enviar a cocina");
		enviarCocina.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e)
	         {
	            enviar();
	         }
		});
		terminar.add(enviarCocina);
		
		// Añadimos los paneles a la ventana 
		ventana1.add(primero);
		ventana1.add(segundo);
		ventana1.add(postre);
		ventana1.add(terminar);
		ventana1.setVisible(true);
	}
	
    /***** Métodos *****/
	private void enviar()
	{
		// Antes de cambiar de ventanas guardaremos las opciones escogidas
		primeroElegido = String.valueOf(comboPrimero.getSelectedItem());
		segundoElegido = String.valueOf(comboSegundo.getSelectedItem());
		postreElegido = String.valueOf(comboPostre.getSelectedItem());
		
		// Cambiamos de ventana 
//		ventana1.setVisible(false);
		Ventana2.hacerVisible();
	}
	public static void hacerVisible()
	{
		ventana1.setVisible(true);
	}
	/**
	 * Resetea los valores de los platos
	 */
	public static void reset()
	{
		comboPrimero.setSelectedIndex(0);
		comboSegundo.setSelectedIndex(0);
		comboPostre.setSelectedIndex(0);
		
		primeroElegido = " ";
		segundoElegido = " ";
		postreElegido = " ";
	}
	
	// Getters
	/**
	 * Configurará el JDialog recibido por parámetros para darle los mismos valores que posee el JFrame padre
	 * @param obj
	 */
	public static void obtenerConfiguracion(JDialog obj)
	{
		obj.setResizable(false);
		obj.setBounds(ventana1.getX(), ventana1.getY(), 400, 300);
		obj.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	public static JFrame getVentana()
	{
		return ventana1;
	}
	public static String getPrimeroElegido()
	{
		return primeroElegido;
	}
	public static String getSegundoElegido()
	{
		return segundoElegido;
	}
	public static String getPostreElegido()
	{
		return postreElegido;
	}
	
}
