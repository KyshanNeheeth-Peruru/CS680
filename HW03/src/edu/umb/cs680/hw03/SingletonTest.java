package edu.umb.cs680.hw03;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class SingletonTest {
	@Test
	public void testGetInstance()
	{
		Singleton singleton = Singleton.getInstance("happy");
		assertNotNull(singleton);
	}
	
	@Test
	public void testInstanceEqual() {
		Singleton expected = Singleton.getInstance("happy");
		Singleton actual = Singleton.getInstance("sad");
		assertEquals(expected.hashCode(),actual.hashCode());
	}
	
	@Test
	public void testInstanceSame() {
		Singleton expected = Singleton.getInstance("happy");
		Singleton actual = Singleton.getInstance("sad");
		assertNotSame(expected.hashCode(),actual.hashCode());
	}
}
