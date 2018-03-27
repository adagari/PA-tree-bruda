public class Customer{

  private String custNumber;
  private String tin;
  private String last;
  private String first;
  private int margin;
  private boolean drip;
  private boolean futures;
  
  public Customer(String nbr, String id){
    this.custNumber = nbr;
    this.tin = id;
  }
  
  public Customer(String nbr, String id, String lName, String fName,
                  int lim, boolean reUp, boolean fAuth){
    this.custNumber = nbr;
    this.tin = id;
    this.last = lName;
    this.first = fName;
    this.margin = lim;
    this.drip = reUp;
    this.futures = fAuth;
  }
  
  public void setCustNumber(String custNumber){
    this.custNumber = custNumber;
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
  
  public String describeCustomer(){
  }
  
  public String toString(){
  }
}
