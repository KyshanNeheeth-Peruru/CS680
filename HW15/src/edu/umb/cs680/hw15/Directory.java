package edu.umb.cs680.hw15;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Directory extends FSElement {
	
	private LinkedList<FSElement> children = new LinkedList<FSElement>();
	private LinkedList<File> fileList = new LinkedList<File>();
	private LinkedList<Directory> directoryList = new LinkedList<Directory>();
	private LinkedList<Link> linkList = new LinkedList<Link>();
	
	public Directory(Directory parent, String name, int size, LocalDateTime createdTime)
	{
		super(parent, name, size, createdTime);
		if (parent != null)
			parent.appendChild(this);
	}
	
	public LinkedList<FSElement> getChildren()
	{
		return children;
	}
	
	public void appendChild(FSElement child)
	{
		this.children.add(child);
		child.setParent(this);
	}
	
	public int countChildren()
	{
		return getChildren().size();
	}
		
	public LinkedList<Directory> getSubDirectories()
	{
		for (FSElement e : getChildren()) {
			if (e instanceof Directory)
				directoryList.add((Directory) e);
		}
		return directoryList;
	}
	
	public LinkedList<File> getFiles()
	{
		for (FSElement e : getChildren()) {
			if (e instanceof File) {
				fileList.add((File) e);
			}
		}
		return fileList;
	}
	
	public LinkedList<Link> getLinks()
	{
		for(FSElement element : getChildren())
		{
			if(element.isLink())
			{
				linkList.add((Link) element);
			}
		}
		return linkList;
	}

	public int getTotalSize()
	{
		int totalSize = 0;
		for (FSElement e : getChildren()) {
			if (e instanceof Directory)
				totalSize += ((Directory) e).getTotalSize();
			else
				totalSize += e.getSize();
		}
		return totalSize;
	}
	
	public boolean isDirectory()
	{
		return true;
	}
	
	public  boolean isFile()
	{
		return false;
	}
	
	public boolean isLink()
	{
		return false;
	}
}
