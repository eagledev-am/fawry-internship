package fawry.repo;

import fawry.entity.Product;
import fawry.entity.ProductCategory;
import fawry.util.HibernateUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.function.Consumer;

public class ProductRepository {

    private static Session session;
    public static Product get(int id){
         session = HibernateUtil.getSessionFactory().openSession();
        return session.get(Product.class , id);
    }

    public static List<Product> getProducts(){
        session = HibernateUtil.getSessionFactory().openSession();
        TypedQuery<Product> query = session.createQuery("from Product", Product.class);
        return query.getResultList();
    }

    public static List<Product> getProductsByNameOrCategory(String query){
        session = HibernateUtil.getSessionFactory().openSession();
        TypedQuery<Product> query1 = session.createQuery("from Product where title like  :query  or category.categoryName like : query" , Product.class);
        query1.setParameter("query", "%" +query+ "%");
        return query1.getResultList();
    }

    public static List<ProductCategory> getCategories() {
        session = HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("from ProductCategory" , ProductCategory.class)
                .getResultList();
    }

    public static void save(Product product){
        executeTransaction(session -> session.persist(product));
    }

    public static void delete(Product product){
        executeTransaction(session-> session.remove(product));
    }

    public static void update(Product product){
        executeTransaction(session1 -> session1.merge(product));
    }


    private static void executeTransaction(Consumer<Session> action){
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction1 = session.beginTransaction();
        action.accept(session);
        transaction1.commit();
    }
}
