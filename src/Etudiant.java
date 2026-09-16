import java.util.ArrayList;
import java.util.HashMap;

public class Etudiant {

    private Identite id;
    private HashMap<String, ArrayList<Double>> notes;

    public Etudiant(Identite i) {
        this.id=i;
    }
    public Etudiant(Identite i, HashMap<String, ArrayList<Double>> n) {
        this.id=i;
        this.notes=n;
    }

    public void ajoutNote(String mat,Double note) {
        //à compléter ...
        return;
    }

    public void calcMoyMat(String mat) {
        //à compléter ...
        return;
    }

    public void calcMoyGen() {
        //à compléter ...
        return;
    }





    public Identite getId() {
        return this.id;
    }

    public HashMap<String, ArrayList<Double>> getNotes(){
        return this.notes;
    }

}
