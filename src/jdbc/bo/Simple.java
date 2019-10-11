package jdbc.bo;

public class Simple extends Compte {

    private float decouvert;
    private int id;

    public Simple() {
        super();
    }

    public Simple( float solde, int idagence, float decouvert) {
        super(solde, idagence);
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
        float resp = this.getSolde();
        if (this.getSolde()-montant >= this.getDecouvert()){
            this.setSolde(this.getSolde()-montant);
             resp = this.getSolde();
        }
        return resp;

    }

    @Override
    public String toString() {
        return super.toString()+
                "decouvert=" + decouvert + '}';
    }
}


