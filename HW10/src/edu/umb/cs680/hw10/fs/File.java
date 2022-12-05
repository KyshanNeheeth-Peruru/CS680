package edu.umb.cs680.hw10.fs;

import java.time.LocalDateTime;

public class File extends FSElement {
	
	public File(Directory parent, String name, int size, LocalDateTime createdTime)
	{
		super(parent,name, size, createdTime);
		parent.appendChild(this);
	}

	public boolean isDirectory() {
		return false;
	}

	public boolean isFile() {
		return true;
	}

	public boolean isLink() {
		return false;
	}

	public void accept(FSVisitor v, SecurityContext ctx) {
		if(ctx.getState() instanceof LoggedIn)
		{
		v.visit(this);
		}
		else {
			System.out.println("Not logged In");
			return;
		}
	}

}
