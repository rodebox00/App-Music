package umu.tds.dominio;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import umu.tds.persistencia.FactoriaDAO;
import umu.tds.modelo.Cancion;
import umu.tds.persistencia.AdaptadorUsuarioTDS;
import umu.tds.persistencia.DAOException;
import umu.tds.persistencia.IAdaptadorCancionDAO;

public class CatalogoCanciones {

	//Buscar canciones con filtros de b�squeda el t�tulo, interprete y estilo musical
	private Map<String,Cancion> cancionesInterprete;
	private Map<String,Cancion> cancioneTitulo;
	private Map<String,LinkedList<Cancion>> cancionesEstilo;
	private static CatalogoCanciones unicaInstancia;
	private IAdaptadorCancionDAO adaptadorCancion;
	
	
	public static CatalogoCanciones getUnicaInstancia(){
		
		if (unicaInstancia == null)
			return new CatalogoCanciones();
		else
			return unicaInstancia;
	}
	
	private CatalogoCanciones() {
		
		try {
			FactoriaDAO dao = FactoriaDAO.getInstancia();
			adaptadorCancion = dao.getCancionDAO();
			cancionesInterprete = new HashMap<String,Cancion>();
			cancioneTitulo = new HashMap<String,Cancion>();
			cancionesEstilo = new HashMap<String,LinkedList<Cancion>>();
			cargarCanciones();
		} catch (DAOException e) {
			e.printStackTrace();
		}	
		
	}
	
	public void addCancion(Cancion cancion) {
		
	}
	
	
	public void removeCancion (Cancion cancion) {
		
	}
	
	
	private void cargarCanciones() {
		
	}
}

