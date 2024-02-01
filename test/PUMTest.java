import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class PUMTest{

    @Test
    public void testPUMcalculatePUM_0(){
        boolean[] cmvVector = new boolean[15];
        OP[][] LCM = new OP[15][15];
        
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


        PUM pum = new PUM(cmvVector, LCM);
        
    }

}


