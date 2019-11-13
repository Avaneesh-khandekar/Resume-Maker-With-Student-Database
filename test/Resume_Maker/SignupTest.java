package Resume_Maker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)	
public class SignupTest {
    Signup instance;
    public SignupTest() {
    }
    @Before
    public void setUp() {
        instance = new Signup();
    }
    @After
    public void tearDown() {
        instance.dispose();
    }
    @Test
    public void A_testCorrectSignUp() throws InterruptedException {
        System.out.println("Test for New Signup.");
        instance.setVisible(true);
        instance.name.setText("yeet");
        Thread.sleep(500);
        instance.password.setText("abc");
        Thread.sleep(500);
        instance.Signup.doClick();
        Thread.sleep(500);
        try {
            assertTrue(instance.status);
            System.out.println("Success.");
        } catch (Exception e) {
            fail(e.toString());
        }
    }
    @Test
    public void B_testExistingSignUp() throws InterruptedException {
        System.out.println("Test for Existing Signup.");
        instance.setVisible(true);
        instance.name.setText("avaneesh");
        Thread.sleep(500);
        instance.password.setText("abc");
        Thread.sleep(500);
        instance.Signup.doClick();
        Thread.sleep(500);
        try {
            assertFalse( instance.status);
            System.out.println("Username is already taken.");
        } catch (Exception e) {
            fail(e.toString());
        }        
    }
    @Test
    public void C_testValidUsernameEmpty() throws InterruptedException {
        System.out.println("Test for Username empty.");
        instance.setVisible(true);
        instance.name.setText("");
        Thread.sleep(500);
        instance.password.setText("abc");
        Thread.sleep(500);
        instance.Signup.doClick();
        Thread.sleep(500);
        try {
            assertFalse(instance.status);
            System.out.println("Username cannot be empty.");
        } catch (Exception e) {
            fail(e.toString());
        }
    }
    @Test
    public void D_testValidPasswordEmpty() throws InterruptedException {
        System.out.println("Test for Password empty.");
        instance.setVisible(true);
        instance.name.setText("abcd");
        Thread.sleep(500);
        instance.password.setText("");
        Thread.sleep(500);
        instance.Signup.doClick();
        Thread.sleep(500);
        try {
            assertFalse(instance.status);
            System.out.println("Username cannot be empty.");
        } catch (Exception e) {
            fail(e.toString());
        }
    }
    @Test
    public void E_testValidLongUsername() throws InterruptedException {
        System.out.println("Test for Long Username.");
        instance.setVisible(true);
        instance.name.setText("abcdabcdabcd");
        Thread.sleep(500);
        instance.password.setText("ab");
        Thread.sleep(500);
        instance.Signup.doClick();
        Thread.sleep(500);
        try {
            assertFalse(instance.status);
            System.out.println("Username cannot exceed 10 characters.");
        } catch (Exception e) {
            fail(e.toString());
        }
    }
    @Test
    public void F_testValidUsernameSpacesAndDigits() throws InterruptedException {
        System.out.println("Test for Username containing spaces and digits.");
        instance.setVisible(true);
        instance.name.setText("a1234 bcd");
        Thread.sleep(500);
        instance.password.setText("ab");
        Thread.sleep(500);
        instance.Signup.doClick();
        Thread.sleep(500);
        try {
            assertFalse(instance.status);
            System.out.println("Username cannot contain spaces or digits.");
        } catch (Exception e) {
            fail(e.toString());
        }
    }
    @Test
    public void G_testValidPasswordSpaces() throws InterruptedException{
        System.out.println("Test for Password containing white space.");
        instance.setVisible(true);
        instance.name.setText("scsc");
        Thread.sleep(500);
        instance.password.setText("ab  a");
        Thread.sleep(500);
        instance.Signup.doClick();
        Thread.sleep(500);
        try {
            assertFalse(instance.status);
            System.out.println("Password cannot containg white spaces.");
        } catch (Exception e) {
            fail(e.toString());
        }
    }
     @Test
    public void H_testLogout() throws InterruptedException {
        System.out.println("Test Case for Back button");
        instance.setVisible(true);
        //boolean expResult = true;
        Thread.sleep(500);
        instance.Back.doClick();
        Thread.sleep(500);
        try{
            assertTrue(instance.status);
            System.out.println("Succesful.");
        }catch(AssertionError e){        
            fail(e.toString());
        }
    }
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Signup.main(args);
    }
}