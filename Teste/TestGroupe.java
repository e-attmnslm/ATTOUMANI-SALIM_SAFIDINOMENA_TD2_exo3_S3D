import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGroupe {
    Formation f1;
    Formation f2;
    Groupe g1;
    Groupe g2;

    Etudiant e1;
    Etudiant e2;

    @BeforeEach
    public void init(){
        f1 = new Formation("INFO");
        f1.ajoutMat("crypto",4);
        f1.ajoutMat("java",4);


        g1 = new Groupe(f1);
        e1 = new Etudiant(new Identite("7777","Thomas","Pierre"),f1);
        e2 = new Etudiant(new Identite("2222","Jean","Claude"),f1);
        e1.ajoutNote("crypto",18.0);
        e1.ajoutNote("crypto",10.0);
        e1.ajoutNote("java",8.0);
        e1.ajoutNote("java",12.0);

        e2.ajoutNote("crypto",10.0);
        e2.ajoutNote("java",4.0);
        e2.ajoutNote("crypto",12.0);
        e2.ajoutNote("java",12.0);

        g1.ajoutEtu(e1);
        g1.ajoutEtu(e2);
    }
    @Test
    public void testajout() {
        Etudiant e3 = new Etudiant(new Identite("4545","Java","Koba"),f1);
        assertEquals(false,g1.present(e3));
        g1.ajoutEtu(e3);
        assertEquals(true,g1.present(e3));
    }

    @Test
    public void testsupp() {
        g1.ajoutEtu(e1);
        g1.ajoutEtu(e2);
        g1.suppEtu(e2);
        assertEquals(true,g1.present(e1));
        assertEquals(false,g1.present(e2));
    }
    @Test
    public void testMoyMat() {
        assertEquals(12.5,g1.calcMoyMat("crypto"));
        assertEquals(9.0,g1.calcMoyMat("java"));

    }

    @Test
    public void testMoyGen() {
        assertEquals(10.75,g1.calcMoyGen());
    }
}
