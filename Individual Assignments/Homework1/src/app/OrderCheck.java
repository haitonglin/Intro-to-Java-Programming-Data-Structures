package app;

public class OrderCheck { //1.2.28
    public static void main(String[] args) throws Exception {

        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);
        double z = Double.parseDouble(args[2]);

        System.out.println ( (x < y && y < z) || (x > y && y > z) );
 
    }
}