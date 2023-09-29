package packWindow;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Principal extends JFrame implements ActionListener, WindowListener {

	private JFrame frame;
	JLabel label = new JLabel();
	JButton Ventana1 = new JButton();

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
		frame = new JFrame("Ventana principal");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBounds(100, 100, 450, 300);
		frame.add(panel);
		panel.setLayout(null);
		
		Font FLabel = new Font(label.getFont().getName(), Font.PLAIN, 20);
		
		// Ventana principal
		label = new JLabel();
		label.setText("Esta es la ventana principal");
		label.setBounds(100, 0, 500, 100);
		label.setFont(FLabel);
		panel.add(label);
		
		
		Ventana1 = new JButton();
		Ventana1.setText("Haz click aqui");
		Ventana1.setBounds(125, 150, 200, 50);
		panel.add(Ventana1);
		Ventana1.addActionListener(this);
	}

	// Método que implementa toda la segunda ventana directamente si pulsas el botón
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Ventana1) {
			JFrame VentanaSec = new JFrame("Nueva ventana");
			VentanaSec.setBounds(100, 100, 450, 300);
			VentanaSec.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
			JPanel panel2 = new JPanel();
			VentanaSec.add(panel2);
			panel2.setBounds(100, 100, 450, 300);
			panel2.setLayout(null);
			
			Font FLabel = new Font(label.getFont().getName(), Font.PLAIN, 20);
			
			JLabel label2 = new JLabel();
			label2.setText("Esta es la ventana secundaria");
			label2.setBounds(90, 0, 500, 100);
			label2.setFont(FLabel);
			panel2.add(label2);
			
			JButton volver = new JButton();
			volver.setText("Volver");
			volver.setBounds(125, 150, 200, 50);

			// Método que hace que si le das click al botón "Volver", la segunda ventana
			// se cierra y la primera ventana se vuelve operativa de nuevo
			volver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() == volver) {
						frame.setEnabled(true);
						VentanaSec.dispose();
					}
				}
			});
			panel2.add(volver);
			
			// Vuelve la primera ventana completamente inoperativa mientras la segunda ventana esté abierta
			frame.setEnabled(false);
			
			// Método que hace que si se cierra la ventana mediante la X, la primera ventana pueda estar operativa
			VentanaSec.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					frame.setEnabled(true);
				}
			});
			VentanaSec.setVisible(true);
		}
		
	}

	// Métodos hechos para que el WindowListener pueda funcionar
	@Override
	public void windowOpened(WindowEvent e) {
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		
	}


}
