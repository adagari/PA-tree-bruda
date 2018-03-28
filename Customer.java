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
  
  public void setCustNumber(String custNumber){
    if(custNumber.matches("[0-9][0-9][1-9]\\d{3}[1-9]")){
      this.custNumber = custNumber;
    }else{
      throw new CustomerException("Customer number must be 7 digits in length and greater than 10000.");
    }
  }
  
  public void setTin(String tin){
  this.tin = tin;
  }
  
  public void setLast(String last){
    this.last = last;
  }
  
  public void setFirst(String first){
    this.first = first;
  }
  
  public void setMargin(int margin){
    this.margin = margin;
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
  }
  
  public String toString(){
  }
}
