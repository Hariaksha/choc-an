package chocAnSystem.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import chocAnSystem.ProviderTerminal;

/** */
class RyanMcCulleyProviderTerminalLogInCheck {

    private ProviderTerminal pt;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() throws Exception {
        System.setOut(new PrintStream(outputStreamCaptor));
        pt = new ProviderTerminal();
    }


    @Test
    void test() {
        ByteArrayInputStream inContent = new ByteArrayInputStream("InvalidUser\nInvalidPassword\n".getBytes());
        System.setIn(inContent);
        pt.providerLogin();
        assertTrue(outputStreamCaptor.toString().contains("Enter username and click Enter: "));
        assertTrue(outputStreamCaptor.toString().contains("Enter password and click Enter: "));
        assertTrue(outputStreamCaptor.toString().contains("Successful login."));
    }
}
