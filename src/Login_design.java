import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

class Login_design extends JPanel {
    Login_design(){

        setSize(550,800);
        setBackground(Color.gray);
        JPanel login=new JPanel();
        login.setSize(400,450);
        login.setBackground(new Color(0,0,0,60));
        login.setBounds(65,150,400,450);
        login.setLayout(null);
        add(login);


        Dimension dim=getPreferredSize();
        dim.height=120;
        setPreferredSize(dim);
        setLayout(new BorderLayout());

        setBackground(new Color(0,0,0,20));
        JLabel username=new JLabel("User Name");
        Font font1=new Font("serif",Font.BOLD,16);
        username.setFont(font1);
        username.setForeground(Color.white);
        username.setBounds(50,50,200,50);
        login.add(username);

        JTextField user_name=new JTextField(20);
        user_name.setBounds(50,100,300,40);
        user_name.setBackground(Color.darkGray);
        user_name.setForeground(Color.white);
        user_name.setBorder(null);
        login.add(user_name);

        JLabel pass=new JLabel("Password");
        pass.setFont(font1);
        pass.setForeground(Color.white);
        pass.setBounds(50,150,200,50);
        login.add(pass);

        JPasswordField password=new JPasswordField(20);
        password.setBounds(50,200,300,40);
        password.setBorder(null);
        password.setBackground(Color.darkGray);
        password.setForeground(Color.white);
        login.add(password);

        JButton log_in=new JButton("Login");
        log_in.setBounds(50,250,80,40);
        Font font2=new Font("serif",Font.BOLD,12);
        log_in.setBackground(Color.gray);
        log_in.setFont(font2);
        login.add(log_in);

        JButton create=new JButton("Create Account");
        create.setBounds(220,250,130,40);
        create.setBackground(Color.gray);
        create.setFont(font2);
        login.add(create);

        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Registration_design registration_design=new Registration_design();
                Main_page main=new Main_page("register");
            }
        });

        log_in.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema_schedule_project","root","Ant@784301");
                    Statement st=con.createStatement();
                    //Resultset rs= st.executeQuery("select *from user_registration where User_name ='"+username.getText()+"'");
                    String query="select *from user_registration";
                    ResultSet rs=st.executeQuery(query);
                    String get_password="";
                    if(username.getText().equals("")||password.getText().equals("")){
                        JOptionPane.showMessageDialog(null,"Please enter all the forms");
                        return;
                    }
                    boolean log=false;
                    while(rs.next()){
                        System.out.println(rs.getString(7));
                        System.out.println(rs.getString(9));

                        if(rs.getString(9).equals(password.getText())&&rs.getString(7).equals(user_name.getText())){
                            JOptionPane.showMessageDialog(null,"Login Successfull");
                            Main main=new Main();
                            main.setUserlogged(true);
                            System.out.println(main.isUserlogged());
                            main.setFirstname(rs.getString(1));
                            System.out.println(rs.getString(1));
                            main.setLastname(rs.getString(2));
                            System.out.println(rs.getString(2));
                            main.setAge(rs.getInt(3));
                            System.out.println(rs.getInt(3));
                            main.setMobile(rs.getInt(4));
                            System.out.println(rs.getInt(4));
                            main.setDate(rs.getString(5));
                            System.out.println(rs.getString(5));
                            main.setGender(rs.getString(6));
                            System.out.println(rs.getString(6));
                            main.setUsername(rs.getString(7));
                            System.out.println(rs.getString(7));
                            main.setUseremail(rs.getString(8));
                            System.out.println(rs.getString(8));
                            Main_page main_page=new Main_page("films_list_logged");
                            log=true;
                            break;
                        }
                    }
                    if(log) {

                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Username or password is incorrect");
                    }

                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                    System.out.println(ex);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    System.out.println(ex);
                }


            }
        });

    }
    public Dimension getPreferredSize() {
        return new Dimension(550,800);
    }

}
