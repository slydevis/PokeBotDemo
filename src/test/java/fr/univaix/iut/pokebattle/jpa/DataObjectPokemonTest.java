package fr.univaix.iut.pokebattle.jpa;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DataObjectPokemonTest {

    DataObjectPokemon daop = new DataObjectPokemon();

    @Test
    public void testNom() throws Exception {
        daop.setNom("Toto");
        assertEquals("Toto", daop.getNom());
    }

    @Test
    public void testEspece() throws Exception {
        daop.setEspece("Trolol");
        assertEquals("Trolol", daop.getEspece());
    }

    @Test
    public void testTaille() throws Exception {
        daop.setTaille(1.20f);
        assertEquals(1.20f, daop.getTaille(), 'f');
    }

    @Test
    public void testPoids() throws Exception {
        daop.setPoids(999f);
        assertEquals(999f, daop.getPoids(), 'f');
    }

    @Test
    public void testFmratio() throws Exception {
        daop.setFmratio(23f);
        assertEquals(23f, daop.getFmratio(), 'f');
    }

    @Test
    public void testEffortval() throws Exception {
        daop.setEffortval("20");
        assertEquals("20", daop.getEffortval());
    }

    @Test
    public void testType1() throws Exception {
        daop.setType1("ELECTRIC");
        assertEquals("ELECTRIC", daop.getType1());
    }

    @Test
    public void testType2() throws Exception {
        daop.setType2("NORMAL");
        assertEquals("NORMAL", daop.getType2());
    }

    @Test
    public void testExpval() throws Exception {
        daop.setExpval(10);
        assertEquals(10, daop.getExpval());
    }

    @Test
    public void testExpmax() throws Exception {
        daop.setExpmax(20);
        assertEquals(20, daop.getExpmax());
    }

    @Test
    public void testCaptureval() throws Exception {
        daop.setCaptureval(29);
        assertEquals(29, daop.getCaptureval());
    }

    @Test
    public void testCapspe1() throws Exception {
        daop.setCapspe1("Yolo");
        assertEquals("Yolo", daop.getCapspe1());
    }

    @Test
    public void testCapspe2() throws Exception {
        daop.setCapspe2("Mouii");
        assertEquals("Mouii", daop.getCapspe2());
    }

    @Test
    public void testCouleur() throws Exception {
        daop.setCouleur("BLUE");
        assertEquals("BLUE", daop.getCouleur());
    }

    @Test
    public void testForme() throws Exception {
        daop.setForme(42);
        assertEquals(42, daop.getForme());
    }

    @Test
    public void testAttaques() throws Exception {
        DataObjectAttack [] monTableau = new DataObjectAttack[2];
        monTableau[0] = new DataObjectAttack("Yolo", "100","75","45","2");
        monTableau[1] = new DataObjectAttack("?", "100","75","45","2");
        daop.setAttaques(monTableau);
        assertEquals(monTableau.toString(), daop.getAttaques().toString());
    }

    @Test
    public void testToString() throws Exception {
        DataObjectPokemon dataObjectPokemon = new DataObjectPokemon();
        assertEquals("DataObjectPokemon{nom='null', espece='null', taille=0.0, poids=0.0, fmratio=0.0, effortval='null', type1='null', type2='null', expval=0, expmax=0, captureval=0, capspe1='null', capspe2='null', couleur='null', forme=0, attaques=null}", daop.toString());
        assertEquals("DataObjectPokemon{nom='null', espece='null', taille=0.0, poids=0.0, fmratio=0.0, effortval='null', type1='null', type2='null', expval=0, expmax=0, captureval=0, capspe1='null', capspe2='null', couleur='null', forme=0, attaques=null}", dataObjectPokemon.toString());
    }
}
