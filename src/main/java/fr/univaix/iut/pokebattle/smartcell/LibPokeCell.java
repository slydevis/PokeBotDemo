package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.jpa.Pokemon;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class LibPokeCell implements SmartCell {

    private Pokemon poke;

    public String ask(Tweet question) {
        if(question.getText().contains("Go out"))
        {
            poke = PokeAskOwnerCell.recupInfo(question.getText());

            if(poke.getEleveur() != null && poke.getEleveur().equals(question.getScreenName()))
            {
                poke.setEleveur(null);
                return "@"+ question.getScreenName() + " Snif Snif =°(";
            } else {
                return "@"+ question.getScreenName() + " I love pringles !";
            }
        }
        return null;
    }
}
