import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

class Registration_design extends JPanel {
     String dates[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
             "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
             "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
     String months[] = { "Jan", "feb", "Mar", "Apr", "May", "Jun", "July", "Aug", "Sup", "Oct", "Nov", "Dec" };
     String years[] = { "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002",
             "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010",
             "2011", "2012", "2103", "2014", "2015", "2016", "2017", "2018", "2019" };
    Registration_design(){


        //setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //pack();
        //setLocationByPlatform(true);
        setBackground(Color.BLUE);
        setVisible(true);
        setSize(550,800);

        //background;
        ImageIcon background_image=new ImageIcon("src/images/h0Vxgz5tyXA_Full.jpg");
        Image img=background_image.getImage();
        Image temp_img=img.getScaledInstance(550,800,Image.SCALE_SMOOTH);
        background_image=new ImageIcon(temp_img);
        JLabel background=new JLabel("",background_image,JLabel.CENTER);
        background.setBounds(0,0,550,800);
        add(background);



        JPanel register=new JPanel();
        register.setSize(400,450);
        register.setBackground(new Color(0,0,0,30));
        register.setBounds(70,90,400,600);
        register.setLayout(null);
        background.add(register);



        Dimension dim=getPreferredSize();
        dim.height=120;
        setPreferredSize(dim);
        setLayout(new BorderLayout());
        setBounds(200,200,550,800);




        JLabel form=new JLabel("Enter the form to register",JLabel.CENTER);
        Font fon=new Font("Serif",Font.BOLD,15);
        form.setForeground(Color.white);
        form.setBounds(5,0,200,50);
        form.setFont(fon);
        register.add(form);

        JLabel rname=new JLabel("First Name");
        rname.setBounds(5,40,200,50);
        rname.setFont(fon);
        rname.setForeground(Color.white);
        register.add(rname);

        JTextField ename=new JTextField();
        ename.setBounds(150,55,170,20);
        ename.setBorder(null);
        ename.setBackground(Color.gray);
        ename.setFont(fon);
        register.add(ename);

        JLabel lname=new JLabel("Last Name");
        lname.setBounds(5,80,200,50);
        lname.setFont(fon);
        lname.setForeground(Color.white);
        register.add(lname);

        JTextField lename=new JTextField();
        lename.setBounds(150,95,170,20);
        lename.setBorder(null);
        lename.setBackground(Color.gray);
        lename.setFont(fon);
        register.add(lename);

        JLabel rage=new JLabel("Age");
        rage.setBounds(5,120,200,50);
        rage.setFont(fon);
        rage.setForeground(Color.white);
        register.add(rage);

        JTextField eage=new JTextField();
        eage.setBounds(150,135,170,20);
        eage.setBorder(null);
        eage.setBackground(Color.gray);
        eage.setFont(fon);
        register.add(eage);

        JLabel rmobile=new JLabel("Mobile");
        rmobile.setBounds(5,160,200,50);
        rmobile.setForeground(Color.white);
        rmobile.setFont(fon);
        register.add(rmobile);

        JTextField emobile=new JTextField();
        emobile.setBounds(150,175,170,20);
        emobile.setBorder(null);
        emobile.setBackground(Color.gray);
        emobile.setFont(fon);
        register.add(emobile);

        JLabel rdob=new JLabel("DOB");
        rdob.setBounds(5,200,200,50);
        rdob.setForeground(Color.white);
        rdob.setFont(fon);
        register.add(rdob);


        JComboBox date = new JComboBox(dates);
        date.setFont(fon);
        date.setBounds(150,215,50,20);
        date.setBorder(null);
        date.setBackground(Color.gray);
        register.add(date);
        repaint();

        JComboBox month = new JComboBox(months);
        month.setFont(fon);
        month.setBackground(Color.gray);
        month.setBounds(210,215,50,20);
        month.setBorder(null);
        register.add(month);
        repaint();

        JComboBox year= new JComboBox(years);
        year.setFont(fon);
        year.setBackground(Color.gray);
        year.setBounds(270,215,50,20);
        year.setBorder(null);
        register.add(year);
        repaint();



        JLabel rgender=new JLabel("Gender");
        rgender.setBounds(5,240,200,50);
        rgender.setForeground(Color.white);
        rgender.setFont(fon);
        register.add(rgender);

        JRadioButton male = new JRadioButton("Male");
        male.setSelected(true);
        male.setBounds(150,260,80,15);
        male.setBackground(Color.gray);
        male.setBorder(null);
        register.add(male);

        JRadioButton female = new JRadioButton("Female");
        female.setSelected(false);
        female.setBackground(Color.gray);
        female.setBounds(235,260,85,15);
        register.add(female);

        male.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                female.setSelected(false);
            }
        });
        female.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                male.setSelected(false);
            }
        });

        JLabel runame=new JLabel("U.Name");
        runame.setBounds(5,280,200,50);
        runame.setFont(fon);
        runame.setForeground(Color.white);
        register.add(runame);

        JTextField euname=new JTextField();
        euname.setBounds(150,295,170,20);
        euname.setBorder(null);
        euname.setBackground(Color.gray);
        euname.setFont(fon);
        register.add(euname);

        JLabel remail=new JLabel("Email");
        remail.setBounds(5,320,170,50);
        remail.setFont(fon);
        remail.setForeground(Color.white);
        register.add(remail);

        JTextField eemail=new JTextField();
        eemail.setBounds(150,335,170,20);
        eemail.setBorder(null);
        eemail.setBackground(Color.gray);
        eemail.setFont(fon);
        register.add(eemail);

        JLabel rpass=new JLabel("Password");
        rpass.setBounds(5,360,200,50);
        rpass.setFont(fon);
        rpass.setForeground(Color.white);
        register.add( rpass);

        JTextField epass=new JTextField();
        epass.setBounds(150,375,170,20);
        epass.setBorder(null);
        epass.setBackground(Color.gray);
        epass.setFont(fon);
        register.add(epass);

        JLabel rconfirm=new JLabel("Confirm Password");
        rconfirm.setBounds(5,400,200,50);
        rconfirm.setFont(fon);
        rconfirm.setForeground(Color.white);
        register.add(rconfirm);

        JTextField econfirm=new JTextField();
        econfirm.setBounds(150,415,170,20);
        econfirm.setBorder(null);
        econfirm.setBackground(Color.gray);
        econfirm.setFont(fon);
        register.add(econfirm);



        Font font2=new Font("serif",Font.BOLD,12);
        JButton create_account=new JButton("Create Account");
        create_account.setBounds(95,460,120,30);
        create_account.setBackground(Color.gray);
        create_account.setFont(font2);
        register.add(create_account);
        create_account.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String epa=epass.getText();
                    String econ=econfirm.getText();
                    String dat = null;
                    String mon =null;
                    String yea=null;
                    String date_of_birth;
                    String gen;
                    if (date.getSelectedIndex() != -1) {
                        dat = "" + date.getItemAt(date.getSelectedIndex());

                    }
                    if (month.getSelectedIndex() != -1) {
                        mon = "" + month.getItemAt(month.getSelectedIndex());
                    }
                    if (year.getSelectedIndex() != -1) {
                        yea = "" + year.getItemAt(year.getSelectedIndex());
                    }
                    date_of_birth=dat + "-" + mon + "-" + yea;

                    if(male.isSelected()){
                        gen="male";
                    }
                    else if(female.isSelected()){
                        gen="female";
                    }
                    else{
                        gen="";
                    }
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema_schedule_project","root","Ant@784301");
                    Statement st=con.createStatement();
                    //st.executeUpdate("insert into login values('"+t1.getText()+"','"+t2.getText()+"');");
                    if(ename.getText().equals("")||lename.getText().equals("")||eage.getText().equals("")||emobile.getText().equals("")||euname.getText().equals("")||eemail.getText().equals("")||epass.getText().equals("")||econfirm.getText().equals("")){
                        JOptionPane.showMessageDialog(null,"Please Enter All the Fields");
                    }
                    else if(gen.equals("")){
                        JOptionPane.showMessageDialog(null,"Please select your gender");
                    }
                    else if(!epa.equals(econ)){
                        JOptionPane.showMessageDialog(null,"Passwords are not same");
                    }
                    else{
                        st.executeUpdate("insert into user_registration values('"+ename.getText()+"','"+lename.getText()+"','"+eage.getText()+"','"+emobile.getText()+"','"+date_of_birth+"','"+gen+"','"+euname.getText()+"','"+eemail.getText()+"','"+epass.getText()+"');");
                        JOptionPane.showMessageDialog(null,"Regestered successfully");
                    }
                    System.out.println("database connected");
                } catch (Exception ae) {
                    System.out.println(ae);
                }
            }
        });

    }
     public Dimension getPreferredSize() {
         return new Dimension(550,800);
     }

}
