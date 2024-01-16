package vista;

import controlador.Controlador;
import modeloVo.Cliente;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Form06MasOpcionesCliente extends JFrame {

	private DefaultListModel<String> clientesListModel;
	private JScrollPane scrollPane;
    private JList<String> clienteList;
    Controlador controlador = new Controlador();
    
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
					Form06MasOpcionesCliente frame = new Form06MasOpcionesCliente();
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
	public Form06MasOpcionesCliente() {
		try {
			initialize();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws SQLException {
		setTitle("Listado Clientes");
        setSize(400, 307);
        getContentPane().setLayout(new BorderLayout());

        clientesListModel = new DefaultListModel<>();
        clienteList = new JList<>(clientesListModel);

        scrollPane = new JScrollPane(clienteList);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        clienteList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String selectedCodigo = clienteList.getSelectedValue();
                if (selectedCodigo != null) {
                	System.out.println("...");
                }
            }
        });
        
        {
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnAtras = new JButton("Atras");
				btnAtras.addActionListener(new AtrasButtonActionListener());
				btnAtras.setActionCommand("Cancel");
				buttonPane.add(btnAtras);
			}
		}
        
        controlador.cargarListaClientes(clientesListModel);

	}
	
	
	private class AtrasButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			dispose();
			controlador.mostrarF04Clientes();
		}
	}

}
