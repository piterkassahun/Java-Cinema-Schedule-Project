import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Booking_interface extends JPanel {
    Booking_interface(){
        setSize(550,800);
        setBackground(new Color(0,0,0,0));

        Dimension dim=getPreferredSize();
        dim.height=120;
        setPreferredSize(dim);
        setLayout(new BorderLayout());


        ImageIcon background_image=new ImageIcon("src/images/h0Vxgz5tyXA_Full.jpg");
        Image img=background_image.getImage();
        Image temp_img=img.getScaledInstance(550,800,Image.SCALE_SMOOTH);
        background_image=new ImageIcon(temp_img);
        JLabel background=new JLabel("",background_image,JLabel.CENTER);
        add(background);

        Films_db_reteriver ret=new Films_db_reteriver();
        Main mai=new Main();
        System.out.println(ret.getTitle());
        System.out.println(ret.getDate());

        JPanel pane=new JPanel();
        pane.setBounds(70,40,400,700);
        pane.setBackground(new Color(0,0,0,60));
        pane.setLayout(null);
        background.add(pane);

        JLabel imagelabel=new JLabel();
        imagelabel.setBounds(20,20,300,300);
        imagelabel.setIcon(ret.getImageIcon());
        pane.add(imagelabel);

        JLabel title=new JLabel();
        title.setText("Title: " + ret.getTitle());
        title.setBounds(225,100,200,20);
        title.setForeground(Color.white);
        pane.add(title);

        JLabel date=new JLabel();
        date.setText("Date: " + ret.getDate());
        date.setBounds(225,130,200,20);
        date.setForeground(Color.white);
        pane.add(date);

        JLabel type=new JLabel();
        type.setText("Type: " + ret.getType());
        type.setBounds(225,160,200,20);
        type.setForeground(Color.white);
        pane.add(type);

        JLabel time=new JLabel();
        time.setText("Time: " + ret.getTime());
        time.setBounds(225,190,200,20);
        time.setForeground(Color.white);
        pane.add(time);

        JLabel price=new JLabel();
        price.setText("Price: " + ret.getPrice() + " birr");
        price.setBounds(225,220,200,20);
        price.setForeground(Color.white);
        pane.add(price);

        JLabel cinema=new JLabel();
        cinema.setText("Cinema: " + ret.getCinema());
        cinema.setBounds(225,250,200,20);
        cinema.setForeground(Color.white);
        pane.add(cinema);

        JLabel description=new JLabel();
        description.setText("Description: " + ret.getDescription());
        description.setBounds(20,340,200,20);
        description.setForeground(Color.white);
        pane.add(description);

        JButton book=new JButton("Book");
        book.setBackground(Color.DARK_GRAY);
        book.setForeground(Color.WHITE);
        book.setBounds(140,420,120,25);
        pane.add(book);

        book.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(ret.getCinema() + " " + mai.getUsername() + " " + ret.getTitle());
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Cinema_schedule_project","root","Ant@784301");
                    Statement st=con.createStatement();
                    String query="select *from booking";
                    ResultSet rs=st.executeQuery(query);
                    boolean boo=false;
                    while(rs.next()){
                        if(rs.getString(1).equals(ret.getCinema())&&rs.getString(2).equals(mai.getUsername())&&rs.getString(3).equals(ret.getTitle())){
                            boo=true;
                        }

                    }
                    if(boo){
                        JOptionPane.showMessageDialog(null,"You have already booked");

                    }
                    else{
                        st.executeUpdate("insert into booking values('"+ret.getCinema()+"','"+mai.getUsername()+"','"+ret.getTitle()+"');");
                        JOptionPane.showMessageDialog(null,"Thanks for booking");
                    }

                }catch(Exception exe){
                    System.out.println(exe.getMessage());
                    JOptionPane.showMessageDialog(null,"Error in entering");
                }
            }
        });

    }
}
