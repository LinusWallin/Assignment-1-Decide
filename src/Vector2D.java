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
}
