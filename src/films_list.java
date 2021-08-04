import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class films_list extends JPanel {
    private JTextField textField;
    private DefaultListModel<Item> listmodel=new DefaultListModel<>();
    private final String DEFAULT_LABEL_TEXT= "Click to set icon";

    films_list(){
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


        JLabel lblIcon = new JLabel(DEFAULT_LABEL_TEXT);

        JList<Item> list =new JList<>(listmodel);
        list.setOpaque(false);
        list.setCellRenderer(new Cell_Render());
        JScrollPane scrollPane=new JScrollPane(list);
        scrollPane.setBounds(0,0,550,800);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        background.add(scrollPane);

        try{
            Connection mysqlcinn=Mysqlconnection.getconnection();
            Statement st=mysqlcinn.createStatement();
            String query="SELECT * FROM film_registration";
            ResultSet resultset=st.executeQuery(query);
            String image;
            int i=0;
            while (resultset.next()){
                BufferedImage im=ImageIO.read(resultset.getBinaryStream(8));
                lblIcon.setIcon(new ImageIcon(im.getScaledInstance(120,150,Image.SCALE_SMOOTH)));
                String filmtitle=resultset.getString("Title");
                listmodel.addElement(new Item(filmtitle,(ImageIcon) lblIcon.getIcon()));
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
            System.out.println(e.getMessage());
        }

        list.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()==2){
                    Main main=new Main();
                    boolean log=main.isUserlogged();
                    if(log){
                        JOptionPane.showMessageDialog(null,"Logged in");
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Please login to book and see detail");
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

    }
}
