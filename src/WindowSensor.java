/**
 * WindowSensor.java
 *
 * @author Dr. Fenwick
 * @version Summer 2018
 *
 * Copyright (C) 2018 Jay Fenwick
 */

/**
 * WindowSensor implements our GE window sensor.
 *
 * @author Dr. Fenwick
 * @version Summer 2018
 */
public class WindowSensor extends Sensor {

    /** Constructor.
     * @param name 
    */
    public WindowSensor(String name) {
	super(name+"Window");
    }

    /** Readies the sensor for intrusion detection. */
    public boolean arm() {
	// GE-specific window sensor stuff here to arm...
	
	setArmed();
	System.out.println(""+getName()+" is armed.");
	return true;
    }

    /** Disables the sensor for intrusion detection. */
    public boolean disarm() {
	// GE-specific window sensor stuff here to disarm...
	
	clearArmed();
	System.out.println(""+getName()+" is disarmed.");
	return true;
    }
}