import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class PUMTest {
    
    /**
     * Tests if a row is false if an element in the row is false (expect diagonal)
     * */
    @Test
    public void testPUM_0(){
        
        boolean[] cmvVector = new boolean[15];
        Enums.CONNECTORS[][] lcm = new Enums.CONNECTORS[15][15];
        
        for (int i = 0; i < 15; i++){
            cmvVector[i] = true;
        }

        boolean[][] mat =  { 
            {false,true,true,true,true, true,true,true,true,true, true,true,true,true,true},
            {true,false,true,false,true, true,true,true,true,true, true,true,true,true,true},
            {true,true,false,true,true, true,true,true,true,true, true,true,true,true,true},
            {true,true,true,false,true, true,true,true,true,true, true,true,true,true,true},
            {true,true,true,true,false, true,true,true,true,true, true,true,true,true,true},
            {true,true,true,true,true, false,true,true,true,true, true,true,true,true,true},
            {true,true,true,true,true, true,false,true,true,true, true,true,true,true,true},
            {true,true,true,true,true, true,true,false,true,true, true,true,true,true,true},
            {true,true,true,true,true, true,true,true,false,true, true,true,true,true,true},
            {true,true,true,true,true, true,true,true,true,false, true,true,true,true,true},
            {true,true,true,true,true, true,true,true,true,true, false,true,true,true,true},
            {true,true,true,true,true, true,true,true,true,true, true,false,true,true,true},
            {true,true,true,true,true, true,true,true,true,true, true,true,false,true,true},
            {true,true,true,true,true, true,true,true,true,true, true,true,true,false,true},
            {true,true,true,true,true, true,true,true,true,true, true,true,true,true,false},
        };

        PUM pum = new PUM(mat);
        for(int i = 0; i < 15; i++){
            if(i == 1){
                assertFalse(pum.row(i));
            }else{
                assertTrue(pum.row(i));
            }  
        }
        
    }
    /**
     * Test if a LCM matrix of only NOTUSED results in true matrix.
     */
    @Test
    public void testPUM_1(){

        boolean[] cmvVector = new boolean[15];
        Enums.CONNECTORS[][] lcm = new Enums.CONNECTORS[15][15];

        boolean[][] expected ={ 
            {true,true,true,true,true, true,true,true,true,true, true,true,true,true,true},
            {true,true,true,true,true, true,true,true,true,true, true,true,true,true,true},
            {true,true,true,true,true, true,true,true,true,true, true,true,true,true,true},
            {true,true,true,true,true, true,true,true,true,true, true,true,true,true,true},
            {true,true,true,true,true, true,true,true,true,true, true,true,true,true,true},
            {true,true,true,true,true, true,true,true,true,true, true,true,true,true,true},
            {true,true,true,true,true, true,true,true,true,true, true,true,true,true,true},
            {true,true,true,true,true, true,true,true,true,true, true,true,true,true,true},
            {true,true,true,true,true, true,true,true,true,true, true,true,true,true,true},
            {true,true,true,true,true, true,true,true,true,true, true,true,true,true,true},
            {true,true,true,true,true, true,true,true,true,true, true,true,true,true,true},
            {true,true,true,true,true, true,true,true,true,true, true,true,true,true,true},
            {true,true,true,true,true, true,true,true,true,true, true,true,true,true,true},
            {true,true,true,true,true, true,true,true,true,true, true,true,true,true,true},
            {true,true,true,true,true, true,true,true,true,true, true,true,true,true,true},
        };

        //If LCM[i,j] is NOTUSED, then PUM[i,j]should be set to true.

        for(int i = 0; i< 15;i++){
            for(int j = 0; j< 15;j++){
                lcm[i][j] = Enums.CONNECTORS.NOTUSED;   
            }
        }
        
        PUM pum = new PUM(cmvVector, lcm);
        boolean[][] mat =  pum.getMatrix();
        for(int i = 0; i< 15;i++){
            for(int j = 0; j< 15;j++){
                if (i != j){
                    assertEquals(expected[i][j], mat[i][j]);
                }else{
                    assertFalse(mat[i][j]);//this means values default to false in matrix.
                }
            }
        }

    }

    /**
     * Tests that ANDD true and false gives false in the matrix.
     */
    @Test
    public void testPUM_2(){

        boolean[] cmvVector = new boolean[15];
        Enums.CONNECTORS[][] lcm = new Enums.CONNECTORS[15][15];

        boolean[][] expected ={
            {true,false,false,false,false, false,false,false,false,false, false,false,false,false,false},
            {false,true,true,true,true, true,true,true,true,true, true,true,true,true,true},
            {false,true,true,true,true, true,true,true,true,true, true,true,true,true,true},
            {false,true,true,true,true, true,true,true,true,true, true,true,true,true,true},
            {false,true,true,true,true, true,true,true,true,true, true,true,true,true,true},
            {false,true,true,true,true, true,true,true,true,true, true,true,true,true,true},
            {false,true,true,true,true, true,true,true,true,true, true,true,true,true,true},
            {false,true,true,true,true, true,true,true,true,true, true,true,true,true,true},
            {false,true,true,true,true, true,true,true,true,true, true,true,true,true,true},
            {false,true,true,true,true, true,true,true,true,true, true,true,true,true,true},
            {false,true,true,true,true, true,true,true,true,true, true,true,true,true,true},
            {false,true,true,true,true, true,true,true,true,true, true,true,true,true,true},
            {false,true,true,true,true, true,true,true,true,true, true,true,true,true,true},
            {false,true,true,true,true, true,true,true,true,true, true,true,true,true,true},
            {false,true,true,true,true, true,true,true,true,true, true,true,true,true,true},
        };

        //If LCM[i,j] is NOTUSED, then PUM[i,j]should be set to true.

        for(int i = 0; i< 15;i++){
            for(int j = 0; j< 15;j++){
                lcm[i][j] = Enums.CONNECTORS.ANDD;   
            }
        }

        for (int i = 0; i < 15; i++){
            cmvVector[i] = true;
        }

        cmvVector[0] = false;
        
        PUM pum = new PUM(cmvVector, lcm);
        boolean[][] mat =  pum.getMatrix();
        for(int i = 0; i< 15;i++){
            for(int j = 0; j< 15;j++){
                if (i != j){
                    assertEquals(expected[i][j], mat[i][j]);
                }else{
                    assertFalse(mat[i][j]);//this means values default to false in matrix.
                }
            }
        }
    }

    @Test
    public void testPUM_3(){

        boolean[] cmvVector = new boolean[15];
        Enums.CONNECTORS[][] lcm = new Enums.CONNECTORS[15][15];

        boolean[][] expected ={ 
            {true,true,true,true,true, true,true,true,true,true, true,true,true,true,true},
            {true,true,true,true,true, true,true,true,true,true, true,true,true,true,true},
            {true,true,true,true,true, true,true,true,true,true, true,true,true,true,true},
            {true,true,true,true,true, true,true,true,true,true, true,true,true,true,true},
            {true,true,true,true,true, true,true,true,true,true, true,true,true,true,true},
            {true,true,true,true,true, true,true,true,true,true, true,true,true,true,true},
            {true,true,true,true,true, true,true,true,true,true, true,true,true,true,true},
            {true,true,true,true,true, true,true,true,true,true, true,true,true,true,true},
            {true,true,true,true,true, true,true,true,true,true, true,true,true,true,true},
            {true,true,true,true,true, true,true,true,true,true, true,true,true,true,true},
            {true,true,true,true,true, true,true,true,true,true, true,true,true,true,true},
            {true,true,true,true,true, true,true,true,true,true, true,true,true,true,true},
            {true,true,true,true,true, true,true,true,true,true, true,true,true,true,true},
            {true,true,true,true,true, true,true,true,true,true, true,true,true,true,true},
            {true,true,true,true,true, true,true,true,true,true, true,true,true,true,true},
        };


    }
}
