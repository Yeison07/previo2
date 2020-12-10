package co.ufps.edu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.ufps.edu.model.Tienda;
import co.ufps.edu.model.TiendaDAO;



/**
 * Servlet implementation class TiendaServlet
 */
@WebServlet(name="CategoriaServlet", urlPatterns= {"/Tienda.do"})
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
		case "insert":
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
		
		

		PrintWriter out = response.getWriter();
		
		if (!verificarImagen(imagen)) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('La imagen en la direccion ingresada no existe o no es valida');");
		    out.println("location='Tienda.do?action=vistaRegistro';");
		    out.println("</script>");
				return;
			
		} 
		
		
		if(verificarCorreo(email)) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('El correo ya existe');");
		    out.println("location='Tienda.do?action=vistaRegistro';");
		    out.println("</script>");
				return;
		}
		
		Tienda tienda = new Tienda();
		tienda.setNombre(nombre);
		tienda.setLema(lema);
		tienda.setDescripcion(descri);
		tienda.setEmail(email);
		tienda.setClave(clave);
		tienda.setPropietario(propietario);
		tienda.setFacebook(face);
		tienda.setWeb(web);
		tienda.setImagen(imagen);
		
		tiendaD.insert(tienda);
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("Home");
		dispatcher.forward(request, response);
	}
	
	private boolean verificarImagen(String imagen) throws IOException {
		try {
		final URL url = new URL(imagen);
		HttpURLConnection huc = (HttpURLConnection) url.openConnection();
		int responseCode = huc.getResponseCode();
		if (responseCode == 404) {
			return false;
		}
		}
		catch(Exception ex) {return false;}
		
		return true;
	}
	
	private boolean verificarCorreo(String email) {
		List <Tienda>tiendas= tiendaD.selectAll();
		for (int i = 0; i < tiendas.size(); i++) {
			if (email.equals(tiendas.get(i).getEmail())) {
				return true;
			}
		}
		return false;
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
