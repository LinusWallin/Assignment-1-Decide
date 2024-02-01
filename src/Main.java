import java.security.InvalidParameterException;

class Main {
    double PI = 3.1415926535;
    
    public static void main (String[] args) {
        //Dummy input
        boolean[] PUV = new boolean[15];
        for(int i = 0; i < PUV.length; i++){
            if(i%2 == 0){
                PUV[i] = true;
            } 
        }
        
        System.out.println("Answer: " + DECIDE(PUV));
    }

    
    private static boolean DECIDE(boolean[] PUV){

        boolean[][] mat = new boolean[15][15];

        PUM pum = new PUM(mat);

       //2.3 "FUV[i] should be set to true if PUV[i] is false (indicating that the associated
       //LIC should not hold back launch) or if all elements in PUM row i are true"
        boolean[] FUV = {
            (pum.row(0) || !PUV[0]),
            (pum.row(1) || !PUV[1]),
            (pum.row(2) || !PUV[2]),
            (pum.row(3) || !PUV[3]),
            (pum.row(4) || !PUV[4]),
            (pum.row(5) || !PUV[5]),
            (pum.row(6) || !PUV[6]),
            (pum.row(7) || !PUV[7]),
            (pum.row(8) || !PUV[8]),
            (pum.row(9) || !PUV[9]),
            (pum.row(10) || !PUV[10]),
            (pum.row(11) || !PUV[11]),
            (pum.row(12) || !PUV[12]),
            (pum.row(13) || !PUV[13]),
            (pum.row(14) || !PUV[14]),
        };


        //2.4 LAUNCH - launch if all elements in FUV is true .

        for(boolean condition :  FUV){
            if(!condition){ 
                return false; //a condition is false - return false
            }
        }
        //all conditions are true
        return true;

    }

     //Function to determine if the input variables are valid
    public boolean isValidInput(
        Vector2D[] points, 
        int numpoints, 
        double length1, 
        double radius1, 
        double epsilon, 
        double area1, 
        int qPts, 
        int quads, 
        double dist, 
        int nPoints, 
        int kPoints, 
        int aPoints, 
        int bPoints, 
        int cPoints, 
        int dPoints, 
        int ePoints, 
        int fPoints, 
        int gPoints, 
        double length2, 
        double radius2, 
        double area2
    ){
        if(points.length != numpoints) throw new InvalidParameterException("Length of POINTS must be equal to NUMPOINTS");
        if(length1 < 0) throw new InvalidParameterException("LENGTH1 must be greater or equal than 0");
        if(radius1 < 0) throw new InvalidParameterException("RADIUS1 must be greater or equal than 0");
        if(epsilon < 0 || epsilon >= this.PI) throw new InvalidParameterException("EPSILON must be greater or equal than 0 and smaller than PI");
        if(area1 < 0) throw new InvalidParameterException("AREA1 must be greater or equal than 0");
        if(qPts < 2 || qPts > numpoints) throw new InvalidParameterException("Q_PTS must be greater or equal than 2 and smaller or equal than NUMPOINTS");
        if(quads < 1 || quads > 3) throw new InvalidParameterException("QUADS must be greater or equal than 1 and smaller or equal than 3");
        if(nPoints < 3 || nPoints > numpoints) throw new InvalidParameterException("N_PTS must be greater or equal than 3 and smaller or equal than NUMPOINTS");
        if(dist < 0) throw new InvalidParameterException("DIST must be greater or equal than 0");
        if(kPoints < 1 || kPoints > numpoints-2) throw new InvalidParameterException("K_PTS must be greater or equal than 1 and smaller or equal than (NUMPOINTS-2)");
        if(aPoints < 1) throw new InvalidParameterException("A_PTS must be greater or equal than 1");
        if(bPoints < 1) throw new InvalidParameterException("B_PTS must be greater or equal than 1");
        if(aPoints+bPoints > (numpoints-3)) throw new InvalidParameterException("sum of A_PTS and B_PTS must be smaller or equal than (NUMPOINTS-3)");
        if(cPoints < 1) throw new InvalidParameterException("C_PTS must be greater or equal than 1");
        if(dPoints < 1) throw new InvalidParameterException("D_PTS must be greater or equal than 1");
        if(cPoints+dPoints > (numpoints-3)) throw new InvalidParameterException("sum of C_PTS and D_PTS must be smaller or equal than (NUMPOINTS-3)");
        if(ePoints < 1) throw new InvalidParameterException("E_PTS must be greater or equal than 1");
        if(fPoints < 1) throw new InvalidParameterException("F_PTS must be greater or equal than 1");
        if(ePoints+fPoints > (numpoints-3)) throw new InvalidParameterException("sum of E_PTS and F_PTS must be smaller or equal than (NUMPOINTS-3)");
        if(gPoints < 1 || gPoints > numpoints-2) throw new InvalidParameterException("G_PTS must be greater or equal than ");
        if(length2 < 0) throw new InvalidParameterException("LENGTH2 must be greater or equal than 0");
        if(radius2 < 0) throw new InvalidParameterException("RADIUS2 must be greater or equal than 0");
        if(area2 < 0) throw new InvalidParameterException("AREA2 must be greater or equal than 0");
        return true;
    }
}
