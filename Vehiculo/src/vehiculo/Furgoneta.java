package vehiculo;
/**
 * 
 * @author isma
 * @version 0.06
 */
public class Furgoneta extends Vehiculo {

	private double espacioInterior;

	// constructores

	public Furgoneta(String matricula, String marca, String modelo, int caballos, double espacioInterior) {
		super(matricula, marca, modelo, caballos);
		this.espacioInterior = espacioInterior;
	}

	// Getters and setters
	/**
	 * 
	 * @return devuelve en litros el espacio de la furgoneta
	 */
	public double getEspacioInterior() {
		return espacioInterior;
	}
	/**
	 * establece el espacio interior de la furgoneta en litros
	 * @param espacioInterior
	 */
	public void setEspacioInterior(double espacioInterior) {
		this.espacioInterior = espacioInterior;
	}

}
