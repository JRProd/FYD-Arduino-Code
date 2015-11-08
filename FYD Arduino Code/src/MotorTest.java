import rxtxrobot.*;
public class MotorTest {
	public static void main(String[] args)
	{
		RXTXRobot robot = new ArduinoNano();
		robot.setPort("COM3");
		robot.connect();
		
		robot.runMotor(RXTXRobot.MOTOR1, 100, RXTXRobot.MOTOR2, -100, 5000);
		robot.runMotor(RXTXRobot.MOTOR1, 0, RXTXRobot.MOTOR2, 0, 100);
		
		robot.close();
	}
}
