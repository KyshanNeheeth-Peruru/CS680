package edu.umb.cs680.hw10.fs.util;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.LinkedList;
import org.junit.jupiter.api.Test;
import edu.umb.cs680.hw10.fs.Directory;
import edu.umb.cs680.hw10.fs.File;
import edu.umb.cs680.hw10.fs.Link;
import edu.umb.cs680.hw10.fs.LoggedIn;
import edu.umb.cs680.hw10.fs.LoggedOut;
import edu.umb.cs680.hw10.fs.SecurityContext;
import edu.umb.cs680.hw10.fs.State;

class FileCrawlingVisitorTest {
	static LocalDateTime localTime = LocalDateTime.now();
	
	Directory root = new Directory(null, "root", 0, localTime);
	Directory apps = new Directory(root, "apps", 0, localTime);
	Directory bin = new Directory(root, "bin", 0, localTime);
	Directory home = new Directory(root, "home", 0, localTime);
	Directory pictures = new Directory(home, "pictures", 0, localTime);
	
	File x = new File(apps, "x", 1, localTime);
	File y = new File(bin, "y", 2, localTime);
	File a = new File(pictures, "a", 3, localTime);
	File b = new File(pictures, "b", 4, localTime);
	File c = new File(home, "c", 4, localTime);
	
	Link d = new Link(root, "d", 0, localTime, pictures);
	Link e = new Link(root, "e", 0, localTime, x);
	
	@Test
    public void checkLoggedOut() {
		SecurityContext ctx = SecurityContext.getInstance();
		State expected;
		expected = LoggedOut.getInstance();
		CountingVisitor v = new CountingVisitor();
		root.accept(v,ctx);
		assertEquals(expected, ctx.getState());
	}
	
	@Test
    public void testAfterLoginFileCrawlingVistorRoot() {
		SecurityContext ctx = SecurityContext.getInstance();
		State expectedState;
		ctx.login("pwd");
		expectedState = LoggedIn.getInstance();
		FileCrawlingVisitor v = new FileCrawlingVisitor();
		root.accept(v,ctx);
		LinkedList<File> actual = v.getFiles();
		File[] expected = {x,y,a,b,c};
		assertEquals(expectedState, ctx.getState());
		assertArrayEquals(expected, actual.toArray());
		ctx.logout();
	}
	
	@Test
    public void testAfterLoginFileCrawlingVistorApps() {
		SecurityContext ctx = SecurityContext.getInstance();
		State expectedState;
		ctx.login("pwd");
		expectedState = LoggedIn.getInstance();
		FileCrawlingVisitor v = new FileCrawlingVisitor();
		apps.accept(v,ctx);
		LinkedList<File> actual = v.getFiles();
		File[] expected = {x};
		assertEquals(expectedState, ctx.getState());
		assertArrayEquals(expected, actual.toArray());
		ctx.logout();
	}
	
	@Test
    public void testAfterLoginFileCrawlingVistorBin() {
		SecurityContext ctx = SecurityContext.getInstance();
		State expectedState;
		ctx.login("pwd");
		expectedState = LoggedIn.getInstance();
		FileCrawlingVisitor v = new FileCrawlingVisitor();
		bin.accept(v,ctx);
		LinkedList<File> actual = v.getFiles();
		File[] expected = {y};
		assertEquals(expectedState, ctx.getState());
		assertArrayEquals(expected, actual.toArray());
		ctx.logout();
	}
	
	@Test
    public void testAfterLoginFileCrawlingVistorHome() {
		SecurityContext ctx = SecurityContext.getInstance();
		State expectedState;
		ctx.login("pwd");
		expectedState = LoggedIn.getInstance();
		FileCrawlingVisitor v = new FileCrawlingVisitor();
		home.accept(v,ctx);
		LinkedList<File> actual = v.getFiles();
		File[] expected = {a,b,c};
		assertEquals(expectedState, ctx.getState());
		assertArrayEquals(expected, actual.toArray());
		ctx.logout();
	}
	
	@Test
    public void testAfterLoginFileCrawlingVistorPictures() {
		SecurityContext ctx = SecurityContext.getInstance();
		State expectedState;
		ctx.login("pwd");
		expectedState = LoggedIn.getInstance();
		FileCrawlingVisitor v = new FileCrawlingVisitor();
		pictures.accept(v,ctx);
		LinkedList<File> actual = v.getFiles();
		File[] expected = {a,b};
		assertEquals(expectedState, ctx.getState());
		assertArrayEquals(expected, actual.toArray());
		ctx.logout();
	}
}
