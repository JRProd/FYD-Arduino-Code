import rxtxrobot.*;

public class Move3Meters
{
	public static void main(String[] args)
	{
		RXTXRobot robot = new ArduinoNano();
		
		robot.setPort("COM3");
		robot.setVerbose(true);
		
		robot.connect();
		
		//CODE FOR DELIVERABLE\\
		int dist = 1700;	//EDIT FOR THREE METERS
		
		robot.runEncodedMotor(RXTXRobot.MOTOR1, 255, (dist+35), RXTXRobot.MOTOR2, 255, dist);
		
//		robot.runEncodedMotor(RXTXRobot.MOTOR1, -255, 390, RXTXRobot.MOTOR2, 200, 382);
//		robot.runEncodedMotor(RXTXRobot.MOTOR1, 255, dist, RXTXRobot.MOTOR2, 200, dist);
		
		//END CODE\\
		
		robot.close();
	}
}
