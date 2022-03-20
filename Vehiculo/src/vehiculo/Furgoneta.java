package vehiculo;

public class Furgoneta extends Vehiculo{

	private double espacioInterior;

	
	
	//constructores
	
	public Furgoneta(String matricula, String marca, String modelo, int caballos, double espacioInterior) {
		super(matricula, marca, modelo, caballos);
		this.espacioInterior = espacioInterior;
	}

	//Getters and setters
	
	public double getEspacioInterior() {
		return espacioInterior;
	}


	public void setEspacioInterior(double espacioInterior) {
		this.espacioInterior = espacioInterior;
	}
	
	
	
}
