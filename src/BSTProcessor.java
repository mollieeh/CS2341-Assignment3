import com.opencsv.CSVReader;
import java.io.FileReader;

public class BSTProcessor {
    public LLRB<Product> readCSVintoLLRB(String fileName) {
        try {
            LLRB<Product> prodRBTree= new LLRB<Product>();
            FileReader productCSV = new FileReader(fileName);
            CSVReader csvReader = new CSVReader(productCSV);
            // drew inspiration from: https://www.geeksforgeeks.org/reading-csv-file-java-using-opencsv/
            String[] nextProduct;
            while ((nextProduct = csvReader.readNext()) != null){
                Product productObject = new Product(nextProduct);
                prodRBTree.put(productObject);
            }
            return prodRBTree;
        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
            return null;
        }
    }
    public void printProduct() {

    }
}
