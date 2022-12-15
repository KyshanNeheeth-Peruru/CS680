package src.edu.umb.cs680.hw10;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import edu.umb.cs680.hw10.fs.Directory;
import edu.umb.cs680.hw10.fs.File;
import edu.umb.cs680.hw10.fs.Link;
import edu.umb.cs680.hw10.fs.LoggedIn;
import edu.umb.cs680.hw10.fs.LoggedOut;
import edu.umb.cs680.hw10.fs.SecurityContext;
import edu.umb.cs680.hw10.fs.State;
import edu.umb.cs680.hw10.fs.util.CountingVisitor;


class CountingVisitorTest {
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
    public void testAfterLoginCoutingVistorRoot() {
		SecurityContext ctx = SecurityContext.getInstance();
		State expected;
		ctx.login("pwd");
		expected = LoggedIn.getInstance();
		CountingVisitor v = new CountingVisitor();
		root.accept(v,ctx);
		assertEquals(expected, ctx.getState());
		assertEquals(5,v.getDirNumber());
		assertEquals(5,v.getFileNumber());
		assertEquals(2,v.getLinkNumber());
		ctx.logout();
	}
	
	@Test
    public void testAfterLoginCoutingVistorApps() {
		SecurityContext ctx = SecurityContext.getInstance();
		State expected;
		ctx.login("pwd");
		expected = LoggedIn.getInstance();
		CountingVisitor v = new CountingVisitor();
		apps.accept(v,ctx);
		assertEquals(expected, ctx.getState());
		assertEquals(1,v.getDirNumber());
		assertEquals(1,v.getFileNumber());
		assertEquals(0,v.getLinkNumber());
		ctx.logout();
	}
	
	@Test
    public void testAfterLoginCoutingVistorBin() {
		SecurityContext ctx = SecurityContext.getInstance();
		State expected;
		ctx.login("pwd");
		expected = LoggedIn.getInstance();
		CountingVisitor v = new CountingVisitor();
		bin.accept(v,ctx);
		assertEquals(expected, ctx.getState());
		assertEquals(1,v.getDirNumber());
		assertEquals(1,v.getFileNumber());
		assertEquals(0,v.getLinkNumber());
		ctx.logout();
	}
	
	@Test
    public void testAfterLoginCoutingVistorHome() {
		SecurityContext ctx = SecurityContext.getInstance();
		State expected;
		ctx.login("pwd");
		expected = LoggedIn.getInstance();
		CountingVisitor v = new CountingVisitor();
		home.accept(v,ctx);
		assertEquals(expected, ctx.getState());
		assertEquals(2,v.getDirNumber());
		assertEquals(3,v.getFileNumber());
		assertEquals(0,v.getLinkNumber());
		ctx.logout();
	}
	
	@Test
    public void testAfterLoginCoutingVistorPictures() {
		SecurityContext ctx = SecurityContext.getInstance();
		State expected;
		ctx.login("pwd");
		expected = LoggedIn.getInstance();
		CountingVisitor v = new CountingVisitor();
		pictures.accept(v,ctx);
		assertEquals(expected, ctx.getState());
		assertEquals(1,v.getDirNumber());
		assertEquals(2,v.getFileNumber());
		assertEquals(0,v.getLinkNumber());
		ctx.logout();
	}

}
