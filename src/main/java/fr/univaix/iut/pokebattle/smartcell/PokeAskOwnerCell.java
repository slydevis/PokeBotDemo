package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.jpa.DAOFactoryJPA;
import fr.univaix.iut.pokebattle.jpa.DAOPokemon;
import fr.univaix.iut.pokebattle.jpa.Pokemon;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokeAskOwnerCell implements SmartCell {

    private Pokemon poke;

    public String getNomPoke(String str) {
        String tmp = "";
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) == ' ') {
            	break;
            }
            if (str.charAt(i) == '@') {
            	++i;
            }
            tmp += str.charAt(i);
        }
        return tmp;
    }

    public Pokemon recupInfo(String texte) {
        String nom = getNomPoke(texte);
        DAOPokemon dao = DAOFactoryJPA.createDAOPokemon();
        Pokemon poke = dao.getById(nom);
        return poke;
    }
	@Override
	public String ask(Tweet question) {
		if (question.getText().contains("Owner?")) {
            poke = recupInfo(question.getText());
            if (poke.getEleveur() != null) {
              return "@" + question.getScreenName() + " @" + poke.getEleveur()
            		  + " is my owner";
            } else {
                return "@" + question.getScreenName() + " No owner";
            }
		}
		return null;
	}
}











