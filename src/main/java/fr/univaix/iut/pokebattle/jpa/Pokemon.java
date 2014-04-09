package fr.univaix.iut.pokebattle.jpa;

import javax.persistence.*;
import java.util.Arrays;


@Entity
@NamedQueries({
        @NamedQuery(name = Pokemon.FIND_ALL, query = "SELECT p FROM Pokemon p"),
        @NamedQuery(name = Pokemon.FIND_BY_TYPE, query = "SELECT p FROM Pokemon p WHERE p.type1 = :ftype")
})
public class Pokemon {

	public enum Type {
	    NORMAL,
	    FIRE,
	    FIGHTING,
	    WATER,
	    FLYING,
	    GRASS,
	    POISON,
	    ELECTRIC,
	    GROUND,
	    PSYCHIC,
	    ROCK,
	    ICE,
	    BUG,
	    DRAGON,
	    GHOST,
	    DARK,
	    STEEL
	}

    public static final String FIND_BY_TYPE = "findPokemonByType";
    public static final String FIND_ALL = "findAllPokemon";

    @Id
    private String name;

    @Enumerated(EnumType.STRING)
    private Type type1;

    @Enumerated(EnumType.STRING)
    private Type type2;

    private int baseHP;
    private int level;
    private int attack;
    private int defense;
    private int attackSpecial;
    private int defenseSpecial;
    private int speed;
    private int xp;
    private int pv;


    private String eleveur;


    protected Pokemon() {
    }

    public Pokemon(String name) {
        this.name = name;
    }

    public Pokemon(String name, String eleveur) {
        this.name = name;
        this.eleveur = eleveur;
    }

    public String getName() {
        return name;
    }

    public Type getType1() {
        return type1;
    }

    public void setType1(Type types1) {
        this.type1 = types1;
    }

    public Type getType2() {
        return type2;
    }

    public void setType2(Type types2) {
        this.type2 = types2;
    }

    public int getBaseHP() {
        return baseHP;
    }

    public void setBaseHP(int baseHP) {
        this.baseHP = baseHP;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getAttackSpecial() {
        return attackSpecial;
    }

    public void setAttackSpecial(int attackSpecial) {
        this.attackSpecial = attackSpecial;
    }

    public int getDefenseSpecial() {
        return defenseSpecial;
    }

    public void setDefenseSpecial(int defenseSpecial) {
        this.defenseSpecial = defenseSpecial;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getEleveur() {
        return eleveur;
    }

    public void setEleveur(String eleveur) {
        this.eleveur = eleveur;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getXP() {
        return xp;
    }

    public void setXP(int xp) {
        this.xp = xp;
    }

    public int getPV() {
        return pv;
    }

    public void setPV(int pv) {
        this.pv = pv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
        	return true;
        }
        if (!(o instanceof Pokemon)) {
        	return false;
        }

        Pokemon pokemon = (Pokemon) o;

        if (attack != pokemon.attack) {
        	return false;
        }
        if (attackSpecial != pokemon.attackSpecial) {
        	return false;
        }
        if (baseHP != pokemon.baseHP) {
        	return false;
        }
        if (defense != pokemon.defense) {
        	return false;
        }
        if (defenseSpecial != pokemon.defenseSpecial) {
        	return false;
        }
        if (speed != pokemon.speed) {
        	return false;
        }
        if (name != null ? !name.equals(pokemon.name) : pokemon.name != null) {
        	return false;
        }
        if (type1 != pokemon.type1) {
        	return false;
        }
        if (type2 != pokemon.type2) {
        	return false;
        }
        if (eleveur != pokemon.eleveur) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (type1 != null ? type1.hashCode() : 0);
        result = 31 * result + (type2 != null ? type2.hashCode() : 0);
        result = 31 * result + baseHP;
        result = 31 * result + attack;
        result = 31 * result + defense;
        result = 31 * result + attackSpecial;
        result = 31 * result + defenseSpecial;
        result = 31 * result + speed;
        result = result + (eleveur != null ? eleveur.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Pokemon{"
        		+ "name='" + name + '\''
                + ", types1=" + type1
                + ", types2=" + type2
                + ", baseHP=" + baseHP
                + ", attack=" + attack
                + ", defense=" + defense
                + ", attackSpecial=" + attackSpecial
                + ", defenseSpecial=" + defenseSpecial
                + ", speed=" + speed
                + ", eleveur=" + eleveur
                + '}';
    }
}
