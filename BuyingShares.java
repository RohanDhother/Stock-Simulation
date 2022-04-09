import java.util.Timer;
import java.awt.event.*; 
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.time.*;
import java.util.Timer;
import java.util.TimerTask;
public class BuyingShares extends Shares
{
    private JFrame f;
    private JPanel content;
    private JPanel header;
    private JPanel col;
    private JPanel row;
    private JLabel name;
    private JLabel value;
    private JLabel units;
    private int i = 0;
    private JLabel Response;
    private String Username;
    /**
     * Constructor for objects of class Portfolio
     */
    public BuyingShares(String username) //This creates the window
    {
        Username = username;
        f = new JFrame("BuyingShares");
        f.setLayout(new BorderLayout());
        JLabel title = new JLabel("BuyingShares");
        f.add(title, "North");
        f.setLocation(Width/2+300,Height/2-300);
        f.setResizable(false);
        f.setVisible(true);
        setShares();
        f.add(content, "Center");
        Response = new JLabel("");
        f.add(Response, "South");
        f.pack();
        TimerControl(Username);
    }
    public void show_BuyingShares() //This shows the window
    {
        f.setVisible(true);
    }
    public void hide_BuyingShares() //This hides the window
    {
        f.setVisible(false);
    }
    public void setShares() //This updates the window
    {
        content = new JPanel();
        content.setLayout(new GridLayout(2,1,0,1));
        header = new JPanel();
        header.setLayout(new GridLayout(1,6,1,0));
        JLabel name_header = new JLabel("Name");
        JLabel value_header = new JLabel("Value");
        JLabel units_header = new JLabel("Units");
        JLabel buy_header = new JLabel("Buy Share");
        JLabel amounts_header = new JLabel("Amount");
        JLabel id_header = new JLabel("Id");
        id_header.setVisible(false);
        header.add(name_header);
        header.add(value_header);
        header.add(units_header);
        header.add(buy_header);
        header.add(amounts_header);
        header.add(id_header);
        content.add(header);
        col = new JPanel();
        col.setLayout(new GridLayout(SharesList.size(),1,0,1));
        i = 0;
        while(i<SharesList.size())
        {
            row = new JPanel();
            row.setLayout(new GridLayout(1,5,1,0));
            JLabel id = new JLabel(String.valueOf(i));
            id.setVisible(false);
            name = new JLabel(getName(SharesList.get(i)));
            value = new JLabel(String.valueOf(getValue(SharesList.get(i))));
            units = new JLabel(String.valueOf(getUnits(SharesList.get(i))));
            JButton buy = new JButton("Buy");
            JTextField amounts = new JTextField("",1);
            buy.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                   if(isStringInt(amounts.getText()))
                   {
                       if(Integer.parseInt(amounts.getText())>getUnits(SharesList.get(Integer.parseInt(id.getText()))) || Integer.parseInt(amounts.getText())<=0)
                       {
                           Response.setText("Not valid amount of stock");
                       }
                       else
                       {
                           BuyShares(getName(SharesList.get(Integer.parseInt(id.getText()))), SharesList.get(Integer.parseInt(id.getText())), getValue(SharesList.get(Integer.parseInt(id.getText()))), Integer.parseInt(amounts.getText()));
                           UpdateBuyShares();
                           Portfolio pp = (Portfolio)p;
                           pp.UpdatePortfolio();
                        }
                    }
                    else
                    {
                        Response.setText("Not valid amount of stock");
                    }
                }
            });
            row.add(name);
            row.add(value);
            row.add(units);
            row.add(buy);
            row.add(amounts);
            row.add(id);
            col.add(row);
            i++;
        }
        content.add(col);
    }
    public void UpdateBuyShares() //This resets the window
    {
         content.setVisible(false);
         setShares();
         f.add(content, "Center");
         Response = new JLabel("");
         f.add(Response, "South");
         f.pack();
    }
    public boolean isStringInt(String s) //This checks if the user has entered a number
    {
    try
    {
        Integer.parseInt(s);
        return true;
    } catch (NumberFormatException ex)
    {
        return false;
    }
    }
}