import java.util.LinkedList;

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
    public CMV(Vector2D[] POINTS, int NUMPOINTS, double LENGTH1, double RADIUS1, double AREA1, int K_PTS){
        this.POINTS = POINTS;
        this.NUMPOINTS = NUMPOINTS;
        this.LENGTH1 = LENGTH1;
        this.RADIUS1 = RADIUS1;
        this.AREA1 = AREA1;
        this.K_PTS = K_PTS;
    }

    public CMV(Vector2D[] POINTS, int NUMPOINTS, int QPTS, int QUADS){
        this.POINTS = POINTS;
        this.NUMPOINTS = NUMPOINTS;
        this.QPTS = QPTS;
        this.QUADS = QUADS;
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
     

    /**
     * Evaluates Condition 1.
     * Calculates the circumradius of three consecutive points with a formula.
     * If these points are collinear, sets the circumradius to be 1/4th of the sum of side lengths.
     * @return false if any circumradius is greater than RADIUS1, true otherwise.
     */
    boolean cmvFunction1(){

        for (int i = 0; i <= this.NUMPOINTS - 3; i++) {
            Vector2D point1 = this.POINTS[i];
            Vector2D point2 = this.POINTS[i+1];
            Vector2D point3 = this.POINTS[i+2];

            double a = Math.sqrt(point1.squaredDistance(point2));
            double b = Math.sqrt(point2.squaredDistance(point3));
            double c = Math.sqrt(point3.squaredDistance(point1));
            
            if(c==a+b || b==a+c || a ==b+c) { //If the points are collinear
                double r  = (a+b+c)/4;
                if(r > this.RADIUS1) return true;
                continue;
            }

            double r = a*b*c / Math.sqrt((a+b+c)*(b+c-a)*(c+a-b)*(a+b-c)); //Finds the Circumradius of the triangle
            if(r > this.RADIUS1) return true;

        }
        return false;
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

    /**
     * This function returns true if there exist QPTS consecutives 
     * points that lies in at least QUADS different quadrants
     * @return (boolean)
     */
    public boolean cmvFunction4(){

        LinkedList<Integer> quadrantQueue = new LinkedList<>();

        for(int i = 0; i < QPTS; i++){
            quadrantQueue.add(POINTS[i].quadrant());
        }

        for(int i = 0; i < POINTS.length - QPTS; i++){
            int count = 0;

            for(int j = 0; j < 4; j++){
                if(quadrantQueue.contains(j+1)){
                    count++;
                }
            }

            if(count >= QUADS) return true;

            quadrantQueue.add(POINTS[QPTS+i].quadrant());
            quadrantQueue.poll();
        }

        return false;
    }

    /**
     * The function evaluates the condition 5.
     * Iterates over POINTS array, looks for consecutive points and checks if the smaller indexed point 
     * has an x bigger than the next point's x
     * @return true if any such points can be found, false otherwise.
     */
    public boolean cmvFunction5() {

        for (int i = 0; i < this.POINTS.length-1; i++) {
            if(this.POINTS[i+1].x < this.POINTS[i].x) return true;
        }

        return false;
    }


    public boolean cmvFunction7(){

        if (this.NUMPOINTS >= 3){

            for (int i = 0; i < this.NUMPOINTS - (this.K_PTS+1); i++){

                if (Math.sqrt(this.POINTS[i].squaredDistance(this.POINTS[i+this.K_PTS+1])) > this.LENGTH1){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * There exists at least one set of two data points, separated by exactly K PTS consecutive
     * intervening points, which are a distance greater than the length, LENGTH1, apart. 
     * In addition, there exists at least one set of two data points (which can be the same or different from
     * the two data points just mentioned), separated by exactly K PTS consecutive intervening
     * points, that are a distance less than the length, LENGTH2, apart. Both parts must be true
     * for the LIC to be true. The condition is not met when NUMPOINTS < 3.
     * 0 ≤ LENGTH2
     * @return true if both condition are met
     */
    public boolean cmvFunction12(){
        
        boolean condition1 = false;
        boolean condition2 = false;

        for(int i = 0; i < NUMPOINTS - K_PTS - 1; i++){
            double distance = POINTS[i].squaredDistance(POINTS[i + K_PTS + 1]);
            if(distance > LENGTH1){
                condition1 = true;
            }
            if(distance < LENGTH2){
                condition2 = true;
            }
        }

        return condition1 && condition2;
    }
}
