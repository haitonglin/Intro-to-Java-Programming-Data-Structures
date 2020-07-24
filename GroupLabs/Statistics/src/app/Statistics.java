package app;

public interface Statistics{
    
    public void addDataPoints(double a);

    public int NumberofPoints();
    public double mean();
    public double stdeviation();
    public double variance();
}