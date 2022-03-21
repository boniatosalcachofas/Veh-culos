package vehiculo;

public class Vehiculo {

	private static String tipoVehiculo[] = { "Coche", "Furgoneta", "Moto" };

	private String matricula;
	private String marca;
	private String modelo;
	private int caballos;
	private int empresa;
	private int diasRestantes;

	public void altaAlquiler(int empresa, int diasRestantes) {

		this.empresa = empresa;
		this.diasRestantes = diasRestantes;

	}

	public String datosVehiculos() {

		if (diasRestantes == -1)
			return " " + marca + " " + modelo + " " + matricula + "\n---";

		else
			return " " + marca + " " + modelo + " " + matricula + " Empresa" + diasRestantes + " dias\n---";

	}

	public int pasoDiaVehiculo() {

		this.diasRestantes--;
		return this.diasRestantes;

	}

	// Constructores
	public Vehiculo(String matricula, String marca, String modelo, int caballos) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.caballos = caballos;
	}
	// Getters and setters

	public String getMatrícula() {
		return matricula;
	}

	public void setMatrícula(String matricula) {
		this.matricula = matricula;
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

	public static String[] getTipoVehiculo() {
		return tipoVehiculo;
	}

	public static void setTipoVehiculo(String[] tipoVehiculo) {
		Vehiculo.tipoVehiculo = tipoVehiculo;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getEmpresa() {
		return empresa;
	}

	public void setEmpresa(int empresa) {
		this.empresa = empresa;
	}

	public int getDiasRestantes() {
		return diasRestantes;
	}

	public void setDiasRestantes(int diasRestantes) {
		this.diasRestantes = diasRestantes;
	}

}
