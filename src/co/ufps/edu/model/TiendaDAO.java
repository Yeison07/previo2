package co.ufps.edu.model;

import java.util.List;

import co.ufps.edu.conexion.Conexion;

public class TiendaDAO {

Conexion con=null;
	
	public TiendaDAO(){
		con= new Conexion();
		con.setC(Tienda.class);
	}
	
	public Tienda selectById(int id) {
		Tienda e = (Tienda) con.find(id);		
		return e;
	}

	
	public List<Tienda> selectAll() {
		
		List<Tienda> contactos = con.list();

		return contactos;
	}

	
	public void insert(Tienda objeto) {
		
		con.insert(objeto);

	}

	
	public void update(Tienda objeto) {

		con.update(objeto);

	}

	
	public void delete(Tienda objeto) {
		
		con.delete(objeto);

	}
}
