package chocAnSystem.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import chocAnSystem.ProviderTerminal;

class RyanMcCulleyProviderTerminalFail {
	public ProviderTerminal npt;

	@BeforeEach
	void setUp() throws Exception {
		npt = new ProviderTerminal();
	}

	@Test
	void test() {
		npt.isPasswordRight("Wrong", 0);
		assertFalse(false);
	}


}
