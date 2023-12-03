package chocAnSystem.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import chocAnSystem.ReportController;

class TylerCruiseReportControllerTest {
	ReportController t;
	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	@BeforeEach
	void setUp() throws Exception {
		System.setOut(new PrintStream(outputStreamCaptor));
		t = new ReportController();
		
		
		
	}

	@Test
	void test() throws IOException {
		File input = new File("memberData.txt");
		t.memberReport();
		assertEquals("Compiled Member Report", outputStreamCaptor.toString().trim());
	}
	//2

}
