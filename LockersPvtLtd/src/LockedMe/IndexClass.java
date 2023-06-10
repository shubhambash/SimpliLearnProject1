package LockedMe;

import java.util.Scanner;

class OptionsList{
	
	
	
	void showOptions(int level)
	{
		System.out.println("Please Select The Appropriate Option");
		System.out.println("OPTIONS : ");
		if(level == 1) {
			System.out.println("1) Open Directory List");
			System.out.println("2) Exit Program");
		
		}
		else if(level == 2) {
			System.out.println("1) Add File to Directory List");
			System.out.println("2) Remove File From Directory List");
			System.out.println("3) Search File In Directory List");
			System.out.println("4) Go Back To Main Menu");
		}
		else System.out.println("Some Error Has Occured !");
	}
}

public class IndexClass {
	
	public static void main(String[] args) {
		
		// show welcome screen
		
		MainMenu mainmenu = new MainMenu();
		
		// show options
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
