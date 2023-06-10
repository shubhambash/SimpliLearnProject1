package LockedMe;

import java.util.Scanner;

public class OptionProcessor {

	Styles style = new Styles();
	FileStorage returnFileStorageObject(String operationType)
	{
		Scanner sc = new Scanner(System.in);
		String fileName = "";
		String content = "";
		
		style.NSpaces(1);
		
		if(operationType == "add")
		{
			System.out.println("Enter File Name : ");style.printStyle(">");	
			fileName = sc.next();style.NSpaces(1);
			System.out.print("Enter File content : ");style.printStyle(">");
			content = sc.next();style.NSpaces(1);
		}
		else if(operationType == "remove")
		{
			System.out.println("Enter File Name : ");style.printStyle(">");	
			fileName = sc.next();style.NSpaces(1);
			style.NSpaces(1);
		}
		else if(operationType == "search")
		{
			System.out.println("Enter File Name : ");style.printStyle(">");	
			fileName = sc.next();style.NSpaces(1);
			style.NSpaces(1);
		}
		
		FileStorage fs = new FileStorage(Math.random(), fileName, "text file" ,content);
		
		return fs;
	}
	
}
