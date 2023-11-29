package chocAnSystem.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import chocAnSystem.ReportController;

class ReportControllerTest {
	ReportController t;
	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	@BeforeEach
	void setUp() throws Exception {
		System.setOut(new PrintStream(outputStreamCaptor));
		t = new ReportController();
		
		
		
	}

	@Test
	void test() {
		t.memberReport();
		assertEquals("Compiled Member Report", outputStreamCaptor.toString().trim());
	}

}
