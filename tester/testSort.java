import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class testSort {

	@Test
	public void test() {
		fail("Not yet implemented");
		
	}
	@Test
	public void sortByName(Application[] app){
		ArrayList<Integer> ratings = new ArrayList<>();
		ArrayList<String> comments = new ArrayList<>();
		Application junit=new Application("for computer","mail","test","communition","ios",100,2.0,3.2,ratings,comments);
		
		
}	@Test
	public static Application[] sortByPrice(Application[] app){
		Application a =new Application(null, null, null, null, null, 0, 0, 0, null, null);
		a.sortByName(app);
		
		return app;
	}
	@Test
	public static Application[] sortByType(Application[] app){
	
	return null;

	}
}
