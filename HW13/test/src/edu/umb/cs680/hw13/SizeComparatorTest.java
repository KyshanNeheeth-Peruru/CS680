package edu.umb.cs680.hw13;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import org.junit.jupiter.api.Test;
import edu.umb.cs680.hw13.Directory;
import edu.umb.cs680.hw13.FSElement;
import edu.umb.cs680.hw13.File;
import edu.umb.cs680.hw13.Link;
import edu.umb.cs680.hw13.SizeComparator;

class SizeComparatorTest {
	static LocalDateTime localTime = LocalDateTime.now();
	
	Directory root = new Directory(null, "root", 1, localTime);
	Directory apps = new Directory(root, "apps", 7, localTime);
	Directory bin = new Directory(root, "bin", 9, localTime);
	Directory home = new Directory(root, "home", 12, localTime);
	Directory pictures = new Directory(home, "pictures", 11, localTime);
	
	File x = new File(apps, "x", 6, localTime);
	File y = new File(bin, "y", 5, localTime);
	File a = new File(pictures, "a", 3, localTime);
	File b = new File(pictures, "b", 4, localTime);
	File c = new File(home, "c", 2, localTime);
	
	Link d = new Link(root, "d", 8, localTime, pictures);
	Link e = new Link(root, "e", 10, localTime, x);
	
	@Test
	public void testGetChildrenRoot() {
		Directory directory = root;
		LinkedList<FSElement> actual = directory.getChildren(new SizeComparator());
		FSElement[] expected = {apps,d,bin,e,home};
		assertArrayEquals(expected, actual.toArray());
	}
	
	@Test
	public void testGetChildrenHome() {
		Directory directory = home;
		LinkedList<FSElement> actual = directory.getChildren(new SizeComparator());
		FSElement[] expected = {c,pictures};
		assertArrayEquals(expected, actual.toArray());
	}
	
	@Test
	public void testGetSubDirectoriesRoot() {
		Directory directory = root;
		LinkedList<Directory> actual = directory.getSubDirectories(new SizeComparator());
		FSElement[] expected = {apps,bin,home};
		assertArrayEquals(expected, actual.toArray());
	}
	
	@Test
	public void testGetSubDirectoriesHome() {
		Directory directory = home;
		LinkedList<Directory> actual = directory.getSubDirectories(new SizeComparator());
		FSElement[] expected = {pictures};
		assertArrayEquals(expected, actual.toArray());
	}
	
	@Test
	public void testGetFilesPictures() {
		Directory directory = pictures;
		LinkedList<File> actual = directory.getFiles(new SizeComparator());
		FSElement[] expected = {a,b};
		assertArrayEquals(expected, actual.toArray());
	}
	
	@Test
	public void testGetLinksRoot() {
		Directory directory = root;
		LinkedList<Link> actual = directory.getLinks(new SizeComparator());
		FSElement[] expected = {d,e};
		assertArrayEquals(expected, actual.toArray());
	}

}
