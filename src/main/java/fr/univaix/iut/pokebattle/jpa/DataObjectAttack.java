package fr.univaix.iut.pokebattle.jpa;

public class DataObjectAttack {
    private String niveau;
    private String nom;
    private String puissance;
    private String precision;
    private String pp;

    public DataObjectAttack(String niveau, String nom, String puissance, String precision, String pp) {
        this.niveau = niveau;
        this.nom = nom;
        this.puissance = puissance;
        this.precision = precision;
        this.pp = pp;
    }

    public String getPuissance() {
        return puissance;
    }

    public void setPuissance(String puissance) {
        this.puissance = puissance;
    }

    public String getPrecision() {
        return precision;
    }

    public void setPrecision(String precision) {
        this.precision = precision;
    }

    public String getPP() {
        return pp;
    }

    public void setPP(String pp) {
        this.pp = pp;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "DataObjectAttack{"
                + "niveau='" + niveau + '\''
                + ", nom='" + nom + '\''
                + ", puissance=" + puissance
                + ", precision=" + precision
                + ", pp=" + pp
                + '}';
    }
}