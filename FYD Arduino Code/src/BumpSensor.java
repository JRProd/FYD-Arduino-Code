import rxtxrobot.AnalogPin;
import rxtxrobot.ArduinoNano;
import rxtxrobot.RXTXRobot;

public class BumpSensor
{
	public static void main(String[] args)
	{
		RXTXRobot robot = new ArduinoNano();
		
		robot.setPort("COM3");
		robot.setVerbose(true);
		
		robot.connect();
		
		//CODE FOR DELIVERABLE\\
		robot.refreshAnalogPins();
		
		AnalogPin temp = robot.getAnalogPin(0);
		System.out.println(temp.getValue());
		
		while(temp.getValue()<=0)
		{
			robot.runMotor(RXTXRobot.MOTOR1, 255, RXTXRobot.MOTOR2, 255, 0);
			robot.refreshAnalogPins();
			temp = robot.getAnalogPin(0);
			System.out.println(temp.getValue());
		}
		
		robot.runMotor(RXTXRobot.MOTOR1, 0, RXTXRobot.MOTOR2, 0, 0);
		
		//END CODE\\
		
		robot.close();
	}
}
