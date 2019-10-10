package jdbc.bo;

public class Simple extends Compte {

    private float decouvert;
    private int id;

    public Simple() {
        super();
    }

    public Simple(int code, float solde, int idagence, float decouvert) {
        super(code, solde, idagence);
        this.decouvert = decouvert;
    }

    public Simple(int id, float decouvert) {
        this.decouvert = decouvert;
        this.id = id;
    }

    public float getDecouvert() {
        return decouvert;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setDecouvert(float decouvert) {
        this.decouvert = decouvert;
    }


    @Override
    public float retrait(float montant) {
        return super.retrait(montant);
    }

    @Override
    public String toString() {
        return super.toString()+
                "decouvert=" + decouvert + '}';
    }
}


