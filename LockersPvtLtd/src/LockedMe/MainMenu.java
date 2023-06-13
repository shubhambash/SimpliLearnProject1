package LockedMe;

import java.util.Scanner;

public class MainMenu {

	MainMenu()
	{
		
		
		Styles st = new Styles();
		st.NSpaces(1);
		st.repeatLine(55);
		st.NSpaces(1);
		
		System.out.println("Welcome to LockedMe.com - a project of Lockers Pvt. Ltd.");
		st.NSpaces(1);
		st.repeatLine(55);
		st.NSpaces(1);
		System.out.println("This project was developed by Mr. Shubham Kumar");
		st.NSpaces(1);
		st.repeatLine(55);
		
		
		
		
		
		Styles style = new Styles();
		
		style.NSpaces(1);
		System.out.println("Select The Option Below : ");
		style.NSpaces(1);
		
		OptionsList op = new OptionsList();
		op.showOptions(1);
		
		Scanner sc = new Scanner(System.in);
		style.printStyle(">");
		int optionLevelOne = sc.nextInt();
		
		switch(optionLevelOne) {
		case 1:{
			// open directory list
			style.NSpaces(2);
			DirectoryList dl = new DirectoryList();
			break;
		}
		case 2:
		{
			//exit program
			style.repeatLine(55);
			System.out.println("Thank you for using LockedMe.com - see you next time !");
			style.repeatLine(55);
			break;
		}
		default:{
			op.showOptions(1);
			break;
		}
		
		}
		
	}
	
	  
	
}
