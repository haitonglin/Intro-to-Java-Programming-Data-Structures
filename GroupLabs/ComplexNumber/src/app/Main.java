package app;

import java.util.ArrayList;
import java.util.Collections;

import twospace.StandardComplex;

public class Main{

    public static void main(String[] args) throws Exception {
       StandardComplex a = new StandardComplex(Double.parseDouble(args[0]), Double.parseDouble(args[1]));
       StandardComplex b = new StandardComplex(Double.parseDouble(args[2]), Double.parseDouble(args[3]));
       StandardComplex c = new StandardComplex(Double.parseDouble(args[4]), Double.parseDouble(args[5]));

       ArrayList<StandardComplex> test = new ArrayList<>();
       test.add(a); test.add(b); test.add(c);

       Collections.sort(test);

       for (int i = 0; i < test.size(); i++){
           System.out.println(test.get(i)+","+test.get(i).abs());
       }
    }

}