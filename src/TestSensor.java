
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

public class TestSensor {

    static XxxxSensor s;  

    // These fields are used to redirect and capture System.out
    static PrintStream originalOut;
    static ByteArrayOutputStream baos;
    static PrintStream newOut;

    @BeforeEach
    void init() {
	s = new XxxxSensor("me");

	originalOut = System.out;     // save to restore later

	baos = new ByteArrayOutputStream();
	newOut = new PrintStream(baos);
	System.setOut(newOut);
    }

    @AfterEach
    void tearDown() {
	System.setOut(originalOut);  // restore 
    }

   
    @Test
    void testGetName() {
	assertEquals("me", s.getName());
    }

    @Test
    public void testIsArmedFalse() {
	boolean expectedOutput = false;

	boolean actualOutput = s.isArmed();
	
	assertEquals(expectedOutput, actualOutput);
    }
    @Test
    public void testIsArmedTrue() {
	boolean expectedOutput = true;

	s.setArmed();
	boolean actualOutput = s.isArmed();
	
	assertEquals(expectedOutput, actualOutput);
    }
    @Test
    public void testSetArmed() {
	assertEquals(false, s.isArmed());
	s.setArmed();
	assertEquals(true, s.isArmed());
    }
    @Test
    public void testClearArmed() {
	assertEquals(false, s.isArmed());
	s.setArmed();
	assertEquals(true, s.isArmed());
	s.clearArmed();
	assertEquals(false, s.isArmed());
    }
    @Test
    public void testArmedTrigger() {
	String expectedOutput = "me is triggered.\n";

	s.setArmed();
	s.setController(new SensorController("you"));
	s.trigger();
	System.out.flush();
	String actualOutput = baos.toString();
	
	// Class we are testing is start of output, but not all of it
	assertEquals(true, actualOutput.startsWith(expectedOutput));
    }
    @Test
    public void testDisarmedTrigger() {
	String expectedOutput = "";

	s.clearArmed();
	s.trigger();
	System.out.flush();
	String actualOutput = baos.toString();
	
	// Class we are testing is start of output, but not all of it
	assertEquals(expectedOutput, actualOutput);
    }
}

class XxxxSensor extends Sensor {
    public XxxxSensor(String name) {
	super(name);
    }
    public boolean arm() {
	setArmed();
	System.out.println(""+getName()+" is armed.");
	return true;
    }
    public boolean disarm() {
	clearArmed();
	System.out.println(""+getName()+" is disarmed.");
	return true;
    }
}