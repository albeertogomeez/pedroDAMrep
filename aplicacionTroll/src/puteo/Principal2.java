//package puteo;
//
//import java.awt.Color;
//import java.awt.EventQueue;
//import java.awt.Font;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;
//import java.util.Random;
//import java.util.Timer;
//
//import javax.swing.*;
//
//import static javax.swing.JOptionPane.showMessageDialog;
//
//public class Principal2 implements ActionListener {
//
//	private JFrame frame;
//    private Timer t;
//    private JFrame Vent2;
//    private Random r;
//	JButton Y = new JButton();
//	JButton N = new JButton();
//	JButton IDK = new JButton();
//
//	/**
//	 * Create the application.
//	 */
//	public Principal2() {
//		initialize();
//	}
//
//	/**
//	 * Initialize the contents of the frame.
//	 */
//	private void initialize() {
//		frame = new JFrame("You really are an idiot :)");
//		frame.setBounds(960, 540, 450, 300);
//		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//        frame.addWindowListener(new WindowAdapter() {
//        	
//            public void windowClosing(WindowEvent e) {
//                mostrarAlerta();
//            }
//        });
//		
//		JPanel panel = new JPanel();
//		panel.setBounds(960, 540, 450, 300);
//		frame.add(panel);
//		panel.setLayout(null);
//		
//		JLabel label = new JLabel("Are you an idiot? ☻☺︎☻ ☺︎☻☺︎");
//		Font font = new Font(label.getFont().getName(), Font.PLAIN, 25);
//		label.setBounds(40, 20, 450, 40);
//		label.setFont(font);
//		panel.add(label);
//		
//		Y = new JButton("Yes");
//		Y.setBounds(20, 100, 120, 30);
//		Y.setBackground(Color.BLACK);
//		Y.setForeground(Color.WHITE);
//		Y.addActionListener(this);
//		panel.add(Y);
//		
//		IDK = new JButton("I don't know");
//		IDK.setBounds(155, 100, 120, 30);
//		IDK.setBackground(Color.BLACK);
//		IDK.setForeground(Color.WHITE);
//		IDK.addActionListener(this);
//		panel.add(IDK);
//		
//		N = new JButton("No");
//		N.setBounds(290, 100, 120, 30);
//		N.setBackground(Color.BLACK);
//		N.setForeground(Color.WHITE);
//		N.addActionListener(this);
//		panel.add(N);
//	}
//	
//	public void trollApp() {
//        Vent2 = new JFrame("You really are an idiot :)");
//        Vent2.setBounds(960, 540, 450, 300);
//        Vent2.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//
//        r = new Random();
//
//        t = new Timer(100, new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                int x = r.nextInt(1200); // Generar un número aleatorio para la posición x (entre 0 y 1200)
//                int y = r.nextInt(1000); // Generar un número aleatorio para la posición y (entre 0 y 1000)
//                Vent2.setLocation(x, y); // Establecer la nueva ubicación de la ventana
//            }
//        });
//
//        t.start();
//
//        Vent2.setVisible(true);
//	}
//	
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		if (e.getSource() == Y) {
//			showMessageDialog(null, "Yes you are :)");
//			trollApp.setVisible(true);
//		} else if (e.getSource() == IDK) {
//			showMessageDialog(null, "I think you're :)");
//		} else if (e.getSource() == N) {
//			showMessageDialog(null, "u r lyin");
//		}
//		
//	}
//	
//	public void mostrarAlerta() {
//		showMessageDialog(null, "you're not closing this window :)");
//	}
//	
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Principal2 window = new Principal2();
//					trollApp app = new trollApp();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//}
