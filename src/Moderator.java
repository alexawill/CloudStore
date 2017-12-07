import java.util.ArrayList;


public class Moderator extends User {
	
	public Moderator() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Moderator(String userName, String passWord) {
		super(userName, passWord);
		// TODO Auto-generated constructor stub
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
