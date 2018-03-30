public class Customer{
  
  private String custNumber;
  private String tin;
  private String last;
  private String first;
  private int margin;
  private boolean drip;
  private boolean futures;
  
  public Customer(String nbr, String id) throws CustomerException{
    setCustNumber(nbr);
    setTin(id);
  }
  
  public Customer(String nbr, String id, String lName, String fName,
                  int lim, boolean reUp, boolean fAuth) throws CustomerException{
    this.custNumber = nbr;
    this.tin = id;
    this.last = lName;
    this.first = fName;
    this.margin = lim;
    this.drip = reUp;
    this.futures = fAuth;
    
    if(!custNumber.matches("\\d{7}") || Integer.parseInt(custNumber) < 10000)
      throw new CustomerException
      ("Customer number must be 7 digits in length and greater than 10000." + toString());
    
    if(!tin.matches("\\d{9}"))
      throw new CustomerException
      ("Tax Identifier must be 9 digits in length." + toString());
    
    if(!last.matches("[a-zA-z]+(['-][a-zA-z]+)*"))
      throw new CustomerException
      ("Last name must not be null or blank." + toString());
    
    if(!first.matches("[A-Z][a-zA-Z]*"))
      throw new CustomerException
      ("First name must not be null or blank." + toString());
    
    if(margin < 0)
      throw new CustomerException
      ("The margin value must be zero or greater." + toString()); 
    }
    
    public final void setCustNumber(String custNumber){
      this.custNumber = custNumber;
    }
    
    public final void setTin(String tin){
      this.tin = tin;
    }
    
    public final void setLast(String last){
      this.last = last;
    }
    
    public final void setFirst(String first){
      this.first = first;
    }
    
    public final void setMargin(int margin){
      this.margin = margin;
    }
    
    public final void setDrip(boolean drip){
      this.drip = drip;
    }
    
    public final void setFutures(boolean futures){
      this.futures = futures;
    }
    
    public final String getCustNumber(){
      return custNumber;
    }
    
    public final String getTin(){
      return tin;
    }
    
    public final String getLast(){
      return last;
    }
    
    public final String getFirst(){
      return first;
    }
    
    public final int getMargin(){
      return margin;
    }
    
    public final boolean getDrip(){
      return drip;
    }
    
    public final boolean getFutures(){
      return futures;
    } 
    
    public String describeCustomer(){
      StringBuilder objInfo = new StringBuilder(String.format("Customer %s, %s %s.%n  The account carries a margin limit of $%d.00.", 
                                                              getCustNumber(), getFirst(), getLast(), getMargin()));
      if(getDrip() == true){
        objInfo.append("\n  The account will reinvest dividens as recieved.");
      }else{
        objInfo.append("\n  The account will not reinvest dividens as recieved.");
      }
      
      if(getFutures() == true){
        objInfo.append("\n  The account is authorized to trade in futures contracts.\n");
      }else{
        objInfo.append("\n  The account is not authorized to trade in futures contracts.\n");
      }                                                        
      return objInfo.toString();
    }
    
    public String toString(){
      return String.format("%nOffered values:%n  Customer number: %s %n  Tax Id: %s%n"
                             + "  Last Name: %s%n  First Name: %s%n  Margin: %d%n  DRIP:"
                             + "%b%n  Futures: %b%n", getCustNumber(), getTin(), getLast()
                             , getFirst(), getMargin(), getDrip(), getFutures());
    }
  }
