package app;

public class Test {
	public static void main(String[] args) {
		Complex a = new StandardComplex(1, 1);
		Complex b = new PolarComplex(Math.sqrt(2), Math.PI / 4);
		System.out.println(b.minus(a));

		Complex a2 = new StandardComplex(-1, -1);
		Complex b2 = new PolarComplex(Math.sqrt(2), Math.PI / 4);
		System.out.println(a2.plus(b2));
	}
}