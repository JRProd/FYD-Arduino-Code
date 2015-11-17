import rxtxrobot.*;

public class Conductivity {
	public static void main(String[] args)
	{
		RXTXRobot robot = new ArduinoNano();
		
		robot.setPort("COM5");
		
		robot.connect();
		
		int adc = robot.getConductivity();
		
		System.out.println(adc);

		if(adc!=0)
		{		
			double waterPerc = ((-.02765)*adc) + 30.37759;
		
			System.out.println( "% of Water = " + waterPerc);
		}
		
		robot.close();
	}
}
