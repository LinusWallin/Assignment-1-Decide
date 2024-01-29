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

    // all points 0.0 return false if Radius1 != 0
    @Test
    public void testFunction13_0(){
        Vector2D[] points = new Vector2D[100];
        
        for(int i=0; i < 100; i++){
            points[i] = new Vector2D(0.0,0.0);
        }
    
        int A_PTS = 1;
        int B_PTS = 1;
        double RADIUS1 = 1.0;
        double RADIUS2 = 0.0;

        CMV cmv = new CMV(points, 100, A_PTS, B_PTS, RADIUS1, RADIUS2);

        assertFalse(cmv.cmvFunction13());
    }

    // return true when 2 pair of points exists.
    @Test
    public void testFunction13_1(){
        Vector2D[] points = new Vector2D[100];
         
        double x = 1.0;
        for(int i=0; i < 100; i++){
            points[i] = new Vector2D(x,0.0);
        }

        points[19] = new Vector2D(1000.0,1000.0);
        points[20] = new Vector2D(0.0,0.0);

        points[77] = new Vector2D(3000.1,3000.0);
        points[78] = new Vector2D(3000.2,3000.0);
        points[79] = new Vector2D(3000.3,3000.0);
    
        int A_PTS = 1;
        int B_PTS = 1;
        double RADIUS2 = 0.5;
        double RADIUS1 = 790.0;

        CMV cmv = new CMV(points, 100, A_PTS, B_PTS, RADIUS1, RADIUS2);

        assertTrue(cmv.cmvFunction13());
    }
}
