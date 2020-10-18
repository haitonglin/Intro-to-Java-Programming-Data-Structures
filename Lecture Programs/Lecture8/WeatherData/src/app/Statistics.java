package app;

import edu.princeton.cs.introcs.*;

public class Statistics {
	public static void main(String[] args) {
		int column = Integer.parseInt(args[0]);
		In file = args.length > 1 ? new In(args[1]) : new In(); //take the second parameter's data if it's a file name
		int count = 0;
		double sum = 0.0;
		while (file.hasNextLine()) {
			String s = file.readLine();
			String[] data = s.split(",");
			++count;
			sum += Double.parseDouble(data[column]);
		}
		System.out.println("Average: " + sum / count);
	}
}
/**
 * to run terminal:
 * command+d: finish your input
 * need to enter "1" after app.Statistic - that parameter is needed (the colomn you need)
 * in this case you can just enter file name as the second parameter 
 * 
 * you can use pipe to connect these two programs together:
 * http://tianqihoubao.com/lishi/beijing/month/201901.html | java -cp bin:lib/stdlib-package.jar app.Statistics 1
 */