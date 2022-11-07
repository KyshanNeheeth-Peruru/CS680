package edu.umb.cs680.hw06;

public class LoggedIn implements State {
	private static LoggedIn instance = null;
	
	public static LoggedIn getInstance() {
		if(instance == null) {
			instance = new LoggedIn();
		}
		return instance;
	}
	
	public boolean isActive() {
		return true;
	}
	
	public void logout() {
		ctx.changeState(LoggedOut.getInstance());
	}
	
	public void login(String pwd) {
		if(isActive()) 
		{
			//do nothing
		}
		else 
		{
			ctx.changeState(LoggedOut.getInstance());
			//ctx.login(pwd);
		}
		
	}
	

}
