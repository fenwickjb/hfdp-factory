/**
 * Alarm.java
 *
 * @author Dr. Fenwick
 * @version Summer 2018
 *
 * Copyright (C) 2018 Jay Fenwick
 */

/**
 * Alarm class implements our GE alarm hardware.
 *
 * @author Dr. Fenwick
 * @version Summer 2018
 */
public class Alarm {
    private String name;

    /** Constructor.
     * @param name 
    */
    public Alarm(String name) {
	this.name = name;
    }

    /** Turns on alarm hardware. */
    public void turnOn() {
	// GE specific way to flash lights and sound

	System.out.println(""+name+ " ALARM ALARM ALARM ALARM ALARM");
    }

    /** Turns off alarm hardware. */
    public void turnOff() {
	// GE specific way to turn off alarm hardware

	System.out.println(""+name+ " alarm off");
    }
}