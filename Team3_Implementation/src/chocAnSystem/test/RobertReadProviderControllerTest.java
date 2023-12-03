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
		boolean test = ProviderController.verifyMember("429803689");
		assertTrue(test);
		
	}
	
	
	@Test
	void testVerifyMemberFail() {
		boolean test = ProviderController.verifyMember("5");
		assertFalse(test);
		
	}
	

	@Test
	void testBillChocAn() {
		String input = "429803689\n07-14-2023\n598470\ny\ntest service\n";
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		ProviderController.billChocAn();
		//assertEquals(0, 0);
		System.setIn(System.in);
	}
	


}
