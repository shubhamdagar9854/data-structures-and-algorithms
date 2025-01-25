package data_structures.linear.treemap_dictionary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Driver which creates a TreeMap Company Dictionary
 * and performs various operations on the dictionary.
 * 
 * @author bjornmelin
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {

        Scanner fileData = new Scanner(new File("companylist.csv"));
        fileData.nextLine(); // Reads first line and gets rid of it

        // Creates my Dictionary of Companies using Java built in TreeMap
        TreeMap<String, Company> companyDict = new TreeMap<>(); // Key is symbol: String

        // Used to test to be sure I am properly using the input file
        while (fileData.hasNextLine()) {
            String line = fileData.nextLine();
            // If the line/Company contains all of the information I am looking for, but
            // that Company into my Dictionary with Symbol as key
            if (!line.contains("n/a")) {
                Company newCompany = new Company(line);
                companyDict.put(newCompany.getSymbol(), newCompany);
                System.out.println(newCompany);
            }
        }

        System.out.println("\n\n\n");

        // For each Company in my Dictionary, prints off its value
        for (Company comp : companyDict.values()) {
            System.out.println(comp);
        }

        System.out.println("\n\n\n\n");

        // Calls on method to display options for the user to input
        masterUserInput(companyDict, "");
    }

    /**
     * Method to be recursively called on to let a user search for a Company by
     * Symbol (key)
     * If Symbol entered is invalid, the method is called on again to ask for new
     * input
     * 
     * @param companyDict TreeMap containing companies
     */
    public static void findSymbol(TreeMap<String, Company> companyDict) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please Enter a Company Symbol: ");
        String userSymbol = userInput.next();

        if (companyDict.containsKey(userSymbol)) {
            Company validKey = companyDict.get(userSymbol);
            System.out.println("\nThe Company with the Symbol Entered is:\n" + validKey);
        } else {
            System.out.println("\nThe Symbol Entered is Invalid!!  Must Enter Valid Company Symbol!\n");
            findSymbol(companyDict);
        }
    }

    /**
     * Method called on to print out the cheapest stock in the Dictionary and the
     * Company with that stock price
     * 
     * @param companyDict TreeMap containing companies
     */
    public static void printCheapestStock(TreeMap<String, Company> companyDict) {
        ArrayList<Double> stockPrices = new ArrayList<>();
        TreeMap<Double, Company> companyDictPrices = new TreeMap<>(); // Key is Stock Price: Double

        for (Company comp : companyDict.values()) {
            Double stockPrice = comp.getLastSale();
            stockPrices.add(stockPrice);
        }
        for (Company comp : companyDict.values()) {
            companyDictPrices.put(comp.getLastSale(), comp);
        }

        insertionSort(stockPrices);
        Double cheapestStock = stockPrices.get(0);
        Company cheapestComp = companyDictPrices.get(cheapestStock);
        System.out.println("The Cheapest Stock is: $" + cheapestStock + " At the Company: " + cheapestComp);
    }

    /**
     * Method called on to print out the most expensive stock in the Dictionary and
     * the Company with that stock price
     * 
     * @param companyDict TreeMap containing companies
     */
    public static void printExpensiveStock(TreeMap<String, Company> companyDict) {
        ArrayList<Double> stockPrices = new ArrayList<>();
        TreeMap<Double, Company> companyDictPrices = new TreeMap<>(); // Key is Stock Price: Double

        for (Company comp : companyDict.values()) {
            Double stockPrice = comp.getLastSale();
            stockPrices.add(stockPrice);
        }
        for (Company comp : companyDict.values()) {
            companyDictPrices.put(comp.getLastSale(), comp);
        }

        insertionSort(stockPrices);
        Double mostExpensiveStock = stockPrices.get(stockPrices.size() - 1);
        Company mostExpensiveComp = companyDictPrices.get(mostExpensiveStock);
        System.out.println(
                "The Most Expensive Stock is: $" + mostExpensiveStock + " At the Company: " + mostExpensiveComp);
    }

    /**
     * Method used to print off the Mean and Median Stock price for a Sector entered
     * in by the user
     * If Sector entered is not in the TreeMap, then it returns NAN
     * 
     * @param companyDict TreeMap containing companies
     */
    public static void printSectorAverage(TreeMap<String, Company> companyDict) {
        Scanner sectorInput = new Scanner(System.in);
        System.out.println("Enter a Sector: ");
        String userSector = sectorInput.nextLine();

        ArrayList<Company> sectorCompanies = new ArrayList<>();

        for (Company value : companyDict.values()) {
            if (value.getSector().equals(userSector)) {
                sectorCompanies.add(value);
            }
        }

        double sumSectorPrice = 0.0;
        for (int i = 0; i < sectorCompanies.size(); i++) {
            sumSectorPrice += sectorCompanies.get(i).getLastSale();
        }
        double meanSectorPrice = sumSectorPrice / sectorCompanies.size();
        System.out.println("Average Stock Price for Sector " + userSector + " is: $" + meanSectorPrice);

        ArrayList<Double> sectorCompaniesPrices = new ArrayList<>();
        for (int i = 0; i < sectorCompanies.size(); i++) {
            sectorCompaniesPrices.add(sectorCompanies.get(i).getLastSale());
        }
        insertionSort(sectorCompaniesPrices);

        // Loop to find the median price for the Sectors stock if the Sector is valid
        if (sectorCompaniesPrices.size() > 0) {
            double sectorMedian;
            if (sectorCompaniesPrices.size() % 2 == 0) {
                sectorMedian = (sectorCompaniesPrices.get(sectorCompaniesPrices.size() / 2) +
                        sectorCompaniesPrices.get((sectorCompaniesPrices.size() / 2) - 1)) / 2;
            } else {
                sectorMedian = sectorCompaniesPrices.get(sectorCompaniesPrices.size() / 2);
            }
            System.out.println("The Median Stock Price for Sector " + userSector + " is: $" + sectorMedian);
        }
    }

    /**
     * Method used to print off the Mean and Median Stock price for an Industry
     * entered in by the user
     * If the Industry entered is not in the TreeMap, then it returns NAN
     * 
     * @param companyDict TreeMap containing companies
     */
    public static void printIndustryAverage(TreeMap<String, Company> companyDict) {
        Scanner industryInput = new Scanner(System.in);
        System.out.println("Enter an Industry: ");
        String userIndustry = industryInput.nextLine();

        ArrayList<Company> industryCompanies = new ArrayList<>();

        for (Company value : companyDict.values()) {
            if (value.getIndustry().equals(userIndustry)) {
                industryCompanies.add(value);
            }
        }

        double sumIndustryPrice = 0.0;
        for (int i = 0; i < industryCompanies.size(); i++) {
            sumIndustryPrice += industryCompanies.get(i).getLastSale();
        }
        double meanIndustryPrice = sumIndustryPrice / industryCompanies.size();
        System.out.println("Average Stock Price for the Industry, " + userIndustry + " is: $" + meanIndustryPrice);

        ArrayList<Double> industryCompaniesPrices = new ArrayList<>();
        for (int i = 0; i < industryCompanies.size(); i++) {
            industryCompaniesPrices.add(industryCompanies.get(i).getLastSale());
        }
        insertionSort(industryCompaniesPrices);

        // Loop to find the median price for the industries stock if the industry is
        // valid
        if (industryCompaniesPrices.size() > 0) {
            double industryMedian;
            if (industryCompaniesPrices.size() % 2 == 0) {
                industryMedian = (industryCompaniesPrices.get(industryCompaniesPrices.size() / 2) +
                        industryCompaniesPrices.get((industryCompaniesPrices.size() / 2) - 1)) / 2;
            } else {
                industryMedian = industryCompaniesPrices.get(industryCompaniesPrices.size() / 2);
            }
            System.out.println("The Median Stock Price for the Industry, " + userIndustry + " is: $" + industryMedian);
        }
    }

    /**
     * Sorts elements in an ArrayList when needed
     * Used in some of the methods above
     * 
     * @param insertion ArrayList to be sorted
     */
    private static void insertionSort(ArrayList<Double> insertion) {
        // Loop for considering every element
        for (int curr = 0; curr < insertion.size(); curr++) {
            int small = curr - 1;
            while (small >= 0 && insertion.get(small).compareTo(insertion.get(curr)) > 0) {
                Double temp = insertion.get(curr);
                insertion.set(curr, insertion.get(small));
                insertion.set(small, temp);
                curr = small;
                small = curr - 1;
            }
        }
    }

    /**
     * Method used to run the heart of this program. Takes in user input and calls
     * upon the methods above to display the
     * information that they are looking for from the TreeMap of Companies
     * 
     * @param companyDict     TreeMap denoting a dictionary filled with Companies
     * @param masterUserInput String denoting what a user enters into the program
     */
    public static void masterUserInput(TreeMap<String, Company> companyDict, String masterUserInput) {
        Scanner masterInput = new Scanner(System.in);
        System.out.println("What Information Would You Like to Look Up?  Options are:\n"
                + "Type '1': to Look Up a Company by Symbol\n"
                + "Type '2': to View the Company with the Cheapest Stock\n"
                + "Type '3': to View the Company with the Most Expensive Stock\n"
                + "Type '4': to View the Average and Median Price for a Specified Sector\n"
                + "Type '5': to View the Average and Median Price for a Specified Industry\n"
                + "Type '6': to Exit this Program");
        masterUserInput = masterInput.next();

        while (masterUserInput.equals("1") || masterUserInput.equals("2") || masterUserInput.equals("3") ||
                masterUserInput.equals("4") || masterUserInput.equals("5") || masterUserInput.equals("6")) {

            if (masterUserInput.equals("1")) {
                findSymbol(companyDict);
                System.out.println("\n\n");
                masterUserInput(companyDict, masterUserInput);
            } else if (masterUserInput.equals("2")) {
                printCheapestStock(companyDict);
                System.out.println("\n\n");
                masterUserInput(companyDict, masterUserInput);
            } else if (masterUserInput.equals("3")) {
                printExpensiveStock(companyDict);
                System.out.println("\n\n");
                masterUserInput(companyDict, masterUserInput);
            } else if (masterUserInput.equals("4")) {
                printSectorAverage(companyDict);
                System.out.println("\n\n");
                masterUserInput(companyDict, masterUserInput);
            } else if (masterUserInput.equals("5")) {
                printIndustryAverage(companyDict);
                System.out.println("\n\n");
                masterUserInput(companyDict, masterUserInput);
            } else if (masterUserInput.equals("6")) {
                System.exit(0);
            }
        }

        // If the user enters in a lookup number above 6, it will tell them it is
        // invalid and let them enter in a new number to lookup info
        while (!(masterUserInput.equals("1") || masterUserInput.equals("2") || masterUserInput.equals("3") ||
                masterUserInput.equals("4") || masterUserInput.equals("5") || masterUserInput.equals("6"))) {
            System.out.println("Invalid Selection! Select Look Up Specifications Again");
            System.out.println("\n\n");
            masterUserInput(companyDict, masterUserInput);
        }
    }
}