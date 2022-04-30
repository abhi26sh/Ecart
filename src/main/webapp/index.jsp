<%@ page import="com.abhi.utils.HibernateUtils" %>
<%@ page import="com.abhi.entities.Product" %>
<%@ page import="com.abhi.entities.Category" %>
<%@ page import="com.abhi.dao.ProductDao" %>
<%@ page import="java.util.List" %>
<%@ page import="com.abhi.dao.CategoryDao" %>
<%@ page import="com.abhi.utils.Helper" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Ecart</title>

    <%@include file="components/common_css_js.jsp"%>
</head>
<body>
<%@include file="components/navbar.jsp"%>
<div class="container-fluid">
    <div class="row mt-3 mx-2">

        <%
            String cat = request.getParameter("category");
            //out.println(cat);
            ProductDao dao = new ProductDao();
            List<Product> list = null;
            if (cat == null || cat.trim().equals("all")) {
                list = dao.getAllProducts();
            } else {
                int cid = Integer.parseInt(cat.trim());
                list = dao.getAllProductsById(cid);
            }
            CategoryDao cdao = new CategoryDao();
            List<Category> clist = cdao.getCategories();
        %>



        <!--show categories-->
        <div class="col-md-2">


            <div class="list-group mt-4">

                <a href="index.jsp?category=all" class="list-group-item list-group-item-action active">
                    Categories
                </a>

                <% for (Category c : clist) {
                %>



                <a href="index.jsp?category=<%= c.getCategoryId()%>" class="list-group-item list-group-item-action"><%= c.getCategoryName()%></a>


                <%    }
                %>



            </div>


        </div>

        <!--show products-->
        <div class="col-md-10">


            <!--row-->
            <div class="row mt-4">

                <!--col:12-->
                <div class="col-md-12">

                    <div class="card-columns">

                        <!--traversing products-->

                        <%
                            for (Product p : list) {
                        %>


                        <!--product card-->
                        <div class="card product-card">

                            <div class="container text-center">
                                <img src="img/products/<%= p.getpPhoto()%>" style="max-height: 200px;max-width: 100%;width: auto; " class="card-img-top m-2" alt="...">

                            </div>

                            <div class="card-body">

                                <h5 class="card-title"><%= p.getPname()%></h5>

                                <p class="card-text">

                                    <%= Helper.get5Words(p.getpDesc())%>

                                </p>

                            </div>

                            <div class="card-footer text-center">
                                <button class="btn bg-dark custom-bg text-white" onclick="add_to_cart(<%= p.getpId()%>, '<%= p.getPname()%>',<%= p.getPriceAfterDis()%>)">Add to Cart</button>
                                <button class="btn  btn-outline-success ">  &#8377; <%= p.getPriceAfterDis()%>/-  <span class="text-secondary discount-label">  &#8377; <%= p.getpPrice()%> , <%= p.getpDiscount()%>% off </span>  </button>

                            </div>



                        </div>

                        <%}
                            if (list.size() == 0) {
                                out.println("<h3>No item in this category</h3>");
                            }
                        %>




                    </div>



                </div>

            </div>



        </div>

    </div>
</div>

<%@include  file="components/modals.jsp" %>

</body>
</html>
