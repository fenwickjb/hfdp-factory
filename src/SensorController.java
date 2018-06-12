/**
 * SensorController.java
 *
 * @author Dr. Fenwick
 * @version Summer 2018
 *
 * Copyright (C) 2018 Jay Fenwick
 */

import java.util.ArrayList;

/**
 * SensorController implements our GE sensor controller.
 *
 * @author Dr. Fenwick
 * @version Summer 2018
 */
public class SensorController {
    private Alarm alarm;
    private String name;
    private ArrayList<Sensor> sensors;
    
    /** Constructor.
     * @param name 
    */
    public SensorController(String name) {
	this.name = name;
	alarm = new Alarm(name);
	sensors = new ArrayList<Sensor>();
    }

    /** Adds sensor to list of sensors to be managed.
     * @param sensor
    */
    public void addSensor(Sensor sensor) {
	// bi-directional link controller <---> sensor
	sensors.add(sensor);
	sensor.setController(this);
    }

    /** Controller receives signal from external sensor.
     * @param sensor sensor that is activated
    */
    public void signal(Sensor source) {
	// GE specific control panel stuff...

	System.out.println("Controller signalled by " + source.getName());
	alarm.turnOn();
    }

    /** System reset. */
    public void disarm() {
	// GE specific control panel stuff...

	for (Sensor sensor : sensors)
	    sensor.disarm();
	alarm.turnOff();
    }

    /** System engaged, begins intrustion detection. */
    public void arm() {
	// GE specific control panel stuff...

	for (Sensor sensor : sensors)
	    sensor.arm();
    }
}