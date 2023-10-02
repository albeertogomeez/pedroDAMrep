package packCalculator;

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
	JTextField display = new JTextField();
	JButton cero = new JButton();
	JButton mod = new JButton();
	JButton uno = new JButton();
	JButton dos = new JButton();
	JButton tre = new JButton();
	JButton cua = new JButton();
	JButton cin = new JButton();
	JButton sei = new JButton();
	JButton sie = new JButton();
	JButton och = new JButton();
	JButton nue = new JButton();
	JButton sum = new JButton();
	JButton rest = new JButton();
	JButton mul = new JButton();
	JButton div = new JButton();
	JButton clean = new JButton();
	JButton enterRes = new JButton();

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
		frame.setBounds(100, 100, 440, 630);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.BLACK); // El background de toda la ventana en negro. Lo mismo con los botones.
		
		JPanel panel = new JPanel();
		panel.setBounds(100, 100, 440, 630);
		frame.add(panel);
		panel.setLayout(null);
		panel.setBackground(Color.BLACK);
		
		display = new JTextField();
		display.setBounds(5, 5, 415, 100);
		display.setHorizontalAlignment(JTextField.RIGHT);
		Font font = new Font(display.getFont().getName(), Font.PLAIN, 100);
		display.setFont(font);
		panel.add(display);
		display.setBackground(Color.BLACK);
		display.setForeground(Color.WHITE);
		display.addKeyListener(this); // Comprueba si la tecla pulsada es 1, 2 o 3. Si no lo es, no escribe.
		
		cero = new JButton("0");
		cero.setBounds(5, 485, 205, 100);
		cero.setBackground(Color.GRAY);
		cero.setForeground(Color.WHITE);
		cero.addActionListener(this);
		panel.add(cero);
		
		mod = new JButton("%");
		mod.setBounds(215, 485, 100, 100);
		mod.setBackground(Color.GRAY);
		mod.setForeground(Color.WHITE);
		mod.addActionListener(this);
		panel.add(mod);
		
		
		enterRes = new JButton("Intro");
		enterRes.setBounds(320, 430, 100, 155);
		enterRes.setBackground(Color.GRAY);
		enterRes.setForeground(Color.WHITE);
		enterRes.addActionListener(this);
//				new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				try {
//					int valor = Integer.parseInt(display.getText());
//				} catch (NumberFormatException ex) {
//					display.setText("Syntax error");
//				}
//			}
//		});
		panel.add(enterRes);
		
		uno = new JButton("1");
		uno.setBounds(5, 380, 100, 100);
		uno.setBackground(Color.GRAY);
		uno.setForeground(Color.WHITE);
		uno.addActionListener(this);
		panel.add(uno);
		
		dos = new JButton("2");
		dos.setBounds(110, 380, 100, 100);
		dos.setBackground(Color.GRAY);
		dos.setForeground(Color.WHITE);
		dos.addActionListener(this);
		panel.add(dos);
		
		tre = new JButton("3");
		tre.setBounds(215, 380, 100, 100);
		tre.setBackground(Color.GRAY);
		tre.setForeground(Color.WHITE);
		tre.addActionListener(this);
		panel.add(tre);
		
		sum = new JButton("Sumar");
		sum.setBounds(320, 270, 100, 155);
		sum.setBackground(Color.GRAY);
		sum.setForeground(Color.WHITE);
		sum.addActionListener(this);
		panel.add(sum);
		
		cua = new JButton("4");
		cua.setBounds(5, 275, 100, 100);
		cua.setBackground(Color.GRAY);
		cua.setForeground(Color.WHITE);
		cua.addActionListener(this);
		panel.add(cua);
		
		cin = new JButton("5");
		cin.setBounds(110, 275, 100, 100);
		cin.setBackground(Color.GRAY);
		cin.setForeground(Color.WHITE);
		cin.addActionListener(this);
		panel.add(cin);
		
		sei = new JButton("6");
		sei.setBounds(215, 275, 100, 100);
		sei.setBackground(Color.GRAY);
		sei.setForeground(Color.WHITE);
		sei.addActionListener(this);
		panel.add(sei);
		
		rest = new JButton("Restar");
		rest.setBounds(320, 110, 100, 155);
		rest.setBackground(Color.GRAY);
		rest.setForeground(Color.WHITE);
		rest.addActionListener(this);
		panel.add(rest);
		
		sie = new JButton("7");
		sie.setBounds(5, 170, 100, 100);
		sie.setBackground(Color.GRAY);
		sie.setForeground(Color.WHITE);
		sie.addActionListener(this);
		panel.add(sie);
		
		och = new JButton("8");
		och.setBounds(110, 170, 100, 100);
		och.setBackground(Color.GRAY);
		och.setForeground(Color.WHITE);
		och.addActionListener(this);
		panel.add(och);
		
		nue = new JButton("9");
		nue.setBounds(215, 170, 100, 100);
		nue.setBackground(Color.GRAY);
		nue.setForeground(Color.WHITE);
		nue.addActionListener(this);
		panel.add(nue);
		
		clean = new JButton("Clean");
		clean.setBounds(5, 110, 100, 55);
		clean.setBackground(Color.GRAY);
		clean.setForeground(Color.WHITE);
		clean.addActionListener(this);
		panel.add(clean);
		
		div = new JButton("/");
		div.setBounds(110, 110, 100, 55);
		div.setBackground(Color.GRAY);
		div.setForeground(Color.WHITE);
		div.addActionListener(this);
		panel.add(div);
		
		mul = new JButton("*");
		mul.setBounds(215, 110, 100, 55);
		mul.setBackground(Color.GRAY);
		mul.setForeground(Color.WHITE);
		mul.addActionListener(this);
		panel.add(mul);
	
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	    if (e.getSource() == enterRes) {
	        String expresion = display.getText();
	        try {
	            double resultado = Calculator.evaluateExpression(expresion);
	            display.setText(Double.toString(resultado));
	        } catch (Exception ex) {
	            display.setText("Error");
	        }
	    } else if (e.getSource() == clean) {
	        display.setText("");
	    } else if (e.getSource() == uno) {
			display.setText(display.getText() + "1");
		} else if (e.getSource() == dos) {
			display.setText(display.getText() + "2");
		} else if (e.getSource() == tre) {
			display.setText(display.getText() + "3");
		} else if (e.getSource() == cua) {
			display.setText(display.getText() + "4");
		} else if (e.getSource() == cin) {
			display.setText(display.getText() + "5");
		} else if (e.getSource() == sei) {
			display.setText(display.getText() + "6");
		} else if (e.getSource() == sie) {
			display.setText(display.getText() + "7");
		} else if (e.getSource() == och) {
			display.setText(display.getText() + "8");
		} else if (e.getSource() == nue) {
			display.setText(display.getText() + "9");
		} else if (e.getSource() == cero) {
			display.setText(display.getText() + "0");
		} else if (e.getSource() == sum) {
			display.setText(display.getText() + "+");
		} else if (e.getSource() == rest) {
			display.setText(display.getText() + "-");
		} else if (e.getSource() == mul) {
			display.setText(display.getText() + "*");
		} else if (e.getSource() == div) {
			display.setText(display.getText() + "/");
		} else if (e.getSource() == mod) {
			display.setText(display.getText() + "%");
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();
		if (c != '1' && c != '2' && c != '3' && c != '4' && c != '5' && c != '6' && c != '7' && c != '8' && c != '9' && c != '0' && c != '+' && c != '-' && c != '*' && c != '/' && c != '%') {
			e.consume();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

}
