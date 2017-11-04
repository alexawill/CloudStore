import java.util.ArrayList;

public class Application {

	public String type, name, developer, description, platform;
	public int downloads;
	public double version, price;
	public static ArrayList<Integer> ratings = new ArrayList<>();
	public static ArrayList<String> comments = new ArrayList<>();

	public Application(String type, String name, String developer, String description, String platform, int downloads,
			double version, double price, ArrayList ratings, ArrayList comments) {
		super();
		this.type = type;
		this.name = name;
		this.developer = developer;
		this.description = description;
		this.platform = platform;
		this.downloads = downloads;
		this.version = version;
		this.price = price;
		this.ratings = ratings;
		this.comments = comments;
	}


	// Methods
	
	public static void addRating(int rate) {
	

		ratings.add(rate);
	}
	
	public static void addComment(String comment) {
		
	}

	
	
	
	@Override
	public String toString() {
		return "$" + price;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDeveloper() {
		return developer;
	}


	public void setDeveloper(String developer) {
		this.developer = developer;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getPlatform() {
		return platform;
	}


	public void setPlatform(String platform) {
		this.platform = platform;
	}


	public int getDownloads() {
		return downloads;
	}


	public void setDownloads(int downloads) {
		this.downloads = downloads;
	}


	public double getVersion() {
		return version;
	}


	public void setVersion(double version) {
		this.version = version;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public static ArrayList<Integer> getRatings() {
		return ratings;
	}


	public static void setRatings(ArrayList<Integer> ratings) {
		Application.ratings = ratings;
	}


	public static ArrayList<String> getComments() {
		return comments;
	}


	public static void setComments(ArrayList<String> comments) {
		Application.comments = comments;
	}
	
	//----------------------------------------------------------------------compare method
	
	public void comparePrice(Object other){
		Application another = (Application) other;
		System.out.println("Price : " + price+ "(Now viewing.)");
		System.out.println("Price : " + another.getPrice());
	}
	
	public void compareVersion(Object other){
		Application another = (Application) other;
		System.out.println("Version : " + version +"(Now viewing.)");
		System.out.println("Version : " + another.getVersion());
	}
	
	
	


	

}