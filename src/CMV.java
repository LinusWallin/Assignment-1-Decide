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

  public CMV(
    Vector2D[] POINTS,
    double length1,
    double length2,
    double pi,
    double EPSILON,
    int K_PTS
  ) {
    this.LENGTH1 = length1;
    this.LENGTH2 = length2;
    this.POINTS = POINTS;
    this.PI = pi;
    this.EPSILON = EPSILON;
    this.K_PTS = K_PTS;
  }

  boolean cmvFunction1() {
    //This is the first function
    return true;
  }

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

  public boolean cmvFunction7() {
    int start = 0;
    int end = 0 + this.K_PTS;
    if (this.POINTS.length < 3 || this.K_PTS >= this.POINTS.length) {
      return false;
    }
    while (end < this.POINTS.length) {
      Vector2D first = this.POINTS[start];
      Vector2D sec = this.POINTS[end];

      double line = Math.pow(first.squaredDistance(sec), 0.5);

      if (line > this.LENGTH1) {
        System.out.println(line);
        return true;
      }
      end++;
      start++;
    }
    return false;
  }

  public boolean cmvFunction12() {
    boolean ans = false;
    if (this.POINTS.length < 3 || this.LENGTH2 < 0) {
      return false;
    }
    int start = 0;
    int end = 0 + this.K_PTS;

    while (end < this.POINTS.length) {
      Vector2D first = this.POINTS[start];
      Vector2D sec = this.POINTS[end];

      double line = Math.pow(first.squaredDistance(sec), 0.5);

      if (line < this.LENGTH2) {
        ans = true;
        break;
      }
      end++;
      start++;
    }
    return ans && cmvFunction7();
  }
}
