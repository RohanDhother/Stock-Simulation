import java.util.ArrayList;
import java.io.*;
public final class Accounts extends Main
{
    private String username;
    private String password;
    public Accounts(String Username, String Password) //This creates a user
    {
        username = Username;
        password = Password;
    }
    public void InitialiseUsers() //This Initialises users from the file Users.txt
    {
        try{
                BufferedReader pr = new BufferedReader(new FileReader("Users.txt"));
                int lines = 0;
                String line;
                String[] temp;
                String delimiter = ";";
                while ((line = pr.readLine()) != null)
                {
                    lines++;
                    if (lines>1)
                    {
                        String str = line.toString();
                        temp = str.split(delimiter);
                        a = new Accounts(String.valueOf(temp[0]), String.valueOf(temp[1]));
                        UsersList.add(a);
                    }
                }
                pr.close();
            }
            catch(IOException e){}
    }
    public void UpdateUsers() //This Update users to the file Users.txt
    {
        try{
                File file = new File("Users.txt");
            PrintWriter writer = new PrintWriter(file);
            writer.print("");
            writer.close();
                FileWriter fr = new FileWriter(file, true);
                BufferedWriter br = new BufferedWriter(fr);
            br.write("Username;Password;");
            for (int i = 0; i<UsersList.size(); i++)
            {
                br.write("\n" +a.getUsername(UsersList.get(i)) + ";" + a.getPassword(UsersList.get(i)) + ";");
            }
            br.close();
            fr.close();
        }
        catch(IOException e){}
    }
    public int isUsername(String ans) //This checks if the username is in the files
    {
        boolean found = false;
        int i = 0;
        int place = -1;
        while(i<UsersList.size() && found==false)
        {
            if(ans.equals(a.getUsername(UsersList.get(i))))
            {
                found = true;
                place = i;
            }
            else
            {
                i++;
            }
        }
        return place;
    }
    public boolean isPassword(String ans, int place) //This checks if the password is correct
    {
        boolean found = false;
        if(ans.equals(a.getPassword(UsersList.get(place))))
        {
            found = true;
        }
        return found;
    }
    public void setAccounts(String Username, String Password) //This sets a new Account up
    {
        Accounts a = new Accounts(Username, Password);
        UsersList.add(a);
    }
    public String getUsername(Main acc) //This gets the username
    {
        return username;
    }
    public String getPassword(Main acc) //This gets the password
    {
        return password;
    }
}