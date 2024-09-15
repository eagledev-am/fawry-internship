<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Products</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style><%@include file="css/normalize.css"%></style>
    <style><%@include file="css/bootstrap.min.css"%></style>
</head>
<body>
    <%@include file="Header.jsp"%>
        <section>
            <div class="container mt-5">
                <div class="row">
                    <c:forEach var="product" items="${products}">
                        <div class="col-md-4 col-lg-3 col-sm-6">
                            <div class="card mb-4 shadow-sm">
                                <div class="position-relative">
                                    <img src="${product.imagePath}" class="card-img-top" width=""  alt="Product 1 Image">
                                    <span class="badge bg-success position-absolute top-0 start-0 m-2">${product.category.categoryName}</span>
                                </div>
                                <div class="card-body">
                                    <h5 class="card-title">${product.title}</h5>
                                    <p class="card-text">${product.description}</p>
                                    <div class="d-flex justify-content-between align-items-center">
                                        <span class="text-muted">$ ${product.price}</span>
                                        <button class="btn btn-sm btn-primary">Add to Cart</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                    </div>
            </div>
        </section>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>