package store;

import java.util.Comparator;

/**
 * Sorts salable products by name in descending order.
 */
public class NameDescendingComparator implements Comparator<SalableProduct> {

    /**
     * Compares two products by name from Z to A.
     *
     * @param p1 first product
     * @param p2 second product
     * @return comparison result
     */
    public int compare(SalableProduct p1, SalableProduct p2) {
        return p2.getName().compareToIgnoreCase(p1.getName());
    }
}
