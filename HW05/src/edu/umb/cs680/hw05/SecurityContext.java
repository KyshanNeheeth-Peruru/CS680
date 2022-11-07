package edu.umb.cs680.hw05;

public class SecurityContext {
	private static SecurityContext instance = null;
	private static State state;
	private SecurityContext(State s) {
		state = s;
	}
	
	public static SecurityContext getInstance() {
		if (instance == null)
		{
			State s = LoggedOut.getInstance();
			instance = new SecurityContext(s);
		}
		return instance;
	}
	
	public void changeState(State s)
	{
		state =s;
	}
	
	public Object getState() {
		 return state;
	}
	
	public void login(String pwd) {
		state.login(pwd);
	}
	
	public void logout() {
		state.logout();
	}

}
