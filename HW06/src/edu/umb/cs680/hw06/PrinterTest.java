package edu.umb.cs680.hw06;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class PrinterTest {
	@Test
    public void testingPrintABCwithoutloggingin() 
	{
	String pwd = "pwd";
	SecurityContext ctx = SecurityContext.getInstance();
	Printers ModelABC= new ModelABC();
	ModelABC.execute(pwd,ctx);
	}
	
	@Test
    public void testingPrintABCafterlogin() 
	{
	String pwd = "pwd";
	SecurityContext ctx = SecurityContext.getInstance();
	Printers ModelABC= new ModelABC();
	ctx.login(pwd);
	ModelABC.execute(pwd,ctx);
	}
	
	@Test
    public void testingPrinterXYZWithoutLogin() 
	{
	String pwd = "pwd";
	SecurityContext ctx = SecurityContext.getInstance();
	Printers ModelXYZ= new ModelXYZ();
	ctx.login(pwd);
	ModelXYZ.execute(pwd,ctx);
	}
	
	@Test
    public void testingPrinterXYZWithLogin() 
	{
	String pwd = "pwd";
	SecurityContext ctx = SecurityContext.getInstance();
	Printers ModelXYZ= new ModelXYZ();
	ctx.login(pwd);
	ModelXYZ.execute(pwd,ctx);
	}

}
