

//*****************************//
//           TIMER             //
//_____________________________//
//                             //
//  Practical a specially  for //
//  Studying  or schedule time //  
//  while using my computer    //
//                             //
//_____________________________//
//*****************************//

import java.awt.Toolkit;
import javax.swing.JOptionPane;


public class Stopwatch {
	private static String MyEvent;
	private static String TimeUnit;
	private static int Mytime;
	private static int Sleeping_time;
	private static boolean running=true;
	/**
	 * set: the event we want to schedule 
	 *  how match time(second,minute,hour)
	 * @param String answer: 'yes'- continues 'no'- stop
	 * @throws InterruptedException
	 */
	private static void Set_Timer(String answer) throws InterruptedException {
		if(answer.equalsIgnoreCase("yes")) {
			MyEvent= MyConsole.readString("Please set your event:");
			do {
			TimeUnit= MyConsole.readString("Enter your time unit (Hour,Minute,Second)");
			if(!TimeUnit.equalsIgnoreCase("minute")&&!TimeUnit.equalsIgnoreCase("second")&&!TimeUnit.equalsIgnoreCase("hour"))
				System.out.println("invalid input");
			}
			while(!TimeUnit.equalsIgnoreCase("minute")&&!TimeUnit.equalsIgnoreCase("second")&&!TimeUnit.equalsIgnoreCase("hour"));
			Mytime=MyConsole.readInt("Please set your time(Integer):");
			SetTime();
			//just for fun
			for (int i = 0; i <3; i++) {
				System.out.print(" . ");
				Thread.sleep(700);
			}
			System.out.println("\nlet's start");
		}
	}
	
	//adjust the value time to milliseconds 
	private static void SetTime() {
		if(TimeUnit.equalsIgnoreCase("hour"))
			Sleeping_time=Mytime*1000*60*60;
		else if(TimeUnit.equalsIgnoreCase("minute"))
			Sleeping_time=Mytime*1000*60;
		else if(TimeUnit.equalsIgnoreCase("second"))
			Sleeping_time=Mytime*1000;
		//it wont wait! 
		else {
			System.out.println("invalid input please try again");
			Sleeping_time=0;
		}
	}
	
	
	private static void SetRunnig(String answer) {
		if(!answer.equalsIgnoreCase("yes")) {
			System.out.println("good bye");
			running=false;
		}
		//just for fun
		else {
			System.out.println(" .  .  . ");
		}
		
	}

	public static void main(String[]args) throws InterruptedException {
		
		
		Set_Timer("yes");
		
		while(running) {
			Thread.sleep(Sleeping_time);
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(null, MyEvent);
			System.out.println("\nwe stoped after "+Mytime+" "+TimeUnit);
			String answer =MyConsole.readString("would you like to continue?");
			SetRunnig(answer);
			if(running) {
				answer =MyConsole.readString("would you like to change your Timer values?");
				Set_Timer(answer);
			}
		}
	}
}
