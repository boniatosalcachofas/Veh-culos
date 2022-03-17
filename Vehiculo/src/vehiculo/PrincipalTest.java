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

				if (Principal.coches[i].getMatr�cula().equals(Principal.coches[j].getMatr�cula()) && i != j) {
					coincide = true;
				}
				
				
				

			}
			for (int j = 0; j < Principal.furgonetas.length; j++) {
				if (Principal.coches[i].getMatr�cula().equals(Principal.furgonetas[j].getMatr�cula()) && i != j) {
					coincide = true;
				}
			}
			for (int j = 0; j < Principal.motos.length; j++) {
				if (Principal.coches[i].getMatr�cula().equals(Principal.motos[j].getMatr�cula()) && i != j) {
					coincide = true;
				}
			}
			
		}
		for (int i = 0; i < Principal.furgonetas.length; i++) {
			for (int j = 0; j < Principal.furgonetas.length; j++) {
				if (Principal.furgonetas[j].getMatr�cula().equals(Principal.furgonetas[i].getMatr�cula()) && i != j) {
					coincide = true;
				}
			}
			for (int j = 0; j < Principal.motos.length; j++) {
				if (Principal.furgonetas[i].getMatr�cula().equals(Principal.motos[j].getMatr�cula()) && i != j) {
					coincide = true;
				}
			}
		}
		for (int i = 0; i < Principal.motos.length; i++) {
			for (int j = 0; j < Principal.motos.length; j++) {
				if (Principal.motos[i].getMatr�cula().equals(Principal.motos[j].getMatr�cula()) && i != j) {
					coincide = true;
				}
			}
		}
			
		assertFalse(coincide, "Matr�cula repetida");
	}

}
