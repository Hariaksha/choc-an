package chocAnSystem.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import chocAnSystem.ProviderDirectory;
import java.io.File;

class RobertReadProviderDirectoryTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testMakeDirectory() {
		ProviderDirectory.makeDirectory();
		File file = new File("Provider_Directory.txt");
		assertTrue(file.exists());
	}

}
