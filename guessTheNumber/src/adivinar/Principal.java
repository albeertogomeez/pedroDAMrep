package adivinar;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Principal extends JFrame implements ActionListener {

	private JFrame frame;
	JButton boton = new JButton();
	JButton enter = new JButton();
	JTextField texto = new JTextField();
	JLabel label = new JLabel();
	private JLabel resultado;
	private int intentosRestantes;
	private int comprobarNum;
	int intentos = 10;
	
	Random r = new Random();
	int aiNumber = r.nextInt(100)+1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
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
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 375, 100);
		frame.add(panel);
		panel.setLayout(null);
		
		
		label = new JLabel();
		label.setText("Adivina el numero: inserta un numero del 1 al 100.");
		label.setBounds(50, 0, 500, 100);
		panel.add(label);
		
		texto = new JTextField();
		texto.setBounds(50, 100, 200, 25);
		panel.add(texto);
		
		enter = new JButton("Enter");
		enter.setBounds(50, 150, 100, 20);
		panel.add(enter);
		enter.addActionListener(this);
		
		boton = new JButton("Salir");
		boton.setBounds(150, 150, 100, 20);
		panel.add(boton);
		boton.addActionListener(this);
		
		
		
	}
	
	public void comprobador() {
		System.out.println(aiNumber);
		try {
			int valor = Integer.parseInt(texto.getText());
				if (valor == aiNumber) {
					label.setText("¡Enhorabuena! Has acertado el numero");
					enter.setText("Reiniciar");
					intentos = 11;
					aiNumber = r.nextInt(100)+1;
				} else if (valor > aiNumber) {
					intentos--;
					label.setText("Has fallado, tu numero es mas alto. Quedan " + intentos + " intentos");
					texto.setText("");
				} else if (valor < aiNumber) {
					intentos--;
					label.setText("Has fallado, tu numero es mas bajo. Quedan " + intentos + " intentos");
					texto.setText("");
				} 
			
				if (intentos == 0) {
					label.setText("Te has quedado sin intentos. El numero era " + aiNumber + ".");
					enter.setText("Reiniciar");
					intentos = 11;
					aiNumber = r.nextInt(100)+1;
				}
				
		} catch (NumberFormatException e) {
			label.setText("El numero ingresado no es un numero valido");
		}
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == enter) {
			comprobador();
		} else if (e.getSource() == boton) {
			System.exit(0);
		}
	}

}
