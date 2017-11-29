import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class JUnit2 {

	@Test
	public void test() {
		ArrayList<Integer> ratings = new ArrayList<>();
		ArrayList<String> comments = new ArrayList<>();
		Application test=new Application(null, null, null, null, null, 0, 0, 0, comments, comments);
			test.setType("for computer");
			assertTrue(test.getType()=="for computer");
			
}
	@Test
	public void setname(){
		ArrayList<Integer> ratings = new ArrayList<>();
		ArrayList<String> comments = new ArrayList<>();
		Application test1=new Application(null, "mail", null, null, null, 0, 0, 0, comments, comments);
		
		assertEquals("mail",test1.getName());
		
		
	}
	@Test
	public void setdeveloper(){
		ArrayList<Integer> ratings = new ArrayList<>();
		ArrayList<String> comments = new ArrayList<>();
		Application test3=new Application("for computer","mail","test","communition","ios",100,2.0,3.2,ratings,comments);
		test3.setDeveloper("lll");
		assertTrue(test3.getDeveloper()=="lll");
		
	}
	@Test
	public void setdecription(){
		ArrayList<Integer> ratings = new ArrayList<>();
		ArrayList<String> comments = new ArrayList<>();
		Application test4=new Application("for computer","mail","test","communition","ios",100,2.0,3.2,ratings,comments);
		test4.setDescription("communition");
		assertTrue(test4.getDescription()=="communition");
		
	}
	@Test
	public void setplatform(){
		ArrayList<Integer> ratings = new ArrayList<>();
		ArrayList<String> comments = new ArrayList<>();
		Application test5=new Application("for computer","mail","test","communition","ios",100,2.0,3.2,ratings,comments);
		test5.setPlatform("ios");
		assertTrue(test5.getPlatform()=="ios");
		
		
	}
	@Test
	public void downoads(){
		ArrayList<Integer> ratings = new ArrayList<>();
		ArrayList<String> comments = new ArrayList<>();
		Application test6=new Application("for computer","mail","test","communition","ios",100,2.0,3.2,ratings,comments);
		
		test6.setDownloads(100);
		assertTrue(test6.getDownloads()==100);
		
	}
	@Test
	public void version(){
		ArrayList<Integer> ratings = new ArrayList<>();
		ArrayList<String> comments = new ArrayList<>();
		Application test7=new Application("for computer","mail","test","communition","ios",100,2.0,3.2,ratings,comments);
		test7.setVersion(2.5);
		assertTrue(test7.getVersion()==2.5);
		
	}
	@Test
	public void price(){
		ArrayList<Integer> ratings = new ArrayList<>();
		ArrayList<String> comments = new ArrayList<>();
		Application test8=new Application("for computer","mail","test","communition","ios",100,2.0,3.2,ratings,comments);
		test8.setPrice(3.33);
		assertTrue(test8.getPrice()==3.33);
	}

	
	
	
}