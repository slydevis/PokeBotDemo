package fr.univaix.iut.pokebattle.run;

import java.io.IOException;
import java.io.InputStream;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import fr.univaix.iut.pokebattle.bot.PokeBot;
import fr.univaix.iut.pokebattle.tuse.TUSEException;

public class TestRun {

	@Test
	public void testConstruct() {
		InputStream input = BotRunner.getResourceAsStream("testCredentials.properties");
		assertThat(input).isNotNull();
	}

	@Test
	public void testRun() throws TUSEException, IOException {
		PokeBot boot = new PokeBot();
		BotRunner.runBot(boot, "testCredentials.properties");
	}

	@Test
	public void testRun2() throws TUSEException, IOException {
		PokeBot boot = new PokeBot();
		BotRunner.runBot(boot, "testCredentials.properties");
	}

	@Test(expected = Exception.class)
	public void testRun3() throws TUSEException, IOException {
		PokeBot boot = new PokeBot();
		BotRunner.runBot(boot, "FichierInexistant.txt");
	}

	@Test(expected = Exception.class)
	public void testnoPkmnrun() throws TUSEException, IOException {
		BotRunner.runBot(null, "testCredentials.properties");
	}

	@Test
    public void testInstance1() {
    	assertThat(BotRunner.getInstance()).isNotNull();
    }

}
