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
	private static JButton botonPrimero = new JButton("Seleccionar");
    // Segundo 
    private static JLabel textoSegundo = new JLabel("Segundo: ");
    private static JButton botonSegundo = new JButton("Seleccionar");
    // Postre
    private static JLabel textoPostre = new JLabel("Postre: ");
    private static JButton botonPostre = new JButton("Seleccionar");
    
    // Enviar a cocina
    private static JButton enviarCocina;
    
    // Variables donde se guardaran las opciones escogidas
    private static String primeroElegido;
    private static String segundoElegido;
    private static String postreElegido;
    
    // Tamaño ventana
    static final int SIZE_X = 500;
    static final int SIZE_Y = 400;
    
    /***** Constructor *****/
	public Ventana1()
	{
		/**** Añadimos los componenetes a sus respectivos paneles y después a la ventana ****/
		// Ventana
		ventana1 = new JFrame("Menú");
		ventana1.setBounds(300, 300, SIZE_X, SIZE_Y);
		ventana1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana1.setLayout(new BoxLayout(ventana1.getContentPane(), BoxLayout.Y_AXIS));
		ventana1.add(Box.createVerticalGlue());
		
		// Primero
		primero = new JPanel();
		botonPrimero.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e)
	         {
	            SeleccionPlato.recibirOpcion("primero");
	         }
		});
		primero.add(textoPrimero);
		primero.add(botonPrimero);
		
		// Segundo 
		segundo = new JPanel();
		botonSegundo.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e)
	         {
	            SeleccionPlato.recibirOpcion("segundo");
	         }
		});
		segundo.add(textoSegundo);
		segundo.add(botonSegundo);
		
		// Postre
		postre = new JPanel();
		botonPostre.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e)
	         {
	            SeleccionPlato.recibirOpcion("postre");
	         }
		});
		postre.add(textoPostre);
		postre.add(botonPostre);
		
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
	/**
	 * Recibe los platos elegidos
	 * @param El plato que es [primero, segundo, postre]
	 * @param platoEscogido
	 */
	public static void setPlatos(String plato, String platoEscogido)
	{
		switch(plato)
		{
			case "primero":
				primeroElegido = platoEscogido;
				botonPrimero.setText(platoEscogido);
				break;
			case "segundo":
				botonSegundo.setText(platoEscogido);
				segundoElegido = platoEscogido;
				break;
			case "postre":
				botonPostre.setText(platoEscogido);
				postreElegido = platoEscogido;
				break;
		}
	}
	private void enviar()
	{
		// Antes de cambiar de ventanas guardaremos las opciones escogidas
		primeroElegido = (botonPrimero.getText().equals("Seleccionar"))? "" : botonPrimero.getText();
		segundoElegido = (botonSegundo.getText().equals("Seleccionar"))? "" : botonSegundo.getText();
		postreElegido = (botonPostre.getText().equals("Seleccionar"))? "" : botonPostre.getText();
		
		// Cambiamos de ventana 
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
		botonPrimero.setText("Seleccionar");
		botonSegundo.setText("Seleccionar");
		botonPostre.setText("Seleccionar");
		
		primeroElegido = " ";
		segundoElegido = " ";
		postreElegido = " ";
	}
	
	// Getters
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
