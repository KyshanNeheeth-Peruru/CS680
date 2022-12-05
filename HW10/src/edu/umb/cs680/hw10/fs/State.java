package edu.umb.cs680.hw10.fs;

public interface State {
	SecurityContext ctx = SecurityContext.getInstance();
	void login(String pwd);
    void logout();
}
