<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Form</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style><%@include file="css/normalize.css"%></style>
    <style><%@include file="css/bootstrap.min.css"%></style>
</head>
<body>
        <%@include file="Header.jsp"%>
        <div class="container mt-5">
            <c:if test="${update == false}">
            <h2 class="mb-4">Add New Product</h2>
            </c:if>

            <c:if test="${update == true}">
                <h2 class="mb-4">Update Product</h2>
            </c:if>
            <form enctype="multipart/form-data" method="post">
                <div class="mb-3">
                    <label for="productName" class="form-label">Product Name</label>
                    <input type="text" class="form-control" id="productName" name="productName" value="${product.title}" required>
                </div>
                <div class="mb-3">
                    <label for="productDescription" class="form-label">Description</label>
                    <textarea class="form-control" id="productDescription" name="productDescription" rows="3">${product.description}</textarea>
                </div>
                <div class="mb-3">
                    <label for="productPrice" class="form-label">Price</label>
                    <input type="number" class="form-control" id="productPrice" name="productPrice" value="${product.price}" step="0.01" required>
                </div>
                <div class="mb-3">
                    <label for="productCategory" class="form-label">Category</label>
                    <select class="form-select" id="productCategory" name="productCategory">
                        <option selected>Choose category...</option>
                        <c:forEach items="${categories}" var="category">
                            <option value="${category.categoryName}">${category.categoryName}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="mb-3">
                    <c:if test="${update == true}">
                        <img alt="img" class="figure figure-img" src="${product.imagePath}" width="80" height="100">
                    </c:if>
                    <label for="image" class="form-label">Product image</label>
                    <input type="file" class="form-control" id="image" name="image" value="${product.imagePath}" >
                </div>
                <input type="hidden" name="id" value="${param.id}">
                <c:if test="${update == false}">
                <button  type="submit" class="btn btn-primary" formaction="${pageContext.request.contextPath}/products/save">Add Product</button>
                </c:if>
                <c:if test="${update == true}" >
                <button type="submit" class="btn btn-primary" formaction="${pageContext.request.contextPath}/products/update">Update Product</button>
                </c:if>
            </form>
        </div>
</body>
</html>
