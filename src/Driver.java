import java.util.Scanner;
import java.util.ArrayList;

public class Driver {

	public static User user;
	private static Scanner in;
	// starting page
	static Page homePage = new Page();
	
	// search pages and links
	static Page searchPage = new Page();
	
	// admin page
	static Page adminOptionsPage = new Page();
	
	// employee page
	static Page employeeOptionsPage = new Page();
	
	// account pages and links
	static Page accountPage = new Page();
	
	// view popular pages and links
	static Page eventsPage = new Page();
	
	// view showtime information
	static Page showtimePage = new Page();
	
	/**
	 * helper method to easily validate user input for choices
	 * @param highestChoice
	 * @return int - value corresponding to a choice given to the user
	 */
	private static int getValidatedChoice(int highestChoice) {
		while (true) {
			String strChoice = in.nextLine();
			if (!strChoice.matches("[0-9]+")) {
				System.out.println("Error, please enter an integer value ...");
				continue;
			}
			int intChoice = Integer.parseInt(strChoice);
			if (intChoice < 0 || intChoice > highestChoice) {
				System.out.println("Error, please choose an integer within the range 0 to " + highestChoice + " inclusive");
				continue;
			}
			return intChoice;
		}
	}
	
	// Page setup and initialization
	// homepage setup display and 
	private static void setUpHomePage() {
		homePage.setDisplay("  *******************    ******************* 	 ******************* \n" +
				 		 	"  *                 *    *                 * 	 *				   * \n" +
				 		 	"  *    HOME PAGE    *    *    0: Search    * 	 * 1: View Account * \n" +
				 		 	"  *                 *    *                 *    *				   * \n" +
				 		 	"  *******************    *******************    ******************* \n" +
				 		 	"                                             						 \n" +
				 		 	"  *******************    ******************* 	 \n" +
				 		 	"  *                 *    *                 * 	 \n" +
				 		 	"  * 2: View Events  *    *     3: Exit     * 	 \n" +
				 		 	"  *                 *    *                 * 	 \n" +
				 		 	"  *******************    ******************* 	 \n" +
				 		 	"\n\n IF YOU ARE EMPLOYEE OR ADMIN --- 4: Go to your functionality");
	}
	private static void homePageManager() {
		// TODO display home page
		homePage.showDisplay();
		// TODO ask for user input
		while(true) {
			System.out.println("Please Enter a number between 0-4: ");
			int choice = in.nextInt();
			in.nextLine();
			
			if(choice < 0 || choice > 4) {
				System.out.println("Your choice was invalid, choose again. ");
			} else if(choice == 0) {
				System.out.println("You selected Search, moving there. ");
				searchPageManager();
			} else if(choice == 1) {
				System.out.println("You selected View Account, moving there. ");
				accountPageManager();
			} else if(choice == 2) {
				System.out.println("You selected View Events, moving there. ");
				eventPageManager();
			} else if(choice == 3) {
				System.out.println("You selected Exit, exiting. ");
				System.exit(0);
			} else if(choice == 4) {
				System.out.println("You selected Employee or Admin, verifying... ");
				if(user.getType().equalsIgnoreCase("employee")) {
					System.out.println("You are an Employee, moving foward... ");
					employeePageManager();
				} else if(user.getType().equalsIgnoreCase("admin")) {
					System.out.println("You are an Admin, moving foward... ");
					adminPageManager();
				} else {
					System.out.println("You are not qualified to move there... try again");
					continue;
				}
			} else {
				System.out.println("Your choice was invalid, choose again. ");
			}
		}
	}
	
	// searchpage setup display
	private static void setUpSearchPage() {
		searchPage.setDisplay("  *******************    *******************    ******************* \n" +
	 		 				  "  *                 *    *                 *    *				 * \n" +
	 		 				  "  *   SEARCH PAGE   *    *   0: By Title   *    *   1: By Date	 * \n" +
	 		 				  "  *                 *    *                 *    *				 * \n" +
	 		 				  "  *******************    *******************    ******************* \n" +
	 		 				  "                                             					   \n" +
	 		 				  "  *******************    *******************    ******************* \n" +
	 		 				  "  *                 *    * 			      *    *				 * \n" +
	 		 				  "  *   2: By Rating  *    *   3: By Actor   *    *  4: Home Page	 * \n" +
	 		 				  "  *                 *    * 			      *    *				 * \n" +
	 		 				  "  *******************    *******************    ******************* \n");
	}
	private static void searchPageManager() {
		// TODO display search page
		searchPage.showDisplay();
		String searchTerm;
		// TODO get user imput 
		while(true) {
			System.out.println("Please Enter a number between 0-4: ");
			int choice = in.nextInt();
			in.nextLine();
			
			if(choice < 0 || choice > 4) {
				System.out.println("Your choice was invalid, choose again. ");
			} else if(choice == 0) {
				System.out.println("You selected Search by Title, moving there. ");
				System.out.println("Enter a title to search by: ");
				searchTerm = in.nextLine();
				//TODO SEARCH
			} else if(choice == 1) {
				System.out.println("You selected search by date, moving there. ");
				System.out.println("Enter a date to search by: ");
				searchTerm = in.nextLine();
				
			} else if(choice == 2) {
				System.out.println("You selected search by rating, moving there. ");
				System.out.println("Enter a title to search by: ");
				searchTerm = in.nextLine();
				//TODO SEARCH
			} else if(choice == 3) {
				System.out.println("You selected search by actor, moving there. ");
				System.out.println("Enter a title to search by: ");
				searchTerm = in.nextLine();
				//TODO SEARCH
			} else if(choice == 4) {
				System.out.println("You selected go home, going home... ");
				homePageManager();
			} else {
				System.out.println("Your choice was invalid, choose again. ");
			}
		}
		// TODO 0 use db stuff to search for showtimes by user specified title
			// TODO list these for the user if exists, redo searchPageManager if not
			// TODO ask if want to add it to cart
				// TODO if so, they enter the number of tickets for event
				// TODO if not, redo searchPageManager
		// TODO 1 use db stuff to search for showtimes on a specified date
			// TODO list these for user if exitsts, redo searchPageManager if not
				// TODO ask if user wants to add any showtimes to cart
		
	}
	
