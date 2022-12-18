package edu.umb.cs680.hw13;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import edu.umb.cs680.hw13.Directory;
import edu.umb.cs680.hw13.FSElement;
import edu.umb.cs680.hw13.File;
import edu.umb.cs680.hw13.Link;

class LinkTest {
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
	public void testIsDirectory() {
		assertTrue(root.isDirectory());
		assertTrue(apps.isDirectory());
		assertTrue(bin.isDirectory());
		assertTrue(home.isDirectory());
		assertTrue(pictures.isDirectory());
		assertFalse(x.isDirectory());
		assertFalse(y.isDirectory());
		assertFalse(a.isDirectory());
		assertFalse(b.isDirectory());
		assertFalse(c.isDirectory());
		assertFalse(d.isDirectory());
		assertFalse(e.isDirectory());
	}
	
	@Test
	public void testIsFile() {
		assertFalse(root.isFile());
		assertFalse(apps.isFile());
		assertFalse(bin.isFile());
		assertFalse(home.isFile());
		assertFalse(pictures.isFile());
		assertTrue(x.isFile());
		assertTrue(y.isFile());
		assertTrue(a.isFile());
		assertTrue(b.isFile());
		assertTrue(c.isFile());
		assertFalse(d.isFile());
		assertFalse(e.isFile());
	}
	
	@Test
	public void testIsLink() {
		assertFalse(root.isLink());
		assertFalse(apps.isLink());
		assertFalse(bin.isLink());
		assertFalse(home.isLink());
		assertFalse(pictures.isLink());
		assertFalse(x.isLink());
		assertFalse(y.isLink());
		assertFalse(a.isLink());
		assertFalse(b.isLink());
		assertFalse(c.isLink());
		assertTrue(d.isLink());
		assertTrue(e.isLink());
	}
	
	@Test
	public void testGetTarget() {
		Directory expecteddir = pictures;
		File expectedFile = x;
		FSElement dTarget = d.getTarget();
		FSElement eTarget = e.getTarget();
		assertSame(expecteddir, dTarget);
		assertSame(expectedFile, eTarget);
	}
}
