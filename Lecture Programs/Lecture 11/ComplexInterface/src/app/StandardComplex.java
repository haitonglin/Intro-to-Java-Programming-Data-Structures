package app;

public class StandardComplex implements Complex {
	private final double re;   // the real part
	private final double im;   // the imaginary part

	// create a new object with the given real and imaginary parts
	public StandardComplex(double real, double imag) {
		re = real;
		im = imag;
	}

	// return a string representation of the invoking Complex object
	public String toString() {
		if (im == 0) return this.re + "";
		if (re == 0) return this.im + "i";
		if (im <  0) return this.re + " - " + (-im) + "i";
		return re + " + " + im + "i";
	}

	// return abs/modulus/magnitude
	public double abs() {
		return Math.hypot(this.re, im);
	}

	public double r() {
		return abs();
	}

	public double th() {
		return Math.atan2(im, re);
	}

	// return a new Complex object whose value is (this + b)
	public Complex plus(Complex b) {
		double real = re + b.re();
		double imag = this.im + b.im();
		return new StandardComplex(real, imag);
	}

	// return a new Complex object whose value is (this - b)
	public Complex minus(Complex b) {
		Complex a = this;
		double real = a.re() - b.re();
		double imag = a.im() - b.im();
		return new StandardComplex(real, imag);
	}

	// return a new Complex object whose value is (this * b)
	public Complex times(Complex b) {
		Complex a = this;
		double real = a.re() * b.re() - a.im() * b.im();
		double imag = a.re() * b.im() + a.im() * b.re();
		return new StandardComplex(real, imag);
	}

	// return the real or imaginary part
	public double re() { return re; }
	public double im() { return im; }

	public boolean equals(Object x) {
		if (x == null || !(x instanceof Complex)) return false;
		Complex that = (Complex) x;
		return (this.re == that.re()) && (this.im == that.im());
	}
}