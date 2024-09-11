import java.util.ArrayList;

public class Product {

    private static int counter = 0;
    private static ArrayList<Product> products = new ArrayList<Product>();
    private int id;
    private String productid;
    private double profit;
    private String name;
    private double price;
    private int quantity;

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Product.counter = counter;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    public Product(String prodid, String nm, double prc, int q, double p) {
        products.add(this);
        counter++;
        setId(counter);
        setProductid(prodid);
        setName(nm);
        setPrice(prc);
        setQuantity(q);
        setProfit(p);
    }

    public void setId(int iden) {
        id = iden;
    }

    public int getId() {
        return id;
    }

    public void setName(String nm) {
        name = nm;
    }

    public String getName() {
        return name;
    }

    public static String getNameById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product.getName();
            }
        }
        return null;
    }

    public void setPrice(double prc) {
        price = prc;
    }

    public double getPrice() {
        return price;
    }

    public static double getPriceById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product.getPrice();
            }
        }
        return -1;
    }

    public void setQuantity(int q) {
        quantity = q;
    }

    public int getQuantity() {
        return quantity;
    }

    public static ArrayList<Product> getProducts() {
        return products;
    }

    public static Product checkAvailability(int iden) {
        for (Product product : products) {
            if (product.getId() == iden) {
                return product;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return String.format("%d\t\t  %s\t\t  %s\t\t  RM%.2f\t\t  %d",
                getId(), getProductid(), getName(), getPrice(), getQuantity());
    }

}
