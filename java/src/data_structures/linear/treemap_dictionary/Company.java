package data_structures.linear.treemap_dictionary;

/**
 * Company Object
 * 
 * @author bjornmelin
 */
public class Company {

    private String symbol;
    private String name;
    private double lastSale;
    private String sector;
    private String industry;

    /**
     * Constructor for Company
     * 
     * @param line String denoting the line from the input file
     */
    public Company(String line) {
        String[] split = line.split("\",\"");
        symbol = split[0].substring(1);
        name = split[1];
        lastSale = Double.parseDouble(split[2]);
        sector = split[6];
        industry = split[7];
    }

    /**
     * toString method for Company Object
     * 
     * @return A String denoting the information of the Company
     */
    @Override
    public String toString() {
        return "Company{" + "symbol = " + symbol + ", name = " + name +
                ", lastSale = " + lastSale + ", sector = " + sector +
                ", industry = " + industry + '}';
    }

    /**
     * Get method for Symbol
     * 
     * @return String denoting the symbol of the company
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Set method for Symbol
     * 
     * @param symbol String denoting the symbol of the company
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     * Get method for Name of Company
     * 
     * @return String denoting the Companies name
     */
    public String getName() {
        return name;
    }

    /**
     * Set method for Name of Company
     * 
     * @param name String denoting what the Companies name is
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get method for Last Sale of a Company
     * 
     * @return double denoting the values of the Companies last sale
     */
    public double getLastSale() {
        return lastSale;
    }

    /**
     * Set method for Last Sale of a Company
     * 
     * @param lastSale double denoting what to set the Companies last sale value to
     */
    public void setLastSale(double lastSale) {
        this.lastSale = lastSale;
    }

    /**
     * Get method for Sector of a Company
     * 
     * @return String denoting the Sector of a Company
     */
    public String getSector() {
        return sector;
    }

    /**
     * Set method for the Sector of a Company
     * 
     * @param sector String denoting the Sector to set for the Company
     */
    public void setSector(String sector) {
        this.sector = sector;
    }

    /**
     * Get method for Industry of a Company
     * 
     * @return String denoting the Industry a Company is in
     */
    public String getIndustry() {
        return industry;
    }

    /**
     * Set method for Industry a Company is in
     * 
     * @param industry String denoting the Industry to set for a Company
     */
    public void setIndustry(String industry) {
        this.industry = industry;
    }
}