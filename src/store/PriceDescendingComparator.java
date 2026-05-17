package store;

import java.util.Comparator;

/**
 * Sorts salable products by price in descending order.
 */
public class PriceDescendingComparator implements Comparator<SalableProduct> {

    /**
     * Compares two products by price from highest to lowest.
     *
     * @param p1 first product
     * @param p2 second product
     * @return comparison result
     */
    public int compare(SalableProduct p1, SalableProduct p2) {
        return Double.compare(p2.getPrice(), p1.getPrice());
    }
}