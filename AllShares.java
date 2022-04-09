import java.util.ArrayList;
public final class AllShares extends Shares
{
    private String name;
    private double value;
    private int units;

    public AllShares(String Name, double Value, int Units) //This creates shares
    {
        name = Name;
        value = Value;
        units = Units;
    }
    public double getValue(Shares s) //This gets the value
    {
        return value;
    }
    public String getName(Shares s) //This gets the name
    {
        return name;
    }
    public int getUnits(Shares s) //This gets the units
    {
        return units;
    }
    public void AddUnits(Shares s, int Units) //This changes the units
    {
        units = units + Units;
    }
    public void RemoveUnits(Shares s, int Units) //This changes the units
    {
        units = units - Units;
    }
    public void SetValue(Shares s, double amount) //This changes the values
    {
        double newValue = Math.round(value*amount);
        if(newValue==0)
        {
            value=2;
        }
        else
        {
            value = newValue;
        }
    }
}
