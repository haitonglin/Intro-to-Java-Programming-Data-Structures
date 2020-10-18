package app;

public class UniformRandomNumber {  //1.2.30
    public static void main(String[] args) throws Exception {

        double a = Math.random(); 
        double b = Math.random(); 
        double c = Math.random(); 
        double d = Math.random(); 
        double e = Math.random(); 
        System.out.println(a+" "+b+" "+c+" "+d+" "+e);
        
        System.out.println((a+b+c+d+e)/5);
        System.out.println(Math.min(Math.min(a,b),Math.min(Math.min(c,d),e)));
        System.out.println(Math.max(Math.max(a,b),Math.max(Math.max(c,d),e)));
    }
}