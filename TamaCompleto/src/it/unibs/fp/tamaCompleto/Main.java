package it.unibs.fp.tamaCompleto;

import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;
import it.unibs.fp.mylib.NumeriCasuali;

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
					tama.riceviBiscotti(NumeriCasuali.estraiIntero(1, 5));
					break;
					
				case 2: 
					tama.riceviCarezze(NumeriCasuali.estraiIntero(1, 5));
					break;
					
				case 0:
					finito = true;
					break;
					
				default:
					System.out.println(ERRORE_SELEZIONE);
					break;
			}
			
			System.out.println(tama.toString());
			
			if (tama.isDead())
				finito = true;
		}
		while (!finito);
		
		System.out.println(MESSAGGIO_ARRIVEDERCI);
	}
}
