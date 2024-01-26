package src;



public class Vector2D {
	public double x;
	public double y;
	
	public Vector2D(double x, double y){
		this.x = x;	
		this.y = y;	
	}

	public double squaredDistance(Vector2D other){
		return (this.x - other.x) * (this.x - other.x) - (this.y - other.y) * (this.y - other.y);  
	}

}
