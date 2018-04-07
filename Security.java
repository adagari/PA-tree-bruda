/*Wes Eaton
Meagan Folmar
Adam Garibay*/

public abstract class Security implements CostBasis //abstract class Security implements CostBasis
{
  private String custNumber; //unique ID for customer
  private int purchDt; //purchase date of Security
  private double purchPrc; //purchase price in dollars
  private double shares; //number of shares purchased
  private String symbol; //market symbol of Security

  public Security(String nbr, int date, double price, double qty, String sym) throws SecurityException
  {
    /*Assign variables*/
    
    this.custNumber = nbr;  
    this.purchDt = date;    
    this.purchPrc = price;  
    this.shares = qty;      
    this.symbol = sym.toUpperCase();      

    /*throw exception if customer number is not 7 digits long and is less than 10000*/

    if(!custNumber.matches("\\d{7}") || Integer.parseInt(custNumber) < 10000)
    {
      throw new SecurityException("Customer number must be 7 digits long and greater than 0010000." + offeredValues());

    }//end if statement

    String convertDate = String.valueOf(purchDt);
    
    /*throw exception if purchase date is not 7 digits long*/

    if(convertDate.length() != 7)
    {
      throw new SecurityException("Purchase date must be entered in the format YYYYDDD" + offeredValues());
      
    }//end if statement

    String year = convertDate.substring(0,4);
    String day = convertDate.substring(4,7);     

    /*throw exception if purchase year is earlier than 1900 or greater than 9999 or if purchase day is not
     * between 001 and 365*/

    if(Integer.parseInt(year) < 1901 || Integer.parseInt(year) > 9999 || 
       Integer.parseInt(day) < 001 || Integer.parseInt(day) > 365)
    {
      throw new SecurityException("Purchase year must be > 1900; Purchase day must be 001 to 365, inclusive." + offeredValues()); 

    }//end if statement

  }//end constructor

  /*overshadowing instance variable custNumber by local variable*/

  public final void setCustNumber(String custNumber)
  {
    this.custNumber = custNumber;

  }//end public final void setCustNumber 

  /*overshadowing instance variable purchDt by local variable*/

  public final void setPurchDT(int purchDt)
  {
    this.purchDt = purchDt;

  }//end public final void setPurchDt

  /*overshadowing instance variable purchPrc by local variable*/

  public final void setPurchPrc(double purchPrc) 
  {
    this.purchPrc = purchPrc;

  }//end public final void setPurchPrc


  /*overshadowing instance variable shares by local variable*/

  public final void setShares(double shares) 
  {
    this.shares = shares;

  }//end public final void setShares

  /*overshadowing instance variable symbol by local variable*/  

  public final void setSymbol(String symbol) 
  {
    this.symbol = symbol;

  }//end public final void setSymbol

  /*returning value of custNumber*/

  public final String getCustNumber() 
  {
    return custNumber;

  }//end public final String getCustNumber

  /*returning value of purchDt*/

  public final int getPurchDt() 
  {
    return purchDt;

  }//end public final int getPurchDt

  /*returning value of purchPrc*/

  public final double getPurchPrc() 
  {
    return purchPrc;

  }//end public final double getPurchPrc

  /*returning value of shares*/

  public final double getShares() 
  {
    return shares;

  }//end public final double getShares

  /*returning value of symbol*/

  public final String getSymbol() 
  {
    return symbol;

  }//end public final String getSymbol

  /*returning customer info*/

  public String offeredValues()
  { 
    return String.format("%nOffered values:%n  Customer number: %s%n"
                           + "  Purchase date: %d%n  Share price: %f"
                           + "%n  Number shares: %f%n  Symbol: %s%n", getCustNumber(), getPurchDt(), getPurchPrc(),
                         getShares(), getSymbol());

  }//end public String offeredValues

  /*returns StringBuilder objInfo*/

  public String toString() 
  { 
    StringBuilder objInfo = new StringBuilder(String.format("The Security belongs to Customer#  %s;", getCustNumber()));

    objInfo.append(String.format(" %.3f shares of %s were%n", getShares(), getSymbol()));
    objInfo.append(String.format("purchased on %d for $%.2f per share.%n", getPurchDt(), getPurchPrc()));

    return objInfo.toString();

  }//end public String toString

}//end public abstract class Security implements CostBasis
