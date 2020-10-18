package twospace;

public class TwoSpaceCoordinate {
	private final double first;
	private final double second;

	public TwoSpaceCoordinate(double first, double second) {
		this.first = first;
		this.second = second;
	}

	public final double getFirstCoordinate() {
		return this.first;
	}

	public final double getSecondCoordinate() {
		return this.second;
	}

	public final double magnitude() {
		return Math.sqrt(this.first * this.first + this.second * this.second);
	}
}