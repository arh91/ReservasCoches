package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

	private int codReserva;
	private Date fechaInicio;
	private Date fechaFinal;
	private int litros;
	
	//Variables datos iniciales
	private String codigoReserva;
	private String fecInicioReserva;
	private String fecFinalReserva;
	private String litrosGasolina;
	private Cliente item_cliente;
	private Coche item_coche;
	
	//Variables datos modificados
	private String codigoReservaNuevo;
	private String fecInicioReservaNuevo;
	private String fecFinalReservaNuevo;
	private String litrosGasolinaNuevo;
	private Cliente item_cliente_nuevo;
	private Coche item_coche_nuevo;
	
	private String matriculaCoche;
	private String nifInvolucra;
	private int codReservaInvolucra;
	
	private String fecha;
	private String fechaFinModificada;
	
	private boolean datosSinModificar = false;
	private boolean fechaInicioCorrecta = false;
	private boolean fechaFinCorrecta = false;
	
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
		setBounds(100, 100, 869, 455);
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
				JButton btnEliminar = new JButton("Cancelar Reserva");
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
		    textCodReserva.setText(codigoReserva);
			int codigo = Integer.parseInt(codigoReserva);
			try {
				controlador.eliminarInvolucra(codigo);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			controlador.eliminarReserva(codigo);
		}
	}

	private class ModifyButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			comprobarDatosModificados();
			if(datosSinModificar) {
				JOptionPane.showMessageDialog(null, "No se ha modificado ningún dato.","Información",JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			
			if(textFecInicial.getText().isEmpty() || textFecFinal.getText().isEmpty() || textCodReserva.getText().isEmpty() || textLitros.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "Por favor, rellene todos los campos del panel.","Información",JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			
			if (validarFormatoFecha(textFecInicial.getText(), "dd/MM/yyyy")) {
	            fechaInicioCorrecta = true;
	        } else {
	        	JOptionPane.showMessageDialog(null, "La fecha de inicio de reserva introducida no tiene el formato correcto de día/mes/año.","Información",JOptionPane.INFORMATION_MESSAGE);
	            return;
	        }
			
			if (validarFormatoFecha(textFecFinal.getText(), "dd/MM/yyyy")) {
	            fechaFinCorrecta = true;
	        } else {
	        	JOptionPane.showMessageDialog(null, "La fecha de fin de reserva introducida no tiene el formato correcto de día/mes/año.","Información",JOptionPane.INFORMATION_MESSAGE);
	            return;
	        }
			
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
				textFecInicial.setText(fecInicioReserva);
				textFecFinal.setText(fecFinalReserva);
				return;
			}
			if(inicioReserva.isAfter(finReserva)){
				JOptionPane.showMessageDialog(null, "Error: La fecha de fin de la reserva no puede ser anterior a la fecha de inicio.","Información",JOptionPane.INFORMATION_MESSAGE);
				textFecInicial.setText(fecInicioReserva);
				textFecFinal.setText(fecFinalReserva);
				return;
			}

			if(controlador.comprobarDisponibilidadVehiculoModificar(matriculaCoche, fechaInicioSql, fechaFinalSql, codReserva)==false){
				JOptionPane.showMessageDialog(null, "Lo sentimos, el coche seleccionado no se encuentra disponible para las fechas que usted ha seleccionado.");
				textFecInicial.setText(fecInicioReserva);
				textFecFinal.setText(fecFinalReserva);
				return;
			}else {
				int codReserva = reserva.getCodigo();
				Date inicio = reserva.getFecInicio();
				Date fin = reserva.getFecFinal();
				controlador.modificarInvolucra(involucra, codReserva);
				controlador.modificarReserva(reserva, codReserva);
				controlador.reservarCoche(inicio, fin, matriculaCoche);
			}
		}
	}


	private class AtrasButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			dispose();
			try {
				controlador.mostrarF07MasOpcionesReserva();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public void mostrarDatos() {
		System.out.println("Código reserva: "+codigoReserva);
		
		Cliente cliente = new Cliente();
		Coche coche = new Coche();
		
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
		codigoReserva = String.valueOf(reservaCompleta.getCodigoReserva());
		litrosGasolina = String.valueOf(reservaCompleta.getLitrosGasolina());
		fecInicioReserva = String.valueOf(reservaCompleta.getFecInicioReserva());
		fecFinalReserva = String.valueOf(reservaCompleta.getFecFinalReserva());
		
		modificarFechaInicioCapturada();
		modificarFechaFinCapturada();
		
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
		
		for (int i = 0; i < comboBox_Clientes.getItemCount(); i++) {
		    item_cliente = comboBox_Clientes.getItemAt(i);
		    if(item_cliente.equals(cliente)) {
		    	comboBox_Clientes.setSelectedItem(item_cliente);
		    	break;
		    }
		}
		
		for (int i = 0; i < comboBox_Coches.getItemCount(); i++) {
		    item_coche = comboBox_Coches.getItemAt(i);
		    if(item_coche.equals(coche)) {
		    	comboBox_Coches.setSelectedItem(item_coche);
		    	break;
		    }
		}
		
		
		System.out.println(cliente);
		System.out.println(coche);
	}
	
	
	private void Reserva(Reserva reserva) {
		textCodReserva.setText(codigoReserva);
		codReserva = Integer.parseInt(textCodReserva.getText());

		modificarFechaInicio();
		modificarFechaFin();

		fechaInicio = convertirFechas.convertirStringDate(fecha);
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

		codReservaInvolucra = Integer.parseInt(textCodReserva.getText());
		litros = Integer.parseInt(textLitros.getText());

		/*System.out.println("MATRÍCULA: "+matriculaCoche);
		System.out.println("DNI CLIENTE: "+nifInvolucra);
		System.out.println("CÓDIGO RESERVA: "+codigoReserva);
		System.out.println("LITROS: "+litros);*/

		involucra.setMatricula(matriculaCoche);
		involucra.setCliente(nifInvolucra);
		involucra.setReserva(codReservaInvolucra);
		involucra.setLitros(litros);
	}
	
	private void modificarFechaInicio(){
		fecha = textFecInicial.getText();
		String[] arrFecInicial = fecha.split("/");
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

		fecha = anhoInicio+"-"+mesInicio+"-"+diaInicio;
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
	
	private void modificarFechaInicioCapturada(){
		String[] arrFecInicial = fecInicioReserva.split("-");
		String[] arrFecInicialModificado = new String[3];
		
		int j=0;
		for(int i= arrFecInicial.length-1; i>=0; i--){

			arrFecInicialModificado[j] = arrFecInicial[i];
			j++;
		}

		String diaInicio = String.valueOf(arrFecInicialModificado[0]);
		String mesInicio = String.valueOf(arrFecInicialModificado[1]);
		String anhoInicio = String.valueOf(arrFecInicialModificado[2]);

		fecInicioReserva = diaInicio+"/"+mesInicio+"/"+anhoInicio;
	}

	private void modificarFechaFinCapturada(){
		String[] arrFecFinal = fecFinalReserva.split("-");
		String[] arrFecFinalModificado = new String[3];

		int k=0;
		for(int i=arrFecFinal.length-1; i>=0; i--){
			arrFecFinalModificado[k] = arrFecFinal[i];
			k++;
		}

		String diaFin = String.valueOf(arrFecFinalModificado[0]);
		String mesFin = String.valueOf(arrFecFinalModificado[1]);
		String anhoFin = String.valueOf(arrFecFinalModificado[2]);

		fecFinalReserva = diaFin+"/"+mesFin+"/"+anhoFin;
	}
	
	
	private void comprobarDatosModificados() {
		codigoReservaNuevo = textCodReserva.getText();
		fecInicioReservaNuevo = textFecInicial.getText();
		fecFinalReservaNuevo = textFecFinal.getText();
		litrosGasolinaNuevo = textLitros.getText();
		item_cliente_nuevo = (Cliente) comboBox_Clientes.getSelectedItem();
		item_coche_nuevo = (Coche) comboBox_Coches.getSelectedItem();
		
		if(codigoReservaNuevo.equals(codigoReserva) && fecInicioReservaNuevo.equals(fecInicioReserva) && fecFinalReservaNuevo.equals(fecFinalReserva) && litrosGasolinaNuevo.equals(litrosGasolina) && item_cliente.equals(item_cliente_nuevo) && item_coche.equals(item_coche_nuevo)) {
			datosSinModificar = true;
		}
	}
	
	
	public static boolean validarFormatoFecha(String fecha, String formato) {
        SimpleDateFormat sdf = new SimpleDateFormat(formato);
        sdf.setLenient(false);

        try {
            Date date = sdf.parse(fecha);
            // Si no ocurre una excepción, significa que la cadena tiene el formato correcto
            return true;
        } catch (ParseException e) {
            // La excepción indica que la cadena no tiene el formato correcto
            return false;
        }
    }


}
