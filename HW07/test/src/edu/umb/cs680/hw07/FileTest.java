package src.edu.umb.cs680.hw07;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import edu.umb.cs680.hw07.Directory;
import edu.umb.cs680.hw07.File;

class FileTest {

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
	
	private String[] dirToStringArray(Directory dir)
	{
		String parentName = null;
		Directory parent = dir.getParent();
		if (parent != null) {
			parentName = parent.getName();
		}
		String[] dirInfo = {dir.getName(), Integer.toString(dir.getSize()),parentName};
		return dirInfo;
	}
	
	private String[] fileToStringArray(File f)
	{
		String parentName = null;
		Directory parent = f.getParent();
		if (parent != null) {
			parentName = parent.getName();
		}
		String[] dirInfo = {f.getName(), Integer.toString(f.getSize()),parentName};
		return dirInfo;
	}
	
	@Test
	public void testEqualityCheckDirectoryUsingGetterMethod() {
		assertTrue(root.isDirectory());
		assertTrue(apps.isDirectory());
		assertTrue(lib.isDirectory());
		assertTrue(home.isDirectory());
		assertTrue(code.isDirectory());
		assertFalse(x.isDirectory());
		assertFalse(y.isDirectory());
		assertFalse(z.isDirectory());
		assertFalse(a.isDirectory());
		assertFalse(b.isDirectory());
		assertFalse(c.isDirectory());
		assertFalse(d.isDirectory());
	}
	
	@Test
	public void testEqualityCheckFileUsingGetterMethod() {
		assertFalse(root.isFile());
		assertFalse(apps.isFile());
		assertFalse(lib.isFile());
		assertFalse(home.isFile());
		assertFalse(code.isFile());
		assertTrue(x.isFile());
		assertTrue(y.isFile());
		assertTrue(z.isFile());
		assertTrue(a.isFile());
		assertTrue(b.isFile());
		assertTrue(c.isFile());
		assertTrue(d.isFile());
	}
	
	@Test
	public void testDirectoryEqualityCheck() {
		String[] expected1 = { "root","0",null };
		Directory actual1 = root;
		assertArrayEquals(expected1, dirToStringArray(actual1));
		String[] expected2 = { "apps","0","root" };
		Directory actual2 = apps;
		assertArrayEquals(expected2, dirToStringArray(actual2));
		String[] expected3 = { "lib","0","root" };
		Directory actual3 = lib;
		assertArrayEquals(expected3, dirToStringArray(actual3));
		String[] expected4 = { "home","0","root" };
		Directory actual4 = home;
		assertArrayEquals(expected4, dirToStringArray(actual4));
		String[] expected5 = { "code","0","home" };
		Directory actual5 = code;
		assertArrayEquals(expected5, dirToStringArray(actual5));
	}
	
	@Test
	public void testFileEqualityCheck() {
		String[] expected1 = {"x","1","apps"};
		File actual1 = x;
		assertArrayEquals(expected1, fileToStringArray(actual1));
		String[] expected2 = {"y","2","apps"};
		File actual2 = y;
		assertArrayEquals(expected2, fileToStringArray(actual2));
		String[] expected3 = {"z","3","lib"};
		File actual3 = z;
		assertArrayEquals(expected3, fileToStringArray(actual3));
		String[] expected4 = {"a","4","code"};
		File actual4 = a;
		assertArrayEquals(expected4, fileToStringArray(actual4));
		String[] expected5 = {"b","5","code"};
		File actual5 = b;
		assertArrayEquals(expected5, fileToStringArray(actual5));
		String[] expected6 = {"c","6","code"};
		File actual6 = c;
		assertArrayEquals(expected6, fileToStringArray(actual6));
		String[] expected7 = {"d","7","home"};
		File actual7 = d;
		assertArrayEquals(expected7, fileToStringArray(actual7));
	}
}
