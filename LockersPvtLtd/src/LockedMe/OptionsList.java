package LockedMe;


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