package umu.tds.modelo;

import java.util.LinkedList;
import java.util.List;



public class Playlist {

	
	private String nombre;
	private int id;
	private List<Cancion> canciones;
	
	public Playlist(String nombre) {
		this.nombre = nombre;
		canciones = new LinkedList<Cancion>();
	}
	
	public void addCancion(Cancion cancion) {
		if(!canciones.contains(cancion))	canciones.add(cancion);
	}
	
	public void addCanciones(List<Cancion> masRepro) {
		canciones.addAll(masRepro);
	}
	
	public void removeCancion(int id) {
		List<Cancion> songs = new LinkedList<Cancion>();
		songs.addAll(canciones);
		for (Cancion c: songs)
			if (c.getId()==id)
				canciones.remove(c);
	}

	public List<Cancion> getCanciones() {
		return canciones;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
