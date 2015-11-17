import rxtxrobot.*;

public class Point65 {

	public final RXTXRobot movement = new ArduinoNano();
	public final RXTXRobot sensors = new ArduinoNano();
	
	public final int servoArmPort = 10;
	public final int pingPort = 12;
	public final int bumpLeftPort = 3;
	public final int bumpRightPort = 1;
	public final int windPort = 7;
	public final int tempPort = 6;
	
	public double[] coords;
	
	public void run()
	{
		movement.setPort("COM6");
		sensors.setPort("COM5");
		
		movement.connect();
		sensors.connect();
		
//		sensors.refreshAnalogPins();
		
//		movement.setVerbose(true);
//		sensors.setVerbose(true);
		
		//Pre Processing 
//		sensors.attachGPS();
		movement.attachServo(RXTXRobot.SERVO1, servoArmPort);
		movement.moveServo(RXTXRobot.SERVO1, 0);
		
		movement.attachMotor(RXTXRobot.MOTOR1, 8);
		movement.attachMotor(RXTXRobot.MOTOR2, 7);
		movement.attachMotor(RXTXRobot.MOTOR3, 6);
		
//		coords = sensors.getGPSCoordinates();

//		System.out.println("Degrees latitude: " + coords[0]);
//		System.out.println("Minutes latitude: " + coords[1]);
//		System.out.println("Degrees longitude: " + coords[2]);
//		System.out.println("Minutes longitude: " + coords[3]);
		
		
//		moveInches(115);
//		turnDegrees(86);
//		moveInches(156);
//		turnDegrees(90);
//		moveInches(72);
//		turnDegrees(-90);
//		moveInches(15);
//		turnDegrees(179);
//		turnDegrees(86);
//		turnDegrees(86);
		
//		boomLift();	//GOOD
		
		System.out.println(sensors.getAnalogPin(0).getValue());	//Right Bump
		System.out.println(sensors.getAnalogPin(1).getValue());	//
		
		getTemperature();
		
//		getConductivity(); GOOD ISH
		
		sensors.close();
		movement.close();
	}
	
	public void moveInches(int inches)
	{
		System.out.println("Moving Robot " +inches + "\"");
		int dist = (int)Math.round(15.14666*inches - 19.8036);
		movement.runEncodedMotor(RXTXRobot.MOTOR1, 150, dist, RXTXRobot.MOTOR2, 176, dist);
	}
	
	public void turnDegrees(int degrees)
	{
		System.out.println("Turning Robot " +degrees + " degrees.");
		double inches = degrees*(29.76/90);	
		int dist = (int)Math.round(15.14666*inches - 19.8036);
		if(degrees<0)
		{
			System.out.println("Running Motor 1 " + Math.abs(dist) + " ticks");
			movement.runEncodedMotor(RXTXRobot.MOTOR1, 150, Math.abs(dist));
		}
		if(degrees>0)
		{
			System.out.println("Running Motor 1 " + dist + " ticks");
			movement.runEncodedMotor(RXTXRobot.MOTOR2, 175, dist);
		}
	}
	
	public void boomLift()
	{
		movement.runMotor(RXTXRobot.MOTOR3, 90, 1500);
		
		movement.sleep(150);
		
		movement.runMotor(RXTXRobot.MOTOR3, 115, 4700);
		
		getTemperature();
		
		movement.runMotor(RXTXRobot.MOTOR3, -125, 2500);
	}
	
	public void getTemperature()
	{
		/*
		double thermistorReading = getThermistorReading(3);
		
		sensors.sleep(100);
		
		double anomonitorReading = getThermistorReading(2);
		
		System.out.printf("The Thermistor read the value: %.02f\n" , thermistorReading);
		System.out.printf("In volts: %.2f\n",(thermistorReading * (5.0/1023.0)));
		double tempWind = (thermistorReading - 701.1946) / (-4.65405);
		System.out.printf("In celcius: %.2fC\n", tempWind);
		
		System.out.printf("The Anomomintor read the value: %.02f\n" , anomonitorReading);
		System.out.printf("In volts: %.2f\n",(anomonitorReading * (5.0/1023.0)));
		double temp = (anomonitorReading - 701.1946) / (-4.65405);
		System.out.printf("In celcius: %.2fC\n", temp);
		*/
		
		Thread temp = new Thread(){
			public void run()
			{
				double thermistorReading = getThermistorReading(3);
				System.out.printf("The Thermistor read the value: %.02f\n" , thermistorReading);
				System.out.printf("In volts: %.2f\n",(thermistorReading * (5.0/1023.0)));
				double tempWind = (thermistorReading - 701.1946) / (-4.65405);
				System.out.printf("In celcius: %.2fC\n", tempWind);
			}
		};
		
		Thread anon = new Thread(){
			public void run()
			{
				double anomonitorReading = getThermistorReading(2);
				System.out.printf("The Anomomintor read the value: %.02f\n" , anomonitorReading);
				System.out.printf("In volts: %.2f\n",(anomonitorReading * (5.0/1023.0)));
				double temp = (anomonitorReading - 701.1946) / (-4.65405);
				System.out.printf("In celcius: %.2fC\n", temp);
			}
		};
		
		temp.run();
		sensors.sleep(5000);
		anon.run();
	}
	
	public void getConductivity()
	{
		movement.moveServo(RXTXRobot.SERVO1, 95);
		int adc = sensors.getConductivity();
		System.out.println(adc);
		movement.moveServo(RXTXRobot.SERVO1, 25);
	}
	
	private double getThermistorReading(int port)
	{
		int sum = 0;
		int readingCount = 10;
		
		for(int i = 0; i < readingCount; i++)
		{
			sensors.refreshAnalogPins();
			int reading = sensors.getAnalogPin(port).getValue();
			System.out.println("Reading: " + i+1 + " ACD = " + reading);
			sum+=reading;
		}
		
		return (double)sum / readingCount;
	}
	
	public static void main(String[] args)
	{
		System.out.println("**********RUNNING PROGRAM POINT65.JAVA**********");
		Point65 run = new Point65();
		run.run();
	}
}
