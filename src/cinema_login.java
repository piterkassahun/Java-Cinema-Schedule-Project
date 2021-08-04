import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class cinema_login extends JPanel {
    cinema_login(){
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
        JLabel username=new JLabel("Cinema U. Name");
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
                Main_page main=new Main_page("cinregister");

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
                    String query="select *from cinema_registration";
                    ResultSet rs=st.executeQuery(query);
                    String get_password="";
                    if(username.getText().equals("")||password.getText().equals("")){
                        JOptionPane.showMessageDialog(null,"Please enter all the forms");
                        return;
                    }
                    while(rs.next()){
                        System.out.println(rs.getString(3));
                        System.out.println(rs.getString(5));

                        if(rs.getString(5).equals(password.getText())&&rs.getString(3).equals(user_name.getText())){
                            JOptionPane.showMessageDialog(null,"Login Successfull");
                            Main ma=new Main();
                            ma.setCinemalogged(true);
                            ma.setCompanyname(rs.getString(1));
                            ma.setCompanymobile(rs.getInt(2));
                            ma.setKeyname(rs.getString(3));
                            ma.setCompanemail(rs.getString(4));
                            ma.setCompanypassword(rs.getString(5));
                            Main_page mai=new Main_page("films_list_cinema_logged");
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"Username or password is incorrect");
                        }

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
}
