package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import modeloVo.Coche;
import modeloVo.Involucra;
import modeloVo.Reserva;
import validaciones.ConvertirFechas;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.awt.event.ActionEvent;

public class Form02NuevaReserva extends JFrame {

	private final JPanel contentPanel = new JPanel();

	LocalDate todaysDate = LocalDate.now();  //Fecha actual del sistema

	Controlador controlador = new Controlador();

	private JTextField textFecInicial;
	private JTextField textFecFinal;
	private JTextField textLitros;
	private JTextField textCodReserva;
	private ModeloComboClientes comboBox_Clientes;
	private ModeloComboCoches comboBox_Coches;

	private int codigoReserva;
	private Date fechaInicio;
	private Date fechaFinal;
	private int litros;

	private String fechaInicioModificada;
	private String fechaFinModificada;

	private String dniCliente;
	private String matriculaCoche;
	private Date fecInicioCancelar;
	private Date fecFinalCancelar;
	private String nifInvolucra;
	private String fechaInicioModificadaCanc;
	private String fechaFinModificadaCanc;

	ConvertirFechas convertirFechas = new ConvertirFechas();

	private JTextField textField_nif_cliente;
	private JTextField textField_Fecha_Inicio;
	private JTextField textField_Matricula_Coche;
	private JTextField textField_fecha_final;

	private int codigoReservaCancelar;
	
	
	private boolean fechaInicioCorrecta = false;
	private boolean fechaFinCorrecta = false;
	
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

	public static void main(String[] args) {
		try {
			Form02NuevaReserva frame = new Form02NuevaReserva();
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Form02NuevaReserva() {
		System.out.println(todaysDate);
		setTitle("Nueva Reserva");
		setBounds(100, 100, 869, 330);
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
				JButton okButton = new JButton("Efectuar Reserva");
				okButton.addActionListener(new OkButtonActionListener());
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
			}
			{
				JButton btnAtras = new JButton("Atras");
				btnAtras.addActionListener(new AtrasButtonActionListener());
				btnAtras.setActionCommand("Cancel");
				buttonPane.add(btnAtras);
			}
			JButton btnMasOpcionesReserva = new JButton("Mas Opciones");
			btnMasOpcionesReserva.addActionListener(new MasOpcionesButtonActionListener());
			btnMasOpcionesReserva.setBounds(700, 22, 130, 25);
			contentPanel.add(btnMasOpcionesReserva);
		}
	}

	private class OkButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
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
			
			Reserva reserva = new Reserva();
			Involucra involucra = new Involucra();
			Reserva(reserva);
			Involucra(involucra);

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
				return;
			}else {
				codigoReserva = reserva.getCodigo();
				Date inicio = reserva.getFecInicio();
				Date fin = reserva.getFecFinal();
				controlador.insertarReserva(reserva, codigoReserva);
				controlador.insertarInvolucra(involucra, codigoReserva);
				controlador.reservarCoche(inicio, fin, matriculaCoche);
				Form07MasOpcionesReserva masOpcionesReservas;
				try {
					masOpcionesReservas = new Form07MasOpcionesReserva();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}


	private class AtrasButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			dispose();
			try {
				controlador.mostrarF01Inicial();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private class MasOpcionesButtonActionListener implements ActionListener {
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

	
	private void Reserva(Reserva reserva) {
		codigoReserva = Integer.parseInt(textCodReserva.getText());

		modificarFechaInicio();
		modificarFechaFin();

		fechaInicio = convertirFechas.convertirStringDate(fechaInicioModificada);
		fechaFinal = convertirFechas.convertirStringDate(fechaFinModificada);

		reserva.setCodigo(codigoReserva);
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

		codigoReserva = Integer.parseInt(textCodReserva.getText());
		litros = Integer.parseInt(textLitros.getText());

		involucra.setMatricula(matriculaCoche);
		involucra.setCliente(nifInvolucra);
		involucra.setReserva(codigoReserva);
		involucra.setLitros(litros);
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
