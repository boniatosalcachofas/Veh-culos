package vehiculo;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * Clase principal donde se crean casi todos los parametros y metodos, y de donde parte el programa al iniciarse
 * @author Ismael
 * @version 0.06
 */
public class Principal {

	public static Coche coches[] = new Coche[7];
	public static Furgoneta furgonetas[] = new Furgoneta[3];
	public static Moto motos[] = new Moto[2];

	public static ArrayList<Vehiculo> vehiculosAlquilados = new ArrayList();
	public static ArrayList<Vehiculo> vehiculosNoAlquilados = new ArrayList();

	public static Empresa empresas[] = new Empresa[6];

	public static int dia = 1;

	/**
	 * Metodo principal donde inicia el codigo y se crean todos los coches y vehiculos. tambien se anyaden al array de no alquilados
	 * @param args
	 * @see menuPrincipal una vez anyadidos todos los coches y vehiculos, el programa esta listo para preguntar que coche quiere ser alquilado
	 */
	public static void main(String[] args) {

		coches[0] = new Coche("1972 ZDL", "BMW", "Spider", 200, 5);
		coches[1] = new Coche("2487 NME", "Dacia", "Santea", 120, 5);
		coches[2] = new Coche("8046 DAG", "Infiniti", "Person", 80, 3);
		coches[3] = new Coche("3857 MIH", "Kia", "Rovers", 220, 3);
		coches[4] = new Coche("3915 YUV", "Land Rover", "Yong", 150, 6);
		coches[5] = new Coche("0888 NFF", "Mercedes-Benz", "Land", 300, 4);
		coches[6] = new Coche("2390 ZXW", "Opel", "Corsa", 330, 3);

		furgonetas[0] = new Furgoneta("1431 IOB", "BMW", "Spider", 80, 100);
		furgonetas[1] = new Furgoneta("8144 OIC", "Rolls-Royce", "Astus", 100, 70);
		furgonetas[2] = new Furgoneta("2927 XGK", "Subaru", "Setsua", 100, 300);

		motos[0] = new Moto("2784 DMG", "BMW", "Ubuntu", 80, true);
		motos[1] = new Moto("5069 UZQ", "Volkswagen", "Corsa", 190, false);

		empresas[0] = new Empresa("Renault", "04936");
		empresas[1] = new Empresa("Nescafe", "56343");
		empresas[2] = new Empresa("Salarium", "12423");
		empresas[3] = new Empresa("Yummi", "54236");
		empresas[4] = new Empresa("Enclurt", "85438");
		empresas[5] = new Empresa("Deuchnest", "39332");

		for (int i = 0; i < coches.length; i++) {

			vehiculosNoAlquilados.add(coches[i]);

		}
		for (int i = 0; i < furgonetas.length; i++) {

			vehiculosNoAlquilados.add(furgonetas[i]);

		}
		for (int i = 0; i < motos.length; i++) {

			vehiculosNoAlquilados.add(motos[i]);

		}

		while (true) {
			try {
				menuPrincipal();
			} catch (java.util.InputMismatchException e) {
				System.out.println("---\nCARACTER NO PERMITIDO\n---");
			} catch (java.lang.ArrayIndexOutOfBoundsException j) {

				System.out.println("---\nNUMERO FUERA DEL RANGO DE ELECCION\n---");

			}
		}
	}
	
	/**
	 * Metodo para definir si lo que quieres es alquilar un vehiculo o pasar de dia y mostrar un informe
	 * @param numEmpresa adquiere, mediante el scanner, el numero de la empresa
	 * @see menuAlquiler llama al menu para alquilar vehiculos con el numero de la empresa obtenido en este metodo
	 * @see mostrarNoAlquilado
	 * @see mostrarAlquilado
	 * @see mostrarAlquiladoOrden
	 * @throws java.lang.ArrayIndexOutOfBoundsException ocurre al escribir un numero mayor que el limite de lo permitido
	 * @throws java.util.InputMismatchException ocurre al escribir un valor no numerico
	 * 
	 */
	public static void menuPrincipal() {

		Scanner scInt = new Scanner(System.in);

		System.out.println("DIA " + dia + "\n------" + "\nQue empresa desea alquilar un vehiculo?");

		int numEmpresa = scInt.nextInt();

		if (numEmpresa > 0 || numEmpresa < -2) {
			menuAlquiler(numEmpresa);
		} else {

			switch (numEmpresa) {

			case -1:
				mostrarNoAlquilado();
				mostrarAlquilado();
				pasoDia();
				break;

			case -2:
				mostrarNoAlquilado();
				vehiculoAlquiladoOrden();
				pasoDia();
				break;

			}
		}

	}

