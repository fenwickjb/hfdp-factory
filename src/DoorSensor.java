/**
 * DoorSensor.java
 *
 * @author Dr. Fenwick
 * @version Summer 2018
 *
 * Copyright (C) 2018 Jay Fenwick
 */

/**
 * DoorSensor implements our GE door sensor.
 *
 * @author Dr. Fenwick
 * @version Summer 2018
 */
public class DoorSensor extends Sensor {

    /** Constructor.
     * @param name 
    */
    public DoorSensor(String name) {
	super(name+"Door");
    }

    /** Readies the sensor for intrusion detection. */
    public boolean arm() {
	// GE-specific door sensor stuff here to arm...
	
	setArmed();
	System.out.println(""+getName()+" is armed.");
	return true;
    }

    /** Disables the sensor for intrusion detection. */
    public boolean disarm() {
	// GE-specific door sensor stuff here to disarm...
	
	clearArmed();
	System.out.println(""+getName()+" is disarmed.");
	return true;
    }
}