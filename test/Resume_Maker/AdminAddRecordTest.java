/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resume_Maker;

import java.text.ParseException;
import java.util.Date;
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
public class AdminAddRecordTest {
    AdminAddRecord instance;
    Functions F = new Functions();
    public AdminAddRecordTest() {
    }
    @Before
    public void setUp() {
    instance = new AdminAddRecord("cxxx");
    }
    
    @After
    public void tearDown() {
        instance.dispose();
    }
    @Test
    public void A_testInvalidContactNumber() throws InterruptedException, ParseException {
        System.out.println("Test Case for invalid contact number");
        instance.setVisible(true);
        Thread.sleep(500);
        instance.id.setText("133");
        Thread.sleep(380);
        instance.firstname.setText("abc");
        Thread.sleep(380);
        instance.surname.setText("abc");
        Thread.sleep(380);
        instance.ad1.setText("abc");
        Thread.sleep(380);
        instance.ad2.setText("abc");
        Thread.sleep(380);
        instance.nationality.setText("123");
        Thread.sleep(380);
        Date d = new Date();
        String dd = F.sdf.format(d);
        instance.dob.setDate(F.sdf.parse(dd));
        instance.contact.setText("1asd0aa");
        Thread.sleep(380);
        instance.email.setText("abc@123.com");
        Thread.sleep(380);
        instance.skill1.setText("Py");
        Thread.sleep(380);
        instance.skill2.setText("Jv");
        Thread.sleep(380);
        instance.skill3.setText("Cpp");
        Thread.sleep(380);
        instance.company.setText("xyz");
        Thread.sleep(380);
        instance.work.setText("pqr");
        Thread.sleep(380);
        instance.college.setText("MMCOE");
        Thread.sleep(380);
        instance.title.setText("BE");
        Thread.sleep(380);
        instance.gpa.setText("1.23");
        Thread.sleep(500);
        instance.Add.doClick();
        try {
            assertEquals(false, instance.status);
            System.out.println("Please enter a valid contact number.");
        } catch (Exception e) {
            fail(e.toString());
        } 
    }
    @Test
    public void B_testInvalidGPA() throws InterruptedException, ParseException {
        System.out.println("Test Case for invalid GPA");
        instance.setVisible(true);
        Thread.sleep(500);
        instance.id.setText("133");
        Thread.sleep(380);
        instance.firstname.setText("abc");
        Thread.sleep(380);
        instance.surname.setText("abc");
        Thread.sleep(380);
        instance.ad1.setText("abc");
        Thread.sleep(380);
        instance.ad2.setText("abc");
        Thread.sleep(380);
        instance.nationality.setText("123");
        Thread.sleep(380);
        Date d = new Date();
        String dd = F.sdf.format(d);
        instance.dob.setDate(F.sdf.parse(dd));
        instance.contact.setText("1234567890");
        Thread.sleep(380);
        instance.email.setText("abc@123.com");
        Thread.sleep(380);
        instance.skill1.setText("Py");
        Thread.sleep(380);
        instance.skill2.setText("Jv");
        Thread.sleep(380);
        instance.skill3.setText("Cpp");
        Thread.sleep(380);
        instance.company.setText("xyz");
        Thread.sleep(380);
        instance.work.setText("pqr");
        Thread.sleep(380);
        instance.college.setText("MMCOE");
        Thread.sleep(380);
        instance.title.setText("BE");
        Thread.sleep(380);
        instance.gpa.setText("123.3");
        Thread.sleep(500);
        instance.Add.doClick();
        try {
            assertEquals(false, instance.status);
            System.out.println("Please enter a valid GPA.");
        } catch (Exception e) {
            fail(e.toString());
        }  
    }
    @Test
    public void C_testInvalidEmail() throws InterruptedException, ParseException {
        System.out.println("Test Case for invalid Email");
        instance.setVisible(true);
        Thread.sleep(500);
        instance.id.setText("133");
        Thread.sleep(380);
        instance.firstname.setText("abc");
        Thread.sleep(380);
        instance.surname.setText("abc");
        Thread.sleep(380);
        instance.ad1.setText("abc");
        Thread.sleep(380);
        instance.ad2.setText("abc");
        Thread.sleep(380);
        instance.nationality.setText("123");
        Thread.sleep(380);
        Date d = new Date();
        String dd = F.sdf.format(d);
        instance.dob.setDate(F.sdf.parse(dd));
        instance.contact.setText("1234567890");
        Thread.sleep(380);
        instance.email.setText("ab_c@1@23..com.@.");
        Thread.sleep(380);
        instance.skill1.setText("Py");
        Thread.sleep(380);
        instance.skill2.setText("Jv");
        Thread.sleep(380);
        instance.skill3.setText("Cpp");
        Thread.sleep(380);
        instance.company.setText("xyz");
        Thread.sleep(380);
        instance.work.setText("pqr");
        Thread.sleep(380);
        instance.college.setText("MMCOE");
        Thread.sleep(380);
        instance.title.setText("BE");
        Thread.sleep(380);
        instance.gpa.setText("1.23");
        Thread.sleep(500);
        instance.Add.doClick();
        try {
            assertEquals(false, instance.status);
           System.out.println("Please enter a valid email-id.");
        } catch (Exception e) {
            fail(e.toString());
        } 
    }
    @Test
    public void D_testBack() throws InterruptedException {
        System.out.println("Test Case for Back Button");
        instance.setVisible(true);
        Thread.sleep(500);
        instance.Back.doClick();
        Thread.sleep(500);
        assertEquals(true,instance.status);
    }
    @Test
    public void E_testLogout() throws InterruptedException {
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