

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

        //constructor for cmvFunction13
    public CMV(Vector2D[] POINTS, int NUMPOINTS, int A_PTS, int B_PTS, double RADIUS1, double RADIUS2){
        this.POINTS = POINTS;
        this.NUMPOINTS = NUMPOINTS;
        this.A_PTS = A_PTS;
        this.B_PTS = B_PTS;
        this.RADIUS1 = RADIUS1;
        this.RADIUS2 = RADIUS2;
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

    boolean cmvFunction13(){
        boolean[] result = {false,false};
        if(NUMPOINTS <5){
            return false;
        }
        for(int i=0; i<NUMPOINTS-A_PTS-B_PTS; i++){
            if(result[0] && result[1]) break;
            Vector2D first = this.POINTS[i];
            Vector2D second = this.POINTS[i+A_PTS];
            Vector2D last = this.POINTS[i+A_PTS+B_PTS];

            System.out.println(i + " " + (i+A_PTS) + " " + (i+A_PTS+B_PTS));

            Vector2D centroid = first.centroid(second,last);

            double squaredRadius1 = Math.pow(RADIUS1,2);
            double squaredRadius2 = Math.pow(RADIUS2,2);

            double distFirst = centroid.squaredDistance(first);
            double distSecond = centroid.squaredDistance(second);
            double distLast = centroid.squaredDistance(last);
            if(!result[0]){
                if(distFirst >= squaredRadius1 || distSecond >= squaredRadius1 || distLast >= squaredRadius1){
                    System.out.println("found 3 points not containable in RADIUS1");
                    result[0] =  true;
                }
            }
            if(!result[1]){
                if(distFirst <= squaredRadius2 && distSecond <= squaredRadius2 && distLast <= squaredRadius2){
                    System.out.println("found 3 points containable in RADIUS2");
                    result[1] = true;
                }
            }
        }

        if(result[0] && result[1]){
            return true;
        }

        return false;
    }

}
