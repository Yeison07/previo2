package co.ufps.edu.test;

import co.ufps.edu.model.Cliente;
import co.ufps.edu.model.ClienteDAO;
import co.ufps.edu.model.Seguir;
import co.ufps.edu.model.SeguirDAO;
import co.ufps.edu.model.SeguirPK;
import co.ufps.edu.model.Servicio;
import co.ufps.edu.model.ServicioDAO;
import co.ufps.edu.model.Tienda;
import co.ufps.edu.model.TiendaDAO;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Insertar cliente
		Cliente c = new Cliente();
		c.setNombre("Esto es una prueba");
		c.setEmail("Email prueba");
		c.setClave("clave");
	
		
		ClienteDAO cd = new ClienteDAO();
		cd.insert(c);
		
		
		
		//Insertar tienda
		Tienda t = new Tienda();
		t.setNombre("tienda prueba");
		t.setLema("lema de prueba");
		t.setDescripcion("descripcion de prueba");
		t.setEmail("email de prueba");
		t.setClave("clave");
		t.setPropietario("propietario prueba");
		t.setFacebook("urlfacebook");
		t.setWeb("url web");
		t.setImagen("url imagen");
		
		TiendaDAO td = new TiendaDAO();
		td.insert(t);
		
		//Insertar servicio
		Servicio s = new Servicio();
		s.setNombre("Servicio prueba");
		s.setDescripcion("Descripcion de prueba");
		s.setTiendaBean(t);
		ServicioDAO sd = new ServicioDAO();
		sd.insert(s);
		
		//Seguir tienda
		Cliente cliente = cd.selectById(2);
		
		SeguirDAO sdao = new SeguirDAO();
		
		SeguirPK sepk = new SeguirPK();
		sepk.setCliente(cliente.getId());
		
		Seguir se= sdao.selectById(sepk.getCliente());
		se.setId(sepk);
		
		Tienda tienda= td.selectById(se.getId().getTienda());
		
		
		
		
		
		
		//Actualizar tienda
		Tienda tiendaActualizar= td.selectById(1);
		tiendaActualizar.setNombre("tiendaActualizada");
		td.update(tiendaActualizar);
		
		
		
	}

}
