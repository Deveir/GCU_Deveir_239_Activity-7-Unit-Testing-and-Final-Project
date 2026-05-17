package store;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Handles file operations for the store.
 */
public class FileService {

    /**
     * Loads inventory from JSON file.
     *
     * @param fileName JSON file name
     * @return list of products
     */
    public ArrayList<SalableProduct> loadInventory(String fileName) {

        ArrayList<SalableProduct> products =
                new ArrayList<SalableProduct>();

        try {

            ObjectMapper mapper = new ObjectMapper();

            ProductData[] productDataList =
                    mapper.readValue(new File(fileName), ProductData[].class);

            // =====================================
            // FOR LOOP GOES HERE
            // =====================================

            for (ProductData data : productDataList) {

                if (data.type == null) {

                    System.out.println(
                        "Product type is missing for item: "
                        + data.name
                    );

                } else if (data.type.equalsIgnoreCase("Weapon")) {

                    products.add(
                        new Weapon(
                            data.id,
                            data.name,
                            data.price,
                            data.damage
                        )
                    );

                } else if (data.type.equalsIgnoreCase("Armor")) {

                    products.add(
                        new Armor(
                            data.id,
                            data.name,
                            data.price,
                            data.defense
                        )
                    );

                } else if (data.type.equalsIgnoreCase("HealthPotion")) {

                    products.add(
                        new HealthPotion(
                            data.id,
                            data.name,
                            data.price,
                            data.healing
                        )
                    );
                }
            }

        } catch (IOException e) {

            System.out.println("Error reading inventory file.");

            System.out.println(
                "Make sure inventory.json exists in the project folder."
            );

            System.out.println(
                "Error message: " + e.getMessage()
            );

        } catch (Exception e) {

            System.out.println(
                "A general error happened while loading inventory."
            );

            System.out.println(
                "Error message: " + e.getMessage()
            );
        }

        return products;
    }
}