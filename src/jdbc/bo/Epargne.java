package jdbc.bo;

public class Epargne extends Compte {

    private float tauxInteret;

    public Epargne() {
    }

    public Epargne(float tauxInteret) {
        this.tauxInteret = tauxInteret;
    }

    public Epargne(int id, float tauxInteret) {
        super(id);
        this.tauxInteret = tauxInteret;
    }

    public float getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(float tauxInteret) {
        this.tauxInteret = tauxInteret;
    }

public float calculInteret(float taux){
     return taux;
}}

