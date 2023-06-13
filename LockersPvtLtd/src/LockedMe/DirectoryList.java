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
	
	String path = "C:\\Users\\ASUS\\Desktop\\New Files";
	
	
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
		File[] listOfFiles = folder.listFiles();
		System.out.println("----> root");
		for (int i = 0; i < listOfFiles.length; i++) {
		  if (listOfFiles[i].isFile()) {
		    
//			  System.out.println("File " + listOfFiles[i].getName());
		    
			FileStorage fileObject = new FileStorage(Math.random(), listOfFiles[i].getName(), "text file" ,"content");
			  
			fl.put(fileObject, listOfFiles[i].getName());
			hashmap.put(listOfFiles[i].getName(), fileObject);
		  } else if (listOfFiles[i].isDirectory()) {
		    System.out.println("Directory " + listOfFiles[i].getName());
		  }
		}
		
		
		
		
		
		
		
		// show folder name here // right now its hard coded 
		
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
			
			File myObj = new File(path + "\\" + fileName);
			
			 if (myObj.createNewFile()) {
			     
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
		int userChoice = sc.nextInt();
		
		switch (userChoice) {
		case 1: {
			
			// calling the file input processor function with - add attribute 
			FileStorage fileNameAndContentInput = processInputs.returnFileStorageObject("add");
			// calling the add file function
			addFile(fileNameAndContentInput.fileName, fileNameAndContentInput.fileContent);style.NSpaces(1);
			
			style.repeatLine(60);style.NSpaces(2);
			// displaying all directory items again
			showDirectoryItems();
			break;
		}
		case 2:{
			
			// calling the file input processor function with - remove attribute 
			FileStorage fileNameAndContentInput = processInputs.returnFileStorageObject("remove");
			
			// calling the remove file function
			removeFile(fileNameAndContentInput.fileName);style.NSpaces(1);
			
			style.repeatLine(60);
			style.NSpaces(2);
			showDirectoryItems();
			break;
		}
		case 3:{
			
			FileStorage fileNameAndContentInput = processInputs.returnFileStorageObject("remove");
			searchFile(fileNameAndContentInput.fileName);
			break;
		}
		case 4:{
			
			break;
		}
		default:
		{
			System.out.println("Some Error Occured !");
			break;
		}
		
		}
		
		return userChoice;
	}

	

}
