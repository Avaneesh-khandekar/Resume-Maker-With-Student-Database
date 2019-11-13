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

public class IntegrationTest {
    ResumeMaker one;
    AdminOperation two;
    AdminModifyRecord three;
    @Before
    public void setUp() {  
    one = new ResumeMaker();
	one.setVisible(true);
	two = new AdminOperation();
	//two.setVisible(true);
	three = new AdminModifyRecord();
	//three.setVisible(true);
	//super.setUp();
    }
    
@Test
public void test() throws InterruptedException{
        System.out.println("Test for Correct Admin login.");
	try {
		assertTrue(one.isShowing());
	} catch (Exception e) {
		fail(e.toString());
	}
        one.name.setText("admin");
        Thread.sleep(500);
        one.password.setText("admin");
        Thread.sleep(500);
        one.combo.setSelectedItem("Admin");
        Thread.sleep(500);
        one.Login.doClick();
        Thread.sleep(500);
        try {
            assertEquals(true,one.status);
            System.out.println("Success.");
        } catch (AssertionError e) {
            fail(e.toString());
        }
		one.dispose();
		two.setVisible(true);
		System.out.println("Test for Modify Button.");
		try {
		assertTrue(two.isShowing());
	    } catch (Exception e) {
		fail(e.toString());
		}
		Thread.sleep(500);
		two.Modify.doClick();
		Thread.sleep(500);
		try{
		assertTrue(two.status);
	    } catch (Exception e) {
		fail(e.toString());
		}
		Thread.sleep(500);
		two.dispose();
		three.setVisible(true);
		System.out.println("Test for Searching a record.");
		try {
		assertTrue(three.isShowing());
	    } catch (Exception e) {
		fail(e.toString());
	    }
		three.search.setText("123");
		Thread.sleep(300);
        three.Search.doClick();
        Thread.sleep(1100);
        three.title.setText("BE comp");
        Thread.sleep(500);
        three.Update.doClick();
        Thread.sleep(1000);
        try {
            assertEquals(true, three.status);
            System.out.println("Data is saved successfuly");
        } catch (Exception e) {
            fail("cancelled"+e.toString());
        }
		Thread.sleep(500);
		three.Logout.doClick();
    }
@After
public void tearDown() throws InterruptedException {
    one.dispose();
	two.dispose();
	three.dispose();
		
    }
    
}