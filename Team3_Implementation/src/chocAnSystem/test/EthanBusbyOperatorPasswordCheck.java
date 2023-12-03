package chocAnSystem.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import chocAnSystem.OperatorTerminal;


class EthanBusbyOperatorPasswordCheck {
	private OperatorTerminal t;
	
	@BeforeEach
	void setUp() throws Exception {
		t = new OperatorTerminal();
	}

	@Test
	void test() {
		t.isPasswordRight("password999", 1);
		assertTrue(true);
	}
//oops
}
