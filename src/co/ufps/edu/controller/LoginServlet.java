package co.ufps.edu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.ufps.edu.model.Cliente;
import co.ufps.edu.model.ClienteDAO;
import co.ufps.edu.model.Tienda;
import co.ufps.edu.model.TiendaDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name="LoginServlet", urlPatterns= {"/Login.do"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  ClienteDAO clienteD;
	private TiendaDAO tiendaD;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig config) throws ServletException {
 		// TODO Auto-generated method stub
 		
 		this.clienteD=new ClienteDAO();
 		this.tiendaD= new TiendaDAO();
 	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action= (request.getParameter("action") != null) ? request.getParameter("action"):"list";
		System.out.println(action);
		
		switch (action) {
		case "vistaLogin":
			vistaLogin(request,response);
			break;
		case "login":
			login(request,response);
			break;
	
		}
	}
	
	private void vistaLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher= request.getRequestDispatcher("vista/login.jsp");
		dispatcher.forward(request, response);
		
		
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=request.getParameter("email");
		String contra=request.getParameter("contra");
		
		List<Tienda>tiendas=tiendaD.selectAll();
		List<Cliente>clientes= clienteD.selectAll();
		for (int i = 0; i < tiendas.size(); i++) {
			
			if (tiendas.get(i).getEmail().equals(email) && (tiendas.get(i).getClave().equals(contra))) {
				RequestDispatcher dispatcher= request.getRequestDispatcher("Home?action=tiendaServicios&id="+tiendas.get(i).getId());
				dispatcher.forward(request, response);
				return;
			}
			
		}
		
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getEmail().equals(email) && (clientes.get(i).getClave().equals(contra))) {
				RequestDispatcher dispatcher= request.getRequestDispatcher("Home");
				dispatcher.forward(request, response);
				return;
			}
		}
		
		PrintWriter out = response.getWriter();
		out.println("<script type=\"text/javascript\">");
		out.println("alert('No existe ningun usuario con esa combinación de correo y contraseña');");
	    out.println("location='Login.do?action=vistaLogin';");
	    out.println("</script>");
	    return;
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
