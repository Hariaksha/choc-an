package chocAnSystem.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import chocAnSystem.ManagerTerminal;

class TylerCruiseManagerTerminalFailureTest {
	ManagerTerminal t;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		Assertions.assertThrows(NumberFormatException.class,()->new ManagerTerminal());
	}

}
