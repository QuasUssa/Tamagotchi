package it.unibs.fp.tamaCompleto;

/**
 * La classe IOUtil raggruppa delle funzionalità utili ma superflue
 * da mantenere nella classe Main.
 * 
 * @author G.Bossini, F.Donati, Q.Hussain
 * 
 */
import it.unibs.fp.mylib.InputDati;

public class IOUtil {
	
	private static final int SOGLIA_MINIMA_SAZIETA = 30;
	private static final int SOGLIA_MINIMO_AFFETTO = 30;
	
	public final static int MAX_SAZIETA = 90;
	public final static int MAX_AFFETTO = 100;
	
	private final static String RICHIESTA_NOME = "\nInserisci il nome del tuo tamagotchi: ";
	private final static String RICHIESTA_SAZIETA = "\nInserisci il livello di sazietà iniziale del tuo Tamagotchi: ";
	private final static String RICHIESTA_SODDISFAZIONE = "Inserisci il livello di soddisfazione iniziale del tuo Tamagotchi: ";

	/**
	 * Il metodo creaTamagotchi permette di creare un nuovo Tamagotchi 
	 * inizializzandone lo stato e definendone il nome.
	 * 
	 * @return Il nuovo Tamagotchi inizializzato manualmente.
	 */
	public static Tamagotchi creaTamagotchi () {
		
		String nome = InputDati.leggiStringa(RICHIESTA_NOME);
		
		double sazieta = InputDati.leggiIntero(RICHIESTA_SAZIETA, SOGLIA_MINIMA_SAZIETA, MAX_SAZIETA);
		double affetto = InputDati.leggiIntero(RICHIESTA_SODDISFAZIONE, SOGLIA_MINIMO_AFFETTO, MAX_AFFETTO);
		
		return new Tamagotchi(nome, affetto, sazieta);	
	}
}
