package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.twitter.Tweet;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class test
{
 
	public static void main(String[] args)
	{
 
		/* Ces 4 informations son disponibles sur la page principale de votre app Twitter
		 * Assurez-vous que votre application permet la lecture ET l'ecriture
		 */
 
		final String CONSUMER_KEY = "HnyufeNZ5MJOcW5kFVHkw";
		final String CONSUMER_SECRET = "nQguyagJ1Rg27BcXsQgcinefX7BTM4TZdHOH51LGFUU";
 
		final String ACCESS_TOKEN = "2370345271-KY0KnozUmmLiEszrTwulyzcxMdnU4Ipk07ETEPv";
		final String ACCESS_TOKEN_SECRET = "9y1eABVh5EowgyTNFmXnmkAuOh61yOAweFsJ8pT7a7cOp";
 
		String message = "Statut de test envoyé via la bibliothèque #Twitter4j.";
 
		AccessToken aToken;
 
		// Creation d'un objet Twitter
 
		String str;
		Tweet a = new Tweet("huyvin", "hello");
 
		PokemonCriesCell quest = new PokemonCriesCell();
		
		str = quest.ask(a);
		
		Twitter t = new TwitterFactory().getInstance();
 
		try
		{
				
			// Envoi du statut sur le compte
			t.updateStatus(str);
 
		}
		catch (TwitterException te)
		{
			System.err.println("Erreur, impossible d'envoyer le status.");
		}
 
	}
 
}