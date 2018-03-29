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
        setCustNumber(nbr);  // set field custNumber
        setPurchDT(date);    // set field purchDt
        setPurchPrc(price);  // set field purchPrc
        setShares(qty);      // set field shares
        setSymbol(sym.toUpperCase());      // set field symbol
    }

    // setCustNumber one String parameter
    public void setCustNumber(String custNumber) throws SecurityException{
        if(custNumber.matches("[0-9][0-9][1-9]\\d{3}[1-9]")){
            this.custNumber = custNumber;
        }else{
            throw new SecurityException("Customer number must be 7 digits in length and greater than 10000");
        }
    }

    // setPurchDt one int parameter
  public void setPurchDT(int purchDt) throws SecurityException{
    
    String date = String.valueOf(purchDt);
    
    if(date.length() != 7){
      throw new SecurityException("Date must be entered in the format YYYYDDD");
    }
    
    String year = date.substring(0,4);
    String day = date.substring(4,7);     
    
    if(Integer.parseInt(year) >= 1901 && Integer.parseInt(year) <= 9999 &&
       Integer.parseInt(day) >= 001 && Integer.parseInt(day) <= 365) {
      this.purchDt = purchDt;
    }else{
      throw new SecurityException("Purchase year must be > 1900; Purchase day must be 001 to 365, inclusive.");
    }
  }

    // setPurchPrc one double parameter
    public void setPurchPrc(double purchPrc) {
        this.purchPrc = purchPrc;
    }

    // setShares one double parameter
    public void setShares(double shares) {
        this.shares = shares;
    }

    // setSymbol one String parameter
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    // getCustNumber returns custNumber field
    public String getCustNumber() {
        return custNumber;
    }

    // getPurchDt returns purchDt field
    public int getPurchDt() {
        return purchDt;
    }

    // getPurchPrc returns purchPrc field
    public double getPurchPrc() {
        return purchPrc;
    }

    // getShares returns shares field
    public double getShares() {
        return shares;
    }

    // getSymbol returns symbol field
    public String getSymbol() {
        return symbol;
    }

    public String offeredValues(){
    return String.format("%nOffered Values:%n  Customer number: %s%n  Purchase Date: %d%n  Share price:  %f"
                         + "%n  Number shares:  %f%n  Symbol: %s%n", getCustNumber(), getPurchDt(), getPurchPrc()
                         , getShares(), getSymbol);
    }
    
    // toString returns StringBuilder objInfo
    public String toString() {

        // create StringBuilder object objInfo
        StringBuilder objInfo = new StringBuilder(String.format("\nThe Security belongs to Customer#  %s;",
                getCustNumber()));

        objInfo.append(String.format(" %.3f shares of %s were%n", getShares(), getSymbol()));
        objInfo.append(String.format("purchased on %d for $%.2f per share.%n", getPurchDt(), getPurchPrc()));

        return objInfo.toString();
    }
}
