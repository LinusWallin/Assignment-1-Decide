/**
 * A class to modelize a 2D Vector
 */
public class Vector2D {

  public double x;
  public double y;

  /**
   * Construct a Vector2D from its coordinates
   * @param x x coordinate
   * @param y y coordinate
   */
  public Vector2D(double x, double y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Compute the squared distance between this and other
   * @param other The point from where the distance is computed
   * @return The squared distance between this and other
   */
  public double squaredDistance(Vector2D other) {
    return (
      (this.x - other.x) *
      (this.x - other.x) +
      (this.y - other.y) *
      (this.y - other.y)
    );
  }

  /**
   * Compute the angle formed by three points
   * @param A First point
   * @param B Second point
   * @return The angle formed by A, B and this
   */
  public double angle(Vector2D A, Vector2D B) {
    //calculate squared triangle sides.
    double AC = A.squaredDistance(this);
    double CB = this.squaredDistance(B);
    double AB = B.squaredDistance(A);

    //law of cosines
    double cosAngle = (AC + CB - AB) / (2 * Math.sqrt(AC) * Math.sqrt(CB));

    return Math.acos(cosAngle);
  }

  /**
   * Compute the centroid of a triangle
   * @param A Second point of the triangle
   * @param C Third point of the triangle
   * @return The centroid of the triangle formed by this A and C
   */
  public Vector2D centroid(Vector2D A, Vector2D C) {
    double x = (this.x + A.x + C.x) / 3;
    double y = (this.y + A.y + C.y) / 3;

    return new Vector2D(x, y);
  }

  /**
   * The function calculates the area of a triangle genereated by 3
   * points.
   * @param A a 2D vector representing the second point
   * @param B a 2D vector representing the third point
   * @return returns the area of the triangle created by the points
   */
  public double traingleArea(Vector2D A, Vector2D B) {
    //determinant of the 3 consecutive vectors from i to i+2
    double det =
      this.x *
      A.y -
      this.x *
      B.y +
      A.x *
      B.y -
      A.x *
      this.y +
      B.x *
      this.y -
      B.x *
      A.y;

    double area = 0.5 * Math.abs(det);

    return area;
  }

  /**
   * Compute the quadrant (quarter of the plain) that contains the Vector2D
   * 1 - top right
   * 2 - top left
   * 3 - bottom left
   * 4 - bottom right
   * @return (int) the quadrant of the point
   **/
  public int quadrant() {
    if (this.x >= 0 && this.y >= 0) {
      return 1;
    }
    if (this.x < 0 && this.y >= 0) {
      return 2;
    }
    if (this.x <= 0 && this.y < 0) {
      return 3;
    }
    return 4;
  }

  /**
   * Compute the middle of the segment formed by two points
   * @param other The other extremity of the segment
   * @return (Vector2D) The point in the middle of this and other
   */
  public Vector2D midPoint(Vector2D other) {
    return new Vector2D((this.x + other.x) / 2, (this.y + other.y) / 2);
  }



    /**
     * Create a new Vector2D from the result of the addition between this and o
     * @param o The Vector2D we want to add to this
     * @return The new Vector2D this + o
     */
    public Vector2D add(Vector2D o){
      return new Vector2D(this.x + o.x, this.y + o.y);
    }

    /**
     * Create a new Vector2D from the result of the multiplication between this and scalar
     * @param scalar The scalar we want to multiply with this
     * @return The new Vector2D this*scalar
     */
    public Vector2D multiply(double scalar){
      return new Vector2D(this.x * scalar, this.y * scalar);
    }

    /**
     * This function takes two Vector2D and a radius and return the centers of the two circles 
     * of that radius that go through those points
     * @param v1 The other point to construct the circles
     * @param radius The radius of the circles
     * @return The two centers as Vector2Ds
     */
    public Vector2D[] circleCenters(Vector2D v1, double radius){
        Vector2D difference = new Vector2D(this.x - v1.x, this.y - v1.y);
        Vector2D m = midPoint(v1);
        Vector2D orthonormalDirection = difference.y == 0  ? new Vector2D(0, 1) : new Vector2D(1, -difference.x/difference.y)
        .multiply(1/Math.sqrt(1 + (difference.x/difference.y)*(difference.x/difference.y)));
        //double bias = m.y - slope*m.x;

        double squaredDistanceToMean = squaredDistance(m); 

        double distMeanToCenter = Math.sqrt(radius*radius-squaredDistanceToMean);
        
        Vector2D center1 = m.add(orthonormalDirection.multiply(distMeanToCenter));
        Vector2D center2 = m.add(orthonormalDirection.multiply(-distMeanToCenter));

        return new Vector2D[]{center1, center2};
    }

    /**
     * Decide if there exist a circle of radius @radius that contains this, @p2 and @p3
     * @param p2 the second point
     * @param p3 the third point
     * @param radius the radius of the circle
     * @return true if such circle exist, false otherwise
     */
    public boolean areFittingInCircle(Vector2D p2, Vector2D p3, double radius){
      Vector2D[] centers1 = this.circleCenters(p2, radius);
      Vector2D[] centers2 = this.circleCenters(p3, radius);
      Vector2D[] centers3 = p2.circleCenters(p3, radius);

      if (
        Math.sqrt(p3.squaredDistance(centers1[0])) <= radius ||
        Math.sqrt(p3.squaredDistance(centers1[1])) <= radius
      ) {
        return true;
      }
      if (
        Math.sqrt(p2.squaredDistance(centers2[0])) <= radius ||
        Math.sqrt(p2.squaredDistance(centers2[1])) <= radius
      ) {
        return true;
      }
      if (
        Math.sqrt(this.squaredDistance(centers3[0])) <= radius ||
        Math.sqrt(this.squaredDistance(centers3[1])) <= radius
      ) {
        return true;
      }

      return false;
    }


    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Vector2D)) return false;
        Vector2D o = (Vector2D) obj;
        return o.x == x && o.y == y; 
    }

}
