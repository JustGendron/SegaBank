package bo;

public class Payant extends Compte {

    public Payant(int identifiant, float solde) {
        super(identifiant, solde);
    }

    @Override
    public float versement(float montant) {
        return super.versement(montant);
    }

    @Override
    public float retrait(float montant) {
        return super.retrait(montant);
    }
}
