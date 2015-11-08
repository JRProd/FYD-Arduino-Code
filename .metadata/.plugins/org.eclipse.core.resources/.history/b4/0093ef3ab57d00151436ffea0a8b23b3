/*import rxtxrobot.*;

public class UseGPS {
	public static void main(String[] args)
	{
		RXTXRobot robot = new ArduinoNano();
		robot.setPort("COM3");
		
		robot.connect();
		
		robot.attachGPS();
		
		double coords[] = robot.getGPSCoordinates();
		
		for(int x = 0; x < 4; x++)
		{
			System.out.println(x + " " + coords[x]);
		}
		
		robot.close();
	}
}*/

import rxtxrobot.*;

public class UseGPS
{
	public static void main(String[] args)
	{
		RXTXRobot robot = new ArduinoNano();
		robot.setPort("COM3");
		
		robot.connect();
		
		robot.attachGPS();

		double[] coordinates = robot.getGPSCoordinates();


		System.out.println("Degrees latitude: " + coordinates[0]);
		System.out.println("Minutes latitude: " + coordinates[1]);
		System.out.println("Degrees longitude: " + coordinates[2]);
		System.out.println("Minutes longitude: " + coordinates[3]);
		
		robot.close();
	}
}
