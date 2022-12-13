package edu.umb.cs680.hw15;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import org.junit.jupiter.api.Test;


class DirectoryTest {
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
	public void testGetChildren() {
		assertEquals(apps,root.getChildren().get(0));
		assertEquals(bin,root.getChildren().get(1));
		assertEquals(home,root.getChildren().get(2));
		assertEquals(pictures,home.getChildren().get(0));
		assertEquals(x,apps.getChildren().get(0));
		assertEquals(y,bin.getChildren().get(0));
		assertEquals(pictures,home.getChildren().get(0));
		assertEquals(c,home.getChildren().get(1));
		assertEquals(a,pictures.getChildren().get(0));
		assertEquals(b,pictures.getChildren().get(1));
		assertEquals(d,root.getChildren().get(3));
		assertEquals(e,root.getChildren().get(4));
	}
	
	@Test
	public void testCountChildren() {
		assertEquals(5,root.countChildren());
		assertEquals(1,apps.countChildren());
		assertEquals(1,bin.countChildren());
		assertEquals(2,home.countChildren());
		assertEquals(2,pictures.countChildren());
	}
	
	@Test
	public void testGetTotalSize() {
		assertEquals(14,root.getTotalSize());
		assertEquals(11,home.getTotalSize());
		assertEquals(7,pictures.getTotalSize());
		assertEquals(2,bin.getTotalSize());
		assertEquals(1,apps.getTotalSize());
	}
	
	@Test
	public void testGetSubDirectories() {
		assertSame("apps",root.getSubDirectories().get(0).getName());
		assertSame("bin",root.getSubDirectories().get(1).getName());
		assertSame("home",root.getSubDirectories().get(2).getName());
		assertSame("pictures",home.getSubDirectories().get(0).getName());
	}
	
	@Test
	public void testGetFiles() {
		assertSame("x",apps.getFiles().get(0).getName());
		assertSame("y",bin.getFiles().get(0).getName());
		assertSame("a",pictures.getFiles().get(0).getName());
		assertSame("b",pictures.getFiles().get(1).getName());
		assertSame("c",home.getFiles().get(0).getName());
	}
	
	@Test
	public void testGetLinks() {
		assertSame("d",root.getLinks().get(0).getName());
		assertSame("e",root.getLinks().get(1).getName());
	}
	
	@Test
	public void testAlphabeticalGetChildrenRoot() {
		Directory directory = root;
		LinkedList<FSElement> actual = directory.getChildren();
		Collections.sort(actual,(FSElement a, FSElement b) -> a.getName().compareTo(b.getName()));
		FSElement[] expected = {apps,bin,d,e,home};
		assertArrayEquals(expected, actual.toArray());
	}
	
	@Test
	public void testAlphabeticalGetChildrenHome() {
		Directory directory = home;
		LinkedList<FSElement> actual = directory.getChildren();
		Collections.sort(actual,Comparator.comparing((FSElement f) -> f.getName()));
		FSElement[] expected = {c,pictures};
		assertArrayEquals(expected, actual.toArray());
	}
	
	@Test
	public void testAlphabeticalGetSubDirectoriesRoot() {
		Directory directory = root;
		LinkedList<Directory> actual = directory.getSubDirectories();
		Collections.sort(actual, Comparator.comparing(Directory::getName));
		FSElement[] expected = {apps,bin,home};
		assertArrayEquals(expected, actual.toArray());
	}

}
