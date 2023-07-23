import java.util.*;

public class OrderProcessor {
    public void placeOrder(ShoppingCart cart){
        System.out.println("no.\tname\t\t\tamount\t\tprice");
        Map<Product , Integer> items = checkOrder(cart);
        int i = 1;
        for (Product product : items.keySet()){
            System.out.println(i++ + "-\t" + product.getName()+" \t\t"+ items.get(product) + " \t\t\t$" + product.getPrice());
        }
        System.out.println("Total Cost = $" + cart.getTotalCost());
    }

    private Map<Product , Integer> checkOrder(ShoppingCart cart){
        Map<Product , Integer> items = new HashMap<>();
        for(Product product : cart.getProducts()){
            items.put(product , items.getOrDefault(product , 0) + 1);
        }
        return items;
    }
}
