package chocAnSystem.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import chocAnSystem.ManagerTerminal;

class TylerCruiseManagerTerminalFailureTest {
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	ManagerTerminal t;

	@BeforeEach
	void setUp() throws Exception {
		System.setOut(new PrintStream(outputStreamCaptor));
		t = new ManagerTerminal();
		
	}

	@Test
	void test() {
		assertEquals(t.isStrInUsernameArr("Potato"), -1);
	}

}
