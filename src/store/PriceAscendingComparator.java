package store;

import java.util.Comparator;

/**
 * Sorts salable products by price in ascending order.
 */
public class PriceAscendingComparator implements Comparator<SalableProduct> {

    /**
     * Compares two products by price from lowest to highest.
     *
     * @param p1 first product
     * @param p2 second product
     * @return comparison result
     */
    public int compare(SalableProduct p1, SalableProduct p2) {
        return Double.compare(p1.getPrice(), p2.getPrice());
    }
}
