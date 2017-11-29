import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.junit.rules.TemporaryFolder;



public class JUnit extends User{
	private String testname;
	
	
	@Test
	public void testSetname() {
		User test=new User();
		test.userName="abc";
		assertEquals("abc",test.getUserName());
		test.userName="aaa";
		assertEquals("aaa",test.getUserName());
	}
	@Test
	public void setPassword(){
		User test1=new User();
		
		assertEquals("",test1.passWord);
	}
	
	public TemporaryFolder folder = new TemporaryFolder();
	@Test
	public void testUsingFolder()throws IOException{
		File createdFolder = folder.newFolder("rw");
		File createdFile = folder.newFile("UserData.txt");
		asserTure(createdFile.exists());
	}

	private void asserTure(boolean exists) {
		// TODO Auto-generated method stub
		
	}
	
	
		
		
	}
	
	
	
	