	// adminpage setup display
	private static void setUpAdminPage() {
		adminOptionsPage.setDisplay("  ****************************************** 	 \n" +
	 		 						"  *                                        * 	 \n" +
	 		 						"  *        ADMIN USER OPTIONS PAGE         * 	 \n" +
	 		 						"  *                                        *    \n" +
	 		 						"  ******************************************    \n" +
	 		 						"                                             	 \n" +
	 		 						"  *******************    ******************* 	 \n" +
	 		 						"  *                 *    *                 * 	 \n" +
	 		 						"  *   0: Add User   *    * 1: Add Location * 	 \n" +
	 		 						"  *                 *    *                 * 	 \n" +
	 		 						"  *******************    ******************* 	 \n" +
	 		 						"                                                  " +
	 		 						"  ****************************************** 	 \n" +
	 		 						"  *                                        * 	 \n" +
	 		 						"  *        3: GO BACK TO HOME PAGE         * 	 \n" +
	 		 						"  *                                        *    \n" +
	 		 						"  ******************************************    ");
	}
	private static void adminPageManager() {
		// TODO display admin page
		// TODO get user input
	}
	
	// employee page setup display
	private static void setUpEmployeePage() {
		employeeOptionsPage.setDisplay( 
									"  ****************************************** 	 \n" +
	 		 						"  *                                        * 	 \n" +
	 		 						"  *       EMPLOYEE USER OPTIONS PAGE       * 	 \n" +
	 		 						"  *                                        *    \n" +
	 		 						"  ******************************************    \n" +
	 		 						"                                             	 \n" +
	 		 						"  *******************    ******************* 	 \n" +
	 		 						"  *                 *    *     -     -     * 	 \n" +
	 		 						"  *  0: Add Event   *    *   ^        ^    * 	 \n" +
	 		 						"  *                 *    *     \\_____/    * 	 \n" +
	 		 						"  *******************    ******************* 	 \n" +
	 		 						"                                                  " +
	 		 						"  ****************************************** 	 \n" +
	 		 						"  *                                        * 	 \n" +
	 		 						"  *        1: GO BACK TO HOME PAGE         * 	 \n" +
	 		 						"  *                                        *    \n" +
	 		 						"  ******************************************    ");
	}
	private static void employeePageManager() {
		employeeOptionsPage.showDisplay();
		
		// TODO get user imput 
		while(true) {
			System.out.println("Please Enter a number between 0-1: ");
			int choice = in.nextInt();
			in.nextLine();

			if(choice < 0 || choice > 1) {
				System.out.println("Your choice was invalid, choose again. ");
			} else if(choice == 0) {
				System.out.println("You selected add event, moving there. ");
				DatabaseDriver.enterEvent();
			} else if(choice == 1) {
				System.out.println("You selected go home, going home... ");
				homePageManager();
			} else {
				System.out.println("Your choice was invalid, choose again. ");
			}
		}
	}
	
