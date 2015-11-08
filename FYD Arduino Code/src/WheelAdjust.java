import rxtxrobot.ArduinoNano;
import rxtxrobot.RXTXRobot;

public class WheelAdjust
{
	public static void main(String[] args)
	{
		RXTXRobot robot = new ArduinoNano();
		
		robot.setPort("COM3");
		robot.setVerbose(true);
		
		robot.connect();
		
		//CODE FOR DELIVERABLE\\
		int dist = 2000;	//EDIT FOR THREE METERS
		
		
		robot.runEncodedMotor(RXTXRobot.MOTOR1, 255, dist, RXTXRobot.MOTOR2, 255, dist);

		
		robot.close();
	}
}
