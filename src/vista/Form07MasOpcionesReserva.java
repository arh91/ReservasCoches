package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

import controlador.Controlador;

public class Form07MasOpcionesReserva extends JFrame {

	private DefaultListModel<String> reservaListModel;
	private JScrollPane scrollPane;
    private JList<String> reservaList;
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
	public Form07MasOpcionesReserva() {
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
		setTitle("Tus Reservas");
        setSize(400, 307);
        getContentPane().setLayout(new BorderLayout());

        reservaListModel = new DefaultListModel<>();
        reservaList = new JList<>(reservaListModel);

        scrollPane = new JScrollPane(reservaList);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        reservaList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String selectedCodigo = reservaList.getSelectedValue();
                if (selectedCodigo != null) {
                    controlador.mostrarF11DetallesReserva(selectedCodigo);
                }
            }
        });
        
        controlador.cargarListaReservas(reservaListModel);

	}

}
