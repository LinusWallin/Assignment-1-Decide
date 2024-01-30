

public class CMV {
    private double LENGTH1; // Length in LICs 0, 7, 12
    private double RADIUS1 ; // Radius in LICs 1, 8, 13
    private double EPSILON ; // Deviation from PI in LICs 2, 9
    private double AREA1; // Area in LICs 3, 10, 14
    private int QPTS; // No. of consecutive points in LIC 4
    private int QUADS; // No. of quadrants in LIC 4
    private double DIST; // Distance in LIC 6
    private int N_PTS; // No. of consecutive pts. in LIC 6
    private int K_PTS; // No. of int. pts. in LICs 7, 12
    private int A_PTS; // No. of int. pts. in LICs 8, 13
    private int B_PTS; // No. of int. pts. in LICs 8, 13
    private int C_PTS; // No. of int. pts. in LIC 9
    private int D_PTS; // No. of int. pts. in LIC 9
    private int E_PTS; // No. of int. pts. in LICs 10, 14
    private int F_PTS; // No. of int. pts. in LICs 10, 14
    private int G_PTS; // No. of int. pts. in LIC 11
    private double LENGTH2; // Maximum length in LIC 12
    private double RADIUS2 ; // Maximum radius in LIC 13
    private double AREA2; 

    private Vector2D[] POINTS;
    private int NUMPOINTS;

    //constructor for cmvFunction0
    public CMV(Vector2D[] POINTS, int NUMPOINTS, double LENGTH1, double AREA1){
        this.POINTS = POINTS;
        this.NUMPOINTS = NUMPOINTS;
        this.LENGTH1 = LENGTH1;
        this.AREA1 = AREA1;
    }
    
    public boolean cmvFunction0(){
        if(this.NUMPOINTS == 0){
            return false;
        }
        //check if two adjacent points square distance are smaller than LENGTH1 squared.
        Vector2D prev = this.POINTS[0];
        double limit = this.LENGTH1*this.LENGTH1; 
        for(int i = 1; i< this.NUMPOINTS; i++) {
            if(prev.squaredDistance(this.POINTS[i]) > limit){
                return true;
            }
            prev = this.POINTS[i];
        }
        return false;
    }
     
    boolean cmvFunction1(){
        //This is the first function
        return true;
    }

    /**
     * The function looks calculates the area of a triangle created by
     * three consecutive points from the give list of 2D vectors. The
     * area of the triangle is then compared with the input value area1
     * and if larger the function returns true, else it returns false.
     * 
     * @return          returns a boolean
     */

     public boolean cmvFunction3(){

        if (POINTS.length > 2){
            for (int i = 0; POINTS.length > i+2; i++) {

                double area = this.POINTS[i].traingleArea(this.POINTS[i+1], this.POINTS[i+2]);

                if (area > this.AREA1) {
                    return true;
                }
            }
        }
        return false;
    }

}
