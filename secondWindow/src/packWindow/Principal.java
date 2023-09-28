package packWindow;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Principal extends JFrame implements ActionListener {

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
			
			
			JButton Ventana2 = new JButton();
			Ventana2.setText("Volver");
			Ventana2.setBounds(125, 150, 200, 50);
			Ventana2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() == Ventana2) {
						frame.setEnabled(true);
						VentanaSec.dispose();
					}
				}
			});
			panel2.add(Ventana2);
			frame.setEnabled(false);
			VentanaSec.setVisible(true);
		}
		
	}

}
