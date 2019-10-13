package jdbc.bo;

public class Simple extends Compte {

    private float decouvert;
    private int id;

    public Simple() {

    }

    public Simple( float solde, int idagence, float decouvert) {
        super(solde, idagence);
        this.decouvert = decouvert;
    }

    public Simple(int id, float decouvert) {
        this.decouvert = decouvert;
        this.id = id;
    }

    public Simple(int id, float solde, int idagence, float decouvert) {
        super(solde, idagence);
        this.id = id;
        this.decouvert = decouvert;
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
    public int getCode() {
        return super.getCode();
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
    public float versement(float montant) {

        this.setSolde(this.getSolde()+montant);
        return super.versement(this.getSolde());
    }

    @Override
    public String toString() {
        return super.toString()+
                "decouvert=" + decouvert + '}'+
                id+"";
    }
}


