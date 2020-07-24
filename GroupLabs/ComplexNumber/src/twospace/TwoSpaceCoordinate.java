package twospace;

import nspace.NSpaceCoordinate;

public class TwoSpaceCoordinate extends NSpaceCoordinate{

	public TwoSpaceCoordinate(double first, double second) {super(new double[] {first, second});}

	public final double getFirstCoordinate() {return super.getNthCoordinate(1);}
	public final double getSecondCoordinate() {return super.getNthCoordinate(2);}
	public final double magnitude() {return super.magnitude();}

}