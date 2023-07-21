public class OrderProcessor {
    public void placeOrder(ShoppingCart cart){
        System.out.println("no.\tname\t\t\tprice");
        int i = 1;
        for (Product product : cart.getProducts()){
            System.out.println(i++ + "-\t" + product.getName()+" \t\t$"+ product.getPrice());
        }
        System.out.println("Total Cost = $" + cart.getTotalCost());
    }
}
