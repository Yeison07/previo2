package co.ufps.edu.model;

import java.util.List;

import co.ufps.edu.conexion.Conexion;

public class ClienteDAO {
Conexion con=null;
	
	public ClienteDAO(){
		con= new Conexion();
		con.setC(Cliente.class);
	}
	
	public Cliente selectById(int id) {
		Cliente e = (Cliente) con.find(id);		
		return e;
	}

	
	public List<Cliente> selectAll() {
		
		List<Cliente> contactos = con.list();

		return contactos;
	}

	
	public void insert(Cliente objeto) {
		
		con.insert(objeto);

	}

	
	public void update(Cliente objeto) {

		con.update(objeto);

	}

	
	public void delete(Cliente objeto) {
		
		con.delete(objeto);

	}
}
