
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

}
