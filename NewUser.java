import java.awt.event.*; 
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
public class NewUser extends Main
{
    private JFrame f;
    private JTextField Username;
    private JTextField Password;
    private JButton Submit;
    private JLabel Response;
    public NewUser() //This creates the window
    {
        f = new JFrame("NewUser");
        f.setLayout(new BorderLayout());
        JLabel title = new JLabel("NewUser");
        f.add(title, "North");
        JPanel Labels = new JPanel();
        Labels.setLayout(new GridLayout(2,1));
        f.add(Labels,"West");
        JLabel Username_Label = new JLabel("Username:");
        JLabel Password_Label = new JLabel("Password:");
        Labels.add(Username_Label);
        Labels.add(Password_Label);
        JPanel content = new JPanel();
        content.setLayout(new GridLayout(2,1));
        Username = new JTextField("",15);
        content.add(Username);
        Password = new JTextField("",15);
        content.add(Password);
        f.add(content,"Center");
        f.setResizable(false);
        JPanel Submit_content = new JPanel();
        Submit_content.setLayout(new GridLayout(2,1));
        Submit = new JButton("Submit");
        Response = new JLabel();
        Submit_content.add(Submit);
        Submit_content.add(Response);
        f.add(Submit_content, "South");
        f.setLocation(Width/2-500,Height/2-400);
        f.pack();
        f.setVisible(true);
        Submit.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                String username = Username.getText();
                String password = Password.getText();
                boolean found=false;
                int i = 0;
                int place = isUsername(username);
                if(username.trim().length() > 0 || password.trim().length() > 0)
                {
                    if(place>-1)
                    {
                        Response.setText("Username is taken");
                    }
                    else
                    {
                        a = new Accounts(username, password);
                        UsersList.add(a);
                        hide();
                        L = new Login();
                        Login LL = (Login)L;
                        LL.show();
                    }
                }
                else
                {
                    Response.setText("Please fill in all forms");
                }
            }   
        });
    }
    public void show() //This shows the window
    {
        f.setVisible(true);
    }
    public void hide() //This hides the window
    {
        f.setVisible(false);
    }
}
