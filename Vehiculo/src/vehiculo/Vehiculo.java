package vehiculo;

public class Vehiculo {
	
	private String matr�cula;
	private String marca;
	private String modelo;
	private int caballos;
	private int empresa;
	
	
	
	
	
	
	
	
	
	public Vehiculo(String matr�cula, String marca, String modelo, int caballos) {
		super();
		this.matr�cula = matr�cula;
		this.marca = marca;
		this.modelo = modelo;
		this.caballos = caballos;
	}
	//Getters and setters
	
	public String getMatr�cula() {
		return matr�cula;
	}
	public void setMatr�cula(String matr�cula) {
		this.matr�cula = matr�cula;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getCaballos() {
		return caballos;
	}
	public void setCaballos(int caballos) {
		this.caballos = caballos;
	}
	
	
	

}
