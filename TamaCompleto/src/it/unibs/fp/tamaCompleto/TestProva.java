package it.unibs.fp.tamaCompleto;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestProva {

	// Attenzione, costruttore utilizzato:
	// public Tamagotchi (String nome, int gradoAffettivo, int gradoSazieta)
	
	@Test
	public void dieForZeroSatisfaction () throws Exception {
		
		final Tamagotchi tama = new Tamagotchi("Kira", 0, 50);
		assertTrue(tama.isDead());
	}
	
	@Test
	public void dieForZeroHunger () throws Exception {
		
		final Tamagotchi tama = new Tamagotchi("Kira", 50, 0);
		assertTrue(tama.isDead());
	}
	
	@Test
	public void aliveWhenSatisfactionAndHungerAreGood () throws Exception {
		
		final Tamagotchi tama = new Tamagotchi("Kira", 50, 50);
		assertFalse(tama.isDead());
	}

	@Test(expected = IllegalArgumentException.class)
	public void cantInstantiatePetWithNegativeSatisfaction () throws Exception {
		
		new Tamagotchi("Kira", -10, 50);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void cantInstantiatePetWithNegativeHunger () throws Exception {
		
		new Tamagotchi("Kira", 50, -10);
	}
	
	
	@Test
	public void petCanReceivePets () throws Exception {
		
		final Tamagotchi tama = new Tamagotchi("Kira", 50, 50);
		tama.riceviCarezze(1);
		assertFalse(tama.isSad());
	}
	
	@Test
	public void petCanReceiveCookies () throws Exception {
		
		final Tamagotchi tama = new Tamagotchi("Kira", 50, 50);
		tama.riceviBiscotti(1);
		assertFalse(tama.isSad());
	}
	
	@Test
	public void petIsUnhappyDueToHunger () throws Exception {
		
		final Tamagotchi tama = new Tamagotchi("Kira", 50, 10);
		assertTrue(tama.isSad());
	}
	
	@Test
	public void petIsUnhappyDueToExtremeRepletion () throws Exception {
		
		final Tamagotchi tama = new Tamagotchi("Kira", 50, 95);
		assertTrue(tama.isSad());
	}
	
	@Test
	public void petIsHappyInTheMidlleOfTheRange () throws Exception {
		
		final Tamagotchi tama = new Tamagotchi("Kira", 50, 50);
		assertFalse(tama.isSad());
	}
	
	@Test
	public void petAugmentsItsRepletionAndDiesDueToCookies () throws Exception {
		
		final Tamagotchi tama = new Tamagotchi("Kira", 50, 99);
		tama.riceviBiscotti(10);
		boolean res=tama.isDead();
		assertTrue(res);
	}
	
	@Test
	public void petAugmentsItsSatisfactionDueToCaresses () throws Exception {
		
		final Tamagotchi tama = new Tamagotchi("Kira", 29, 50);
		tama.riceviCarezze(10);
		assertFalse(tama.isSad());
	}
}
