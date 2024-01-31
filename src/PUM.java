public class PUM{

    private OP[][] LCM;
    private boolean[] cmvVector;
    private boolean[][] matrix = new boolean[15][15];
    private int row_size = 15;


    //set the matrix manually -just for testing
    public PUM(boolean[][] matrix){
        this.matrix = matrix;
    }

    //This constructor should be used in production.
    public PUM(boolean[] cmvVector, OP[][] LCM){
        this.LCM = LCM;
        this.cmvVector = cmvVector;
        calculatePUM();
    }

    //returns true if the whole row of PUM is true 
    //Used in 2.3 FUV[i] should be set to true if PUV[i] is false (indicating that the associated
    //LIC should not hold back launch) or if all elements in PUM row i are true
    public boolean row(int number){
        for(int i = 0; i < row_size; i++){
            if(!matrix[number][i]){
                return false;
            }
        }
        return true;
    }


    private void calculatePUM(){
        // here we calculate the PUM matrix based on the cmvVector and the
        // logical connector matrix LMC.

        //if lcm[i][j] = NOTUSED -> PUM[i][j] = true; -- If LCM[i,j] is NOTUSED, then PUM[i,j] should be set to true.
        //LCM[i,j] represents the boolean operator to be applied to CMV[i] and CMV[j]. PUM[i,j] is set according to the result of this operation.
        //else if lcm[i][j] = ANDD -> PUM[i][j] = CMV[i] && CMV[j]  
        //else if lcm[i][j] = ORR -> PUM[i][j] = CMV[i] || CMV[j]  -- 
        for(int i = 0; i < 15; i++){
            for(int j=0; j<15;j++){
                if(this.LCM[i][j] == OP.NOTUSED){
                    this.matrix[i][j] = true;
                }
                else if(this.LCM[i][j] == OP.ANDD){
                    this.matrix[i][j] = cmvVector[i] && cmvVector[j];
                }
                else if(this.LCM[i][j] == OP.ORR){
                    this.matrix[i][j] = cmvVector[i] || cmvVector[j];
                }
            }
        }
    }
}
