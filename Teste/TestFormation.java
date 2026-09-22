import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestFormation {
    Formation form1 = new Formation("INFO");
    Formation form2 = new Formation("BIO");
    Formation form3 = new Formation("SPORT");

    @BeforeEach
    public void init(){

        form1.ajoutMat("Maths",4);
        form1.ajoutMat("NSI",8);
        form1.ajoutMat("Physique-Chimie",2);

        form2.ajoutMat("Maths",2);
        form2.ajoutMat("SVT",6);
        form2.ajoutMat("Physique-Chimie",4);

        form3.ajoutMat("Maths",3);
        form3.ajoutMat("EPS",7);
        form3.ajoutMat("SVT",4);

    }

    @Test
    public void testAjoutMat(){
        assertEquals(false,form1.getmat().containsKey("Crypto"));
        form1.ajoutMat("Crypto",3);
        assertEquals(true,form1.getmat().containsKey("Crypto"));
    }
    @Test
    public void testSupMat(){
        assertEquals(true,form1.getmat().containsKey("Physique-Chimie"));
        form1.supMat("Physique-Chimie");
        assertEquals(false,form1.getmat().containsKey("Physique-Chimie"));
    }
    @Test
    public void testGetCoef(){
        assertEquals(8,form1.getCoef("NSI"));
    }

}
