package chocAnSystem.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.Rule;
import org.junit.contrib.java.lang.system.Assertion;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import chocAnSystem.ManagerTerminal;

class TylerCruiseManagerTerminalFailureTest {
	@Rule
	public final ExpectedSystemExit exit = ExpectedSystemExit.none();
	
	
	ManagerTerminal t;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    //private final InputStream originalSystemIn = System.in;

	@BeforeEach
	void setUp() throws Exception {
		System.setOut(new PrintStream(outputStreamCaptor));
		t = new ManagerTerminal();
	}

	@Test
	void test() {
		 exit.expectSystemExitWithStatus(1);
		    exit.checkAssertionAfterwards(new Assertion() {
		      public void checkAssertion() {
		        assertEquals("Failed too many times. You will be logged out.", t.login());
		      }
		    });
		    t.login();
	}

}
