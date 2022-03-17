package vehiculo;

import java.util.Scanner;

public class Principal {
	
	
	public static Coche coches[] = new Coche[7];
	public static Furgoneta furgonetas[] = new Furgoneta[3];
	public static Moto motos[] = new Moto[2];
	
	public static Empresa empresas[] = new Empresa[6];
	
	public static int dia = 1;
	
public static void main(String[] args) {
		
		coches[0] = new Coche("1972 ZDL", "BMW", "Spider", 200, 5);
		coches[1] = new Coche("2487 NME", "Dacia", "Santea", 120, 5);
		coches[2] = new Coche("8046 DAG", "Infiniti", "Person",80, 3);
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
		empresas[1] = new Empresa("Nescafé", "56343");
		empresas[2] = new Empresa("Salarium", "12423");
		empresas[3] = new Empresa("Yummi", "54236");
		empresas[4] = new Empresa("Enclurt", "85438");
		empresas[5] = new Empresa("Deuchnest", "39332");
		
		menuAlquiler();
	}
	
	public static void menuAlquiler() {
	Scanner scInt = new Scanner(System.in);
		
		
		System.out.println("DIA " + dia + 
							"\n------"
						+ "\nQue empresa desea alquilar un vehiculo?");
		//Posible error
		int numEmpresa = scInt.nextInt();	
		System.out.println(empresas[numEmpresa-1].getNombre());
		
		System.out.println("¿Que vehiculo?");
		//Posible error
		
		

		
		//for(int i = 0; i<empresas.length; i++) {
//			
//			if(i == eleccion)
//			
//		}
	
	}
	
	
	

}
