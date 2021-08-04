import javax.swing.ImageIcon;


public class Item {
    private ImageIcon imageIcon;
    private String text;
    public Item() {

    }
    public Item(String text) {

        setText(text);

    }
    public Item(String text, ImageIcon imageIcon) {

        setText(text);
        setImageIcon(imageIcon);

    }
    public ImageIcon getImageIcon() {
        return imageIcon;
    }
    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    @Override
    public String toString() {
        return getText();
    }
}