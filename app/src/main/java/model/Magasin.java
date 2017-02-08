package model;

import java.util.ArrayList;

/**
 * Created by jambo on 01/02/17.
 */

public class Magasin {

    private int num;
    private String nom,ville,pays,type;

    private static ArrayList<Magasin> listMag = new ArrayList<Magasin>();

    public Magasin(int num, String nom,String ville,String pays,String type) {
        this.num = num;
        this.nom = nom;
        this.ville=ville;
        this.pays=pays;
        this.type=type;
        Magasin.listMag.add(this);
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

    public static ArrayList<Magasin> getData(){
        return listMag;
    }
}
