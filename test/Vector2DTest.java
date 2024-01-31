import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.junit.jupiter.api.Test;
import src.Vector2D;

public class Vector2DTest {

  /*
   * Distance Tests
   */

  //test distance of equal points is 0.
  @Test
  public void testDistance_0() {
    Vector2D vec1 = new Vector2D(1.0, 1.0);
    Vector2D vec2 = new Vector2D(1.0, 1.0);

    assertEquals(vec1.squaredDistance(vec2), 0.0);
  }

  //test both x and y are relevant
  @Test
  public void testDistance_1() {
    Vector2D vec1 = new Vector2D(2.0, 2.0);
    Vector2D vec2 = new Vector2D(4.0, 2.0);

    Vector2D vec3 = new Vector2D(2.0, 2.0);
    Vector2D vec4 = new Vector2D(2.0, 4.0);

    assertEquals(Math.sqrt(vec1.squaredDistance(vec2)), 2.0);
    assertEquals(Math.sqrt(vec3.squaredDistance(vec4)), 2.0);
  }

  //test distance a->b = b->a
  @Test
  public void testDistance_2() {
    Vector2D vec1 = new Vector2D(15.3, 2.2);
    Vector2D vec2 = new Vector2D(3.3, 3.8);

    assertEquals(
      Math.sqrt(vec1.squaredDistance(vec2)),
      (Math.sqrt(vec2.squaredDistance(vec1)))
    );
  }

  /*
   * Angle Tests
   */

  @Test
  public void testAngle_0() {
    Vector2D vec1 = new Vector2D(0.0, 0.0);
    Vector2D vec2 = new Vector2D(0.0, 1.0);
    Vector2D vec3 = new Vector2D(1.0, 0.0);

    double angle = vec1.angle(vec2, vec3);

    assertEquals(Math.PI / 2, angle);
  }

  @Test
  public void testAngle_1() {
    Vector2D vec1 = new Vector2D(5.11237780, 3.12318293);
    Vector2D vec2 = new Vector2D(2.123, 7.12378);
    Vector2D vec3 = new Vector2D(1.178721, 8.1231232);

    //Transform angle to Degrees
    double angle = Math.toDegrees(vec1.angle(vec2, vec3));

    //from: https://www.google.com/search?q=law+of+cosines+calculator&sca_esv=602184151&sxsrf=ACQVn08Kapk5dRmjysJO68uIIh1LnCcMBw%3A1706465515272&ei=65i2ZaGOEOqP1fIPzaCPuAw&oq=law+of+cosines+cal&gs_lp=Egxnd3Mtd2l6LXNlcnAiEmxhdyBvZiBjb3NpbmVzIGNhbCoCCAAyBRAAGIAEMgoQABiABBiKBRhDMgUQABiABDIKEAAYgAQYigUYQzIFEAAYgAQyBRAAGIAEMgUQABiABDIFEAAYgAQyBRAAGIAEMgsQABiABBiKBRiGA0ilJlC0BFiwInAFeAGQAQCYAZcBoAGMCqoBBDEzLjK4AQPIAQD4AQGoAhTCAgoQABhHGNYEGLADwgINEAAYgAQYigUYQxiwA8ICChAjGIAEGIoFGCfCAgQQIxgnwgIHECMY6gIYJ8ICExAAGIAEGIoFGEMY6gIYtALYAQHCAhAQLhiABBiKBRhDGMcBGNEDwgILEC4YgAQYxwEY0QPCAgUQLhiABMICCxAuGIAEGMcBGK8BwgIKEC4YgAQYFBiHAsICCBAuGIAEGNQCwgIKEAAYgAQYFBiHAsICCxAAGIAEGIoFGJECwgIGEAAYFhge4gMEGAAgQYgGAZAGCroGBggBEAEYAQ&sclient=gws-wiz-serp
    double EXPECTED = 1.42528; //degrees, rounded to 5 decimals

    //Change angle to five decimals
    BigDecimal fiveDecimals = new BigDecimal(Double.toString(angle));
    fiveDecimals = fiveDecimals.setScale(5, RoundingMode.HALF_UP);

    assertEquals(EXPECTED, fiveDecimals.doubleValue());
  }

  @Test
  public void testTriangleArea_0() {
    Vector2D vec1 = new Vector2D(0, 0);
    Vector2D vec2 = new Vector2D(1, 2);
    Vector2D vec3 = new Vector2D(2, 0);

    double area = vec1.traingleArea(vec2, vec3);

    assertEquals(2.0, area);
  }

  @Test
  public void testTriangleArea_1() {
    Vector2D vec1 = new Vector2D(1, 2);
    Vector2D vec2 = new Vector2D(0, 0);
    Vector2D vec3 = new Vector2D(2, 0);

    double area = vec1.traingleArea(vec2, vec3);

    assertEquals(2.0, area);
  }

  @Test
  public void testTriangleArea_2() {
    Vector2D vec1 = new Vector2D(-1.5, 4);
    Vector2D vec2 = new Vector2D(1.5, 2);
    Vector2D vec3 = new Vector2D(3, -1.5);

    double area = vec1.traingleArea(vec2, vec3);

    assertEquals(3.75, area);
  }

  @Test
  public void testQuadrantEdgeCases() {
    Vector2D vec1 = new Vector2D(0, 0);
    Vector2D vec2 = new Vector2D(1, 0);
    Vector2D vec3 = new Vector2D(0, 1);
    Vector2D vec4 = new Vector2D(-1, 0);
    Vector2D vec5 = new Vector2D(0, -1);

    assertEquals(vec1.quadrant(), 1);
    assertEquals(vec2.quadrant(), 1);
    assertEquals(vec3.quadrant(), 1);
    assertEquals(vec4.quadrant(), 2);
    assertEquals(vec5.quadrant(), 3);
  }

  @Test
  public void testQuadrant() {
    Vector2D vec1 = new Vector2D(143, 888);
    Vector2D vec2 = new Vector2D(-4445, 2);
    Vector2D vec3 = new Vector2D(-0.00000000001, -0.0000000001);
    Vector2D vec4 = new Vector2D(1, -55);

    assertEquals(vec1.quadrant(), 1);
    assertEquals(vec2.quadrant(), 2);
    assertEquals(vec3.quadrant(), 3);
    assertEquals(vec4.quadrant(), 4);
  }
}
