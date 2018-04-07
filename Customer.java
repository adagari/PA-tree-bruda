/*Wesley Eaton
Meagan Folmar
Adam Garibay*/

public class Customer
{
  private String custNumber; //unique customer ID
  private String tin; //tax reporting number
  private String last; //last name
  private String first; //first name
  private int margin; //margin limit for trading
  private boolean drip; //instructions on dividend reinvestment
  private boolean futures; //authorization for future contracts trading

  public Customer(String nbr, String id) throws CustomerException
  {
    this.custNumber = nbr;
    this.tin = id;

  }//end constructor

  public Customer(String nbr, String id, String lName, String fName, int lim, 
                  boolean reUp, boolean fAuth) throws CustomerException
  {
    /*Assigning variables*/

    this.custNumber = nbr;
    this.tin = id;
    this.last = lName;
    this.first = fName;
    this.margin = lim;
    this.drip = reUp;
    this.futures = fAuth;

    /*throwing exception if customer number isn't 7 digits and is less than 10000*/

    if(!custNumber.matches("\\d{7}") || Integer.parseInt(custNumber) < 10000) 
    {
      throw new CustomerException("Customer number must be 7 digits in length and greater than 10000." + toString());

    }//end if statement

    /*throw exception if tax ID is not 9 digits long*/

    if(!tin.matches("\\d{9}"))
    {
      throw new CustomerException("Tax Identifier must be 9 digits in length." + toString()); 

    }//end if statement

    /*throw exception if last name is invalid*/    

    if(!last.matches("[a-zA-z]+(['-][a-zA-z]+)*"))
    {
      throw new CustomerException("Last name must not be null or blank." + toString());

    }//end if statement

    /*throw exception if first name is invalid*/    

    if(!first.matches("[A-Z][a-zA-Z]*"))
    {
      throw new CustomerException("First name must not be null or blank." + toString());
      
    }//end if statement

    /*throw exception if margin is less than 0*/
    
    if(margin < 0)
    {
      throw new CustomerException("The margin value must be zero or greater." + toString()); 
      
    }//end if statement

  }//end constructor

    /*overshadowing instance variable custNumber by local variable*/

    public final void setCustNumber(String custNumber)
    {
      this.custNumber = custNumber;

    }//end public final void setCustNumber(String custNumber)

    /*overshadowing instance variable tin by local variable*/

    public final void setTin(String tin)
    {
      this.tin = tin;

    }//end public final void setTin

    /*overshadowing instance variable last by local variable*/

    public final void setLast(String last)
    {
      this.last = last;

    }//end public final void setLast

    /*overshadowing instance variable first by local variable*/

    public final void setFirst(String first)
    {
      this.first = first;

    }//end public final void setFirst   

    /*overshadowing instance variable margin by local variable*/

    public final void setMargin(int margin)
    {
      this.margin = margin;

    }//end public final void setMargin

    /*overshadowing instance variable drip by local variable*/

    public final void setDrip(boolean drip)
    {
      this.drip = drip;

    }//end public final void setDrip

    /*overshadowing instance variable futures by local variable*/

    public final void setFutures(boolean futures)
    {
      this.futures = futures;

    }//end public final void setFutures
    
    /*returning value of custNumber*/

    public final String getCustNumber()
    {
      return custNumber;

    }//end public final String getCustNumber

    /*returning value of tin*/

    public final String getTin()
    {
      return tin;
      
    }//end public final String getTin

    /*returning value of last*/

    public final String getLast()
    {
      return last;

    }//end public final String getLast

    /*returning value of first*/

    public final String getFirst()
    {
      return first;

    }//end public final String getFirst

    /*returning value of margin*/

    public final int getMargin()
    {
      return margin;

    }//end public final int getMargin

    /*returning value of drip*/

    public final boolean getDrip()
    {
      return drip;

    }//end public final boolean getDrip

    /*returning value of futures*/

    public final boolean getFutures()
    {
      return futures;

    }//end public final boolean getFutures 

    /*returning object info using append and StringBuilder*/

    public String describeCustomer()
    {
      StringBuilder objInfo = new StringBuilder(String.format("Customer %s, %s %s.%n  The account carries" 
                                                               + "a margin limit of $%d.00.", getCustNumber(), 
                                                              getFirst(), getLast(), getMargin()));

      /*series of if/else statements using append determining if customer can reinvest dividends or 
       * trading in future contracts*/

      if(getDrip() == true)
      {
        objInfo.append("\n  The account will reinvest dividends as recieved.");

      }//end if statement

      else
      {
        objInfo.append("\n  The account will not reinvest dividends as recieved.");

      }//end else statement

      if(getFutures() == true)
      {
        objInfo.append("\n  The account is authorized to trade in futures contracts.\n");

      }//end if statement
      
      else
      {
        objInfo.append("\n  The account is not authorized to trade in futures contracts.\n");

      }//end else statement                                                        

      return objInfo.toString(); //returning object info

    }//end public String describeCustomer

    /*returning String object that prints out information about customer*/

    public String toString()
    {
      return String.format("%nOffered values:%n  Customer number: %s %n  Tax Id: %s%n"
                             + "  Last Name: %s%n  First Name: %s%n  Margin: %d%n  DRIP:"
                             + "%b%n  Futures: %b%n", getCustNumber(), getTin(), getLast(),
                               getFirst(), getMargin(), getDrip(), getFutures());

    }//end public String toString
  
  }//end public class Customer
