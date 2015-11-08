import java.util.Scanner;

import rxtxrobot.ArduinoNano;
import rxtxrobot.RXTXRobot;

public class ServoMovement
{
	public static void main(String[] args)
	{
		RXTXRobot robot = new ArduinoNano();
		
		robot.setPort("COM3");
		robot.setVerbose(true);
		
		robot.connect();
		
		//CODE FOR DELIVERABLE\\
		Scanner cin = new Scanner(System.in);	
		System.out.print("Enter the angle :: ");
		
		int angle = cin.nextInt();	//EDIT FOR THREE METERS
		
		robot.attachServo(RXTXRobot.SERVO1, 4);
		robot.moveServo(RXTXRobot.SERVO1, angle);
		
		robot.sleep(1000);
		
		//END CODE\\
		
		robot.close();
	}
}
