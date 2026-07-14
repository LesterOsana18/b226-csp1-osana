/* * Capstone 1: App Building - Load Registration App
 *   Created by Lester Osana on Thursday, July 9, 2026.
 *   
 * * Description: A Java-based application designed to register, manage, 
 *   and store user load profiles.
 *   
 * * In partial fulfillment of the requirements for JOYSIS TVI 
 *   Submitted to: Sir Jareth Ronquillo
 */	 
package com.joysistvi.loadreg.main;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class Main {
	
	// Create a global Scanner object
	static Scanner input = new Scanner(System.in);
	
	// Create a global 'choice' variable for user inputs
	static int choice;
	
	// Tracks the promo the user is currently registered to (null if none yet).
	static String currentPromoName = null;
	static String currentPromoDetails = null;
	
	// Tracks how much load the user has available to spend on promos.
	static double loadBalance = 500;
	
	// Logs every successful promo registration for the "Registration History" screen.
	static StringBuilder registrationHistory = new StringBuilder();
	
	public static void main(String[] args) {
		// Load Registration Menu for Globe Users
		printHeader("GLOBE LOAD REGISTRATION");
	    
	    validateUSSDCode();
	    
	    input.close();
	}
	
	public static void validateUSSDCode() {
		String ussd;
		
		do {
			
			System.out.print("\nDial USSD Code: ");
			ussd = input.nextLine().trim();
			
			if (!ussd.equals("*143#")) {
				System.out.println("\nInvalid USSD Code.");
				System.out.println("Please dial *143#");
			} 
			
		} while (!ussd.equals("*143#"));
		
		System.out.println("\nConnecting to Globe...");
		System.out.println("Connection Successful!");
		
		mainMenu();
	}
	
	public static void mainMenu() {
		do {
			
			printHeader("GLOBE *143#");

	        System.out.println("[0] MyAccount");
	        System.out.println("[1] Go+");
	        System.out.println("[2] SuperGo99");
	        System.out.println("[3] GoEXTRA");
	        System.out.println("[4] UNLI");
	        System.out.println("[5] Go");
	        System.out.println("[6] GoBOOSTERS");
	        System.out.println("[7] Surf4All");
	        System.out.println("[8] ALLNET");
	        System.out.println("[9] All-Time Favorites");
	        System.out.println("[10] GlobeONE");
	        System.out.println("[11] Rewards");
	        System.out.println("[12] Loans");
	        System.out.println("[13] Roaming & Int'l");
	        System.out.println("[14] Exit");

	        System.out.print("\nReply: ");
	        choice = getIntegerInput();

	        switch (choice) {

	        case 0:
	            myAccount();
	            break;

	        case 1:
	            goPlus();
	            break;

	        case 2:
	            superGo99();
	            break;

	        case 3:
	            goExtra();
	            break;

	        case 4:
	            unli();
	            break;

	        case 5:
	            go();
	            break;

	        case 6:
	            goBoosters();
	            break;

	        case 7:
	            surf4All();
	            break;

	        case 8:
	            allNet();
	            break;

	        case 9:
	            allTimeFavorites();
	            break;

	        case 10:
	            globeOne();
	            break;

	        case 11:
	            rewards();
	            break;

	        case 12:
	            loans();
	            break;

	        case 13:
	            roaming();
	            break;

	        case 14:
	            exitApp();
	            return;

	        default:
	            defaultMessage();
	        }
			
		} while (true);
	}
	
	// myAccount() method
	public static void myAccount() {
		do {
			printHeader("MY ACCOUNT");
			
			System.out.println("Manage your account and check your balance with GlobeOne.");
			System.out.println("Download it now.");
			
			System.out.println("[1] Data Balance");
			System.out.println("[2] Surf Alert");
			System.out.println("[3] Load Call Card");
			System.out.println("[4] My Devices");
			System.out.println("[5] Registration History");
			System.out.println("[6] Back");
			
			System.out.print("Reply: ");
			choice = getIntegerInput();
			
			switch (choice) {
				case 1:
					printHeader("DATA BALANCE");
					
					System.out.println("Load Balance: PHP " + String.format("%.2f", loadBalance));
					System.out.println();
					
					if (currentPromoName != null) {
						System.out.println("You are currently registered to:");
						System.out.println();
						System.out.println(currentPromoName);
						System.out.println(currentPromoDetails);
					} else {
						System.out.println("You do not have any registered promos on this number.");
					}
					break;
					
				case 2:
					comingSoon();
					break;
					
				case 3:
					loadCallCard();
					break;
					
				case 4:
					comingSoon();
					break;
					
				case 5:
					printHeader("REGISTRATION HISTORY");
					
					if (registrationHistory.length() == 0) {
						System.out.println("You have no registration history yet.");
					} else {
						System.out.print(registrationHistory);
					}
					break;
					
				case 6:
					// Returns to main menu when selected
					return;
					
				default:
					defaultMessage();
			}
		} while (true);
	}
	
	// goPlus() method
	public static void goPlus() {
		do {
			printHeader("GO+");
			
			System.out.println("You can earn reward points when you purchase your promos via GlobeOne.");
			System.out.println("Download the app now!");
			
			System.out.println("[1] Go+99");
			System.out.println("[2] Go+109");
			System.out.println("[3] Go+129");
			System.out.println("[4] Go+149");
			System.out.println("[5] Go+179");
			System.out.println("[6] Go+250");
			System.out.println("[7] Go+400");
			System.out.println("[8] Back");
			
			System.out.print("Reply: ");
			choice = getIntegerInput();
	        
	        switch (choice) {
		        case 1:
		        	registerPromo(
		        		"GoPLUS99",
		        		"8 GB all-access data + 8 GB for choice of apps + 4 GB free 5G + unli all-net texts",
		        		99);
		        	break;
		        	
		        case 2:
		        	registerPromo(
	        			"GoPLUS109",
		        		"10 GB all-access data + 8 GB for choice of apps + 4 GB free 5G + unli all-net texts",
		        		109);
		        	break;
		        	
		        case 3:
		        	registerPromo(
			        	"GoPLUS129",
			        	"10 GB all-access data + 8 GB for choice of apps + 8 GB free 5G + unli all-net texts + unli calls to Globe and TM",
		        		129);
		        	break;
		        	
		        case 4:
		        	registerPromo(
			        	"GoPLUS149",
			        	"12 GB all-access data + 8 GB for choice of apps + 8 GB free 5G + unli all-net calls and texts",
		        		149);
		        	break;
		        	
		        case 5:
		        	registerPromo(
			        	"GoPLUS179",
			        	"8 GB all-access data + 8 GB for choice of apps + 8 GB free 5G + unli all-net texts",
		        		179);
		        	break;
		        	
		        case 6:
		        	registerPromo(
			        	"GoPLUS250",
			        	"15 GB all-access data + 15 GB for choice of apps + 8 GB free 5G",
		        		250);
		        	break;
		        	
		        case 7:
		        	registerPromo(
			        	"GoPLUS400",
			        	"25 GB all-access data + 15 GB for choice of apps + 8 GB free 5G",
		        		400);
		        	break;
		        	
		        case 8:
		        	// Returns to main menu when selected
		        	return;
		        	
		        default:
		        	defaultMessage();
	        }
			
		} while (true);
	}
	
	// superGo99() method
	public static void superGo99() {
		do {
			printHeader("SUPERGO99");
			
			System.out.println("Enjoy data for 15 days with GoDEALS!");
			System.out.println("SuperGo99 comes with 7GB for all sites + unli all-net texts, valid for 15 days.");
			System.out.println("Register via GlobeOne to earn 1.98 points.");
			
			System.out.println("[1] Subscribe");
			System.out.println("[2] Back");
			
			System.out.print("Reply: ");
			choice = getIntegerInput();
	        
	        switch (choice) {
		        case 1:
		        	registerPromo(
		        		"SuperGo99",
		        		"7 GB all-access data + unli all-net texts, valid for 15 days",
		        		99);
		        	break;
		        	
		        case 2:
		        	// Returns to main menu when selected
		        	return;
		        	
		        default:
		        	defaultMessage();
	        }
			
		} while (true);
	}
  	
	// goExtra() method
	public static void goExtra() {
		do {
			printHeader("GOEXTRA");
			
			System.out.println("You can earn reward points when you purchase your promos via GlobeOne.");
			System.out.println("Download the app now!");
			
			System.out.println("[1] GoEXTRA59");
			System.out.println("[2] GoEXTRA99");
			System.out.println("[3] GoEXTRA109");
			System.out.println("[4] GoEXTRA179");
			System.out.println("[5] GoEXTRA199");
			System.out.println("[6] Back");
			
			System.out.print("Reply: ");
			choice = getIntegerInput();
	        
	        switch (choice) {
		        case 1:
		        	registerPromo(
			        	"GoEXTRA59",
			        	"5 GB all-access data + unli all-net calls and texts",
		        		59);
		        	break;
		        	
		        case 2:
		        	registerPromo(
			        	"GoEXTRA99",
			        	"8 GB all-access data + unli all-net calls and texts",
		        		99);
		        	break;
		        	
		        case 3:
		        	registerPromo(
			        	"GoEXTRA109",
			        	"10 GB all-access data + unli all-net calls and texts",
		        		109);
		        	break;
		        	
		        case 4:
		        	registerPromo(
			        	"GoEXTRA179",
			        	"5 GB all-access data + unli all-net calls and texts",
		        		179);
		        	break;
		        	
		        case 5:
		        	registerPromo(
		        		"GoEXTRA199",
		        		"8 GB all-access data + unli all-net calls and texts",
		        		199);
		        	break;
		        	
		        case 6:
		        	// Returns to main menu when selected
		        	return;
		        	
	        	default:
	        		defaultMessage();
	        }
			
		} while (true);
	}
	
	// unli() method
	public static void unli() {
		do {
			printHeader("UNLI");
			
			System.out.println("You can earn reward points when you purchase your promos via GlobeOne.");
			System.out.println("Download the app now!");
			
			System.out.println("[1] UNLI 5G 59");
			System.out.println("[2] UNLI 5G 80");
			System.out.println("[3] UnliGo99 FB");
			System.out.println("[4] UnliGo99 TikTok");
			System.out.println("[5] UnliGo99 IG");
			System.out.println("[6] Back");
			
			System.out.print("Reply: ");
			choice = getIntegerInput();
	        
	        switch (choice) {
		        case 1:
		        	registerPromo(
		        		"UNLI 5G 59",
		        		"Unli Data for 5G + 2 GB for all sites",
		        		59);
		        	break;
		        	
		        case 2:
		        	registerPromo(
			        	"UNLI 5G 80",
			        	"Unli Data for 5G + 2 GB for all sites + unli all-net calls and texts",
		        		80);
		        	break;
		        	
		        case 3:
		        	registerPromo(
			        	"UnliGo99 Facebook",
			        	"Unli Facebook + 5 GB all-access data + unli all-net texts",
		        		99);
		        	break;
		        	
		        case 4:
		        	registerPromo(
			        	"UnliGo99 TikTok",
			        	"Unli TikTok + 5 GB all-access data + unli all-net texts",
		        		99);
		        	break;
		        	
		        case 5:
		        	registerPromo(
			        	"UnliGo99 Instagram",
			        	"Unli Instagram + 5 GB all-access data + unli all-net texts",
		        		99);
		        	break;
		        	
		        case 6:
		        	// Return to main menu when selected
		        	return;
		        	
	        	default:
	        		defaultMessage();
	        }
			
		} while (true);
	}
	
	// go() method
	public static void go() {
		do {
			printHeader("GO");
			
			System.out.println("You can earn reward points when you purchase your promos via GlobeOne.");
			System.out.println("Download the app now!");
			
			System.out.println("[1] Go59");
			System.out.println("[2] Go59 for Students");
			System.out.println("[3] Back");
			
			System.out.print("Reply: ");
			choice = getIntegerInput();
	        
	        switch (choice) {
		        case 1:
		        	registerPromo(
		        		"Go59",
		        		"5 GB all-access data + unli all-net texts",
		        		59);
		        	break;
		        	
		        case 2:
		        	registerPromo(
		        		"Go59 for Students",
		        		"5 GB all-access data + 1 GB for GoLEARN apps + unli all-net texts",
		        		59);
		        	break;
		        	
		        case 3:
		        	// Return to main menu when selected
		        	return;
		        	
	        	default:
	        		defaultMessage();
	        }
			
		} while (true);
	}
 	
	// goBoosters() method
	public static void goBoosters() {
		do {
			printHeader("GOBOOSTERS");
			
			System.out.println("Add more with your Go promo by registering to any of the following GoBOOSTERS:");
			
			System.out.println("[1] GoBOOST15");
			System.out.println("[2] GoWATCH10");
			System.out.println("[3] GoPLAY10");
			System.out.println("[4] GoSHARE10");
			System.out.println("[5] More");
			System.out.println("[6] Back");
			
			System.out.print("Reply: ");
			choice = getIntegerInput();
	        
	        switch (choice) {
		        case 1:
		        	registerPromo(
		        		"GoBOOST15",
		        		"Additional 1 GB data for all sites and apps",
		        		15);
		        	break;
		        	
		        case 2:
		        	registerPromo(
			        	"GoWATCH10",
			        	"Additional 1 GB for video apps (YouTube, Netflix, Viu, and Disney+)",
		        		10);
		        	break;
		        	
		        case 3:
		        	registerPromo(
			        	"GoPLAY10",
			        	"Additional 1 GB for gaming apps (Mobile Legends, PUBG, Call of Duty, Discord, Twitch, and Honor of Kings)",
		        		10);
		        	break;
		        	
		        case 4:
		        	registerPromo(
			        	"GoSHARE10",
			        	"Additional 1 GB for social media apps (Facebook, Instagram, TikTok, X, Viber, WhatsApp, and Canva)",
		        		10);
		        	break;
		        	
		        case 5:
		        	comingSoon();
		        	break;
		        	
		        case 6:
		        	// Return to main menu when selected
		        	return;
		        	
	        	default:
	        		defaultMessage();
	        }
		} while (true);
	}
	
	// surf4All() method
	public static void surf4All() {
		do {
			printHeader("SURF4ALL");
			
			System.out.println("You can earn reward points when you purchase your promos via GlobeOne.");
			System.out.println("Download the app now!");
			
			System.out.println("[1] Surf4All 99");
			System.out.println("[2] Surf4All 249");
			System.out.println("[3] Status");
			System.out.println("[4] Manage your Group");
			System.out.println("[5] Back");
			
			System.out.print("Reply: ");
			choice = getIntegerInput();
	        
	        switch (choice) {
		        case 1:
		        	registerPromo(
		        		"Surf4All 99",
		        		"9 GB Data + Valid for 7 days + Can be shared with your friends and fam",
		        		99);
		        	break;
		        	
		        case 2:
		        	registerPromo(
			        	"Surf4All 249",
			        	"20 GB Data + Valid for 7 days + Can be shared with your friends and fam",
		        		249);
			        break;
		        	
		        case 3:
		        	comingSoon();
		        	break;
		        	
		        case 4:
		        	comingSoon();
		        	break;
		        	
		        case 5:
		        	// Return to main menu when selected
		        	return; 
		        	
	        	default:
	        		defaultMessage();
	        }
		} while (true);
	}
	
	// allNet() method
	public static void allNet() {
		do {
			printHeader("GOUNLI");
			
			System.out.println("The new GoUNLI now has calls & texts to ALL NETWORKS!");
			
			System.out.println("[1] GoUNLI20");
			System.out.println("[2] GoUNLI30");
			System.out.println("[3] GoUNLI50");
			System.out.println("[4] GoUNLI95");
			System.out.println("[5] GoUNLI180");
			System.out.println("[6] GoUNLI350");
			System.out.println("[7] Back");
			
			System.out.print("Reply: ");
			choice = getIntegerInput();
	        
	        switch (choice) {
		        case 1:
		        	registerPromo("GoUNLI20", "Unli calls and texts to all networks + 50 MB of mobile data",
		        		20);
		        	break;
		        	
		        case 2:
		        	registerPromo("GoUNLI30", "Unli calls and texts to all networks + 100 MB of mobile data",
		        		30);
		        	break;
		        	
		        case 3: 
		        	registerPromo("GoUNLI50", "Unli calls and texts to all networks + 500 MB of mobile data",
		        		50);
		        	break;
		        	
		        case 4:
		        	registerPromo("GoUNLI95", "Unli calls and texts to all networks + 1 GB of mobile data",
		        		95);
		        	break;
		        	
		        case 5:
		        	registerPromo("GoUNLI180", "Unli calls and texts to all networks + 2 GB of mobile data",
		        		180);
		        	break;
		        	
		        case 6:
		        	registerPromo("GoUNLI350", "Unli calls and texts to all networks + 3 GB of mobile data",
		        		350);
		        	break;
		        	
		        case 7:
		        	// Return to main menu when selected
		        	return;
		        	
	        	default:
	        		defaultMessage();
	        }
		} while (true);
	}
	
	// allTimeFavorites() method
	public static void allTimeFavorites() {
		do {
			printHeader("ALL-TIME FAVORITES");
			
			System.out.println("[1] GoSURF");
			System.out.println("[2] GS Status");
			System.out.println("[3] SuperSurf");
			System.out.println("[4] Mobile internet usage");
			System.out.println("[5] Help");
			System.out.println("[6] Back");

			System.out.print("Reply: ");
			choice = getIntegerInput();
	        
	        switch (choice) {
		        case 1:
		        	comingSoon();
		        	break;
		        	
		        case 2:
		        	comingSoon();
		        	break;
		        	
		        case 3:
		        	comingSoon();
		        	break;
		        	
		        case 4:
		        	comingSoon();
		        	break;
		        	
		        case 5:
		        	comingSoon();
		        	break;
		        	
		        case 6:
		        	// Return to main menu when selected
		        	return;
		        	
		        default:
		        	defaultMessage();
	        }
			
		} while (true);
	}
	
	// globeOne() method
	public static void globeOne() {
		printHeader("GLOBEONE");
		
		pause();
		
		System.out.println("Thank you! You will get a response shortly.");
		
		pause();
		
		System.out.println("Register to the latest Globe Prepaid offers, track your usage and manage your mobile accounts in one place anytime, anywhere with the GlobeOne app.");
		System.out.println("Download it now!");
	}
	
	// rewards() method
	public static void rewards() {
		// TODO: Implement the functionalities of this method
		comingSoon();
		return;
	}
	
	// loans() method
	public static void loans() {
		// TODO: Implement the functionalities of this method
		comingSoon();
		return;
	}
	
	// roaming() method
	public static void roaming() {
		// TODO: Implement the functionalities of this method
		comingSoon();
		return;
	}
	
	// loadCallCard() method
	public static void loadCallCard() {
		printHeader("LOAD CALL CARD");
		
		System.out.println("Current Load Balance: PHP " + String.format("%.2f", loadBalance));
		System.out.println("\nEnter amount to load (0 to cancel):");
		System.out.print("Amount: PHP ");
		
		int amount = getIntegerInput();
		
		if (amount == 0) {
			System.out.println("\nLoad cancelled.");
			return;
		}
		
		if (amount < 0) {
			System.out.println("\nInvalid amount. Please enter a positive value.");
			return;
		}
		
		loadBalance += amount;
		
		printHeader("LOAD SUCCESSFUL");
		System.out.println("You have successfully loaded PHP " + String.format("%.2f", (double) amount) + ".");
		System.out.println("New Load Balance: PHP " + String.format("%.2f", loadBalance));
	}
	
	// pause() method
	public static void pause() {
		System.out.println("\nPress ENTER to continue...");
		input.nextLine();
	}
	
	// registerPromo() method
	public static void registerPromo(String promoName, String promoDetails, double price) {

	    if (loadBalance < price) {
	        printHeader("INSUFFICIENT BALANCE");

	        System.out.println("You need PHP " + String.format("%.2f", price) + " to register to this promo.");
	        System.out.println("Your current load balance is PHP " + String.format("%.2f", loadBalance) + ".");
	        System.out.println("\nPlease load up before registering to this promo.");

	        return;
	    }

	    if (confirmRegistration(promoName, promoDetails, price)) {
	        loadBalance -= price;
	        currentPromoName = promoName;
	        currentPromoDetails = promoDetails;
	        registrationHistory.append("- ").append(promoName)
	            .append(" (PHP ").append(String.format("%.2f", price)).append(")\n");
	        successMessage(promoName, promoDetails);
	    } else {
	        System.out.println("\nRegistration cancelled.");
	    }

	}
	
	// confirmRegistration() method
	public static boolean confirmRegistration(String promoName, String promoDetails, double price) {

	    printHeader("CONFIRM REGISTRATION");

	    System.out.println("Promo: " + promoName);
	    System.out.println();
	    System.out.println(promoDetails);
	    System.out.println();
	    System.out.println("Price: PHP " + String.format("%.2f", price));

	    System.out.println("\n[1] Confirm");
	    System.out.println("[2] Cancel");

	    System.out.print("\nReply: ");

	    int confirm = getIntegerInput();

	    return confirm == 1;
	}
	
	// successMessage() method
	public static void successMessage(String promoName, String promoDetails) {

	    printHeader("REGISTRATION SUCCESSFUL");

	    System.out.println("Congratulations!");
	    System.out.println();
	    System.out.println("You have successfully registered to:");
	    System.out.println();

	    System.out.println(promoName);
	    System.out.println(promoDetails);
	    System.out.println();
	    System.out.println("Remaining Load Balance: PHP " + String.format("%.2f", loadBalance));
	    
	    pause();

	    System.out.println("\nThank you for choosing Globe!");
	}
 	
 	// defaultMessage() method
	public static void defaultMessage() {
		System.out.println("\nInvalid option!");
		System.out.println("Please try again.");
	}
 	
	// comingSoon() method
	public static void comingSoon() {
		System.out.println("\nThis is still under construction!");
		System.out.println("Feature available in future updates.");
	}
	
	// printHeader() method
	public static void printHeader(String title) {
		// Fixed divider width
		final int width = 34;
		int padding = Math.max(0, (width - title.length()) / 2);
		String centered = " ".repeat(padding) + title;
		
		System.out.println("\n==================================");
	    System.out.println(centered);
	    System.out.println("==================================");
	}
	
	// getIntegerInput() method
	public static int getIntegerInput() {
		while (true) {

	        try {

	            int choice = input.nextInt();
	            input.nextLine();

	            return choice;

	        } catch (InputMismatchException e) {

	            System.out.println("\nInvalid input. Numbers only.");
	            input.nextLine();
	            System.out.print("\nReply: ");
	            
	        } catch (NoSuchElementException e) {

	            // Input stream ended unexpectedly (e.g. Ctrl+D/Ctrl+Z or piped
	            // input running out) - exit cleanly instead of crashing.
	            System.out.println("\nInput stream closed unexpectedly. Exiting program...");
	            System.exit(0);

	        }

	    }
	}
	
	// exitApp() method
	public static void exitApp() {
		printHeader("GOODBYE!");
		
		System.out.println("Thank you for using Globe.");
		System.out.println("Have a nice day!");
	}
}
