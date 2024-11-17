public class Product implements Comparable<Product> {
    protected String uniqueID, name, category, price;

    public Product(String[] productInfo) {
        this.uniqueID = productInfo[0];
        this.name = productInfo[1];
        this.category = productInfo[2];
        this.price = productInfo[3];

    }
    public String getUniqueID() {
        return uniqueID;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getPrice() {
        return price;
    }

    public int compareTo(Product product) {
        return this.uniqueID.compareTo(product.uniqueID);
    }
}
