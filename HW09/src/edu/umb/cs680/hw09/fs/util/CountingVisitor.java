package edu.umb.cs680.hw09.fs.util;

import edu.umb.cs680.hw09.fs.FSVisitor;
import edu.umb.cs680.hw09.fs.Directory;
import edu.umb.cs680.hw09.fs.File;
import edu.umb.cs680.hw09.fs.Link;

public class CountingVisitor implements FSVisitor {
	private int dirNumber = 0;
	private int fileNumber = 0;
	private int linkNumber = 0;
	
	public int getDirNumber() {
		return dirNumber;
	}
	public int getFileNumber() {
		return fileNumber;
	}
	public int getLinkNumber() {
		return linkNumber;
	}
	public void visit(Directory dir) {
		dirNumber++;
	}
	public void visit(File file) {
		fileNumber++;
	}
	public void visit(Link link) {
		linkNumber++;
	}

}
