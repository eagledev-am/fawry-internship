import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final List<Product> cart;

    public ShoppingCart(){
        cart = new ArrayList<>();
    }

    public void addItem(Product product){
        cart.add(product);
    }

    public void removeItem(Product product){
        cart.remove(product);
    }

    public double getTotalCost(){
        double cost = 0.0;
        for(Product product : cart){
            cost += product.getPrice();
        }
        return cost;
    }

    public List<Product> getProducts(){
        return cart;
    }
}
