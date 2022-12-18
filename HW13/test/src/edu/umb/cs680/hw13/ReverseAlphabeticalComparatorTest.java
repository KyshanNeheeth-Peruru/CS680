package edu.umb.cs680.hw13;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import org.junit.jupiter.api.Test;
import edu.umb.cs680.hw13.Directory;
import edu.umb.cs680.hw13.FSElement;
import edu.umb.cs680.hw13.File;
import edu.umb.cs680.hw13.Link;
import edu.umb.cs680.hw13.ReverseAlphabeticalComparator;

class ReverseAlphabeticalComparatorTest {
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
	public void testGetChildrenRoot() {
		Directory directory = root;
		LinkedList<FSElement> actual = directory.getChildren(new ReverseAlphabeticalComparator());
		FSElement[] expected = {home,e,d,bin,apps};
		assertArrayEquals(expected, actual.toArray());
	}
	
	@Test
	public void testGetChildrenHome() {
		Directory directory = home;
		LinkedList<FSElement> actual = directory.getChildren(new ReverseAlphabeticalComparator());
		FSElement[] expected = {pictures,c};
		assertArrayEquals(expected, actual.toArray());
	}
	
	@Test
	public void testGetSubDirectoriesRoot() {
		Directory directory = root;
		LinkedList<Directory> actual = directory.getSubDirectories(new ReverseAlphabeticalComparator());
		FSElement[] expected = {home,bin,apps};
		assertArrayEquals(expected, actual.toArray());
	}
	
	@Test
	public void testGetSubDirectoriesHome() {
		Directory directory = home;
		LinkedList<Directory> actual = directory.getSubDirectories(new ReverseAlphabeticalComparator());
		FSElement[] expected = {pictures};
		assertArrayEquals(expected, actual.toArray());
	}
	
	@Test
	public void testGetFilesPictures() {
		Directory directory = pictures;
		LinkedList<File> actual = directory.getFiles(new ReverseAlphabeticalComparator());
		FSElement[] expected = {b,a};
		assertArrayEquals(expected, actual.toArray());
	}
	
	@Test
	public void testGetLinksRoot() {
		Directory directory = root;
		LinkedList<Link> actual = directory.getLinks(new ReverseAlphabeticalComparator());
		FSElement[] expected = {e,d};
		assertArrayEquals(expected, actual.toArray());
	}

}
