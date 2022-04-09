import java.util.ArrayList;
import java.io.*;
import java.util.Timer;
import java.util.TimerTask;
public class Shares extends Main
{
    protected static String CurrentUsername = "";
    protected TimerTask task1;
    protected Timer timer;
    private String myState;
    final protected static ArrayList<Shares> mySharesList = new ArrayList<>();
    final protected static ArrayList<Shares> SharesList = new ArrayList<>(); 
    protected static Shares p;
    protected static Shares bS;
    public Shares()
    {

    }
    public void TimerControl(String Username) //This controls the interval between when the shares change
    {
        timer = new Timer();
        task1 = new TimerTask() {
            public void run() {
                for(int i = 0; i<SharesList.size();i++)
                    {
                        ChangeValue(SharesList.get(i));
                    }
                BuyingShares bSs = (BuyingShares)bS;
                bSs.UpdateBuyShares();
                Portfolio pp = (Portfolio)p;
                pp.UpdatePortfolio();
            }
        };
        timer.scheduleAtFixedRate(task1,3000,5000);
    }
    public void EndProgram() //This ends the program
    {
        if(CurrentUsername.equals(""))
        {
            System.exit(0);
        }
        else
        {
            UpdateAllShares();
            bS.UpdateMyShares(CurrentUsername);
            System.exit(0);
        }
    }
    public void ChangeValue(Shares s) //This changes the values
    {
        double change = Math.random();
        double amount = Math.random();
        if(change<0.6)
        {
            s.SetValue(s, amount);
        }
        else
        {
            amount = amount + 1;
            s.SetValue(s, amount);
        }
        int i = 0;
        boolean found = false;
        while(i<mySharesList.size() && found==false)
        {
            if(getName(mySharesList.get(i)).equals(getName(s)))
            {
                found = true;
                mySharesList.get(i).SetValue(mySharesList.get(i), amount);
            }
            i++;
        }
    }
    public void SetValue(Shares s, double amount) //This sets the shares
    {

    }
    public double getValue(Shares s)
    {
        return s.getValue(s);
    }
    public String getName(Shares s)
    {
        return s.getName(s);
    }
    public int getUnits(Shares s)
    {
        return s.getUnits(s);
    }
    public void setUnits(Shares s, int Units)
    {
        s.setUnits(s, Units);
    }
    public void BuyShares(String Name, Shares s, double Value, int Units) //This buys shares
    {
        AllShares sA = (AllShares)s;
        sA.RemoveUnits(s, Units);
        boolean found = false;
        int i = 0;
        while(i<mySharesList.size() && found==false)
        {
            if(Name.equals(getName(mySharesList.get(i))))
            {
                found = true;
                myShares sM = (myShares)mySharesList.get(i);
                sM.AddUnits(mySharesList.get(i), Units);
            }
            i++;
        }
        if(found==false)
        {
            setShare(Name, Value, Units);
        }
    }
    public void SellShares(String Name, Shares s, int Units) //This sells shares
    {
        myShares sM = (myShares)s;
        sM.RemoveUnits(s, Units);
        if(s.getUnits(s)==0)
        {
            RemoveMyShare(Name);
        }
        boolean found = false;
        int i = 0;
        while(i<SharesList.size() && found==false)
        {
            if(Name.equals(getName(SharesList.get(i))))
            {
                found = true;
                AllShares sA = (AllShares)SharesList.get(i);
                sA.AddUnits(SharesList.get(i), Units);
            }
            i++;
        }
    }
    public void RemoveMyShare(String Name) //This removes shares
    {
        boolean found = false;
        int i = 0;
        int place = 0;
        while(i<mySharesList.size() && found==false)
        {
            if(Name.equals(getName(mySharesList.get(i))))
            {
                found = true;
                place = i;
            }
            i++;
        }
        mySharesList.remove(place);
    }
    public void setShare(String Name, double Value, int Units) //this creates a new share
    {
        Shares s = new myShares(Name, Value, Units);
        mySharesList.add(s);
    }
    public static void InitialiseAllShares(String Username) //This Initialises AllShares
    {
        try{
                BufferedReader pr = new BufferedReader(new FileReader("AllShares.txt"));
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
                        Shares s = new AllShares(String.valueOf(temp[0]), Double.valueOf(temp[1]), Integer. parseInt(temp[2]));
                        SharesList.add(s);
                    }
                }
                pr.close();
                bS = new BuyingShares(Username);
            }
        catch(IOException e){}
    }
    public static void InitialisemyShares(String username) //This Initialises myShares
    {
        CurrentUsername = username;
        try{
                BufferedReader pr = new BufferedReader(new FileReader(username + ".txt"));
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
                        Shares s = new myShares(String.valueOf(temp[0]), Double.valueOf(temp[1]), Integer. parseInt(temp[2]));
                        mySharesList.add(s);
                    }
                }
                pr.close();
            }
            catch(IOException e)
            {
                try{
                        File file = new File(username + ".txt");
                    PrintWriter writer = new PrintWriter(file);
                    writer.print("");
                    writer.close();
                }
                catch(IOException ie){}
            }
            p = new Portfolio();
    }
    public void UpdateAllShares() //This updates AllShares
    {
        try{
                File file = new File("AllShares.txt");
            PrintWriter writer = new PrintWriter(file);
            writer.print("");
            writer.close();
                FileWriter fr = new FileWriter(file, true);
                BufferedWriter br = new BufferedWriter(fr);
            br.write("Name;Value;Units");
            for (int i = 0; i<SharesList.size(); i++)
            {
                br.write("\n" +getName(SharesList.get(i)) + ";" + getValue(SharesList.get(i)) + ";" + getUnits(SharesList.get(i)));
            }
            br.close();
            fr.close();
        }
        catch(IOException e){}
    }
    public void UpdateMyShares(String username) //This updates myShares
    {
        try{
                File file = new File(username+".txt");
            PrintWriter writer = new PrintWriter(file);
            writer.print("");
            writer.close();
                FileWriter fr = new FileWriter(file, true);
                BufferedWriter br = new BufferedWriter(fr);
            br.write("Name;Value;Units");
            for (int i = 0; i<mySharesList.size(); i++)
            {
                br.write("\n" +getName(mySharesList.get(i)) + ";" + getValue(mySharesList.get(i)) + ";" + getUnits(mySharesList.get(i)));
            }
            br.close();
            fr.close();
        }
        catch(IOException e){}
    }
}
