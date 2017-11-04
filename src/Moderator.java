import java.util.ArrayList;


public class Moderator extends User {
	
	public Moderator(){
		this("","");
	}
	
	public Moderator(String userName, String passWord){
		super(userName,passWord);
	}
	
	public boolean deleteComment(Object a, String comment){
		Application app = (Application) a;
		ArrayList<String> c = app.getComments();
		int length = c.size();
		for(int i = 0; i < length; i++){
			if(c.contains(comment)){
				c.remove(comment);
				return true;
			}
		}
		return false;
	}

}
