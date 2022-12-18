package edu.umb.cs680.hw09;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import edu.umb.cs680.hw09.fs.Directory;
import edu.umb.cs680.hw09.fs.File;
import edu.umb.cs680.hw09.fs.Link;
import edu.umb.cs680.hw09.fs.util.CountingVisitor;

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
	public void testCoutingVisitorRoot() {
		CountingVisitor v = new CountingVisitor();
		root.accept(v);
		assertEquals(5,v.getDirNumber());
		assertEquals(5,v.getFileNumber());
		assertEquals(2,v.getLinkNumber());
	}
	
	@Test
	public void testCoutingVisitorApps() {
		CountingVisitor v = new CountingVisitor();
		apps.accept(v);
		assertEquals(1,v.getDirNumber());
		assertEquals(1,v.getFileNumber());
		assertEquals(0,v.getLinkNumber());
	}
	
	@Test
	public void testCoutingVisitorBin() {
		CountingVisitor v = new CountingVisitor();
		bin.accept(v);
		assertEquals(1,v.getDirNumber());
		assertEquals(1,v.getFileNumber());
		assertEquals(0,v.getLinkNumber());
	}
	
	@Test
	public void testCoutingVisitorHome() {
		CountingVisitor v = new CountingVisitor();
		home.accept(v);
		assertEquals(2,v.getDirNumber());
		assertEquals(3,v.getFileNumber());
		assertEquals(0,v.getLinkNumber());
	}
	
	@Test
	public void testCoutingVisitorPictures() {
		CountingVisitor v = new CountingVisitor();
		pictures.accept(v);
		assertEquals(1,v.getDirNumber());
		assertEquals(2,v.getFileNumber());
		assertEquals(0,v.getLinkNumber());
	}

}
