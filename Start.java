import java.awt.event.*; 
import javax.swing.*;
public class Start extends Main
{
    private static JButton b;
    private static JFrame f;
    public Start() //This creates the window
    {
        f = new JFrame("Stocks Simulation");
        f.setVisible(true);
        b=new JButton("Start");
        f.add(b);
        b.setVisible(true);
        f.pack();
        f.setLocation(Width/2-100,Height/2-100);
        f.setResizable(false);
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                if(Simulation==false)
                {
                    b.setText("Stop");
                    Simulation = true;
                    b.setVisible(true);
                    Login LL = (Login)L;
                    LL.show();
                }
                else
                {
                    b.setText("Start");
                    Simulation = false;
                    b.setVisible(true);
                    admin.UpdateUsers();
                    m.EndProgram();
                }
            }   
        });
    }
}
