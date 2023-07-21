public class Main {
    public static void main(String[] args) {

        Product product1 = new Product("product1" , 30.5);
        Product product2 = new Product("product2" , 100);
        Product product3 = new Product("product3" , 90);
        Product product4 = new Product("product4" , 40.5);

        ShoppingCart cart = new ShoppingCart();

        cart.addItem(product1);
        cart.addItem(product2);
        cart.addItem(product3);
        cart.addItem(product4);

        System.out.println("Cart Content : " + cart.getProducts());
        cart.removeItem(product3);
        System.out.println("Cart Content : " + cart.getProducts());

        OrderProcessor order = new OrderProcessor();
        order.placeOrder(cart);
    }
}