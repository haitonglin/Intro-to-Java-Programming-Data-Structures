package app;

public class Statistics2 implements Statistics{
    private double[] realnumbers;

    public Statistics2(){
        this.realnumbers = new double[0];
    }

    public void addDataPoints(double a){
        double[] newarray = new double[this.realnumbers.length+1];
        newarray[this.realnumbers.length] = a;
        for (int i = 0; i < this.realnumbers.length; i++){
            newarray[i] = this.realnumbers[i];
        }
        this.realnumbers = newarray;
    }

    public int NumberofPoints(){
        return this.realnumbers.length;
    }

    public double mean(){
        double sum = 0;
        for (int i = 0; i < this.realnumbers.length; i++){
            sum += this.realnumbers[i];
        }
        return sum/this.realnumbers.length;
    }

    public double stdeviation(){
        return Math.sqrt(this.variance());
    }

    public double variance(){
        double n = this.mean();
        double sum=  0;
        for (int i = 0; i < this.realnumbers.length; i++){
            sum += (this.realnumbers[i] - n) * (this.realnumbers[i] - n);
        }
        return sum/this.realnumbers.length;
    }

}