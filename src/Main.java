import java.security.InvalidParameterException;

class Main {
    double PI = 3.1415926535;
    
    public static void main (String[] args) {
        System.out.println("This is the main file");
    
    }
    
    //Function to determine if the input variables are valid
    public boolean isValidInput(
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
        if(points.length != numpoints) throw new InvalidParameterException("Length of POINTS must be equal to NUMPOINTS");
        if(length1 < 0) throw new InvalidParameterException("LENGTH1 must be greater or equal than 0");
        if(radius1 < 0) throw new InvalidParameterException("RADIUS1 must be greater or equal than 0");
        if(epsilon < 0 || epsilon >= this.PI) throw new InvalidParameterException("EPSILON must be greater or equal than 0 and smaller than PI");
        if(area1 < 0) throw new InvalidParameterException("AREA1 must be greater or equal than 0");
        if(qPts < 2 || qPts > numpoints) throw new InvalidParameterException("Q_PTS must be greater or equal than 2 and smaller or equal than NUMPOINTS");
        if(quads < 1 || quads > 3) throw new InvalidParameterException("QUADS must be greater or equal than 1 and smaller or equal than 3");
        if(nPoints < 3 || nPoints > numpoints) throw new InvalidParameterException("N_PTS must be greater or equal than 3 and smaller or equal than NUMPOINTS");
        if(dist < 0) throw new InvalidParameterException("DIST must be greater or equal than 0");
        if(kPoints < 1 || kPoints > numpoints-2) throw new InvalidParameterException("K_PTS must be greater or equal than 1 and smaller or equal than (NUMPOINTS-2)");
        if(aPoints < 1) throw new InvalidParameterException("A_PTS must be greater or equal than 1");
        if(bPoints < 1) throw new InvalidParameterException("B_PTS must be greater or equal than 1");
        if(aPoints+bPoints > (numpoints-3)) throw new InvalidParameterException("sum of A_PTS and B_PTS must be smaller or equal than (NUMPOINTS-3)");
        if(cPoints < 1) throw new InvalidParameterException("C_PTS must be greater or equal than 1");
        if(dPoints < 1) throw new InvalidParameterException("D_PTS must be greater or equal than 1");
        if(cPoints+dPoints > (numpoints-3)) throw new InvalidParameterException("sum of C_PTS and D_PTS must be smaller or equal than (NUMPOINTS-3)");
        if(ePoints < 1) throw new InvalidParameterException("E_PTS must be greater or equal than 1");
        if(fPoints < 1) throw new InvalidParameterException("F_PTS must be greater or equal than 1");
        if(ePoints+fPoints > (numpoints-3)) throw new InvalidParameterException("sum of E_PTS and F_PTS must be smaller or equal than (NUMPOINTS-3)");
        if(gPoints < 1 || gPoints > numpoints-2) throw new InvalidParameterException("G_PTS must be greater or equal than ");
        if(length2 < 0) throw new InvalidParameterException("LENGTH2 must be greater or equal than 0");
        if(radius2 < 0) throw new InvalidParameterException("RADIUS2 must be greater or equal than 0");
        if(area2 < 0) throw new InvalidParameterException("AREA2 must be greater or equal than 0");
        return true;
    }
}
