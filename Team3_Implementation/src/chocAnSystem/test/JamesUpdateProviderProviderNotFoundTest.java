package chocAnSystem.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import chocAnSystem.UpdateProvider;

class JamesUpdateProviderProviderNotFoundTest {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testErrorPrintOutput() {
        
        System.setOut(new PrintStream(outContent));

       
        UpdateProvider updateProvider = new UpdateProvider();

        updateProvider.providerNotFound();
        
        System.setOut(originalOut);

        assertFalse(outContent.toString().contains("Provider found"));
    }
}
