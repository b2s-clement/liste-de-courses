package model;

import java.util.ArrayList;

/**
 * Created by jambo on 01/02/17.
 */

public class Liste {

    private int id;
    private String nom;
    private ArrayList<Produit> liste ;

    private ArrayList<Liste> listListe = new ArrayList<Liste>();

    public Liste(int id, String n, ArrayList<Produit> liste) {
        this.id = id;
        this.nom = n;
        this.liste = liste;
    }


    public int getId() {
        return id;
    }

    public ArrayList<Produit> getListe() {
        return liste;
    }

    public void setListe(ArrayList<Produit> liste) {
        this.liste = liste;
    }

    public void addProduit(Produit p){
        liste.add(p);
    }
    public void removeProduit(Produit p){
        liste.remove(p);
    }

}
