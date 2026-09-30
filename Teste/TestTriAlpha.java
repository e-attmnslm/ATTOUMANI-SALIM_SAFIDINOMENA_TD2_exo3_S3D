import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestTriAlpha {

    private Formation f;
    private Identite i1,i2,i3;
    private Etudiant e1,e2,e3;
    private Groupe g, g_trieAlpha, g_trieAntiAlpha,g_trieMerite;

    @BeforeEach
    public void PreparationDonnee(){
        f = new Formation("f1");
        f.ajoutMat("Maths", 1);
        i1 = new Identite("1","etua","diant1");
        e1 = new Etudiant(i1,f);

        i2 = new Identite("2","etub","diant2");
        e2 = new Etudiant(i2,f);

        i3 = new Identite("3","etuc","diant3");
        e3 = new Etudiant(i3,f);

        //création d'un groupe non triee
        g = new Groupe(f);
        g.ajoutEtu(e1);
        g.ajoutEtu(e3);
        g.ajoutEtu(e2);


        //créer un groupe trier par ordre Alphabétique
        g_trieAlpha = new Groupe(f);
        g_trieAlpha.ajoutEtu(e1);
        g_trieAlpha.ajoutEtu(e2);
        g_trieAlpha.ajoutEtu(e3);

        //créer un groupe trier par ordre Alphabétique inverser
        g_trieAntiAlpha = new Groupe(f);
        g_trieAntiAlpha.ajoutEtu(e3);
        g_trieAntiAlpha.ajoutEtu(e2);
        g_trieAntiAlpha.ajoutEtu(e1);
        // Attributions des notes :
        // e1 aura 10.0 (Moyenne : 10.0) -> 2ème
        // e2 aura 18.0 (Moyenne : 18.0) -> 1er
        // e3 aura 05.0 (Moyenne : 05.0) -> 3ème
        e1.ajoutNote("Maths", 10.0);
        e2.ajoutNote("Maths", 18.0);
        e3.ajoutNote("Maths", 5.0);

        // Groupe non trié
        g = new Groupe(f);
        g.ajoutEtu(e1);
        g.ajoutEtu(e3);
        g.ajoutEtu(e2);

        // Groupe attendu trié par mérite (meilleures notes en premier)
        g_trieMerite = new Groupe(f);
        g_trieMerite.ajoutEtu(e2); // 18.0
        g_trieMerite.ajoutEtu(e1); // 10.0
        g_trieMerite.ajoutEtu(e3); // 05.0
    }

    @Test
    public void test_triParMerite() {
        boolean test = true;
        ArrayList<Etudiant> g_triee = g.triParMerite();

        for (int i = 0; i < g_triee.size(); i++) {
            if (g_triee.get(i) != g_trieMerite.getEtudiants().get(i)) {
                test = false;
                break;
            }
        }
        assertTrue(test, "Le groupe doit être trié par ordre de mérite (décroissant des moyennes)");
    }
    @Test
    public void test_triAlpha(){
        boolean test = true;
        ArrayList<Etudiant> g_triee = g.triAlpha();
        for (int i = 0; i<g_triee.size();i++){
            if (g_triee.get(i) != g_trieAlpha.getEtudiants().get(i)){
                test = false;
                break;
            }
        }
        assertTrue(test,"Le groupe doit être en ordre alphabétique");
    }

    @Test
    public void test_triAntiAlpha(){
        boolean test = true;
        ArrayList<Etudiant> g_triee = g.triAntiAlpha();
        for (int i = 0; i<g_triee.size();i++){
            if (g_triee.get(i) != g_trieAntiAlpha.getEtudiants().get(i)){
                test = false;
                break;
            }
        }
        assertTrue(test,"Le groupe doit être en ordre alphabétique inverse");
    }

}
