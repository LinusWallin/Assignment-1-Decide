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

    @Test
    public void testFunction0_3(){

        Vector2D[] points = new Vector2D[100];

        for(int i=0; i < 100; i++){
            points[i] = new Vector2D(2.0,2.0);
        }
    
        points[7] = new Vector2D(2.5,2.5);
        points[8] = new Vector2D(1.6,1.6);
        
        CMV cmv  = new CMV(points, 100, 1.0);

        assertTrue(cmv.cmvFunction0());
    }

    //The function goes through all iterations
    @Test
    public void testFunction9_0(){
        Vector2D[] points = new Vector2D[100];
        
        double x = 0.0;
        for(int i=0; i < 100; i++){
            points[i] = new Vector2D(x,0.0);
            x = x + 1.0;
        }
    
        int C_PTS = 1;
        int D_PTS = 1;
        double EPSILON = 0.01;
        CMV cmv  = new CMV(points, 100, C_PTS, D_PTS, EPSILON);

        assertFalse(cmv.cmvFunction9());
    }
    //The function true on big angle
    @Test
    public void testFunction9_1(){
        Vector2D[] points = new Vector2D[100];
        
        double x = 0.0;
        for(int i=0; i < 100; i++){
            points[i] = new Vector2D(x,0.0);
            x = x + 1.0;
        }
    
        int C_PTS = 1;
        int D_PTS = 1;
        double EPSILON = 0.01;
        CMV cmv  = new CMV(points, 100, C_PTS, D_PTS, EPSILON);

        assertFalse(cmv.cmvFunction9());
    }
}
