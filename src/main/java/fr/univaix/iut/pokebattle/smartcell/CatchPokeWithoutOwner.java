package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.jpa.Pokemon;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class CatchPokeWithoutOwner implements SmartCell {

	private Pokemon poke;

	@Override
	public String ask(Tweet question) {
		if (question.getText().contains("Pokeball!")) {
            poke = PokeAskOwnerCell.recupInfo(question.getText());
            if (poke != null && poke.getEleveur() != null) {
            	return "@" + question.getScreenName() + " @" + poke.getEleveur() + " is my owner";
            } else if (poke != null && poke.getEleveur() == null) {
            	poke.setEleveur(question.getScreenName());
                UpdateBioCell.update(poke);
                return "@" + question.getScreenName() + " @" + poke.getEleveur() + " is my owner";
            }
		}
		return null;
	}
}
