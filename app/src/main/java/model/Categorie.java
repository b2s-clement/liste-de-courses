package model;

/**
 * Created by jambo on 01/02/17.
 */

public class Categorie {

    private int num;
    private String nom;

    public Categorie(int num, String nom) {
        this.num = num;
        this.nom = nom;
    }

    public int getNum() {
        return num;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
