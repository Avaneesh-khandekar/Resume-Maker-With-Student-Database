/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resume_Maker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class AdminCreateStudentTest {
    AdminCreateStudent instance;
    public AdminCreateStudentTest() {
    }
    @Before
    public void setUp() {
        instance = new AdminCreateStudent();
    }
    
    @After
    public void tearDown() {
        instance.dispose();
    }
    @Test
    public void testCorrectSignUp() throws InterruptedException {
        instance.setVisible(true);
        System.out.println("Test Case for Correct Signup.");
        instance.name.setText("xyabx");
        Thread.sleep(500);
        instance.password.setText("abc");
        Thread.sleep(500);
        instance.Proceed.doClick();
        Thread.sleep(500);
        try {
        assertTrue(instance.status);
        System.out.println("Succesful.");
    } catch (AssertionError e) {
        fail(e.toString());
    }
        
    }
    public void testExistingSignUp() throws InterruptedException {
        instance.setVisible(true);
        System.out.println("Test Case for Correct Signup.");
        instance.name.setText("avaneesh");
        Thread.sleep(500);
        instance.password.setText("abc");
        Thread.sleep(500);
        instance.Proceed.doClick();
        Thread.sleep(500);
        try {
        assertFalse(instance.status);
        System.out.println("Succesful.");
    } catch (AssertionError e) {
        fail(e.toString());
    }
        
    }
    @Test
    public void testValidUsernameEmpty() throws InterruptedException {
        System.out.println("Test Case for Username Empty.");
        instance.setVisible(true);
        instance.name.setText("");
        Thread.sleep(500);
        instance.password.setText("abc");
        Thread.sleep(500);
        instance.Proceed.doClick();
        try {
            assertFalse(instance.status);
            System.out.println();
        } catch (AssertionError e) {
            fail(e.toString());
        }
        
    }
    @Test
    public void testValidPasswordEmpty() throws InterruptedException {
        System.out.println("Test Case for Password Empty.");
        instance.setVisible(true);
        instance.name.setText("abcd");
        Thread.sleep(500);
        instance.password.setText("");
        Thread.sleep(500);
        instance.Proceed.doClick();
        Thread.sleep(500);
        try {
            instance.Proceed.doClick();
            assertFalse(instance.status);
        } catch (AssertionError e) {
            fail(e.toString());
        }
        
    }
    @Test
    public void testValidLongUsername() throws InterruptedException {
        System.out.println("Test Case for Long Username.");
        instance.setVisible(true);
        instance.name.setText("abcd1234abcd");
        Thread.sleep(500);
        instance.password.setText("ab");
        Thread.sleep(500);
        instance.Proceed.doClick();
        Thread.sleep(500);
        try {
            assertFalse(instance.status);
        } catch (AssertionError e) {
            fail(e.toString());
        }
        
    }
     @Test
    public void testValidUsernameSpacesAndDigits() throws InterruptedException {
        System.out.println("Test Case for Username containing spaces and digits.");
        instance.setVisible(true);
        instance.name.setText("abcd1234a bcd");
        Thread.sleep(500);
        instance.password.setText("ab");
        Thread.sleep(500);
        instance.Proceed.doClick();
        Thread.sleep(500);
         try {
             assertFalse(instance.status);
         } catch (AssertionError e) {
             fail(e.toString());
         }
         
    }
     public void testValidPasswordSpaces() throws InterruptedException{
         System.out.println("Test Case for Password containing spaces.");
         instance.setVisible(true);
        instance.name.setText("abcdsdabcd");
        Thread.sleep(500);
        instance.password.setText("ab 4");
        Thread.sleep(500);
        instance.Proceed.doClick();
        Thread.sleep(500);
         try {
             assertFalse(instance.status);
         } catch (AssertionError e) {
             fail(e.toString());
         }
         
    }
    @Test
    public void testBack() throws InterruptedException {
        System.out.println("Test Case for Back Button.");
        instance.setVisible(true);
        Thread.sleep(500);
        instance.Back.doClick();
        try {
            assertFalse(instance.isShowing());
            System.out.println("Successful");
        } catch (Exception e) {
            fail(e.toString());
        }
        
    }
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        AdminCreateStudent.main(args);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
