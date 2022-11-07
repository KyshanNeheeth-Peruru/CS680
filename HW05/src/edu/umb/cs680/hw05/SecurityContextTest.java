package edu.umb.cs680.hw05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SecurityContextTest {
	String pwd;

	@Test
    public void checkStateInitial() {
	SecurityContext ctx = SecurityContext.getInstance();
	State expected;
	expected = LoggedOut.getInstance();
	assertEquals(expected, ctx.getState());
	}
	
	@Test
    public void checkStateAfterLogin() {
	SecurityContext ctx = SecurityContext.getInstance();
	State expected;
	ctx.login(pwd);
	expected = LoggedIn.getInstance();
	assertSame(expected, ctx.getState());
	}
	
	@Test
    public void checkStateAfterLoginandLogout() {
	SecurityContext ctx = SecurityContext.getInstance();
	ctx.login(pwd);
	ctx.logout();
	assertTrue(ctx.getState() instanceof LoggedOut);
	}
	
	@Test
    public void testNotActive() {
	SecurityContext ctx = SecurityContext.getInstance();
	State expected;
	ctx.login(pwd);
	ctx.logout();
	ctx.login(pwd);
	ctx.login(pwd);
	expected = LoggedIn.getInstance();
	assertSame(expected, ctx.getState());
	}	
}
