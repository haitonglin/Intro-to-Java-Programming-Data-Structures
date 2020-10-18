package app;


public class SideEffect {
	public static double square(double a){
		System.out.println("hsjfgbdshb");
		return Math.sqrt(a);
	}
	public static void main(String[] args) {
		//double x = square(2);
		System.out.println(square(2));
		System.out.println(square(2));
		System.out.println(square(2));
	}
}