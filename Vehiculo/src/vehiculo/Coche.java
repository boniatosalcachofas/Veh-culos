package vehiculo;

public class Coche extends Vehiculo {

	private int numPuertas;

	
	
	
	
	
	//Constructores
	
	public Coche(String matr�cula, String marca, String modelo, int caballos, int numPuertas) {
		super(matr�cula, marca, modelo, caballos);
		this.numPuertas = numPuertas;
	}

	//Getters and setters
	
	public int getNumPuertas() {
		return numPuertas;
	}

	public void setNumPuertas(int numPuertas) {
		this.numPuertas = numPuertas;
	}
	
	
	
	
	
}

