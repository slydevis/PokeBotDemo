package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.univaix.iut.pokebattle.twitter.Tweet;

public class OwnAskPkmnAttCellTest {

	private OwnAskPkmnAtkCell cell = new OwnAskPkmnAtkCell();

	@Test
	public void ownerAskAtkTest() {
		assertEquals("@bulbizarre #attack #plaquage! /cc @nedseb",
				cell.ask(new Tweet("nedseb", "#attack #plaquage @bulbizarre")));
	}

	@Test
	public void notOwnerAskAtkTest() {
		assertEquals(null, cell.ask(new Tweet("nedseb", "attack")));
	}
}
