package jdbc.bo;

public class Epargne extends Compte {

    private float tauxInteret;
    private int id;

    public Epargne() {
    }

    public Epargne(float tauxInteret) {
        this.tauxInteret = tauxInteret;
    }

    public Epargne(int id, float tauxInteret) {
        super(id);
        this.tauxInteret = tauxInteret;
    }

    public Epargne(float solde, int idagence, float tauxInteret) {
        super(solde, idagence);
        this.tauxInteret = tauxInteret;
    }

    public float getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(float tauxInteret) {
        this.tauxInteret = tauxInteret;
    }

    public float calculInteret(float taux){
        return this.getSolde() * taux;
}

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public float retrait(float montant) {
        this.setSolde(this.getSolde()- montant);
        return (this.getSolde());

    }

    @Override
    public float versement(float montant) {

        this.setSolde(this.getSolde()+ montant);
        return (this.getSolde());
    }


}

