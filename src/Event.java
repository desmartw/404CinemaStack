/**
 * 
 * @author wilsdesmarteau && Ryan Henderson
 * Class: Event
 *
 */
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Event {
	
	private String name;
	private String type;
	private int ratingSum;
	private int ratingNum;
	private ArrayList<String> comments;
	private ArrayList<String> actors;
	
	/**
     * Default Constructor - all attributes are set to empty, int values are 0
     */
	public Event()
	{
	    name = "";
	    type = "";
	    ratingSum = 0;
	    ratingNum = 0;
	    comments = new ArrayList<String>();
	    actors = new ArrayList<String>();
	}
	
	/**
     * Basic Parameterized Constructor - Initializes values that stay constant across venues
     * @param name
     * @param type
     * @param actors
     */
    public Event(String name, String type, ArrayList<String> comments, ArrayList<String> actors) {
        this.name = name;
        this.type = type;
        this.comments = comments;
        this.actors = actors;
    }
	
    /**
	 * Full Parameterized Constructor
	 * @param name
	 * @param type
	 * @param ratingSum
	 * @param ratingCount
	 * @param militaryTimes
	 * @param comments
	 * @param dates
	 * @param price
     */
	public Event(String name, String type, int ratingSum, int ratingNum, ArrayList<String> comments,
	             ArrayList<String> actors) {
	    this.name = name;
	    this.type = type;
	    this.ratingSum = ratingSum;
	    this.ratingNum = ratingNum;
        this.comments = comments;	        
	    this.actors = actors;
	}
	
	
	/**
	 * printEvent method returns all attributes of this event 
	 *
	 */
	public void printEvent() {
		System.out.println("\nName of event: "+ name);
		//System.out.print("Times: | ");
		//militaryTimes.forEach(militaryTime ->{System.out.print(militaryTime + " | ");});
		System.out.println("Type: " + type);
		System.out.println("Rating: " + getAverageRating());
		//System.out.println("Number of ratings: " + numOfRatings);
		//System.out.println("Rating: " + sumOfRatings);
		System.out.print("Comments: | ");
		comments.forEach(comment ->{System.out.print(comment + " | ");});
		System.out.println("\n");
		//System.out.println("\nPrice: " + price);
		
	}

	
	
	//getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getRatingSum() {
		return ratingSum;
	}
	public void setRatingSum(int ratingSum) {
		this.ratingSum = ratingSum;
	}
	public int getRatingNum() {
		return ratingNum;
	}
	public void setRatingNum(int ratingNum) {
		this.ratingNum = ratingNum;
	}
	public ArrayList<String> getComments() {
		return comments;
	}
	public void setComments(ArrayList<String> comments) {
		this.comments = comments;
	}
	public ArrayList<String> getActors() {
		return actors;
	}
	public void setActors(ArrayList<String> actors) {
		this.actors = actors;
	}
	
	/**
	 * This function adds a rating to the running average
	 * @param rating - new rating to be added to the average rating
	 */
	public void addUserRating(int ratingSum) {
		this.ratingSum += ratingSum;
		this.ratingNum++;
	}
	
	/**
	 * 
	 * @return double value of average rating 
	 */
	@JsonIgnore
	public double getAverageRating() {
		if (this.ratingNum == 0) {
			return 0;
		}
		else {
			return (double) (this.ratingSum/this.ratingNum);
		}
	}
	
	/**
	 * Adds a user's comment to the list of comments held in this event
	 * @param user - User who makes the comment
	 * @param comment - String of what the user wants to comment
	 */
	public void addUserComment(String comment) {
		comments.add(comment);
	}
}