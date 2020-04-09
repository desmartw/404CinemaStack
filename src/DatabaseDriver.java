import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DatabaseDriver {
	public static Scanner scan = new Scanner(System.in);
	public static EventDatabase ev = new EventDatabase();
	public static EventDatabaseReborn evr = new EventDatabaseReborn(); ///
	public static LocationDatabase lv = new LocationDatabase();
	public static ScheduleDatabase sv = new ScheduleDatabase();
	public static UserDatabase uv = new UserDatabase();
	
	public static void enterEventAndConstruct() {
		evr.enterEvent();
	}
	
	// print all the attributes of all events
	public static void printAllEvents() {
		ev.readAllEvents();
	}
	
	public static ArrayList<Event> returnAllEventsAsArrayList() {
		return ev.returnAllEventsAsArrayList();
	}
	
	public static void enterNewEvent() {
		ev.enterEvent();
	}
	
	public static void enterNewEventWithLocation(String loc) {
		
		ev.enterEvent(loc);
	}
	
	public static void wipeEventDatabase() {
		ev.wipeDatabase();
	}
	
	public static Event returnEvent(String name) {
		return ev.returnEventObjectByName(name);
	}
	
	public static void displayAllEvents() {
		ev.readAllEventsForUser();
	}
	
	public static void enterComment(String eventName, String comment) {
		ev.addCommentToEvent(eventName, comment);
		System.out.println("Comment saved.");
	}
	
	public static void enterRating() {
		String name = "";
		ArrayList<String> names = ev.getAllEventNames();
		while(true) {
			System.out.println("Enter the name of your event:");
			name = scan.nextLine();
			if (names.contains(name)) 
				break;
			else 
				System.out.println("Event does not exist.");
		}
		int rating;
		do {
			System.out.println("Enter a number between 0 and 5 to rate " + name + ".");
			while (!scan.hasNextInt()) {
	            String input = scan.next();
	            System.out.printf("\"%s\" is not a valid number.\n", input);
			}
			rating = scan.nextInt();
			scan.nextLine();
		} while (rating < 0 || rating > 5);
		String ratingStr = String.valueOf(rating);
		ev.addRatingToEvent(name, ratingStr);
		System.out.println("Rating saved.");
	}
	
	public static void enterNewLocation() {
		lv.enterLocation();
	}
	public static void readAllLocations() {
		lv.readAllLocations();
	}
	
	public static void enterNewSchedule() {
		sv.enterSchedule();
	}
	public static void printAllSchedules() {
		sv.readAllSchedules();
	}
	
	public static void addUser() {
		uv.enterUser();
	}
	public static void wipeUserDatabase() {
		uv.wipeDatabase();
	}
	public static void printCredentials() {
		uv.readAllCredentials();
	}

	
	
	
	// find an event based on its name, return an Event object
	
	
	public static void main(String[] args) {
		//UserDatabase db = new UserDatabase();
		//db.readAllCredentials();
		//User user = GenerateUser.generateUser();
		//db.readAllCredentials();
		//printAllEvents();
		//Event event = returnEvent("Frozen 2");
		//event.printEvent();
		//enterComment("Frozen 2", "I loved it so much it gave me chills");
		//printAllEvents();
		//enterNewEvent();
		
		//ArrayList<Event> events = returnAllEventsAsArrayList();
		//Location loc = new Location("Regal", "Theater", 25, new ArrayList<Event>());
		//enterNewEvent(loc);
		
		//enterNewLocation();
		//enterNewEventWithLocation("Regal");
		//loc.showSeatGrid(seatGrid);
		//enterRating();
		
		//evr.enterEvent();
		//evr.writeList();
		//evr.enterEvent();
		
		evr.writeList();
		
		//evr.readList();
	}

}
