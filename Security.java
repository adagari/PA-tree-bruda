// abstract class Security implements CostBasis
public abstract class Security implements CostBasis {

    private String custNumber;  // private String
    private int purchDt;        // private int
    private double purchPrc;    // private double
    private double shares;      // private double
    private String symbol;      // private String

    // constructor five parameters
    public Security(String nbr, int date, double price,
                    double qty, String sym) {
        this.custNumber = nbr;  // set field custNumber
        this.purchDt = date;    // set field purchDt
        this.purchPrc = price;  // set field purchPrc
        this.shares = qty;      // set field shares
        this.symbol = sym.toUpperCase();      // set field symbol
    }

    // setCustNumber one String parameter
    public void setCustNumber(String custNumber) {
        this.custNumber = custNumber;
    }

    // setPurchDt one int parameter
    public void setPurchDT(int purchDt) {
        this.purchDt = purchDt;
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