package store;

import java.util.Scanner;

/**
 * Main Store Front application.
 */
public class StoreFront {

    private InventoryManager inventoryManager;
    private ShoppingCart shoppingCart;

    /**
     * Creates the StoreFront object.
     */
    public StoreFront() {
        inventoryManager = new InventoryManager();
        shoppingCart = new ShoppingCart();
    }

    /**
     * Starts the store.
     */
    public void startStore() {
        inventoryManager.initializeInventory();
        shoppingCart.initializeCart();
    }

    /**
     * Returns inventory manager.
     *
     * @return inventory manager
     */
    public InventoryManager getInventoryManager() {
        return inventoryManager;
    }

    /**
     * Returns shopping cart.
     *
     * @return shopping cart
     */
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    /**
     * Displays inventory.
     */
    public void showInventory() {

        System.out.println("\nINVENTORY:");

        if (inventoryManager.getInventory().isEmpty()) {

            System.out.println("Inventory is empty.");

        } else {

            for (SalableProduct product : inventoryManager.getInventory()) {
                System.out.println(product);
            }
        }

        System.out.println();
    }

    /**
     * Displays shopping cart.
     */
    public void showCart() {

        System.out.println("\nSHOPPING CART:");

        if (shoppingCart.getCart().isEmpty()) {

            System.out.println("Cart is empty.");

        } else {

            for (SalableProduct product : shoppingCart.getCart()) {
                System.out.println(product);
            }
        }

        System.out.println();
    }

    /**
     * Buys a product.
     *
     * @param id product ID
     */
    public void buyProduct(String id) {

        SalableProduct product = inventoryManager.findProduct(id);

        if (product != null) {

            shoppingCart.addToCart(product);
            inventoryManager.removeProduct(product);

            System.out.println(product.getName()
                    + " added to cart.");

        } else {

            System.out.println("Product not found.");
        }
    }

    /**
     * Cancels a purchase.
     *
     * @param id product ID
     */
    public void cancelProduct(String id) {

        SalableProduct product = shoppingCart.findProduct(id);

        if (product != null) {

            shoppingCart.removeFromCart(product);
            inventoryManager.addProduct(product);

            System.out.println(product.getName()
                    + " returned to inventory.");

        } else {

            System.out.println("Product not found in cart.");
        }
    }

    /**
     * Displays sort menu.
     */
    public void sortMenu(Scanner scanner) {

        System.out.println("\nSORT OPTIONS");
        System.out.println("1. Name A-Z");
        System.out.println("2. Name Z-A");
        System.out.println("3. Price Low-High");
        System.out.println("4. Price High-Low");

        System.out.print("Enter sort option: ");

        int choice = scanner.nextInt();

        switch (choice) {

            case 1:
                inventoryManager.sortByNameAscending();
                System.out.println("Sorted by Name A-Z");
                break;

            case 2:
                inventoryManager.sortByNameDescending();
                System.out.println("Sorted by Name Z-A");
                break;

            case 3:
                inventoryManager.sortByPriceAscending();
                System.out.println("Sorted by Price Low-High");
                break;

            case 4:
                inventoryManager.sortByPriceDescending();
                System.out.println("Sorted by Price High-Low");
                break;

            default:
                System.out.println("Invalid sort option.");
        }

        showInventory();
    }

    /**
     * Main method.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {

        StoreFront store = new StoreFront();

        store.startStore();

        Scanner scanner = new Scanner(System.in);

        int choice = 0;

        while (choice != 7) {

            System.out.println("\nSTORE FRONT APPLICATION");
            System.out.println("1. View Inventory");
            System.out.println("2. Sort Inventory");
            System.out.println("3. Buy Product");
            System.out.println("4. Cancel Purchase");
            System.out.println("5. View Cart");
            System.out.println("6. Empty Cart");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");

            choice = scanner.nextInt();

            scanner.nextLine();

            switch (choice) {

                case 1:
                    store.showInventory();
                    break;

                case 2:
                    store.sortMenu(scanner);
                    break;

                case 3:

                    System.out.print("Enter product ID to buy: ");

                    String buyId = scanner.nextLine();

                    store.buyProduct(buyId);

                    break;

                case 4:

                    System.out.print(
                            "Enter product ID to cancel: ");

                    String cancelId = scanner.nextLine();

                    store.cancelProduct(cancelId);

                    break;

                case 5:
                    store.showCart();
                    break;

                case 6:

                    store.getShoppingCart().emptyCart();

                    System.out.println(
                            "Shopping cart emptied.");

                    break;

                case 7:
                    System.out.println("Program ending.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}