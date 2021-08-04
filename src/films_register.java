import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class films_register extends JPanel {
    String filepath;
    File file;
    FileInputStream fin;
    films_register(){


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

        JPanel register=new JPanel();
        register.setSize(400,450);
        register.setBackground(new Color(0,0,0,30));
        register.setBounds(70,90,400,600);
        register.setLayout(null);
        background.add(register);


        JLabel rtitle=new JLabel("Title");
        Font fon=new Font("Serif",Font.BOLD,15);
        rtitle.setBounds(5,40,200,50);
        rtitle.setFont(fon);
        rtitle.setForeground(Color.white);
        register.add(rtitle);

        JTextField etitle=new JTextField();
        etitle.setBounds(150,55,190,20);
        etitle.setBorder(null);
        etitle.setBackground(Color.gray);
        etitle.setFont(fon);
        register.add(etitle);

        JLabel rdate=new JLabel("Date");
        rdate.setBounds(5,80,200,50);
        rdate.setFont(fon);
        rdate.setForeground(Color.white);
        register.add(rdate);

        JTextField edate=new JTextField();
        edate.setBounds(150,95,190,20);
        edate.setBorder(null);
        edate.setBackground(Color.gray);
        edate.setFont(fon);
        register.add(edate);

        JLabel rtype=new JLabel("Film Type");
        rtype.setBounds(5,120,200,50);
        rtype.setFont(fon);
        rtype.setForeground(Color.white);
        register.add(rtype);

        JTextField etype=new JTextField();
        etype.setBounds(150,135,190,20);
        etype.setBorder(null);
        etype.setBackground(Color.gray);
        etype.setFont(fon);
        register.add(etype);

        JLabel rtime=new JLabel("Time");
        rtime.setBounds(5,160,200,50);
        rtime.setForeground(Color.white);
        rtime.setFont(fon);
        register.add(rtime);

        JTextField etime=new JTextField();
        etime.setBounds(150,175,190,20);
        etime.setBorder(null);
        etime.setBackground(Color.gray);
        etime.setFont(fon);
        register.add(etime);

        JLabel rPrice=new JLabel("Price");
        rPrice.setBounds(5,200,200,50);
        rPrice.setForeground(Color.white);
        rPrice.setFont(fon);
        register.add(rPrice);

        JTextField eprice=new JTextField();
        eprice.setBounds(150,215,190,20);
        eprice.setBorder(null);
        eprice.setBackground(Color.gray);
        eprice.setFont(fon);
        register.add(eprice);

        JLabel rdescription=new JLabel("Description");
        rdescription.setBounds(5,240,200,50);
        rdescription.setForeground(Color.white);
        rdescription.setFont(fon);
        register.add(rdescription);

        JTextField edescription=new JTextField();
        edescription.setBounds(150,255,190,20);
        edescription.setBorder(null);
        edescription.setBackground(Color.gray);
        edescription.setFont(fon);
        register.add(edescription);

        JLabel rimage=new JLabel("Image");
        rimage.setBounds(5,280,200,50);
        rimage.setForeground(Color.white);
        rimage.setFont(fon);
        register.add(rimage);

        JButton showFileDialogButton = new JButton("Open File");
        Font font2=new Font("serif",Font.BOLD,12);
        showFileDialogButton.setBounds(150,295,100,20);
        showFileDialogButton.setBackground(Color.gray);
        showFileDialogButton.setFont(font2);
        register.add(showFileDialogButton);


        JTextField statusLabel=new JTextField("File name");
        statusLabel.setBounds(260,295,80,20);
        statusLabel.setBorder(null);
        statusLabel.setBackground(Color.gray);
        statusLabel.setFont(fon);
        register.add(statusLabel);

        JButton insert = new JButton("Insert film");
        insert.setBounds(150,350,120,30);
        insert.setBackground(Color.gray);
        insert.setFont(font2);
        register.add(insert);
        showFileDialogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser=new JFileChooser();
                //fileChooser.setCurrentDirectory(new File(System.getProperty("user home")));
                int result=fileChooser.showSaveDialog(getParent());
                if(result==JFileChooser.APPROVE_OPTION){
                     File selectedfile=fileChooser.getSelectedFile();
                     statusLabel.setText(selectedfile.getAbsolutePath());
                     file=new File(statusLabel.getText());
                     System.out.println(statusLabel.getText());
                    try {
                        fin=new FileInputStream(file);
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }

                }
            }
        });

        insert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Cinema_schedule_project","root","Ant@784301");
                    Statement st=con.createStatement();
                    PreparedStatement pre=con.prepareStatement("insert into film_registration values(?,?,?,?,?,?,?,?)");
                    if(etitle.getText().equals("")||edate.getText().equals("")||etype.getText().equals("")||etime.getText().equals("")||eprice.getText().equals("")||edescription.getText().equals("")){
                        JOptionPane.showMessageDialog(null,"Please enter all the forms");
                    }
                    else{
                        Main mm=new Main();
                        String cinema=mm.getKeyname();
                        System.out.println(mm.getKeyname());
                        pre.setString(1,etitle.getText());
                        pre.setString(2,edate.getText());
                        pre.setString(3,etype.getText());
                        pre.setString(4,etime.getText());
                        pre.setString(5,eprice.getText());
                        pre.setString(6,edescription.getText());
                        pre.setString(7,cinema);
                        pre.setBinaryStream(8,(InputStream)fin,(int)file.length());
                        pre.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Inserted Successfully");
                        //st.executeUpdate("insert into film_registration values('"+etitle.getText()+"','"+edate.getText()+"','"+etype.getText()+"','"+etime.getText()+"','"+eprice.getText()+"','"+edescription.getText()+"','"+cinema+"','"+statusLabel.getText()+"');");
                    }
                } catch (Exception ae) {
                    System.out.println(ae);
                }
            }
        });

    }
}
