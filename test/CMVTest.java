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
        
        CMV cmv  = new CMV(points, 100, 2.0, 0);

        assertTrue(cmv.cmvFunction0());
    }

    @Test
    public void testFunction0_2(){

        Vector2D[] points = new Vector2D[100];

        for(int i=0; i < 100; i++){
            points[i] = new Vector2D(1.0,1.0);
        }
    
        CMV cmv  = new CMV(points, 100, 2.0, 0);

        assertFalse(cmv.cmvFunction0());
    }

    @Test
    public void testFunction0_3(){

        Vector2D[] points = new Vector2D[100];

        for(int i=0; i < 100; i++){
            points[i] = new Vector2D(2.0,2.0);
        }
    
        points[7] = new Vector2D(2.5,2.5);
        points[8] = new Vector2D(1.6,1.6);
        
        CMV cmv  = new CMV(points, 100, 1.0, 0);

        assertTrue(cmv.cmvFunction0());
    }

    @Test
    public void testFunction1_0(){

        Vector2D[] points = new Vector2D[100];

        for(int i=0; i < 100; i++){
            points[i] = new Vector2D(i,i);
        }
    
                
        CMV cmv  = new CMV(points, 100, 0, 1);

        assertTrue(cmv.cmvFunction1());
    }

    @Test
    public void testFunction1_1(){

        Vector2D[] points = new Vector2D[100];

        for(int i=0; i < 100; i++){
            points[i] = new Vector2D(i,i);
        }
    
                
        CMV cmv  = new CMV(points, 100, 0, 2);

        assertFalse(cmv.cmvFunction1());
    }

    @Test
    public void testFunction1_2(){

        Vector2D[] points = new Vector2D[100];

        for(int i=0; i < 100; i++){
            points[i] = new Vector2D(1,1);
        }

        points[1] = new Vector2D(4,1);
        points[2] = new Vector2D(4,5);
    
                
        CMV cmv  = new CMV(points, 100, 0, 5);

        assertFalse(cmv.cmvFunction1());
    }

}
