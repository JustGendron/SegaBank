package jdbc.bo;

public class Simple extends Compte {

    private float decouvert;

    public Simple(int identifiant, float solde, float decouvert) {
        super(identifiant, solde);
        this.decouvert = decouvert;
    }

    public float getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(float decouvert) {
        this.decouvert = decouvert;
    }

    @Override
    public float retrait(float montant) {
        return super.retrait(montant);
    }
}
