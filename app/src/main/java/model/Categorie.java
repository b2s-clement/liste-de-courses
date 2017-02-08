package model;

import java.util.ArrayList;

/**
 * Created by jambo on 01/02/17.
 */

public class Categorie {

    private int num;
    private String nom;

    private static ArrayList<Categorie> listCat = new ArrayList<Categorie>();

    public Categorie(int num, String nom) {
        this.num = num;
        this.nom = nom;
        listCat.add(this);
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

    public static ArrayList<Categorie> getData(){return listCat;}
}
