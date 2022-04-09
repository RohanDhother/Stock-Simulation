import java.util.ArrayList;
import java.awt.*;
import java.io.*;
//These are the modules being imported
public class Main
{
    protected static boolean Simulation=false;
    protected static Accounts a;
    protected static Main S;
    protected  static Main L;
    protected static Main admin = new Accounts("Admin", "password");
    protected static Shares m = new Shares();
    protected static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    final protected static int Width = (int)screenSize.getWidth();
    final protected static int Height = (int)screenSize.getHeight();
    final protected static ArrayList<Accounts> UsersList = new ArrayList<>();
    public Main()
    {
        
    }
    public int isUsername(String ans) //This checks if the username is in the files
    {
        int place = -1;
        return place;
    }
    public boolean isPassword(String ans, int place) //This checks if the password is correct
    {
        boolean found = false;
        return found;
    }
    public void InitialiseUsers()
    {
        
    }
    public void UpdateUsers()
    {
        
    }
    public static void main(String[] args) //This starts the program
    {
        admin.InitialiseUsers();
        S = new Start();
        L = new Login();
    }
}
