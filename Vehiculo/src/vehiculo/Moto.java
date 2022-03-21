package vehiculo;

public class Moto extends Vehiculo {

	boolean maletin;

	// Constructores

	public Moto(String matricula, String marca, String modelo, int caballos, boolean maletin) {
		super(matricula, marca, modelo, caballos);
		this.maletin = maletin;
	}

	// Getters and setters

	public boolean isMaletin() {
		return maletin;
	}

	public void setMaletin(boolean maletin) {
		this.maletin = maletin;
	}

}