	/**
	 * Metodo para obtener la informacion sobre el tipo de vehiculo que se alquila y el numero de dias
	 * @param numEmpresa
	 * @param vehiculo obtiene un numero que define el tipo de vehiculo
	 * @param diasAlquilado obtiene el numero de dias que se alquila el vehiculo
	 * @see alquilerDeVehiculos llama al metodo enviando la informacion para dar de alta el alquiler y seleccionar el vehiculo
	 * @throws java.lang.ArrayIndexOutOfBoundsException se obtiene al elegir un caracter numerico que sea mayor al limite del tamanyo de los arrays de este metodo
	 * @throws java.util.InputMismatchException se obtiene al escribir un caracter no numerico en un campo numerica
	 */
	public static void menuAlquiler(int numEmpresa) {
		Scanner scInt = new Scanner(System.in);
		int diasAlquilado = 0;
		
		System.out.println(empresas[numEmpresa - 1].getNombre());

		System.out.println("\n¿Que vehiculo?");

		int vehiculo = scInt.nextInt();
		System.out.println(Vehiculo.getTipoVehiculo()[vehiculo - 1]);

		while (true) {
			System.out.println("\n¿Durante cuantos dias?");
			diasAlquilado = scInt.nextInt();
			if(diasAlquilado < 0) System.out.println("Valor no permitido");
			else break;
		}
		System.out.println("Durante " + diasAlquilado + " dias");

		alquilerDeVehiculos(vehiculo, numEmpresa, diasAlquilado);

	}

	/**
	 * Metodo para seleccionar un vehiculo que alquilar filtrando para encontrar el tipo de vehiculo que coincida con el
	 * que el cliente quiera, mediante un "instanceof"
	 * @param tipoVehiculo
	 * @param numEmpresa
	 * @param diasAlquilado
	 * @see procesoDeAlquiler llama a este metodo para mandar la informacion de los dias que se alquila y el numero de empresa y la posicion en el array para poder
	 * dar de alta como alquilado ese vehiculo
	 * @see error llama a este metodo en el caso que no exista ni coincida en el array las condiciones establecidas
	 */
	public static void alquilerDeVehiculos(int tipoVehiculo, int numEmpresa, int diasAlquilado) {

		if (vehiculosNoAlquilados.size() <= 0)
			error(tipoVehiculo);

		for (int i = 0; i < vehiculosNoAlquilados.size();) {

			if (tipoVehiculo == 1 && vehiculosNoAlquilados.get(i) instanceof Coche) {

				procesoDeAlquiler(numEmpresa, diasAlquilado, i);
				break;

			} else if (tipoVehiculo == 2 && vehiculosNoAlquilados.get(i) instanceof Furgoneta) {

				procesoDeAlquiler(numEmpresa, diasAlquilado, i);
				break;

			} else if (tipoVehiculo == 3 && vehiculosNoAlquilados.get(i) instanceof Moto) {

				procesoDeAlquiler(numEmpresa, diasAlquilado, i);
				break;

			} else if (i == vehiculosNoAlquilados.size() - 1) {

				error(tipoVehiculo);
				i++;

			} else
				i++;

		}

	}
	
	/**
	 * retira del array de vehiculos no alquilados el vehiculo seleccionado en la posicion "i" y lo anyade en el array de 
	 * vehiculos alquilados.
	 * @param numEmpresa
	 * @param diasAlquilado
	 * @param i
	 * @see Vehiculo.altaAlquiler metodo para dar de alta el alquiler de determinado vehiculo enviando la informacion necesaria
	 * para rellenar los datos
	 */
	public static void procesoDeAlquiler(int numEmpresa, int diasAlquilado, int i) {
		vehiculosAlquilados.add(vehiculosNoAlquilados.get(i));
		vehiculosNoAlquilados.remove(i);
		vehiculosAlquilados.get(vehiculosAlquilados.size() - 1).altaAlquiler(numEmpresa, diasAlquilado);
	}

	/**
	 * metodo para informar de que ya no esta disponible algun tipo de vehiculo
	 * @param tipoVehiculo
	 */
	private static void error(int tipoVehiculo) {
		if (tipoVehiculo == 1)
			System.out.println("\nNO DISPONIBLE COCHE PARA ALQUILAR\n");
		else if (tipoVehiculo == 2)
			System.out.println("\nNO DISPONIBLE FURGONETA PARA ALQUILAR\n");
		else if (tipoVehiculo == 3)
			System.out.println("\nNO DISPONIBLE MOTO PARA ALQUILAR\n");
	}

