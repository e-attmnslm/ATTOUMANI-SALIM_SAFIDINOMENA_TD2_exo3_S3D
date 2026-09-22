import java.util.HashMap;

public class Formation {
    private String id_form;
    private HashMap<String,Integer> matieres;

    public Formation(String id_form) {
        this.id_form = id_form;
        this.matieres = new HashMap<String,Integer>();
    }

    public void ajoutMat(String s, int n){
        if (matieres.containsKey(s)){
            System.out.println("Matière existante");
        } else {
            matieres.put(s,n);
        }
    }

    public void supMat(String s){
        if (! matieres.containsKey(s)){
            System.out.println("Matière inexistante");
        } else {
            matieres.remove(s);
        }
    }

    public int getCoef(String s){
        return matieres.get(s);
    }
    public HashMap<String,Integer> getmat(){
        return this.matieres;
    }

}
