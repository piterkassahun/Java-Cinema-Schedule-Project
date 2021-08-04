import javax.swing.*;
import java.sql.Time;
import java.util.Timer;

public class Films_db_reteriver {
    public static String title;
    public static String date;
    public static String type;
    public static String time;
    public static String price;
    public static String cinema;
    public static ImageIcon imageIcon;
    public static String description;

    public Films_db_reteriver(){
    }

    public Films_db_reteriver(String Title, String Date, String Type,String Time, String Price,String Description,String Cinema,ImageIcon Image){
        this.title=Title;
        this.date=Date;
        this.type=Type;
        this.time=Time;
        this.price=Price;
        this.description=Description;
        this.cinema=Cinema;
        this.imageIcon=Image;
    }

    public static String getTitle() {
        return title;
    }

    public static String getCinema() {
        return cinema;
    }

    public static void setCinema(String cinema) {
        Films_db_reteriver.cinema = cinema;
    }

    public static ImageIcon getImageIcon() {
        return imageIcon;
    }

    public static void setImageIcon(ImageIcon imageIcon) {
        Films_db_reteriver.imageIcon = imageIcon;
    }

    public static void setTitle(String title) {
        Films_db_reteriver.title = title;
    }

    public static String getDate() {
        return date;
    }

    public static void setDate(String date) {
        Films_db_reteriver.date = date;
    }

    public static String getType() {
        return type;
    }

    public static void setType(String type) {
        Films_db_reteriver.type = type;
    }

    public static String getTime() {
        return time;
    }

    public static void setTime(String time) {
        Films_db_reteriver.time = time;
    }

    public static String getPrice() {
        return price;
    }

    public static void setPrice(String price) {
        Films_db_reteriver.price = price;
    }

    public static String getDescription() {
        return description;
    }

    public static void setDescription(String description) {
        Films_db_reteriver.description = description;
    }
}
