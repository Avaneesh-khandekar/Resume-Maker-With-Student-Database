
package Resume_Maker;

import java.text.ParseException;
import java.util.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class IntegrationTest2 {
	ResumeMaker one;
	Signup two;
	StudentResume three;
	Functions F;
	public IntegrationTest2() {
	}	
	@Before
	public void setUp() {
		one = new ResumeMaker();
		one.setVisible(true);
		two = new Signup();
		F=new Functions();
	}
	
	@After
	public void tearDown() {
		one.dispose();
		one.setVisible(true);
		two.dispose();
	}
	@Test
	public void testNew() throws InterruptedException, ParseException {
		try {
			assertTrue(one.isShowing());
		} catch (Exception e) {
			fail(e.toString());
		}
		System.out.println("Test for New Student.");
        one.Signup.doClick();
        Thread.sleep(500);
        try {
            assertTrue(one.status);
            System.out.println("Succesful.");
        } catch (Exception e) {
            fail(e.toString());
        }
		one.dispose();
		two.setVisible(true);
		System.out.println("Test for New Student Credentials.");
		two.name.setText("Barca");
        Thread.sleep(500);
        two.password.setText("ten");
        Thread.sleep(500);
        two.Signup.doClick();
        Thread.sleep(500);
        try {
            assertTrue(two.status);
            System.out.println("Success.");
        } catch (Exception e) {
            fail(e.toString());
        }
		two.dispose();
		three = new StudentResume(two.name.getText());
		System.out.println("Test Case for Saving Data");
        three.setVisible(true);
        Thread.sleep(500);
        three.id.setText("567");
        Thread.sleep(380);
        three.firstname.setText("abc");
        Thread.sleep(380);
        three.surname.setText("abc");
        Thread.sleep(380);
        three.ad1.setText("abc");
        Thread.sleep(380);
        three.ad2.setText("abc");
        Thread.sleep(380);
        three.nationality.setText("123");
        Thread.sleep(380);
        Date d = new Date();
        String dd = F.sdf.format(d);
        three.dob.setDate(F.sdf.parse(dd));
        three.contact.setText("6547894512");
        Thread.sleep(380);
        three.email.setText("abc@123.com");
        Thread.sleep(380);
        three.skill1.setText("Py");
        Thread.sleep(380);
        three.skill2.setText("Jv");
        Thread.sleep(380);
        three.skill3.setText("Cpp");
        Thread.sleep(380);
        three.company.setText("xyz");
        Thread.sleep(380);
        three.work.setText("pqr");
        Thread.sleep(380);
        three.college.setText("MMCOE");
        Thread.sleep(380);
        three.title.setText("BE");
        Thread.sleep(380);
        three.gpa.setText("1.23");
        Thread.sleep(500);
        three.Save.doClick();
        try {
            assertEquals(true, three.status);
            System.out.println("Data Saved Successfully.");
        } catch (Exception e) {
            fail(e.toString());
        }
		three.Clear.doClick();
		try {
            assertEquals(true, three.status);
            System.out.println("Data Saved Successfully.");
        } catch (Exception e) {
            fail(e.toString());
        }
		Thread.sleep(500);
		three.Logout.doClick();
		try {
            assertEquals(false, three.isShowing());
            System.out.println("Successfull.");
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
	//	fail("The test case is a prototype.");
	}
	
}
