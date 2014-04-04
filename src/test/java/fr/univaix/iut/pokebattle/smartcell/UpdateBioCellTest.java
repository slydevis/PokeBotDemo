package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.jpa.Pokemon;
import junit.framework.Assert;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class UpdateBioCellTest {
    UpdateBioCell updateBioCell = new UpdateBioCell();
    @Test
    public void testUpdate() throws Exception {
        Pokemon poke = new Pokemon("Ronflaix");
        poke.setLevel(100);
        poke.setEleveur("slydevis");
        assertEquals("#pokebattle - #pokemon - Owner: @slydevis - Level: 100", updateBioCell.update(poke));
    }
}
