import rxtxrobot.*;

public class MainController {
	
	public static final RXTXRobot movement = new ArduinoNano();
	public static final RXTXRobot sensors = new ArduinoNano();
	
	public static final int servoArmPort = 10;
	public static final int pingPort = 12;
	public static final int bumpLeftPort = 3;
	public static final int bumpRightPort = 1;
	public static final int windPort = 7;
	public static final int tempPort = 6;
	
	public static double[] coords;
	
	/* 1. robot starts up
	 * 	-we know that the robot is in x sector therefore we've got the degrees already
	 *   oriented prior to startup.
	 *   -print gps coordinates
	 * 2. move forward *10 meters* to the charging location
	 * 3. wait 5s to fulfill requirement
	 * 4. start while loop (while conductivity&&air)
	 * 		1. locate nearest objective relative to current location
	 * 		2. turn to face objective
	 * 		3. move towards objective
	 * 		*** at any time during translocation may initiate evasive function
	 * 		4. reach location
	 * 		5. do objective 
	 * 		6. objective = !objective
	 * 5. exit loop
	 * 6. 
	 * 
	 * 
	 */
	
	public static void main(String[] args) {
		
		
		boolean conductivity = false;  //boolean variables to signal when task = completed
		boolean air = false;
		boolean charged = false;
		
		movement.setPort("COM5");
//		movement.setVerbose(true);
		sensors.setPort("COM6");
// 		sensors.setVerbose(true);
		
		movement.connect();
		sensors.connect();
		
		//Pre Processing 
		sensors.attachGPS();
		movement.attachServo(RXTXRobot.SERVO1, servoArmPort);
//		movement.moveServo(RXTXRobot.SERVO1, 10);
		
		movement.attachMotor(RXTXRobot.MOTOR1, 7);
		movement.attachMotor(RXTXRobot.MOTOR2, 6);
		movement.attachMotor(RXTXRobot.MOTOR3, 8);
		
		AnalogPin rightBump = sensors.getAnalogPin(bumpRightPort);
		AnalogPin leftBump = sensors.getAnalogPin(bumpLeftPort);
		
		System.out.println(rightBump.getValue() + " " + leftBump.getValue());
		

		movement.refreshAnalogPins();
		movement.refreshDigitalPins();
		sensors.refreshAnalogPins();
		sensors.refreshDigitalPins();

		//Begin Scoring\\
		coords = sensors.getGPSCoordinates();
	
		if(coords[0]==-1 || coords[1]==-1 || coords[2]==-1 || coords[3] == -1)
		{
			System.out.println("Sleeping for GPS Coords");
			sensors.sleep(1000);
		}
		coords = sensors.getGPSCoordinates();

		System.out.println("Degrees latitude: " + coords[0]);
		System.out.println("Minutes latitude: " + coords[1]);
		System.out.println("Degrees longitude: " + coords[2]);
		System.out.println("Minutes longitude: " + coords[3]);
		
		//Begin Movement
//		while(!(conductivity&&air&&charged))
		{
//			double pingValue = getPingReading();
//			while(pingValue > 5)
			{
				sensors.refreshAnalogPins();
				System.out.println("Move Motors " + rightBump.getValue() + " " + leftBump.getValue());
				
//				movement.runMotor(RXTXRobot.MOTOR3, 255, 10000);
				
				rightBump = sensors.getAnalogPin(bumpRightPort);
				leftBump = sensors.getAnalogPin(bumpLeftPort);
				
//				if(rightBump.getValue()<=900&&leftBump.getValue()<=900)
				//	movement.runEncodedMotor(RXTXRobot.MOTOR1, 150, 2000, RXTXRobot.MOTOR2, 150, 2000);
			
				
				
//	 				sensors.sleep(10);
				
//				pingValue = getPingReading();
				
			}
			movement.runMotor(RXTXRobot.MOTOR3, 50, 500);
			
			movement.sleep(150);
			
			movement.runMotor(RXTXRobot.MOTOR3, 125, 4000);
			movement.runMotor(RXTXRobot.MOTOR3, -125, 2250);
		}
		
		

		//Post Processing
		sensors.close();
        movement.close();
        System.out.println("Closed");
	}
	
	public static double getPingReading()
	{
		int total = 0;
		double average = 0.0;
		System.out.println("Getting Measurement");
		for (int y = 0; y < 5; y++)
		{
			int temp = movement.getPing(pingPort);
			total += temp;

		}
		average = total / 10.0;
		System.out.printf("The Distance is :: %.2fcm\n", average);
		return average;
	}
	
	public static int getConductivity()
	{
		
		return sensors.getConductivity();
	}
	//Note: Collision not implemented yet.
			/*while(!conductivity && !air)
			 * 	while(!collision)
			 * 		move robot step-by-step and check for collision each time
			 * 
			 */
	
	//Note: Most method names are pseudocode. Replace with actual methods later.
			/*while(!conductivity && !air) {
			 * currentloc = getCurrentLocation();
			 * if(!conductivity && !air) {
			 *	 if(currentloc.getDistance(airloc) < currentloc.getDistance(conductivityloc) {
			 * 		rotate(xDegrees);
			 * 		moveTo(airloc);
			 * 		conductivityMethods();
			 * 		air = !air;
			 *	 }
			 * 	 else {
			 * 		rotate(xDegrees);
			 * 		moveTo(conductivityloc);
			 * 	 }
			 *  }
			 *  else if(!conductivity && air) {
			 *  	rotate(xDegrees);
			 *  	moveTo(conductivityloc);
			 *  	conductivityMethods();
			 *  	conductivity = !conductivity;
			 *   }
			 *  else if(conductivity && !air) {
			 *  	rotate(xDegrees);
			 *  	moveTo(airloc);
			 *  	airMethods();
			 *  	air = !air;
			 *  }
			 *  else {
			 *  	System.out.println("Finished.");
			 *  }
			 *  }
			 * 
			 */
}
