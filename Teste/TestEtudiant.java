import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestEtudiant {
    private Formation f ;
    private Etudiant e;

    @BeforeEach
    public void PreparationDonnee(){
        this.f = new Formation("form1");
        this.e = new Etudiant(new Identite("123","nom1","prenom1"),f);
    }

    @Test
    public void test_matiere_vide(){
        assertTrue(e.getForm().getmat().isEmpty(), "Matières dans formation doit être vide");
    }

//    @Test
//    public void test_calcul_moyenne_sans_notes(){
//        e.ajoutNote("mat1",null);
//        System.out.println(e.calcMoyMat("mat1"));
//
//    }

    @Test
    public void test_ajoutNote_NonMatiere(){
        e.ajoutNote("mat2", 10.0);
        assertTrue(e.getNotes().containsKey("mat2") && e.getNotes().get("mat2").getLast() == 10.0, "Si la matière n'existe pas elle est ajouter");

    }

    @Test
    public void test_ajoutNote_Matiere(){
        e.ajoutNote("mat2", 11.0);
        assertTrue(e.getNotes().containsKey("mat2") && e.getNotes().get("mat2").getLast() == 11.0, "La matière doit être ajouter");
    }

    @Test
    //si Double:note < 0 => note = 0
    public void test_ajoutNote_negative(){
        e.ajoutNote("mat1",-5.0);
        ArrayList<Double> listeNotes = e.getNotes().get("mat1");
        boolean noteVerif = listeNotes.getLast() == 0.0;
        assertTrue(e.getNotes().containsKey("mat1") && noteVerif, "ladernière note doit être égale à 0");
    }

    @Test
    //si Double:note > 20 => note = 20
    public void test_ajoutNote_Sup20(){
        e.ajoutNote("mat1",24.0);
        ArrayList<Double> listeNotes = e.getNotes().get("mat1");
        boolean noteVerif = listeNotes.getLast() == 20.0;
        assertTrue(e.getNotes().containsKey("mat1") && noteVerif, "ladernière note doit être égale à 20");
    }

//    @Test
//    public void  test_Calcul_Moyenne(){
//
//    }


}
