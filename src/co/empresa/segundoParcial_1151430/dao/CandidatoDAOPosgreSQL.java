package co.empresa.segundoParcial_1151430.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.empresa.segundoParcial_1151430.modelo.Candidato;
import co.empresa.segundoParcial_1151430.util.Conexion;

public class CandidatoDAOPosgreSQL implements CandidatoDAO {
	
	private Conexion conexion; 
	private static final String INSERT_CANDIDATO_SQL = "INSERT INTO candidato ( documento,nombre, apellido,numero) VALUES (?,?,?,?);";
	private static final String DELETE_CANDIDATO_SQL = "DELETE FROM candidato WHERE id = ? ;";
	private static final String UPDATE_CANDIDATO_SQL = "UPDATE  candidato SET  nombre = ?, apellido = ?, documento = ?,numero  = ? WHERE id = ?;";
	private static final String SELECT_CANDIDATO_ID = "SELECT * FROM candidato WHERE id = ?;";
	private static final String SELECT_ALL_CANDIDATO = "SELECT * FROM candidato;"; 
	
	public CandidatoDAOPosgreSQL() {
		this.conexion = Conexion.getConexion();
		
	}
	

	public void insert(Candidato candidato) throws SQLException {
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(INSERT_CANDIDATO_SQL);
			preparedStatement.setString(1, candidato.getNombre());
			preparedStatement.setString(2, candidato.getApellido());
			preparedStatement.setString(3, candidato.getDocumento());
			preparedStatement.setInt(4, candidato.getNumero());

			conexion.execute();			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
	}
	
	public void delete(int id) throws SQLException {
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(DELETE_CANDIDATO_SQL);
			preparedStatement.setInt(1, id);

			conexion.execute();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	public void update(Candidato candidato )  throws SQLException {
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(UPDATE_CANDIDATO_SQL);
			preparedStatement.setString(1, candidato.getNombre());
			preparedStatement.setString(2, candidato.getApellido());
			preparedStatement.setString(3, candidato.getDocumento());
			preparedStatement.setInt(4, candidato.getNumero());
			preparedStatement.setInt(5, candidato.getId());
			
			conexion.execute();			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	
	public List<Candidato> selectAll() {
		List<Candidato> candidato = new ArrayList<>();
		try {
			conexion.setPreparedStatement(SELECT_ALL_CANDIDATO);
			
			ResultSet rs = conexion.query();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String apellido = rs.getNString("apellido");
				String documento = rs.getString("documento");
				int numero = rs.getInt("numero");
				
				candidato.add(new Candidato(id,nombre,apellido,documento,numero));
				
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return candidato;
		
	}
	
	public Candidato select(int id) {
		Candidato candidato = null;
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(SELECT_CANDIDATO_ID);
			preparedStatement.setInt(1, id);
			
			ResultSet rs = conexion.query();
			
			while(rs.next()) {
				String nombre = rs.getString("nombre");
				String apellido = rs.getNString("apellido");
				String documento = rs.getString("documento");
				int numero = rs.getInt("numero");
				
				candidato = new Candidato(id,nombre,apellido,documento,numero);
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return candidato;
		
	}
	

}
