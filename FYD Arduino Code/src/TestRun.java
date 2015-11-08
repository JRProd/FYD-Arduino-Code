import rxtxrobot.*;

public class TestRun {
	public static void main(String[] args)
	{
		RXTXRobot robot = new ArduinoNano();
		
		robot.setPort("COM3");
		robot.setVerbose(true);
		
		robot.connect();
		
		robot.runEncodedMotor(RXTXRobot.MOTOR1, 100, 100, RXTXRobot.MOTOR2, 100, 100);
		
		robot.close();
	}
}
