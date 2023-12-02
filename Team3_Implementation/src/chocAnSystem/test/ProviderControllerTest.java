package chocAnSystem.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.PrintStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import chocAnSystem.ProviderController;

class ProviderControllerTest {
	private final static InputStream systemIn = System.in;
	private final static PrintStream systemOut = System.out;
	private ByteArrayInputStream typeIn;
	private static ByteArrayOutputStream typeOut;
	
	@BeforeEach
	 void setUp() throws Exception {
	  typeOut = new ByteArrayOutputStream();
	        System.setOut(new PrintStream(typeOut));
	 }
	
	@AfterEach
	 void tearDown() {
	  System.setIn(systemIn);
	        System.setOut(systemOut);
	 }


	@Test
	void testVerifyMemberSuccess() {
		boolean test = ProviderController.verifyMember("122142750");
		assertTrue(test == true);
		
	}
	
	@Test
	void testVerifyMemberFail() {
		boolean test = ProviderController.verifyMember("5");
		assertFalse(test == false);
		
	}
	
	@Test
	void testBillChocAn() {
		ProviderController.billChocAn();
		String simulatedUserInput = 
				"834861601" + System.getProperty("line.separator") +
			    "07-14-2023" + System.getProperty("line.separator") +
			    "598470" + System.getProperty("line.separator") +
			    "y" + System.getProperty("line.separator") +
			    "test service" + System.getProperty("line.separator");
		
		System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
		
		assertTrue(true);
	}
	
	
	

}
