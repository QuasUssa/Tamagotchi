package it.unibs.fp.tamaCompleto;

/**
 * La classe Tamagotchi gestisce i dati di un Tamagotchi mettendo
 * a disposizione i metodi per l'interazione con il proprio.
 * 
 * @author G.Bossini, F.Donati, Q.Hussain
 */
public class Tamagotchi {
	
	private static final int MIN_SAZIETA = 0;
	private static final int MAX_SAZIETA = 100;
	
	private static final int MIN_SAZIETA_FELICE = 30;
	private static final int MAX_SAZIETA_FELICE = 90;
	
	private static final int MIN_AFFETTO = 0;
	private static final int MAX_AFFETTO = 100;
	
	private static final int MIN_AFFETTO_FELICE = 30;
	
	private static final String MESSAGGIO_FELICE = "\nIl tuo Tamagotchi è felice :) ";
	private static final String MESSAGGIO_TRISTE = "\nIl tuo Tamagotchi è triste :( ";
	private static final String MESSAGGIO_MORTE = "\nIl tuo Tamagotchi è morto \u271d ";
	
	private static final String ERRORE_SAZIETA = "\nLivello di sazieta inserito non valido... ";
	private static final String ERRORE_AFFETTO = "\nLivello di affetto inserito non valido... ";
	
	private static final double FATTORE_BISCOTTI = 1.10;
	private static final int FATTORE_CAREZZE = 2;
	private static final int FATTORE_BISCOTTI_AFFETTO = 4;
	
	private double affetto;
	private double sazieta;
	
	private String nome;

	/**
	 * Il metodo Tamagotchi (costruttore) permette di creare un'istanza del
	 * proprio Tamagotchi.
	 * 
	 * @param nome Il nome dato al Tamagotchi.
	 * @param affetto Il livello di affetto, basato sulle carezze.
	 * @param sazieta Il livello di sazietà, basato sui biscotti mangiati.
	 */
	public Tamagotchi (String nome, double affetto, double sazieta) {
		
		if (sazieta < MIN_SAZIETA || sazieta > MAX_SAZIETA)
			throw new IllegalArgumentException(ERRORE_SAZIETA);
		
		if (affetto < MIN_AFFETTO || affetto > MAX_AFFETTO) {
			
			throw new IllegalArgumentException(ERRORE_AFFETTO);
		}
		else {
			
			this.affetto = affetto;
			this.sazieta = sazieta;
			this.nome = nome;
		}
	}
	
	/**
	 * @return Il nome del Tamagotchi.
	 */
	public String getNome () {
		
		return nome;
	}

	/**
	 * @return La sazietà del Tamagotchi.
	 */
	public double getSazieta () {
		
		return sazieta;
	}

	/**
	 * @return L'affetto del Tamagotchi.
	 */
	public double getAffetto () {
		
		return affetto;
	}
	
	/**
	 * Il metodo riceviBiscotti permette di incrementare il valore della sazietà del Tamagotchi a
	 * discapito dell'affetto. 
	 * La sazietà aumenta di una certa percentuale tante volte quanti i biscotti ricevuti.
	 * L'affetto diminuisce in base al numero di biscotti ricevuti diviso per un fattore costante.
	 * Il valore della sazietà non può scendere sotto il valore minimo possibile e salire
	 * sopra il valore massimo possibile per la sazietà.
	 * 
	 * @param biscotti Numero di biscotti generato randomicamente.
	 */
	public void riceviBiscotti(int biscotti) {
		
		for (int i = 0; i < biscotti; i++) {
			
			sazieta = Math.min(MAX_SAZIETA, sazieta * FATTORE_BISCOTTI);
		}
		
		affetto = Math.max(MIN_AFFETTO, affetto - (biscotti / FATTORE_BISCOTTI_AFFETTO));
	}
	
	/**
	 * Il metodo riceviCarezze permette di incrementare il valore dell'affetto del Tamagotchi a
	 * discapito della sazietà. 
	 * L'affetto aumenta in base al numero di carezze ricevute.
	 * La sazietà diminuisce in base al numero di carezze ricevute divise per un fattore costante.
	 * Il valore dell'affetto non scendere sotto il valore minimo possibile e salire
	 * sopra il valore massimo possibile per l'affetto.
	 * 
	 * @param carezze Numero di carezze generato randomicamente.
	 */
	public void riceviCarezze (int carezze) {
		
		sazieta = Math.max(MIN_SAZIETA, sazieta - carezze / FATTORE_CAREZZE);
		affetto = Math.min(MAX_AFFETTO, affetto + carezze);
	}
	
	/**
	 * @return True, se il Tamagotchi soddisfa le condizioni di felicità.
	 */
	public boolean isHappy () {
		
		return ((sazieta >= MIN_SAZIETA_FELICE && sazieta <= MAX_SAZIETA_FELICE) && affetto >= MIN_AFFETTO_FELICE);
	}
	
	/**
	 * @return True, se il Tamagotchi soddisfa le condizioni di tristezza.
	 */
	public boolean isSad () {
		
		return ((sazieta < MIN_SAZIETA_FELICE || sazieta > MAX_SAZIETA_FELICE) || affetto < MIN_AFFETTO_FELICE);
	}
	
	/**
	 * @return True, se il Tamagotchi soddisfa le condizioni di morte.
	 */
	public boolean isDead () {
		
		return ((affetto == MIN_AFFETTO || sazieta == MIN_SAZIETA) || sazieta == 100);
	}
	
	/**
	 * @return Le informazioni sullo stato del Tamagotchi.
	 */
	public String toString () {
		
		StringBuffer risultato = new StringBuffer();
		
		risultato.append("\nTamagotchi: " +nome);
		risultato.append(String.format("\n%nLivello di sazietà: %.2f%n", sazieta));
		risultato.append(String.format("Livello di affetto: %.2f%n", affetto));
		
		if (isDead()) {
		
			risultato.append(MESSAGGIO_MORTE);
		}
		else {
			
			if (isSad())
				risultato.append(MESSAGGIO_TRISTE);
			
			if (isHappy())
				risultato.append(MESSAGGIO_FELICE);
		}
		
		return risultato.toString();
	}
}
