package chocAnSystem.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import chocAnSystem.ProviderController;

class ProviderControllerTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testVerifyMemberSuccess() {
		boolean test = ProviderController.verifyMember("122142750");
		assertEquals(true, test);
		
	}
	
	@Test
	void testVerifyMemberFail() {
		boolean test = ProviderController.verifyMember("5");
		assertEquals(true, test);
		
	}

}
