package jdbc.bo;

public class Payant extends Compte {

    public Payant() {
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
