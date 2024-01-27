import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class CMVTest {

    @Test
    public void testFunction0_1(){

        Vector2D[] points = new Vector2D[100];

        for(int i=0; i < 100; i++){
            points[i] = new Vector2D(1.0,1.0);
        }
    
        points[8] = new Vector2D(3.1,3.1);
        
        CMV cmv  = new CMV(points, 100, 2.0);

        assertTrue(cmv.cmvFunction0());
    }

    @Test
    public void testFunction0_2(){

        Vector2D[] points = new Vector2D[100];

        for(int i=0; i < 100; i++){
            points[i] = new Vector2D(1.0,1.0);
        }
    
        CMV cmv  = new CMV(points, 100, 2.0);

        assertFalse(cmv.cmvFunction0());
    }
}
