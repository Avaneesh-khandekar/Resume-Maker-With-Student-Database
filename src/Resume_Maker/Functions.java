package Resume_Maker;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
/**
 *
 * @author User
 */
public class Functions {
    
Connection conn=null;
ResultSet rs=null;
PreparedStatement pst=null;
boolean result=false;
Pattern rollno_pattern = Pattern.compile("^[1-9]\\d{2}");
Pattern mobile_pattern = Pattern.compile("\\d{10}");
String Email_Pattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
Pattern email_pattern = Pattern.compile(Email_Pattern);
Pattern gpa_pattern = Pattern.compile("^[0-9]\\.?\\d{0,2}|[10].[0]{0,2}$");
Pattern NoSpaces = Pattern.compile("^\\S+$");
Pattern NoSpacesAndDigits = Pattern.compile("^[^\\d\\s]+$");
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
private final ImageIcon format = null;
String filename = null;
byte[] my_image = null;
byte [] image = null;
int limit=30;  
public static int x;    
public static int y;    
public Functions(){
conn=db.java_db();
}    
public boolean valid(javax.swing.JTextField id,javax.swing.JTextField firstname,javax.swing.JTextField surname,javax.swing.JTextField ad1,javax.swing.JTextField ad2,
            javax.swing.JTextField nationality,com.toedter.calendar.JDateChooser dob,javax.swing.JTextField contact,javax.swing.JTextField email,
            javax.swing.JTextField skill1,javax.swing.JTextField skill2,javax.swing.JTextField skill3,javax.swing.JTextField skill4,
            javax.swing.JTextField skill5,javax.swing.JTextField skill6,javax.swing.JTextField company,
            javax.swing.JTextField work,javax.swing.JTextField college,javax.swing.JTextField title,javax.swing.JTextField gpa,javax.swing.JLabel img){
    result = false;
    String d1  = ((JTextField)dob.getDateEditor().getUiComponent()).getText();
    Matcher gpa_matcher = gpa_pattern.matcher(gpa.getText());
    Matcher rollno_matcher = rollno_pattern.matcher(id.getText());
    Matcher email_matcher = email_pattern.matcher(email.getText());
    Matcher mobile_matcher = mobile_pattern.matcher(contact.getText());
   
     if(firstname.getText().isEmpty() || surname.getText().isEmpty() || ad1.getText().isEmpty() || ad2.getText().isEmpty() ||
        nationality.getText().isEmpty() || contact.getText().isEmpty() || email.getText().isEmpty() || 
        college.getText().isEmpty() || title.getText().isEmpty() || gpa.getText().isEmpty()){
        result=false;
        JOptionPane.showMessageDialog(null,"PLease Fill all the compulsory fields.");
        }
    else if(!rollno_matcher.matches() || id.getText().isEmpty()){
        JOptionPane.showMessageDialog(null,"Please enter a unique 3 digit Roll Number.");
        result=false;
        }
    else if(d1.isEmpty()){
        result = false;
        JOptionPane.showMessageDialog(null,"Please choose a date.");
        }
    else if(!mobile_matcher.matches()){
        JOptionPane.showMessageDialog(null,"Please Enter a valid mobile number.");
        result=false;
        }
    else if(!email_matcher.matches()){
        JOptionPane.showMessageDialog(null,"Please Enter a valid email id.");
        result=false;
        }
    else if(company.getText().length()>50 || work.getText().length()>30 || college.getText().length()>100||
        title.getText().length()>15){
        result=false;
        JOptionPane.showMessageDialog(null, "Too Long.");
        }
    else if(skill1.getText().length()>limit || skill2.getText().length()>limit || skill3.getText().length()>limit ||
        skill4.getText().length()>limit || skill5.getText().length()>limit || skill6.getText().length()>limit){
        JOptionPane.showMessageDialog(null,"Too Long.");
        result=false;
        }
    else if(!gpa_matcher.matches()){
        result=false;
        JOptionPane.showMessageDialog(null,"Please enter a valid GPA.");
        }
    else{
        result = true;
        }
    return result;
    }   

