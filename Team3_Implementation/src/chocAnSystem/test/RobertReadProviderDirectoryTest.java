package chocAnSystem.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import chocAnSystem.ProviderDirectory;

class RobertReadProviderDirectoryTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testMakeDirectory() {
		ProviderDirectory.makeDirectory();
		assertEquals("Service Code\tService Name\tService Price\n"
				 + "598470\tdietitianAppt\t125\n"
				 + "883948\taerobicsSession\t143", ProviderDirectory.getBuff());
	}

}
