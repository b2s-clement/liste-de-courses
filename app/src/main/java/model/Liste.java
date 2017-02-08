package model;

import java.util.ArrayList;

/**
 * Created by jambo on 01/02/17.
 */

public class Liste {

    private int id;
    private String nom;
    private ArrayList<Produit> liste ;
    private double total;

    private static ArrayList<Liste> listListe = new ArrayList<Liste>();

    public Liste(int id, String n, ArrayList<Produit> liste) {
        this.id = id;
        this.nom = n;
        this.liste = liste;
        double tot = 0;
        for(Produit p : liste){
            tot+=p.getPrix();
        }
        this.total = tot;
        listListe.add(this);
    }


    public int getId() {
        return id;
    }

    public ArrayList<Produit> getListe() {
        return liste;
    }

    public void setListe(ArrayList<Produit> liste) {
        this.liste = liste;
        double tot = 0;
        for(Produit p : liste){
            tot+=p.getPrix();
        }
        this.total = tot;
    }

    public void addProduit(Produit p){
        liste.add(p);
        total+=p.getPrix();
    }
    public void removeProduit(Produit p){
        liste.remove(p);
        total-=p.getPrix();
    }

    public static ArrayList<Liste> getData(){
        return listListe;
    }
}
