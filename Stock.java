// class Stock subclass of Security
public class Stock extends Security {

    private String exchange;    // private String
    private boolean dividends;  // private boolean
    private int divDate;        // private int
    private double divAmount;   // private double

    // constructor nine parameters
    public Stock(String nbr, int date, double prc, double qty, String sym,
                 String xchg, boolean div, int divDt,double amt) {
        super(nbr, date, prc, qty, sym); // superclass constructor
        this.exchange = xchg;            // set field exchange
        this.dividends = div;            // set field dividends
        this.divDate = divDt;            // set field divDate
        this.divAmount = amt;            // set field divAmount
    }

    // setExchage one String parameter
    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    // setDividends one boolean parameter
    public void setDividends(boolean dividends) {
        this.dividends = dividends;
    }

    // setDivDate one int parameter
    public void setDivDate(int divDate) {
        this.divDate = divDate;
    }

    // setDivAmount one double parameter
    public void setDivAmount(double divAmount) {
        this.divAmount = divAmount;
    }

    // getExchange returns exchange field
    public String getExchange() {
        return exchange;
    }

    // getDividends returns dividends field
    public boolean getDividends() {
        return dividends;
    }

    // getDivDate returns divDate field
    public int getDivDate() {
        return divDate;
    }

    // getDivAmount returns divAmount field
    public double getDivAmount() {
        return divAmount;
    }

    // toString returns StringBuilder objInfo
    public String toString() {

        // create StringBuilder object objInfo
        StringBuilder objInfo = new StringBuilder(String.format("\nThe Stock belongs to Customer# %s;",
                getCustNumber()));

        objInfo.append(String.format(" %.3f shares of %s were%n", getShares(), getSymbol()));
        objInfo.append(String.format("purchased on %d for $%.2f per share.%n", getPurchDt(), getPurchPrc()));
        objInfo.append(String.format("This stock is traded on the %s exchange.%n", getExchange()));

        // if else to append getDividens information
        if(getDividends() == true) {
            objInfo.append(String.format("\tA dividend of $%.2f will be paid in the %d quarter.%n", getDivAmount(), getDivDate()));
        } else {
            objInfo.append("\tThis stock does not pay dividends.\n");
        }

        return objInfo.toString();
    }

    // calcCost returns calculated cost
    public double calcCost() {
        return (getShares() * (getPurchPrc() - getDivAmount()));
    }
}