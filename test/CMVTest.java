import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import src.CMV;
import src.Vector2D;

public class CMVTest {

  @Test
  void function2TestTrue() {
    double PI = 3.1415926535;
    Vector2D[] points = new Vector2D[100];
    for (int i = 0; i < 100; i++) {
      points[i] = new Vector2D(1.0, 1.0);
    }

    points[1] = new Vector2D(1.0, 1.0);
    points[2] = new Vector2D(2.0, 2.0);
    points[3] = new Vector2D(3.0, 3.0);

    CMV t = new CMV(points, 1.0, 2.0, PI, -1E9, 5);
    assertTrue(t.cmvFunction2());
  }

  @Test
  void function2TestFalse() {
    double PI = 3.1415926535;
    Vector2D p1 = new Vector2D(1.0, 1.0);
    Vector2D p2 = new Vector2D(2.0, 2.0);
    Vector2D p3 = new Vector2D(3.0, 3.0);

    Vector2D[] points = new Vector2D[] { p1, p2, p3 };

    CMV t = new CMV(points, 1.0, 2.0, PI, 1.0, 5);
    assertFalse(t.cmvFunction2());
  }

  @Test
  void function7TestTrue() {
    double PI = 3.1415926535;
    Vector2D[] points = new Vector2D[100];
    for (int i = 0; i < 100; i++) {
      points[i] = new Vector2D(1.0, 1.0);
    }

    points[10] = new Vector2D(1.0, 1.0);
    points[20] = new Vector2D(11.0, 11.0);
    CMV t = new CMV(points, 10.0, 2.0, PI, 1.0, 10);
    assertTrue(t.cmvFunction7());
  }

  @Test
  void function7TestFalse() {
    double PI = 3.1415926535;
    Vector2D[] points = new Vector2D[100];
    for (int i = 0; i < 100; i++) {
      points[i] = new Vector2D(5.0, 5.0);
    }

    points[10] = new Vector2D(1.0, 1.0);
    points[20] = new Vector2D(9.0, 9.0);
    CMV t = new CMV(points, 10.0, 2.0, PI, 1.0, 9);
    assertFalse(t.cmvFunction7());
  }

  @Test
  void function12TestTrue() {
    double PI = 3.1415926535;
    Vector2D[] points = new Vector2D[100];
    for (int i = 0; i < 100; i++) {
      points[i] = new Vector2D(5.0, 5.0);
    }

    points[10] = new Vector2D(1.0, 1.0);
    points[20] = new Vector2D(9.0, 9.0);
    CMV t = new CMV(points, 10.0, 15.0, PI, 1.0, 10);
    assertTrue(t.cmvFunction7());
  }

  @Test
  void function12TestFalse() {
    double PI = 3.1415926535;
    Vector2D[] points = new Vector2D[100];
    for (int i = 0; i < 100; i++) {
      points[i] = new Vector2D(5.0, 5.0);
    }

    points[10] = new Vector2D(1.0, 1.0);
    points[20] = new Vector2D(9.0, 9.0);
    CMV t = new CMV(points, 10.0, 0.0, PI, 1.0, 9);
    assertFalse(t.cmvFunction7());
  }
}
