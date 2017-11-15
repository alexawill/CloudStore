import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class JUnit {

	
	@Test
	public void testSetname() {
		User test=new User();
		test.setUserName("abc");
		assertTrue(test.getUserName()=="abc");
	}

	public void setPassword(){
		User test=new User();
		test.setPassword("123");
		assertTrue(test.getPassword()=="123");
	}
	

}
