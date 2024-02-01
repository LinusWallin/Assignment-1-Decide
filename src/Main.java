import java.security.InvalidParameterException;

class Main {

  public static final double PI = 3.1415926535;

  public static void main(String[] args) {
    int NUMPOINTS = 100; // some number of points
    double[] X = new double[NUMPOINTS];
    double[] Y = new double[NUMPOINTS];

    Enums.CONNECTORS[][] LCM = new Enums.CONNECTORS[15][15];
    boolean[] pumMatrix;
    boolean[] PUV = new boolean[] {
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
    };
    Params PARAMETERS = new Params(
      0.0,
      0.0,
      0.0,
      0.0,
      0,
      0,
      0.0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0.0,
      0.0,
      0.0
    );
    boolean[] cmvMatrix;
    boolean[] FUV;
    boolean LAUNCH;
    PUV = new boolean[15];
    //make PUV
    for (int i = 0; i < PUV.length; i++) {
      if (i % 2 == 0) {
        PUV[i] = true;
      }
    }
    //make X & Y & points
    Vector2D[] points = new Vector2D[NUMPOINTS];
    for (int i = 0; i < NUMPOINTS; i++) {
      X[i] = i;
      Y[i] = i;
      points[i] = new Vector2D(X[i], Y[i]);
    }

    //initialise LCM

    for (int i = 0; i < 15; i++) {
      Enums.CONNECTORS[] row = new Enums.CONNECTORS[15];
      for (int j = 0; j < 15; j++) {
        row[i] = Enums.CONNECTORS.ANDD;
      }
      LCM[i] = row;
    }

    LAUNCH = Main.DECIDE(points, NUMPOINTS, LCM, PUV, PARAMETERS);
    //Dummy input
    System.out.println("LAUNCH : " + LAUNCH);
    System.out.println("Answer: " + DECIDEtest(PUV));
  }

  private static boolean DECIDE(
    Vector2D[] points,
    int NUMPOINTS,
    Enums.CONNECTORS[][] LCM,
    boolean[] PUV,
    Params props
  ) {
    boolean isValid = Main.isValidInput(
      points,
      NUMPOINTS,
      props.LENGTH1,
      props.RADIUS1,
      props.EPSILON,
      props.AREA1,
      props.QPTS,
      props.QUADS,
      props.DIST,
      props.N_PTS,
      props.K_PTS,
      props.A_PTS,
      props.B_PTS,
      props.C_PTS,
      props.D_PTS,
      props.E_PTS,
      props.F_PTS,
      props.G_PTS,
      props.LENGTH2,
      props.RADIUS2,
      props.AREA2
    );

    CMV cmvObj = new CMV(
      points,
      NUMPOINTS,
      props.LENGTH1,
      props.RADIUS1,
      props.EPSILON,
      props.AREA1,
      props.QPTS,
      props.QUADS,
      props.DIST,
      props.N_PTS,
      props.K_PTS,
      props.A_PTS,
      props.B_PTS,
      props.C_PTS,
      props.D_PTS,
      props.E_PTS,
      props.F_PTS,
      props.G_PTS,
      props.LENGTH2,
      props.RADIUS2,
      props.AREA2
    );

    boolean[] cmvMatrix = cmvObj.computeCMV();
    PUM pum = new PUM(cmvMatrix, LCM);

    boolean[] FUV = {
      (pum.row(0) || !PUV[0]),
      (pum.row(1) || !PUV[1]),
      (pum.row(2) || !PUV[2]),
      (pum.row(3) || !PUV[3]),
      (pum.row(4) || !PUV[4]),
      (pum.row(5) || !PUV[5]),
      (pum.row(6) || !PUV[6]),
      (pum.row(7) || !PUV[7]),
      (pum.row(8) || !PUV[8]),
      (pum.row(9) || !PUV[9]),
      (pum.row(10) || !PUV[10]),
      (pum.row(11) || !PUV[11]),
      (pum.row(12) || !PUV[12]),
      (pum.row(13) || !PUV[13]),
      (pum.row(14) || !PUV[14]),
    };
    boolean ans = true;
    for (boolean condition : FUV) {
      if (!condition) {
        ans = false; //a condition is false - return false
      }
    }
    //all conditions are true
    return ans;
  }

  //for testing only
  private static boolean DECIDEtest(boolean[] PUV) {
    // CMV cmvMatrix = new CMV(this.);
    boolean[][] mat = new boolean[15][15];

    PUM pum = new PUM(mat);

    //2.3 "FUV[i] should be set to true if PUV[i] is false (indicating that the associated
    //LIC should not hold back launch) or if all elements in PUM row i are true"
    boolean[] FUV = {
      (pum.row(0) || !PUV[0]),
      (pum.row(1) || !PUV[1]),
      (pum.row(2) || !PUV[2]),
      (pum.row(3) || !PUV[3]),
      (pum.row(4) || !PUV[4]),
      (pum.row(5) || !PUV[5]),
      (pum.row(6) || !PUV[6]),
      (pum.row(7) || !PUV[7]),
      (pum.row(8) || !PUV[8]),
      (pum.row(9) || !PUV[9]),
      (pum.row(10) || !PUV[10]),
      (pum.row(11) || !PUV[11]),
      (pum.row(12) || !PUV[12]),
      (pum.row(13) || !PUV[13]),
      (pum.row(14) || !PUV[14]),
    };

    //2.4 LAUNCH - launch if all elements in FUV is true .

    for (boolean condition : FUV) {
      if (!condition) {
        return false; //a condition is false - return false
      }
    }
    //all conditions are true
    return true;
  }

