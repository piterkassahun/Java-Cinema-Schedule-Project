import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class cinema_register extends JPanel {
    cinema_register(){
        //setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //pack();
        //setLocationByPlatform(true);
        //setVisible(true);
        //setSize(550,800);

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

        Font fon=new Font("Serif",Font.BOLD,15);
        JLabel form=new JLabel("Enter the form to register",JLabel.CENTER);
        form.setForeground(Color.white);
        form.setBounds(100,0,200,50);
        form.setFont(fon);
        register.add(form);

        JLabel rname=new JLabel("Company Name");
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

        JLabel rmobile=new JLabel("Company Mobile");
        rmobile.setBounds(5,80,200,50);
        rmobile.setForeground(Color.white);
        rmobile.setFont(fon);
        register.add(rmobile);

        JTextField emobile=new JTextField();
        emobile.setBounds(150,95,170,20);
        emobile.setBorder(null);
        emobile.setBackground(Color.gray);
        emobile.setFont(fon);
        register.add(emobile);



        JLabel runame=new JLabel("Key Name");
        runame.setBounds(5,120,200,50);
        runame.setFont(fon);
        runame.setForeground(Color.white);
        register.add(runame);

        JTextField euname=new JTextField();
        euname.setBounds(150,135,170,20);
        euname.setBorder(null);
        euname.setBackground(Color.gray);
        euname.setFont(fon);
        register.add(euname);

        JLabel remail=new JLabel("Company Email");
        remail.setBounds(5,160,170,50);
        remail.setFont(fon);
        remail.setForeground(Color.white);
        register.add(remail);

        JTextField eemail=new JTextField();
        eemail.setBounds(150,175,170,20);
        eemail.setBorder(null);
        eemail.setBackground(Color.gray);
        eemail.setFont(fon);
        register.add(eemail);

        JLabel rpass=new JLabel("Password");
        rpass.setBounds(5,200,200,50);
        rpass.setFont(fon);
        rpass.setForeground(Color.white);
        register.add( rpass);

        JTextField epass=new JTextField();
        epass.setBounds(150,215,170,20);
        epass.setBorder(null);
        epass.setBackground(Color.gray);
        epass.setFont(fon);
        register.add(epass);

        JLabel rconfirm=new JLabel("Confirm Password");
        rconfirm.setBounds(5,240,200,50);
        rconfirm.setFont(fon);
        rconfirm.setForeground(Color.white);
        register.add(rconfirm);

        JTextField econfirm=new JTextField();
        econfirm.setBounds(150,255,170,20);
        econfirm.setBorder(null);
        econfirm.setBackground(Color.gray);
        econfirm.setFont(fon);
        register.add(econfirm);



        Font font2=new Font("serif",Font.BOLD,12);
        JButton create_account=new JButton("Create Account");
        create_account.setBounds(95,280,120,30);
        create_account.setBackground(Color.gray);
        create_account.setFont(font2);
        register.add(create_account);
        create_account.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Cinema_schedule_project","root","Ant@784301");
                    Statement st=con.createStatement();
                    //st.executeUpdate("insert into login values('"+t1.getText()+"','"+t2.getText()+"');");
                    if(ename.getText().equals("")||emobile.getText().equals("")||euname.getText().equals("")||eemail.getText().equals("")||epass.getText().equals("")||econfirm.getText().equals("")){
                        JOptionPane.showMessageDialog(null,"Please fill all the forms");
                    }
                    else if(!epass.getText().equals(econfirm.getText())){
                        JOptionPane.showMessageDialog(null,"Passwords are not same");
                    }
                    else{
                            st.executeUpdate("insert into cinema_registration values('"+ename.getText()+"','"+emobile.getText()+"','"+euname.getText()+"','"+eemail.getText()+"','"+epass.getText()+"');");
                    }
                } catch (Exception ae) {
                    System.out.println(ae);
                }
            }
        });
    }
}
