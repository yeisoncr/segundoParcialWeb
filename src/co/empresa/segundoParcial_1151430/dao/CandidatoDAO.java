package co.empresa.segundoParcial_1151430.dao;

import java.sql.SQLException;
import java.util.List;

import co.empresa.segundoParcial_1151430.modelo.Candidato;



public interface CandidatoDAO {
	public void insert(Candidato candidato) throws SQLException;

	public void delete(int id) throws SQLException;

	public void update(Candidato candidato) throws SQLException;

	public List<Candidato> selectAll();

	public Candidato  select (int id);

}
