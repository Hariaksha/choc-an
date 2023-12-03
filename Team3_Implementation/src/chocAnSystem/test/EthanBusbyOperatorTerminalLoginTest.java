package chocAnSystem.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import chocAnSystem.OperatorTerminal;

class EthanBusbyOperatorTerminalLoginTest {

    private OperatorTerminal t;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final InputStream originalSystemIn = System.in;

    @BeforeEach
    void setUp() throws Exception {
        System.setOut(new PrintStream(outputStreamCaptor));
        t = new OperatorTerminal();
    }

    @AfterEach
    void tearDown() {
        System.setIn(originalSystemIn);
        System.setOut(System.out);
    }

    @Test
    void test() {
        ByteArrayInputStream inContent = new ByteArrayInputStream("InvalidUser\nInvalidPassword\n".getBytes());
        System.setIn(inContent);
        t.login();
        assertTrue(outputStreamCaptor.toString().contains("Enter username and click Enter: "));
        assertTrue(outputStreamCaptor.toString().contains("Enter password and click Enter: "));
        assertTrue(outputStreamCaptor.toString().contains("Successful login."));
    }
}