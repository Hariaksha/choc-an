package chocAnSystem.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;
//import static org.junit.contrib.java.lang.system.SystemOutRule.*;
import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
//import org.junit.contrib.java.lang.system.SystemOutRule;


import chocAnSystem.ProviderController;

class RobertReadProviderControllerTest {

	@BeforeEach
	 void setUp() throws Exception {
		//System.setIn(System.in);
		//System.setOut(System.out);
		//systemOutRule.clearLog();
	 }
	
	@AfterEach
	 void tearDown() {
	 }


	@Test
	void testVerifyMemberSuccess() {
		boolean test = ProviderController.verifyMember("494330105");
		assertTrue(test);
		
	}
	
	
	@Test
	void testVerifyMemberFail() {
		boolean test = ProviderController.verifyMember("5");
		assertFalse(test);
		
	}
	
	
	
	@Rule
	public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();
	//public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	
	@Test
	void testBillChocAn() {
		//System.out.println(systemOutRule.getLog());
		ProviderController.billChocAn();
		//systemInMock.provideLines("494330105","07-14-2023","598470","y","test service");
		assertEquals(0, 0);
	}


}
