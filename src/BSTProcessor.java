import com.opencsv.CSVReader;
import java.io.FileReader;

public class BSTProcessor {
    private LLRB<String, Product> prodRBTree;

    public void readCSVintoLLRB(String fileName) {
        try {
            LLRB<String, Product> prodRBTree= new LLRB<String, Product>();
            FileReader productCSV = new FileReader(fileName);
            CSVReader csvReader = new CSVReader(productCSV);
            // drew inspiration from: https://www.geeksforgeeks.org/reading-csv-file-java-using-opencsv/
            String[] nextProduct;
            while ((nextProduct = csvReader.readNext()) != null){
                Product productObject = new Product(nextProduct);
                prodRBTree.insert(productObject.getUniqueID(), productObject);
            }
            this.prodRBTree = prodRBTree;
        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }
    public void insertTestLLRBTree() {
        Product test1 = new Product(new String[]{"3932387affc268b3c9d6cca70dbdbcb4","roblox toy","Toys & Games","$39.39"});
        Product test2 = new Product(new String[]{"3932387affc268b3c9d6cca70dbdbcb4","roblox toy","Toys & Games","$39.39"});        // should receive error
        Product test3 = new Product(new String[]{"93f821fa0abe44f1d29203623d5ee012","jelly cat","Stuffed Animals","$93.93"});

        // insert test
        insertProduct(test1);
        insertProduct(test3);
        insertProduct(test2);
    }

    private void insertProduct(Product product) {
        ConsoleColors.print("Inserting Product: ","cyan");
        System.out.println(product);
        try {
            prodRBTree.insert(product.getUniqueID(), product);
            ConsoleColors.println("Insertion successful.","green");
        } catch (Exception e) {
            ConsoleColors.println("Insertion failed - Product already exists", "red");
        }
        System.out.println();
    }

    public void searchTestLLRBTree(String userID) {
        // looking within the tree already made to find the product which matches the string for USERID
        Product searchObj = prodRBTree.search(userID); // takes generic, so should be able to take "Product type"
        ConsoleColors.println("Search found: " + searchObj,"violet");
    }
}