    public boolean Clear(javax.swing.JTextField id,javax.swing.JTextField firstname,javax.swing.JTextField surname,javax.swing.JTextField ad1,javax.swing.JTextField ad2,
            javax.swing.JTextField nationality,com.toedter.calendar.JDateChooser dob,javax.swing.JTextField contact,javax.swing.JTextField email,
            javax.swing.JTextField skill1,javax.swing.JTextField skill2,javax.swing.JTextField skill3,javax.swing.JTextField skill4,
            javax.swing.JTextField skill5,javax.swing.JTextField skill6,javax.swing.JTextField company,
            javax.swing.JTextField work,javax.swing.JTextField college,javax.swing.JTextField title,javax.swing.JTextField gpa,javax.swing.JLabel img){
        id.setText("");
        firstname.setText("");
        surname.setText("");
        ad1.setText("");
        ad2.setText("");
        nationality.setText("");
        dob.setDate(null);
        contact.setText("");
        email.setText("");
        skill1.setText("");
        skill2.setText("");
        skill3.setText("");
        skill4.setText("");
        skill5.setText("");
        skill6.setText("");
        company.setText("");
        work.setText("");
        college.setText("");
        title.setText("");
        gpa.setText("");
        img.setIcon(null);
        return true;
    }
    public boolean Attach(javax.swing.JLabel img){
        JFileChooser chooser = new JFileChooser();     
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.setFileFilter(new ImageFilter());
        int check = chooser.showOpenDialog((null));
        if(check == JFileChooser.APPROVE_OPTION){
        File f = chooser.getSelectedFile();
        filename = f.getAbsolutePath();
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(img.getWidth(),img.getHeight(),Image.SCALE_DEFAULT));
        img.setIcon(imageIcon);
        try{

            File image_ = new File(filename);
            FileInputStream fix = new FileInputStream(image_);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte [] buf = new byte[1024];
            for(int number;(number=fix.read(buf))!=-1;){
                bos.write(buf,0,number);
            }
            my_image = bos.toByteArray();
            return true;
        }catch(IOException e ){
            JOptionPane.showMessageDialog(null,e);
            return false;
        }
        }
    return false;
    }
    public boolean Delete(String user){
    y = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete record?","Delete Record.",JOptionPane.YES_NO_OPTION);
        if(y==0){
            try{
                String sql ="delete from resume where username=?";
                pst=conn.prepareStatement(sql);
                pst.setString(1,user);
                pst.execute();
                String sql2 ="delete from Users where username=?";
                pst=conn.prepareStatement(sql2);
                pst.setString(1,user);
                pst.execute();
                JOptionPane.showMessageDialog(null,"Data is deleted successfully.");
                return true;
                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,e);
                return false;
            }finally {
                try{
//                    rs.close();
                    pst.close();
                }
                catch(SQLException e){
                }
            }
        }
        return false;
    }
     
    public boolean Save(String user,javax.swing.JTextField id,javax.swing.JTextField firstname,javax.swing.JTextField surname,javax.swing.JTextField ad1,javax.swing.JTextField ad2,
            javax.swing.JTextField nationality,com.toedter.calendar.JDateChooser dob,javax.swing.JTextField contact,javax.swing.JTextField email,
            javax.swing.JTextField skill1,javax.swing.JTextField skill2,javax.swing.JTextField skill3,javax.swing.JTextField skill4,
            javax.swing.JTextField skill5,javax.swing.JTextField skill6,javax.swing.JTextField company,
            javax.swing.JTextField work,javax.swing.JTextField college,javax.swing.JTextField title,javax.swing.JTextField gpa,javax.swing.JLabel img,byte[] image ){
        x = JOptionPane.showConfirmDialog(null,"Are you sure you want to save record?","Delete Record.",JOptionPane.YES_NO_OPTION);
        if(x==0){   
        try {
        
                String sql ="update resume set id = ?,firstname=?,surname=?,"
                    + "ad1=?,ad2=?,nationality=?,dob=?,"
                    + "contact =?,email =?,skill1 =?,skill2 =?,"
                    + "skill3=?,skill4=?,skill5=?,skill6=?,"
                    + "company=?,work=?,college=?,title=?,gpa=?,image=? where username='"+user+"'";                
                pst=conn.prepareStatement(sql);
                pst.setString(1,id.getText());
                pst.setString(2,firstname.getText());
                pst.setString(3,surname.getText());
                pst.setString(4,ad1.getText());
                pst.setString(5,ad2.getText());
                pst.setString(6,nationality.getText());
                String d1  = ((JTextField)dob.getDateEditor().getUiComponent()).getText();
                pst.setString(7,d1);
                pst.setString(8,contact.getText());
                pst.setString(9,email.getText());
                pst.setString(10, skill1.getText());
                pst.setString(11,skill2.getText());
                pst.setString(12,skill3.getText());
                pst.setString(13,skill4.getText());
                pst.setString(14,skill5.getText());
                pst.setString(15,skill6.getText());
                pst.setString(16,company.getText());
                pst.setString(17,work.getText());
                pst.setString(18,college.getText());
                pst.setString(19,title.getText());
                pst.setString(20,gpa.getText());
                if(my_image==null){
                pst.setBytes(21,image);
                }
                else{
                pst.setBytes(21,my_image);
                }
                pst.execute();
                JOptionPane.showMessageDialog(null,"Data is saved successfully.");
                return true;
                
            }
            catch (HeadlessException | SQLException e)
            {
                JOptionPane.showMessageDialog(null,"Roll Number is already assigned.");
                return false;
            }
            
            finally {
                try{
                    //rs.close();
                    pst.close();
                }
                catch(SQLException e){
                    JOptionPane.showMessageDialog(null,e);
                }
            }
        } 
     return false;
    }

