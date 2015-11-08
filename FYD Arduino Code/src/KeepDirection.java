
public class KeepDirection {
	
	public static void main(String[] args)
	{
		
	}
}

class Coordinate
{
	
	private double xCoordDeg;
	private double xCoordMin;
	private double yCoordDeg;
	private double yCoordMin;
	
	public Coordinate()
	{
		setXCoord(0,0);
		setYCoord(0,0);
	}
	public Coordinate(double xD, double xM, double yD, double yM)
	{
		setXCoord(xD,xM);
		setYCoord(yD,yM);
	}
	public Coordinate(double[] coords)
	{
		setXCoord(coords[0],coords[1]);
		setYCoord(coords[2],coords[3]);
	}
	
	private void setXCoord(double xD, double xM)
	{
		xCoordDeg = xD;
		xCoordMin = xM;
	}
	
	private void setYCoord(double yD, double yM)
	{
		yCoordDeg = yD;
		yCoordMin = yM;
	}
	
	private double getXCoord() {
		double xCoord = xCoordDeg + (xCoordMin/60);
		return xCoord;
	}
	
	private double getYCoord() {
		double yCoord = yCoordDeg + (yCoordMin/60);
		return yCoord;
	}
}
