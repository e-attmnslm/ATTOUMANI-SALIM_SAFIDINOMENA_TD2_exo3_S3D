public class Identite {
    private String nip;
    private String nom;
    private String prenom;

    public Identite(String nip, String n, String p) {
        this.nip=nip;
        this.nom=n;
        this.prenom=p;

    }

    public String getNip() {
        return this.nip;
    }

    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }
}
