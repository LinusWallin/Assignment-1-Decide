import java.security.InvalidParameterException;
import java.util.LinkedList;

public class CMV {
  private double LENGTH1; // Length in LICs 0, 7, 12
  private double RADIUS1; // Radius in LICs 1, 8, 13
  private double EPSILON; // Deviation from PI in LICs 2, 9
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
  private double RADIUS2; // Maximum radius in LIC 13
  private double AREA2;

  private double PI;
  private Vector2D[] POINTS;
  private int NUMPOINTS;

    /**
     * Construct an instance of CMV from all the input parameters.
     * @param points
     * @param numpoints
     * @param length1 Length in LICs 0, 7, 12
     * @param radius1 Radius in LICs 1, 8, 13
     * @param epsilon Deviation from PI in LICs 2, 9
     * @param area1 Area in LICs 3, 10, 14
     * @param qPts No. of consecutive points in LIC 4
     * @param quads No. of quadrants in LIC 4
     * @param dist Distance in LIC 6
     * @param nPoints No. of consecutive pts. in LIC 6
     * @param kPoints No. of int. pts. in LICs 7, 12
     * @param aPoints No. of int. pts. in LICs 8, 13
     * @param bPoints No. of int. pts. in LICs 8, 13
     * @param cPoints No. of int. pts. in LIC 9
     * @param dPoints No. of int. pts. in LIC 9
     * @param ePoints No. of int. pts. in LICs 10, 14
     * @param fPoints No. of int. pts. in LICs 10, 14
     * @param gPoints No. of int. pts. in LIC 11
     * @param length2 Maximum length in LIC 12
     * @param radius2 Maximum radius in LIC 13
     * @param area2 Maximum a r e a i n LIC 14
     */
    public CMV(
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
        if(points.length != numpoints) throw new InvalidParameterException("POINTS.length != NUMPOINTS");
        this.NUMPOINTS = numpoints;
        this.POINTS = points;
        this.LENGTH1 = length1;
        this.RADIUS1 = radius1;
        this.EPSILON = epsilon;
        this.AREA1 = area1;
        this.QPTS = qPts;
        this.QUADS = quads;
        this.DIST = dist;
        this.N_PTS = nPoints;
        this.K_PTS = kPoints;
        this.A_PTS = aPoints;
        this.B_PTS = bPoints;
        this.C_PTS = cPoints;
        this.D_PTS = dPoints;
        this.E_PTS = ePoints;
        this.F_PTS = fPoints;
        this.G_PTS = gPoints;
        this.LENGTH2 = length2;
        this.RADIUS2 = radius2;
        this.AREA2 = area2; 
        this.PI = 3.1415926535;
    }

