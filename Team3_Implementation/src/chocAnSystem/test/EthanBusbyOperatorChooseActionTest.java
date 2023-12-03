package chocAnSystem.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import chocAnSystem.OperatorTerminal;

class EthanBusbyOperatorChooseActionTest {
    private OperatorTerminal t;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	
	
	@BeforeEach
	void setUp() throws Exception {
		System.setOut(new PrintStream(outputStreamCaptor));
        t = new OperatorTerminal();
	}

	@Test
	void test() {
		
	}

}
