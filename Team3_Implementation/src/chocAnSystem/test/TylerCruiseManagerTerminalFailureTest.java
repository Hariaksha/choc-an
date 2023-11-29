package chocAnSystem.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import chocAnSystem.ManagerTerminal;

class TylerCruiseManagerTerminalFailureTest {
	ManagerTerminal t;
	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	@BeforeEach
	void setUp() throws Exception {
		System.setOut(new PrintStream(outputStreamCaptor));
		t = new ManagerTerminal();
	}

	@Test
	void test() {
		t.managerLoginAndChooseAction();
		assertEquals("Enter username and click Enter: ", outputStreamCaptor.toString().trim());
		assertEquals("Enter password and click Enter: ", outputStreamCaptor.toString().trim());
		assertEquals("Username is not valid.", outputStreamCaptor.toString().trim());
	}

}
