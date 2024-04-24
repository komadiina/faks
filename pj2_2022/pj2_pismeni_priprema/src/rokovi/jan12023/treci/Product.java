package rokovi.jan12023.treci;

public class Product {
    public String id, productName, productCategory;
    public Double price;
    public String currency;
    public Integer quantity;

    public Product() {
        id = ""; productCategory = ""; productName = "";
        currency = "";
        price = 0.0;
        quantity = 0;
    }

    public Product(String id, String productName, String productCategory, Double price, String currency, Integer quantity) {
        this.id = id;
        this.productName = productName;
        this.productCategory = productCategory;
        this.price = price;
        this.currency = currency;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", productName='" + productName + '\'' +
                ", productCategory='" + productCategory + '\'' +
                ", price=" + price +
                ", currency='" + currency + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
