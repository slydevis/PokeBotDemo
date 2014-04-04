package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.univaix.iut.pokebattle.twitter.Tweet;

public class OwnAskPkmnAttCellTest {

//	AskOwnerCell cell1 = new AskOwnerCell();
	private OwnAskPkmnAtkCell cell = new OwnAskPkmnAtkCell();

/*	@Test
	public void AskOwnerTest() {
		assertEquals("@nedseb @nedseb is my owner", cell1.ask(new Tweet("@nedseb", "Owner?")));
	}*/

	@Test
	public void ownerAskAtkTest() {
		assertEquals("@bulbizarre #attack #plaquage! /cc @slydevis",
				cell.ask(new Tweet("slydevis", "@Pikachu #attack #plaquage @bulbizarre")));
	}

	@Test
	public void notOwnerAskAtkTest() {
		assertEquals(null,
				cell.ask(new Tweet("nedseb", "attack")));
	}
}
