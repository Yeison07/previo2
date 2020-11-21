package co.ufps.edu.test;

import co.ufps.edu.model.Cliente;
import co.ufps.edu.model.ClienteDAO;
import co.ufps.edu.model.Servicio;
import co.ufps.edu.model.Tienda;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cliente c = new Cliente();
		c.setNombre("Esto es una prueba");
		c.setEmail("Email prueba");
		c.setClave("Clave prueba");
		
		ClienteDAO cd = new ClienteDAO();
		cd.insert(c);
		
		
		
		
		Tienda t = new Tienda();
		
		
		
		Servicio s = new Servicio();
		s.setNombre("Servicio prueba");
		s.setDescripcion("Descripcion de prueba");
		
	}

}
