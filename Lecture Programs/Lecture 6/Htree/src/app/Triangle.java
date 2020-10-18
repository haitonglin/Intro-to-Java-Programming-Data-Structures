package app;

import edu.princeton.cs.introcs.*;

public class Triangle {

    // plot an triangle, centered on (x, y) of the given side length
    public static void sierpinski(double x, double y, double size) {

        // compute the coordinates of the 3 tips of triangle
        double x0 = x;
        double y0 = y;

        double x1 = x0 + size;
        double y1 = y0;
        double x2 = x0 + size / 2;
        double y2 = y0 + (Math.sqrt(3)) * size / 2;

        // draw the 3 line segments of triangle
        StdDraw.line(x0, y0, x1, y1);
        StdDraw.line(x0, y0, x2, y2);
        StdDraw.line(x1, y1, x2, y2);
    }

    // plot an order n triangle, centered on (x, y) of the given side length
    public static void draw(int n, double x, double y, double size) {
        if (n == 0) return;
        sierpinski(x, y, size);

        double x0 = x;
        double y0 = y;

        double x1 = x0 + size;
        double y1 = y0;
        double x2 = x0 + size / 2;
        double y2 = y0 + (Math.sqrt(3)) * size / 2;

        //recursive calls
        draw(n-1, x0, y0, size / 2);
        draw(n-1,(x0 + x1) / 2, (y0 + y1) / 2, size / 2);
        draw(n-1,(x0 + x2) / 2, (y0 + y2) / 2, size / 2);
    }

    // reads an integer command-line argument n and plots an order n triangle
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double x = 0.5, y = 0.5;   
        double size = 0.5;   // side length 
        draw(n, x, y, size);
    }
}
