package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import controlador.Controlador;
/*import vista.Form04Cliente.BtnAtrasActionListener;
import vista.Form04Cliente.BtnInsertarActionListener;
import vista.Form04Cliente.BtnMasOpcionesActionListener;
import vista.Form11DetallesReserva.AtrasButtonActionListener;
import vista.Form11DetallesReserva.DeleteButtonActionListener;
import vista.Form11DetallesReserva.ModifyButtonActionListener;*/

public class Form12DetallesCliente extends JFrame{
	
	Controlador controlador = new Controlador();

	private JFrame frame;
	private JTextField textField_primer_apellido;
	private JTextField textField_nombre;
	private JTextField textField_calle;
	private JTextField textField_numero;
	private JTextField textField_telefono;
	private JTextField textField_nif;
	private JTextField textField_localidad;
	private String codigoReserva;
	
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form12DetallesCliente frame = new Form12DetallesCliente();
					frame.setDefaultCloseOperation(JFrame
		                    .DISPOSE_ON_CLOSE);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Form12DetallesCliente(String codigo) {
		this.codigoReserva = codigo;
		initialize();
		mostrarDatos();
	}
	
	

	public Form12DetallesCliente() throws HeadlessException {
		super();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle("Nuevo Cliente");
		setBounds(100, 100, 635, 404);
		setExtendedState(JFrame.NORMAL);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		textField_primer_apellido = new JTextField();
		textField_primer_apellido.setBounds(129, 110, 96, 19);
		getContentPane().add(textField_primer_apellido);
		textField_primer_apellido.setColumns(10);
		
		JLabel label_nombre = new JLabel("Nombre");
		label_nombre.setBounds(28, 79, 58, 13);
		getContentPane().add(label_nombre);
		
		JLabel label_primer_apellido = new JLabel("Primer Apellido");
		label_primer_apellido.setBounds(28, 113, 110, 13);
		getContentPane().add(label_primer_apellido);
		
		JLabel label_nif = new JLabel("NIF");
		label_nif.setBounds(28, 45, 45, 13);
		getContentPane().add(label_nif);
		
		JLabel label_calle = new JLabel("Calle");
		label_calle.setBounds(28, 147, 45, 13);
		getContentPane().add(label_calle);
		
		JLabel label_numero = new JLabel("Número");
		label_numero.setBounds(28, 181, 45, 13);
		getContentPane().add(label_numero);
		
		JLabel label_telefono = new JLabel("Teléfono");
		label_telefono.setBounds(28, 249, 70, 13);
		getContentPane().add(label_telefono);
		
		textField_nombre = new JTextField();
		textField_nombre.setColumns(10);
		textField_nombre.setBounds(129, 76, 96, 19);
		getContentPane().add(textField_nombre);
		
		textField_calle = new JTextField();
		textField_calle.setColumns(10);
		textField_calle.setBounds(129, 144, 96, 19);
		getContentPane().add(textField_calle);
		
		textField_numero = new JTextField();
		textField_numero.setColumns(10);
		textField_numero.setBounds(129, 178, 96, 19);
		getContentPane().add(textField_numero);
		
		textField_telefono = new JTextField();
		textField_telefono.setColumns(10);
		textField_telefono.setBounds(129, 252, 96, 19);
		getContentPane().add(textField_telefono);
		
		textField_nif = new JTextField();
		textField_nif.setColumns(10);
		textField_nif.setBounds(129, 42, 96, 19);
		getContentPane().add(textField_nif);
		
		JButton btnEliminarCliente = new JButton("Eliminar Cliente");
		btnEliminarCliente.addActionListener(new BtnEliminarClienteActionListener());
		btnEliminarCliente.setBounds(396, 121, 139, 21);
		getContentPane().add(btnEliminarCliente);
		
		JButton btnModificarCliente = new JButton("Modificar Cliente");
		btnModificarCliente.addActionListener(new BtnModificarClienteActionListener());
		btnModificarCliente.setBounds(104, 327, 132, 21);
		getContentPane().add(btnModificarCliente);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new BtnAtrasActionListener());
		btnAtras.setBounds(396, 327, 85, 21);
		getContentPane().add(btnAtras);
		
		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setAutoscrolls(true);
		lblLocalidad.setBounds(28, 215, 70, 13);
		getContentPane().add(lblLocalidad);
		
		textField_localidad = new JTextField();
		textField_localidad.setColumns(10);
		textField_localidad.setBounds(129, 215, 96, 19);
		getContentPane().add(textField_localidad);
	}
	
	
	private class BtnEliminarClienteActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			controlador.eliminarReservasCliente(codigoReserva);
			controlador.eliminarInvolucraCliente(codigoReserva);
			controlador.eliminarCliente(codigoReserva);
		}
	}
	
	private class BtnModificarClienteActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
		}
	}
	
	private class BtnAtrasActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			dispose();
			controlador.mostrarF06MasOpcionesCliente();
		}
	}

}
