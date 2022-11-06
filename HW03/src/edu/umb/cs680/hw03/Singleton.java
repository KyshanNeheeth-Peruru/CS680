package edu.umb.cs680.hw03;

public class Singleton {
	private static Singleton instance;
	public String value1;
	private Singleton(String value)
	{
		this.value1=value;
	}
	public static Singleton getInstance(String value)
	{
		if(instance == null)
		{
			instance = new Singleton(value);
		}
		return instance;
	}
}
