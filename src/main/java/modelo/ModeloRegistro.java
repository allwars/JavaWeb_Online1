package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Conexion.Conexion;
import entidad.registrousuario;

public class ModeloRegistro {	
	public registrousuario iniciarRegistro(String nombre, String clave) {
		registrousuario registrousuario = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			cn = Conexion.getConexion();
			String sql = "INSERT INTO usuario (nombre, clave) VALUES (?,?)";
			
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, nombre);
			pstm.setString(2, clave);
			int rtdo = pstm.executeUpdate();
			
			
			
			if (rtdo == 1) {
				System.out.println("Fila insertada: "+nombre+ " "+clave );
			}else {
				throw new RuntimeException("No se pudo insertar");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				
				if (pstm != null) {
					pstm.close();
				}
				
				if (cn != null) {
					cn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return registrousuario;
	}
}