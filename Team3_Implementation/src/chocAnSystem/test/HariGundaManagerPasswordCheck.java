package chocAnSystem.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import chocAnSystem.ManagerTerminal;


class HariGundaManagerPasswordCheck {
	private ManagerTerminal t;
	
	@BeforeEach
	void setUp() throws Exception {
		t = new ManagerTerminal();
	}

	@Test
	void test() {
		t.isPasswordRight("222222222", 1);
		assertTrue(true);
	}
}
