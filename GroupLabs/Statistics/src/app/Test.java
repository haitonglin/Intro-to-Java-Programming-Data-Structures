package app;

public class Test {
    public static void main(String[] args) throws Exception {
        Statistics[] twoStatsObjects = new Statistics[] { new Statistics1(), new Statistics2() };
        for (int i = 0; i < twoStatsObjects.length; i++) {
            Statistics s = twoStatsObjects[i];
            System.out.println("Demonstrating statistics object #" + (i + 1));

            s.addDataPoints(1.0);
            s.addDataPoints(2.0);
            s.addDataPoints(3.0);
            s.addDataPoints(4.0);
            s.addDataPoints(5.0);

            System.out.println("Number of points in statistics object #" + (i + 1) + " is " + s.NumberofPoints());
            System.out.println("Mean value of statistics object #" + (i + 1) + " is " + s.mean());
            System.out.println("Standard deviation of statistics object #" + (i + 1) + " is " + s.stdeviation());
            System.out.println("Variance of statistics object #" + (i + 1) + " is " + s.variance());
            System.out.println("");

        }
    }
}