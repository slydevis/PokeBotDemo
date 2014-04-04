package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.jpa.DAOFactoryJPA;
import fr.univaix.iut.pokebattle.jpa.DAOPokemon;
import fr.univaix.iut.pokebattle.jpa.Pokemon;
import fr.univaix.iut.pokebattle.run.PokemonMain;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class AfficheStatCell {

    private Pokemon poke;

    public String getNomPoke(String str) {
        String tmp = "";
        boolean ajoutnom = false;
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) == ' ') {
            	break;
            }
        	if (ajoutnom) {
                tmp += str.charAt(i);
        	}
            if (str.charAt(i) == '@') {
            	ajoutnom = true;
            }
        }
        return tmp;
    }

    public Pokemon recupInfo(String texte) {
        String nom = getNomPoke(texte);
        DAOPokemon dao = DAOFactoryJPA.createDAOPokemon();
        Pokemon poke = dao.getById(nom);
        return poke;
    }

	public String decode(Tweet question) {
		String text = question.getText(); //Cette variable récupère le contenu du tweet
		String stat = "";
		for (int i = 6; i < text.length(); ++i) {
			if (text.charAt(i) == ' ') {
				break;
			}
			stat += text.charAt(i);
		}
		int chiffre;
		poke = PokemonMain.getPokemon();
		switch(stat) {
			case "#PV":
				chiffre = poke.getBaseHP();
				break;
			case "#attack":
				chiffre = poke.getAttack();
				break;
			case "#defense":
				chiffre = poke.getDefense();
				break;
			case "#attack spe":
				chiffre = poke.getAttackSpecial();
				break;
			case "#defense spe":
				chiffre = poke.getDefenseSpecial();
				break;
			case "#speed":
				chiffre = poke.getSpeed();
				break;
			default:
				chiffre = -1;
		}
		if (chiffre == -1) {
			return '@' + question.getScreenName() + " stat?";
		} else {
			return '@' + question.getScreenName() + ' ' + stat + '=' + chiffre;
		}
	}


	public String ask(Tweet question) {
		if (question.getText().contains("#stat")) {
            return decode(question);
        } else {
            return null;
        }
	}

}
