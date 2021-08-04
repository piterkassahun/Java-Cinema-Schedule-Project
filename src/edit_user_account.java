import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


class edit_user_account extends JPanel {
    String dates[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
    String months[] = { "Jan", "feb", "Mar", "Apr", "May", "Jun", "July", "Aug", "Sup", "Oct", "Nov", "Dec" };
    String years[] = { "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002",
            "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010",
            "2011", "2012", "2103", "2014", "2015", "2016", "2017", "2018", "2019" };
    edit_user_account(){

        Main main=new Main();

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




        JLabel form=new JLabel("Edit the fields to edit your account",JLabel.CENTER);
        Font fon=new Font("Serif",Font.BOLD,15);
        form.setForeground(Color.white);
        form.setBounds(5,0,250,50);
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
        ename.setText(main.getFirstname());
        System.out.println(main.getFirstname());
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
        lename.setText(main.getLastname());
        System.out.println(main.getLastname());
        lename.setFont(fon);
        register.add(lename);

        JLabel rage=new JLabel("Age");
        rage.setBounds(5,120,200,50);
        rage.setFont(fon);
        rage.setForeground(Color.white);
        register.add(rage);

        JLabel eage=new JLabel();
        eage.setBounds(150,135,170,20);
        eage.setBorder(null);
        eage.setBackground(Color.gray);
        eage.setForeground(Color.WHITE);
        eage.setFont(fon);
        eage.setText(String.valueOf(main.getAge()));
        System.out.println(String.valueOf(main.getAge()));
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
        emobile.setText(String.valueOf(main.getMobile()));
        System.out.println(String.valueOf(main.getMobile()));
        register.add(emobile);

        JLabel rdob=new JLabel("DOB");
        rdob.setBounds(5,200,200,50);
        rdob.setForeground(Color.white);
        rdob.setFont(fon);
        register.add(rdob);


        JLabel date = new JLabel();
        date.setFont(fon);
        date.setBounds(150,215,200,20);
        date.setBorder(null);
        date.setForeground(Color.WHITE);
        date.setText(main.getDate());
        date.setBackground(Color.gray);
        register.add(date);
        repaint();




        JLabel rgender=new JLabel("Gender");
        rgender.setBounds(5,240,200,50);
        rgender.setForeground(Color.white);
        rgender.setFont(fon);
        register.add(rgender);

        JLabel male = new JLabel();
        male.setBounds(150,260,80,15);
        male.setBackground(Color.gray);
        male.setText(main.getGender());
        male.setForeground(Color.WHITE);
        male.setBorder(null);
        register.add(male);



        JLabel runame=new JLabel("U.Name");
        runame.setBounds(5,280,200,50);
        runame.setFont(fon);
        runame.setForeground(Color.white);

        register.add(runame);

        JLabel euname=new JLabel();
        euname.setBounds(150,295,170,20);
        euname.setBorder(null);
        euname.setForeground(Color.WHITE);
        euname.setBackground(Color.gray);
        euname.setFont(fon);
        String seuname=main.getUsername();
        euname.setText(main.getUsername());
        System.out.println(main.getUsername());
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
        eemail.setText(main.getUseremail());
        System.out.println(main.getUseremail());
        register.add(eemail);

        JLabel rpass=new JLabel("New Password");
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

        JLabel rconfirm=new JLabel("Con. new Password");
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
        JButton create_account=new JButton("Apply changes");
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
                    Main ma=new Main();
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema_schedule_project","root","Ant@784301");
                    String query="select *from user_registration";
                    String queryuudate="UPDATE `cinema_schedule_project`.`cinema_registration` SET `Company_name` = 'cinema ', `Company_mobile` = '111234568' WHERE (`Company_name` = 'cinema ethiopia');";
                    String queryupdate="UPDATE `cinema_schedule_project`.`user_registration` SET `First_name` = ?, `Last_name` = ?, `Mobile` = ?, `Email` = ?, `Password` = ? WHERE (`User_name` = '"+ma.getUsername()+"');";
                    PreparedStatement pre=con.prepareStatement(queryupdate);
                    Statement st=con.createStatement();
                    ResultSet rs=st.executeQuery(query);
                    if(ename.getText().equals("")||lename.getText().equals("")||emobile.getText().equals("")||eemail.getText().equals("")||epass.getText().equals("")||econfirm.getText().equals("")){
                        JOptionPane.showMessageDialog(null,"Please Enter All the Fields");
                    }
                    else if(!epa.equals(econ)){
                        JOptionPane.showMessageDialog(null,"Passwords are not same");
                    }
                    else{
                        while(rs.next()){ ;
                            if(rs.getString(7).equals(ma.getUsername())){
                                pre.setString(1,ename.getText());
                                pre.setString(2,lename.getText());
                                pre.setString(3,emobile.getText());
                                pre.setString(4,eemail.getText());
                                pre.setString(5,epass.getText());
                                pre.executeUpdate();
                                JOptionPane.showMessageDialog(null,"Changed Successfully");
                                break;
                            }
                        }
                    }

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
