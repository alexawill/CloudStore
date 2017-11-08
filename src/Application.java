import java.util.ArrayList;

public class Application {

	public String type, name, developer, description, platform, version, price;
	public int downloads;
	public static ArrayList<Double> ratings = new ArrayList<>();
	public static ArrayList<String> comments = new ArrayList<>();

	public Application(String type, String name, String developer, String description, String platform, 
			String version, String price) {
		super();
		this.type = type;
		this.name = name;
		this.developer = developer;
		this.description = description;
		this.platform = platform;
		downloads = 0;
		this.version = version;
		this.price = price;
		ratings = new ArrayList<Double>();
		comments = new ArrayList<String>();
	}


	// Methods
	
	public static void addRating(double rate) {
	

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


	public String getVersion() {
		return version;
	}


	public void setVersion(String version) {
		this.version = version;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public static ArrayList<Double> getRatings() {
		return ratings;
	}


	public static void setRatings(ArrayList<Double> ratings) {
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