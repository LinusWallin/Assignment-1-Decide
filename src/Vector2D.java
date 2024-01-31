import org.omg.CORBA.VM_CUSTOM;

public class Vector2D {
    public double x;
    public double y;

    public Vector2D(double x, double y){
        this.x = x;	
        this.y = y;	
    }

    public double squaredDistance(Vector2D other){
        return (this.x - other.x) * (this.x - other.x) + (this.y - other.y) * (this.y - other.y);  
    }

    public double angle(Vector2D A, Vector2D B){

        //calculate squared triangle sides.
        double AC = A.squaredDistance(this);
        double CB = this.squaredDistance(B);
        double AB = B.squaredDistance(A);

        //law of cosines
        double cosAngle = (AC + CB - AB) / (2 * Math.sqrt(AC) * Math.sqrt(CB));

        return Math.acos(cosAngle);
    }

    public Vector2D centroid(Vector2D A, Vector2D C){
        double x = (this.x + A.x + C.x)/3;
        double y = (this.y + A.y + C.y)/3;

        return new Vector2D(x,y);
    }

    /**
     * The function calculates the area of a triangle genereated by 3
     * points.
     * @param A a 2D vector representing the second point
     * @param B a 2D vector representing the third point
     * @return returns the area of the triangle created by the points
     */
    public double traingleArea(Vector2D A, Vector2D B){

        //determinant of the 3 consecutive vectors from i to i+2
        double det = this.x * A.y - this.x * B.y + A.x * B.y - A.x * this.y + 
        B.x * this.y - B.x * A.y;

        double area = 0.5*Math.abs(det);

        return area;
    }

    public Vector2D mean(Vector2D other){
        double x = (this.x + other.x) * 0.5;
        double y = (this.y + other.y) * 0.5;

        return new Vector2D(x, y);
    }

    public double circleRadius(Vector2D v1, Vector2D v2){
        Vector2D d1 = new Vector2D(this.x - v1.x, this.y - v1.y);
        Vector2D m1 = mean(v1);
        double a1 = -d1.x/d1.y;
        double b1 = m1.y - a1*m1.x;

        Vector2D d2 = new Vector2D(this.x - v2.x, this.y - v2.y);
        Vector2D m2 = mean(v2);
        double a2 = -d2.x/d2.y;
        double b2 = -m2.y - a2*m2.x;

        Vector2D intersect = new Vector2D((b2-b1)/(a1-a2), (a1*b2-a2*b1)/(a1-a2));

        return Math.sqrt(squaredDistance(intersect));
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Vector2D)) return false;
        Vector2D o = (Vector2D) obj;
        return o.x == x && o.y == y; 
    }

}
