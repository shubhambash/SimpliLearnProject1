package LockedMe;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class OptionProcessor {

	private static final Pattern INVALID = Pattern.compile("[^a-zA-Z0-9_.]");
	Styles style = new Styles();
	
	
    public static boolean isValidFileName(String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            return false;
        }
        Matcher matcher = INVALID.matcher(fileName);
        return !matcher.find();
    }
	
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
			if(!isValidFileName(fileName))
			{
				fileName = null;
				
			}
			else
			{
				System.out.print("Enter File content : ");style.printStyle(">");
				content = sc.next();style.NSpaces(1);
			}

		}
		else if(operationType == "remove")
		{
			System.out.println("Enter File Name : ");style.printStyle(">");	
			fileName = sc.next();style.NSpaces(1);
			if(!isValidFileName(fileName))
			{
				fileName = null;
				
			}
			style.NSpaces(1);
		}
		else if(operationType == "search")
		{
			System.out.println("Enter File Name : ");style.printStyle(">");	
			fileName = sc.next();style.NSpaces(1);
			if(!isValidFileName(fileName))
			{
				fileName = null;
				
			}
			style.NSpaces(1);
		}
		
		
		FileStorage fs = new FileStorage(Math.random(), fileName, "text file" ,content);
		
		return fs;
	}
	
}








