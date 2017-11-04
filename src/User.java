import java.io.RandomAccessFile;
import java.util.ArrayList;

public class User {
	public String userName;
	public String passWord;
	private RandomAccessFile out;
//	public static ArrayList<String> name = new ArrayList<>();
//	public static ArrayList<String> pw = new ArrayList<>();
	
	public User(String userName, String passWord){
		this.userName = userName;
		this.passWord = passWord;
//		this.name = name;
//		this.pw = pw;
	}
	
	public User(){
		this("","");
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
		 try{
			 out = new RandomAccessFile("UserData.txt","rw");
			 long length = out.length();
			 out.seek(length);
			 out.writeBytes(userName + "\n");
			 out.close();
		 }
		 catch(Exception p) {}
		
//		name.add(userName);
		
	}
//	public static ArrayList<String> getName() {
//		return name;
//	}
//	public static ArrayList<String> getPw() {
//		return pw;
//	}
	public String getPassword() {
		return passWord;
	}
	public void setPassword(String password) {
		this.passWord = password;
		try{
			 out = new RandomAccessFile("UserData.txt","rw");
			 long length = out.length();
			 out.seek(length);
			 out.writeBytes(password + "\n");
			 out.close();
		 }
		 catch(Exception p) {}
		
	}
	public static void addRating(Application a, int rate){
		a.getRatings().add(rate);
	}
	public static void addComment(Application a, String comment){
		a.getComments().add(comment);
	}
	public void submitRequestForm(Application a){
		
	}
	
	public boolean downloadApp(Application a){
		if(a.downloads == 100){
			return true;
		}
		return false;
	}
	
}
