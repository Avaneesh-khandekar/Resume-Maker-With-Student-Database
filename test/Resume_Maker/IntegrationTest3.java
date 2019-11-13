package Resume_Maker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class IntegrationTest3 {
	ResumeMaker one;
	StudentResume two;
	public IntegrationTest3() {
		
	}
	@Before
	public void setUp() {
		one = new ResumeMaker();
		one.setVisible(true);
		
	}
	
	@After
	public void tearDown() {
	}
	@Test
	public void test() throws InterruptedException {
		System.out.println("Test for Student Login.");
		try {
			assertTrue(one.isShowing());
		} catch (Exception e) {
			fail(e.toString());
		}
		one.name.setText("avaneesh");
		Thread.sleep(500);
		one.password.setText("abcd");
		Thread.sleep(500);
		one.combo.setSelectedItem("Student");
		Thread.sleep(500);
		one.Login.doClick();
		Thread.sleep(500);
		try {
			assertTrue(one.status);
			System.out.println("Login Successful.");
		} catch (Exception e) {
			fail(e.toString());
		}
		one.dispose();
		System.out.println("Test for Student Generating Resume.");
		two=new StudentResume(one.name.getText());
		two.setVisible(true);
		two.Generate.doClick();
		Thread.sleep(500);
		try {
			assertTrue(two.status);
			System.out.println("Resume Generated Successfully.");
		} catch (Exception e) {
			fail("Cancelled by user"+e.toString());
		}
		two.Logout.doClick();
		try {
			assertFalse(two.isShowing());
		} catch (Exception e) {
			fail(e.toString());
		}
		
	}

	@Test
	public void testMain() {
		System.out.println("main");
		String[] args = null;
		ResumeMaker.main(args);
		// TODO review the generated test code and remove the default call to fail.
		//fail("The test case is a prototype.");
	}
	
}
