package edu.umb.cs680.hw10;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import org.junit.jupiter.api.Test;
import edu.umb.cs680.hw10.fs.Directory;
import edu.umb.cs680.hw10.fs.File;
import edu.umb.cs680.hw10.fs.LoggedIn;
import edu.umb.cs680.hw10.fs.LoggedOut;
import edu.umb.cs680.hw10.fs.SecurityContext;
import edu.umb.cs680.hw10.fs.State;
import edu.umb.cs680.hw10.fs.util.FileSearchVisitor;


class FileSearchVisitorTest {
	static LocalDateTime localTime = LocalDateTime.now();
	
	Directory root = new Directory(null, "root", 0, localTime);
	Directory apps = new Directory(root, "apps", 0, localTime);
	Directory lib = new Directory(root, "lib", 0, localTime);
	Directory home = new Directory(root, "home", 0, localTime);
	Directory code = new Directory(home, "code", 0, localTime);
	
	File x = new File(apps, "x", 1, localTime);
	File y = new File(apps, "y", 2, localTime);
	File z = new File(lib, "z", 3, localTime);
	File a = new File(code, "a", 4, localTime);
	File b = new File(code, "b", 5, localTime);
	File c = new File(code, "c", 6, localTime);
	File d = new File(home, "d", 7, localTime);
	
	@Test
    public void checkLoggedOut() {
		SecurityContext ctx = SecurityContext.getInstance();
		State expected;
		expected = LoggedOut.getInstance();
		FileSearchVisitor v = new FileSearchVisitor("x");
		root.accept(v,ctx);
		assertEquals(expected, ctx.getState());
	}
	
	@Test
	public void testLoginSearchVisitorFileX() {
		SecurityContext ctx = SecurityContext.getInstance();
		State expectedState;
		ctx.login("pwd");
		expectedState = LoggedIn.getInstance();
		FileSearchVisitor v = new FileSearchVisitor("x");
		root.accept(v,ctx);
		assertEquals(expectedState, ctx.getState());
		assertSame(x, v.getFoundFiles().get(0));
		ctx.logout();
	}
	
	@Test
	public void testLoginSearchVisitorFileY() {
		SecurityContext ctx = SecurityContext.getInstance();
		State expectedState;
		ctx.login("pwd");
		expectedState = LoggedIn.getInstance();
		FileSearchVisitor v = new FileSearchVisitor("y");
		root.accept(v,ctx);
		assertEquals(expectedState, ctx.getState());
		assertSame(y, v.getFoundFiles().get(0));
		ctx.logout();
	}
	
	@Test
	public void testLoginSearchVisitorFileABCD() {
		SecurityContext ctx = SecurityContext.getInstance();
		State expectedState;
		ctx.login("pwd");
		expectedState = LoggedIn.getInstance();
		FileSearchVisitor v = new FileSearchVisitor("a");
		root.accept(v,ctx);
		v.setFileName("b");
		root.accept(v,ctx);
		v.setFileName("c");
		root.accept(v,ctx);
		v.setFileName("d");
		root.accept(v,ctx);
		LinkedList<File> actual = v.getFoundFiles();
		LinkedList<File> expected = new LinkedList<>();
		expected.add(a);
		expected.add(b);
		expected.add(c);
		expected.add(d);
		assertEquals(expectedState, ctx.getState());
		assertArrayEquals(expected.toArray(), actual.toArray());
		ctx.logout();
	}
	
	

}
