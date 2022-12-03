package edu.umb.cs680.hw09.fs.util;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import org.junit.jupiter.api.Test;
import edu.umb.cs680.hw09.fs.Directory;
import edu.umb.cs680.hw09.fs.File;
import edu.umb.cs680.hw09.fs.Link;

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
	public void testCrawlingVisitorRoot() {
		FileCrawlingVisitor v = new FileCrawlingVisitor();
		root.accept(v);
		LinkedList<File> actual = v.getFiles();
		File[] expected = {x,y,a,b,c};
		assertArrayEquals(expected, actual.toArray());
	}
	
	@Test
	public void testCrawlingVisitorApps() {
		FileCrawlingVisitor v = new FileCrawlingVisitor();
		apps.accept(v);
		LinkedList<File> actual = v.getFiles();
		File[] expected = {x};
		assertArrayEquals(expected, actual.toArray());
	}
	
	@Test
	public void testCrawlingVisitorBin() {
		FileCrawlingVisitor v = new FileCrawlingVisitor();
		bin.accept(v);
		LinkedList<File> actual = v.getFiles();
		File[] expected = {y};
		assertArrayEquals(expected, actual.toArray());
	}
	
	@Test
	public void testCrawlingVisitorHome() {
		FileCrawlingVisitor v = new FileCrawlingVisitor();
		home.accept(v);
		LinkedList<File> actual = v.getFiles();
		File[] expected = {a,b,c};
		assertArrayEquals(expected, actual.toArray());
	}
	
	@Test
	public void testCrawlingVisitorPictures() {
		FileCrawlingVisitor v = new FileCrawlingVisitor();
		pictures.accept(v);
		LinkedList<File> actual = v.getFiles();
		File[] expected = {a,b};
		assertArrayEquals(expected, actual.toArray());
	}

	

}
