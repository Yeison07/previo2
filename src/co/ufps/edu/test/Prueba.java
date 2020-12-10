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
		c.setNombre("Yeison Soto");
		c.setEmail("yeisona07@hotmail.com");
		c.setClave("1234");
		
		ClienteDAO cd = new ClienteDAO();
		cd.insert(c);
	
		//Insertar tienda
		Tienda t = new Tienda();
		t.setNombre("Tienda creada");
		t.setLema("Lema de la tienda creado");
		t.setDescripcion("Descripcion creado");
		t.setEmail("tienda@hotmail.com");
		t.setClave("1234");
		t.setPropietario("Yeison Soto");
		t.setFacebook("https://www.facebook.com");
		t.setWeb("https://www.google.com");
		t.setImagen("https://www.enriquedans.com/wp-content/uploads/2008/12/msie.jpg");
		
		TiendaDAO td = new TiendaDAO();
		td.insert(t);
	
		//Trae una tienda
		Tienda tiendaServicio = td.selectById(11);
		//Inserta un servicio
		Servicio servicio = new Servicio();
		servicio.setNombre("Servicio creado");
		servicio.setDescripcion("Descripcion creada");
		servicio.setTiendaBean(tiendaServicio);
		ServicioDAO servicioD = new ServicioDAO();
		servicioD.insert(servicio);
		
		//Seguir tienda
		Cliente cliente = cd.selectById(4);
		Tienda tienda = td.selectById(11);
		
		SeguirPK spk= new SeguirPK();
		spk.setCliente(cliente.getId());
		spk.setTienda(tienda.getId());
		
		Seguir seguir = new Seguir();
		seguir.setId(spk);
		
		SeguirDAO seguirD = new SeguirDAO();
		seguirD.insert(seguir);
			
			
		//Actualizar tienda
		Tienda tiendaActualizar= td.selectById(11);
		tiendaActualizar.setNombre("tiendaActualizada");
		td.update(tiendaActualizar);
		
		
		
	}

}
