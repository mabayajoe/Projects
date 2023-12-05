package RealEstate;

import java.util.Scanner;

public class REO {
	
	static Listings reoListings = new Listings();
	Scanner sIn = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		
		Scanner sIn = new Scanner(System.in);
		String option;
		
		
		boolean closed = false;
        while(!closed){
        	
        	System.out.println("--------------------------------------------");
			System.out.println("                  Main Menu");
			System.out.println("--------------------------------------------");
        	
        	System.out.println("\n1: Listing");
            System.out.println("2: Bids");
            System.out.println("\n\nWhat would you like to do? (1-2): ");
            option = sIn.nextLine();           
            
            if (option.equals("")){
            	closed = false;
            } else {
            	switch(option) {
            	
	            	case "1":
	            		listing();
	            		break;
	            	case "2":
	            		bids();
	            		break;
	            	default:
	            		System.out.println("Invalid response");
	            		break;
            	}
            }
        }
	}

	

	private static void listing() {
		Scanner sIn = new Scanner(System.in);
		boolean listing = false;
		while(!listing) {
			
			System.out.println("--------------------------------------------");
			System.out.println("              Listing Menu");
			System.out.println("--------------------------------------------");
			
			System.out.println("\n1: Add Listings" + "\n2: Show Listings" + 
				"\n3: Auto Populate Listings (Dev tool)" + "\nENTER: Exit back to the previos menu" +
				"\n\nWhat would you like to do? (1-3):");
			String lis = sIn.nextLine();
			
			switch(lis) {
			case "1":
				addListing();
				break;
			case "2":
				System.out.println("Current Listings for REO:");
				showListing();
				break;
			case "3":
				autoPopulate();
				break;
			case "":
				listing = true;				
			}
		}
	}
	
	



	private static void addListing() {
		Scanner sIn = new Scanner(System.in);
		boolean addListing = false;
		while(!addListing) {
			System.out.println("--------------------------------------------");
			System.out.println("              Add Listing Menu");
			System.out.println("--------------------------------------------");
			
			System.out.println("\n1: Add House" + "\n2: Add Condo" + 
					"\nENTER: Exit back to the previos menu" +
					"\n\nWhat would you like to do? (1-2):");
			String adLis = sIn.nextLine();
			switch(adLis) {
			case "1":
				Residence(sIn, "House");
				break;
			case "2":
				Residence(sIn, "Condo");
				break;
			case "":
				addListing = true;		
			}
		}
	}

	private static void Residence(Scanner sIn, String residenceType) {
		double appraisal;
		double listPrice;	
		
		
		System.out.println("Please enter the street address for the residence: ");
			String StreetAddress = sIn.nextLine();
		System.out.println("Please enter the zip code for the residence:  ");
			int zip = validationInt(sIn, "Error. Please type numbers.");
		System.out.println("Please enter the number of bedrooms: ");
			int bedCount = validationInt(sIn, "Error. Please type numbers.");
		System.out.println("Please enter the number of bathrooms:");
			double badCount = validationDouble(sIn,"Error. Please type numbers." );
		System.out.println("Please enter the square footage of the residence:");
			int sqFoot = validationInt(sIn, "Error. Please type numbers.");
		
		
	
		if(residenceType.equalsIgnoreCase("House")) {
			int zIp = Integer.valueOf(zip);
			
			System.out.println("Please enter the size of the yard in acres: ");
				double yardAcres = validationDouble(sIn,"Error. Please type numbers." );
			
			House residence = new House(StreetAddress, zIp, bedCount, badCount, sqFoot, yardAcres, zIp, yardAcres);
			
			appraisal = residence.calculateAppraisalPrice();
			System.out.printf("\nAppraisal Price for this property is: $%,.2f\n", appraisal);
			System.out.println("Please enter the List Price for the property:");
				listPrice = validationDouble(sIn,"Invalid number");
				residence.setListPrice(listPrice);
				reoListings.addListing(StreetAddress, residence);
				
			System.out.printf("\nYou have created a new listing!\n");
			System.out.println(residence.toString());
			
		} else if (residenceType.equalsIgnoreCase("Condo")) {
			int zIp = Integer.valueOf(zip);
			
			System.out.println("Please enter the floor level of the condo: ");
				int floorLvl = validationInt(sIn, "Error. Please type numbers.");
			
			Condo residence = new Condo(StreetAddress,zIp, bedCount, badCount, sqFoot, floorLvl, floorLvl, floorLvl);
			
			appraisal = residence.calculateAppraisalPrice();
			System.out.printf("\nAppraisal Price for this property is: $%,.2f\n",appraisal);
			System.out.println("Please enter the List Price for the property: ");
				listPrice = validationDouble(sIn,"Invalid number");
				residence.setListPrice(listPrice);
				reoListings.addListing(StreetAddress, residence);
			
			
			System.out.printf("\nYou have created a new listing!\n");
			System.out.println(residence.toString());
			
		}
		
	}



	





	private static void showListing() {
		int ListNo = 1;
        for(Residential i : reoListings.getResidences()){
            System.out.println("Listing No: " + ListNo);
            System.out.println(i.toString() + "\n\n");
            ListNo +=1;
        }
	}

	
	
	private static void bids() {
		Scanner sIn = new Scanner(System.in);
		boolean bids = false;
		while(!bids) {
			System.out.println("--------------------------------------------");
			System.out.println("                 Bids Menu");
			System.out.println("--------------------------------------------");
			
			System.out.println("\n1: Add New Bid" + "\n2: Show Existing Bids" + 
				"\n3: Auto Populate Bids" + "\nENTER: Exit back to previose menu" + 
				"\n\nWhat would you like to do? (1-3):");
			String bid = sIn.nextLine();
			
			switch (bid) {
			case "1":
				break;
			case "2":
				break;
			case "3":
				break;
			case "":
				bids = true;
			
			}
		}
	}
	
	
	private static void autoPopulate(){
		
		int currentSize = reoListings.getListings().size();
		
		House house1 = new House("34 Elm",95129, 3, 2, 2200, .2, 2, 2.5);
		house1.setListPrice(house1.calculateAppraisalPrice() * 1.1);
		reoListings.addListing("34 Elm", house1);
		
		House house2 = new House("42 Hitchhikers",95136, 4, 3, 2800, .3, 2, 2.5);
		house2.setListPrice(house2.calculateAppraisalPrice() * 1.1);
		reoListings.addListing("42 Hitchhikers", house2);
		
		Condo condo1 = new Condo("4876 Industrial", 95177, 3, 1, 1800, 3, 2, 2);
		condo1.setListPrice(condo1.calculateAppraisalPrice() * 1.1);
		reoListings.addListing("4876 Industrial", condo1);
		
		House house3 = new House("2654 Oak",84062, 5, 53, 4200, .5, 2, 2.5);
		house3.setListPrice(house3.calculateAppraisalPrice() * 1.1);
		reoListings.addListing("2654 Oak", house3);
		
		Condo condo2 = new Condo("9875 Lexington",84063, 2, 1, 1500, 1, 2, 2);
		condo2.setListPrice(condo2.calculateAppraisalPrice() * 1.1);
		reoListings.addListing("9875 Lexington", condo2);
		
		Condo condo3 = new Condo("3782 Market", 84066, 3, 1, 1800, 2, 2, 2);
		condo3.setListPrice(condo3.calculateAppraisalPrice() * 1.1);
		reoListings.addListing("3782 Market", condo3);
		
		House house4 = new House("7608 Glenwood", 84055, 6, 3, 3900, .4, 2, 2.5);
		house4.setListPrice(house4.calculateAppraisalPrice() * 1.1);
		reoListings.addListing("7608 Glenwood", house4);
		
		House house5 = new House("1220 Apple", 84057, 8, 7, 7900, 1, 2, 2.5);
		house5.setListPrice(house5.calculateAppraisalPrice() * 1.1);
		reoListings.addListing("1220 Apple", house5);
		
		 System.out.println("8 residences have been added to the listings for testing purposes.");
		
	}
	
	
	
	

	private static double validationDouble(Scanner sIn, String warning) {
		double validation = 0;
        do{ 
            try{
                validation = Double.parseDouble(sIn.nextLine());
                break;
            } catch(NumberFormatException e) {
                System.out.println(warning);
            }
        }
        while (true);
        return validation;

	}
	
	
	private static int validationInt(Scanner sIn, String warning) {
		int validation = 0;
		do {
			try {
				validation = Integer.parseInt(sIn.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println(warning);
			}
		}
		while(true);
		return validation;
	}
	
	

	
	
	
	
	
	
	
	

}
