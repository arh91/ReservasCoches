package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import controlador.Controlador;
import modeloVo.Cliente;
import modeloVo.Coche;
import modeloVo.Involucra;
import modeloVo.Reserva;
import modeloVo.ReservaCompleta;
import validaciones.ConvertirFechas;

/*import vista.Form02NuevaReserva.AtrasButtonActionListener;
import vista.Form02NuevaReserva.CancelButtonActionListener;
import vista.Form02NuevaReserva.MasOpcionesButtonActionListener;
import vista.Form02NuevaReserva.OkButtonActionListener;
*/
public class Form11DetallesReserva extends JFrame{
	static String codigo;
	
	private final JPanel contentPanel = new JPanel();

	LocalDate todaysDate = LocalDate.now();  //Fecha actual del sistema

	Controlador controlador = new Controlador();

	private JTextField textFecInicial;
	private JTextField textFecFinal;
	private JTextField textLitros;
	private JTextField textCodReserva;
	private ModeloComboClientes comboBox_Clientes;
	private ModeloComboCoches comboBox_Coches;

	private String codigoReserva;
	private Date fechaInicio;
	private Date fechaFinal;
	private int litros;
	private String matriculaCoche;
	private String nifInvolucra;
	
	private String fechaInicioModificada;
	private String fechaFinModificada;
	
	ConvertirFechas convertirFechas = new ConvertirFechas();
	
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
					Form11DetallesReserva frame = new Form11DetallesReserva(codigo);
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
	
	
	public Form11DetallesReserva(String codigo) {
		this.codigoReserva = codigo;
		initialize();
		mostrarDatos();
	}

