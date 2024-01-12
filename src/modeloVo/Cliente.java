package modeloVo;

import java.util.Objects;

public class Cliente {
	
	private String nif;
	private String nombre;
	private String direccion;
	private int telefono;
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cliente(String nif, String nombre, String direccion, int telefono) {
		super();
		this.nif = nif;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(nif, nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(nif, other.nif) && Objects.equals(nombre, other.nombre);
	}
	
	
	@Override
	public String toString() {
		return  nif+"  "+nombre+"  ";
	}
	
	

}
