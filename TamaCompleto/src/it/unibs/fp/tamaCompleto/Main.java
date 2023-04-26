package it.unibs.fp.tamaCompleto;

import it.unibs.fp.myUtil.*;
import it.unibs.fp.mylib.*;

/**
 * La classe Main contiene il main del programma. 
 * In esso un ciclo a controllo iniziale itera il menu
 * delle opzioni del Tamagotchi.
 * 
 * @author G.Bossini, F.Donati, Q.Hussain
 *
 */
public class Main {
	
	private final static String MESSAGGIO_SALUTO = "\nBenvenuto nel fantastico mondo dei Tamagotchi! ";
	private final static String MESSAGGIO_ARRIVEDERCI = "Arrivederci! ";
	
	private static final String MESSAGGIO_NUM_BISCOTTI = "Al tama sono stati dati %d biscotti";
	private static final String MESSAGGIO_NUM_CAREZZE = "Al tama sono state date %d carezze";
	
	private static final String OPZIONI_MENU = "Opzioni Tamagotchi: ";
	
	private static final String ERRORE_SELEZIONE = "\nSeleziona un'opzione presente nel menu: ";
	
	private final static String SCEGLI_BISCOTTI ="Dai Biscotti al tuo Tamagotchi ";
	private final static String SCEGLI_CAREZZE ="Dai carezze al tuo Tamagotchi ";
	
	private final static String [] SCELTA_AZIONE = {SCEGLI_BISCOTTI, SCEGLI_CAREZZE};
	
	
	public static void main (String args[]) {
		
		System.out.println(MESSAGGIO_SALUTO);
		Tamagotchi tama = IOUtil.creaTamagotchi();
		MyMenu menu = new MyMenu(OPZIONI_MENU, SCELTA_AZIONE);
		
		boolean finito = false;
		
		do {
			
			int scelta = menu.scegli();
			
			switch (scelta) {
			
				case 1: 
					int numBiscotti = NumeriCasuali.estraiIntero(1, 5);
					System.out.printf(MESSAGGIO_NUM_BISCOTTI,numBiscotti);
					tama.riceviBiscotti(numBiscotti);
					
					break;
					
				case 2: 
					int numCarezze = NumeriCasuali.estraiIntero(1, 5);
					System.out.printf(MESSAGGIO_NUM_CAREZZE,numCarezze);
					tama.riceviCarezze(numCarezze);
					break;
					
				case 0:
					finito = true;
					break;
					
				default:
					System.out.println(ERRORE_SELEZIONE);
					break;
			}
			
			System.out.println(tama.toString());
			
			if (tama.sonoMorto())
				finito = true;
		}
		while (!finito);
		
		System.out.println(MESSAGGIO_ARRIVEDERCI);
	}
}
