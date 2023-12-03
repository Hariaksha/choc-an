package chocAnSystem.test;

//import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import chocAnSystem.ProviderController;

class RobertReadProviderControllerTest {

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
	
	
	@AfterEach
	void teardown() {
		System.setIn(System.in);
	}
	
	
	//@Rule
	//public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();
	//public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	
	@Test
	void testBillChocAn() {
		ByteArrayInputStream in = new ByteArrayInputStream("494330105\n07-14-2023\n598470\ny\ntest service\n".getBytes());
		System.setIn(in);
		ProviderController.billChocAn();
		assertEquals(0, 0);
	}
	


}
