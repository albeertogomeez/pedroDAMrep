package keyboard;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Principal extends JFrame implements ActionListener, KeyListener {

	private JFrame frame;
	JTextField insert = new JTextField();
	JButton B1 = new JButton();
	JButton B2 = new JButton();
	JButton B3 = new JButton();
	JButton Clean = new JButton();
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
		frame.setBounds(100, 100, 450, 630);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.BLACK); // El background de toda la ventana en negro. Lo mismo con los botones.
		
		JPanel panel = new JPanel();
		panel.setBounds(100, 100, 450, 630);
		frame.add(panel);
		panel.setLayout(null);
		panel.setBackground(Color.BLACK);
		
		insert = new JTextField();
		insert.setBounds(5, 5, 425, 100);
		insert.setHorizontalAlignment(JTextField.RIGHT);
		Font font = new Font(insert.getFont().getName(), Font.PLAIN, 100);
		insert.setFont(font);
		panel.add(insert);
		insert.setBackground(Color.BLACK);
		insert.setForeground(Color.GREEN); // Pone el texto escrito en verde.
		insert.addKeyListener(this); // Comprueba si la tecla pulsada es 1, 2 o 3. Si no lo es, no escribe.
		
		
		Font FB = new Font(B1.getFont().getName(), Font.PLAIN, 50); // Ajusta el tamaño de la fuente de los botones
		
		B1 = new JButton("Pulsa o teclea 1");
		B1.setBounds(5, 120, 425, 100);
		B1.setFont(FB);
		B1.setBackground(Color.BLACK);
		B1.setForeground(Color.WHITE);
		panel.add(B1);
		B1.addActionListener(this); // Añade 1 si pulsas el botón.
		
		B2 = new JButton("Pulsa o teclea 2");
		B2.setBounds(5, 240, 425, 100);
		B2.setFont(FB);
		B2.setBackground(Color.BLACK);
		B2.setForeground(Color.WHITE);
		panel.add(B2);
		B2.addActionListener(this); // Añade 2 si pulsas el botón.
		
		B3 = new JButton("Pulsa o teclea 3");
		B3.setBounds(5, 360, 425, 100);
		B3.setFont(FB);
		B3.setBackground(Color.BLACK);
		B3.setForeground(Color.WHITE);
		panel.add(B3);
		B3.addActionListener(this); // Añade 3 si pulsas el botón.
		
		Clean = new JButton("Limpiar display");
		Clean.setBounds(5, 480, 425, 100);
		Clean.setFont(FB);
		Clean.setBackground(Color.BLACK);
		Clean.setForeground(Color.WHITE);
		panel.add(Clean);
		Clean.addActionListener(this); // Pone el texto vacío (limpia el display)
	}

	// Método que añade 1, 2 o 3 al display dependiendo del botón que pulses.
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Clean) {
			insert.setText("");
		} else if (e.getSource() == B1) {
			insert.setText(insert.getText() + "1");
		} else if (e.getSource() == B2) {
			insert.setText(insert.getText() + "2");
		} else if (e.getSource() == B3) {
			insert.setText(insert.getText() + "3");
		}
		
	}
	
	// Método que comprueba si la tecla presionada es 1, 2 o 3. Si no lo es, no introduce la tecla.
	public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();
		if (c != '1' && c != '2' && c != '3') {
			e.consume();
		}
	}
	
	// Métodos hechos para que el KeyListener pueda funcionar.
	public void keyPressed(KeyEvent e) {
		
	}
	
	public void keyReleased(KeyEvent e) {
		
	}

}
