package jdbc.bo;

public class Compte {

    private int identifiant;
    private float solde;

    public Compte() {
    }

    public Compte(int identifiant, float solde) {
        this.identifiant = identifiant;
        this.solde = solde;
    }

    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    public float getSolde() {
        return solde;
    }

    public void setSolde(float solde) {
        this.solde = solde;
    }


    public float versement(float montant){

        return montant;
    }

    public float retrait(float montant){
        return montant;
    }

}
