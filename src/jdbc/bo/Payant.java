package jdbc.bo;

public class Payant extends Compte {
    private int id;

    public Payant() {
    }

    public Payant(float solde, int idagence) {
        super(solde, idagence);
    }

    public Payant(int id) {
        this.id = id;
    }

    public Payant(float solde, int idagence, int id) {
        super(solde, idagence);
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setCode(int code) {
        super.setCode(code);
    }

    @Override
    public float versement(float montant) {
        float taxe = (float) (montant*0.05);
        super.setSolde(super.getSolde()+montant-taxe);
        return super.getSolde();
    }

    @Override
    public float retrait(float montant) {
        float taxe = (float) (montant*0.05);
        super.setSolde(super.getSolde()-montant-taxe);
        return super.getSolde();
    }


    @Override
    public void setId(int id) {
        this.id = id;
    }
}
