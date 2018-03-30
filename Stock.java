public class Stock extends Security //subclass of Security class
{
  private String exchange;    //exchange stock is traded
  private boolean dividends;  //indicating if stock pays divids. T = dividends paid. F = no dividends.
  private int divDate;        //indicating if dividends are paid by quarter.
  private double divAmount;   //dollar value of dividends/share.

  public Stock(String nbr, int date, double prc, double qty, String sym, String xchg, boolean div, 
               int divDt,double amt) throws SecurityException
  {
    super(nbr, date, prc, qty, sym); // superclass constructor

    this.exchange = xchg;            // set field exchange
    this.dividends = dividends;      // set field dividends
    this.divDate = divDt;            // set field divDate
    this.divAmount = amt;            // set field divAmount

    if(divDate < 0 || divDate > 4)
    {
      throw new SecurityException("Allowed divident payment dates are 0-4." + offeredValues());
    
    }//end if statement
    
    if(dividends == false && divAmount != 0)
    {
      throw new SecurityException("Invalid input for dividen amount.");
    
    }//end if statement

    if(divDate < 0 || divDate > 4 && divAmount != 0)
    {
      throw new SecurityException("Invalid input for dividen amount.");

    }//end if statement
    
  }//end constructor

  public void setExchange(String exchange) 
  {
    this.exchange = exchange; //instance variable exchange overshadowed by local variable

  }//end public void setExchange

  public void setDividends(boolean dividends) 
  {
    this.dividends = dividends; //instance variable dividends overshadowewd by local variable

  }//end public void setDividends

  public void setDivDate(int divDate) 
  {
    this.divDate = divDate; //overshadow instance variable divDate by local variable

  }//end public void setDivDate

  public void setDivAmount(double divAmount) 
  {
    this.divAmount = divAmount; //overshadow instance variable divAmount by local variable

  }//end public void setDivAmount

  public String getExchange() 
  {
    return exchange; //returning the value of exchange

  }//end public String getExchange

  public boolean getDividends() 
  {
    return dividends; //returning the value of dividends 

  }//end public boolean getDividends

  public int getDivDate() 
  {
    return divDate; //returning the value of divDate

  }//end public int getDivDate

  public double getDivAmount() 
  {
    return divAmount; //returning the value of divAmount

  }//end public double getDivAmount

  public String toString() 
  {
    /*create StringBuilder object objInfo*/

    StringBuilder objInfo = new StringBuilder(String.format("The Stock belongs to Customer# %s;", getCustNumber()));

    objInfo.append(String.format(" %.3f shares of %s were%n", getShares(), getSymbol()));
    objInfo.append(String.format("purchased on %d for $%.2f per share.%n", getPurchDt(), getPurchPrc()));
    objInfo.append(String.format("This stock is traded on the %s exchange.%n", getExchange()));

    /*if else to append getDividens information*/

    if(getDividends() == true) 
    {
      objInfo.append(String.format("\tA dividend of $%.2f will be paid in the %d quarter.%n", 
                                   getDivAmount(), getDivDate()));

    }//end if statement 
    
    else 
    {
      objInfo.append("   This stock does not pay dividends.\n");

    }//end else statement    
    
    /*toString returns StringBuilder objInfo*/

    return objInfo.toString();

  }//end public String toString

  public double calcCost() 
  {
    return (getShares() * (getPurchPrc() - getDivAmount())); //calcCost returns calculated cost

  }//end public double calcCost

}//end public class Stock extends Security
