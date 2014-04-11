package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.jpa.Pokemon;
import fr.univaix.iut.pokebattle.twitter.Tweet;


public class PokeDonneCarac implements SmartCell {

    private Pokemon poke;

    @Override
    public String ask(Tweet question) {

    	poke = PokeAskOwnerCell.recupInfo(question.getText());
    	String asking = question.getText();
    	if (poke != null && asking.contains("#stat #level ?")) {
    		return "@" + question.getScreenName() + " #level=" + poke.getLevel();
    	} else if (poke != null && asking.contains("#stat #XP ?")) {
    		return "@" + question.getScreenName() + " #XP=" + poke.getXP();
    	} else if (poke != null && asking.contains("#stat #PV ?")) {
    		return "@" + question.getScreenName() + " #PV=" + poke.getPV();
    	} else if (poke != null && asking.contains("#stat #Attack ?")) {
    		return "@" + question.getScreenName() + " #Attack=" + poke.getAttack();
    	} else if (poke != null && asking.contains("#stat #Defense ?")) {
    		return "@" + question.getScreenName() + " #Defense=" + poke.getDefense();
    	} else if (poke != null && asking.contains("#stat #Atk.Spe ?")) {
    		return "@" + question.getScreenName() + " #Atk.Spe=" + poke.getAttackSpecial();
    	} else if (poke != null && asking.contains("#stat #Def.Spe ?")) {
    		return "@" + question.getScreenName() + " #Def.Spe=" + poke.getDefenseSpecial();
    	} else if (poke != null && asking.contains("#stat #Speed ?")) {
    		return "@" + question.getScreenName() + " #Speed=" + poke.getSpeed();
    	} else {
    		return null;
    	}
    }
}