	public Form11DetallesReserva() throws HeadlessException {
		super();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle("Detalles Reserva");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		setExtendedState(JFrame.NORMAL);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(35, 24, 56, 16);
		contentPanel.add(lblCliente);

		JLabel lblCoche = new JLabel("Coche:");
		lblCoche.setBounds(35, 67, 56, 16);
		contentPanel.add(lblCoche);



		JPanel panel_Reserva = new JPanel();
		panel_Reserva.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Reserva", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_Reserva.setBounds(12, 105, 827, 139);
		contentPanel.add(panel_Reserva);
		panel_Reserva.setLayout(null);

		JLabel lblFechaInicial = new JLabel("Fecha Inicial (DD/MM/AAAA):");
		lblFechaInicial.setBounds(45, 35, 192, 16);
		panel_Reserva.add(lblFechaInicial);

		JLabel lblFechafinal = new JLabel("FechaFinal (DD/MM/AAAA):");
		lblFechafinal.setBounds(438, 35, 179, 16);
		panel_Reserva.add(lblFechafinal);

		textFecInicial = new JTextField();
		textFecInicial.setHorizontalAlignment(SwingConstants.CENTER);
		textFecInicial.setBounds(249, 32, 116, 22);
		panel_Reserva.add(textFecInicial);
		textFecInicial.setColumns(10);

		textFecFinal = new JTextField();
		textFecFinal.setHorizontalAlignment(SwingConstants.CENTER);
		textFecFinal.setColumns(10);
		textFecFinal.setBounds(629, 32, 116, 22);
		panel_Reserva.add(textFecFinal);

		JLabel lblLitros = new JLabel("Litros consumidos:");
		lblLitros.setBounds(438, 81, 152, 16);
		panel_Reserva.add(lblLitros);

		textLitros = new JTextField();
		textLitros.setHorizontalAlignment(SwingConstants.CENTER);
		textLitros.setBounds(629, 78, 116, 22);
		panel_Reserva.add(textLitros);
		textLitros.setColumns(10);

		JLabel lblCdigoReserva = new JLabel("C\u00F3digo Reserva:");
		lblCdigoReserva.setBounds(45, 81, 167, 16);
		panel_Reserva.add(lblCdigoReserva);

		textCodReserva = new JTextField();
		textCodReserva.setHorizontalAlignment(SwingConstants.CENTER);
		textCodReserva.setColumns(10);
		textCodReserva.setBounds(249, 78, 116, 22);
		panel_Reserva.add(textCodReserva);

		comboBox_Coches = new ModeloComboCoches();
		comboBox_Coches.setBounds(101, 65, 686, 20);
		contentPanel.add(comboBox_Coches);

		comboBox_Clientes = new ModeloComboClientes();
		comboBox_Clientes.setBounds(101, 22, 196, 20);
		contentPanel.add(comboBox_Clientes);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnEliminar = new JButton("Eliminar Reserva");
				btnEliminar.addActionListener(new DeleteButtonActionListener());
				btnEliminar.setActionCommand("OK");
				buttonPane.add(btnEliminar);

				JButton btnModificar = new JButton("Modificar Reserva");
				btnModificar.addActionListener(new ModifyButtonActionListener());
				btnModificar.setActionCommand("Cancel");
				buttonPane.add(btnModificar);
				getRootPane().setDefaultButton(btnEliminar);
			}
			{
				JButton btnAtras = new JButton("Atras");
				btnAtras.addActionListener(new AtrasButtonActionListener());
				btnAtras.setActionCommand("Cancel");
				buttonPane.add(btnAtras);
			}
		}
	}
	
	
	private class DeleteButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			int codigoReserva = Integer.parseInt(codigo);
			try {
				controlador.eliminarInvolucra(codigoReserva);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			controlador.eliminarReserva(codigoReserva);
		}
	}

	private class ModifyButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Involucra involucra = new Involucra();
			Reserva reserva = new Reserva();
			Involucra(involucra);
			Reserva(reserva);
			
			java.sql.Date fechaInicioSql = new java.sql.Date(fechaInicio.getTime());
			java.sql.Date fechaFinalSql = new java.sql.Date(fechaFinal.getTime());
			LocalDate inicioReserva = fechaInicioSql.toLocalDate();
			LocalDate finReserva = fechaFinalSql.toLocalDate();

			if(inicioReserva.isBefore(todaysDate)){
				JOptionPane.showMessageDialog(null, "Error: La fecha de inicio de la reserva no puede ser anterior a la fecha de hoy.","Información",JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			if(inicioReserva.isAfter(finReserva)){
				JOptionPane.showMessageDialog(null, "Error: La fecha de fin de la reserva no puede ser anterior a la fecha de inicio.","Información",JOptionPane.INFORMATION_MESSAGE);
				return;
			}

			if(controlador.comprobarDisponibilidadVehiculo(matriculaCoche, fechaInicioSql, fechaFinalSql)==false){
				JOptionPane.showMessageDialog(null, "Lo sentimos, el coche seleccionado no se encuentra disponible para las fechas que usted ha seleccionado.");
			}else {
				int codReserva = reserva.getCodigo();
				controlador.modificarInvolucra(involucra, codReserva);
				controlador.modificarReserva(reserva, codReserva);
			}
			}
		}


	private class AtrasButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			dispose();
			controlador.mostrarF07MasOpcionesReserva();
		}
	}
	
	
	public void mostrarDatos() {
		System.out.println("Código reserva: "+codigoReserva);
		
		Cliente cliente = new Cliente();
		Coche coche = new Coche();
		
		textCodReserva.setEnabled(false);
		int codigo = Integer.parseInt(codigoReserva);
		ReservaCompleta reservaCompleta = new ReservaCompleta();
		controlador.buscarReserva(reservaCompleta, codigo);
		
		String matriculaCoche = reservaCompleta.getMatriculaCoche();
		String marcaCoche = reservaCompleta.getMarcaCoche();
		String modeloCoche = reservaCompleta.getModeloCoche();
		String colorCoche = reservaCompleta.getColorCoche();
		int precioCoche = reservaCompleta.getPrecioCoche();
		String dniCliente = reservaCompleta.getDniCliente();
		String nombreCliente = reservaCompleta.getNombreCliente();
		String codigoReserva = String.valueOf(reservaCompleta.getCodigoReserva());
		String litrosGasolina = String.valueOf(reservaCompleta.getLitrosGasolina());
		String fecInicioReserva = String.valueOf(reservaCompleta.getFecInicioReserva());
		String fecFinalReserva = String.valueOf(reservaCompleta.getFecFinalReserva());
		
		
		cliente.setNif(dniCliente);
		cliente.setNombre(nombreCliente);
		
		coche.setMatricula(matriculaCoche);
		coche.setMarca(marcaCoche);
		coche.setModelo(modeloCoche);
		coche.setColor(colorCoche);
		coche.setPrecio(precioCoche);
		
		
		textFecInicial.setText(fecInicioReserva);
		textFecFinal.setText(fecFinalReserva);
		textCodReserva.setText(codigoReserva);
		textLitros.setText(litrosGasolina);
		comboBox_Clientes.setSelectedItem(cliente);
		comboBox_Coches.setSelectedItem(coche);
		
		System.out.println(cliente);
		System.out.println(coche);
	}
	
	
	private void Reserva(Reserva reserva) {
		int codReserva = Integer.parseInt(textCodReserva.getText());

		modificarFechaInicio();
		modificarFechaFin();

		fechaInicio = convertirFechas.convertirStringDate(fechaInicioModificada);
		fechaFinal = convertirFechas.convertirStringDate(fechaFinModificada);

		reserva.setCodigo(codReserva);
		reserva.setFecInicio(fechaInicio);
		reserva.setFecFinal(fechaFinal);
	}

	private void Involucra(Involucra involucra) {
		String infoCoche = String.valueOf(comboBox_Coches.getSelectedItem());
		String[] arrCoche = infoCoche.split("  ");
		matriculaCoche = arrCoche[0];

		String infoCliente = String.valueOf(comboBox_Clientes.getSelectedItem());
		String[] arrCliente = infoCliente.split("  ");
		nifInvolucra = arrCliente[0];

		int codReserva = Integer.parseInt(textCodReserva.getText());
		litros = Integer.parseInt(textLitros.getText());

		/*System.out.println("MATRÍCULA: "+matriculaCoche);
		System.out.println("DNI CLIENTE: "+nifInvolucra);
		System.out.println("CÓDIGO RESERVA: "+codigoReserva);
		System.out.println("LITROS: "+litros);*/

		involucra.setMatricula(matriculaCoche);
		involucra.setCliente(nifInvolucra);
		involucra.setReserva(codReserva);
		involucra.setLitros(litros);
	}
	
	private void modificarFechaInicio(){
		fechaInicioModificada = textFecInicial.getText();
		String[] arrFecInicial = fechaInicioModificada.split("/");
		String[] arrFecInicialModificado = new String[3];
		System.out.println(arrFecInicial[0]);
		System.out.println(arrFecInicial[1]);
		System.out.println(arrFecInicial[2]);
		int j=0;
		for(int i= arrFecInicial.length-1; i>=0; i--){

			arrFecInicialModificado[j] = arrFecInicial[i];
			j++;
		}

		String diaInicio = String.valueOf(arrFecInicialModificado[2]);
		String mesInicio = String.valueOf(arrFecInicialModificado[1]);
		String anhoInicio = String.valueOf(arrFecInicialModificado[0]);

		fechaInicioModificada = anhoInicio+"-"+mesInicio+"-"+diaInicio;
	}

	private void modificarFechaFin(){
		fechaFinModificada = textFecFinal.getText();
		String[] arrFecFinal = fechaFinModificada.split("/");
		String[] arrFecFinalModificado = new String[3];

		int k=0;
		for(int i=arrFecFinal.length-1; i>=0; i--){
			arrFecFinalModificado[k] = arrFecFinal[i];
			k++;
		}

		String diaFin = String.valueOf(arrFecFinalModificado[2]);
		String mesFin = String.valueOf(arrFecFinalModificado[1]);
		String anhoFin = String.valueOf(arrFecFinalModificado[0]);

		fechaFinModificada = anhoFin+"-"+mesFin+"-"+diaFin;
	}

}
