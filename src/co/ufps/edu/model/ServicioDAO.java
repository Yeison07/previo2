package co.ufps.edu.model;

import java.util.List;

import co.ufps.edu.conexion.Conexion;

public class ServicioDAO {

Conexion con=null;
	
	public ServicioDAO(){
		con= new Conexion();
		con.setC(Servicio.class);
	}
	
	public Servicio selectById(int id) {
		Servicio e = (Servicio) con.find(id);		
		return e;
	}

	
	public List<Servicio> selectAll() {
		
		List<Servicio> contactos = con.list();

		return contactos;
	}

	
	public void insert(Servicio objeto) {
		
		con.insert(objeto);

	}

	
	public void update(Servicio objeto) {

		con.update(objeto);

	}

	
	public void delete(Servicio objeto) {
		
		con.delete(objeto);

	}
}
