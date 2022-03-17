package vehiculo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PrincipalTest {

	@Test
	void testMatricula() {
		Principal.main(null);
		boolean coincide = false;
		for (int i = 0; i < Principal.coches.length; i++) {

			for (int j = 0; j < Principal.coches.length; j++) {

				if (Principal.coches[i].getMatrícula().equals(Principal.coches[j].getMatrícula()) && i != j) {
					coincide = true;
				}
				
				
				

			}
			for (int j = 0; j < Principal.furgonetas.length; j++) {
				if (Principal.coches[i].getMatrícula().equals(Principal.furgonetas[j].getMatrícula()) && i != j) {
					coincide = true;
				}
			}
			for (int j = 0; j < Principal.motos.length; j++) {
				if (Principal.coches[i].getMatrícula().equals(Principal.motos[j].getMatrícula()) && i != j) {
					coincide = true;
				}
			}
			
		}
		for (int i = 0; i < Principal.furgonetas.length; i++) {
			for (int j = 0; j < Principal.furgonetas.length; j++) {
				if (Principal.furgonetas[j].getMatrícula().equals(Principal.furgonetas[i].getMatrícula()) && i != j) {
					coincide = true;
				}
			}
			for (int j = 0; j < Principal.motos.length; j++) {
				if (Principal.furgonetas[i].getMatrícula().equals(Principal.motos[j].getMatrícula()) && i != j) {
					coincide = true;
				}
			}
		}
		for (int i = 0; i < Principal.motos.length; i++) {
			for (int j = 0; j < Principal.motos.length; j++) {
				if (Principal.motos[i].getMatrícula().equals(Principal.motos[j].getMatrícula()) && i != j) {
					coincide = true;
				}
			}
		}
			
		assertFalse(coincide, "Matrícula repetida");
	}

}
