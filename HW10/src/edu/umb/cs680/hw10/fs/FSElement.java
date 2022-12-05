package edu.umb.cs680.hw10.fs;

import java.time.LocalDateTime;

public abstract class FSElement {
	private String name;
	private int size;
	private LocalDateTime creationTime;
	private Directory parent;
	
	public abstract boolean isDirectory();
	public abstract boolean isFile();
	public abstract boolean isLink();
	public abstract void accept(FSVisitor v, SecurityContext ctx);
	
	public FSElement(Directory parent, String name, int size, LocalDateTime creationTime)
	{
		this.parent = parent;
		this.name = name;
		this.size = size;
		this.creationTime = creationTime;
	}
	
	public Directory getParent() {
		return parent;
	}

	public void setParent(Directory parent) {
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public LocalDateTime getCreationTime() {
		return creationTime;
	}
}
