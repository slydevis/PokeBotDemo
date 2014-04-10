package fr.univaix.iut.pokebattle.jpa;

import java.util.Arrays;

public class DataObjectPokemon {
    private String nom;
    private String espece;
    private float taille;
    private float poids;
    private float fmratio;
    private String effortval;
    private String type1;
    private String type2;
    private int expval;
    private int expmax;
    private int captureval;
    private String capspe1;
    private String capspe2;
    private String couleur;
    private int forme;

    private DataObjectAttack[] attaques;

    public DataObjectPokemon() {
    }

    public DataObjectPokemon(String nom,
                            DataObjectAttack[] attaques) {
        this.nom = nom;
        this.attaques = attaques;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEspece() {
        return espece;
    }

    public void setEspece(String espece) {
        this.espece = espece;
    }

    public float getTaille() {
        return taille;
    }

    public void setTaille(float taille) {
        this.taille = taille;
    }

    public float getPoids() {
        return poids;
    }

    public void setPoids(float poids) {
        this.poids = poids;
    }

    public float getFmratio() {
        return fmratio;
    }

    public void setFmratio(float fmratio) {
        this.fmratio = fmratio;
    }

    public String getEffortval() {
        return effortval;
    }

    public void setEffortval(String effortval) {
        this.effortval = effortval;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public int getExpval() {
        return expval;
    }

    public void setExpval(int expval) {
        this.expval = expval;
    }

    public int getExpmax() {
        return expmax;
    }

    public void setExpmax(int expmax) {
        this.expmax = expmax;
    }

    public int getCaptureval() {
        return captureval;
    }

    public void setCaptureval(int captureval) {
        this.captureval = captureval;
    }

    public String getCapspe1() {
        return capspe1;
    }

    public void setCapspe1(String capspe1) {
        this.capspe1 = capspe1;
    }

    public String getCapspe2() {
        return capspe2;
    }

    public void setCapspe2(String capspe2) {
        this.capspe2 = capspe2;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public int getForme() {
        return forme;
    }

    public void setForme(int forme) {
        this.forme = forme;
    }

    public DataObjectAttack[] getAttaques() {
        return attaques;
    }

    public void setAttaques(DataObjectAttack[] attaques) {
        this.attaques = attaques;
    }

    @Override
    public String toString() {
        return "DataObjectPokemon{"
                + "nom='" + nom + '\''
                + ", espece='" + espece + '\''
                + ", taille=" + taille
                + ", poids=" + poids
                + ", fmratio=" + fmratio
                + ", effortval='" + effortval + '\''
                + ", type1='" + type1 + '\''
                + ", type2='" + type2 + '\''
                + ", expval=" + expval
                + ", expmax=" + expmax
                + ", captureval=" + captureval
                + ", capspe1='" + capspe1 + '\''
                + ", capspe2='" + capspe2 + '\''
                + ", couleur='" + couleur + '\''
                + ", forme=" + forme
                + ", attaques=" + (attaques == null ? null : Arrays.asList(attaques))
                + '}';
    }
}

