package modeloDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import conexion.Conexion;
import modeloVo.Cliente;
import modeloVo.Coche;


public class CocheDao {

	public ArrayList<Coche> cargarCoches() {
		Conexion conexion = new Conexion();
		
		String consulta = "SELECT * FROM Coches Order BY coMarca, coMatricula";
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList <Coche> coches = new ArrayList<Coche>();
		try {
			ps = conexion.getConnection().prepareStatement(consulta);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Coche coch = new Coche();
				coch.setMatricula(rs.getString(1));
				coch.setMarca(rs.getString(2));
				coch.setModelo(rs.getString(3));
				coch.setColor(rs.getString(4));
				coch.setPrecio(rs.getInt(5));
				coch.setDisponible(rs.getBoolean(6));
				coch.setGaraje(rs.getInt(7));
				
				coches.add(coch);
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		conexion.desconectar();
		return coches;
	}
	

	public boolean existeMatriculaCoche(String codigo){
		boolean existe = false;
		Conexion conex= new Conexion();
		String comprobarCodigosBD = "SELECT * FROM coches WHERE coMatricula = ?";

		try {
				PreparedStatement ps = conex.getConnection().prepareStatement(comprobarCodigosBD);
				ps.setString(1, codigo);
				ResultSet resultSet=ps.executeQuery();
				if(resultSet.next()) {
					existe = true;
				} else {
					existe = false;
				}
		} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		return existe;
	}


	/*public void preguntarDisponibilidadCoche(String codigo, Coche coche) {
		String valor;
		Conexion conex = new Conexion();
		boolean existe = false;
		try {
			String consulta = "SELECT coDisponible FROM coches WHERE coMatricula = ?";
			PreparedStatement ps = conex.getConnection().prepareStatement(consulta);
			ps.setString(1, codigo);
			ResultSet res = ps.executeQuery();
			while(res.next()){
				existe=true;
				coche.setDisponible(res.getBoolean(6));
			}
			res.close();
			conex.desconectar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}*/

	/*public void preguntarDisponibilidadCoche(Date fecInicio, Date fecFin) {
		String valor;
		Conexion conex = new Conexion();
		boolean existe = false;
		try {
			String consulta = "SELECT coDisponible FROM coches WHERE coMatricula = ?";
			PreparedStatement ps = conex.getConnection().prepareStatement(consulta);
			ps.setString(1, codigo);
			ResultSet res = ps.executeQuery();
			while(res.next()){
				existe=true;
				coche.setDisponible(res.getBoolean(6));
			}
			res.close();
			conex.desconectar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
	}*/
	
	
	public void reservarCoche(Date fecInicio, Date fecFin, String matricula) {
		LocalDate fechaActual = LocalDate.now();
		
		java.sql.Date fecActualSql = java.sql.Date.valueOf(fechaActual);
		java.sql.Date fecInicioSql = new java.sql.Date(fecInicio.getTime());
		java.sql.Date fecFinSql = new java.sql.Date(fecFin.getTime());
		
		/*String fecActual = String.valueOf(fechaActual);
		String[] arrFechaActual = fecActual.split("-");
		ArrayList<String> fechaOrdenada = new ArrayList<String>();
		String elemento;
		for(int i=arrFechaActual.length-1;i>=0;i--) {
			elemento = arrFechaActual[i];
			fechaOrdenada.add(elemento);
		}*/
		
		Conexion conexion = null;
		
		
		String consulta = "UPDATE coches SET coDisponible= "
				+ "(CASE "
				+ "WHEN ? BETWEEN ? AND ? THEN 0"
				+ " ELSE 1"
				+ " END)"
				+ " WHERE coMatricula = ?";
		
		/*String consulta = "UPDATE coches SET coDisponible = 0 "+
		"JOIN Involucra ON coMatricula = inMatricula "+
		"JOIN Reservas ON inReserva = reCodigo "+
		"WHERE coMatricula = ? "+
		"BETWEEN ? AND ?";*/
		
		PreparedStatement ps = null;
		
		try {
			conexion = new Conexion();
			ps = conexion.getConnection().prepareStatement(consulta);
			
			ps.setDate(1,  fecActualSql);
			ps.setDate(2,  fecInicioSql);
			ps.setDate(3, fecFinSql);
			ps.setString(4, matricula);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null) {
					ps.close();
				}
				if (conexion!=null){
					conexion.desconectar();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}


	public void liberarCoche(String cadena) {
		Conexion conexion = null;
		String consulta = "UPDATE coches SET coDisponible= 1"
				+ " WHERE coMatricula = ?";
		PreparedStatement ps = null;
		try {
			conexion = new Conexion();
			ps = conexion.getConnection().prepareStatement(consulta);
			ps.executeUpdate();
		} catch (SQLException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null) {
					ps.close();
				}
				if (conexion!=null){
					conexion.desconectar();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
