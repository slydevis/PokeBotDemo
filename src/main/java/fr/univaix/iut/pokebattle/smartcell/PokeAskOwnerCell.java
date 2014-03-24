package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.jpa.Pokemon;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokeAskOwnerCell implements SmartCell {
	Pokemon poke;
	
	public void setPokemon(Pokemon poke)
	{
		this.poke = poke;
	}
	@Override
	public String ask(Tweet question) {
		if(question.getText().contains("Owner?")){
            if(poke.getEleveur() != null) {
               String answer = "@" + question.getScreenName() + " My owner is @" + poke.getEleveur() + ".";
               return answer;
            }
            else {
                String answer = "@" + question.getScreenName() + " No owner";
                return answer;
            }
		}
		return null;
	}
}











