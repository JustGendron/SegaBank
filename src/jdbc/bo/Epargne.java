package bo;

public class Epargne extends Compte {

    private int tauxInteret;


    public Epargne(int identifiant, float solde, int tauxInteret) {
        super(identifiant, solde);
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

