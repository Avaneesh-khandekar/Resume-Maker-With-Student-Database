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
public class AdminOperationTest {
    AdminOperation instance;
    public AdminOperationTest() {
    }
    
    @Before
    public void setUp() {
    instance = new AdminOperation();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of new_ method, of class Admin_operation.
     */
    @Test
    public void testNew_() throws InterruptedException {
        System.out.println("Test Case for 'Create New Record Button'.");
        instance.setVisible(true);
        Thread.sleep(500);
        instance.NewRecord.doClick();
        Thread.sleep(500);
        try{
            assertTrue(instance.status);
            System.out.println("Succesful.");
        }catch(AssertionError e){        
            fail(e.toString());
        }
        
     }
    @Test
    public void testModify() throws InterruptedException {
        System.out.println("Test Case for button 'Modify Existing Record'.");
        instance.setVisible(true);
        Thread.sleep(500);
        instance.Modify.doClick();
        Thread.sleep(500);
        try{
            assertTrue(instance.status);
            System.out.println("Succesful.");
        }catch(AssertionError e){        
            fail(e.toString());
        }
      
    }
    @Test
    public void testLogout() throws InterruptedException {
        
        System.out.println("Test Case for Logout");
        instance.setVisible(true);
        //boolean expResult = true;
        Thread.sleep(500);
        instance.Logout.doClick();
        Thread.sleep(500);
        try{
            assertFalse(instance.isShowing());
            System.out.println("Succesful.");
        }catch(AssertionError e){        
            fail(e.toString());
        }  
    
    }

    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        AdminOperation.main(args);
        
    }
    
}
