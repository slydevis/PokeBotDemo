package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.jpa.Pokemon;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class UpdateBioCell {
    public static String update(Pokemon poke) {
        Twitter twitter = TwitterFactory.getSingleton();

        String owner;

        if (poke.getEleveur() != null) {
            owner = "@" + poke.getEleveur();
        } else {
            owner = "No Owner";
        }

        String answer = "#pokebattle - #pokemon - Owner: " + owner + " - Level: " + poke.getLevel();
        try {
            twitter.updateProfile(poke.getName(), "", "", answer);
            return answer;
        } catch (TwitterException e) {
            e.printStackTrace();
            return "Error";
        }
    }
}
