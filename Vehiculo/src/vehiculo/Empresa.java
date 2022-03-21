package vehiculo;

import java.util.ArrayList;

/**
 * 
 * @author isma
 * @version 0.06
 */
public class Empresa {

	private String nombre;
	private String cif;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	// Constructores
	public Empresa(String nombre, String cif) {
		super();
		this.nombre = nombre;
		this.cif = cif;
	}

}
