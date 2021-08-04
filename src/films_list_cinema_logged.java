import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class films_list_cinema_logged extends JPanel {
    private JTextField textField;
    private DefaultListModel<Item> listmodel=new DefaultListModel<>();
    private final String DEFAULT_LABEL_TEXT= "Click to set icon";
    Films_db_reteriver ret=new Films_db_reteriver();
    films_list_cinema_logged(){
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

        JPanel pane=new JPanel();
        pane.setBackground(new Color(0,0,0,0));
        pane.setBounds(0,0,550,30);
        pane.setLayout(null);
        background.add(pane);


        JButton editaccount=new JButton("Edit account");
        Font font2=new Font("serif",Font.BOLD,12);
        editaccount.setBackground(Color.gray);
        editaccount.setFont(font2);
        editaccount.setBounds(0,0,120,30);
        pane.add(editaccount);

        JButton logout=new JButton("Logout");
        logout.setFont(font2);
        logout.setBackground(Color.gray);
        logout.setBounds(420,0,120,30);
        pane.add(logout);
        JLabel lblIcon = new JLabel(DEFAULT_LABEL_TEXT);

        JButton addmovie=new JButton("Add movie");
        addmovie.setFont(font2);
        addmovie.setBackground(Color.GRAY);
        addmovie.setBounds(200,0,120,30);
        pane.add(addmovie);

        JList<Item> list =new JList<>(listmodel);
        list.setOpaque(false);
        list.setCellRenderer(new Cell_Render());
        JScrollPane scrollPane=new JScrollPane(list);
        scrollPane.setBounds(0,30,550,770);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        background.add(scrollPane);

        try{
            Connection mysqlcinn=Mysqlconnection.getconnection();
            Statement st=mysqlcinn.createStatement();
            Main mm=new Main();
            String query="SELECT * FROM film_registration Where(Cinema='"+mm.getKeyname()+"');";
            System.out.println(query);
            ResultSet resultset=st.executeQuery(query);
            String image;
            int i=0;
            while (resultset.next()){
                BufferedImage im= ImageIO.read(resultset.getBinaryStream(8));
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
                    boolean log=main.isCinemalogged();
                    System.out.println(main.isUserlogged());
                    String name=((Item)list.getSelectedValue()).getText();
                    if(log){
                        try{
                            Connection mysqlcinn=Mysqlconnection.getconnection();
                            Statement st=mysqlcinn.createStatement();
                            System.out.println(main.getKeyname());
                            String query="SELECT * FROM film_registration";
                            ResultSet resultset=st.executeQuery(query);
                            while (resultset.next()){
                                if(name.equals(resultset.getString("Title"))){
                                    ret.setTitle(resultset.getString(1));
                                    ret.setDate(resultset.getString(2));
                                    ret.setType(resultset.getString(3));
                                    ret.setTime(resultset.getString(4));
                                    ret.setPrice(resultset.getString(5));
                                    ret.setDescription(resultset.getString(6));
                                    ret.setCinema(resultset.getString(7));
                                    BufferedImage im=ImageIO.read(resultset.getBinaryStream(8));
                                    lblIcon.setIcon(new ImageIcon(im.getScaledInstance(200,300,Image.SCALE_SMOOTH)));
                                    ret.setImageIcon((ImageIcon) lblIcon.getIcon());

                                }
                            }
                        }catch (Exception eve){
                            System.out.println(eve);
                        }
                        Main_page ma=new Main_page("edit_films");
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

        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main main=new Main();
                main.setCinemalogged(false);
                Main_page mai=new Main_page("filmslist");

            }
        });

        editaccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main_page mai=new Main_page("edit_cinema_account");
            }
        });

        addmovie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main_page mai=new Main_page("films_register");
            }
        });
    }
}
