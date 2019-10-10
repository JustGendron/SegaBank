package jdbc.bo;

public class Agence {
    private int identifiant;
    private int code;
    private String adresse;


    public Agence() {

    }

    public Agence(int code, String adresse) {
        this.code = code;
        this.adresse = adresse;
    }

    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "Agence{" +
                "code=" + code +
                ", adresse='" + adresse + '\'' +
                '}';
    }
}
