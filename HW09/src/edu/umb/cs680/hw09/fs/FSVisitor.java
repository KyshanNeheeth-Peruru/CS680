package edu.umb.cs680.hw09.fs;

public interface FSVisitor {
	public void visit(Directory d);
	public void visit(File f);
	public void visit(Link l);
}
