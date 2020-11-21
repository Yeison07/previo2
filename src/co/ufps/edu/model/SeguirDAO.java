package co.ufps.edu.model;

import java.util.List;

import co.ufps.edu.conexion.Conexion;

public class SeguirDAO {

Conexion con=null;
	
	public SeguirDAO(){
		con= new Conexion();
		con.setC(Seguir.class);
	}
	
	public Seguir selectById(int id) {
		Seguir e = (Seguir) con.find(id);		
		return e;
	}

	
	public List<Seguir> selectAll() {
		
		List<Seguir> contactos = con.list();

		return contactos;
	}

	
	public void insert(Seguir objeto) {
		
		con.insert(objeto);

	}

	
	public void update(Seguir objeto) {

		con.update(objeto);

	}

	
	public void delete(Seguir objeto) {
		
		con.delete(objeto);

	}
}
