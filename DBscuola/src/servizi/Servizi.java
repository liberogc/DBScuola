package servizi;

import java.util.Scanner;

public class Servizi {

	private Scanner inval = null;
	private Scanner intesto = new Scanner(System.in);
	private String persona;

	public void menu() {
		System.out.println("1- Inserimento Studenti");
		System.out.println("2- Lista Studenti");
		System.out.println("3- Lista Studenti x Cognome");
		System.out.println("4- Modifica Scheda Studente");
		System.out.println("5- Elimina Scheda Studente");
		System.out.println("7- F I N E");
	}
	
	public String sceltaTesto(String messaggio) {
		System.out.println(messaggio);
		String testo = intesto.nextLine();
		return testo;
	}

	public int sceltaNumerica(String messaggio) {
		int scelta = 0;
		boolean vero = true;
		System.out.println(messaggio);
		while (vero) {
			try {
				inval = new Scanner(System.in);
				scelta = inval.nextInt();
				vero = false;
			} catch (Exception e) {
				System.out.println("Scelta errata riprova !!!!");
			} // fine try
		} // fine while
		return scelta;
	}
}
