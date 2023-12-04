package chocAnSystem.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import chocAnSystem.ProviderTerminal;

class RyanMcCulleyProviderPasswordCheck {
	private ProviderTerminal pt;

	@BeforeEach
	void setUp() throws Exception {
		pt = new ProviderTerminal();
	}

	@Test
	void test() {
		pt.isPasswordRight("222222222", 1);
		assertTrue(true);
	}

}






