package vehiculo;

/**
 * 
 * @author isma
 * @version 0.06
 */
public class Moto extends Vehiculo {

	boolean maletin;

	// Constructores

	public Moto(String matricula, String marca, String modelo, int caballos, boolean maletin) {
		super(matricula, marca, modelo, caballos);
		this.maletin = maletin;
	}

	// Getters and setters
	/**
	 * 
	 * @return devuelve informacion sobre si la moto tiene maletin o no
	 */
	public boolean isMaletin() {
		return maletin;
	}
	/**
	 * define si la moto tiene maletin o no
	 * @param maletin
	 */
	public void setMaletin(boolean maletin) {
		this.maletin = maletin;
	}

}
