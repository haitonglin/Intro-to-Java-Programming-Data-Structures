package app;

public class  Statistics1 implements Statistics{
    
    private int count;
    private double sum;
    private double squaresum;


    public Statistics1(){
        count = 0;
        sum = 0;
        squaresum = 0;
    }
       

    public void addDataPoints(double num){
        count++;
        sum+=num;
        squaresum+=num*num;

    }

    public int NumberofPoints(){
        return count;
    }


    public double mean(){
        return sum/count;
    }

    public double stdeviation(){
        double mean= mean();
        return Math.sqrt(squaresum/count-mean*mean);
    }

    public double variance(){
        double StandardDeviation=stdeviation();
        return StandardDeviation*StandardDeviation;
    }

}