public boolean Generate(String user,byte[] image,javax.swing.JTextField firstname,javax.swing.JTextField surname,javax.swing.JTextField ad1,javax.swing.JTextField ad2,
javax.swing.JTextField contact,javax.swing.JTextField email,javax.swing.JTextField skill1,javax.swing.JTextField skill2,javax.swing.JTextField skill3,javax.swing.JTextField skill4,
            javax.swing.JTextField skill5,javax.swing.JTextField skill6,javax.swing.JTextField company,
            javax.swing.JTextField work,javax.swing.JTextField college,javax.swing.JTextField title,javax.swing.JTextField gpa){
try {
                String sql = "select image from resume where username=?";
                pst=conn.prepareStatement(sql);
                pst.setString(1,user);
                rs=pst.executeQuery();
                image = rs.getBytes("image");
        }catch(SQLException e){
            //JOptionPane.showMessageDialog(null,e); 
        }
        finally {
            try{
                rs.close();
                pst.close();
            }
            catch(SQLException e){
            }
        }
        JFileChooser dialog = new JFileChooser();
        dialog.setSelectedFile(new File(firstname.getText()+" "+surname.getText()+"-Resume"+".pdf"));
        int dialogresult = dialog.showSaveDialog(null);
        if(dialogresult == JFileChooser.APPROVE_OPTION){
        String filepath = dialog.getSelectedFile().getPath();
        Rectangle layout = new Rectangle(PageSize.A4);
        layout.setBackgroundColor(BaseColor.WHITE);
        Document myDocument = new Document(layout);
        LineSeparator ls = new LineSeparator();
        try{
        PdfWriter myWriter = PdfWriter.getInstance(myDocument,new FileOutputStream(filepath));
        myDocument.open();
        Font DarkGray = new Font(FontFactory.getFont(FontFactory.HELVETICA,10,Font.NORMAL,BaseColor.DARK_GRAY));
        Paragraph paragraph = new Paragraph();
        if(image!=null){
        com.itextpdf.text.Image myImage = com.itextpdf.text.Image.getInstance(image);
        myImage.scaleAbsolute(80,80);
        myImage.setAlignment(com.itextpdf.text.Image.RIGHT);
        paragraph.add(myImage);
        }
        Chunk n = new Chunk(firstname.getText()+"\n"+surname.getText(),FontFactory.getFont(FontFactory.HELVETICA_BOLD,20,Font.BOLD,BaseColor.DARK_GRAY));
        paragraph.add(n);
        paragraph.setAlignment(Element.ALIGN_LEFT);
        myDocument.add(paragraph);
        myDocument.add(new Chunk(ls));
        String date = sdf.format(new Date());
        paragraph = new Paragraph(date,DarkGray);
        paragraph.setAlignment(Element.ALIGN_RIGHT);
        myDocument.add(paragraph);
        paragraph = new Paragraph(ad1.getText(),DarkGray);
        paragraph.setAlignment(Element.ALIGN_RIGHT);
        myDocument.add(paragraph);
        paragraph = new Paragraph(ad2.getText(),DarkGray);
        paragraph.setAlignment(Element.ALIGN_RIGHT);
        myDocument.add(paragraph);
        paragraph = new Paragraph("+91-"+contact.getText(),DarkGray);
        paragraph.setAlignment(Element.ALIGN_RIGHT);
        myDocument.add(paragraph);
        paragraph = new Paragraph(email.getText(),FontFactory.getFont(FontFactory.HELVETICA,10,BaseColor.BLUE.brighter()));
        paragraph.setAlignment(Element.ALIGN_RIGHT);
        myDocument.add(paragraph);
        myDocument.add(new Chunk(ls));
        Font titles = new Font(FontFactory.getFont(FontFactory.HELVETICA_BOLD,15,Font.UNDERLINE,BaseColor.DARK_GRAY));
        if(!skill1.getText().isEmpty() || !skill2.getText().isEmpty() || !skill3.getText().isEmpty() || 
           !skill4.getText().isEmpty()|| !skill5.getText().isEmpty() || !skill6.getText().isEmpty()){
        paragraph = new Paragraph("Skills",titles);
        paragraph.setAlignment(Element.ALIGN_LEFT);
        myDocument.add(paragraph);
        myDocument.add(Chunk.NEWLINE);
        List list = new List(List.UNORDERED);
        Font lst = new Font(FontFactory.getFont(FontFactory.HELVETICA,12,BaseColor.DARK_GRAY));
        list.setListSymbol("•");
        if(!skill1.getText().isEmpty()){
        list.add(new ListItem(" "+skill1.getText(),lst));             
        }
        if(!skill2.getText().isEmpty()){
        list.add(new ListItem(" "+skill2.getText(),lst));
        }
        if(!skill3.getText().isEmpty()){
        list.add(new ListItem(" "+skill3.getText(),lst));
        }
        if(!skill4.getText().isEmpty()){
        list.add(new ListItem(" "+skill4.getText(),lst));
        }
        if(!skill5.getText().isEmpty()){
        list.add(new ListItem(" "+skill5.getText(),lst));
        }
        if(!skill6.getText().isEmpty()){
        list.add(new ListItem(" "+skill6.getText(),lst));
        }
        myDocument.add(list);
        myDocument.add(new Chunk(ls));
        }
        paragraph = new Paragraph("Experience",titles);
        paragraph.setAlignment(Element.ALIGN_LEFT);
        myDocument.add(paragraph);
        myDocument.add(Chunk.NEWLINE);
        myDocument.add(new Phrase("Organizaton :",FontFactory.getFont(FontFactory.HELVETICA_BOLD,11,Font.BOLD)));
        myDocument.add(new Phrase(" "+company.getText(),FontFactory.getFont(FontFactory.HELVETICA,10,BaseColor.DARK_GRAY)));
        paragraph = new Paragraph();
        Phrase p = new Phrase("Work Done/Position :",FontFactory.getFont(FontFactory.HELVETICA_BOLD,11,Font.BOLD));
        Phrase p2 = new Phrase(" "+work.getText(),FontFactory.getFont(FontFactory.HELVETICA,10,BaseColor.DARK_GRAY));
        paragraph.add(p);
        paragraph.add(p2);
        myDocument.add(paragraph);
        myDocument.add(new Chunk(ls));
        paragraph = new Paragraph("Education",titles);
        paragraph.setAlignment(Element.ALIGN_LEFT);
        myDocument.add(paragraph);
        myDocument.add(Chunk.NEWLINE);
        myDocument.add(new Phrase("College/University :",FontFactory.getFont(FontFactory.HELVETICA_BOLD,11,Font.BOLD)));
        myDocument.add(new Phrase(" "+college.getText(),FontFactory.getFont(FontFactory.HELVETICA,10,BaseColor.DARK_GRAY)));
        paragraph = new Paragraph();
        Phrase p3 = new Phrase("Course :",FontFactory.getFont(FontFactory.HELVETICA_BOLD,11,Font.BOLD));
        Phrase p4 = new Phrase(" "+title.getText(),FontFactory.getFont(FontFactory.HELVETICA,10,BaseColor.DARK_GRAY));
        paragraph.add(p3);
        paragraph.add(p4);
        myDocument.add(paragraph);
        paragraph = new Paragraph();
        Phrase p5 = new Phrase("Aggreagate :",FontFactory.getFont(FontFactory.HELVETICA_BOLD,11,Font.BOLD));
        Phrase p6 = new Phrase(" "+gpa.getText(),FontFactory.getFont(FontFactory.HELVETICA,10,BaseColor.DARK_GRAY));
        paragraph.add(p5);
        paragraph.add(p6);
        myDocument.add(paragraph);
        myDocument.add(new Chunk(ls));
        paragraph = new Paragraph();
        Phrase place = new Phrase("Place :",FontFactory.getFont(FontFactory.HELVETICA,11,Font.BOLD));
        Phrase place_name = new Phrase("Pune",FontFactory.getFont(FontFactory.HELVETICA,11,Font.BOLD));
        paragraph.add(place);
        paragraph.add(place_name);
        myDocument.add(paragraph);
        myDocument.close();
        JOptionPane.showMessageDialog(null,"Resume Generated Successfully.");
        return true;
        }catch(DocumentException | HeadlessException | IOException e){
            return false;
            }
        }
        return false;
    }
    public boolean validSignup(javax.swing.JTextField name, javax.swing.JTextField password){
    result=false; 
        Matcher NoSpacesMatcher = NoSpaces.matcher(password.getText());
        Matcher NoSpacesAndDigitsMatcher = NoSpacesAndDigits.matcher(name.getText());
        if(name.getText().isEmpty()){   
        JOptionPane.showMessageDialog(null,"Username cannot be empty");
        result=false;
        }
        else if(password.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "Password cannot be empty");
        result=false;
        }
        else if(!NoSpacesAndDigitsMatcher.matches()){
        JOptionPane.showMessageDialog(null,"Username cannot contain spaces or digits");
        result=false;    
        }
        else if(!NoSpacesMatcher.matches()){
        JOptionPane.showMessageDialog(null,"Password cannot contain white spaces.");
        result=false;
        }
        else if(name.getText().length()>10){
        JOptionPane.showMessageDialog(null, "Username cannot exceed 10 characters");
        result=false;
        }
        else{
        result=true;    
        }
    return result;
    }
    public boolean Logout(){
    ResumeMaker x = new ResumeMaker();
    x.setVisible(true);
    return x.isVisible();
    //return false;
    }
}

