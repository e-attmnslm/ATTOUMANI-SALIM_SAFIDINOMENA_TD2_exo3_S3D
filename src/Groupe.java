import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

    public ArrayList<Etudiant> triAlpha(){
        Collections.sort(this.etudiants);
        return this.etudiants;
    }

    public ArrayList<Etudiant> triParMerite() {
        Collections.sort(this.etudiants, new Comparator<Etudiant>() {
            @Override
            public int compare(Etudiant e1, Etudiant e2) {
                Double moy1 = e1.calcMoyGen();
                Double moy2 = e2.calcMoyGen();
                return Double.compare(moy2, moy1);
            }
        });
        return this.etudiants;
    }

    public ArrayList<Etudiant> triAntiAlpha(){
        Collections.sort(this.etudiants);
        Collections.reverse(this.etudiants);
        return this.etudiants;
    }

    public ArrayList<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(ArrayList<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }
}
