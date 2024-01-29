

class CMV {
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
     * @param points    a list of 2D vectors that contain the information
     * of the points to look at
     * @param area1     the area which has to be surpassed by the triangle
     * created by the three choosen points
     * @return          returns a boolean
     */

     boolean cmvFunction3(Vector2D[] points, double area1){

        if (points.length > 2){
            for (int i = 0; points.length > i+2; i++) {
                //determinant of the 3 consecutive vectors from i to i+2
                double det = points[i].x * points[i+1].y - points[i].x * points[i+2].y + 
                points[i+1].x * points[i+2].y - points[i+1].x * points[i].y + 
                points[i+2].x * points[i].y - points[i+2].x * points[i+1].y;

                double area = 0.5*Math.abs(det);

                if (area > area1) {
                    return true;
                }
            }
        }

        return false;
    }

}