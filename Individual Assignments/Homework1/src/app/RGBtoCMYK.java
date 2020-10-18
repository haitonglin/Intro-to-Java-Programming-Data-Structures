package app;

public class RGBtoCMYK {  //1.2.32
    public static void main(String[] args) throws Exception {
        
        int r = Integer.parseInt(args[0]);
        int g = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);

        if (r == 0 && g == 0 && b == 0) {System.out.println("c=0 m=0 y=0 k=1");}
        else {double w = Math.max (Math.max((double)r / 255, (double)g / 255), (double)b / 255);
              double c = (w - ( (double)r / 255)) / w;
              double m = (w - ( (double)g / 255)) / w;
              double y = (w - ( (double)b / 255)) / w;
              double k = 1 - w; 
              System.out.println(c+" "+m+" "+y+" "+k);}
    }
}