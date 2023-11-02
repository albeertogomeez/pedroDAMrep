package profesorClase;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Principal extends JFrame implements ActionListener {

	public Map<Integer, Estudiante> mapaAlumnos = new HashMap<>();
	
	JButton btnAnadir;
	JButton btnVer;
	JButton btnCorregir;
	JButton btnEliminar;
	
	public JTextArea textArea;
	private JFrame frame;

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
		frame = new JFrame("Maps Actividad 1 Profesor");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBounds(100, 100, 450, 300);
		frame.add(panel);
	    panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
	    btnAnadir = new JButton("Añadir");
	    panel.add(btnAnadir);
	    btnAnadir.addActionListener(this);
	    
	    btnVer = new JButton("Ver");
	    panel.add(btnVer);
	    btnVer.addActionListener(this);
	    
	    btnCorregir = new JButton("Corregir");
	    panel.add(btnCorregir);
	    btnCorregir.addActionListener(this);
	    
	    btnEliminar = new JButton("Eliminar");
	    panel.add(btnEliminar);
	    btnEliminar.addActionListener(this);
	    
	    textArea = new JTextArea(10, 30);
	    textArea.setEditable(false); // Hace que el área de texto sea solo de lectura
	    JScrollPane scrollPane = new JScrollPane(textArea);
	    panel.add(scrollPane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAnadir) {
			AnadirAlumno();
		} else if (e.getSource() == btnVer) {
			verNotas();
		} else if (e.getSource() == btnCorregir) {
			  try {
		            int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la ID del alumno a corregir:"));
		            double nuevaNota = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la nueva nota del alumno:"));
		            corregirNota(id, nuevaNota);
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "Por favor, ingrese datos válidos", "Error", JOptionPane.ERROR_MESSAGE);
		        }
		} else if (e.getSource() == btnEliminar) {
	        try {
	            int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la ID del alumno a eliminar:"));
	            eliminarAlumno(id);
	        } catch (NumberFormatException ex) {
	            JOptionPane.showMessageDialog(null, "Por favor, ingrese una ID válida", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	}
	
	public void AnadirAlumno() {
	    try {
	        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la ID del alumno:"));
	        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del alumno:");
	        double nota = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la nota del alumno (puede ser un decimal, por ejemplo, 8.5):"));

	        // Validar que la nota esté dentro del rango válido (0.0 a 10.0)
	        if (nota < 0.0 || nota > 10.0) {
	            JOptionPane.showMessageDialog(null, "La nota debe estar entre 0.0 y 10.0", "Error", JOptionPane.ERROR_MESSAGE);
	            return;
	        }

	        Estudiante estudiante = new Estudiante(id, nombre, nota);
	        mapaAlumnos.put(id, estudiante);

	        JOptionPane.showMessageDialog(null, "Alumno añadido correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(null, "Por favor, ingrese datos válidos", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	    actualizarTextArea();
	}

	public void verNotas() {
	    StringBuilder notas = new StringBuilder();
	    for (Estudiante estudiante : mapaAlumnos.values()) {
	        notas.append("ID: ").append(estudiante.getID()).append(", Nombre: ").append(estudiante.getNombre()).append(", Nota: ").append(estudiante.getNota()).append("\n");
	    }
	    JOptionPane.showMessageDialog(null, notas.toString(), "Notas de Estudiantes", JOptionPane.INFORMATION_MESSAGE);
	    actualizarTextArea();
	}
	
	public void corregirNota(int id, double nuevaNota) {
	    Estudiante estudiante = mapaAlumnos.get(id);
	    if (estudiante != null) {
	        estudiante.setNota(nuevaNota);
	        JOptionPane.showMessageDialog(null, "Nota corregida correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
	    } else {
	        JOptionPane.showMessageDialog(null, "Estudiante no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	    actualizarTextArea();
	}
	
	public void eliminarAlumno(int id) {
		 Estudiante estudiante = mapaAlumnos.remove(id);
		    if (estudiante != null) {
		        JOptionPane.showMessageDialog(null, "Estudiante eliminado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
		} else {
		    JOptionPane.showMessageDialog(null, "Estudiante no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
		    }
		    actualizarTextArea();
		}
	
	private void actualizarTextArea() {
	    StringBuilder estudiantesInfo = new StringBuilder();
	    for (Estudiante estudiante : mapaAlumnos.values()) {
	        estudiantesInfo.append("ID: ").append(estudiante.getID()).append(", Nombre: ").append(estudiante.getNombre()).append(", Nota: ").append(estudiante.getNota()).append("\n");
	    }
	    textArea.setText(estudiantesInfo.toString());
	}
}
