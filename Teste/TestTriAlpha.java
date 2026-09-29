import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestTriAlpha {

    private Formation f;
    private Identite i1,i2,i3;
    private Etudiant e1,e2,e3;
    private Groupe g, g_trieAlpha, g_trieAntiAlpha;

    @BeforeEach
    public void PreparationDonnee(){
        f = new Formation("f1");

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
