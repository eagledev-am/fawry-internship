package fawry.servlet;

import java.io.*;

import java.util.List;

import fawry.entity.Product;
import fawry.entity.ProductCategory;
import fawry.file.FileStorage;
import fawry.service.ProductService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(urlPatterns = {
        "/products/*"
})
@MultipartConfig
public class ProductServlet extends HttpServlet {
    private ProductService productService;
    private List<Product> products ;
    List<ProductCategory> categories;

    @Override
    public void init() throws ServletException {
        productService = new ProductService();
        categories = productService.getCategories();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = (request.getPathInfo() == null)? "/products" :  request.getPathInfo();
        System.out.println(pathInfo);
        switch (pathInfo){
            case "/manage":
                showProductManagePage(request , response);
                break;
            case "/search":
                searchProduct(request , response);
                break;
            case "/save":
                saveProduct(request , response);
                break;
            case "/delete":
                deleteProduct(request , response);
                break;
            case "/add-form":
                showProductForm(request , response);
                break;
            case "/update-form":
                showUpdateForm(request , response);
                break;
            case "/update":
                updateProduct(request , response);
                break;
            case "/products":
                showProductList(request ,response);
                break;

        }
    }


    private void showProductForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("categories", categories);
        request.setAttribute("update" , false);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/form.jsp");
        dispatcher.forward(request , response);
    }


    private void showProductManagePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        products = productService.getAllProduct();
        request.setAttribute("products", products);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/product-management.jsp");
        requestDispatcher.forward(request , response);
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.getProduct(id);
        request.setAttribute("product" , product);
        request.setAttribute("categories", categories);
        request.setAttribute("update" , true);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/form.jsp");
        dispatcher.forward(request , response);

    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = getProductParameters(request , response);
        product.setId(id);
        productService.updateProduct(
                product
        );
        response.sendRedirect(request.getContextPath() + "/products");
    }


    private void showProductList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       products = productService.getAllProduct();
       request.setAttribute("products", products);
       RequestDispatcher requestDispatcher = request.getRequestDispatcher("product.jsp");
       requestDispatcher.forward(request , response);
    }

    private void deleteProduct(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        productService.deleteProduct(id);
        response.sendRedirect(request.getContextPath() + "/products/manage");
    }

    private void saveProduct(HttpServletRequest request , HttpServletResponse response) throws IOException, ServletException {
        productService.addProduct(
              getProductParameters(request , response)
        );
        response.sendRedirect(request.getContextPath() + "/products");
    }

    private void searchProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String query = request.getParameter("query");
        request.setAttribute("products" ,  productService.searchProduct(query));
        String pathInfo = request.getPathInfo();
        RequestDispatcher requestDispatcher;
        if(pathInfo == null){
            requestDispatcher = request.getRequestDispatcher("/product.jsp");
        }
        else{
            requestDispatcher = request.getRequestDispatcher("/product-management.jsp");
        }
        requestDispatcher.include(request , response);

    }

    private boolean isImage(Part file) {
        return file.getContentType() != null &&
                ( file.getContentType().equals("image/jpeg") || file.getContentType().equals("image/png") ) ;
    }

    private ProductCategory getCategory(String categoryName){
        return categories.stream()
                .filter(category -> category.getCategoryName().equals(categoryName))
                .findFirst()
                .orElse(null);
    }

    private Product getProductParameters(HttpServletRequest request , HttpServletResponse response) throws IOException, ServletException {
        String title = request.getParameter("productName");
        String description = request.getParameter("productDescription");
        double price = Double.parseDouble(request.getParameter("productPrice"));
        String category = request.getParameter("productCategory");
        Part file = request.getPart("image");

        if(!isImage(file)){
            response.sendError(403 , "invalid file");
        }

        String filePath = request.getContextPath() + "/file/" + FileStorage.storeFile(file);
        System.out.println(getServletContext().getContextPath());
        System.out.println(filePath);
        return Product.builder()
                    .title(title)
                    .description(description)
                    .price(price)
                    .imagePath(filePath)
                    .category(getCategory(category))
                    .build();
    }
}