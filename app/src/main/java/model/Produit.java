package model;

import java.util.ArrayList;

/**
 * Created by jambo on 01/02/17.
 */

public class Produit {

    //Sert à calculer l'id automatiquement:
    private static int nbProduits = 1;

    private String nom ;
    private int quantite, id; //id = code barre
    private double promotion, prix;
    private Magasin emplacement;
    private Categorie categorie;

    private static ArrayList<Produit> listProd = new ArrayList<Produit>();

    public Produit(String nom, int quantite, double promotion, double prix,
                   Magasin emplacement, Categorie c) {
        this.nom = nom;
        this.quantite = quantite;
        this.promotion = promotion;
        this.prix = prix;
        this.emplacement = emplacement;
        this.categorie = c;
        this.id = Produit.nbProduits;
        Produit.nbProduits++;
        Produit.listProd.add(this);
    }


    public double getPromotion() {
        return promotion;
    }

    public void setPromotion(double promotion) {
        this.promotion = promotion;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Magasin getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(Magasin emplacement) {
        this.emplacement = emplacement;
    }

    public static ArrayList<Produit> getData(){
        return listProd;
    }
}
