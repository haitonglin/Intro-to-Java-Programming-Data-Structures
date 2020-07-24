package nspace;

import java.util.ArrayList;

public class NSpaceCoordinate implements Comparable<NSpaceCoordinate>{
    //1.the single private field
    private ArrayList<Double> a;

    //2. constructor
    public NSpaceCoordinate(double[] b){
        a = new ArrayList<Double>();
        for (int i = 0; i < b.length; i++){
            this.a.add(b[i]);
        }
    }

    //3. method (Nth is 1-based)
    public double getNthCoordinate(int c){
        return this.a.get(c-1);
    }

    //4. overriding compareTo method
    public int compareTo(NSpaceCoordinate f){
        for (int i = 0; i < this.a.size() && i < f.a.size(); i++) {
            double x = this.a.get(i);
            double y = f.a.get(i);
            if (x < y) {return -1;}
            if (x > y) {return 1;}
        }
        return this.a.size()-f.a.size();
    }

    //5. magnitude and toString
    public double magnitude(){
        double sum = 0;
        for (int i = 0; i < this.a.size(); i++){
            sum += a.get(i) * a.get(i);
        }

        return Math.sqrt(sum);
    }

    public String toString(){
        String e = "(";
        for (int i = 0; i < this.a.size()-1; i++){
            e = e + a.get(i) + ",";
        }
        e = e + a.get(this.a.size()-1)+")";
        return e;
    }

    //Test client
    public static void main(String[] args) throws Exception {
        NSpaceCoordinate test = new NSpaceCoordinate(new double[] {2,1});
        NSpaceCoordinate comp = new NSpaceCoordinate(new double[] {2,1,2});
        System.out.println(test.getNthCoordinate(1));
        System.out.println(test.magnitude());
        System.out.println(test.toString());
        System.out.println(test.compareTo(comp));
    }
}