  /**
   * Evaluates LIC 0
   * @return true if two conscutive points are less than LENGTH1 distance from eachother. false otherwise.
   */
  public boolean cmvFunction0() {
    if (this.NUMPOINTS == 0) {
      return false;
    }
    //check if two adjacent points square distance are smaller than LENGTH1 squared.
    Vector2D prev = this.POINTS[0];
    double limit = this.LENGTH1 * this.LENGTH1;
    for (int i = 1; i < this.NUMPOINTS; i++) {
      if (prev.squaredDistance(this.POINTS[i]) > limit) {
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
  public boolean cmvFunction1() {
    for (int i = 0; i <= this.NUMPOINTS - 3; i++) {
      Vector2D point1 = this.POINTS[i];
      Vector2D point2 = this.POINTS[i + 1];
      Vector2D point3 = this.POINTS[i + 2];

      double a = Math.sqrt(point1.squaredDistance(point2));
      double b = Math.sqrt(point2.squaredDistance(point3));
      double c = Math.sqrt(point3.squaredDistance(point1));

      if (c == a + b || b == a + c || a == b + c) { //If the points are collinear
        double r = (a + b + c) / 4;
        if (r > this.RADIUS1) return true;
        continue;
      }

      double r =
        a *
        b *
        c /
        Math.sqrt((a + b + c) * (b + c - a) * (c + a - b) * (a + b - c)); //Finds the Circumradius of the triangle
      if (r > this.RADIUS1) return true;
    }
    return false;
  }

  /**
   * Evaluates Condition 2.
   * Calculates the angle between 3 consecutive data points
   *
   * @return true if angle < PI - Episilon or angle > PI + EPSILON otherwise false
   */

  public boolean cmvFunction2() {
    for (int i = 0; i < this.POINTS.length - 2; i++) {
      Vector2D first = this.POINTS[i];
      Vector2D sec = this.POINTS[i + 1];
      Vector2D third = this.POINTS[i + 2];
      double line1 = Math.pow(first.squaredDistance(sec), 0.5);
      double line2 = Math.pow(sec.squaredDistance(third), 0.5);
      double line3 = Math.pow(third.squaredDistance(first), 0.5);

      double angle = Math.acos(
        (Math.pow(line1, 2) + Math.pow(line2, 2) - Math.pow(line3, 2)) /
        (2 * line1 * line2)
      );

      if (
        (angle < (this.PI - this.EPSILON)) || (angle > (this.PI + this.EPSILON))
      ) {
        return true;
      }
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

  public boolean cmvFunction3() {
    if (POINTS.length > 2) {
      for (int i = 0; POINTS.length > i + 2; i++) {
        double area =
          this.POINTS[i].traingleArea(this.POINTS[i + 1], this.POINTS[i + 2]);

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
  public boolean cmvFunction4() {
    LinkedList<Integer> quadrantQueue = new LinkedList<>();

    for (int i = 0; i < QPTS; i++) {
      quadrantQueue.add(POINTS[i].quadrant());
    }

    for (int i = 0; i < POINTS.length - QPTS; i++) {
      int count = 0;

      for (int j = 0; j < 4; j++) {
        if (quadrantQueue.contains(j + 1)) {
          count++;
        }
      }

      if (count >= QUADS) return true;

      quadrantQueue.add(POINTS[QPTS + i].quadrant());
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
    for (int i = 0; i < this.POINTS.length - 1; i++) {
      if (this.POINTS[i + 1].x < this.POINTS[i].x) return true;
    }

    return false;
  }

  /**
   * Evaluates Condition 6.
   * Calculates the distance between the line formed by the first
   * and last point and every other point where NUMPOINTS >= 3
   * @return true if distance is greater than this.DIST otherwise false
   */

  public boolean cmvFunction6() {
    if (this.POINTS.length < 3) {
      return false;
    }
    Vector2D start = this.POINTS[0];
    Vector2D end = this.POINTS[this.POINTS.length - 1];
    Vector2D midpoint = start.midPoint(end);

    for (Vector2D p : this.POINTS) {
      double dist = Math.sqrt(midpoint.squaredDistance(p));
      if (dist > this.DIST) {
        return true;
      }
    }
    return false;
  }

  public boolean cmvFunction7() {
    if (this.NUMPOINTS >= 3) {
      for (int i = 0; i < this.NUMPOINTS - (this.K_PTS + 1); i++) {
        if (
          Math.sqrt(
            this.POINTS[i].squaredDistance(this.POINTS[i + this.K_PTS + 1])
          ) >
          this.LENGTH1
        ) {
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
            double distance = Math.sqrt(POINTS[i].squaredDistance(POINTS[i + K_PTS + 1]));
            if(distance > LENGTH1){
                condition1 = true;
            }
            if(distance < LENGTH2){
                condition2 = true;
            }
        }

        return condition1 && condition2;
    }
  /**
   * Evaluates Condition 10.
   * Calculates the area of the triangle formed by the 3 consecutive points spaced E_PTS and F_PTS
   * apart.
   * @return true if area > this.AREA1 otherwise false
   */

  public boolean cmvFunction10() {
    if (this.POINTS.length < 5) {
      return false;
    }
    for (int i = 0; i < this.POINTS.length - this.E_PTS - this.F_PTS; i++) {
      Vector2D first = this.POINTS[i];
      Vector2D vertex = this.POINTS[i + E_PTS];
      Vector2D last = this.POINTS[i + E_PTS + F_PTS];

      double line1 = Math.sqrt(first.squaredDistance(vertex));
      double line2 = Math.sqrt(vertex.squaredDistance(last));
      double line3 = Math.sqrt(last.squaredDistance(first));
      double s = (line1 + line2 + line3) / 2;
      double area = Math.sqrt(s * (s - line1) * (s - line2) * (s - line3));

      if (area > this.AREA1) {
        return true;
      }
    }
    return false;
  }

  /**
   * Checks that there exists atleast one set of two data points separated by
   * exactly G_PTS consecutive intervening points, such that X[j] - X[i] < 0 (
   * where i<j). The condition is not met when NUMPOINTS < 3. 
   * @return (boolean)
   */
  public boolean cmvFunction11(){
    if (this.NUMPOINTS >= 3){
        int j = this.G_PTS+1;
        for (int i = 0; i < this.NUMPOINTS - j; i++){
            if (this.POINTS[i+j].x - this.POINTS[i].x < 0){
                return true;
            }
        }
    }
    return false;
  }

  /**
   * Evaluates condition 14.
   * Iterates over the array, looks for 3 points seperated by E_PTS and F_PTS respectively
   * Finds the area of the triangle created by these 3 points as vertices
   * Checks if the area is bigger than AREA1, also checks if it's smaller than AREA2
   * At the end of iteration, returns true if both conditions were satisfied at least once.
   * @return true if result1 && result2, false otherwise.
   */
  public boolean cmvFunction14() {
    if (NUMPOINTS < 5) return false;

    boolean result1 = false;
    boolean result2 = false;
    for (int i = 0; i < this.NUMPOINTS - this.E_PTS - this.F_PTS; i++) {
      if (result1 && result2) return true;
      Vector2D point1 = this.POINTS[i];
      Vector2D point2 = this.POINTS[i + this.E_PTS];
      Vector2D point3 = this.POINTS[i + this.E_PTS + this.F_PTS];

      double area = point1.traingleArea(point2, point3);

      if (area > this.AREA1) result1 = true;
      if (area < this.AREA2) result2 = true;
    }

    if (result1 && result2) return true;

    return false;
  }

    boolean cmvFunction13(){
        boolean[] result = {false,false};
        if(this.NUMPOINTS <5){
            return false;
        }
        for(int i=0; i<this.NUMPOINTS-this.A_PTS-this.B_PTS; i++){
            if(result[0] && result[1]) break;
            Vector2D first = this.POINTS[i];
            Vector2D second = this.POINTS[i+this.A_PTS];
            Vector2D last = this.POINTS[i+this.A_PTS+this.B_PTS];


            Vector2D centroid = first.centroid(second,last);

            double squaredradius1 = Math.pow(this.RADIUS2,2);
            double squaredradius2 = Math.pow(this.RADIUS2,2);

            double distfirst = centroid.squaredDistance(first);
            double distsecond = centroid.squaredDistance(second);
            double distlast = centroid.squaredDistance(last);
            if(!result[0]){
                if(distfirst >= squaredradius1 || distsecond >= squaredradius1 || distlast >= squaredradius1){
                    result[0] =  true;
                }
            }
            if(!result[1]){
                if(distfirst <= squaredradius2 && distsecond <= squaredradius2 && distlast <= squaredradius2){
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
