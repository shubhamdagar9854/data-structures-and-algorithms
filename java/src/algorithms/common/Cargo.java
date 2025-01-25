package algorithms.common;

/**
 * Represents a Cargo object used across different algorithm implementations
 * for consistent testing and comparison.
 * 
 * @author bjornmelin
 * @version 1.0
 * @since 2025-01-25
 */
import java.util.*;

public class Cargo implements Comparable<Cargo> {
    private static int trackNumber = 0;
    private int orderNum;
    private String dest = "";
    private double tons = 0.0;

    /**
     * Constructs a Cargo object with destination and weight.
     * 
     * @param dest Destination string
     * @param tons Weight in tons (used for sorting)
     */
    public Cargo(String dest, double tons) {
        setDest(dest);
        setTonnage(tons);
        setOrderNumber();
    }

    /**
     * Sets a unique order number for each Cargo instance.
     */
    private void setOrderNumber() {
        orderNum = trackNumber++;
    }

    /**
     * Gets the unique order number of this Cargo instance.
     * 
     * @return The order number
     */
    public int getOrderNumber() {
        return orderNum;
    }

    /**
     * Gets the destination of this Cargo.
     * 
     * @return The destination string
     */
    public String getDest() {
        return dest;
    }

    /**
     * Gets the weight in tons of this Cargo.
     * 
     * @return The weight in tons
     */
    public double getTonnage() {
        return tons;
    }

    /**
     * Sets the destination of this Cargo.
     * 
     * @param dest The destination string to set
     */
    private void setDest(String dest) {
        this.dest = dest;
    }

    /**
     * Sets the weight in tons of this Cargo, ensuring non-negative values.
     * 
     * @param tons The weight in tons to set
     */
    private void setTonnage(double tons) {
        if (tons >= 0) {
            this.tons = tons;
        }
    }

    @Override
    public String toString() {
        return String.format(
                "Cargo object #%d has the following information:\n" +
                        "\t%.2f tons\n\tTo be delivered to: %s",
                getOrderNumber(), getTonnage(), getDest());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Cargo other = (Cargo) obj;
        return getOrderNumber() == other.getOrderNumber();
    }

    @Override
    public int compareTo(Cargo other) {
        if (getTonnage() < other.getTonnage()) {
            return -1;
        } else if (getTonnage() > other.getTonnage()) {
            return 1;
        } else {
            return 0;
        }
    }
}