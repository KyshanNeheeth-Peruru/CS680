package edu.umb.cs680.hw07;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import edu.umb.cs680.hw07.Directory;
import edu.umb.cs680.hw07.FileSystem;

class FileSystemTest {
	
	LocalDateTime localTime = LocalDateTime.now();
	
	Directory root = new Directory(null, "root", 0, localTime);
	
	private String[] toStringArray(Directory dir) {
		String[] dirInfo = { null, dir.getName(), Integer.toString(dir.getSize()), dir.getCreationTime().toString() };
		return dirInfo;
	}
	
	@Test
	void checkFile() {
		FileSystem file1 = FileSystem.getFileSystem();
		FileSystem file2 = FileSystem.getFileSystem();
		assertSame(file1, file2);
	}

	@Test
	void checkRootDirectory() {
		String[] expected = { null, "root", "0", localTime.toString() };
		Directory actual = root;
		assertArrayEquals(expected, toStringArray(actual));
	}
}
