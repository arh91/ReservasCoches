package modeloVo;

import java.util.Date;

public class ReservaCompleta {
	private String matriculaCoche;
	private String dniCliente;
	private String nombreCliente;
	private int codigoReserva;
	private int litrosGasolina;
	private Date fecInicioReserva;
	private Date fecFinalReserva;
	private String marcaCoche;
	private String modeloCoche;
	private String colorCoche;
	private int precioCoche;
	
	
	public ReservaCompleta() {
		super();
	}
	
	public ReservaCompleta(String matriculaCoche, String dniCliente, String nombreCliente, int codigoReserva, int litrosGasolina,
			Date fecInicioReserva, Date fecFinalReserva, String marcaCoche, String modeloCoche, String colorCoche,
			int precioCoche) {
		super();
		this.matriculaCoche = matriculaCoche;
		this.dniCliente = dniCliente;
		this.nombreCliente = nombreCliente;
		this.codigoReserva = codigoReserva;
		this.litrosGasolina = litrosGasolina;
		this.fecInicioReserva = fecInicioReserva;
		this.fecFinalReserva = fecFinalReserva;
		this.marcaCoche = marcaCoche;
		this.modeloCoche = modeloCoche;
		this.colorCoche = colorCoche;
		this.precioCoche = precioCoche;
	}
	
	
	public String getMatriculaCoche() {
		return matriculaCoche;
	}
	
	public void setMatriculaCoche(String matriculaCoche) {
		this.matriculaCoche = matriculaCoche;
	}
	
	public String getDniCliente() {
		return dniCliente;
	}

	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}
	
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	
	public int getCodigoReserva() {
		return codigoReserva;
	}
	
	public void setCodigoReserva(int codigoReserva) {
		this.codigoReserva = codigoReserva;
	}
	
	public int getLitrosGasolina() {
		return litrosGasolina;
	}
	
	public void setLitrosGasolina(int litrosGasolina) {
		this.litrosGasolina = litrosGasolina;
	}
	
	public Date getFecInicioReserva() {
		return fecInicioReserva;
	}
	
	public void setFecInicioReserva(Date fecInicioReserva) {
		this.fecInicioReserva = fecInicioReserva;
	}
	
	public Date getFecFinalReserva() {
		return fecFinalReserva;
	}
	
	public void setFecFinalReserva(Date fecFinalReserva) {
		this.fecFinalReserva = fecFinalReserva;
	}
	
	public String getMarcaCoche() {
		return marcaCoche;
	}
	
	public void setMarcaCoche(String marcaCoche) {
		this.marcaCoche = marcaCoche;
	}
	
	public String getModeloCoche() {
		return modeloCoche;
	}
	
	public void setModeloCoche(String modeloCoche) {
		this.modeloCoche = modeloCoche;
	}
	
	public String getColorCoche() {
		return colorCoche;
	}
	
	public void setColorCoche(String colorCoche) {
		this.colorCoche = colorCoche;
	}
	
	public int getPrecioCoche() {
		return precioCoche;
	}
	
	public void setPrecioCoche(int precioCoche) {
		this.precioCoche = precioCoche;
	}
	
	
	
	/*public Reserva() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reserva(int codigo, Date fecInicio, Date fecFinal) {
		super();
		this.codigoReserva = codigo;
		this.fecInicioReserva = fecInicio;
		this.fecFinalReserva = fecFinal;
	}
	
	
	public int getCodigo() {
		return codigoReserva;
	}
	public void setCodigo(int codigo) {
		this.codigoReserva = codigo;
	}
	public Date getFecInicio() {
		return fecInicioReserva;
	}
	public void setFecInicio(Date fecInicio) {
		this.fecInicioReserva = fecInicio;
	}
	public Date getFecFinal() {
		return fecFinalReserva;
	}
	public void setFecFinal(Date fecFinal) {
		this.fecFinalReserva = fecFinal;
	}*/
	
	

}

