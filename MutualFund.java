
public class MutualFund extends Security //subclass of security 
{
  private String type;    //identify general MutualFund type 
  private double admin;   //administrative fee cap
  private char rptPeriod; //reporting period: A = annual, Q = quarterly, M = monthly
  private boolean mgmt;   //bond is either managed actively or passively

  public MutualFund(String nbr, int date, double price, double qty, String sym,
                    String sort, double cost, char rpt, boolean style) throws SecurityException
  {
    super(nbr, date, price, qty, sym);  // superclass constructor to pass on values for nbr, date, price, qty, and sym

    this.type = sort;      // set value for type
    this.admin = cost;     // set value for admin
    this.rptPeriod = rpt;  // set value for rptPeriod
    this.mgmt = style;     // set value for mgmt

    /*throwing SecurityException if customer number is not seven digits in length and is less than 10000*/

    if(!getCustNumber().matches("\\d{7}") || Integer.parseInt(getCustNumber()) < 10000)
    {
      throw new SecurityException("Customer number must be 7 digits in length and greater than 10000" + offeredValues());

    }//end if statement

    /*throwing SecurityException if reporting period is not A, Q, or M*/ 

    if(Character.toUpperCase(rptPeriod) != 'A' && Character.toUpperCase(rptPeriod) != 'Q' && 
       Character.toUpperCase(rptPeriod) != 'M')
    {
      throw new SecurityException("The reporting period must be A, Q, or M." + offeredValues() + additionalInfo());

    }//end if statement

  }//end construcotr

  public void setType(String type) 
  {
    this.type = type; //overshadowing instance variable type by local variable

  }//end public void setType

  public void setAdmin(double admin) 
  {
    this.admin = admin; //overshadowing instance variable admin by local variable

  }//end public void setAdmin

  public void setRptPeriod(char rptPeriod) 
  {
    this.rptPeriod = rptPeriod; //overshadowing instance variable rptPeriod by local variable

  }//end public void setRptPeriod

  public void setMgmt(boolean mgmt) 
  {
    this.mgmt = mgmt; //overshadowing instance variable mgmt by local variable

  }//end public void setMgmt

  public String getType() 
  {
    return type; //returning value of type

  }//end public String getType

  public double getAdmin() 
  {
    return admin; //returning the value of admin

  }//end public double getAdmin

  public char getRptPeriod() 
  {
    return rptPeriod; //returning the value of rptPeriod

  }//end public char getRptPeriod

  public boolean getMgmt() 
  {
    return mgmt; //returning the value of mgmt

  }//end public boolean getMgmt  

  public String additionalInfo()
  {
    return String.format("  Type: %s%n  Admin cost: %f%n  Reporting Period: %c%n  Managment: %b%n",
                         getType(), getAdmin(), getRptPeriod(), getMgmt());

  }//end public String additionalInfo

  public String toString() 
  {
    /*create StringBuilder object objInfo*/

    StringBuilder objInfo = new StringBuilder(String.format("The MutualFund belongs to Customer# %s;", getCustNumber()));

    objInfo.append(String.format(" %.3f shares of %s were%n", getShares(), getSymbol()));
    objInfo.append(String.format("purchased on %d for $%.2f per share.%n", getPurchDt(), getPurchPrc()));
    objInfo.append(String.format("This is a %s fund.%n", getType()));
    objInfo.append(String.format("  Admin cost are capped at %.6f.%n", getAdmin()));

    /*if else to append the reporting period*/

    if(Character.toUpperCase(getRptPeriod()) == 'A') 
    {
      objInfo.append("  Reporting cycle is Annual.\n");

    }//end if statement 

    else if(Character.toUpperCase(getRptPeriod()) == 'Q') 
    {
      objInfo.append("  Reporting cycle is Quarterly.\n");

    }//end else if statement 
    
    else if(Character.toUpperCase(getRptPeriod()) == 'M') 
    {
      objInfo.append("  Reporting cycle is Monthly.\n");

    }//end else if statement

    /*if else to append fund management*/

    if(getMgmt() == true) 
    {
      objInfo.append("  The fund is managed actively.\n");

    }//end if statement

    else if(getMgmt() == false) 
    {
      objInfo.append("  The fund is managed passively.\n");

    }//end else if statement

    return objInfo.toString(); //toString returns StringBuilder objInfo

  }//end public String toString

  public double calcCost()
  {
    return (getShares() * getPurchPrc()) * (1 + getAdmin()); //calcCost returns calculated cost

  }//end public double calcCost

}//end public class MutualFund extends Security
