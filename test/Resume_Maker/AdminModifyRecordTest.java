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

/**
 *
 * @author User
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)	
public class AdminModifyRecordTest {
    AdminModifyRecord instance;
    public AdminModifyRecordTest() {
    }
    @Before
    public void setUp() {
        instance = new AdminModifyRecord();
    }
    
    @After
    public void tearDown() {
        instance.dispose();
    }
  
    @Test
    public void A_testSearch() throws InterruptedException {
        System.out.println("Test Case for Search");
        instance.setVisible(true);
        Thread.sleep(500);
        instance.search.setText("123");
        Thread.sleep(800);
        instance.Search.doClick();
        Thread.sleep(3000);
        try {
            assertTrue(instance.status);
            System.out.println("Data Loaded.");
        } catch (Exception e) {
            fail(e.toString());
        }
        
    }
     @Test
    public void B_testNonExistantSearch() throws InterruptedException {
        System.out.println("Test Case for Search");
        instance.setVisible(true);
        Thread.sleep(500);
        instance.search.setText("420");
        Thread.sleep(800);
        instance.Search.doClick();
        Thread.sleep(1000);
        try {
            assertFalse(instance.status);
            System.out.println("Record Does Not Exist.");
        } catch (Exception e) {
            fail(e.toString());
        }
        
    }
     @Test
    public void C_testSearchInvalidRollNumber() throws InterruptedException {
        System.out.println("Test Case for Search");
        instance.setVisible(true);
        Thread.sleep(500);
        instance.search.setText("1234");
        Thread.sleep(800);
        instance.Search.doClick();
        Thread.sleep(1000);
        try {
            assertFalse(instance.status);
            System.out.println("Please enter a three digit Roll Number to search.");
        } catch (Exception e) {
            fail(e.toString());
        }
        
    }
    @Test
    public void D_testSearchInvalidRollNumberChars() throws InterruptedException {
        System.out.println("Test Case for Search");
        instance.setVisible(true);
        Thread.sleep(500);
        instance.search.setText("abc");
        Thread.sleep(800);
        instance.Search.doClick();
        Thread.sleep(1000);
        try {
            assertFalse(instance.status);
            System.out.println("Please enter a three digit Roll Number to search.");
        } catch (Exception e) {
            fail(e.toString());
        }
        
    }
    @Test
    public void I_testBack() throws InterruptedException {
        System.out.println("Test Case for Back Button");
        instance.setVisible(true);
        Thread.sleep(500);
        instance.Back.doClick();
        Thread.sleep(500);
          try {
              assertEquals(true, instance.status);
              System.out.println("Success.");
          } catch (Exception e) {
              fail(e.toString());
          }
          
    }
    @Test
    public void E_testUpdate() throws InterruptedException {
        System.out.println("Test Case for Update Button");
        instance.setVisible(true);
        instance.search.setText("123");
        Thread.sleep(300);
        instance.Search.doClick();
        Thread.sleep(1100);
        instance.title.setText("BE");
        Thread.sleep(500);
        instance.Update.doClick();
        Thread.sleep(1000);
        try {
            assertEquals(true, instance.status);
            System.out.println("Data is saved successfuly");
        } catch (Exception e) {
            fail("cancelled"+e.toString());
        }
        
    }
    @Test
    public void F_testClear() throws InterruptedException {
        System.out.println("Test Case for Clear Button");
        instance.setVisible(true);
        instance.search.setText("123");
        Thread.sleep(300);
        instance.Search.doClick();
        Thread.sleep(500);
        instance.Clear.doClick();
        Thread.sleep(2500);
         try {
             assertEquals(true, instance.status);
             System.out.println("Cleared");
         } catch (Exception e) {
             fail(e.toString());
         }
    }
    @Test
      public void G_testGenerateResume() throws InterruptedException {
        System.out.println("Test Case for Generating PDF.");
        instance.setVisible(true);
        Thread.sleep(300);
        instance.search.setText("123");
        Thread.sleep(300);
        instance.Search.doClick();
        Thread.sleep(300);
        instance.Generate.doClick();
        Thread.sleep(500);
        try {
            assertEquals(true,instance.status);
            System.out.println("Data saved successfully.");
            System.out.println("Resume Generated successfully.");
        } catch (AssertionError e) {
            fail("Cancelled"+e.toString());
        }    
    }
}
