package chocAnSystem.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import chocAnSystem.ServiceList;

class ServiceListTest {
	
	ServiceList t;

	@BeforeEach
	void setUp() throws Exception {
		t = new ServiceList();
		for(int i = 0; i < 10; i++) {
			t.addServiceInfo("Notes: "+i, "Notes: "+i);
		}
	}

	@Test
	void test() {
		assertEquals(10, t.amount);
	}

}
