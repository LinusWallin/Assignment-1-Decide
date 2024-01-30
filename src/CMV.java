package src;

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

  // public CMV(
  //   Vector2D[] POINTS,
  //   double length1,
  //   double length2,
  //   double pi,
  //   double EPSILON,
  //   int K_PTS
  // ) {
  //   this.LENGTH1 = length1;
  //   this.LENGTH2 = length2;
  //   this.POINTS = POINTS;
  //   this.PI = pi;
  //   this.EPSILON = EPSILON;
  //   this.K_PTS = K_PTS;
  // }

  public CMV(
    Vector2D[] POINTS,
    double pi,
    double EPSILON,
    double DIST,
    int E_PTS,
    int F_PTS,
    double AREA1
  ) {
    this.POINTS = POINTS;
    this.PI = pi;
    this.EPSILON = EPSILON;
    this.DIST = DIST;
    this.E_PTS = E_PTS;
    this.F_PTS = F_PTS;
    this.AREA1 = AREA1;
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

      //   System.out.printf(
      //     "points: (%f, %f), (%f, %f), (%f, %f) ",
      //     first.x,
      //     first.y,
      //     sec.x,
      //     sec.y,
      //     third.x,
      //     third.y
      //   );

      double line1 = Math.pow(first.squaredDistance(sec), 0.5);
      double line2 = Math.pow(sec.squaredDistance(third), 0.5);
      double line3 = Math.pow(third.squaredDistance(first), 0.5);

      //   System.out.printf(
      //     "line length : %f, %f, %f ",
      //     first.squaredDistance(sec),
      //     line2,
      //     line3
      //   );

      double angle = Math.acos(
        (Math.pow(line1, 2) + Math.pow(line2, 2) - Math.pow(line3, 2)) /
        (2 * line1 * line2)
      );
      //   System.out.printf("angle : %f \n", angle);

      if (
        (angle < (this.PI - this.EPSILON)) || (angle > (this.PI + this.EPSILON))
      ) {
        // System.out.println(angle);
        // System.out.printf("true angle : %f", angle);
        return true;
      }
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
      // System.out.printf(
      //   "first : (%f,%f),vertex : (%f,%f),last : (%f,%f)\n",
      //   first.x,
      //   first.y,
      //   vertex.x,
      //   vertex.y,
      //   last.x,
      //   last.y
      // );

      double line1 = Math.sqrt(first.squaredDistance(vertex));
      double line2 = Math.sqrt(vertex.squaredDistance(last));
      double line3 = Math.sqrt(last.squaredDistance(first));
      double s = (line1 + line2 + line3) / 2;
      double area = Math.sqrt(s * (s - line1) * (s - line2) * (s - line3));

      // System.out.printf("area : %f \n", area);

      if (area > this.AREA1) {
        return true;
      }
    }
    return false;
  }
}
