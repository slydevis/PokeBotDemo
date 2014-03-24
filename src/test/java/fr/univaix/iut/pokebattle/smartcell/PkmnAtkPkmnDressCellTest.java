package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PkmnAtkPkmnDressCellTest {

	PkmnAtkPkmnDressCell cell = new PkmnAtkPkmnDressCell();

	@Test
	public void testAtk() {
		assertEquals("@mewtwo #attack #ultralaser! /cc @gantben @nedseb",
				cell.ask(new Tweet("nedseb", "#attack #ultralaser @mewtwo /cc @gantben")));
	}

	@Test
	public void testBadAtk() {
		assertEquals("Fleex?...",
				cell.ask(new Tweet("nedseb", "#attack #ultralaser @mewtwo")));
	}

	@Test
	public void testBadAtk2() {
		assertEquals("Fleex?...",
				cell.ask(new Tweet("nedseb", "#attack #ultralaser @mewtwo @gantben")));
	}
}