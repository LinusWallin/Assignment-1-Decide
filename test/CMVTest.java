import static org.junit.jupiter.api.Assertions.assertEquals;
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

    CMV t = new CMV(points, PI, -1E9, 5.0, 5, 5, 10.0);
    assertTrue(t.cmvFunction2());
  }

  @Test
  void function2TestFalse() {
    double PI = 3.1415926535;
    Vector2D p1 = new Vector2D(1.0, 1.0);
    Vector2D p2 = new Vector2D(2.0, 2.0);
    Vector2D p3 = new Vector2D(3.0, 3.0);

    Vector2D[] points = new Vector2D[] { p1, p2, p3 };

    CMV t = new CMV(points, PI, 1.0, 5.0, 5, 5, 10.0);
    assertFalse(t.cmvFunction2());
  }

  @Test
  void function6TestTrue() {
    double PI = 3.1415926535;
    Vector2D[] points = new Vector2D[100];
    for (int i = 0; i < 100; i++) {
      points[i] = new Vector2D(2.0, 2.0);
    }

    points[1] = new Vector2D(1.0, 1.0);
    points[1 + 6] = new Vector2D(1.0, 1.0);
    points[1 + 6 + 7] = new Vector2D(2.0, 13.0);

    CMV t = new CMV(points, PI, -1E9, 10.0, 6, 7, 10.0);

    assertTrue(t.cmvFunction6());
  }

  @Test
  void function6TestFalse() {
    double PI = 3.1415926535;
    Vector2D[] points = new Vector2D[100];
    for (int i = 0; i < 100; i++) {
      points[i] = new Vector2D(2.0, 2.0);
    }

    points[12] = new Vector2D(2.0, 9.0);

    CMV t = new CMV(points, PI, -1E9, 10.0, 6, 7, 10.0);

    assertFalse(t.cmvFunction6());
  }

  @Test
  void function10TestTrue() {
    double PI = 3.1415926535;
    int E = 6;
    int F = 7;
    Vector2D[] points = new Vector2D[100];
    for (int i = 0; i < 100; i++) {
      points[i] = new Vector2D(1.0, 1.0);
    }

    points[1] = new Vector2D(5.0, 1.0);
    points[1 + E] = new Vector2D(0.0, 1.0);
    points[1 + E + F] = new Vector2D(2.5, 11.0);

    CMV t = new CMV(points, PI, -1E9, 10.0, E, F, 24.9);

    assertTrue(t.cmvFunction10());
  }

  @Test
  void function10TestFalse() {
    double PI = 3.1415926535;
    int E = 6;
    int F = 7;
    Vector2D[] points = new Vector2D[100];
    for (int i = 0; i < 100; i++) {
      points[i] = new Vector2D(1.0, 1.0);
    }

    points[1] = new Vector2D(5.0, 1.0);
    points[1 + E] = new Vector2D(0.0, 1.0);
    points[1 + E + F] = new Vector2D(2.5, 10.0);

    CMV t = new CMV(points, PI, -1E9, 10.0, E, F, 24.9);

    assertFalse(t.cmvFunction10());
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
  // @Test
  // void function7TestFalse() {
  //   double PI = 3.1415926535;
  //   Vector2D[] points = new Vector2D[100];
  //   for (int i = 0; i < 100; i++) {
  //     points[i] = new Vector2D(5.0, 5.0);
  //   }

  //   points[10] = new Vector2D(1.0, 1.0);
  //   points[20] = new Vector2D(9.0, 9.0);
  //   CMV t = new CMV(points, 10.0, 2.0, PI, 1.0, 9);
  //   assertFalse(t.cmvFunction7());
  // }

  // @Test
  // void function12TestTrue() {
  //   double PI = 3.1415926535;
  //   Vector2D[] points = new Vector2D[100];
  //   for (int i = 0; i < 100; i++) {
  //     points[i] = new Vector2D(5.0, 5.0);
  //   }

  //   points[10] = new Vector2D(1.0, 1.0);
  //   points[20] = new Vector2D(9.0, 9.0);
  //   CMV t = new CMV(points, 10.0, 15.0, PI, 1.0, 10);
  //   assertTrue(t.cmvFunction7());
  // }

  // @Test
  // void function12TestFalse() {
  //   double PI = 3.1415926535;
  //   Vector2D[] points = new Vector2D[100];
  //   for (int i = 0; i < 100; i++) {
  //     points[i] = new Vector2D(5.0, 5.0);
  //   }

  //   points[10] = new Vector2D(1.0, 1.0);
  //   points[20] = new Vector2D(9.0, 9.0);
  //   CMV t = new CMV(points, 10.0, 0.0, PI, 1.0, 9);
  //   assertFalse(t.cmvFunction7());
  // }
}
