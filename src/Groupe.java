import java.util.ArrayList;

public class Groupe {

    private Formation form;
    private ArrayList<Etudiant> etudiants;

    public Groupe(Formation f) {
        this.form = f;
        this.etudiants = new ArrayList<Etudiant>();
    }

    public void ajoutEtu(Etudiant e) {
        if ( e.getForm().getId() == form.getId() ) {
            boolean present = false;
            for (Etudiant e2 : this.etudiants) {
                if ( e.getId().getNip() == e2.getId().getNip() ) present = true;
            }
            if(!present) {
                this.etudiants.add(e);
            }
        }
    }

    public void suppEtu(Etudiant e) {
        if ( e.getForm().getId() == form.getId() ) {
            for (int i = 0; i < this.etudiants.size(); i++) {
                if ( e.getId().getNip() == this.etudiants.get(i).getId().getNip() ) this.etudiants.remove(i);
            }
        }
        else {
            System.out.println("l'étudiant n'a pas la meme formation");
        }
    }

    public boolean present(Etudiant e ){
        if ( e.getForm().getId() == form.getId() ) {
            boolean present = false;
            for (Etudiant e2 : this.etudiants) {
                if ( e.getId().getNip() == e2.getId().getNip() ) present = true;
            }
            if(present) {
                return true;
            }
        }
        return false;
    }

    public double calcMoyMat(String mat){
        if (this.form.getmat().containsKey(mat)) {
            int coef = 0;
            double m = 0.0;
            for(Etudiant e : this.etudiants){
                m+=e.calcMoyMat(mat);
                coef++;
            }
            return m/coef;

        }
        return -1.0;

    }

    public double calcMoyGen(){

        int coef = 0;
        double m = 0.0;
        for(Etudiant e : this.etudiants){
            m+=e.calcMoyGen();
            coef++;
        }
        return m/coef;



    }


}
