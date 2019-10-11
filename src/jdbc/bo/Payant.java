package jdbc.bo;

public class Payant extends Compte {
    private int id;

    public Payant() {
    }

    public Payant(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
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
