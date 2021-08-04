import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class About_us extends JPanel {
    About_us(){
        setSize(550,800);
        setBackground(new Color(0,0,0,0));
        JPanel about=new JPanel();
        about.setSize(500,550);
        about.setBackground(new Color(0,0,0,60));
        about.setBounds(20,125,500,550);
        about.setLayout(null);
        add(about);

        Dimension dim=getPreferredSize();
        dim.height=120;
        setPreferredSize(dim);
        setLayout(new BorderLayout());


        JLabel memb1=new JLabel("1. ANTENEH SOLOMON              UGR/16798/11" );
        Font font1=new Font("serif",Font.BOLD,16);
        memb1.setFont(font1);
        memb1.setForeground(Color.white);
        memb1.setBounds(50,50,400,100);
        about.add(memb1);

        JLabel memb2=new JLabel("2. DAWIT TADESSE                      A/UR14305/10" );
        memb2.setFont(font1);
        memb2.setForeground(Color.white);
        memb2.setBounds(50,80,400,100);
        about.add(memb2);

        JLabel memb3=new JLabel("3. ABIYU ALEMAYHEW               UGR/16706/11" );
        memb3.setFont(font1);
        memb3.setForeground(Color.white);
        memb3.setBounds(50,110,400,100);
        about.add(memb3);

        JLabel memb4=new JLabel("4. SHIS MUBAREK                         A/UR14753/10" );
        memb4.setFont(font1);
        memb4.setForeground(Color.white);
        memb4.setBounds(50,140,400,100);
        about.add(memb4);

        JLabel memb5=new JLabel("5. AMANUEL KINDE                     UGR/16769/11" );
        memb5.setFont(font1);
        memb5.setForeground(Color.white);
        memb5.setBounds(50,170,400,100);
        about.add(memb5);

        JLabel memb6=new JLabel("6. DILAMO WONDIMU                 UGR/16996/11" );
        memb6.setFont(font1);
        memb6.setForeground(Color.white);
        memb6.setBounds(50,200,400,100);
        about.add(memb6);



    }
}
