import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CMVTest {

  @Test
  public void testFunction0_1() {
    Vector2D[] points = new Vector2D[100];

    for (int i = 0; i < 100; i++) {
      points[i] = new Vector2D(1.0, 1.0);
    }

    points[8] = new Vector2D(3.1, 3.1);

    CMV cmv = new CMV(points, 100, 2.0, 0, 0, 0);
    for (int i = 0; i < 100; i++) {
      points[i] = new Vector2D(1.0, 1.0);
    }

    points[8] = new Vector2D(3.1, 3.1);

    CMV cmv = new CMV(points, 100, 2.0, 0, 0, 0, 0, 0, 0);

    assertTrue(cmv.cmvFunction0());
  }

  @Test
  public void testFunction0_2() {
    Vector2D[] points = new Vector2D[100];

    for (int i = 0; i < 100; i++) {
      points[i] = new Vector2D(1.0, 1.0);
    }

    CMV cmv = new CMV(points, 100, 2.0, 0, 0, 0, 0, 0, 0);

    assertFalse(cmv.cmvFunction0());
  }

  @Test
  public void testFunction0_3() {
    Vector2D[] points = new Vector2D[100];

    for (int i = 0; i < 100; i++) {
      points[i] = new Vector2D(2.0, 2.0);
    }

    points[7] = new Vector2D(2.5, 2.5);
    points[8] = new Vector2D(1.6, 1.6);

    CMV cmv = new CMV(points, 100, 1.0, 0, 0, 0, 0, 0, 0);

    assertTrue(cmv.cmvFunction0());
  }

  @Test
  public void testFunction1_0() {
    Vector2D[] points = new Vector2D[100];

    for (int i = 0; i < 100; i++) {
      points[i] = new Vector2D(i, i);
    }

    CMV cmv = new CMV(points, 100, 0, 1, 0, 0, 0, 0, 0);

    assertTrue(cmv.cmvFunction1());
  }

  @Test
  public void testFunction1_1() {
    Vector2D[] points = new Vector2D[100];

    for (int i = 0; i < 100; i++) {
      points[i] = new Vector2D(i, i);
    }

    CMV cmv = new CMV(points, 100, 0, 2, 0, 0, 0, 0, 0);

    assertFalse(cmv.cmvFunction1());
  }

  @Test
  public void testFunction1_2() {
    Vector2D[] points = new Vector2D[100];

    for (int i = 0; i < 100; i++) {
      points[i] = new Vector2D(1, 1);
    }

    points[1] = new Vector2D(4, 1);
    points[2] = new Vector2D(4, 5);

    CMV cmv = new CMV(points, 100, 0, 5, 0, 0, 0, 0, 0);

    assertFalse(cmv.cmvFunction1());
  }

  @Test
  public void testFunction2_0() {
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
  public void testFunction2_1() {
    double PI = 3.1415926535;
    Vector2D p1 = new Vector2D(1.0, 1.0);
    Vector2D p2 = new Vector2D(2.0, 2.0);
    Vector2D p3 = new Vector2D(3.0, 3.0);

    Vector2D[] points = new Vector2D[] { p1, p2, p3 };

    CMV t = new CMV(points, PI, 1.0, 5.0, 5, 5, 10.0);
    assertFalse(t.cmvFunction2());
  }

  @Test
  public void testFunction3_0() {
    Vector2D[] points = new Vector2D[3];

    points[0] = new Vector2D(0.0, 0.0);
    points[1] = new Vector2D(1.0, 4.0);
    points[2] = new Vector2D(2.0, 0.0);

    CMV cmv = new CMV(points, 3, 1, 0, 3.99, 0, 0, 0, 0);

    assertTrue(cmv.cmvFunction3());
  }

  @Test
  public void testFunction3_1() {
    Vector2D[] points = new Vector2D[10];

    for (int i = 0; i < 10; i++) {
      points[i] = new Vector2D(0.0, 0.0);
    }

    points[3] = new Vector2D(1.0, 4.0);
    points[6] = new Vector2D(2.0, 0.0);

    CMV cmv = new CMV(points, 10, 1, 0, 3.99, 0, 0, 0, 0);

    assertFalse(cmv.cmvFunction3());
  }

  @Test
  public void testFunction3_2() {
    Vector2D[] points = new Vector2D[10];

    for (int i = 0; i < 10; i++) {
      points[i] = new Vector2D(0.0, 0.0);
    }

    CMV cmv = new CMV(points, 10, 1, 0, 1, 0, 0, 0, 0);

    assertFalse(cmv.cmvFunction3());
  }

  @Test
  public void testFunction3_3() {
    Vector2D[] points = new Vector2D[2];

    points[0] = new Vector2D(0.0, 0.0);
    points[1] = new Vector2D(100.0, 100.0);

    CMV cmv = new CMV(points, 2, 1, 0, 0, 0, 0, 0, 0);

    assertFalse(cmv.cmvFunction3());
  }

  @Test
  public void testFunction4_0() {
    Vector2D[] points = new Vector2D[10];
    for (int i = 0; i < 10; i++) {
      points[i] = new Vector2D(i, i);
    }

    CMV cmv = new CMV(points, 10, 2, 2);
    assertFalse(cmv.cmvFunction4());
  }

  @Test
  public void testFunction4_1() {
    Vector2D[] points = new Vector2D[10];
    for (int i = 0; i < 10; i++) {
      points[i] = new Vector2D(i, i);
    }
    points[5].x = -1;
    points[7].y = -1;

    CMV cmv = new CMV(points, 10, 3, 3);
    assertTrue(cmv.cmvFunction4());
  }

  @Test
  public void testFunction4_2() {
    Vector2D[] points = new Vector2D[10];
    for (int i = 0; i < 10; i++) {
      points[i] = new Vector2D(i, i);
    }

    CMV cmv = new CMV(points, 10, 1, 1);
    assertTrue(cmv.cmvFunction4());
  }

  @Test
  public void testFunction5_0() {
    Vector2D[] points = new Vector2D[10];

    for (int i = 0; i < 10; i++) {
      points[i] = new Vector2D(1, 1);
    }

    CMV cmv = new CMV(points, 10, 1, 0, 1, 0, 0, 0, 0);

    assertFalse(cmv.cmvFunction5());
  }

  @Test
  public void testFunction5_1() {
    Vector2D[] points = new Vector2D[10];

    for (int i = 0; i < 10; i++) {
      points[i] = new Vector2D(i, i);
    }

    CMV cmv = new CMV(points, 10, 1, 0, 1, 0, 0, 0, 0);

    assertFalse(cmv.cmvFunction5());
  }

  @Test
  public void testFunction5_2() {
    Vector2D[] points = new Vector2D[10];

    for (int i = 0; i < 10; i++) {
      points[i] = new Vector2D(1, 1);
    }

    points[5].x = 0;

    CMV cmv = new CMV(points, 10, 1, 0, 1, 0, 0, 0, 0);

    assertTrue(cmv.cmvFunction5());
  }

  @Test
  public void testFunction6_0() {
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
  public void testFunction6_1() {
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
  public void testFunction7_0() {
    Vector2D[] points = new Vector2D[10];

    for (int i = 0; i < 10; i++) {
      points[i] = new Vector2D(i * 1, 0);
    }

    CMV cmv = new CMV(points, 10, 8.99, 0, 0, 0, 8, 0, 0);

    assertTrue(cmv.cmvFunction7());
  }

  @Test
  public void testFunction7_1() {
    Vector2D[] points = new Vector2D[3];

    for (int i = 0; i < 3; i++) {
      points[i] = new Vector2D(i, i);
    }

    CMV cmv = new CMV(points, 3, 0.5, 0, 0, 0, 0, 0, 0);

    assertTrue(cmv.cmvFunction7());
  }

  @Test
  public void testFunction7_2() {
    Vector2D[] points = new Vector2D[10];

    for (int i = 0; i < 10; i++) {
      points[i] = new Vector2D(i * 1, 0);
    }

    CMV cmv = new CMV(points, 10, 9, 0, 0, 0, 8, 0, 0);

    assertFalse(cmv.cmvFunction7());
  }

  @Test
  public void testFunction7_3() {
    Vector2D[] points = new Vector2D[2];

    points[0] = new Vector2D(0, 0);
    points[1] = new Vector2D(1, 1);

    CMV cmv = new CMV(points, 2, 0.5, 0, 0, 0, 0, 0, 0);

    assertFalse(cmv.cmvFunction7());
  }

  @Test
  public void testFunction7_4() {
    Vector2D[] points = new Vector2D[10];

    for (int i = 0; i < 10; i++) {
      points[i] = new Vector2D(0, 0);
    }

    points[5] = new Vector2D(1, 1);

    CMV cmv = new CMV(points, 10, 0, 0, 0, 0, 8, 0, 0);

    assertFalse(cmv.cmvFunction7());
  }

  @Test
  public void testFunction14_0() {
    Vector2D[] points = new Vector2D[100];

    for (int i = 0; i < 100; i++) {
      points[i] = new Vector2D(1, 1);
    }
    points[2].x = 4;
    points[4].y = 5;
    points[4].x = 4;

    CMV cmv = new CMV(points, 100, 0, 0, 4, 8, 0, 1, 2);

    assertTrue(cmv.cmvFunction14());
  }

  @Test
  public void testFunction14_1() {
    Vector2D[] points = new Vector2D[100];

    for (int i = 0; i < 100; i++) {
      points[i] = new Vector2D(1, 1);
    }
    points[2].x = 4;
    points[3].x = 4;
    points[3].y = 5;
  }

  @Test
  public void testFunction10_0() {
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
  public void testFunction10_1() {
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

    CMV cmv = new CMV(points, 100, 0, 0, 6, 7, 0, 1, 1);

    assertFalse(cmv.cmvFunction14());

    CMV t = new CMV(points, PI, -1E9, 10.0, E, F, 24.9);

    assertFalse(t.cmvFunction10());
  }
}
