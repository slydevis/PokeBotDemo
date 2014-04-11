package fr.univaix.iut.pokebattle.smartcell;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import scala.App;

import com.google.gson.Gson;

import fr.univaix.iut.pokebattle.jpa.DataObjectAttack;
import fr.univaix.iut.pokebattle.jpa.DataObjectPokemon;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class AskStatAttackCell implements SmartCell {

	public String ask(Tweet question) {

		if (question.getText().contains("#statAttack")) {

			String[] tabTweet = question.getText().split(" ");
			String attackName = tabTweet[3].replace("#", "");

			Gson gson = new Gson();
	        BufferedReader br = new BufferedReader(
	                              new InputStreamReader(App.class.getClassLoader().getResourceAsStream(
	                            		  "ronflex.json")));
	        DataObjectPokemon ronflex = gson.fromJson(br, DataObjectPokemon.class);
	        DataObjectAttack[] listAttack = ronflex.getAttaques();

	        for (int i = 0; i < listAttack.length; ++i) {
	        	if (attackName.equals(listAttack[i].getNom())) {
					if (tabTweet[2].equals("#PP")) {
						return "@" + question.getScreenName() + " " + tabTweet[3]
								+ " #PP= " + listAttack[i].getPP();
					} else if (tabTweet[2].equals("#PRECISION")) {
						return "@" + question.getScreenName() + " " + tabTweet[3]
								+ " #PRECISION= " + listAttack[i].getPrecision();
					} else if (tabTweet[2].equals("#NOM")) {
						return "@" + question.getScreenName() + " " + tabTweet[3]
								+ " #NOM= " + listAttack[i].getNom();
					} else if (tabTweet[2].equals("#PUISSANCE")) {
						return "@" + question.getScreenName() + " " + tabTweet[3]
								+ " #PUISSANCE= " + listAttack[i].getPuissance();
					} else if (tabTweet[2].equals("#NIVEAU")) {
						return "@" + question.getScreenName() + " " + tabTweet[3]
								+ " #NIVEAU= " + listAttack[i].getNiveau();
					} else {
						return "@" + question.getScreenName() + " Stat unknown";
					}
				}
	        } return "@" + question.getScreenName() + " Attack unknown";
		}
		return null;
	}
}