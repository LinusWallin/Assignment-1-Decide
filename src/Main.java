
class Main {
    double PI = 3.1415926535;
    
    public static void main (String[] args) {
        //Dummy input
        boolean[] PUV = new boolean[15];
        for(int i = 0; i < PUV.length; i++){
            if(i%2 == 0){
                PUV[i] = true;
            } 
        }
        
        System.out.println("Answer: " + DECIDE(PUV));
    }

    
    private static boolean DECIDE(boolean[] PUV){

        boolean[][] mat = new boolean[15][15];

        PUM pum = new PUM(mat);

       //2.3 "FUV[i] should be set to true if PUV[i] is false (indicating that the associated
       //LIC should not hold back launch) or if all elements in PUM row i are true"
        boolean[] FUV = {
            (pum.row(0) || !PUV[0]),
            (pum.row(1) || !PUV[1]),
            (pum.row(2) || !PUV[2]),
            (pum.row(3) || !PUV[3]),
            (pum.row(4) || !PUV[4]),
            (pum.row(5) || !PUV[5]),
            (pum.row(6) || !PUV[6]),
            (pum.row(7) || !PUV[7]),
            (pum.row(8) || !PUV[8]),
            (pum.row(9) || !PUV[9]),
            (pum.row(10) || !PUV[10]),
            (pum.row(11) || !PUV[11]),
            (pum.row(12) || !PUV[12]),
            (pum.row(13) || !PUV[13]),
            (pum.row(14) || !PUV[14]),
        };


        //2.4 LAUNCH - launch if all elements in FUV is true .

        for(boolean condition :  FUV){
            if(!condition){ 
                return false; //a condition is false - return false
            }
        }
        //all conditions are true
        return true;

    }

}
