import java.util.Scanner;
import java.util.InputMismatchException;


public class Demo {
 
    public static void main(String[] args) {

	// construct products
	WindowSensor livingRoomWindow = new WindowSensor("Living Room");
	WindowSensor diningRoomWindow = new WindowSensor("Dining Room");
	DoorSensor frontDoor = new DoorSensor("Front");
	MotionSensor livingRoomMotion = new MotionSensor("Living");
	MotionSensor diningRoomMotion = new MotionSensor("Dining");
	SensorController downstairsController = 
	    new SensorController("Downstairs");
	
	// connect sensors into controller
	downstairsController.addSensor(livingRoomWindow);
	downstairsController.addSensor(diningRoomWindow);
	downstairsController.addSensor(livingRoomMotion);
	downstairsController.addSensor(diningRoomMotion);
	downstairsController.addSensor(frontDoor);

	// start the demo
	Scanner keyboard = new Scanner(System.in);
	int choice = menu(keyboard);
	while (choice != 0) {
	    switch (choice) {
	    case 1 :
		downstairsController.arm();
		break;
	    case 2:
		downstairsController.disarm();
		break;
	    case 3:
		choice = submenu(keyboard);
		switch (choice) {
		case 1:
		    livingRoomWindow.trigger();
		    break;
		case 2:
		    diningRoomWindow.trigger();
		    break;
		case 3:
		    livingRoomMotion.trigger();
		    break;
		case 4:
		    diningRoomMotion.trigger();
		    break;
		case 5:
		    frontDoor.trigger();
		    break;
		default:
		    System.out.println("Illegal choice.");
		    break;
		}
		break;
	    }
	    choice = menu(keyboard);
	}
    }
    private static int menu(Scanner keyboard) {
	int choice = -1;
	while (choice < 0) {
	    System.out.println();
	    System.out.println();
	    System.out.println("Welcome to the HomeSec Simulator");
	    System.out.println("Your menu choices are:");
	    System.out.println("\t0. Quit the simulator");
	    System.out.println("\t1. Arm the System");
	    System.out.println("\t2. Disarm the System");
	    System.out.println("\t3. Test a sensor");
	    System.out.println();
	    System.out.print("What do you wish to do? ");
	    
	    try {
		choice = keyboard.nextInt();
		if (choice < 0 || choice > 3) {
		    choice = -1;
		    throw new InputMismatchException();
		}
	    }
	    catch (InputMismatchException e) {
		System.out.println("PLEASE ENTER A NUMBER 0-3.");
		keyboard.nextLine(); // clear out trailing \n
	    }
	    catch (Exception e) {
		e.printStackTrace();
	    }
	}
	return choice;
    }

    private static int submenu(Scanner keyboard) {
	int choice = -1;

	System.out.println("Available sensors:");
	System.out.println("\t1. Living room window");
	System.out.println("\t2. Dining room window");
	System.out.println("\t3. Living room motion");
	System.out.println("\t4. Dining room motion");
	System.out.println("\t5. Front door");
	System.out.print("Which sensor do you wish to trigger? ");
	    
	try {
	    choice = keyboard.nextInt();
	}
	catch (InputMismatchException e) {
	    keyboard.nextLine(); // clear out trailing \n
	}
	catch (Exception e) {
	    e.printStackTrace();
	}
	return choice;
    }
}
