package co.empresa.segundoParcial_1151430.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import co.empresa.segundoParcial_1151430.dao.CandidatoDAO;
import co.empresa.segundoParcial_1151430.modelo.Candidato;


@WebServlet("/CandidatoServlet")
public class CandidatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	private CandidatoDAO candidatoDAO;
	
    public CandidatoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		
		try {
			switch(action) {
				case "/new":
					verNuevoForm(request, response); 
					break;
				case "/insert":
					insertarCandidato(request, response);
					break;
				case "/delete":
					eliminarCandidato(request, response);
					break;
				case "/edit":
					verFormularioEdicion(request, response);
					break;
				case "/update":
					actualizarCandidato(request, response);
					break;
				default:
					listCandidato(request,response);
					break;
			}
		}catch(SQLException e){
			throw new ServletException(e);
			
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void verNuevoForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("candidato.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void insertarCandidato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException {
		
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String documento = request.getParameter("documento");
		int numero = Integer.parseInt(request.getParameter("numero"));
		
		Candidato  candidato = new Candidato(nombre,apellido,documento,numero);
		
		candidatoDAO.insert(candidato);
	
		response.sendRedirect("list");
	}
	

	private void verFormularioEdicion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		
		Candidato candidatoActual = candidatoDAO.select(id); 
		
		request.setAttribute("usuario", candidatoActual);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("candidato.jsp");
		dispatcher.forward(request, response);
	}
	
	private void actualizarCandidato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String documento = request.getParameter("documento");
		int numero = Integer.parseInt(request.getParameter("numero"));
		
		Candidato  candidato = new Candidato(id, nombre, apellido, documento,numero);
		
		candidatoDAO.update(candidato);
		
	
		response.sendRedirect("list");
	}
	
	private void eliminarCandidato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));

		candidatoDAO.delete(id);
		
	
		response.sendRedirect("list");
	}
	
	private void listCandidato(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		List <Candidato> listCandidatos = candidatoDAO.selectAll();
		request.setAttribute("listCandidato", listCandidatos);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("FormCandidatos.jsp");
		dispatcher.forward(request, response);
		
	}

}
