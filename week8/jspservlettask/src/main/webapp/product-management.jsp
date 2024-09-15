<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add new Product</title>
    <style><%@include file="css/normalize.css"%></style>
    <style><%@include file="css/bootstrap.min.css"%></style>
    <style>
        html,
        body,
        .intro {
            height: 100%;
        }

        table td,
        table th {
            text-overflow: ellipsis;
            white-space: nowrap;
            overflow: hidden;
        }

        .card {
            border-radius: .5rem;
        }

    </style>
</head>
<body>
        <%@include file="Header.jsp"%>
        <div class="m-5">
            <section class="intro">
                <div class="bg-image">
                    <div class="mask d-flex align-items-center">
                        <div class="container">
                            <div class="mb-2">
                                <a class="btn btn-primary" style="text-decoration: none" href="${pageContext.request.contextPath}/products/add-form">Add Product</a>
                            </div>
                            <div class="row justify-content-center">
                                <div class="col-12">
                                    <div class="card shadow-2-strong">
                                        <div class="card-body p-0">
                                            <div class="table-responsive table-scroll" data-mdb-perfect-scrollbar="true" style="position: relative; height: 700px">
                                                <table class="table table-dark table-hover mb-0">
                                                    <thead style="background-color: #0d6efd;">
                                                    <tr class="text-uppercase text-success">
                                                        <th scope="col">#</th>
                                                        <th scope="col">title</th>
                                                        <th scope="col">description</th>
                                                        <th scope="col">Image</th>
                                                        <th scope="col">price</th>
                                                        <th scope="col">Category</th>
                                                        <th scope="col">Actions</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <c:forEach var="product" items="${products}">
                                                    <tr>
                                                        <td>${product.id}</td>
                                                        <td>${product.title}</td>
                                                        <td>${product.description}</td>
                                                        <td>
                                                            <div class="card-img m-auto">
                                                            <img src="${product.imagePath}" class="img-fluid" width="100" height="100" alt="">
                                                            </div>
                                                        </td>
                                                        <td>${product.price}</td>
                                                        <td>
                                                            ${product.category.categoryName}
                                                        </td>
                                                        <td>
                                                            <div class="d-flex justify-content-center align-content-center">
                                                                <form>
                                                                    <input type="hidden" name="id" value="${product.id}">
                                                                    <button type="submit" formaction="${pageContext.request.contextPath}/products/update-form" class="btn btn-success">Update</button>
                                                                    <button type="submit" formaction="${pageContext.request.contextPath}/products/delete" class="btn btn-danger">delete</button>
                                                                </form>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        </div>
</body>
</html>