	/**
	 * metodo que muestra un listado de vehiculos que no estan alquilados
	 * distinguiendo entre tipo de vehiculo mediante "if"
	 */
	public static void mostrarNoAlquilado() {

		System.out.println("VEHICULOS SIN ALQUILAR");
		for (int i = 0; i < vehiculosNoAlquilados.size(); i++) {

			if (vehiculosNoAlquilados.get(i) instanceof Coche) {

				System.out.println("Coche " + vehiculosNoAlquilados.get(i).datosVehiculos());

			} else if (vehiculosNoAlquilados.get(i) instanceof Furgoneta) {

				System.out.println("Furgoneta " + vehiculosNoAlquilados.get(i).datosVehiculos());

			} else if (vehiculosNoAlquilados.get(i) instanceof Moto) {

				System.out.println("Moto " + vehiculosNoAlquilados.get(i).datosVehiculos());

			}

		}

	}

	/**
	 * metodo que muestra un listado de vehiculos que estan alquilados
	 * distinguiendo entre tipo de vehiculo mediante "if"
	 */
	public static void mostrarAlquilado() {

		System.out.println("---\nVEHICULOS ALQUILADOS\n---");
		for (int i = 0; i < vehiculosAlquilados.size(); i++) {

			if (vehiculosAlquilados.get(i) instanceof Coche) {

				System.out.println("Coche " + vehiculosAlquilados.get(i).datosVehiculos());

			} else if (vehiculosAlquilados.get(i) instanceof Furgoneta) {

				System.out.println("Furgoneta " + vehiculosAlquilados.get(i).datosVehiculos());

			} else if (vehiculosAlquilados.get(i) instanceof Moto) {

				System.out.println("Moto " + vehiculosAlquilados.get(i).datosVehiculos());

			}

		}

	}

	/**
	 * metodo que muestra un listado de vehiculos que estan alquilados
	 * distinguiendo entre tipo de vehiculo mediante "if" y ordenandolos
	 * de menos a mas sobre la caducidad o dias restantes del alquiler
	 * @param vehiculosAlquiladosTemporal array en el que se clona el array de vehiculosAlquilados
	 * para poder ordenar mediante varios if, un for y un while
	 * @see Vehiculo.datosVehiculos metodo para mostrar informacion sobre los vehiculos
	 */
	public static void vehiculoAlquiladoOrden() {

		ArrayList<Vehiculo> vehiculosAlquiladosTemporal = new ArrayList();

		vehiculosAlquiladosTemporal.addAll(vehiculosAlquilados);

		System.out.println("---\nVEHICULOS ALQUILADOS POR ORDEN\n---");

		while (vehiculosAlquiladosTemporal.size() >= 1) {

			int posicionV = 0;
			for (int i = 0; i < vehiculosAlquiladosTemporal.size(); i++) {

				if (vehiculosAlquiladosTemporal.get(i).getDiasRestantes() <= vehiculosAlquiladosTemporal.get(posicionV)
						.getDiasRestantes())
					posicionV = i;

			}

			if (vehiculosAlquiladosTemporal.get(posicionV) instanceof Coche) {

				System.out.println("Coche " + vehiculosAlquiladosTemporal.get(posicionV).datosVehiculos());

			} else if (vehiculosAlquiladosTemporal.get(posicionV) instanceof Furgoneta) {

				System.out.println("Furgoneta " + vehiculosAlquiladosTemporal.get(posicionV).datosVehiculos());

			} else if (vehiculosAlquiladosTemporal.get(posicionV) instanceof Moto) {

				System.out.println("Moto " + vehiculosAlquiladosTemporal.get(posicionV).datosVehiculos());

			}
			if (vehiculosAlquiladosTemporal.size() == 1) {
				break;
			}
			vehiculosAlquiladosTemporal.remove(posicionV);
		}

	}
	/**
	 * metodo para pasar de dia
	 * @see Vehiculo.pasoDiaVehiculo se llama al metodo para obtener el numero de dias restantes para finalizar el alquiler
	 */
	public static void pasoDia() {

		dia++;

		for (int i = 0; i < vehiculosAlquilados.size();) {

			int diaRestante = vehiculosAlquilados.get(i).pasoDiaVehiculo();

			if (diaRestante == -1) {

				vehiculosNoAlquilados.add(vehiculosAlquilados.get(i));
				vehiculosAlquilados.remove(i);

			} else
				i++;

		}

	}

}
