package jdbc.bo;

public class Epargne extends Compte {

    private int tauxInteret;


    public Epargne(int tauxInteret) {
        this.tauxInteret = tauxInteret;
    }

    public int getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(int tauxInteret) {
        this.tauxInteret = tauxInteret;
    }

public float calculInteret(float taux){
     return taux;
}}

