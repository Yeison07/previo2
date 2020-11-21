package co.ufps.edu.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.ufps.edu.model.TiendaDAO;



/**
 * Servlet implementation class TiendaServlet
 */
@WebServlet(name="CategoriaServlet", urlPatterns= {"/Categoria.do"})
public class TiendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private TiendaDAO tiendaD;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TiendaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
		this.tiendaD=new TiendaDAO();
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
			vistaRegistrar(request,response);
			break;
		case "registrar":
			registrar(request,response);
			break;
	
		}
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nombre=request.getParameter("nombre");
		String lema=request.getParameter("lema");
		String descri=request.getParameter("descri");
		String email=request.getParameter("email");
		String clave=request.getParameter("clave");
		String propietario=request.getParameter("propietario");
		String face=request.getParameter("face");
		String web=request.getParameter("web");
		String imagen=request.getParameter("imagen");
		
	}
	private void vistaRegistrar(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher= request.getRequestDispatcher("vista/registro.jsp");
		dispatcher.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
