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

  public CMV() {
    this.LENGTH1 = 1;
    this.LENGTH2 = 2;
  }

  boolean cmvFunction1() {
    //This is the first function
    return true;
  }

  public boolean cmvFunction2(double[] x, double[] y, double pi) {
    for (int i = 1; i < x.length - 2; i++) {
      Vector2D first = new Vector2D(x[i], y[i]);
      Vector2D sec = new Vector2D(x[i + 1], y[i + 1]);
      Vector2D third = new Vector2D(x[i + 2], y[i + 2]);
      double line1 = Math.pow(
        Math.pow(first.x - sec.x, 2) + Math.pow(first.y - sec.y, 2),
        0.5
      );
      double line2 = Math.pow(
        Math.pow(sec.x - third.x, 2) + Math.pow(sec.y - third.y, 2),
        0.5
      );

      double line3 = Math.pow(
        Math.pow(third.x - first.x, 2) + Math.pow(third.y - first.y, 2),
        0.5
      );

      double angle = Math.acos(
        (Math.pow(line1, 2) + Math.pow(line2, 2) - Math.pow(line3, 2)) /
        (2 * line1 * line2)
      );

      if ((angle < (pi - this.EPSILON)) || (angle > (pi + this.EPSILON))) {
        // System.out.println(angle);
        return true;
      }
    }

    return false;
  }

  boolean cmvFunction7(double[] x, double[] y) {
    int start = 0;
    int end = 0 + this.K_PTS;
    if (x.length < 3) {
      return false;
    }
    while (end < x.length) {
      Vector2D first = new Vector2D(x[start], y[start]);
      Vector2D sec = new Vector2D(x[end], y[end]);

      double line = Math.pow(
        Math.pow(first.x - sec.x, 2) + Math.pow(first.y - sec.y, 2),
        0.5
      );
      if (line > this.LENGTH1) {
        return true;
      }
    }
    return false;
  }

  boolean cmvFunction12(double[] x, double[] y) {
    boolean ans = false;
    if (x.length < 3 || this.LENGTH2 < 0) {
      return false;
    }
    int start = 0;
    int end = 0 + this.K_PTS;

    while (end < x.length) {
      Vector2D first = new Vector2D(x[start], y[start]);
      Vector2D sec = new Vector2D(x[end], y[end]);

      double line = Math.pow(
        Math.pow(first.x - sec.x, 2) + Math.pow(first.y - sec.y, 2),
        0.5
      );

      if (line < this.LENGTH2) {
        ans = true;
        break;
      }
    }
    return ans && cmvFunction7(x, y);
  }
}
