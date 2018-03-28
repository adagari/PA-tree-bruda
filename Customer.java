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
    setCustNumber(nbr);
    setTin(id);
    setLast(lName);
    setFirst(fName);
    setMargin(lim);
    setDrip(reUp);
    setFutures(fAuth);
  }
  
  public void setCustNumber(String custNumber) throws CustomerException{
    if(custNumber.matches("[0-9][0-9][1-9]\\d{3}[1-9]")){
      this.custNumber = custNumber;
    }else{
      throw new CustomerException("Customer number must be 7 digits in length and greater than 10000." + toString());
    }
  }
  
  public void setTin(String tin) throws CustomerException{
    if(tin.matches("\\d{9}")){
      this.tin = tin;
    }else{
      throw new CustomerException("Tax Identifier must be 9 digits in length." + toString());
    }
  }
  
  public void setLast(String last) throws CustomerException{
    if(last.matches("[a-zA-z]+(['-][a-zA-z]+)*")){
      this.last = last;
    }else{
      throw new CustomerException("Last name must not be null or blank." + toString());
    }
  }
  
  public void setFirst(String first) throws CustomerException{
    if(first.matches("[A-Z][a-zA-Z]*")){
      this.first = first;
    }else{
      throw new CustomerException("First name must not be null or blank." + toString());
    }
  }
  
  public void setMargin(int margin) throws CustomerException{
    if(margin >= 0){
      this.margin = margin;
    }else{
      throw new CustomerException("The margin value must be zero or greater.");
    }
  }
  
  public void setDrip(boolean drip){
    this.drip = drip;
  }
  
  public void setFutures(boolean futures){
    this.futures = futures;
  }
  
  public String getCustNumber(){
    return custNumber;
  }
  
  public String getTin(){
    return tin;
  }
  
  public String getLast(){
    return last;
  }
  
  public String getFirst(){
    return first;
  }
  
  public int getMargin(){
    return margin;
  }
  
  public boolean getDrip(){
    return drip;
  }
  
  public boolean getFutures(){
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
      objInfo.append("\n  The account is authorized to trade in futures contracts.");
    }else{
      objInfo.append("\n  The account is not authorized to trade in futures contracts.");
    }                                                        
    return objInfo.toString();
  }
  
  public String toString(){
    return String.format("%nOffered values:%n  Customer number: %s %n  Tax Id: %s%n"
                           + "  Last Name: %s%n  First Name: %s%n  Margin: %d%n  DRIP:"
                           + "%b%n  Futures: %b", getCustNumber(), getTin(), getLast()
                           , getFirst(), getMargin(), getDrip(), getFutures());
  }
}
