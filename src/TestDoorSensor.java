
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

public class TestDoorSensor {

    static DoorSensor s;  

    // These fields are used to redirect and capture System.out
    static PrintStream originalOut;
    static ByteArrayOutputStream baos;
    static PrintStream newOut;

    @BeforeEach
    void init() {
	s = new DoorSensor("me");

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
    void testArm() {
	String expectedOutput = "meDoor is armed.\n";

	// method writes to System.out which has been redirected
	s.arm();
	System.out.flush();
	String actualOutput = baos.toString();
	
	assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testDisarm() {
	String expectedOutput = "meDoor is disarmed.\n";

	// method writes to System.out which has been redirected
	s.disarm();
	System.out.flush();
	String actualOutput = baos.toString();
	
	assertEquals(expectedOutput, actualOutput);
    }
}
