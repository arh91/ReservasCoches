package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

import controlador.Controlador;

public class pruebaa extends JFrame {

	private DefaultListModel<String> reservaListModel;
	private JScrollPane scrollPane;
    private JList<String> reservaList;
    Controlador controlador = new Controlador();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pruebaa frame = new pruebaa();
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
	public pruebaa() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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
                    System.out.println("...");
					//controlador.mostrarF12ModificarReserva(selectedCodigo)
                }
            }
        });
        
        controlador.cargarListaReservas(reservaListModel);

	}

}
