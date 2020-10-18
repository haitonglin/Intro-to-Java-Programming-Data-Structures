package app;

public class Point {

    private final double x, y;

    public Point(double x0, double y0)
    { x = x0; y = y0;}

    public double distanceTo(Point q)
    { return Math.sqrt((x-q.x)*(x-q.x) + (y-q.y)*(y-q.y));}

    public String toString()
    { return "("+ x + "," + y + ")"; }

    public static void main(String[] args) throws Exception {
        Point x = new Point(Double.parseDouble(args[0]), Double.parseDouble(args[1]));
        Point y = new Point(Double.parseDouble(args[2]), Double.parseDouble(args[3]));
        System.out.println("Distance from " + x + " to " + y + " is " + x.distanceTo(y));
    }
}