  //Function to determine if the input variables are valid
  static boolean isValidInput(
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
  ) {
    if (points.length != numpoints) throw new InvalidParameterException(
      "Length of POINTS must be equal to NUMPOINTS"
    );
    if (length1 < 0) throw new InvalidParameterException(
      "LENGTH1 must be greater or equal than 0"
    );
    if (radius1 < 0) throw new InvalidParameterException(
      "RADIUS1 must be greater or equal than 0"
    );
    if (epsilon < 0 || epsilon >= Main.PI) throw new InvalidParameterException(
      "EPSILON must be greater or equal than 0 and smaller than PI"
    );
    if (area1 < 0) throw new InvalidParameterException(
      "AREA1 must be greater or equal than 0"
    );
    if (qPts < 2 || qPts > numpoints) throw new InvalidParameterException(
      "Q_PTS must be greater or equal than 2 and smaller or equal than NUMPOINTS"
    );
    if (quads < 1 || quads > 3) throw new InvalidParameterException(
      "QUADS must be greater or equal than 1 and smaller or equal than 3"
    );
    if (nPoints < 3 || nPoints > numpoints) throw new InvalidParameterException(
      "N_PTS must be greater or equal than 3 and smaller or equal than NUMPOINTS"
    );
    if (dist < 0) throw new InvalidParameterException(
      "DIST must be greater or equal than 0"
    );
    if (
      kPoints < 1 || kPoints > numpoints - 2
    ) throw new InvalidParameterException(
      "K_PTS must be greater or equal than 1 and smaller or equal than (NUMPOINTS-2)"
    );
    if (aPoints < 1) throw new InvalidParameterException(
      "A_PTS must be greater or equal than 1"
    );
    if (bPoints < 1) throw new InvalidParameterException(
      "B_PTS must be greater or equal than 1"
    );
    if (
      aPoints + bPoints > (numpoints - 3)
    ) throw new InvalidParameterException(
      "sum of A_PTS and B_PTS must be smaller or equal than (NUMPOINTS-3)"
    );
    if (cPoints < 1) throw new InvalidParameterException(
      "C_PTS must be greater or equal than 1"
    );
    if (dPoints < 1) throw new InvalidParameterException(
      "D_PTS must be greater or equal than 1"
    );
    if (
      cPoints + dPoints > (numpoints - 3)
    ) throw new InvalidParameterException(
      "sum of C_PTS and D_PTS must be smaller or equal than (NUMPOINTS-3)"
    );
    if (ePoints < 1) throw new InvalidParameterException(
      "E_PTS must be greater or equal than 1"
    );
    if (fPoints < 1) throw new InvalidParameterException(
      "F_PTS must be greater or equal than 1"
    );
    if (
      ePoints + fPoints > (numpoints - 3)
    ) throw new InvalidParameterException(
      "sum of E_PTS and F_PTS must be smaller or equal than (NUMPOINTS-3)"
    );
    if (
      gPoints < 1 || gPoints > numpoints - 2
    ) throw new InvalidParameterException(
      "G_PTS must be greater or equal than "
    );
    if (length2 < 0) throw new InvalidParameterException(
      "LENGTH2 must be greater or equal than 0"
    );
    if (radius2 < 0) throw new InvalidParameterException(
      "RADIUS2 must be greater or equal than 0"
    );
    if (area2 < 0) throw new InvalidParameterException(
      "AREA2 must be greater or equal than 0"
    );
    return true;
  }
}

class Params {

  double LENGTH1; // Length in LICs 0, 7, 12
  double RADIUS1; // Radius in LICs 1, 8, 13
  double EPSILON; // Deviation from PI in LICs 2, 9
  double AREA1; // Area in LICs 3, 10, 14
  int QPTS; // No. of consecutive points in LIC 4
  int QUADS; // No. of quadrants in LIC 4
  double DIST; // Distance in LIC 6
  int N_PTS; // No. of consecutive pts. in LIC 6
  int K_PTS; // No. of int. pts. in LICs 7, 12
  int A_PTS; // No. of int. pts. in LICs 8, 13
  int B_PTS; // No. of int. pts. in LICs 8, 13
  int C_PTS; // No. of int. pts. in LIC 9
  int D_PTS; // No. of int. pts. in LIC 9
  int E_PTS; // No. of int. pts. in LICs 10, 14
  int F_PTS; // No. of int. pts. in LICs 10, 14
  int G_PTS; // No. of int. pts. in LIC 11
  double LENGTH2; // Maximum length in LIC 12
  double RADIUS2; // Maximum radius in LIC 13
  double AREA2;

  Params(
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
  ) {
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
  }
}
