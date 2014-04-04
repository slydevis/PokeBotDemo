package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.jpa.Pokemon;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class UpdateBioCell {
    public static String update(Pokemon poke) {
        Twitter twitter = TwitterFactory.getSingleton();
        try {
            twitter.updateProfile("@" + poke.getName(), "", "",
                    "#pokebattle - #pokemon - Owner: @"+ poke.getEleveur() + " - Level: " + poke.getLevel());
            return "#pokebattle - #pokemon - Owner: @"+ poke.getEleveur() + " - Level: " + poke.getLevel();
        } catch (TwitterException e) {
            e.printStackTrace();
            return "Error";
        }
    }
}
