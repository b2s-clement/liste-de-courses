package model;

import java.util.ArrayList;

/**
 * Created by jambo on 01/02/17.
 */

public class Magasin {

    private int num;
    private String nom,ville,pays,type;
    private boolean checked;

    private static ArrayList<Magasin> listMag = new ArrayList<Magasin>();
    public static Magasin mag1 = new Magasin("Ici","Caen","France","Grande surface");
    public static Magasin mag2 = new Magasin("Là-bas","Bruxelles","Belgique","Friterie");


    public Magasin(String nom,String ville,String pays,String type) {
        this.num = Magasin.newIdMagasin();
        this.nom = nom;
        this.ville=ville;
        this.pays=pays;
        this.type=type;
        this.checked = false;
        Magasin.listMag.add(this);
    }

    public int getNum() {
        return num;
    }

    public String getNom() {
        return nom;
    }

    public static String getNom(int n){
        String res = "";
        for(Magasin m : listMag){
            if(m.getNum()==n) {
                res = m.getNom();
            }
        }
        return res;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public static ArrayList<Magasin> getData(){
        return listMag;
    }

    public String getVille(){
        return ville;
    }
    public String getPays(){
        return pays;
    }

    public void setVille(String s){
        ville = s;
    }
    public void setPays(String s){
        pays = s;
    }

    public boolean getChecked(){
        return checked;
    }
    public void setChecked(boolean val){
        checked=val;
    }

    public static int nbChecked(){
        int res = 0;
        for(Magasin mag : listMag){
            if(mag.getChecked()){
                res++;
            }
        }
        return res;
    }
    public static void resetSelection(){
        for(Magasin mag : listMag){
            mag.setChecked(false);
        }
    }

    public static Magasin getMagasin(int n){
        Magasin m = null;
        for(Magasin mag : listMag){
            if(n==mag.getNum()){
                m=mag;
            }
        }
        return m;
    }

    public static int newIdMagasin(){
        int res = 0;
        for(Magasin m : listMag){
            if(m.getNum()>res){
                res = m.getNum();
            }
        }
        return res +1;
    }
}
