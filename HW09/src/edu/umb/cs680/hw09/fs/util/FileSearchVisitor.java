package edu.umb.cs680.hw09.fs.util;

import edu.umb.cs680.hw09.fs.FSVisitor;

import java.util.LinkedList;

import edu.umb.cs680.hw09.fs.Directory;
import edu.umb.cs680.hw09.fs.File;
import edu.umb.cs680.hw09.fs.Link;

public class FileSearchVisitor implements FSVisitor {
	private String fileName;
	private LinkedList<File> foundFiles;
	
	public FileSearchVisitor(String fileName) {
		foundFiles = new LinkedList<>();
		this.fileName = fileName;
	}
	
	public void visit(Directory dir) {
		return;
	}
	
	public void visit(Link link) {
		return;
	}

	public void visit(File file) {
		if(file.getName().equals(fileName)) {
			foundFiles.add(file);
		}
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public LinkedList<File> getFoundFiles() {
		return foundFiles;
	}
}
