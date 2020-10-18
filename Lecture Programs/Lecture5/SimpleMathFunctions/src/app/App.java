package app;

public class App {
    public static double hypotenuse(double a, double b) {
        return Math.sqrt(square(a) + square(b)); //since square and this is also in the same class (App)
    }

    public static double square(double x) {
        return x * x;
    }

    public static void main(String[] args) {
        System.out.println("10 squared is " + square(10.0));
        System.out.println("a right-angle triangle with perpendicular sides 10 and 3.5 has a hypotenuse of length " + hypotenuse(10, 3.5));
    }

    public static int main(int x, int y) {
        return x + y;
    }
}