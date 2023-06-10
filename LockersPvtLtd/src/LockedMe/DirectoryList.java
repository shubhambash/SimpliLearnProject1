package LockedMe;
import java.util.Scanner;
import java.util.TreeMap;



public class DirectoryList implements CRUDInterface{
	
	
	// using a TreeMap with custom class FileStorage which implements Comparator interface
	TreeMap<FileStorage, Integer> fl;
	
	// styles class instance
	Styles style = new Styles();
	// list of options class instance
	OptionsList options = new OptionsList();
	// standard input class instance
	Scanner sc = new Scanner(System.in);
	//Input processor
	OptionProcessor processInputs = new OptionProcessor(); 
	
	// Constructor
	DirectoryList()
	{
		// assigning reference to the tree map instance
		fl = new TreeMap<FileStorage, Integer>(new DirectoryStoreComp());
		FileStorage f1 = new FileStorage(1,"zile1.txt", "text file", "This is my first text file");
		FileStorage f2 = new FileStorage(2,"yile1.txt", "text file", "This is my first text file");
		FileStorage f3 = new FileStorage(3, "file1.txt", "text file", "This is my first text file");
		
		fl.put(f1,  1);
		fl.put(f2, 2);
		fl.put(f3, 3);
		
		showDirectoryItems();			
		int userChoice = 0;
		
		while(userChoice != 4)
		{
			// create a separate function for processing options
			options.showOptions(2);		
			userChoice = processOptions();
		}
	}
	
			
	// functions displays all the files contained in the directory 
	@Override
	public void showDirectoryItems()
	{
		// show folder name here // right now its hard coded 
		System.out.println("----> root");
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
			
			FileStorage fileObject = new FileStorage(Math.random(), fileName, "text file" ,content);
			int id = (int) Math.random();
			fl.put(fileObject, id);
			
		} catch (Exception e) {
			System.out.println("An error occured ! ");
		}

	}

	@Override
	public void removeFile() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void searchFile() {
		// TODO Auto-generated method stub
		
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
			
			style.repeatLine(55);style.NSpaces(2);
			// displaying all directory items again
			showDirectoryItems();
			break;
		}
		case 2:{
			
			// calling the file input processor function with - remove attribute 
			FileStorage fileNameAndContentInput = processInputs.returnFileStorageObject("remove");
			
			// calling the remove file function
			removeFile();style.NSpaces(1);
			
			style.repeatLine(55);
			style.NSpaces(2);
			showDirectoryItems();
			break;
		}
		case 3:{
			
			break;
		}
		case 4:{
			
			break;
		}
		default:
		{
			
			break;
		}
		
		}
		
		return userChoice;
	}

	

}
