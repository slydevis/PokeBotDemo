package fr.univaix.iut.pokebattle.jpa;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DataObjectAttackTest {

    DataObjectAttack doa = new DataObjectAttack("1", "Troll", "999", "100", "69");
    @Test
    public void testPuissance() throws Exception {
        doa.setPuissance("2");
        assertEquals("2", doa.getPuissance());
    }

    @Test
    public void testPrecision() throws Exception {
        doa.setPrecision("23");
        assertEquals("23", doa.getPrecision());
    }

    @Test
    public void testPP() throws Exception {
        doa.setPP("9");
        assertEquals("9", doa.getPP());
    }

    @Test
    public void testNiveau() throws Exception {
        doa.setNiveau("4");
        assertEquals("4", doa.getNiveau());
    }

    @Test
    public void testSetNom() throws Exception {
        doa.setNom("TROLLMAGEDON");
        assertEquals("TROLLMAGEDON", doa.getNom());
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("DataObjectAttack{niveau='1', nom='Troll', puissance=999, precision=100, pp=69}", doa.toString());

    }
}
