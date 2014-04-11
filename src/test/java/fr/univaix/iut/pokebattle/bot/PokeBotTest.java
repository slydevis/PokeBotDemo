package fr.univaix.iut.pokebattle.bot;

import fr.univaix.iut.pokebattle.jpa.DAOFactoryJPA;
import fr.univaix.iut.pokebattle.jpa.DAOPokemon;
import fr.univaix.iut.pokebattle.twitter.Tweet;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.eclipse.persistence.internal.jpa.EntityManagerImpl;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;

import static org.junit.Assert.assertEquals;

/**
 * Integration tests checking the PokeBot
 * behavior. We just test some cases to make sure that the
 * PokeBot is using smartcell properly.
 */
public class PokeBotTest {
    private PokeBot pokeBot = new PokeBot();

    private Twitter twitter = Mockito.mock(Twitter.class);
    private static EntityManager entityManager;
    private static FlatXmlDataSet dataset;
    private static DatabaseConnection dbUnitConnection;
    private static EntityManagerFactory entityManagerFactory;
    private static DAOPokemon dao;
    @BeforeClass
    public static void initTestFixture() throws Exception {
        entityManagerFactory = Persistence.createEntityManagerFactory("pokebattlePUTest");
        entityManager = entityManagerFactory.createEntityManager();
        DAOFactoryJPA.setEntityManager(entityManager);

        dao = DAOFactoryJPA.createDAOPokemon();

        Connection connection = ((EntityManagerImpl) (entityManager.getDelegate())).getServerSession().getAccessor().getConnection();

        dbUnitConnection = new DatabaseConnection(connection);
        //Loads the data set from a file
        dataset = new FlatXmlDataSetBuilder().build(Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream("pokemonDataset.xml"));
    }

    @AfterClass
    public static void finishTestFixture() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }

    @Before
    public void setUp() throws Exception {
        //Clean the data from previous test and insert new data test.
        pokeBot.setTwitter(twitter);
        DatabaseOperation.CLEAN_INSERT.execute(dbUnitConnection, dataset);
    }

    @Test
    public void testSalut() throws TwitterException {
        assertEquals("Fleeex...zZz", pokeBot.ask(new Tweet("Salut")));
        assertEquals("Fleeex...zZz", pokeBot.ask(new Tweet("This is not a question.")));
        assertEquals("@nedseb RON-FLEEEX", pokeBot.ask(new Tweet("nedseb", "Salut")));
        assertEquals("@nedseb RON-FLEEEX", pokeBot.ask(new Tweet("nedseb", "This is not a question.")));

    }

    @Test
    public void testOwner() throws TwitterException {
    	assertEquals("@slydevis No owner", pokeBot.ask(new Tweet("slydevis", "@Rattata Owner?")));
    }


    @Test
    public void testBadAtk() throws TwitterException {
    	assertEquals("@nedseb RON-FLEEEX", pokeBot.ask(new Tweet("nedseb", "attack")));
    }

    @Test
    public void testAtk() throws TwitterException {
    	assertEquals("@bulbizarre #attack #plaquage! /cc @slydevis", pokeBot.ask(new Tweet(
    			"slydevis", "@Pikachu #attack #plaquage @bulbizarre")));
    }

    @Test
    public void testbadOwnerAtk() throws TwitterException {
    	assertEquals("@slydevis is my owner", pokeBot.ask(new Tweet(
    			"nedseb", "@Pikachu #attack #plaquage @bulbizarre")));
    }

    @Test
    public void testunknwonAtk() throws TwitterException {
    	assertEquals("@slydevis ZzZz...Fleeex?", pokeBot.ask(new Tweet(
    			"slydevis", "@Pikachu #attack @bulbizarre")));
    }

    @Test
    public void testOwnerEnemyAtk() throws TwitterException {
    	assertEquals("@bulbizarre #attack #plaquage! /cc @gantben @slydevis", pokeBot.ask(new Tweet(
    			"slydevis", "@Pikachu #attack #plaquage @bulbizarre /cc @gantben")));
    }

    @Test
    public void testCatchPoke() throws TwitterException {
        assertEquals("@slydevis @nedseb is my owner", pokeBot.ask(new Tweet("slydevis", "@Ronflaix Pokeball!")));
    }

    @Test
    public void testTroll() throws TwitterException {
        assertEquals("@slydevis Trolol http://www.dailymotion.com/video/xtczcf_gandalf-epic-sax-guy_fun",
                pokeBot.ask(new Tweet("slydevis", "@Ronflaix Troll")));
    }

    @Test
    public void testKO() throws TwitterException {
        assertEquals("@Ronflaix #attack #charge! /cc @nedseb @slydevis", pokeBot.ask(new Tweet("slydevis", "@Pikachu #attack #charge @Ronflaix /cc @nedseb  ")));
        assertEquals("#KO /cc @viviane @nedseb @slydevis", pokeBot.ask(new Tweet("viviane", "@Pikachu -35pv /cc @slydevis")));
    }
}
