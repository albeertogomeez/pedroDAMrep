package vendedorTienda;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Principal extends JFrame implements ActionListener {

	private JFrame frame;
	
	JButton btnAnadir;
	JButton btnVer;
	JButton btnVender;
	JButton btnEliminar;
	
	public JTextArea textArea;
	public HashMap<String, Producto> Inventario;

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
		Inventario = new HashMap<>();
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
		panel.setBounds(100, 100, 450, 300);
		frame.add(panel);
	    panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
	    btnAnadir = new JButton("Añadir");
	    panel.add(btnAnadir);
	    btnAnadir.addActionListener(this);
	    
	    btnVer = new JButton("Ver");
	    panel.add(btnVer);
	    btnVer.addActionListener(this);
	    
	    btnVender = new JButton("Vender");
	    panel.add(btnVender);
	    btnVender.addActionListener(this);
	    
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
            // Obtener el nombre, precio y cantidad del producto desde el usuario
            String nombre = obtenerNombreProducto(); // Implementa este método para obtener el nombre desde el usuario
            double precio = obtenerPrecioProducto(); // Implementa este método para obtener el precio desde el usuario
            int cantidad = obtenerCantidadProducto(); // Implementa este método para obtener la cantidad desde el usuario

            // Crear un nuevo producto y añadirlo al inventario
            Producto producto = new Producto(nombre, precio, cantidad);
            Inventario.put(nombre, producto);
            mostrarMensaje("Producto añadido al inventario: " + nombre);
        } else if (e.getSource() == btnVer) {
            mostrarInventario();
        } else if (e.getSource() == btnVender) {
            // Obtener el nombre del producto desde el usuario
            String nombre = obtenerNombreProducto(); // Implementa este método para obtener el nombre desde el usuario
            Producto producto = Inventario.get(nombre);

            // Verificar si el producto está en el inventario y hay suficiente cantidad para vender
            if (producto != null && producto.getCantidadStock() > 0) {
                producto = new Producto(producto.getNombre(), producto.getPrecio(), producto.getCantidadStock() - 1);
                Inventario.put(nombre, producto);
                mostrarMensaje("Producto vendido: " + nombre);
            } else {
                mostrarMensaje("Producto no disponible para la venta: " + nombre);
            }
        } else if (e.getSource() == btnEliminar) {
            // Obtener el nombre del producto desde el usuario
            String nombre = obtenerNombreProducto(); // Implementa este método para obtener el nombre desde el usuario

            // Verificar si el producto está en el inventario y eliminarlo
            if (Inventario.containsKey(nombre)) {
            	Inventario.remove(nombre);
                mostrarMensaje("Producto eliminado del inventario: " + nombre);
            } else {
                mostrarMensaje("Producto no encontrado en el inventario: " + nombre);
            }
        }
    }
	
	private void mostrarInventario() {
	    textArea.setText(""); // Limpiar el área de texto antes de mostrar el inventario
	    if (Inventario.isEmpty()) {
	        textArea.append("El inventario está vacío.");
	    } else {
	        for (Map.Entry<String, Producto> entry : Inventario.entrySet()) {
	            String nombre = entry.getKey();
	            Producto producto = entry.getValue();
	            textArea.append("Nombre: " + nombre + ", Precio: " + producto.getPrecio() + ", Cantidad: " + producto.getCantidadStock() + "\n");
	        }
	    }
	}

    // Método para mostrar mensajes en el área de texto
    private void mostrarMensaje(String mensaje) {
        textArea.append(mensaje + "\n");
    }
    
    // Método para obtener el nombre del producto desde el usuario
    private String obtenerNombreProducto() {
        return JOptionPane.showInputDialog("Introduce el nombre del producto:");
    }

    // Método para obtener el precio del producto desde el usuario
    private double obtenerPrecioProducto() {
        double precio = 0.0;
        boolean precioValido = false;
        while (!precioValido) {
            try {
                String precioStr = JOptionPane.showInputDialog("Introduce el precio del producto:");
                precio = Double.parseDouble(precioStr);
                precioValido = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, ingresa un precio válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return precio;
    }

    // Método para obtener la cantidad del producto desde el usuario
    private int obtenerCantidadProducto() {
        int cantidad = 0;
        boolean cantidadValida = false;
        while (!cantidadValida) {
            try {
                String cantidadStr = JOptionPane.showInputDialog("Introduce la cantidad del producto:");
                cantidad = Integer.parseInt(cantidadStr);
                if (cantidad >= 0) {
                    cantidadValida = true;
                } else {
                    JOptionPane.showMessageDialog(null, "La cantidad debe ser un número positivo.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, ingresa una cantidad válida.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return cantidad;
    }
}
