package LockedMe;

public class Styles {
	
	// styles
	
	void printStyle(String attribute)
	{
		System.out.print(attribute + " ");
	}
	
	void repeatLine(int length)
	{
		String line = "=".repeat(length);
		System.out.println(line);
	}
	
	void NSpaces(int length)
	{
		while(length-- > 0)System.out.println();
	}
	

}
