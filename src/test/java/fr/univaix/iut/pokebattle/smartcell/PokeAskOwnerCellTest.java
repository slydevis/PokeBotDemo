package fr.univaix.iut.pokebattle.smartcell;

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

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;

import static org.junit.Assert.assertEquals;

public class PokeAskOwnerCellTest {

    private static EntityManager entityManager;
    private static FlatXmlDataSet dataset;
    private static DatabaseConnection dbUnitConnection;
    private static EntityManagerFactory entityManagerFactory;
    private static DAOPokemon dao;

    private PokeAskOwnerCell cell = new PokeAskOwnerCell();

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
        DatabaseOperation.CLEAN_INSERT.execute(dbUnitConnection, dataset);
    }

    @Test
	public void testEleveur() {
		assertEquals("@huyvin @slydevis is my owner", cell.ask(new Tweet("huyvin", "@Pikachu Owner?")));
	}

    @Test
    public void testSansEleveur() {

        assertEquals("@huyvin No owner", cell.ask(new Tweet("huyvin", "@Rattata Owner?")));
    }
}
