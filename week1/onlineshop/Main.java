import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {

        Product product1 = new Product("productA" , 30.5);
        Product product2 = new Product("productB" , 100);
        Product product3 = new Product("productC" , 90);
        Product product4 = new Product("productD" , 40.5);
        Product product5 = new Product("productB" , 100);
        Product product6 = new Product("productA" , 30.5);

        ShoppingCart cart = new ShoppingCart();

        cart.addItem(product1);
        cart.addItem(product2);
        cart.addItem(product3);
        cart.addItem(product4);
        cart.addItem(product5);
        cart.addItem(product6);


        System.out.println("Cart Content : " + cart.getProducts());
        cart.removeItem(product3);
        System.out.println("Cart Content : " + cart.getProducts());

        OrderProcessor order = new OrderProcessor();
        order.placeOrder(cart);
    }
}