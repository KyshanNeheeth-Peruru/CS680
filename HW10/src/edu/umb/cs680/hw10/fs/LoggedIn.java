package edu.umb.cs680.hw10.fs;

public class LoggedIn implements State {
	int count=1;
	private static LoggedIn instance = null;
	
	public static LoggedIn getInstance() {
		if(instance == null) {
			instance = new LoggedIn();
		}
		return instance;
	}
	
	public boolean isActive() {
		if(this.count==1) 
		{
			this.count=2;
			return true;
		}
		else {
			return false;
		}
	}
	
	public void logout() {
		ctx.changeState(LoggedOut.getInstance());
	}
	
	public void login(String pwd) {
		//System.out.println("b4 checking active:"+this.count);
		if(isActive()) 
		{
			this.count=2;
			//do nothing
		}
		else 
		{
			//System.out.println("came to inactive");
			ctx.changeState(LoggedOut.getInstance());
			ctx.login(pwd);
		}	
	}
}
