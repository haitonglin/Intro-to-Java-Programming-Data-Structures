package app;

import edu.princeton.cs.introcs.*; 

public class MultiplyMatrices {

	//the function to read matrix
    public static double[][] inputMatrix(){
    int a = (int) StdIn.readDouble();
	int b = (int) StdIn.readDouble();
	double[][] m = new double [a][b];
    for (int i = 0; i < a; i++){
        for (int j = 0; j < b; j++)
        m[i][j] = StdIn.readDouble();
    }return m;
}	   
	//The function to multiply matrix
	public static void main(String[] args) {
		double[][] c = inputMatrix();
		double[][] d = inputMatrix();
		double[][] f = new double [c.length][d[0].length];
		if (c[0].length!=d.length) StdOut.println("ERROR");
		else {
		for (int i = 0; i < c.length; i++){
   			for (int j = 0; j < d[0].length; j++){
      			for (int k = 0; k < d.length; k++)
					 f[i][j] += c[i][k]*d[k][j];
			    } 
			}
		for (int g = 0; g < f.length; g++){
			for (int h = 0; h < f[0].length; h++){
				StdOut.print(f[g][h]+" ");
					}
				StdOut.println();
			}
		} 	
	}
} 