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
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)	
public class ResumeMakerTest {
    ResumeMaker instance; 
    public ResumeMakerTest() {    
    }
    
    @Before
    public void setUp() {  
    instance = new ResumeMaker();
    }
    @After
    public void tearDown() {
    instance.dispose();
    }
    @Test
    public void A_testAdminCorrect() throws InterruptedException{
        System.out.println("Test for Correct Admin login");
        instance.setVisible(true);
        instance.name.setText("admin");
        Thread.sleep(500);
        instance.password.setText("admin");
        Thread.sleep(500);
        instance.combo.setSelectedItem("Admin");
        Thread.sleep(500);
        instance.Login.doClick();
        Thread.sleep(500);
        try {
            assertTrue(instance.status);
            System.out.println("Success.");
        } catch (Exception e) {
            fail(e.toString());
        }        
    }
    @Test
    public void B_testWrongAdminCredentials() throws InterruptedException{
        System.out.println("Test for Wrong Admin Credentials");
        instance.setVisible(true);
        instance.name.setText("avaneesh");
        Thread.sleep(500);
        instance.password.setText("adminsd");
        Thread.sleep(500);
        instance.combo.setSelectedItem("Admin");
        Thread.sleep(500);
        instance.Login.doClick();
        Thread.sleep(500);
        try {
            assertFalse(instance.status);
            System.out.println("The Admin with given username and password combination not found.");
        } catch (Exception e) {
            fail(e.toString());
        }
    }
    @Test
    public void C_testWrongAdminCategory() throws InterruptedException{
        System.out.println("Test for Wrong Admin Category");
        instance.setVisible(true);
        instance.name.setText("admin");
        Thread.sleep(500);
        instance.password.setText("admin");
        Thread.sleep(500);
        instance.combo.setSelectedItem("Student");
        Thread.sleep(500);
        instance.Login.doClick();
        Thread.sleep(500);
        try {
            assertFalse(instance.status);
            System.out.println("Student with given username and password combination not found.");
        } catch (Exception e) {
            fail(e.toString());
        }
    }
    @Test
    public void D_testStudentCorrect() throws InterruptedException{
        System.out.println("Test for Correct Student login");
        instance.setVisible(true);
        instance.name.setText("avaneesh");
        Thread.sleep(500);
        instance.password.setText("abcd");
        Thread.sleep(500);
        instance.combo.setSelectedItem("Student");
        Thread.sleep(500);
        instance.Login.doClick();
        Thread.sleep(500);
        assertTrue(instance.status);
        System.out.println("Success.");
    } 
    @Test
    public void E_testWrongStudentCredentials() throws InterruptedException{
        System.out.println("Test for Wrong Student Credentials");
        instance.setVisible(true);
        instance.name.setText("abcdasd");
        Thread.sleep(500);
        instance.password.setText("abcddyhn");
        Thread.sleep(500);
        instance.combo.setSelectedItem("Student");
        Thread.sleep(500);
        instance.Login.doClick();
        Thread.sleep(500);
        try {
            assertFalse(instance.status);
            System.out.println("Student with given username and password combination not found.");
        } catch (Exception e) {
            fail(e.toString());
        }
    }   
    @Test
    public void F_testWrongStudentCategory() throws InterruptedException{
        System.out.println("Test for Wrong Student Category");
        instance.setVisible(true);
        instance.name.setText("avaneesh");
        Thread.sleep(500);
        instance.password.setText("abcd");
        Thread.sleep(500);
        instance.combo.setSelectedItem("Admin");
        Thread.sleep(500);
        instance.Login.doClick();
        Thread.sleep(500);
        try {
            assertFalse(instance.status);
            System.out.println("The Admin with given username and password combination not found.");
        } catch (Exception e) {
            fail(e.toString());
        }
    }
    @Test
    public void G_testValidUsernameEmpty() throws InterruptedException {
        System.out.println("Test for Username empty.");
        instance.setVisible(true);
        instance.name.setText("");
        Thread.sleep(500);
        instance.password.setText("admin");
        Thread.sleep(500);
        instance.Login.doClick();
        Thread.sleep(500);
        try {
            assertFalse(instance.status);
            System.out.println("Username cannot be empty.");
        } catch (Exception e) {
            fail(e.toString());
        }
    }
    @Test
    public void H_testValidPasswordEmpty() throws InterruptedException {
        System.out.println("Test for Wrong Password empty.");
        instance.setVisible(true);
        instance.name.setText("admin");
        Thread.sleep(500);
        instance.password.setText("");
        Thread.sleep(500);
        instance.Login.doClick();
        Thread.sleep(500);
        try {
            assertFalse(instance.status);
            System.out.println("Password cannot be empty.");
        } catch (Exception e) {
            fail(e.toString());
        }
    }
    @Test
    public void I_testSignUp() throws InterruptedException{
    System.out.println("Test for New Student.");
        instance.setVisible(true);
        Thread.sleep(500);
        instance.Signup.doClick();
        Thread.sleep(500);
        try {
            assertTrue(instance.status);
            System.out.println("Succesful.");
        } catch (Exception e) {
            fail(e.toString());
        }
    }
}