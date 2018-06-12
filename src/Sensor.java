/**
 * Sensor.java
 *
 * @author Dr. Fenwick
 * @version Summer 2018
 *
 * Copyright (C) 2018 Jay Fenwick
 */

/**
 * Sensor class abstracts the common properties and operations of
 * our GE sensors.
 *
 * @author Dr. Fenwick
 * @version Summer 2018
 */
public abstract class Sensor {
    private boolean armed;
    private String name;
    private SensorController controller;

    /** Constructor.
     * @param name 
    */
    public Sensor(String name) {
	this.name = name;
	armed = false;
	controller = null;
    }

    /** field accessor. */
    public String getName() {
	return name;
    }

    /** field accessor. */
    public boolean isArmed() {
	return armed;
    }

    /** field mutator. */
    public void setArmed() {
	armed = true;
    }

    /** field mutator. */
    public void clearArmed() {
	armed = false;
    }

    /** field mutator. */
    public void setController(SensorController c) {
	controller = c;
    }

    /** Sensor activated. */
    public void trigger() {
	if (armed) {
	    System.out.println(""+name+" is triggered.");
	    controller.signal(this);
	}
    }

    abstract public boolean arm();
    abstract public boolean disarm();
}