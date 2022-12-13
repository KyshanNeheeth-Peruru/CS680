package edu.umb.cs680.hw13;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.LinkedList;


import org.junit.jupiter.api.Test;

class TimeStampComparatorTest {
	Directory root = new Directory(null, "root", 1, LocalDateTime.now());
	Directory apps = new Directory(root, "apps", 7, LocalDateTime.now());
	Directory bin = new Directory(root, "bin", 9, LocalDateTime.now());
	Directory home = new Directory(root, "home", 12, LocalDateTime.now());
	Directory pictures = new Directory(home, "pictures", 11, LocalDateTime.now());
	
	File x = new File(apps, "x", 6, LocalDateTime.now());
	File y = new File(bin, "y", 5, LocalDateTime.now());
	File a = new File(pictures, "a", 3, LocalDateTime.now());
	File b = new File(pictures, "b", 4, LocalDateTime.now());
	File c = new File(home, "c", 2, LocalDateTime.now());
	Link d = new Link(root, "d", 8, LocalDateTime.now(), pictures);
	Link e = new Link(root, "e", 10, LocalDateTime.now(), x);
	
	@Test
	public void testGetChildrenRoot() {
		Directory directory = root;
		LinkedList<FSElement> actual = directory.getChildren(new TimeStampComparator());
		FSElement[] expected = {apps,bin,home,d,e};
		assertArrayEquals(expected, actual.toArray());
	}
	
	@Test
	public void testGetChildrenHome() {
		Directory directory = home;
		LinkedList<FSElement> actual = directory.getChildren(new TimeStampComparator());
		FSElement[] expected = {pictures,c};
		assertArrayEquals(expected, actual.toArray());
	}
	
	@Test
	public void testGetSubDirectoriesRoot() {
		Directory directory = root;
		LinkedList<Directory> actual = directory.getSubDirectories(new TimeStampComparator());
		FSElement[] expected = {apps,bin,home};
		assertArrayEquals(expected, actual.toArray());
	}
	
	@Test
	public void testGetSubDirectoriesHome() {
		Directory directory = home;
		LinkedList<Directory> actual = directory.getSubDirectories(new TimeStampComparator());
		FSElement[] expected = {pictures};
		assertArrayEquals(expected, actual.toArray());
	}
	
	@Test
	public void testGetFilesPictures() {
		Directory directory = pictures;
		LinkedList<File> actual = directory.getFiles(new TimeStampComparator());
		FSElement[] expected = {a,b};
		assertArrayEquals(expected, actual.toArray());
	}
	
	@Test
	public void testGetLinksRoot() {
		Directory directory = root;
		LinkedList<Link> actual = directory.getLinks(new TimeStampComparator());
		FSElement[] expected = {d,e};
		assertArrayEquals(expected, actual.toArray());
	}

}
