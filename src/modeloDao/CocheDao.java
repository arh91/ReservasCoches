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
	
	
	public void reservarCoche(Date fecInicio, Date fecFin, String matricula) {
		LocalDate fechaActual = LocalDate.now();
		
		java.sql.Date fecActualSql = java.sql.Date.valueOf(fechaActual);
		java.sql.Date fecInicioSql = new java.sql.Date(fecInicio.getTime());
		java.sql.Date fecFinSql = new java.sql.Date(fecFin.getTime());
		
		Conexion conexion = null;
			
		String consulta = "UPDATE coches SET coDisponible= "
				+ "(CASE "
				+ "WHEN ? BETWEEN ? AND ? THEN 0"
				+ " ELSE 1"
				+ " END)"
				+ " WHERE coMatricula = ?";
				
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

}
