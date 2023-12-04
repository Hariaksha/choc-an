package chocAnSystem.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import chocAnSystem.ServiceList;

class RyanMcCulleyServiceListTest {
	public ServiceList sl;
	

	@BeforeEach
	void setUp() throws Exception {
		sl = new ServiceList();
	}

	@Test
	void testMain() {
		sl.addServiceInfo("testnote","testdate");
		assertEquals("testnote",sl.comments.get(0));
	}

}
