package jana60;

import java.time.LocalDate;
import java.util.Scanner;

public class Agenzia {

	public static void main(String[] args) throws Exception {
		
		boolean flag = false;
		Scanner scan = new Scanner(System.in);
		String destinazione;
		int giornoInizio, giornoFine, meseInizio, meseFine, annoInizio, annoFine;
		LocalDate inizioVacanza = null, fineVacanza = null;
		
		do {
			
			try {
				
				System.out.print("Destinazione ");
				destinazione = scan.nextLine();
				
				System.out.println("Inizio vacanza:");
				
				System.out.print("giorno ");
				giornoInizio = Integer.parseInt(scan.nextLine());
				
				System.out.print("mese ");
				meseInizio = Integer.parseInt(scan.nextLine());

				System.out.print("anno ");
				annoInizio = Integer.parseInt(scan.nextLine());
				
				System.out.println("Fine vacanza:");
				
				System.out.print("giorno ");
				giornoFine = Integer.parseInt(scan.nextLine());
				
				System.out.print("mese ");
				meseFine = Integer.parseInt(scan.nextLine());

				System.out.print("anno ");
				annoFine = Integer.parseInt(scan.nextLine());
				
				Vacanza vacanza1 = new Vacanza(destinazione, giornoInizio, giornoFine, meseInizio, meseFine, annoInizio, annoFine);
				
				System.out.println(vacanza1.stampaVacanza());
				
				flag = true;
				
			} catch (NumberFormatException nfe) {
				
				System.out.println("Hai inserito un carattere non valido, la data deve essere un numero intero.");
				System.out.println(nfe.getMessage());		
			
			}
			
			catch(Exception e) {
				
				System.out.println("Impossibile registrare l'utente. Riprova.");
				System.out.println(e.getMessage());
				
			}
			
		}while(!flag);
		
		scan.close();
		
	}

}
