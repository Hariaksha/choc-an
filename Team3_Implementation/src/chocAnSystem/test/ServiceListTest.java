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
		for(int i = 0; i < 50; i++) {
			//System.out.println("Amount = " + t.amount);
			t.addServiceInfo("note: " + i, "date: " + i);
		}
		//System.out.println("Before Final Amount = " + t.amount);
		t.addServiceInfo("additional", "the last one");
	}

	@Test
	void test() {
		System.out.println("Size: " + t.size + " Amount: " + t.amount);
		assertEquals(100, t.size);
	}

}
