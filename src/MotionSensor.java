/**
 * MotionSensor.java
 *
 * @author Dr. Fenwick
 * @version Summer 2018
 *
 * Copyright (C) 2018 Jay Fenwick
 */

/**
 * MotionSensor implements our GE motion sensor.
 *
 * @author Dr. Fenwick
 * @version Summer 2018
 */
public class MotionSensor extends Sensor {

    /** Constructor.
     * @param name 
    */
    public MotionSensor(String name) {
	super(name+"Motion");
    }

    /** Readies the sensor for intrusion detection. */
    public boolean arm() {
	// GE-specific motion sensor stuff here to arm...
	
	setArmed();
	System.out.println(""+getName()+" is armed.");
	return true;
    }

    /** Disables the sensor for intrusion detection. */
    public boolean disarm() {
	// GE-specific motion sensor stuff here to disarm...
	
	clearArmed();
	System.out.println(""+getName()+" is disarmed.");
	return true;
    }
}