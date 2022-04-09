import java.awt.event.*; 
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
public class Login extends Main
{
    private JFrame f;
    private JTextField Username;
    private JTextField Password;
    private JButton Submit;
    private JLabel Response;
    public Login() //This creates the window
    {
        f = new JFrame("Login");
        f.setLayout(new BorderLayout());
        JLabel title = new JLabel("Login");
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
        Submit_content.setLayout(new GridLayout(3,1));
        Submit = new JButton("Submit");
        Response = new JLabel();
        Submit_content.add(Submit);
        JButton NewUsers = new JButton("New User");
        Submit_content.add(NewUsers);
        Submit_content.add(Response);
        f.add(Submit_content, "South");
        f.setLocation(Width/2-500,Height/2-400);
        f.pack();
        NewUsers.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                hide();
                Main nW = new NewUser();
                NewUser nWw = (NewUser)nW;
                nWw.show();
            }
        });
        Submit.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                String username = Username.getText();
                String password = Password.getText();
                int place = admin.isUsername(username);
                boolean PasswordExist = false;
                if(place>-1)
                {
                    PasswordExist = admin.isPassword(password, place);
                }
                if(PasswordExist)
                {
                    Response.setText("Logined in");
                    m.InitialisemyShares(username);
                    m.InitialiseAllShares(username);
                    f.setVisible(false);
                }
                else
                {
                    Response.setText("Username or Password not correct");
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
