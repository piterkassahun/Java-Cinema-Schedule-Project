import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

public class Main_page extends JFrame implements ActionListener {
    public static CardLayout cardLayout;
    public static JPanel mainpanel;
    public static Login_design login;
    public static cinema_login cinemalog;
    public static films_list films_list;
    public static Registration_design registration_design;
    public static films_register films_register;
    public static films_list_logged films_list_logged;
    public static edit_films edit_films;
    public static edit_user_account edit_user_account;
    public static edit_cinema_account edit_cinema_account;
    public static cinema_register cinema_register;
    public static films_list_cinema_logged films_list_cinema_logged;
    public static Booking_interface booking_interface;
    public static About_us about_us;

    public Main_page(){

        cardLayout=new CardLayout();
        mainpanel=new JPanel(cardLayout);
        about_us=new About_us();
        login=new Login_design();
        films_list=new films_list();
        cinemalog=new cinema_login();
        films_register=new films_register();
        registration_design=new Registration_design();
        cinema_register=new cinema_register();
        mainpanel.add(films_list,"filmslist");
        mainpanel.add(films_register,"films_register");
        mainpanel.add(about_us,"about_us");
        mainpanel.add(registration_design,"register");
        mainpanel.add(login,"login");
        mainpanel.add(cinema_register,"cinregister");
        mainpanel.add(cinemalog,"cinemalog");

        mainpanel.setBounds(350,0,550,800);
        mainpanel.setBackground(new Color(0,0,0,20));
        pack();
        setLocationByPlatform(true);
        setVisible(true);
        setResizable(false);
        setLocation(60,20);



        //background
        ImageIcon background_image=new ImageIcon("src/images/h0Vxgz5tyXA_Full.jpg");
        Image img=background_image.getImage();
        Image temp_img=img.getScaledInstance(900,800,Image.SCALE_SMOOTH);
        background_image=new ImageIcon(temp_img);
        JLabel background=new JLabel("",background_image,JLabel.CENTER);
        add(background);
        background.setBounds(0,0,900,800);
        setSize(900,800);
        setLayout(null);


        //first panel
        JPanel first=new JPanel();
        first.setBackground(new Color(0,0,0,80));
        first.setBounds(0,0,350,800);
        first.setLayout(null);
        /*JLabel name=new JLabel("CSP",JLabel.CENTER);
        name.setBounds(0,5,400,50);
        Font font=new Font("Serif",Font.BOLD,40);
        name.setFont(font);
        name.setForeground(Color.WHITE);
        first.add(name);*/


        BufferedImage image;
        ImageIcon icon=new ImageIcon("src/images/test.png");
        JLabel piclabel=new JLabel(icon);
        piclabel.setBounds(100,30,150,150);
        first.add(piclabel);


        JButton lists=new JButton("Movies List");
        Font font2=new Font("serif",Font.BOLD,12);
        lists.setBounds(100,210,120,30);
        lists.setBackground(Color.gray);
        lists.setForeground(Color.WHITE);
        lists.setFont(font2);
        first.add(lists);


        JButton account=new JButton("Account");
        account.setBounds(100,260,120,30);
        account.setBackground(Color.gray);
        account.setFont(font2);
        account.setForeground(Color.WHITE);
        account.addActionListener(this);
        first.add(account);

        JButton admins=new JButton("Cinema Admins");
        admins.setBounds(100,310,120,30);
        admins.setBackground(Color.gray);
        admins.setFont(font2);
        admins.setForeground(Color.WHITE);
        first.add(admins);


        JButton other=new JButton("About Us");
        other.setBounds(100,360,120,30);
        other.setBackground(Color.gray);
        other.setFont(font2);
        other.setForeground(Color.WHITE);
        first.add(other);

        other.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainpanel,"about_us");
                repaint();
            }
        });




        background.add(first);
        background.add(mainpanel);
        admins.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cinemalogon();
            }
        });

        lists.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main maa=new Main();
                boolean logg=maa.isUserlogged();
                boolean loge=maa.isCinemalogged();
                if(logg){
                    cardLayout.show(mainpanel,"films_list_logged");
                    repaint();
                }
                else if(loge){
                    cardLayout.show(mainpanel,"films_list_cinema_logged");
                    repaint();
                }
                else{
                    cardLayout.show(mainpanel,"filmslist");
                    repaint();
                }
            }
        });

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        gameon();
    }

    public void gameon(){
        Main ma=new Main();
        boolean lo=ma.isCinemalogged();
        boolean loo=ma.isUserlogged();
        if(lo){
            JOptionPane.showMessageDialog(null,"Cinema admins and users can not enter together, please logout cinema account");
        }
        else if(loo){
            cardLayout.show(mainpanel,"films_list_logged");
            repaint();
        }
        else{
            cardLayout.show(mainpanel,"login");
            repaint();
            //JOptionPane.showMessageDialog(null,"clicked");
        }

    }

    public void cinemalogon(){
        Main main=new Main();
        boolean log=main.isUserlogged();
        boolean looog=main.isCinemalogged();
        if(log){
            JOptionPane.showMessageDialog(null,"Cinema admins and users can not enter together, please logout user account");
        }
        else if(looog){
            cardLayout.show(mainpanel,"films_list_cinema_logged");
            repaint();
        }
        else{
            cardLayout.show(mainpanel,"cinemalog");
            repaint();
        }

    }




    public static void main(String args[]){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Main_page main=new Main_page();
            }
        });
    }

    public void change_card(String changed){

    }
    public Main_page(String changed){
        if(changed.equals("booking_interface")){
            booking_interface=new Booking_interface();
            mainpanel.add(booking_interface,"booking_interface");
        }
        else if(changed.equals("edit_films")){
            edit_films=new edit_films();
            mainpanel.add(edit_films,"edit_films");
        }
        else if(changed.equals("edit_cinema_account")){
            edit_cinema_account=new edit_cinema_account();
            mainpanel.add(edit_cinema_account,"edit_cinema_account");
        }
        else if(changed.equals("films_list_logged")){
            films_list_logged=new films_list_logged();
            mainpanel.add(films_list_logged,"films_list_logged");
        }
        else if(changed.equals("films_list_cinema_logged")){
            films_list_cinema_logged=new films_list_cinema_logged();
            mainpanel.add(films_list_cinema_logged,"films_list_cinema_logged");
        }
        cardLayout.show(mainpanel,changed);
        mainpanel.repaint();
    }
    public Main_page(String edit,int num){
        edit_user_account=new edit_user_account();
        mainpanel.add(edit_user_account,"edit_user_account");
        cardLayout.show(mainpanel,edit);
        mainpanel.repaint();
    }


}
