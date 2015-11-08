import rxtxrobot.*;

public class MainController {
	
	public final int servoArmPort = 4;
	public final int pingPort = 9;
	public final int bumpLeftPort = 2;
	public final int windPort = 7;
	public final int tempPort = 6;
	
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
		
		RXTXRobot movement = new ArduinoNano();
//		movement.setPort("COM3");
//		movement.setVerbose(true);
		
		RXTXRobot sensors = new ArduinoNano();
		sensors.setPort("COM3");
		
//		movement.connect();
		sensors.connect();
	
		int adcConductivity = sensors.getConductivity();
		
		System.out.println(adcConductivity);
		
		sensors.close();
//        movement.close();	
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
