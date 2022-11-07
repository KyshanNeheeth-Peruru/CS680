package edu.umb.cs680.hw06;

abstract class Printers
{
	public boolean authenticate(String pwd) {
		return true;
	}
	public final void execute(String pwd,SecurityContext ctx)
	{
		doAuthentication(pwd);
		doAccessControl();
		doPrint(ctx);
		doErrorHandling();
	}
	public abstract void doAuthentication(String pwd);
	public abstract void doAccessControl();
	public abstract void doPrint(SecurityContext ctx);
	public abstract void doErrorHandling();
}


class ModelXYZ extends Printers 
{
	@Override
	public void doAuthentication(String pwd)
	{
		//System.out.println("XYZdoauth");
	}

	@Override
	public void doAccessControl() 
	{
		//System.out.println("XYZdoaccesscontrol");
	}

	@Override
	public void doPrint(SecurityContext ctx) 
	{
		if(ctx.getState()==LoggedOut.getInstance()) {
			//System.out.println("jobs terminated");
		}
		//System.out.println("XYZdoprint");
	}

	@Override
	public void doErrorHandling() 
	{
		//System.out.println("XYZdoerrhandle");
	}
}
	
class ModelABC extends Printers 
{
	@Override
	public void doAuthentication(String pwd)
	{
		//System.out.println("ABCdoauth");
		if(authenticate(pwd)) {
			System.out.println("Authenticated");
		}
	}

	@Override
	public void doAccessControl() 
	{
		//System.out.println("ABCdoaccesscontrol");
	}

	@Override
	public void doPrint(SecurityContext ctx) 
	{
		//System.out.println(ctx.getState());
		if(ctx.getState()==LoggedOut.getInstance()) {
			System.out.println("Not logged in, jobs terminated");
		}
	}

	@Override
	public void doErrorHandling() 
	{
		//System.out.println("ABCdoerrhandle");
	}
}


class Printer {
	public static void main(String[] args) 
	{
		String pwd = "pwd";
		SecurityContext ctx = SecurityContext.getInstance();
		Printers ModelXYZ= new ModelXYZ();
		//ModelXYZ.execute(pwd,ctx);
		Printers ModelABC= new ModelABC();
		//ModelABC.execute(pwd,ctx);
	}
}
