package src;

class CMV {

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

  boolean cmvFunction1() {
    //This is the first function
    return true;
  }

  boolean cmvFunction2(double[] x, double[] y, double pi) {
    for (int i = 1; i < x.length - 2; i++) {
      double firstX = x[i];
      double firstY = y[i];
      double secX = x[i + 1];
      double secY = y[i + 1];
      double thirdX = x[i + 2];
      double thirdY = y[i + 2];
      double line1 = Math.pow(
        Math.pow(firstX - secX, 2) + Math.pow(firstY - secY, 2),
        0.5
      );
      double line2 = Math.pow(
        Math.pow(secX - thirdX, 2) + Math.pow(secY - thirdY, 2),
        0.5
      );

      double line3 = Math.pow(
        Math.pow(thirdX - firstX, 2) + Math.pow(thirdY - firstY, 2),
        0.5
      );

      double angle = Math.acos(
        (Math.pow(line1, 2) + Math.pow(line2, 2) - Math.pow(line3, 2)) /
        (2 * line1 * line2)
      );

      if ((angle < (pi - this.EPSILON)) || (angle > (pi + this.EPSILON))) {
        return true;
      }
    }

    return false;
  }
}
