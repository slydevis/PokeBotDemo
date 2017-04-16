package fr.univaix.iut.pokebattle.smartcell;

/* Linda */

import fr.univaix.iut.pokebattle.jpa.Pokemon;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class CatchPokeWithOwner implements SmartCell {
    Pokemon poke;

    public void setPokemon(Pokemon poke)
    {
        this.poke = poke;
    }
    @Override
    public String ask(Tweet question) {
        if(question.getText().contains("Owner ?")){
            if(poke.getEleveur() != null) {
                String answer = "@" + question.getScreenName() + " My owner is @" + poke.getEleveur() + ".";
                return answer;
            }
        }
        return null;
    }
}










