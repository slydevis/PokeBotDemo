package fr.univaix.iut.pokebattle.run;

import fr.univaix.iut.pokebattle.bot.PokeBot;
import fr.univaix.iut.pokebattle.jpa.DAOFactoryJPA;
import fr.univaix.iut.pokebattle.jpa.DAOPokemon;
import fr.univaix.iut.pokebattle.jpa.Pokemon;
import fr.univaix.iut.pokebattle.tuse.TUSEException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class PokemonMain {
    private static final Logger LOGGER = LoggerFactory.getLogger(PokemonMain.class);

    private PokemonMain() {

    }

    private static Map<String, String> createConfigurationMap() throws URISyntaxException {
        URI dbUri = new URI("postgres://uxmkwioofjunwk:-_KhHXYpfh8urU46Nu6l3m6NBA@ec2-54-197-241-96.compute-1.amazonaws.com:5432/d946ute9ed9erl");
        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath() + "?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";

        Map<String, String> props = new HashMap<String, String>();
        props.put("javax.persistence.jdbc.driver", "org.postgresql.Driver");
        props.put("eclipselink.target-database", "PostgreSQL");
        props.put("javax.persistence.jdbc.url", dbUrl);
        props.put("javax.persistence.jdbc.user", username);
        props.put("javax.persistence.jdbc.password", password);
        return props;
    }

    public static void main(String[] args) throws URISyntaxException {
        try {
            Map<String, String> props = createConfigurationMap();

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("pokebattlePU", props);
            EntityManager em = emf.createEntityManager();

            DAOFactoryJPA.setEntityManager(em);

            DAOPokemon pokemon = DAOFactoryJPA.createDAOPokemon();

            BotRunner.runBot(new PokeBot(), "twitter4j.properties");
        } catch (TUSEException e) {
            LOGGER.error("Erreur sérieuse dans le BotRunner", e);
        }
    }
}
