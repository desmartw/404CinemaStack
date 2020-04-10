// TODO delete unused imports
	import java.util.Scanner;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Arrays;
	import java.util.Iterator;

	import javax.swing.JPasswordField;
	import javax.swing.JOptionPane;

	import java.io.FileWriter;

	import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
	import java.io.FileReader;

	import org.json.simple.JSONArray;
	import org.json.simple.JSONObject;
	import org.json.simple.parser.JSONParser;
	import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LocationDatabase {
	public static final int NONE = -1;
	
	private ArrayList<Location> list = new ArrayList<Location>();
	public static final Scanner scan = new Scanner(System.in);
	private File file = new File("locations.json");
	private ObjectMapper mapper = new ObjectMapper();
	
	// deleteme
    JSONArray locationList;
    
    /*
    /**
     * default constructor
     *
    public LocationDatabase() {
        locationList = new JSONArray();
        scan = new Scanner(System.in);
    }
    */
    
    /**
     * Allows creation of new locations
     */
    public void enterLocation() {
        System.out.println();
        String name = validateName();
        String description = validateDescription();
        int seatingRows = validateSeatingRows();
        int seatingCols = validateSeatingCols();
        int handicapStartSeat = 1;
        int handicapEndSeat = validateHandicapSeatCount();
        if (handicapEndSeat == NONE)
        	handicapStartSeat = NONE;
        ArrayList<Showtime> showtimes = new ArrayList<Showtime>();
        refreshList();
        Location loc = new Location(name, description, seatingRows, seatingCols, handicapStartSeat, handicapEndSeat, showtimes);      ////change
        writeList(loc);
        /*
        org.json.JSONObject locationDetails = new JSONObject();
        
        locationDetails.put("Name",  name);
        locationDetails.put("Description", description);
        locationDetails.put("Password", password);
        locationDetails.put("SeatRows", seatingRows);
        locationDetails.put("SeatCols", seatingCols);
        locationDetails.put("HandicapStartSeat", handicapStartSeat);
        locationDetails.put("HandicapEndSeat", handicapStartSeat);
        locationDetails.put("Showtimes", showtimes);
        
        JSONObject locationObject = new JSONObject();
        locationObject.put("Location", locationDetails);
        
        locationList = readLocationList();
        locationList.add(locationObject);
        */
    }
    
    public int validateHandicapSeatCount() {
    	int count = 0;
    	System.out.println("Enter the number of handicapp seats in your theater between 0-5:");
    	count = scan.nextInt();
    	scan.nextLine();
    	if(count <= 0) {
    		return NONE;
    	} 
    	else if(count >= 1 && count <= 5) {
    		return count;
    	}
		return NONE;
    }
    
    public void refreshList() {
		try {
			this.list = mapper.readValue(new File("locations.json"), new TypeReference<ArrayList<Location>>(){});
		} catch(Exception e) {
			System.out.println("Error " + e);
		}
	}
    
    // arraylist to pretty json
 	public void writeList(Location loc) {
 		try {
 			this.list.add(loc);
 			mapper.writeValue(new File("locations.json"), this.list);
 		} catch(Exception e) {
 			System.out.println("Error " + e);
 		}
 	}
 	
 	// arraylist to pretty json
 	public void writeList() {
 		try {
 			mapper.writeValue(new File("locations.json"), this.list);
 		} catch(Exception e) {
 			System.out.println("Error " + e);
 		}
 	}
    
	/**
     * returns a JSONarray of locations
     * @return
     */
    public JSONArray readLocationList() {
		JSONParser jsonParser = new JSONParser();
        JSONArray readLocationList = new JSONArray();
        
        try (FileReader reader = new FileReader("location.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            readLocationList = (JSONArray) obj;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        return readLocationList;
	}
    /**
     * checks name is valid
     * @return
     */
    public String validateName() {
        String name = "";
        while (true) {
            System.out.println("Enter the name of the location:");
            name = scan.nextLine();
            if (name.length() == 0) {
                System.out.println("The name of your event cannot be empty");
                continue;
            }
            System.out.println("Location name added.");
            break;
        }
        return name;
    }
    /**
     *  Makes sure seatNumber of location is valid
     * @return
     */
    public int validateSeatingRows() {
        int seatRows = 0;
        while(true) {
        	System.out.println("Enter the seat rows you would like in range 1-25: ");
        	seatRows = scan.nextInt();
        	scan.nextLine();
        	if(seatRows == 0 || seatRows > 25) {
        		System.out.println("Your seat row number is out of range");
        		continue;
        	}
        	System.out.println("Number of rows added.");
        	break;
        }
        return seatRows;
    }
    
    private int validateSeatingCols() {
		 int seatCols = 0;
	        while(true) {
	        	System.out.println("Enter the seat col you would like in range 1-25: ");
	        	seatCols = scan.nextInt();
	        	scan.nextLine();
	        	if(seatCols == 0 || seatCols> 25) {
	        		System.out.println("Your seat col number is out of range");
	        		continue;
	        	}
	        	System.out.println("Number of cols added.");
	        	break;
	        }
	        return seatCols;
	}
    
    /**
     * Makes sure description of location is valid
     * @return
     */
    public String validateDescription() {
    	String description = "";
    	while(true) {
    		System.out.println("Enter a description of the location: ");
    		description = scan.nextLine();
    		if(description.length() <= 0 || description.length() >= 500) {
    			System.out.println("Your description is either too long or empty,"
    					+ " please make sure its between 1 and 500 characters inclusive.");
    			continue;
    		}
    		System.out.println("Description added");
    		break;
    		}
    	return description;
    }
    
    private int validateHandicapStartSeat() {
		// TODO Auto-generated method stub
    	int hStartSeat = 0;
    	System.out.println("If you would like to add handicapped seats, enter a starting seat number (between 1-5). \n"
    			+ "If not, hit 0.");
    	hStartSeat = scan.nextInt();
    	scan.nextLine();
    	if(hStartSeat <= 0) {
    		return 0;
    	} 
    	else if(hStartSeat >= 1 && hStartSeat <= 5) {
    		return hStartSeat;
    	}
		return 0;
	}
	private int validateHandicapEndSeat() {
		int hEndSeat = 0;
		System.out.println("Where would you like the handicapped seating to stop? enter a seat number (between 2-5). \n");
		while(true) {
			hEndSeat = scan.nextInt();
			scan.nextLine();
			if(hEndSeat <= 1 || hEndSeat > 5) {
				System.out.println("Invalid number, try again");
				continue;
			} 
			else {
				System.out.println("End seat added");
				break;
			}
		}
		return hEndSeat;
	}
	
	
	private String validatePassword() {
		// TODO Auto-generated method stub
		String pwd;
		while(true) {
        	System.out.println("Enter your desired password, between 3-10 char: ");
        	pwd = scan.nextLine();
        	if(pwd.length() == 0 || pwd.length() > 10) {
        		System.out.println("Your password is too long or too short, try again");
        	} 
        	System.out.println("Password saved.");
        	break;
	}
	  	return pwd;
	}
    /**
     * reads and prints locations to console
     */
    public void readAllLocations() {
		// reading
        JSONParser jsonParser = new JSONParser();
        JSONArray readLocationList = readLocationList();
        try (FileReader reader = new FileReader("users.json"))
        {
            System.out.println(readLocationList);
            //Iterate over user array
            readLocationList.forEach( location -> parseLocationObject( (JSONObject) location ) );
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } 
	}
	/**
	 * creates a location from a JSON object
	 * @param location
	 */
	public void parseLocationObject(JSONObject location) {
		JSONObject locationObject = (JSONObject) location.get("Location");
        System.out.println("\nName: " + (String) locationObject.get("Name")); 
        System.out.println("\nDescription: "+ (String) locationObject.get("Description"));
        System.out.println("\nSeat Number: "+ (int) locationObject.get("SeatNumber"));
        System.out.println("\nEvents: "+ (Event) locationObject.get("Events"));
        }
	}
	    
	



