package jdbc.bo;

public class Compte {

    private int code;
    private int id;
    private float solde;
    private int idagence;

    public Compte() {

    }

    public Compte(int id) {
        this.id = id;
    }

    public Compte(float solde, int idagence) {

        this.solde = solde;
        this.idagence = idagence;
    }

    public Compte(int code, int id, float solde, int idagence) {
        this.code = code;
        this.id = id;
        this.solde = solde;
        this.idagence = idagence;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public float getSolde() {
        return solde;
    }

    public void setSolde(float solde) {
        this.solde = solde;
    }

    public int getIdagence() {
        return idagence;
    }

    public void setIdagence(int idagence) {
        this.idagence = idagence;
    }

    public float versement(float montant){
        this.setSolde( montant+this.getSolde());

        return this.getSolde();

    }

    public float retrait(float montant){
        this.setSolde(this.getSolde()-montant);
        return this.getSolde();
    }

    @Override
    public String toString() {
        return "Compte{" +
                "code=" + code +
                ", id=" + id +
                ", solde=" + solde +
                ", idagence=" + idagence +
                ' ';
    }
}
