package fawry.service;

import fawry.entity.Product;
import fawry.entity.ProductCategory;
import fawry.repo.ProductRepository;

import java.util.List;

public class ProductService {
    public ProductService(){
    }

    public void addProduct(Product product){
        validateFields(product);
       ProductRepository.save(product);
    }

    public void deleteProduct(int id){
        if(id <= 0){
            throw new RuntimeException("id must be positive");
        }
        Product product = ProductRepository.get(id);
        ProductRepository.delete(product);
    }

    public Product getProduct(int id){
        if(id <= 0){
            throw new RuntimeException("id must be positive");
        }
        return ProductRepository.get(id);
    }

    public List<Product> getAllProduct(){
        return ProductRepository.getProducts();
    }

    private void validateFields(Product product){
        if(product == null){
            throw new RuntimeException("product can not be null");
        }

        if(product.getDescription() == null || product.getDescription().isEmpty()){
            throw new RuntimeException("description can not be empty");
        }

        if(product.getTitle() == null || product.getTitle().isEmpty()){
            throw new RuntimeException("title can not be empty");
        }

        if(product.getPrice() < 0){
            throw new RuntimeException("price can not be less than zero");
        }
    }

    public Product updateProduct(Product product){
         ProductRepository.update(product);
         return product;
    }

    public List<Product> searchProduct(String query) {
        return ProductRepository.getProductsByNameOrCategory(query);
    }

    public List<ProductCategory> getCategories(){
        return  ProductRepository.getCategories();
    }
}
