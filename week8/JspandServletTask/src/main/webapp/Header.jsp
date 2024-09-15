<header>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark bg-body-tertiary">
        <div class="container-fluid">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/products">Product List</a>
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/products/manage">Manage</a>
                </li>
            </ul>
            <form class="d-flex input-group w-auto" >
                <input
                        type="search"
                        class="form-control"
                        placeholder="Type query"
                        aria-label="Search"
                        name="query"
                />
                <button
                        data-mdb-ripple-init
                        class="btn btn-outline-primary"
                        type="submit"
                        data-mdb-ripple-color="dark"
                        formaction="${pageContext.request.contextPath}/products/search"
                >
                    Search
                </button>
            </form>
        </div>
    </nav>
</header>