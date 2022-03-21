package vehiculo;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * Clase principal donde se crean casi todos los parametros y metodos, y de donde parte el programa al iniciarse
 * @author Ismael
 * @version 0.05
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

	// Menu para completar el alquiler pidiendo
	public static void menuAlquiler(int numEmpresa) {
		Scanner scInt = new Scanner(System.in);

		System.out.println(empresas[numEmpresa - 1].getNombre());

		System.out.println("\n�Que vehiculo?");

		int vehiculo = scInt.nextInt();
		System.out.println(Vehiculo.getTipoVehiculo()[vehiculo - 1]);

		System.out.println("\n�Durante cuantos dias?");

		int diasAlquilado = scInt.nextInt();
		System.out.println("Durante " + diasAlquilado + " dias");

		alquilerDeVehiculos(vehiculo, numEmpresa, diasAlquilado);

	}

	// Alquila un vehiculo a una empresa
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

	public static void procesoDeAlquiler(int numEmpresa, int diasAlquilado, int i) {
		vehiculosAlquilados.add(vehiculosNoAlquilados.get(i));
		vehiculosNoAlquilados.remove(i);
		vehiculosAlquilados.get(vehiculosAlquilados.size() - 1).altaAlquiler(numEmpresa, diasAlquilado);
	}

	// Muestra en pantalla que no hay suficientes vehiculos de determinado tipo para
	// alquilar
	private static void error(int tipoVehiculo) {
		if (tipoVehiculo == 1)
			System.out.println("\nNO DISPONIBLE COCHE PARA ALQUILAR\n");
		else if (tipoVehiculo == 2)
			System.out.println("\nNO DISPONIBLE FURGONETA PARA ALQUILAR\n");
		else if (tipoVehiculo == 3)
			System.out.println("\nNO DISPONIBLE MOTO PARA ALQUILAR\n");
	}

	// Muestra todos los vehiculos que no estan alquilados
	public static void mostrarNoAlquilado() {

		System.out.println("Vehiculos sin alquilar");
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

	// Muestra los vehiculos que estan alquilados
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

	// Muestra los vehiculos alquilados por orden del dia de menos a mas
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
