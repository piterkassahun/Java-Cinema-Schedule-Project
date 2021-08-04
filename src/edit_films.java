import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class edit_films extends JPanel {
    edit_films(){
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

        JButton book=new JButton("Delete");
        book.setBackground(Color.DARK_GRAY);
        book.setForeground(Color.WHITE);
        book.setBounds(140,420,120,25);
        pane.add(book);

        Films_db_reteriver re=new Films_db_reteriver();

        book.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema_schedule_project","root","Ant@784301");
                    Statement st=con.createStatement();
                    String sql="DELETE FROM `cinema_schedule_project`.`film_registration` WHERE (`title` = '"+re.getTitle()+ "');";
                    PreparedStatement pst=con.prepareStatement(sql);
                    pst.execute();
                }catch (Exception exe){
                    System.out.println(exe);
                }
            }
        });

    }
}
