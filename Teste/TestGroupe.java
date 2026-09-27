import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGroupe {
    Groupe g1 = new Groupe(new Formation("NSI"));
    Groupe g2 = new Groupe(new Formation("MATHS"));

    Etudiant e1 = new Etudiant(new Identite("7777","Thomas","Pierre"),new Formation("NSI"));
    Etudiant e2 = new Etudiant(new Identite("2222","Jean","Claude"),new Formation("NSI"));
    @Test
    public void testajout() {
        g1.ajoutEtu(e1);
        g1.ajoutEtu(e2);
        assertEquals(true,g1.present(e1));
        assertEquals(true,g1.present(e2));
    }

    @Test
    public void testsupp() {
        g1.ajoutEtu(e1);
        g1.ajoutEtu(e2);
        g1.suppEtu(e2);
        assertEquals(true,g1.present(e1));
        assertEquals(false,g1.present(e2));
    }
}
