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

    CMV cmv = new CMV(points, 100, 2.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    assertTrue(cmv.cmvFunction0());
  }

  @Test
  public void testFunction0_2() {
    Vector2D[] points = new Vector2D[100];

    for (int i = 0; i < 100; i++) {
      points[i] = new Vector2D(1.0, 1.0);
    }

    CMV cmv = new CMV(points, 100, 2.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

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

    CMV cmv = new CMV(points, 100, 1.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    assertTrue(cmv.cmvFunction0());
  }

  @Test
  public void testFunction1_0() {
    Vector2D[] points = new Vector2D[100];

    for (int i = 0; i < 100; i++) {
      points[i] = new Vector2D(i, i);
    }

    CMV cmv = new CMV(points, 100, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    assertTrue(cmv.cmvFunction1());
  }

  @Test
  public void testFunction1_1() {
    Vector2D[] points = new Vector2D[100];

    for (int i = 0; i < 100; i++) {
      points[i] = new Vector2D(i, i);
    }

    CMV cmv = new CMV(points, 100, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

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

    CMV cmv = new CMV(points, 100, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

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

    CMV t = new CMV(points, 100, 0, 0, -1E9, 10.0, 0, 0, 5.0, 0, 0, 0, 0, 0, 0, 5, 5, 0, 0, 0, 0);

    
    assertTrue(t.cmvFunction2());
  }

  @Test
  public void testFunction2_1() {
    double PI = 3.1415926535;
    Vector2D p1 = new Vector2D(1.0, 1.0);
    Vector2D p2 = new Vector2D(2.0, 2.0);
    Vector2D p3 = new Vector2D(3.0, 3.0);

    Vector2D[] points = new Vector2D[] { p1, p2, p3 };

    CMV t = new CMV(points, 3, 0, 0, 1.0, 10.0, 0, 0, 5.0, 0, 0, 0, 0, 0, 0, 5, 5, 0, 0, 0, 0);

    assertFalse(t.cmvFunction2());
  }

  @Test
  public void testFunction3_0() {
    Vector2D[] points = new Vector2D[3];

    points[0] = new Vector2D(0.0, 0.0);
    points[1] = new Vector2D(1.0, 4.0);
    points[2] = new Vector2D(2.0, 0.0);

    CMV cmv = new CMV(points, 3, 1, 0, 0.0, 3.99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

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

    CMV cmv = new CMV(points, 10, 1, 0, 0.0, 3.99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    assertFalse(cmv.cmvFunction3());
  }

  @Test
  public void testFunction3_2() {
    Vector2D[] points = new Vector2D[10];

    for (int i = 0; i < 10; i++) {
      points[i] = new Vector2D(0.0, 0.0);
    }

    CMV cmv = new CMV(points, 10, 1, 0, 0.0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    assertFalse(cmv.cmvFunction3());
  }

  @Test
  public void testFunction3_3() {
    Vector2D[] points = new Vector2D[2];

    points[0] = new Vector2D(0.0, 0.0);
    points[1] = new Vector2D(100.0, 100.0);

    CMV cmv = new CMV(points, 2, 1, 0, 0.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    assertFalse(cmv.cmvFunction3());
  }

  @Test
  public void testFunction4_0() {
    Vector2D[] points = new Vector2D[10];
    for (int i = 0; i < 10; i++) {
      points[i] = new Vector2D(i, i);
    }

    CMV cmv = new CMV(points, 10, 0, 0, 0.0, 0, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

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

    CMV cmv = new CMV(points, 10, 0, 0, 0.0, 0, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    assertTrue(cmv.cmvFunction4());
  }

  @Test
  public void testFunction4_2() {
    Vector2D[] points = new Vector2D[10];
    for (int i = 0; i < 10; i++) {
      points[i] = new Vector2D(i, i);
    }

    CMV cmv = new CMV(points, 10, 0, 0, 0.0, 0,1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    assertTrue(cmv.cmvFunction4());
  }

  @Test
  public void testFunction5_0() {
    Vector2D[] points = new Vector2D[10];

    for (int i = 0; i < 10; i++) {
      points[i] = new Vector2D(1, 1);
    }

    CMV cmv = new CMV(points, 10, 1, 0, 0.0, 1.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    assertFalse(cmv.cmvFunction5());
  }

  @Test
  public void testFunction5_1() {
    Vector2D[] points = new Vector2D[10];

    for (int i = 0; i < 10; i++) {
      points[i] = new Vector2D(i, i);
    }
    
    CMV cmv = new CMV(points, 10, 1, 0, 0.0, 1.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    assertFalse(cmv.cmvFunction5());
  }

  @Test
  public void testFunction5_2() {
    Vector2D[] points = new Vector2D[10];

    for (int i = 0; i < 10; i++) {
      points[i] = new Vector2D(1, 1);
    }

    points[5].x = 0;

    CMV cmv = new CMV(points, 10, 1, 0, 0.0, 1.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

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
    points[1 + 6 + 1] = new Vector2D(1.0, 1.0);
    points[1 + 6 + 7 + 2] = new Vector2D(2.0, 13.0);

    CMV t = new CMV(points, 100, 0, 0, -1E9, 10.0, 0, 0, 10.0, 17, 0, 0, 0, 0, 0, 6, 7, 0, 0, 0, 0);

    assertTrue(t.cmvFunction6());
  }

  @Test
  public void testFunction6_1() {
    double PI = 3.1415926535;
    Vector2D[] points = new Vector2D[100];
    for (int i = 0; i < 100; i++) {
      points[i] = new Vector2D(2.0, 2.0);
    }
    points[1] = new Vector2D(1.0, 1.0);
    points[1 + 6 + 1] = new Vector2D(1.0, 1.0);
    points[1 + 6 + 7 + 2] = new Vector2D(11.0, 11.0);

    CMV t = new CMV(points, 100, 0, 0, -1E9, 10.0, 0, 0, 10.0, 1, 0, 0, 0, 0, 0, 6, 7, 0, 0, 0, 0);

    assertFalse(t.cmvFunction6());
  }

  @Test
  public void testFunction7_0() {
    Vector2D[] points = new Vector2D[10];

    for (int i = 0; i < 10; i++) {
      points[i] = new Vector2D(i * 1, 0);
    }

    CMV cmv = new CMV(points, 10, 8.99, 0, 0.0, 0.0, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    assertTrue(cmv.cmvFunction7());
  }

  @Test
  public void testFunction7_1() {
    Vector2D[] points = new Vector2D[3];

    for (int i = 0; i < 3; i++) {
      points[i] = new Vector2D(i, i);
    }

    CMV cmv = new CMV(points, 3, 0.5, 0, 0.0, 0.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    assertTrue(cmv.cmvFunction7());
  }

  @Test
  public void testFunction7_2() {
    Vector2D[] points = new Vector2D[10];

    for (int i = 0; i < 10; i++) {
      points[i] = new Vector2D(i * 1, 0);
    }

    CMV cmv = new CMV(points, 10, 9, 0, 0.0, 0.0, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    assertFalse(cmv.cmvFunction7());
  }

  @Test
  public void testFunction7_3() {
    Vector2D[] points = new Vector2D[2];

    points[0] = new Vector2D(0, 0);
    points[1] = new Vector2D(1, 1);

    CMV cmv = new CMV(points, 2, 0.5, 0, 0.0, 0.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    assertFalse(cmv.cmvFunction7());
  }

  @Test
  public void testFunction7_4() {
    Vector2D[] points = new Vector2D[10];

    for (int i = 0; i < 10; i++) {
      points[i] = new Vector2D(0, 0);
    }

    points[5] = new Vector2D(1, 1);

    CMV cmv = new CMV(points, 10, 0, 0, 0.0, 0.0, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    assertFalse(cmv.cmvFunction7());
  }

  @Test
  public void testFunction8_0(){
    Vector2D[] points = new Vector2D[10];

    for(int i = 0; i < 10; i++){
      points[i] = new Vector2D(i, i);
    }

    CMV cmv = new CMV(points, 10, 0, 1, 0.0, 0.0, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    assertTrue(cmv.cmvFunction8());
  }

  @Test
  public void testFunction8_1(){
    Vector2D[] points = new Vector2D[10];

    for(int i = 0; i < 10; i++){
      points[i] = new Vector2D(i, i);
    }

    CMV cmv = new CMV(points, 10, 0, 1.415, 0.0, 0.0, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    assertFalse(cmv.cmvFunction8());
  }

  @Test
  public void testFunction8_2(){
    Vector2D[] points = new Vector2D[10];

    for(int i = 0; i < 10; i++){
      points[i] = new Vector2D(i, i);
    }

    points[2] = new Vector2D(0.5, 0.5);

    points[4] = new Vector2D(0, 0.5);


    CMV cmv = new CMV(points, 10, 0, 0.5, 0.0, 0.0, 0, 0, 0, 0, 8, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0);

    assertTrue(cmv.cmvFunction8());

    cmv = new CMV(points, 10, 0, 7.072, 0.0, 0.0, 0, 0, 0, 0, 8, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0);

    assertFalse(cmv.cmvFunction8());

  }

    @Test
    public void testFunction12_0(){
        Vector2D[] points = new Vector2D[10];
        for(int i = 0; i < 10; i++){
            points[i] = new Vector2D(0, i);
        }

        
        CMV cmv = new CMV(points, 10, 4, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 10, 0, 0);
        assertFalse(cmv.cmvFunction12());

        CMV cmv1 = new CMV(points, 10, 3, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0);
        assertFalse(cmv1.cmvFunction12());
        
        CMV cmv2 = new CMV(points, 10, 3.9, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 4.1, 0, 0);
        assertTrue(cmv2.cmvFunction12());

        CMV cmv3 = new CMV(points, 10, 5, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 6.1, 0, 0);
        assertTrue(cmv3.cmvFunction12());
    }  


  // returns false if RADIUS1 is smaller than distance between all 3 points.
  @Test
  public void testFunction13_0(){
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

      assertFalse(cmv.cmvFunction13());
  }

  // return true when 2 pair of points exists.
  @Test
  public void testFunction13_1(){
      Vector2D[] points = new Vector2D[100];
       
      double x = 1.0;
      for(int i=0; i < 100; i++){
          points[i] = new Vector2D(x,0.0);
      }

      points[19] = new Vector2D(1000.0,1000.0);
      points[20] = new Vector2D(0.0,0.0);

      points[77] = new Vector2D(3000.1,3000.0);
      points[78] = new Vector2D(3000.2,3000.0);
      points[79] = new Vector2D(3000.3,3000.0);
  
      int A_PTS = 1;
      int B_PTS = 1;
      double RADIUS2 = 0.5;
      double RADIUS1 = 790.0;

      CMV cmv = new CMV(points, 100, 0, RADIUS1, 0, 0, 0, 0, 0, 0, 0, A_PTS, B_PTS, 0, 0, 0, 0, 0, 0,RADIUS2,0);

      assertTrue(cmv.cmvFunction13());
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

    CMV cmv = new CMV(points, 100, 0, 0, 0.0, 4.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0, 0, 0, 8);

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

    CMV cmv = new CMV(points, 100, 0, 0, 0.0, 6.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    assertFalse(cmv.cmvFunction14());

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
    points[1 + E + 1] = new Vector2D(0.0, 1.0);
    points[1 + E + F + 2] = new Vector2D(2.5, 11.0);

    CMV t = new CMV(points, 100, 0, 0, -1E9, 24.9, 0, 0, 10.0, 0, 0, 0, 0, 0, 0, E, F, 0, 0, 0, 0);

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

    CMV t = new CMV(points, 100, 0, 0, -1E9, 24.9, 0, 0, 10.0, 0, 0, 0, 0, 0, 0, E, F, 0, 0, 0, 0);

    assertFalse(t.cmvFunction10());
  }

  @Test
  public void testFunction11_0(){
    
    Vector2D[] points = new Vector2D[10];

    for (int i = 0; i < 10; i++){
      points[i] = new Vector2D((-1)*i, (-1)*i);
    }

    CMV cmv = new CMV(points, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 0, 0, 0);

    assertTrue(cmv.cmvFunction11());
  }

  @Test
  public void testFunction11_1(){

    Vector2D[] points = new Vector2D[10];

    for (int i = 0; i < 10; i++){
      points[i] = new Vector2D((-1)*i, (-1)*i);
    }

    CMV cmv = new CMV(points, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 0, 0, 0);

    assertFalse(cmv.cmvFunction11());
  }

  @Test
  public void testFunction11_2(){

    Vector2D[] points = new Vector2D[2];

    for (int i = 0; i < 2; i++){
      points[i] = new Vector2D((-1)*i, (-1)*i);
    }

    CMV cmv = new CMV(points, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    assertFalse(cmv.cmvFunction11());
  }

  @Test
  public void testFunction11_3(){

    Vector2D[] points = new Vector2D[10];

    for (int i = 0; i < 10; i++){
      points[i] = new Vector2D(i, i);
    }
  }


    //The function goes through all iterations
    @Test
    public void testFunction9_0(){
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

        assertFalse(cmv.cmvFunction9());
    }
    //tests true if there is big angle between 3 points that are C_PTS and D_PTS points apart.
    // every big angle have an opposite small angle.
    @Test
    public void testFunction9_1(){
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

        assertTrue(cmv.cmvFunction9());
    }

    //tests true if there is small angle between 3 points that are C_PTS and D_PTS points apart.
    @Test
    public void testFunction9_2(){
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

        assertTrue(cmv.cmvFunction9());
    }

}
