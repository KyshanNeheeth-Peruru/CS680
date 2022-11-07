package edu.umb.cs680.hw05;

public interface State {
	SecurityContext ctx = SecurityContext.getInstance();
	void login(String pwd);
    void logout();
}
