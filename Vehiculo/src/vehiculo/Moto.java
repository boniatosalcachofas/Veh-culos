package vehiculo;

public class Moto extends Vehiculo{
	
	boolean maletin;

	
	
	
	//Constructores
	
	public Moto(String matr�cula, String marca, String modelo, int caballos, boolean maletin) {
		super(matr�cula, marca, modelo, caballos);
		this.maletin = maletin;
	}

	//Getters and setters
	
	public boolean isMaletin() {
		return maletin;
	}

	

	public void setMaletin(boolean maletin) {
		this.maletin = maletin;
	}
	
	

}
