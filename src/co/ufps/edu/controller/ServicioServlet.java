package co.ufps.edu.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.ufps.edu.model.ServicioDAO;
import co.ufps.edu.model.TiendaDAO;

/**
 * Servlet implementation class ServicioServlet
 */
@WebServlet(name="ServicioServlet", urlPatterns= {"/Servicio.do"})
public class ServicioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ServicioDAO servicioD;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServicioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig config) throws ServletException {
 		// TODO Auto-generated method stub
 		
 		this.servicioD=new ServicioDAO();
 	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action= (request.getParameter("action") != null) ? request.getParameter("action"):"list";
		System.out.println(action);
		
		switch (action) {
		case "vistaRegistro":
			vista(request,response);
			break;
		}
	}

	private void vista(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
