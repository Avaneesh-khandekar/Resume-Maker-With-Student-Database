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
public class StudentResumeTest {
    StudentResume instance = new StudentResume("avaneesh");
    public StudentResumeTest() {
    }    
    @Before
    public void setUp() {
    instance.dispose();
    }
    @After
    public void tearDown() {
    }
    @Test
    public void A_testStudentLoad() throws InterruptedException {
        System.out.println("Test Case for Loading Student Data.");
        instance.setVisible(true);
        Thread.sleep(500);
        instance.load();
        try {
            assertTrue(instance.load());
            System.out.println("Form Loaded.");
        } catch (Exception e) {
            fail(e.toString());
        }      
    }
    @Test
    public void B_testClearData() throws InterruptedException {
        System.out.println("Test Case for Clearing Data.");
        instance.setVisible(true);
        Thread.sleep(500);
        instance.Clear.doClick();
        Thread.sleep(500);
        try {
            assertTrue(instance.status);
            System.out.println("Form Cleared.");
        } catch (Exception e) {
            fail(e.toString());
        }
    }
    @Test
    public void C_testSaveData() throws InterruptedException {
        System.out.println("Test Case for Saving Data.");
        instance.setVisible(true);
        Thread.sleep(500);
        instance.Save.doClick();
        Thread.sleep(500);
        try {
            assertTrue(instance.status);
            System.out.println("Data saved successfully.");
        } catch (Exception e) {
            fail(e.toString());
        }
    }
    @Test
      public void D_testSaveNoData() throws InterruptedException {
        System.out.println("Test Case for Saving Data.");
        instance.setVisible(true);
        Thread.sleep(500);
        instance.Clear.doClick();
        Thread.sleep(500);
        instance.Save.doClick();
        Thread.sleep(500);
        try {
            assertEquals(false,instance.status);
            System.out.println("Data saved successfully.");
        } catch (AssertionError e) {
            fail(e.toString());
        }
    }
       @Test
    public void I_testDeleteData() throws InterruptedException {
        StudentResume instance_ = new StudentResume("abcd");
        System.out.println("Test Case for Saving Data.");
        instance_.setVisible(true);
        Thread.sleep(500);
        instance_.Delete.doClick();
        Thread.sleep(500);
        try {
            assertTrue(instance_.status);
            System.out.println("Data is Deleted successfully.");
        } catch (AssertionError e) {
            fail("Cancelled by user"+e.toString());
        }
        instance_.dispose(); 
    }
     @Test
      public void F_testGenerateResume() throws InterruptedException {
        System.out.println("Test Case for Generating PDF.");
        instance.setVisible(true);
        Thread.sleep(500);
        instance.Generate.doClick();
        Thread.sleep(500);
        try {
            assertEquals(true,instance.status);
            System.out.println("Data saved successfully.");
            System.out.println("Resume Generated successfully.");
        } catch (AssertionError e) {
            fail("Cancelled by user"+e.toString());
        }
    }
    @Test
    public void G_testAttachImage() throws InterruptedException {
        System.out.println("Test Case for Attaching Image.");
        instance.setVisible(true);
        Thread.sleep(500);
        instance.Attach.doClick();
        Thread.sleep(500);
        try {
            assertEquals(true,instance.status);
            System.out.println("Successful.");
        } catch (AssertionError e) {
            fail("Cancelled by user by user"+e.toString());
        }
    }
    @Test
    public void H_testLogout() throws InterruptedException {
        System.out.println("Test Case for Logging out.");
        instance.setVisible(true);
        Thread.sleep(500);
        instance.Logout.doClick();
        Thread.sleep(500);
         try {
             assertFalse(instance.isShowing());
             System.out.println("Succesful");
         } catch (Exception e) {
             fail(e.toString());
         }         
    }
}
