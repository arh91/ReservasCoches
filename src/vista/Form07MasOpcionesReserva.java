package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controlador.Controlador;


public class Form07MasOpcionesReserva extends JFrame {

	private DefaultListModel<String> reservaListModel;
	private JScrollPane scrollPane;
    private JList<String> reservasList;
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
					Form07MasOpcionesReserva frame = new Form07MasOpcionesReserva();
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
	public Form07MasOpcionesReserva() throws SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() throws SQLException {
		setTitle("Listado Reservas");
        setSize(400, 307);
        getContentPane().setLayout(new BorderLayout());

        reservaListModel = new DefaultListModel<>();
        reservasList = new JList<>(reservaListModel);

        scrollPane = new JScrollPane(reservasList);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        reservasList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String selectedCodigo = reservasList.getSelectedValue();
                if (selectedCodigo != null) {
                	Form11DetallesReserva detallesReserva = new Form11DetallesReserva(selectedCodigo);
                	dispose();
                	detallesReserva.setVisible(true);             
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
        
        controlador.cargarListaReservas(reservaListModel);

	}
	
	
	private class AtrasButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			dispose();
			controlador.mostrarF02NuevaReserva();
		}
	}

}
