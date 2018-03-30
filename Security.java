// abstract class Security implements CostBasis
public abstract class Security implements CostBasis {
  
  private String custNumber;  // private String
  private int purchDt;        // private int
  private double purchPrc;    // private double
  private double shares;      // private double
  private String symbol;      // private String
  
  // constructor five parameters
  public Security(String nbr, int date, double price,
                  double qty, String sym) throws SecurityException{
    this.custNumber = nbr;  // set field custNumber
    this.purchDt = date;    // set field purchDt
    this.purchPrc = price;  // set field purchPrc
    this.shares = qty;      // set field shares
    this.symbol = sym.toUpperCase();      // set field
    
    if(!custNumber.matches("\\d{7}") && Integer.parseInt(custNumber) > 10000)
      throw new SecurityException("Customer number must be 7 digits in length and greater than 10000" + offeredValues());
    
    String convertDate = String.valueOf(purchDt);
    if(convertDate.length() != 7)
      throw new SecurityException("Purchase date must be entered in the format YYYYDDD" + offeredValues());
    String year = convertDate.substring(0,4);
    String day = convertDate.substring(4,7);     
    if(Integer.parseInt(year) < 1901 || Integer.parseInt(year) > 9999 ||
       Integer.parseInt(day) < 001 || Integer.parseInt(day) > 365)
      throw new SecurityException("Purchase year must be > 1900; Purchase day must be 001 to 365, inclusive." + offeredValues()); 
  }
  
  // setCustNumber one String parameter
  public final void setCustNumber(String custNumber){
    this.custNumber = custNumber;
  }
  
  // setPurchDt one int parameter
  public final void setPurchDT(int purchDt){
    this.purchDt = purchDt;
  }
  
  // setPurchPrc one double parameter
  public final void setPurchPrc(double purchPrc) {
    this.purchPrc = purchPrc;
  }
  
  // setShares one double parameter
  public final void setShares(double shares) {
    this.shares = shares;
  }
  
  // setSymbol one String parameter
  public final void setSymbol(String symbol) {
    this.symbol = symbol;
  }
  
  // getCustNumber returns custNumber field
  public final String getCustNumber() {
    return custNumber;
  }
  
  // getPurchDt returns purchDt field
  public final int getPurchDt() {
    return purchDt;
  }
  
  // getPurchPrc returns purchPrc field
  public final double getPurchPrc() {
    return purchPrc;
  }
  
  // getShares returns shares field
  public final double getShares() {
    return shares;
  }
  
  // getSymbol returns symbol field
  public final String getSymbol() {
    return symbol;
  }
  
  public String offeredValues(){
    return String.format("%nOffered Values:%n  Customer number: %s%n  Purchase Date: %d%n  Share price:  %f"
                           + "%n  Number shares:  %f%n  Symbol: %s%n", getCustNumber(), getPurchDt(), getPurchPrc()
                           , getShares(), getSymbol());
  }
  
  // toString returns StringBuilder objInfo
  public String toString() {
    
    // create StringBuilder object objInfo
    StringBuilder objInfo = new StringBuilder(String.format("The Security belongs to Customer#  %s;",
                                                            getCustNumber()));
    
    objInfo.append(String.format(" %.3f shares of %s were%n", getShares(), getSymbol()));
    objInfo.append(String.format("purchased on %d for $%.2f per share.%n", getPurchDt(), getPurchPrc()));
    
    return objInfo.toString();
  }
}
