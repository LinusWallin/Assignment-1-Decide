import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CMVTest {


    @Test
    void testFunction3_0(){

        Vector2D[] points = new Vector2D[3];
        
        points[0] = new Vector2D(0.0, 0.0);
        points[1] = new Vector2D(1.0, 4.0);
        points[2] = new Vector2D(2.0, 0.0);

        double area1 = 3.99;

        CMV cmv = new CMV();

        assertTrue(cmv.cmvFunction3(points, area1));

    }

    @Test
    void testFunction3_1(){

        Vector2D[] points = new Vector2D[10];

        for (int i = 0; i < 10; i++){
            points[i] = new Vector2D(0.0, 0.0);
        }

        points[3] = new Vector2D(1.0, 4.0);
        points[6] = new Vector2D(2.0, 0.0);

        double area1 = 3.99;

        CMV cmv = new CMV();

        assertFalse(cmv.cmvFunction3(points, area1));
    }

    @Test 
    void testFunction3_2(){

        Vector2D[] points = new Vector2D[10];
        
        for (int i = 0; i < 10; i++){
            points[i] = new Vector2D(0.0, 0.0);
        }

        double area1 = 1.0;

        CMV cmv = new CMV();

        assertFalse(cmv.cmvFunction3(points, area1));

    }

    @Test
    void testFunction3_3(){

        Vector2D[] points = new Vector2D[2];

        points[0] = new Vector2D(0.0, 0.0);
        points[1] = new Vector2D(100.0, 100.0);

        double area1 = 0.0;

        CMV cmv = new CMV();

        assertFalse(cmv.cmvFunction3(points, area1));
    }

}
