
JFLAGS = -d bin -sourcepath src
CKSTYLE_COMMAND="-jar /usr/local/checkstyle-5.5/checkstyle-5.5-all.jar"
CKSTYLE_XML = style.xml

default:
	@echo "'make clean' removes *.class *~ files"
	@echo "'make compile' compiles all Java files"
	@echo "'make demo' runs simulator demo"
	@echo "'make test' runs JUnit5 test cases"
	@echo "'make check' runs checkstyle on non-test classes"

test: junit-platform-console-standalone-1.2.0.jar 
	java -cp .:bin:junit-platform-console-standalone-1.2.0.jar org.junit.platform.console.ConsoleLauncher --scan-class-path

clean:
	rm -f bin/*.class
	rm -f src/*~
	rm -f *~

compile: junit-platform-console-standalone-1.2.0.jar 
	javac $(JFLAGS) -cp .:junit-platform-console-standalone-1.2.0.jar src/*.java

demo: bin/Demo.class
	java -cp bin Demo

check: style.xml
	cd src; java -jar /usr/local/checkstyle-5.5/checkstyle-5.5-all.jar -c ../style.xml *.java

# Unfortunately you will have to update this for each non-test source file.
# Make sure the first character is a TAB
defchk: 
	cd src; checkstyle Sensor.java
	cd src; checkstyle WindowSensor.java
	cd src; checkstyle DoorSensor.java
	cd src; checkstyle MotionSensor.java
	cd src; checkstyle Alarm.java
	cd src; checkstyle SensorController.java
	@echo "YOU NEED TO MANUALLY CHECK THE OTHER FILES, SEE MAKEFILE"
