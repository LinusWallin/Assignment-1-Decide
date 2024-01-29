

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
    public CMV(Vector2D[] POINTS, int NUMPOINTS, double LENGTH1){
        this.POINTS = POINTS;
        this.NUMPOINTS = NUMPOINTS;
        this.LENGTH1 = LENGTH1;
    }

    //constructor for cmvFunction9
    public CMV(Vector2D[] POINTS, int NUMPOINTS, int C_PTS, int D_PTS, double EPSILON){
        this.POINTS = POINTS;
        this.NUMPOINTS = NUMPOINTS;
        this.C_PTS = C_PTS;
        this.D_PTS = D_PTS;
        this.EPSILON = EPSILON; 
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

    boolean cmvFunction9(){
        //assert((this.C_PTS + this.D_PTS) < (this.NUMPOINTS -3));
        //assert(C_PTS >= 1);
        //assert(D_PTS >= 1);

        if(NUMPOINTS <5){
            return false;
        }

        for(int i=0; i<NUMPOINTS-C_PTS-D_PTS; i++){
            Vector2D first = this.POINTS[i];
            Vector2D vertex = this.POINTS[i+C_PTS];
            Vector2D last = this.POINTS[i+C_PTS+D_PTS];

            //if vertex and first or last coincide. reject
            if(first.x == vertex.x && first.y == vertex.y){
                return false;
            }
            if(last.x == vertex.x && last.y == vertex.y){
                return false;
            }

            // angle calculation
            double angle = vertex.angle(first,last);
            System.out.println(i +" " + (i+C_PTS) +" "+(i+C_PTS+D_PTS) + " " + angle);
            if(angle < Main.PI - this.EPSILON){
                System.out.println("Found an angle < PI - EPSILON:  Angle - " + angle);
                return true;
            }
            if(angle > Main.PI + this.EPSILON){
                System.out.println("Found an angle < PI + EPSILON:  Angle - " + angle);
                return true;
            }
        }
        
        return false;
    }

}
