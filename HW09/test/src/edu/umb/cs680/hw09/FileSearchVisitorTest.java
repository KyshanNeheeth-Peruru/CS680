package src.edu.umb.cs680.hw09;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;
import edu.umb.cs680.hw09.fs.Directory;
import edu.umb.cs680.hw09.fs.File;
import edu.umb.cs680.hw09.fs.util.FileSearchVisitor;

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
	public void testSearchFileX() {
		FileSearchVisitor v = new FileSearchVisitor("x");
		root.accept(v);
		assertSame(x, v.getFoundFiles().get(0));
	}
	
	@Test
	public void testSearchFileY() {
		FileSearchVisitor v = new FileSearchVisitor("y");
		root.accept(v);
		assertSame(y, v.getFoundFiles().get(0));
	}
	
	@Test
	public void testSearchFileZ() {
		FileSearchVisitor v = new FileSearchVisitor("z");
		root.accept(v);
		assertSame(z, v.getFoundFiles().get(0));
	}
	
	@Test
	public void testSearchFileA() {
		FileSearchVisitor v = new FileSearchVisitor("a");
		root.accept(v);
		assertSame(a, v.getFoundFiles().get(0));
	}
	
	@Test
	public void testSearchFileB() {
		FileSearchVisitor v = new FileSearchVisitor("b");
		root.accept(v);
		assertSame(b, v.getFoundFiles().get(0));
	}
	
	@Test
	public void testSearchFileC() {
		FileSearchVisitor v = new FileSearchVisitor("c");
		root.accept(v);
		assertSame(c, v.getFoundFiles().get(0));
	}
	
	@Test
	public void testSearchFileD() {
		FileSearchVisitor v = new FileSearchVisitor("d");
		root.accept(v);
		assertSame(d, v.getFoundFiles().get(0));
	}
	
	@Test
	public void testSearchFileABCD() {
		FileSearchVisitor v = new FileSearchVisitor("a");
		root.accept(v);
		v.setFileName("b");
		root.accept(v);
		v.setFileName("c");
		root.accept(v);
		v.setFileName("d");
		root.accept(v);
		LinkedList<File> actual = v.getFoundFiles();
		LinkedList<File> expected = new LinkedList<>();
		expected.add(a);
		expected.add(b);
		expected.add(c);
		expected.add(d);
		assertArrayEquals(expected.toArray(), actual.toArray());
	}
	

}