	private static void setUpEventsPage() {
		homePage.setDisplay("  *******************    ******************* 	 ******************* \n" +
				 		 	"  *                 *    *                 * 	 *				   * \n" +
				 		 	"  *  EVENTS PAGE    *    *  0:SHOW EVENTS  * 	 * 1: GO HOME      * \n" +
				 		 	"  *                 *    *                 *    *				   * \n" +
				 		 	"  *******************    *******************    ******************* \n" +
				 		 	"                                             						 \n"+
				 		 	"  ****************************************** 	 \n" +
		 				    "  *                                        * 	 \n" +
		 					"  *        2: VIEW SHOWTIME INFO           * 	 \n" +
		 					"  *                                        *    \n" +
		 					"  ******************************************    ");
	}
	private static void eventPageManager() {
		eventsPage.showDisplay();
		while(true) {
			System.out.println("Please Enter a number between 0-1: ");
			int choice = in.nextInt();
			in.nextLine();

			if(choice < 0 || choice > 1) {
				System.out.println("Your choice was invalid, choose again. ");
			} else if(choice == 0) {
				System.out.println("You selected show all events, showing. ");
				DatabaseDriver.readAllEvents();
			} else if(choice == 1) {
				System.out.println("You selected go home, going home... ");
				homePageManager();
			} else if(choice == 3) {
				System.out.println("Showing showtime info");
				DatabaseDriver.
			} else {
				System.out.println("Your choice was invalid, choose again. ");
			}
		}
	}
	
	
	private static void setUpAccountPage() {
		accountPage.setDisplay(     
	 		 						"                                             	 \n" +
	 		 						"  *******************    ******************* 	 \n" +
	 		 						"  *                 *    *                 * 	 \n" +
	 		 						"  *  0: View Wallet *    *  1: View Cart   * 	 \n" +
	 		 						"  *                 *    *                 * 	 \n" +
	 		 						"  *******************    ******************* 	 \n" +
	 		 						"                                             	 \n" +
	 		 						"  *******************    ******************* 	 \n" +
	 		 						"  *                 *    *                 * 	 \n" +
	 		 						"  * 2: Purchase Tix *    * 3: View Tickets * 	 \n" +
	 		 						"  *                 *    *                 * 	 \n" +
	 		 						"  *******************    ******************* 	 \n" +
	 		 						"                                                \n" +
	 		 						"  *******************    ******************* 	 \n" +
	 		 						"  *                 *    *                 * 	 \n" +
	 		 						"  *  4: Empty Cart  *    *     5: Exit     * 	 \n" +
	 		 						"  *                 *    *                 * 	 \n" +
									"  *******************    ******************* 	 \n");
	}
	private static void accountPageManager() {
		accountPage.showDisplay();
		
			while(true) {
			System.out.println("Please Enter a number between 0-5: ");
			int choice = in.nextInt();
			in.nextLine();
			
			if(choice < 0 || choice > 5) {
				System.out.println("Your choice was invalid, choose again. ");
			} else if(choice == 0) {
				System.out.println("You selected View Wallet, viewing. ");
				user.viewWallet();
				accountPageManager();
			} else if(choice == 1) {
				System.out.println("You selected view cart, viewing. ");
				user.viewCart();
				accountPageManager();
			} else if(choice == 2) {
				System.out.println("You selected Purchase ticket, moving there. ");
				user.purchaseTickets();
				accountPageManager();
			} else if(choice == 3) {
				System.out.println("You selected view tickets, viewing. ");
				user.viewTickets();
				accountPageManager();
			} else if(choice == 4) {
				System.out.println("You selected empty cart, emptying... ");
				user.emptyCart();
				accountPageManager();
			} else if(choice == 5) {
					System.out.println("You selected exit, exiting... ");
					System.exit(0);
			} else {
				System.out.println("Your choice was invalid, choose again. ");
			}
		}
	}
	
	
	private static void setUpShowtimePage() {
		showtimePage.setDisplay(     
	 		 						"                                             	 \n" +
	 		 						"  *******************    ******************* 	 \n" +
	 		 						"  *                 *    *                 * 	 \n" +
	 		 						"  *  0: View Seats  *    *  1: View Cart   * 	 \n" +
	 		 						"  *                 *    *                 * 	 \n" +
	 		 						"  *******************    ******************* 	 \n" +
	 		 						"                                             	 \n" +
	 		 						"  *******************    ******************* 	 \n" +
	 		 						"  *                 *    *                 * 	 \n" +
	 		 						"  * 2: Purchase Tix *    * 3: View Tickets * 	 \n" +
	 		 						"  *                 *    *                 * 	 \n" +
	 		 						"  *******************    ******************* 	 \n" +
	 		 						"                                                \n" +
	 		 						"  *******************    ******************* 	 \n" +
	 		 						"  *                 *    *                 * 	 \n" +
	 		 						"  *  4: Empty Cart  *    *     5: Exit     * 	 \n" +
	 		 						"  *                 *    *                 * 	 \n" +
									"  *******************    ******************* 	 \n");
	}
	
	
	
	// welcomes the user with greeting messages
	private static void welcomeUser() {
		System.out.println("-------------------------------------------------------");
		System.out.println("                Welcome to CinemaStack!");
		System.out.println("-------------------------------------------------------");
		System.out.println("~~~ Please enjoy the fine services we have to offer ~~~\n");
	}
	
	public static void main(String[] args) {
		
		setUpHomePage();
		setUpSearchPage();
		setUpAdminPage();
		setUpEmployeePage();
		setUpEventsPage();
		
		// create input stream
		in = new Scanner(System.in);
		
		// welcome user
		welcomeUser();
		
		// get the user to login or continue as guest
		user = GenerateUser.generateUser();
		
		// start user off on the home page
		homePageManager();
		
		// close input stream
		in.close();
		
	}
}