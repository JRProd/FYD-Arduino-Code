import java.util.Scanner;

import rxtxrobot.ArduinoNano;
import rxtxrobot.RXTXRobot;

public class ReadDistance
{
	public static void main(String[] args)
	{
		RXTXRobot robot = new ArduinoNano();

		robot.setPort("COM3");
//		robot.setVerbose(true);

		robot.connect();

		// CODE FOR DELIVERABLE\\
		final int PING_PORT = 13;
		

		System.out.println("Starting Measurement.");
		for (int x = 0; x < 2; x++)
		{
			Scanner cin = new Scanner(System.in);
			int total = 0;
			double average = 0.0;
			double toInches = 0.0;
			System.out.println("Getting Measurement");
			for (int y = 0; y < 10; y++)
			{
				int temp = robot.getPing(PING_PORT);
				total += temp;
				System.out.println("Response: " + temp + "cm" + " Total is:" + total);
				robot.sleep(10);
			}
			average = total / 10.0;
			toInches = average * .393701;
			System.out.printf("The Distance is :: %.2fcm\n", average);
			System.out.printf("The Distance is :: %.2fin\n", toInches);
			if (x == 0)
			{
				System.out.println("Press enter to get next value.");
				cin.nextLine();
			}
		}

		// END CODE\\

		robot.close();
	}
}
