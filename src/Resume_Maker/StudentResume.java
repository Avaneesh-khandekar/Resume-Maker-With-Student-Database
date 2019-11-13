/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resume_Maker;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Dimension;
import java.util.Date;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class StudentResume extends javax.swing.JFrame {
    String user;
    Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    int limit=30;
    public boolean status = false;
    private final ImageIcon format = null;
    String filename = null;
    byte[] image = null;
    Functions F = new Functions();
    /**
     * Creates new form Resume_S
     * @param s
     */
    public StudentResume(String s) {
        initComponents();
        JTextFieldDateEditor editor = (JTextFieldDateEditor) dob.getDateEditor();
        editor.setEditable(false);
        conn=db.java_db();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, 
        size.height/2 - getHeight()/2);
        this.user=s;
        load();
    }
    public  boolean load(){
    try{
            String sql ="select * from resume where username=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1,user);
            rs=pst.executeQuery();
            String add1 =rs.getString("id");
            id.setText(add1);
            String add2 =rs.getString("firstname");
            firstname.setText(add2);
            String add3 =rs.getString("surname");
            surname.setText(add3);
            String add4 =rs.getString("ad1");
            ad1.setText(add4);
            String add5 =rs.getString("ad2");
            ad2.setText(add5);
            String add6 =rs.getString("nationality");
            nationality.setText(add6);
            String add7 = rs.getString("dob");
            if(add7.isEmpty()){
                Date d = new Date();
                String dd = F.sdf.format(d);
                dob.setDate(F.sdf.parse(dd));
            }
            else{
                Date d = F.sdf.parse(add7);
                dob.setDate(d);
            }
            String add8 =rs.getString("contact");
            contact.setText(add8);
            String add10 =rs.getString("email");
            email.setText(add10);
            String add11 =rs.getString("skill1");
            skill1.setText(add11);
            String add12 =rs.getString("skill2");
            skill2.setText(add12);
            String add13 =rs.getString("skill3");
            skill3.setText(add13);
            String add14 =rs.getString("skill4");
            skill4.setText(add14);
            String add15 =rs.getString("skill5");
            skill5.setText(add15);
            String add16 =rs.getString("skill6");
            skill6.setText(add16);
            String add17 =rs.getString("company");
            company.setText(add17);
            String add18 =rs.getString("work");
            work.setText(add18);
            String add19 =rs.getString("college");
            college.setText(add19);
            String add20 =rs.getString("title");
            title.setText(add20);
            String add21 =rs.getString("gpa");
            gpa.setText(add21);
            image = rs.getBytes("image");
            if(image.length!=0){
            ImageIcon imageIcon = new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(img.getWidth(), img.getHeight(), Image.SCALE_SMOOTH));
            img.setIcon(imageIcon);
            return true;
            }
        }catch(Exception e){
           //JOptionPane.showMessageDialog(null,e);
           return true;
        }
        finally {
            try{
                rs.close();
                pst.close();
            }
            catch(SQLException e){
            }
        }
    return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel17 = new javax.swing.JLabel();
        firstname = new javax.swing.JTextField();
        title = new javax.swing.JTextField();
        surname = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        ad1 = new javax.swing.JTextField();
        gpa = new javax.swing.JTextField();
        ad2 = new javax.swing.JTextField();
        skill3 = new javax.swing.JTextField();
        nationality = new javax.swing.JTextField();
        skill6 = new javax.swing.JTextField();
        contact = new javax.swing.JTextField();
        Save = new javax.swing.JButton();
        Clear = new javax.swing.JButton();
        email = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        skill4 = new javax.swing.JTextField();
        skill5 = new javax.swing.JTextField();
        skill2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        skill1 = new javax.swing.JTextField();
        id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        company = new javax.swing.JTextField();
        Delete = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        work = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        college = new javax.swing.JTextField();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        img = new javax.swing.JLabel();
        Attach = new javax.swing.JButton();
        Logout = new javax.swing.JButton();
        dob = new com.toedter.calendar.JDateChooser();
        Generate = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Logged in as Student");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusTraversalPolicyProvider(true);

        jLabel17.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel17.setText("Title of Qualification:");

        firstname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));

        title.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));

        surname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));

        jLabel18.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel18.setText("GPA:");

        ad1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));

        gpa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));

        ad2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));

        skill3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                skill3KeyTyped(evt);
            }
        });

        nationality.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));

        skill6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                skill6KeyTyped(evt);
            }
        });

        contact.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));

        Save.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        Save.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Resume Maker\\images\\floppy-disk (1).png")); // NOI18N
        Save.setText("Save");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });
        Save.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SaveKeyPressed(evt);
            }
        });

        Clear.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        Clear.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Resume Maker\\images\\clear.png")); // NOI18N
        Clear.setText("Clear");
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });
        Clear.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ClearKeyPressed(evt);
            }
        });

        email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));

        jLabel12.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 18)); // NOI18N
        jLabel12.setText("Skills");

        skill4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                skill4KeyTyped(evt);
            }
        });

        skill5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                skill5KeyTyped(evt);
            }
        });

        skill2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                skill2KeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 18)); // NOI18N
        jLabel1.setText("Personal Information");

        skill1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                skill1KeyTyped(evt);
            }
        });

        id.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));

        jLabel2.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel2.setText("First  Name:");

        jLabel11.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 18)); // NOI18N
        jLabel11.setText("Work Experience");

        jLabel20.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel20.setText("Roll Number:");

        jLabel3.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel3.setText("Last Name:");

        Delete.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        Delete.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Resume Maker\\images\\rubbish-bin-delete-button.png")); // NOI18N
        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });
        Delete.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DeleteKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel4.setText("Address Line 1:");

        jLabel5.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel5.setText("Address Line 2:");

        jLabel13.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel13.setText("Company Name:");

        jLabel6.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel6.setText("Nationality:");

        jLabel7.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel7.setText("Date of birth:");

        jLabel14.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel14.setText("Work Done:");

        jLabel15.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 18)); // NOI18N
        jLabel15.setText("Qualifications");

        jLabel8.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel8.setText("Contact:");

        jLabel16.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel16.setText("College/University:");

        jLabel9.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jLabel9.setText("E-mail:");

        college.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));

        jDesktopPane1.setLayer(img, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(img, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(img, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                .addContainerGap())
        );

        Attach.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        Attach.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Resume Maker\\images\\attachment.png")); // NOI18N
        Attach.setText("Attach");
        Attach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AttachActionPerformed(evt);
            }
        });
        Attach.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AttachKeyPressed(evt);
            }
        });

        Logout.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        Logout.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Resume Maker\\images\\logout.png")); // NOI18N
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });

        dob.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        dob.setDateFormatString("dd/MM/yyyy\n");

        Generate.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        Generate.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Resume Maker\\images\\pdf.png")); // NOI18N
        Generate.setText("Generate Resume");
        Generate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerateActionPerformed(evt);
            }
        });
        Generate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                GenerateKeyPressed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));

        jLabel21.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel21.setText("Required");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9)))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nationality, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ad2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(surname, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(firstname, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ad1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dob, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contact, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel13)
                                .addComponent(jLabel14))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(company, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(work, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel15)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel18)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(gpa, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(title)
                                .addComponent(college)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Attach)
                .addGap(77, 77, 77))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel20)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(122, 122, 122)
                                .addComponent(jLabel12))
                            .addComponent(skill1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(skill3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(skill2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(skill4, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(skill5, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(skill6, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(Save)
                        .addGap(18, 18, 18)
                        .addComponent(Clear)
                        .addGap(18, 18, 18)
                        .addComponent(Delete)
                        .addGap(18, 18, 18)
                        .addComponent(Generate)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(25, 25, 25)
                                        .addComponent(jLabel20)
                                        .addGap(11, 11, 11)
                                        .addComponent(jLabel2)
                                        .addGap(11, 11, 11)
                                        .addComponent(jLabel3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(22, 22, 22)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(skill1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(36, 36, 36)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(skill3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(surname, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(44, 44, 44)
                                        .addComponent(skill4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(skill5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(skill2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(firstname, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(7, 7, 7)
                                        .addComponent(skill6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ad1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ad2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel13)
                                    .addComponent(company, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(157, 157, 157)
                                .addComponent(Attach)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(nationality, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6)
                                .addComponent(jLabel14))
                            .addComponent(work, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addGap(11, 11, 11)
                                        .addComponent(jLabel16))
                                    .addComponent(title, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel17)
                                    .addComponent(college, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(gpa, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(dob, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(contact, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Save)
                                    .addComponent(Clear)
                                    .addComponent(Delete)
                                    .addComponent(Generate))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        // TODO add your handling code here:
    F.valid(id,firstname,surname,ad1,ad2,nationality,dob,contact,email,skill1,skill2,skill3,skill4,skill5,skill6,company,work,college,title,gpa,img);
    if(F.result){    
    status=F.Save(user,id,firstname,surname,ad1,ad2,nationality,dob,contact,email,skill1,skill2,skill3,skill4,skill5,skill6,company,work,college,title,gpa,img,image);
            }
    else{status=false;}
    }//GEN-LAST:event_SaveActionPerformed

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        // TODO add your handling code here:
    status = F.Clear(id,firstname,surname,ad1,ad2,nationality,dob,contact,email,skill1,skill2,skill3,skill4,skill5,skill6,company,work,college,title,gpa,img);
    }//GEN-LAST:event_ClearActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        // TODO add your handling code here:
        status=F.Delete(user);
        F.Logout();
		this.dispose();
    }//GEN-LAST:event_DeleteActionPerformed

    private void AttachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AttachActionPerformed
        // TODO add your handling code here:
    status=F.Attach(img);
    }//GEN-LAST:event_AttachActionPerformed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        status=F.Logout();
        this.dispose();
    }//GEN-LAST:event_LogoutActionPerformed

    private void skill1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_skill1KeyTyped
        // TODO add your handling code here
        if(skill1.getText().length() >= limit){
            evt.consume();
        JOptionPane.showMessageDialog(null,"Too many characters");
        }
    }//GEN-LAST:event_skill1KeyTyped

    private void skill4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_skill4KeyTyped
        // TODO add your handling code here:
        if(skill4.getText().length() > limit){
            evt.consume();
        JOptionPane.showMessageDialog(null,"Too many characters");
        }
    }//GEN-LAST:event_skill4KeyTyped

    private void skill2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_skill2KeyTyped
        // TODO add your handling code here:
        if(skill2.getText().length() > limit){
            evt.consume();
        JOptionPane.showMessageDialog(null,"Too many characters");
        }
    }//GEN-LAST:event_skill2KeyTyped

    private void skill5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_skill5KeyTyped
        // TODO add your handling code here:
        if(skill5.getText().length() > limit){
            evt.consume();
        JOptionPane.showMessageDialog(null,"Too many characters");
        }
    }//GEN-LAST:event_skill5KeyTyped

    private void skill3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_skill3KeyTyped
        // TODO add your handling code here:
        if(skill3.getText().length() > limit){
            evt.consume();
        JOptionPane.showMessageDialog(null,"Too many characters");
        }
    }//GEN-LAST:event_skill3KeyTyped

    private void skill6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_skill6KeyTyped
        // TODO add your handling code here:
        if(skill6.getText().length() > limit){
            evt.consume();
        JOptionPane.showMessageDialog(null,"Too many characters");
        }
    }//GEN-LAST:event_skill6KeyTyped

    private void SaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SaveKeyPressed
        // TODO add your handling code here:
    if(evt.getKeyCode()==KeyEvent.VK_ENTER){
    F.valid(id,firstname,surname,ad1,ad2,nationality,dob,contact,email,skill1,skill2,skill3,skill4,skill5,skill6,company,work,college,title,gpa,img);
    if(F.result){
    status=F.Save(user,id,firstname,surname,ad1,ad2,nationality,dob,contact,email,skill1,skill2,skill3,skill4,skill5,skill6,company,work,college,title,gpa,img,image);
        }
    }
    }//GEN-LAST:event_SaveKeyPressed

    private void ClearKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ClearKeyPressed
        // TODO add your handling code here:
    if(evt.getKeyCode()==KeyEvent.VK_ENTER){
    status=F.Clear(id,firstname,surname,ad1,ad2,nationality,dob,contact,email,skill1,skill2,skill3,skill4,skill5,skill6,company,work,college,title,gpa,img);
    }
    }//GEN-LAST:event_ClearKeyPressed

    private void DeleteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DeleteKeyPressed
        // TODO add your handling code here:
    if(evt.getKeyCode()==KeyEvent.VK_ENTER){
    status=F.Delete(user);
    F.Logout();
        }
    }//GEN-LAST:event_DeleteKeyPressed

    private void AttachKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AttachKeyPressed
        // TODO add your handling code here:
    if(evt.getKeyCode()==KeyEvent.VK_ENTER){
    status=F.Attach(img);
        }
    }//GEN-LAST:event_AttachKeyPressed

    private void GenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerateActionPerformed
        // TODO add your handling code here:
    F.valid(id,firstname,surname,ad1,ad2,nationality,dob,contact,email,skill1,skill2,skill3,skill4,skill5,skill6,company,work,college,title,gpa,img);
    if(F.result){
    F.Save(user,id,firstname,surname,ad1,ad2,nationality,dob,contact,email,skill1,skill2,skill3,skill4,skill5,skill6,company,work,college,title,gpa,img,image);
    if(Functions.x==0){
    status=F.Generate(user,image,firstname,surname,ad1,ad2,contact,email,skill1,skill2,skill3,skill4,skill5,skill6,company,work,college,title,gpa);
      }
     }
    }//GEN-LAST:event_GenerateActionPerformed

    private void GenerateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GenerateKeyPressed
      // TODO add your handling code here:
    if(evt.getKeyCode()==KeyEvent.VK_ENTER){
    F.valid(id,firstname,surname,ad1,ad2,nationality,dob,contact,email,skill1,skill2,skill3,skill4,skill5,skill6,company,work,college,title,gpa,img);
    if(F.result){
    F.Save(user,id,firstname,surname,ad1,ad2,nationality,dob,contact,email,skill1,skill2,skill3,skill4,skill5,skill6,company,work,college,title,gpa,img,image);
    if(Functions.x==0){
    status=F.Generate(user,image,firstname,surname,ad1,ad2,contact,email,skill1,skill2,skill3,skill4,skill5,skill6,company,work,college,title,gpa);    
       }
      }
     }
    }//GEN-LAST:event_GenerateKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentResume.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            //new Resume_S().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Attach;
    public javax.swing.JButton Clear;
    public javax.swing.JButton Delete;
    public javax.swing.JButton Generate;
    public javax.swing.JButton Logout;
    public javax.swing.JButton Save;
    public javax.swing.JTextField ad1;
    public javax.swing.JTextField ad2;
    public javax.swing.JTextField college;
    public javax.swing.JTextField company;
    public javax.swing.JTextField contact;
    public com.toedter.calendar.JDateChooser dob;
    public javax.swing.JTextField email;
    public javax.swing.JTextField firstname;
    public javax.swing.JTextField gpa;
    public javax.swing.JTextField id;
    public javax.swing.JLabel img;
    public javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField nationality;
    public javax.swing.JTextField skill1;
    public javax.swing.JTextField skill2;
    public javax.swing.JTextField skill3;
    public javax.swing.JTextField skill4;
    public javax.swing.JTextField skill5;
    public javax.swing.JTextField skill6;
    public javax.swing.JTextField surname;
    public javax.swing.JTextField title;
    public javax.swing.JTextField work;
    // End of variables declaration//GEN-END:variables


}
