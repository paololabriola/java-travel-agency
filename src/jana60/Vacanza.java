package jana60;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Vacanza {

	private String destinazione;
	private int giornoInizio, giornoFine, meseInizio, meseFine, annoInizio, annoFine;
	LocalDate inizioVacanza, fineVacanza;
	public Vacanza(String destinazione, int giornoInizio, int giornoFine, int meseInizio, int meseFine, int annoInizio, int annoFine) throws Exception {
		
		super();
		
		this.destinazione = destinazione;
		this.giornoInizio = giornoInizio;
		this.giornoFine = giornoFine;
		this.meseInizio = meseInizio;
		this.meseFine = meseFine;
		this.annoInizio = annoInizio;
		this.annoFine = annoFine;
		
		inizioVacanza = LocalDate.of(annoInizio, meseInizio, giornoInizio);
		fineVacanza = LocalDate.of(annoFine, meseFine, giornoFine);
		
		validaDestinazione();		
		validaInizioVacanza();
		validaFineVacanza();
		
	}
	
	

	public String getDestinazione() {
		return destinazione;
	}



	public void setDestinazione(String destinazione) {
		this.destinazione = destinazione;
	}



	public LocalDate getInizioVacanza() {
		return inizioVacanza;
	}



	public void setInizioVacanza(LocalDate inizioVacanza) {
		this.inizioVacanza = inizioVacanza;
	}



	public LocalDate getFineVacanza() {
		return fineVacanza;
	}



	public void setFineVacanza(LocalDate fineVacanza) {
		this.fineVacanza = fineVacanza;
	}

	
	
	private void validaInizioVacanza() throws Exception {
		
		if(inizioVacanza.equals(null))
			throw new Exception("ERRORE, devi necessariamente definire una data.");
		
		if(inizioVacanza.isBefore(LocalDate.now()))
			throw new Exception("ERRORE, La data di inizio non può essere una data passata.");
		
	}
	
	private void validaFineVacanza() throws Exception {
		
		if(fineVacanza.equals(null))
			throw new Exception("ERRORE, devi necessariamente definire una data.");
		
		if(fineVacanza.isBefore(inizioVacanza))
			throw new Exception("ERRORE, la data di fine non può essere una data precedente a quella di inizio.");
		
	}
	
	private void validaDestinazione() throws Exception {
		
		if(destinazione == null)
			throw new Exception("ERRORE, è necessario scegliere una destinazione.");
		
	}
	
	private String formattaDataInizio() {
		
		return inizioVacanza.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
		
	}
	
	private String formattaDataFine() {
		
		return fineVacanza.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
		
	}
	
	public String stampaVacanza() {
		
		String stampa;
		
		Period durata = Period.between(inizioVacanza, fineVacanza);
		
		return stampa = "Hai prenotato una vacanza di " + durata + " a " + destinazione + " dal " + formattaDataInizio() + " al " + formattaDataFine();
		
	}
	
}
