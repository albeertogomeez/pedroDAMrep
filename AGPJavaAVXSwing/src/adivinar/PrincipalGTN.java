package adivinar;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PrincipalGTN extends JFrame implements ActionListener {

	private JFrame frame;
	
	// Pestaña previa al inicio del juego.
	JLabel start = new JLabel();
	JButton inicio = new JButton();
	
	// Pestaña del juego.
	JLabel label = new JLabel();
	JTextField texto = new JTextField();
	JButton enter = new JButton();
	JButton salir = new JButton();
	JButton reinicio = new JButton();

	int intentos = 10;
	
	// Generador del número aleatorio
	Random r = new Random();
	int aiNumber = r.nextInt(100)+1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalGTN window = new PrincipalGTN();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PrincipalGTN() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Adivina el número");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 375, 100);
		frame.add(panel);
		panel.setLayout(null);
		
		// Fuente para ajustar el texto
		Font font = new Font(start.getFont().getName(), Font.PLAIN, 20);
		
		// Pestaña previa al juego
		start = new JLabel();
		start.setBounds(90, 0, 300, 200);
		start.setText("¿Quieres jugar a un juego?");
		start.setFont(font);
		panel.add(start);
		
		inicio = new JButton();
		inicio.setBounds(150, 150, 120, 40);
		inicio.setText("Iniciar juego");
		panel.add(inicio);
		inicio.addActionListener(this);
		
		// Juego
		label = new JLabel();
		label.setText("Adivina el número: inserta un número del 1 al 100.");
		label.setBounds(50, 0, 500, 100);
		panel.add(label);
		label.setVisible(false);
		
		texto = new JTextField();
		texto.setBounds(50, 100, 200, 25);
		panel.add(texto);
		texto.setVisible(false);
		
		enter = new JButton("Enter");
		enter.setBounds(50, 150, 100, 20);
		panel.add(enter);
		enter.addActionListener(this);
		enter.setVisible(false);
		
		salir = new JButton("Salir");
		salir.setBounds(150, 150, 100, 20);
		panel.add(salir);
		salir.addActionListener(this);
		salir.setVisible(false);
		
		reinicio = new JButton("Reiniciar");
		reinicio.setBounds(50, 150, 100, 20);
		panel.add(reinicio);
		reinicio.setVisible(false);
		reinicio.addActionListener(this);
		reinicio.setVisible(false);
	}
	
	// Método para comprobar el número una vez introducido.
	public void comprobador() {
		try {
			int valor = Integer.parseInt(texto.getText()); // Convierte el texto a Int para poder ser comparado
				if (valor == aiNumber) {
					// Si el valor es igual que el número introducido, has ganado.
					label.setText("¡Enhorabuena! Has acertado el numero");
				    enter.setVisible(false);
				    reinicio.setVisible(true);
				} else if (valor > aiNumber) {
					// Si el valor es mayor que el número introducido, baja un intento y da una pista del número
					intentos--;
					label.setText("Has fallado, el numero correcto es mas bajo. Quedan " + intentos + " intentos");
					texto.setText("");
				} else if (valor < aiNumber) {
					// Si el valor es menor que el número introducido, baja un intento y da una pista del número
					intentos--;
					label.setText("Has fallado, el numero correcto es más alto. Quedan " + intentos + " intentos");
					texto.setText("");
				} 
				
				if (valor > 100 || valor < 1) {
					// Si el valor introducido es menor que 1 o mayor que 100, error.
					label.setText("El número debe estar entre 1 y 100.");
					texto.setText("");
				}
			
				if (intentos == 0) {
					// Si te quedas sin intentos, has perdido.
					label.setText("Te has quedado sin intentos. El número era " + aiNumber + ".");
					enter.setVisible(false);
					reinicio.setVisible(true);
				}
				
		} catch (NumberFormatException e) {
			// Si el valor introducido NO es un número, lo indica.
			label.setText("El número ingresado no es un número válido.");
			texto.setText("");
		}
		
	}
	
	// Aquí es donde se produce la acción que conlleva pulsar los botones
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == enter) {
			comprobador(); // Una vez pulsado el botón enter, se comprueba el número
		} else if (e.getSource() == salir) {
			System.exit(0); // Una vez pulsado el botón salir, sale de la aplicación
		} else if (e.getSource() == inicio || e.getSource() == reinicio) {
			iniciar(); // Para iniciar (o reiniciar en caso de ganar / perder), se accede al mismo método
		}
	}
	
	// Método que inicia el juego
	public void iniciar() {
		
		// Reinicia todos los valores
		intentos = 10;
		aiNumber = r.nextInt(100)+1;
		label.setText("Adivina el número: inserta un número del 1 al 100.");
		texto.setText("");
		
		// Hace desaparecer lo que hay previo al juego. No hace nada si lo reinicia.
		start.setVisible(false);
		inicio.setVisible(false);
		
		// Hace visible el juego. No hace nada si lo reinicia.
		label.setVisible(true);
		enter.setVisible(true);
		texto.setVisible(true);
		salir.setVisible(true);
		reinicio.setVisible(true);
	}

}

