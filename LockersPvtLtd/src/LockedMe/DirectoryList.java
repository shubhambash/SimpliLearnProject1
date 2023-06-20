package LockedMe;
import java.io.File;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;



public class DirectoryList implements CRUDInterface{
	
	
	// using a TreeMap with custom class FileStorage which implements Comparator interface
	TreeMap<FileStorage, String> fl;
	// using hash map to reduce remove operation time complexity
	HashMap<String, FileStorage> hashmap; 
 	// styles class instance
	Styles style = new Styles();
	// list of options class instance
	OptionsList options = new OptionsList();
	// standard input class instance
	Scanner sc = new Scanner(System.in);
	//Input processor
	OptionProcessor processInputs = new OptionProcessor(); 
	// Dummy Folder path used as a constant here. In real application a user will set the actual path or configure the database url
	private String path = "C:\\Users\\ASUS\\Desktop\\New Files";
	
	
	// Constructor
	DirectoryList()
	{
		// assigning reference to the tree map instance
		fl = new TreeMap<FileStorage, String>(new DirectoryStoreComp());
		hashmap = new HashMap<>();

		showDirectoryItems();			
		int userChoice = 0;
		
		while(userChoice != 4)
		{
			// create a separate function for processing options
			options.showOptions(2);		
			userChoice = processOptions();
		}
		
		MainMenu menu = new MainMenu();		
	}
	
			
	// functions displays all the files contained in the directory 
	@Override
	public void showDirectoryItems()
	{
		
		
		File folder = new File(path);
		
		// retrieve the files from the directory and store in an array
		File[] listOfFiles = folder.listFiles();
		System.out.println("----> root");
		
		
		for (int i = 0; i < listOfFiles.length; i++) {
		  if (listOfFiles[i].isFile()) {
		    
			FileStorage fileObject = new FileStorage(Math.random(), listOfFiles[i].getName(), "text file" ,"content");
			  
			fl.put(fileObject, listOfFiles[i].getName());
			hashmap.put(listOfFiles[i].getName(), fileObject);
		  } else if (listOfFiles[i].isDirectory()) {
		    System.out.println("Directory " + listOfFiles[i].getName());
		  }
		}
		

		// shows the available files in ascending order of their names 
		
		for(FileStorage item : fl.keySet())
		{
			style.printStyle("  |");System.out.println();
			style.printStyle("   -->");System.out.println(item.fileName);
		}
		style.NSpaces(2);
	}
	
	@Override
	public void addFile(String fileName, String content)
	{
		try {
			// Add file is not case sensitive
			fileName = fileName.toLowerCase();
			File myObj = new File(path + "\\" + fileName);
			
			 if (myObj.createNewFile()) {
			        
			        System.out.println(fileName);
					FileStorage fileObject = new FileStorage(Math.random(), fileName, "text file" ,"content");
					fl.put(fileObject, fileName);
					hashmap.put(fileName, fileObject);
				 	style.NSpaces(1);
				 	System.out.println("File Created !");
				 	style.NSpaces(1);
				 
			      } else {
			        System.out.println("File already exists.");
			      }
			
			
		} catch (Exception e) {
			System.out.println("An error occured ! ");
		}

	}

	@Override
	public void removeFile(String fileName) {
		try {
		
			File fileObject = new File(path + "\\" + fileName);
			
			  if (fileObject.delete()) {
				  
				  	fl.remove(hashmap.get(fileName));
				  	hashmap.remove(fileName);
				  	
		            System.out.println("File deleted successfully");
		        
			  }
		      else {
		    	  
		            System.out.println("Failed to delete the file. File Not Found !");
		        
		      }
			
			
		} catch (Exception e) {
			System.out.println("File Not Found ! Please Enter Correct Name (Case Sensitive)");
		}
		
	}


	@Override
	public void searchFile(String fileName) {
		
		if(hashmap.containsKey(fileName))
		{
			System.out.println("File Found!");
			style.NSpaces(2);
			style.repeatLine(60);
			
			System.out.println(fileName);
			style.NSpaces(2);
			System.out.println(hashmap.get(fileName).fileContent);
			style.repeatLine(60);
			style.NSpaces(2);
			
		}
		else
		{
			System.out.println("File Not Found! (Enter correct file name - case sensitive)");
	
			style.NSpaces(2);
		}
	
		
	}
	
	//process options
	int processOptions()
	{
		style.printStyle(">");
		int userChoice = 0;
		try {
			userChoice = sc.nextInt();
		} catch (Exception e) {
			userChoice = 0;
			sc.nextLine();
		}
		
		
		
		switch (userChoice) {
		case 1: {
			
			// calling the file input processor function with - add attribute 
			FileStorage fileNameAndContentInput = processInputs.returnFileStorageObject("add");
			// calling the add file function
			
			if(fileNameAndContentInput.fileName == null)
			{
				throwInvalidNameError();
				break;
			}
			
			addFile(fileNameAndContentInput.fileName, fileNameAndContentInput.fileContent);style.NSpaces(1);
			
			style.repeatLine(60);style.NSpaces(2);
			// displaying all directory items again
			showDirectoryItems();
			break;
		}
		case 2:{
			
			// calling the file input processor function with - remove attribute 
			FileStorage fileNameAndContentInput = processInputs.returnFileStorageObject("remove");
			if(fileNameAndContentInput.fileName == null)
			{
				throwInvalidNameError();
				break;
			}
			// calling the remove file function
			removeFile(fileNameAndContentInput.fileName);style.NSpaces(1);
			
			style.repeatLine(60);
			style.NSpaces(2);
			showDirectoryItems();
			break;
		}
		case 3:{
			
			FileStorage fileNameAndContentInput = processInputs.returnFileStorageObject("remove");
			
			if(fileNameAndContentInput.fileName == null)
			{
				throwInvalidNameError();
				break;
			}
			
			searchFile(fileNameAndContentInput.fileName);
			break;
		}
		case 4:{
			
			break;
		}
		default:
		{
			style.NSpaces(2);
			System.out.println("Invalid Option Entered!");
			style.NSpaces(1);
			break;
		}
		
		}
		
		return userChoice;
	}
	
	
	private void throwInvalidNameError()
	{
		style.NSpaces(2);
		System.out.println("Please Enter a Valid File Name!");
		style.NSpaces(1);
	}

	

}
