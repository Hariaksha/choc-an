package chocAnSystem.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import chocAnSystem.ManagerTerminal;


class HariGundaOperatorTerminalFail {
	private OperatorTerminal t;


	@BeforeEach
	void setUp() throws Exception {
		t = new OperatorTerminal();

	}

	@Test
	void test() {
		t.isPasswordRight("Wrong", 0);
		assertFalse(false);
	}
}
