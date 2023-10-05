package puteo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

// Herramienta secreta que nos servirá para más tarde (concretamente para buscar en Google)
import java.awt.Desktop;
import java.net.URI;

import javax.swing.*;

public class Principal implements ActionListener {

    private JFrame frame;
    private JFrame Vent2;
    private Random r;
    private Timer t;
    
    // Integer que cuenta los intentos que llevas para cerrar las ventanas.
    private int intCerrar = 0;
    
    JButton Y = new JButton();
    JButton N = new JButton();
    JButton IDK = new JButton();
    JLabel idiot = new JLabel();
    
    public Principal() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("You really are an idiot :)");
        frame.setBounds(960, 540, 450, 300);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                mostrarAlerta();
            }
        });

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        JLabel label = new JLabel("Are you an idiot? ☻☺︎☻ ☺︎☻☺︎");
        Font font = new Font(label.getFont().getName(), Font.PLAIN, 25);
        label.setBounds(40, 20, 450, 40);
        label.setFont(font);
        panel.add(label);

        Y = new JButton("Yes");
        Y.setBounds(20, 100, 120, 30);
        Y.setBackground(Color.BLACK);
        Y.setForeground(Color.WHITE);
        Y.addActionListener(this);
        panel.add(Y);

        IDK = new JButton("I don't know");
        IDK.setBounds(155, 100, 120, 30);
        IDK.setBackground(Color.BLACK);
        IDK.setForeground(Color.WHITE);
        IDK.addActionListener(this);
        panel.add(IDK);

        N = new JButton("No");
        N.setBounds(290, 100, 120, 30);
        N.setBackground(Color.BLACK);
        N.setForeground(Color.WHITE);
        N.addActionListener(this);
        panel.add(N);
    }

    // Función para abrir la ventana del trolleo
    public void trollApp() {
        Vent2 = new JFrame("☻☺︎☻☺︎☻☺︎☻☺︎☻☺︎☻☺︎☻☺︎☻☺︎☻☺︎☻☺︎☻☺︎☻☺︎");
        Vent2.setBounds(960, 540, 450, 300);
        Vent2.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Nope, no vas a cerrarlo
        Vent2.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                mostrarAlerta2();
            }
        });
        Vent2.setBackground(Color.BLACK);
        
        JPanel panel2 = new JPanel();
        panel2.setBounds(960, 540, 500, 300);
        Vent2.add(panel2);
        panel2.setBackground(Color.BLACK);
        panel2.setLayout(null);
        
        idiot = new JLabel("☻☺︎☻☺︎☻☺︎☻☺︎☻☺︎☻");
        idiot.setBounds(10, 0, 450, 300);
        Font font = new Font(idiot.getFont().getName(), Font.PLAIN, 25);
        idiot.setFont(font);
        idiot.setForeground(Color.WHITE);
        panel2.add(idiot);
        
        r = new Random();

        // Posición de la ventana (se mueve por todas partes, es literalmente imposible cerrarla como tal).
        t = new Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int x = r.nextInt(1200);
                int y = r.nextInt(1000);
                Vent2.setLocation(x, y);
            }
        });

        t.start();

        Vent2.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	// Hagas lo que hagas va a abrir la app troll, pero cada botón muestra un mensaje diferente.
        if (e.getSource() == Y) {
            JOptionPane.showMessageDialog(null, "Yes you are :)");
            trollApp();
            frame.setVisible(false);
        } else if (e.getSource() == IDK) {
            JOptionPane.showMessageDialog(null, "I think you're :)");
            trollApp();
            frame.setVisible(false);
        } else if (e.getSource() == N) {
            JOptionPane.showMessageDialog(null, "u r lyin");
            trollApp();
            frame.setVisible(false);
        }
    }

    // Por si intentas cerrar la ventana principal.
    public void mostrarAlerta() {
        JOptionPane.showMessageDialog(null, "you're not closing this window :)");
    }
    
    // Por si intentas cerrar cualquier ventana que se mueva.
    public void mostrarAlerta2() {
    	JOptionPane.showMessageDialog(null, "again? how many times do I have to tell you? :)");
    	intCerrar++;
    	
        for (int i = 0; i < 2; i++) {
            JFrame nuevaVentana = new JFrame("YOU ARE AN IDIOT AHHAHAHHAHHAAHAHAAAHAAHAH");
            nuevaVentana.setBounds(960, 540, 450, 300);
            nuevaVentana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            nuevaVentana.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    mostrarAlerta2();
                }
			});
            
            JPanel panelN = new JPanel();
            panelN.setBounds(960, 540, 450, 300);
            panelN.setLayout(null);
            nuevaVentana.add(panelN);
            panelN.setBackground(Color.BLACK);
            
            idiot = new JLabel("☻☺︎☻☺︎☻☺︎☻☺︎☻☺︎☻");
            idiot.setBounds(10, 0, 450, 300);
            Font font = new Font(idiot.getFont().getName(), Font.PLAIN, 25);
            idiot.setFont(font);
            idiot.setForeground(Color.WHITE);
            panelN.add(idiot);
            
            r = new Random();

            t = new Timer(100, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int x = r.nextInt(1200);
                    int y = r.nextInt(1000);
                    nuevaVentana.setLocation(x, y);
                }
            });

            t.start();

            nuevaVentana.setVisible(true);
        }
        
        // Si intentas cerrar la ventana 3 veces, automáticamente en Google se buscará esta página. Su contenido es secreto :).
        if (intCerrar == 3) {
	        try {
	            Desktop.getDesktop().browse(new URI("https://we-are-jammin.xyz"));
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Principal window = new Principal();
                window.frame.setVisible(true);
            }
        });
    }
}
