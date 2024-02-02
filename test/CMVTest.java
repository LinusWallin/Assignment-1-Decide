import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CMVTest {

  /**
   * Tests that evaluateLIC_0 can identify that a point is further away than 2
   * from one of its adjecent points.
   */
  @Test
  public void testEvaluateLIC_0_1() {
    Vector2D[] points = new Vector2D[100];

    for (int i = 0; i < 100; i++) {
      points[i] = new Vector2D(1.0, 1.0);
    }

    points[8] = new Vector2D(3.1, 3.1);

    CMV cmv = new CMV(points, 100, 2.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    assertTrue(cmv.evaluateLIC_0());
  }

  /**
   * Tests that evaluateLIC_0 can identify that a point isn't further away than LENGTH1
   * from one of its adjecent points, when all points are located on the same
   * position.
   */
  @Test
  public void testEvaluateLIC_0_2() {
    Vector2D[] points = new Vector2D[100];

    for (int i = 0; i < 100; i++) {
      points[i] = new Vector2D(1.0, 1.0);
    }

    CMV cmv = new CMV(points, 100, 2.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    assertFalse(cmv.evaluateLIC_0());
  }

  /**
   * Tests that evaluateLIC_0 can identify that a point is further away than LENGTH1
   * from one of its adjecent points.
   */
  @Test
  public void testEvaluateLIC_0_3() {
    Vector2D[] points = new Vector2D[100];

    for (int i = 0; i < 100; i++) {
      points[i] = new Vector2D(2.0, 2.0);
    }

    points[7] = new Vector2D(2.5, 2.5);
    points[8] = new Vector2D(1.6, 1.6);

    CMV cmv = new CMV(points, 100, 1.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    assertTrue(cmv.evaluateLIC_0());
  }

  /**
   * Tests that evaluateLIC_1 returns true when RADIUS1 is large
   * enough so that three consecutive points can be placed inside or
   * on a circle with radius RADIUS1.
   */
  @Test
  public void testEvaluateLIC_1_0() {
    Vector2D[] points = new Vector2D[100];

    for (int i = 0; i < 100; i++) {
      points[i] = new Vector2D(i, i);
    }

    CMV cmv = new CMV(points, 100, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    assertTrue(cmv.evaluateLIC_1());
  }

  /**
   * Tests that evaluateLIC_1 returns false when the radius is too
   * small to create a circle which can contain three consecutive
   * points.
   */
  @Test
  public void testEvaluateLIC_1_1() {
    Vector2D[] points = new Vector2D[100];

    for (int i = 0; i < 100; i++) {
      points[i] = new Vector2D(i, i);
    }

    CMV cmv = new CMV(points, 100, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    assertFalse(cmv.evaluateLIC_1());
  }

  /**
   * Tests that evaluateLIC_1 returns false when the radius is too
   * small to create a circle which can contain three consecutive
   * points.
   */
  @Test
  public void testEvaluateLIC_1_2() {
    Vector2D[] points = new Vector2D[100];

    for (int i = 0; i < 100; i++) {
      points[i] = new Vector2D(1, 1);
    }

    points[1] = new Vector2D(4, 1);
    points[2] = new Vector2D(4, 5);

    CMV cmv = new CMV(points, 100, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    assertFalse(cmv.evaluateLIC_1());
  }

  /**
   * Tests that evaluateLIC_2 can identify that there are 3 consecutive points
   * which form an angle < PI + EPSILON or angle > PI - EPSILON.
   */
  @Test
  public void testEvaluateLIC_2_0() {
    Vector2D[] points = new Vector2D[100];
    for (int i = 0; i < 100; i++) {
      points[i] = new Vector2D(1.0, 1.0);
    }

    points[1] = new Vector2D(1.0, 1.0);
    points[2] = new Vector2D(2.0, 2.0);
    points[3] = new Vector2D(3.0, 3.0);

    CMV t = new CMV(points, 100, 0, 0, -1E9, 10.0, 0, 0, 5.0, 0, 0, 0, 0, 0, 0, 5, 5, 0, 0, 0, 0);

    
    assertTrue(t.evaluateLIC_2());
  }

  /**
   * Tests that evaluateLIC_2 can identify that there are no 3 consecutive points
   * which form an angle < PI - EPSILON or angle > PI + EPSILON.
   */
  @Test
  public void testEvaluateLIC_2_1() {
    double PI = 3.1415926535;
    Vector2D p1 = new Vector2D(1.0, 1.0);
    Vector2D p2 = new Vector2D(2.0, 2.0);
    Vector2D p3 = new Vector2D(3.0, 3.0);

    Vector2D[] points = new Vector2D[] { p1, p2, p3 };

    CMV t = new CMV(points, 3, 0, 0, 1.0, 10.0, 0, 0, 5.0, 0, 0, 0, 0, 0, 0, 5, 5, 0, 0, 0, 0);

    assertFalse(t.evaluateLIC_2());
  }

  /**
   * Tests that evaluateLIC_3 can identify that 3 consecutive create a triangle
   * with area greater than AREA1.
   */
  @Test
  public void testEvaluateLIC_3_0() {
    Vector2D[] points = new Vector2D[3];

    points[0] = new Vector2D(0.0, 0.0);
    points[1] = new Vector2D(1.0, 4.0);
    points[2] = new Vector2D(2.0, 0.0);

    CMV cmv = new CMV(points, 3, 1, 0, 0.0, 3.99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    assertTrue(cmv.evaluateLIC_3());
  }

  /**
   * Tests that EvaluateLIC_3 can identify that there isn't 3 consecutive which
   * create a triangle with area greater than AREA1.
   */
  @Test
  public void testEvaluateLIC_3_1() {
    Vector2D[] points = new Vector2D[10];

    for (int i = 0; i < 10; i++) {
      points[i] = new Vector2D(0.0, 0.0);
    }

    points[3] = new Vector2D(1.0, 4.0);
    points[6] = new Vector2D(2.0, 0.0);

    CMV cmv = new CMV(points, 10, 1, 0, 0.0, 3.99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    assertFalse(cmv.evaluateLIC_3());
  }

  /**
   * Tests that evaluateLIC_3 can identify that there isn't 3 consecutive which
   * create a triangle with area greater than AREA1, when all points are
   * in the same position.
   */
  @Test
  public void testEvaluateLIC_3_2() {
    Vector2D[] points = new Vector2D[10];

    for (int i = 0; i < 10; i++) {
      points[i] = new Vector2D(0.0, 0.0);
    }

    CMV cmv = new CMV(points, 10, 1, 0, 0.0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    assertFalse(cmv.evaluateLIC_3());
  }

  /**
   * Tests that evaluateLIC_3 can identify that there isn't 3 consecutive which
   * create a triangle with area greater than AREA1 when there only is 2 points.
   */
  @Test
  public void testEvaluateLIC_3_3() {
    Vector2D[] points = new Vector2D[2];

    points[0] = new Vector2D(0.0, 0.0);
    points[1] = new Vector2D(100.0, 100.0);

    CMV cmv = new CMV(points, 2, 1, 0, 0.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    assertFalse(cmv.evaluateLIC_3());
  }

  /**
   * Tests that evaluateLIC_4 can find Q_PTS consecutive points in at least QUADS
   * different quadrants.
   */
  @Test
  public void testEvaluateLIC_4_0() {
    Vector2D[] points = new Vector2D[10];
    for (int i = 0; i < 10; i++) {
      points[i] = new Vector2D(i, i);
    }

    CMV cmv = new CMV(points, 10, 0, 0, 0.0, 0, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    assertFalse(cmv.evaluateLIC_4());
  }

  /**
   * Tests that evaluateLIC_4 can find Q_PTS consecutive points in at least QUADS
   * different quadrants, when x-values and y values are negative.
   */
  @Test
  public void testEvaluateLIC_4_1() {
    Vector2D[] points = new Vector2D[10];
    for (int i = 0; i < 10; i++) {
      points[i] = new Vector2D(i, i);
    }
    points[5].x = -1;
    points[7].y = -1;

    CMV cmv = new CMV(points, 10, 0, 0, 0.0, 0, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    assertTrue(cmv.evaluateLIC_4());
  }

  /**
   * Tests that evaluateLIC_4 can find Q_PTS consecutive points in at least QUADS
   * different quadrants, when both variables are 1.
   */
  @Test
  public void testEvaluateLIC_4_2() {
    Vector2D[] points = new Vector2D[10];
    for (int i = 0; i < 10; i++) {
      points[i] = new Vector2D(i, i);
    }

    CMV cmv = new CMV(points, 10, 0, 0, 0.0, 0,1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    assertTrue(cmv.evaluateLIC_4());
  }

  /**
   * Tests that evaluateLIC_5 can identify when there is no point with larger
   * x-value than the next point, when all points are at the same position.
   */
  @Test
  public void testEvaluateLIC_5_0() {
    Vector2D[] points = new Vector2D[10];

    for (int i = 0; i < 10; i++) {
      points[i] = new Vector2D(1, 1);
    }

    CMV cmv = new CMV(points, 10, 1, 0, 0.0, 1.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    assertFalse(cmv.evaluateLIC_5());
  }

  /**
   * Tests that evaluateLIC_5 can identify when there is no point with larger
   * x-value than the previous point, when the points are on the line y=x.
   */
  @Test
  public void testEvaluateLIC_5_1() {
    Vector2D[] points = new Vector2D[10];

    for (int i = 0; i < 10; i++) {
      points[i] = new Vector2D(i, i);
    }
    
    CMV cmv = new CMV(points, 10, 1, 0, 0.0, 1.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    assertFalse(cmv.evaluateLIC_5());
  }

  /**
   * Tests that evaluateLIC_5 can identify when there is a point that has a 
   * larger x-value than the next point.
   */
  @Test
  public void testEvaluateLIC_5_2() {
    Vector2D[] points = new Vector2D[10];

    for (int i = 0; i < 10; i++) {
      points[i] = new Vector2D(1, 1);
    }

    points[5].x = 0;

    CMV cmv = new CMV(points, 10, 1, 0, 0.0, 1.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    assertTrue(cmv.evaluateLIC_5());
  }

  /**
   * Test that evaluateLIC_6 returns true if the distance to the line
   * for every other point than the start and end points, which
   * represent the line, is greater than DIST.
   */
  @Test
  public void testEvaluateLIC_6_0() {
    Vector2D[] points = new Vector2D[100];
    for (int i = 0; i < 100; i++) {
      points[i] = new Vector2D(2.0, 2.0);
    }

    points[1] = new Vector2D(1.0, 1.0);
    points[1 + 6 + 1] = new Vector2D(1.0, 1.0);
    points[1 + 6 + 7 + 2] = new Vector2D(2.0, 13.0);

    CMV t = new CMV(points, 100, 0, 0, -1E9, 10.0, 0, 0, 10.0, 17, 0, 0, 0, 0, 0, 6, 7, 0, 0, 0, 0);

    assertTrue(t.evaluateLIC_6());
  }

  /**
   * Test that evaluateLIC_6 returns false if the distance to the line
   * for every other point than the start and end points, which
   * represent the line, is less than DIST.
   */
  @Test
  public void testEvaluateLIC_6_1() {
    double PI = 3.1415926535;
    Vector2D[] points = new Vector2D[100];
    for (int i = 0; i < 100; i++) {
      points[i] = new Vector2D(2.0, 2.0);
    }
    points[1] = new Vector2D(1.0, 1.0);
    points[1 + 6 + 1] = new Vector2D(1.0, 1.0);
    points[1 + 6 + 7 + 2] = new Vector2D(11.0, 11.0);

    CMV t = new CMV(points, 100, 0, 0, -1E9, 10.0, 0, 0, 10.0, 1, 0, 0, 0, 0, 0, 6, 7, 0, 0, 0, 0);

    assertFalse(t.evaluateLIC_6());
  }

  /**
   * Tests that evaluateLIC_7 can find 2 points separated by K_PTS consecutive
   * points and that are no further apart than LENGTH1.
   */
  @Test
  public void testEvaluateLIC_7_0() {
    Vector2D[] points = new Vector2D[10];

    for (int i = 0; i < 10; i++) {
      points[i] = new Vector2D(i * 1, 0);
    }

    CMV cmv = new CMV(points, 10, 8.99, 0, 0.0, 0.0, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    assertTrue(cmv.evaluateLIC_7());
  }

  /**
   * Tests that evaluateLIC_7 can find 2 points separated by K_PTS consecutive
   * points and that are no further apart than LENGTH1.
   */
  @Test
  public void testEvaluateLIC_7_1() {
    Vector2D[] points = new Vector2D[3];

    for (int i = 0; i < 3; i++) {
      points[i] = new Vector2D(i, i);
    }

    CMV cmv = new CMV(points, 3, 0.5, 0, 0.0, 0.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    assertTrue(cmv.evaluateLIC_7());
  }

  /**
   * Tests that evaluateLIC_7 can't find 2 points separated by K_PTS consecutive
   * points and that are no further apart than LENGTH1.
   */
  @Test
  public void testEvaluateLIC_7_2() {
    Vector2D[] points = new Vector2D[10];

    for (int i = 0; i < 10; i++) {
      points[i] = new Vector2D(i * 1, 0);
    }

    CMV cmv = new CMV(points, 10, 9, 0, 0.0, 0.0, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    assertFalse(cmv.evaluateLIC_7());
  }

  /**
   * Tests that evaluateLIC_7 can't find 2 points separated by K_PTS consecutive
   * points and that are no further apart than LENGTH1 if there only is 2 points.
   */
  @Test
  public void testEvaluateLIC_7_3() {
    Vector2D[] points = new Vector2D[2];

    points[0] = new Vector2D(0, 0);
    points[1] = new Vector2D(1, 1);

    CMV cmv = new CMV(points, 2, 0.5, 0, 0.0, 0.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    assertFalse(cmv.evaluateLIC_7());
  }

  /**
   * Tests that evaluateLIC_7 can't find 2 points separated by K_PTS consecutive
   * points and that are no further apart than LENGTH1, when all points are
   * at the same position.
   */
  @Test
  public void testEvaluateLIC_7_4() {
    Vector2D[] points = new Vector2D[10];

    for (int i = 0; i < 10; i++) {
      points[i] = new Vector2D(0, 0);
    }

    points[5] = new Vector2D(1, 1);

    CMV cmv = new CMV(points, 10, 0, 0, 0.0, 0.0, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    assertFalse(cmv.evaluateLIC_7());
  }

  /**
   * Tests that evaluateLIC_8 is able to find 3 points separated by exactly
   * A_PTS and B_PTS consecutive intervening points that can be contained
   * inside or on a circle with RADIUS1, when the radius is larger.
   */
  @Test
  public void testEvaluateLIC_8_0(){
    Vector2D[] points = new Vector2D[10];

    for(int i = 0; i < 10; i++){
      points[i] = new Vector2D(i, i);
    }

    CMV cmv = new CMV(points, 10, 0, 1, 0.0, 0.0, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    assertTrue(cmv.evaluateLIC_8());
  }

  /**
   * Tests that evaluateLIC_8 isn't able to find 3 points separated by exactly
   * A_PTS and B_PTS consecutive intervening points that can be contained
   * inside or on a circle with RADIUS1.
   */
  @Test
  public void testEvaluateLIC_8_1(){
    Vector2D[] points = new Vector2D[10];

    for(int i = 0; i < 10; i++){
      points[i] = new Vector2D(i, i);
    }

    CMV cmv = new CMV(points, 10, 0, 1.415, 0.0, 0.0, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    assertFalse(cmv.evaluateLIC_8());
  }

  /**
   * Tests that evaluateLIC_8 returns true if the distance from each of the
   * possible circle centers have a larger distance to at least one of
   * the points than the given RADIUS1. Also tests that false is returned
   * if the distance is less for all points.
   */
  @Test
  public void testEvaluateLIC_8_2(){
    Vector2D[] points = new Vector2D[10];

    for(int i = 0; i < 10; i++){
      points[i] = new Vector2D(i, i);
    }

    points[2] = new Vector2D(0.5, 0.5);

    points[4] = new Vector2D(0, 0.5);


    CMV cmv = new CMV(points, 10, 0, 0.5, 0.0, 0.0, 0, 0, 0, 0, 8, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0);

    assertTrue(cmv.evaluateLIC_8());

    cmv = new CMV(points, 10, 0, 7.072, 0.0, 0.0, 0, 0, 0, 0, 8, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0);

    assertFalse(cmv.evaluateLIC_8());

  }

  /**
   * Tests that evaluateLIC_9 is false when there are no three points
   * separated by C_PTS and D_PTS consecutive points, which create
   * an angle < PI - EPSILON or angle > PI + EPSILON.
   */
  @Test
  public void testEvaluateLIC_9_0(){
      Vector2D[] points = new Vector2D[100];
      
      double x = 0.0;
      for(int i=0; i < 100; i++){
          points[i] = new Vector2D(x,0.0);
          x = x + 1.0;
      }
  
      int C_PTS = 1;
      int D_PTS = 1;
      double EPSILON = 0.01;
      CMV cmv = new CMV(points, 100, 0, 0, EPSILON, 0, 0, 0, 0, 0, 0, 0, 0, C_PTS, D_PTS, 0, 0, 0, 0,0,0);

      assertFalse(cmv.evaluateLIC_9());
  }

  /**
   * Tests that evaluateLIC_9 is true if there is big angle between
   * 3 points that are C_PTS and D_PTS points apart.
   * Every big angle have an opposite small angle.
   */
  
  @Test
  public void testEvaluateLIC_9_1(){
      Vector2D[] points = new Vector2D[100];

      double x = 0.0;
      for(int i=0; i < 100; i++){
          points[i] = new Vector2D(x,0.0);
          x = x + 1.0;
      }

      //.....89...93.....99 expected 3 points returning true. 
      int C_PTS = 3;
      int D_PTS = 5;
      points[89]= new Vector2D(89.0,0.0);
      points[93]= new Vector2D(93.0,0.0);
      points[99]= new Vector2D(99.0,-10.0);
      double EPSILON = 1.0;
      CMV cmv = new CMV(points, 100, 0, 0, EPSILON, 0, 0, 0, 0, 0, 0, 0, 0, C_PTS, D_PTS, 0, 0, 0, 0,0,0);

      assertTrue(cmv.evaluateLIC_9());
  }

  /**
   * Tests true if there is small angle between 3 points
   * that are C_PTS and D_PTS points apart.
   */
  @Test
  public void testEvaluateLIC_9_2(){
      Vector2D[] points = new Vector2D[100];

      double x = 0.0;
      for(int i=0; i < 100; i++){
          points[i] = new Vector2D(x,0.0);
          x = x + 1.0;
      }

      //.....89...93.....99 expected 3 points returning true. 
      int C_PTS = 3;
      int D_PTS = 5;
      points[89]= new Vector2D(89.0,0.0);
      points[93]= new Vector2D(93.0,0.0);
      points[99]= new Vector2D(99.0,10.0);
      double EPSILON = 1.0;
      CMV cmv = new CMV(points, 100, 0, 0, EPSILON, 0, 0, 0, 0, 0, 0, 0, 0, C_PTS, D_PTS, 0, 0, 0, 0,0,0);

      assertTrue(cmv.evaluateLIC_9());
  }

  /**
   * Test that evaluateLIC_10 returns true when the area of the
   * triangle formed by 3 points separated by E_PTS and F_PTS
   * consecutive points is larger than AREA1.
   */
  @Test
  public void testEvaluateLIC_10_0() {
    double PI = 3.1415926535;
    int E = 6;
    int F = 7;
    Vector2D[] points = new Vector2D[100];
    for (int i = 0; i < 100; i++) {
      points[i] = new Vector2D(1.0, 1.0);
    }

    points[1] = new Vector2D(5.0, 1.0);
    points[1 + E + 1] = new Vector2D(0.0, 1.0);
    points[1 + E + F + 2] = new Vector2D(2.5, 11.0);

    CMV t = new CMV(points, 100, 0, 0, -1E9, 24.9, 0, 0, 10.0, 0, 0, 0, 0, 0, 0, E, F, 0, 0, 0, 0);

    assertTrue(t.evaluateLIC_10());
  }

  /**
   * Test that evaluateLIC_10 returns false when the area of the
   * triangle formed by 3 points separated by E_PTS and F_PTS
   * consecutive points is smaller than AREA1.
   */
  @Test
  public void testEvaluateLIC_10_1() {
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

    CMV t = new CMV(points, 100, 0, 0, -1E9, 24.9, 0, 0, 10.0, 0, 0, 0, 0, 0, 0, E, F, 0, 0, 0, 0);

    assertFalse(t.evaluateLIC_10());
  }

  /**
   * Test that EvaluateLIC_11 returns true when the x-value of the
   * point is less than that of the point that is G_PTS
   * consecutive points apart from the current point.
   */
  @Test
  public void testEvaluateLIC_11_0(){
    
    Vector2D[] points = new Vector2D[10];

    for (int i = 0; i < 10; i++){
      points[i] = new Vector2D((-1)*i, (-1)*i);
    }

    CMV cmv = new CMV(points, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 0, 0, 0);

    assertTrue(cmv.evaluateLIC_11());
  }

  /**
   * Test that evaluateLIC_11 returns false when G_PTS is equal to 
   * NUMPOINTS - 1.
   */
  @Test
  public void testEvaluateLIC_11_1(){

    Vector2D[] points = new Vector2D[10];

    for (int i = 0; i < 10; i++){
      points[i] = new Vector2D((-1)*i, (-1)*i);
    }

    CMV cmv = new CMV(points, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 0, 0, 0);

    assertFalse(cmv.evaluateLIC_11());
  }

  /**
   * Test that evaluateLIC_11 returns false when there are only 2
   * points.
   */
  @Test
  public void testEvaluateLIC_11_2(){

    Vector2D[] points = new Vector2D[2];

    for (int i = 0; i < 2; i++){
      points[i] = new Vector2D((-1)*i, (-1)*i);
    }

    CMV cmv = new CMV(points, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    assertFalse(cmv.evaluateLIC_11());
  }

  /**
   * Test that evaluateLIC_11 returns false when the x-value of the
   * current point - the x-value of the point that is G_PTS 
   * consecutive points further is less than 0.
   */
  @Test
  public void testEvaluateLIC_11_3(){

    Vector2D[] points = new Vector2D[10];

    for (int i = 0; i < 10; i++){
      points[i] = new Vector2D(i, i);
    }

    CMV cmv = new CMV(points, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0);
    
    assertFalse(cmv.evaluateLIC_11());
  }

  /**
   * Tests that evaluateLIC_12 returns false if the distance between
   * all points separated by K_PTS is less than LENGTH1.
   * Tests that evaluateLIC_12 returns false if the distance between
   * all points separated by K_PTS is greater than LENGTH2.
   * Tests that evaluateLIC_12 returns true if the distance between
   * two points separated by K_PTS is greater than LENGTH1 and
   * the distance between two other points or the same points
   * separated by K_PTS consecutive points is less than LENGTH2.
   */
  @Test
    public void testEvaluateLIC_12_0(){
        Vector2D[] points = new Vector2D[10];
        for(int i = 0; i < 10; i++){
            points[i] = new Vector2D(0, i);
        }

        
        CMV cmv = new CMV(points, 10, 4, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 10, 0, 0);
        assertFalse(cmv.evaluateLIC_12());

        CMV cmv1 = new CMV(points, 10, 3, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0);
        assertFalse(cmv1.evaluateLIC_12());
        
        CMV cmv2 = new CMV(points, 10, 3.9, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 4.1, 0, 0);
        assertTrue(cmv2.evaluateLIC_12());

        CMV cmv3 = new CMV(points, 10, 5, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 6.1, 0, 0);
        assertTrue(cmv3.evaluateLIC_12());
    }  


    /**
     * test if evaluateLIC_13 returns false if no condition is met.
     */
  @Test
  public void testEvaluateLIC_13_0(){
      Vector2D[] points = new Vector2D[100];
      
      double x = 0.0; 
      for(int i=0; i < 100; i++){
          points[i] = new Vector2D(x,0.0);
          x = x + 0.1;
      }
  
      int A_PTS = 1;
      int B_PTS = 1;
      double RADIUS1 = 1.0;
      double RADIUS2 = 0.0;

        CMV cmv = new CMV(points, 100, 0, RADIUS1, 0, 0, 0, 0, 0, 0, 0, A_PTS, B_PTS, 0, 0, 0, 0, 0, 0,RADIUS2,0);

        assertFalse(cmv.evaluateLIC_13());
    }

    /**
     * Tests if evaluateLIC_13 all points same expect 2 different set of 3 where. 
     * one set meets condition 1
     * the other set meets condition 2.
     * expect the evaluateLIC_ to return true.
     */
  @Test
  public void testEvaluateLIC_13_1(){
      Vector2D[] points = new Vector2D[100];
       
      for(int i=0; i < 100; i++){
          points[i] = new Vector2D(1.0,0.0);
      }

      points[19] = new Vector2D(1000.0,1000.0);
      points[21] = new Vector2D(0.0,0.0);

      points[77] = new Vector2D(3000.7,3000.0);
      points[79] = new Vector2D(3000.2,3000.0);
      points[81] = new Vector2D(3000.3,3000.0);
  
      int A_PTS = 1;
      int B_PTS = 1;
      double RADIUS2 = 100.0;
      double RADIUS1 = 50.0;

        CMV cmv = new CMV(points, 100, 0, RADIUS1, 0, 0, 0, 0, 0, 0, 0, A_PTS, B_PTS, 0, 0, 0, 0, 0, 0,RADIUS2,0);

      assertTrue(cmv.evaluateLIC_13());
  }

    /**
     * test if evaluateLIC_13 returns false if only condition 1 met.
     */
  @Test
  public void testEvaluateLIC_13_2(){
      Vector2D[] points = new Vector2D[100];
       
      double x = 1.0;
      for(int i=0; i < 100; i++){
            points[i] = new Vector2D(x,0.0);
            x= x+ 100.0;
      }

      int A_PTS = 10;
      int B_PTS = 10;
      double RADIUS1 = 50.0;
      double RADIUS2 = 100.0;

      CMV cmv = new CMV(points, 100, 0, RADIUS1, 0, 0, 0, 0, 0, 0, 0, A_PTS, B_PTS, 0, 0, 0, 0, 0, 0,RADIUS2,0);

      assertFalse(cmv.evaluateLIC_13());
  }

    /**
     * test if evaluateLIC_13 returns false if only condition 2 met.
     */
  @Test
  public void testEvaluateLIC_13_3(){
      Vector2D[] points = new Vector2D[100];

      double x = 0.0;
      for(int i=0; i < 100; i++){
            points[i] = new Vector2D(x,0.0);
            x= x+ 10.0;
      }
    
      int A_PTS = 1;
      int B_PTS = 1;
      double RADIUS1 = 5000.0;
      double RADIUS2 = 100.0;

      CMV cmv = new CMV(points, 100, 0, RADIUS1, 0, 0, 0, 0, 0, 0, 0, A_PTS, B_PTS, 0, 0, 0, 0, 0, 0,RADIUS2,0);

      assertFalse(cmv.evaluateLIC_13());
  }

    /**
     * Tests that evaluateLIC_ 14 returns true when the area given
     * by the three points separated by E_PTS and F_PTS consecutive
     * points is greater than AREA1 but smaller than AREA2.
     */
    @Test
    public void testEvaluateLIC_14_0() {
      Vector2D[] points = new Vector2D[100];

      for (int i = 0; i < 100; i++) {
        points[i] = new Vector2D(1, 1);
      }
      points[2].x = 4;
      points[4].y = 5;
      points[4].x = 4;

      CMV cmv = new CMV(points, 100, 0, 0, 0.0, 4.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0, 0, 0, 8);

      assertTrue(cmv.evaluateLIC_14());
    }

    /**
     * Tests that evaluateLIC_ 14 returns false when the area given
     * by the three points separated by E_PTS and F_PTS consecutive
     * points is equal to AREA1 and larger than AREA2.
     */
    @Test
    public void testEvaluateLIC_14_1() {
      Vector2D[] points = new Vector2D[100];

      for (int i = 0; i < 100; i++) {
        points[i] = new Vector2D(1, 1);
      }
      points[2].x = 4;
      points[3].x = 4;
      points[3].y = 5;

      CMV cmv = new CMV(points, 100, 0, 0, 0.0, 6.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

      assertFalse(cmv.evaluateLIC_14());

    }

}
