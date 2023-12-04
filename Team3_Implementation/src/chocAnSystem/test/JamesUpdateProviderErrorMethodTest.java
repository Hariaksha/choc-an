package chocAnSystem.test;

import static org.junit.jupiter.api.Assertions.*;

import chocAnSystem.UpdateProvider; 
import org.junit.Before;
import org.junit.After;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class JamesUpdateProviderErrorMethodTest {
	
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

        updateProvider.error();
        
        System.setOut(originalOut);

        assertTrue(outContent.toString().contains("Enter valid function"));
    }
    
}

