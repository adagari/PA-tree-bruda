// class MutualFund subclass of Security
public class MutualFund extends Security {
  
  private String type;    // private String
  private double admin;   // private double
  private char rptPeriod; // private char
  private boolean mgmt;   // private boolean
  
  // constructor nine parameters
  public MutualFund(String nbr, int date, double price, double qty, String sym,
                    String sort, double cost, char rpt, boolean style) throws SecurityException{
    super(nbr, date, price, qty, sym);  // superclass constructor
    this.type = sort;                   // set field type
    this.admin = cost;                  // set field admin
    this.rptPeriod = rpt;               // set field rptPeriod
    this.mgmt = style;                  // set field mgmt
    
    if(!getCustNumber().matches("\\d{7}") || Integer.parseInt(getCustNumber()) < 10000)
      throw new SecurityException("Customer number must be 7 digits in length and greater than 10000" + offeredValues());
    
    if(Character.toUpperCase(rptPeriod) != 'A' 
         && Character.toUpperCase(rptPeriod) != 'Q' 
         && Character.toUpperCase(rptPeriod) != 'M')
      throw new SecurityException("The reporting period must be A, Q, or M." + offeredValues());
  }
  
  // setType one String parameter
  public void setType(String type) {
    this.type = type;
  }
  
  // setAdmin one double parameter
  public void setAdmin(double admin) {
    this.admin = admin;
  }
  
  // setRptPeriod one char parameter
  public void setRptPeriod(char rptPeriod) {
    this.rptPeriod = rptPeriod;
  }
  
  // setMgmt one boolean parameter
  public void setMgmt(boolean mgmt) {
    this.mgmt = mgmt;
  }
  
  // getType returns type field
  public String getType() {
    return type;
  }
  
  // getAdmin returns admin field
  public double getAdmin() {
    return admin;
  }
  
  // getRptPeriod returns rptPeriod field
  public char getRptPeriod() {
    return rptPeriod;
  }
  
  // getMgmt returns mgmt field
  public boolean getMgmt() {
    return mgmt;
  }
  
  public String offeredValues(){
    return String.format("%nOffered Values:%n  Customer number: %s%n  Purchase Date: %d%n  Share price:  %f"
                           + "%n  Number shares:  %f%n  Symbol: %s%n", getCustNumber(), getPurchDt(), getPurchPrc()
                           , getShares(), getSymbol());
  }
  
  // toString returns StringBuilder objInfo
  public String toString() {
    
    // create StringBuilder object objInfo
    StringBuilder objInfo = new StringBuilder(String.format("The MutualFund belongs to Customer# %s;",
                                                            getCustNumber()));
    
    objInfo.append(String.format(" %.3f shares of %s were%n", getShares(), getSymbol()));
    objInfo.append(String.format("purchased on %d for $%.2f per share.%n", getPurchDt(), getPurchPrc()));
    objInfo.append(String.format("This is a %s fund.%n", getType()));
    objInfo.append(String.format("\tAdmin cost are capped at %.6f.%n", getAdmin()));
    
    // if else to append the reporting period
    if(Character.toUpperCase(getRptPeriod()) == 'A') {
      objInfo.append("\tReporting cycle is Annual.\n");
    } else if(Character.toUpperCase(getRptPeriod()) == 'Q') {
      objInfo.append("\tReporting cycle is Quarterly.\n");
    } else if(Character.toUpperCase(getRptPeriod()) == 'M') {
      objInfo.append("\tReporting cycle is Monthly.\n");
    }
    
    // if else to append fund management
    if(getMgmt() == true) {
      objInfo.append("\tThe fund is managed actively.\n");
    } else if(getMgmt() == false) {
      objInfo.append("\tThe fund is managed passively.\n");
    }
    return objInfo.toString();
  }
  
  // calcCost returns calculated cost
  public double calcCost() {
    return (getShares() * getPurchPrc()) * (1 + getAdmin());
  }
}
