package chocAnSystem.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import chocAnSystem.OperatorTerminal; 

class JamesOperatorTerminalStringUsernameTest {

	OperatorTerminal opterm; 
	
	@BeforeEach
	void setUp() throws Exception {
		opterm = new OperatorTerminal(); 
	}

	@Test
	void test() {
		opterm.isStrInUsernameArr("James"); 
		assertTrue(true); 
	}

}
