import rxtxrobot.AnalogPin;
import rxtxrobot.ArduinoNano;
import rxtxrobot.RXTXRobot;

public class TempSensor
{
	public static void main(String[] args)
	{
		RXTXRobot robot = new ArduinoNano();
		
		robot.setPort("COM5");
//		robot.setVerbose(true);
		
		robot.connect();
		
		//CODE FOR DELIVERABLE\\
		
		double thermistorReading = getThermistorReading(robot,0);
		
		double anomonitorReading = getThermistorReading(robot,2);
		
		System.out.printf("The thermistor probe read the value: %.02f\n" , thermistorReading);
		System.out.printf("In volts: %.2f\n",(thermistorReading * (5.0/1023.0)));
		double temp = (thermistorReading - 919.55) / (-10.182);
		System.out.printf("In celcius: %.2fC\n\n", temp);
		
		robot.sleep(1000);
		
		System.out.printf("The anomonitor probe read the value: %.02f\n" , anomonitorReading);
		System.out.printf("In volts: %.2f\n",(anomonitorReading * (5.0/1023.0)));
		double tempWind = (anomonitorReading - 919.55) / (-10.182);
		System.out.printf("In celcius: %.2fC\n", tempWind);
		
		//END CODE\\
		
		robot.close();
	}
	
	public static double getThermistorReading(RXTXRobot robot, int port)
	{
		int sum = 0;
		int readingCount = 10;
		
		for(int i = 0; i < readingCount; i++)
		{
			robot.refreshAnalogPins();
			int reading = robot.getAnalogPin(port).getValue();
			sum+=reading;
		}
		
		return (double)sum / readingCount;
	}
}
