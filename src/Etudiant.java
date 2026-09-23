import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Etudiant {

    private Identite id;
    private HashMap<String, ArrayList<Double>> notes;
    private Formation form;

    public Etudiant(Identite i,Formation f) {
        this.id=i;
        this.form = f;
        this.notes = new HashMap<String,ArrayList<Double>>();
        Set<String> keys = f.getmat().keySet();
        Iterator<String> iter = keys.iterator();
        while(iter.hasNext() ) {

            String m = iter.next();
            this.notes.put(m,new ArrayList<Double>());

        }

    }

    public Identite getId() {
        return this.id;
    }

    public HashMap<String, ArrayList<Double>> getNotes(){
        return this.notes;
    }

    public boolean ajoutNote(String mat,Double note) {
        if(note>=0.0 && note <=20.0){
            if(this.notes.containsKey(mat)){
                ArrayList<Double> d= this.notes.get(mat);
                d.add(note);
                this.notes.replace(mat,d);
                System.out.println("la note a bien pu être ajouter");
                return true;

            }
            else{
                System.out.println("la matière n est pas dans la formation");
                return false;
            }
        }
        return false;



    }

    public Double calcMoyMat(String mat) {
        int coef =0;
        Double somme=0.0;
        if(this.getNotes().containsKey(mat)){
            ArrayList<Double> tab =this.getNotes().get(mat);

            for(Double d:tab){
                somme+=d;
                coef++;
            }
            if(coef>0)return somme/coef;

            else return -1.0;


        }
        return -2.0;

    }

    public Double calcMoyGen() {
        Set<String> keys = this.notes.keySet();
        Iterator<String> iter = keys.iterator();
        Double moyGen=0.0;
        int totc=0;
        while(iter.hasNext()) {

            String m = iter.next();
            int coef = this.form.getCoef(m);
            if(this.calcMoyMat(m)!=-1.0){
                moyGen+=this.calcMoyMat(m)*coef;
                totc+=coef;
            }
        }
        return moyGen/totc;
    }







}

