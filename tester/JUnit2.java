import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class JUnit2 {

	@Test
	public void test() {
		ArrayList<Integer> ratings = new ArrayList<>();
		ArrayList<String> comments = new ArrayList<>();
		Application test=new Application("for computer","mail","test","communition","ios",100,2.0,3.2,ratings,comments);
			test.setType("for computer");
			assertTrue(test.getType()=="for computer");
			
}
	public void setname(){
		ArrayList<Integer> ratings = new ArrayList<>();
		ArrayList<String> comments = new ArrayList<>();
		Application test2=new Application("for computer","mail","test","communition","ios",100,2.0,3.2,ratings,comments);
		test2.setName("mail");
		assertTrue(test2.getName()=="mail");
		
		
	}
	public void setdeveloper(){
		ArrayList<Integer> ratings = new ArrayList<>();
		ArrayList<String> comments = new ArrayList<>();
		Application test3=new Application("for computer","mail","test","communition","ios",100,2.0,3.2,ratings,comments);
		test3.setDeveloper("lll");
		assertTrue(test3.getDeveloper()=="lll");
		
	}
	
	public void setdecription(){
		ArrayList<Integer> ratings = new ArrayList<>();
		ArrayList<String> comments = new ArrayList<>();
		Application test4=new Application("for computer","mail","test","communition","ios",100,2.0,3.2,ratings,comments);
		test4.setDescription("communition");
		assertTrue(test4.getDescription()=="communition");
		
	}
	public void setplatform(){
		ArrayList<Integer> ratings = new ArrayList<>();
		ArrayList<String> comments = new ArrayList<>();
		Application test5=new Application("for computer","mail","test","communition","ios",100,2.0,3.2,ratings,comments);
		test5.setPlatform("ios");
		assertTrue(test5.getPlatform()=="ios");
		
		
	}
	public void downoads(){
		ArrayList<Integer> ratings = new ArrayList<>();
		ArrayList<String> comments = new ArrayList<>();
		Application test6=new Application("for computer","mail","test","communition","ios",100,2.0,3.2,ratings,comments);
		
		test6.setDownloads(100);
		assertTrue(test6.getDownloads()==100);
		
	}
	public void version(){
		ArrayList<Integer> ratings = new ArrayList<>();
		ArrayList<String> comments = new ArrayList<>();
		Application test7=new Application("for computer","mail","test","communition","ios",100,2.0,3.2,ratings,comments);
		test7.setVersion(2.5);
		assertTrue(test7.getVersion()==2.5);
		
	}
	public void price(){
		ArrayList<Integer> ratings = new ArrayList<>();
		ArrayList<String> comments = new ArrayList<>();
		Application test8=new Application("for computer","mail","test","communition","ios",100,2.0,3.2,ratings,comments);
		test8.setPrice(3.33);
		assertTrue(test8.getPrice()==3.33);
	}
	
	
	
	
	
}