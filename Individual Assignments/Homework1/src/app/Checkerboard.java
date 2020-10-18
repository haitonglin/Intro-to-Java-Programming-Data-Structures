package app;

public class Checkerboard { //1.3.29
    public static void main(String[] args) throws Exception 
    {
        int n = Integer.parseInt(args[0]);
        for (int i = 1; i <= n; i++) 
        {
            for (int j = 1; j <= n; j++)
            {
                if ((i%2==0 && j%2==0) || (i%2==1 && j%2==1)) System.out.print("*");
                if ((i%2==0 && j%2==1) || (i%2==1 && j%2==0)) System.out.print("  ");
            }  
            System.out.println("");
        }
    }
}