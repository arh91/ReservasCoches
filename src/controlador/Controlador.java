package controlador;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

import java.sql.Date;

import modeloDao.ClienteDao;
import modeloDao.CocheDao;
import modeloDao.InvolucraDao;
import modeloDao.ReservaDao;
import modeloVo.Cliente;
import modeloVo.Coche;
import modeloVo.FilaCliente;
import modeloVo.FilaReserva;
import modeloVo.Involucra;
import modeloVo.Reserva;
import modeloVo.ReservaCompleta;
import vista.*;

public class Controlador {
	
	Form01Inicial inicio;
	Form02NuevaReserva nuevaReserva;
	Form03ListadoReservas listaReservas;
	Form04Cliente clientes;
	Form05ListadoClientes listaClientes;
	Form06MasOpcionesCliente masOpcionesCliente;
	Form07MasOpcionesReserva masOpcionesReserva;
	Form10HistorialReservas historialReservas;
	Form11DetallesReserva detallesReserva;
	
	ClienteDao clienteDao = new ClienteDao();
	CocheDao cocheDao = new CocheDao();
	ReservaDao reservaDao = new ReservaDao();
	InvolucraDao involucraDao = new InvolucraDao();
	
	
	public void setInicio (Form01Inicial inicio) {
		this.inicio = inicio;
	}
	
	public void setNuevaReserva (Form02NuevaReserva nuevaReserva) {
		this.nuevaReserva = nuevaReserva;
	}
	
	public void setListadoReservas (Form03ListadoReservas listaReservas) {
		this.listaReservas = listaReservas;
	}
	
	public void setCliente (Form04Cliente clientes) {
		this.clientes = clientes;
	}
	
	public void setListadoClientes (Form05ListadoClientes listaClientes) {
		this.listaClientes = listaClientes;
	}
	
	public void setMasOpcionesCliente(Form06MasOpcionesCliente masOpcionesCliente) {
		this.masOpcionesCliente = masOpcionesCliente;
	}

	public void setMasOpcionesReserva(Form07MasOpcionesReserva masOpcionesReserva){
		this.masOpcionesReserva = masOpcionesReserva;
	}

	public void setHistorialReservas(Form10HistorialReservas historialReservas) { 
		this.historialReservas = historialReservas;
	}

	public void setDetallesReserva(Form11DetallesReserva detallesReserva) { 
		this.detallesReserva = detallesReserva;}

	/*public void setClienteDao (ClienteDao clienteDao) {
		this.clienteDao = clienteDao;
	}
	
	public void setCocheDao (CocheDao cocheDao) {
		this.cocheDao = cocheDao;
	}
	
	public void setReservaDao (ReservaDao reservaDao) {
		this.reservaDao = reservaDao;
	}
	
	public void setInvolucraDao(InvolucraDao involucraDao) {
		this.involucraDao = involucraDao;
	}*/
	
	////////////////////////////////////////////////////////////////////////////////////
	
	public void mostrarF01Inicial() {
		inicio.setVisible(true);
	}
	
	public void mostrarF02NuevaReserva() {
		nuevaReserva.setVisible(true);
	}
	
	public void mostrarF03ListadoReservas() {
		listaReservas.setVisible(true);
	}
	
	public void mostrarF04Clientes() {
		clientes.setVisible(true);
	}
	
	public void mostrarF05ListadoClientes() {
		listaClientes.setVisible(true);
	}
	
	public void mostrarF06MasOpcionesCliente() {
		masOpcionesCliente.setVisible(true);
	}

	public void mostrarF07MasOpcionesReserva(){
		masOpcionesReserva.setVisible(true);
	}

	public void mostrarF10HistorialReservas() { 
		historialReservas.setVisible(true); 
	}

	public void mostrarF11DetallesReserva(String codigo) {
		detallesReserva = new Form11DetallesReserva(codigo);
		detallesReserva.setVisible(true); 
	}

	
	///////////////////////////////////////////////////////////////////////

	public void insertarCliente(Cliente cliente, String codigo) {
		clienteDao.insertarCliente(cliente, codigo);
	}
	
	public void buscarCliente(Cliente cliente, String codigo) {
		clienteDao.buscarCliente(cliente, codigo);
	}
	
	public void cargarListaClientes(DefaultListModel clientesListModel) {
		clienteDao.cargarListaClientes(clientesListModel);
	}
	
	public void eliminarCliente(String codigo) {
		clienteDao.eliminarCliente(codigo);
	}
	
	public void modificarCliente(Cliente cliente, String codigo) {
		clienteDao.modificarCliente(cliente, codigo);
	}
	
	public void obtenerDireccionesClientes(ArrayList<String> list) {
		clienteDao.obtenerDireccionesClientes(list);
	}
	
	public void insertarReserva(Reserva reserva, int codigo) {
		reservaDao.insertarReserva(reserva, codigo);
	}

	public void eliminarReserva(int codigo){
		reservaDao.eliminarReserva(codigo);
	}

	public void buscarReserva(ReservaCompleta reservaCompleta, int codigo){
		reservaDao.buscarReserva(reservaCompleta, codigo);
	}
	
	public void cargarListaReservas(DefaultListModel reservasListModel) {
		reservaDao.cargarListaReservas(reservasListModel);
	}

	public void modificarReserva(Reserva reserva, int codigo){
		reservaDao.modificarReserva(reserva, codigo);
	}

	public void eliminarReservasAntiguas() throws SQLException { reservaDao.eliminarReservasAntiguas();}

	public void moverAHistorial() throws SQLException { reservaDao.moverAHistorial();}

	public boolean existeMatriculaCoche(String codigo){
		return cocheDao.existeMatriculaCoche(codigo);
	}
	
	public boolean comprobarDisponibilidadVehiculo(String matricula, Date inicioReserva, Date finReserva) {
		return reservaDao.comprobarDisponibilidadVehiculo(matricula, inicioReserva, finReserva);
	}

	public boolean existeCliente(String codigo){
		return involucraDao.existeCliente(codigo);
	}

	public boolean existeCoche(String codigo){
		return involucraDao.existeCoche(codigo);
	}

	public void insertarInvolucra(Involucra involucra, int codigoReserva) {
		involucraDao.insertarInvolucra(involucra, codigoReserva);
	}

	public void eliminarInvolucra(int codigo) throws SQLException {
		involucraDao.eliminarInvolucra(codigo);
	}
	
	public void modificarInvolucra(Involucra involucra, int codigo) {
		involucraDao.modificarInvolucra(involucra, codigo);
	}

	public void obtenerCodigoReserva(Involucra involucra, String matricula){
		involucraDao.obtenerCodigoReserva(involucra, matricula);
	}
	///////////////////////////////////////////////////////////////////////
	
	
	public ArrayList<FilaCliente> cargarClientesPorLocalidad(String localidad){
		return clienteDao.cargarClientesPorLocalidad(localidad);
	}

	public ArrayList<FilaReserva> ReservasMes(int mes) {
		return reservaDao.ReservasMes(mes);
	}
	
	public ArrayList<FilaReserva> HistorialReservasMes(int mes, int anho){
		return reservaDao.HistorialReservasMes(mes, anho);
	}

	public ArrayList<Cliente> cargarClientes(){
		return clienteDao.cargarClientes();
	}
	
	public ArrayList<Coche> cargarCoches(){
		return cocheDao.cargarCoches();
	}

}
