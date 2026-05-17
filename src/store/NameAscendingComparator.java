package store;

import java.util.Comparator;

/**
 * Sorts salable products by name in ascending order.
 */
public class NameAscendingComparator implements Comparator<SalableProduct> {

    /**
     * Compares two products by name from A to Z.
     *
     * @param p1 first product
     * @param p2 second product
     * @return comparison result
     */
    public int compare(SalableProduct p1, SalableProduct p2) {
        return p1.getName().compareToIgnoreCase(p2.getName());
    }
}