package chocAnSystem.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import chocAnSystem.ManagerTerminal;

class TylerCruiseManagerTerminalFailureTest {
	ManagerTerminal t;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final InputStream originalSystemIn = System.in;

	@BeforeEach
	void setUp() throws Exception {
		System.setOut(new PrintStream(outputStreamCaptor));
		t = new ManagerTerminal();
	}

	@Test
	void test() {
        ByteArrayInputStream inContent = new ByteArrayInputStream("InvalidUser\nInvalidPassword\n".getBytes());
        System.setIn(inContent);
        t.login();
        assertTrue(outputStreamCaptor.toString().contains("Enter username and click Enter: "));
        assertTrue(outputStreamCaptor.toString().contains("Enter password and click Enter: "));
        assertTrue(outputStreamCaptor.toString().contains("Successful login."));
	}

}
