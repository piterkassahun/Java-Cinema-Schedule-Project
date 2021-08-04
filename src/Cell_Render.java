import javax.swing.*;
import java.awt.*;

public class Cell_Render implements ListCellRenderer<Item> {

    @Override
    public Component getListCellRendererComponent(JList<? extends Item> list, Item value, int index, boolean isSelected, boolean cellHasFocus) {

        JPanel panel=new JPanel(new FlowLayout(FlowLayout.LEFT,5,5));


        JLabel lblIcon=new JLabel();
        lblIcon.setIcon(value.getImageIcon());
        panel.add(lblIcon,BorderLayout.WEST);


        JLabel lblText=new JLabel();
        lblText.setText(value.getText());
        lblText.setForeground(Color.WHITE);
        panel.add(lblText,BorderLayout.EAST);



        if(isSelected){
            panel.setBackground(list.getSelectionBackground());
            panel.setForeground(list.getSelectionForeground());
        }
        else{
            panel.setBackground(list.getBackground());
            panel.setForeground(list.getForeground());
        }
        panel.setOpaque(isSelected);
        panel.setEnabled(true);
        panel.setFont(list.getFont());
        return panel;
    }
}
