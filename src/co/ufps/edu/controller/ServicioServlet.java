package co.ufps.edu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.ufps.edu.model.Servicio;
import co.ufps.edu.model.ServicioDAO;
import co.ufps.edu.model.Tienda;
import co.ufps.edu.model.TiendaDAO;


/**
 * Servlet implementation class ServicioServlet
 */
@WebServlet(name="ServicioServlet", urlPatterns= {"/Home"})
public class ServicioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ServicioDAO servicioD;
	TiendaDAO tiendaD;
	
       
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
 		this.tiendaD=new TiendaDAO();
 	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action= (request.getParameter("action") != null) ? request.getParameter("action"):"Home";
		System.out.println(action);
		
		switch (action) {
		case "/Home":
			listarS(request,response);
			break;
		case "tiendaServicios":
			tiendaServicios(request,response);
			break;
		default:
			listarS(request,response);
	
		}
			
		
	}

	
	
	private void tiendaServicios(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		Tienda tienda = tiendaD.selectById(id);

		List <Servicio> listServicio = tienda.getServicios();
		request.setAttribute("servicio", listServicio);
		request.setAttribute("tienda", tienda); 
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("vista/servicios.jsp");
		dispatcher.forward(request, response);

	}

	private void listarS(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List <Servicio> listServicio = servicioD.selectAll();
		request.setAttribute("servicio", listServicio);
		
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("index.jsp");
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
