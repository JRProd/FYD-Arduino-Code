import java.util.Scanner;

public class GetAngle {
	public static void main(String[] args){
		double a1,a2;
		double b1,b2;
		
		Scanner cin = new Scanner(System.in);
		//cin.useDelimiter("\\(|,|\\)");
		do
		{
			System.out.print("Enter the first coord :: ");
			a1 = cin.nextDouble();
			a2 = cin.nextDouble();
			
			
			System.out.print("Enter the second coord :: ");
			
			b1 = cin.nextDouble();
			b2 = cin.nextDouble();
			
			
			Coordinate c1,c2;
			
			System.out.print("Enter the first coord :: ");
			c1 = new Coordinate(cin.nextDouble(),cin.nextDouble(),cin.nextDouble(),cin.nextDouble());
			
			System.out.print("Enter the second coord :: ");
			c2 = new Coordinate(cin.nextDouble(),cin.nextDouble(),cin.nextDouble(),cin.nextDouble());
			
			
			int angle = getAngle(a1,a2,b1,b2);
			
			int angleC1 = getAngle(c1,c2);
			System.out.println();
		}while(true);
	}
	
	private static int getAngle(double a1, double a2, double b1, double b2)
	{
		int angle = 0;
		double dist1 =0;
		double dist2 = 0;
		double hypo = 0;
		
		dist1 = b1-a1;
		dist2 = b2-a2;
		
		hypo = Math.sqrt(Math.pow(b1-a1, 2)+Math.pow(b2-a2, 2));

		double test = Math.toDegrees(Math.asin(((double)dist2)/hypo));
		
		System.out.println(test);
		
		angle = (int) Math.round(test);
		
		System.out.println("Dist1 :: " + dist1 + " Dist2 :: " + dist2 + " Hypo :: " + hypo + " Angle :: " + angle);
		
		return angle;
	}
	
	private static int getAngle(Coordinate coord1, Coordinate coord2)
	{
		double a1 = coord1.getXCoord();
		double a2 = coord1.getYCoord();
		double b1 = coord2.getXCoord();
		double b2 = coord2.getYCoord();
		int angle = 0;
		double dist1 =0;
		double dist2 = 0;
		double hypo = 0;
		
		dist1 = b1-a1;
		dist2 = b2-a2;
		
		hypo = Math.sqrt(Math.pow(b1-a1, 2)+Math.pow(b2-a2, 2));

		double test = Math.toDegrees(Math.asin(((double)dist2)/hypo));
		
		System.out.println(test);
		
		angle = (int) Math.round(test);
		
		System.out.println("Dist1 :: " + dist1 + " Dist2 :: " + dist2 + " Hypo :: " + hypo + " Angle :: " + angle);
		
		return angle;
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
	
	public void setXCoord(double xD, double xM)
	{
		xCoordDeg = xD;
		xCoordMin = xM;
	}
	
	public void setYCoord(double yD, double yM)
	{
		yCoordDeg = yD;
		yCoordMin = yM;
	}
	
	public double getXCoord() {
		double xCoord = xCoordDeg + (xCoordMin/60);
		return xCoord;
	}
	
	public double getYCoord() {
		double yCoord = yCoordDeg + (yCoordMin/60);
		return yCoord;
	}
}
