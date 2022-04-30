
<%@ page import="com.abhi.entities.Users" %>
<%@ page import="com.abhi.dao.CategoryDao" %>
<%@ page import="java.util.List" %>
<%@ page import="com.abhi.entities.Category" %>
<%
    Users user= (Users)session.getAttribute("curr_user");

    if(user==null)
    {
        session.setAttribute("message","you are not loggedin login first");
        response.sendRedirect("login.jsp");
    }else {
        if (user.getUserType().equals("normal")) {
            session.setAttribute("message", "you are not authorized to access admin page ");
            response.sendRedirect("login.jsp");
            return;
        }
    }

%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Page</title>
    <%@include file="components/common_css_js.jsp"%>
</head>
<body>
<%@include file="components/navbar.jsp"%>

    <div class="container admin ">

        <div class="container-fluid">
            <%@include file="components/message.jsp"%>
        </div>

        <div class="row mt-3">
            <div class="col-md-4">
                <div class="card">

                    <div class="card-body text-center">

                        <h1 class="text-uppercase text-muted">USERS</h1>
                        <h2>2333</h2>
                    </div>
                </div>
            </div>

            <div class="col-md-4">
                <div class="card">

                    <div class="card-body text-center">

                        <h1 class="text-uppercase text-muted">CATEGORIES</h1>
                        <h2>100</h2>
                    </div>
                </div>
            </div>


            <div class="col-md-4">
                <div class="card">

                    <div class="card-body text-center">

                        <h1 class="text-uppercase text-muted">PRODUCTS</h1>
                        <h2>500</h2>
                    </div>
                </div>
            </div>
        </div>

        <div class="row mt-3">
            <div class="col-md-6">
                <div class="card " data-toggle="modal" data-target="#add-category-model">

                    <div class="card-body text-center">

                        <p> Click here to add a new category</p>
                        <h1 class="text-uppercase text-muted">add categories</h1>
                    </div>
                </div>
            </div>

            <div class="col-md-6">
                <div class="card" data-toggle="modal" data-target="#add-product-model">

                    <div class="card-body text-center">

                        <p> Click here to add a new product</p>
                        <h1 class="text-uppercase text-muted">add product</h1>
                    </div>
                </div>
            </div>



        </div>
    </div>



<!-- Modal -->
<div class="modal fade" id="add-category-model" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header bg-custom text-white">
                <h5 class="modal-title" id="exampleModalLabel">Fill category details</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form action="ProductOperationServlet" method="post">
                    <div class="form-group">
                        <input type="hidden" name="operation" value="add_category">
                        <input type="text" class="form-control" name="catTitle" placeholder="Enter category title" required/>
                    </div>

                    <div class="form-group">

                        <textarea style="height: 300px" class="form-control "  name="catDescription" placeholder="Enter category description" required></textarea>
                    </div>

                    <div class="container text-center ">
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<!--   **************************************************product modal*********************************************************************************     -->

<div class="modal fade" id="add-product-model" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header bg-custom text-white">
                <h5 class="modal-title" id="productModalLabel">Fill Product details</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form action="ProductOperationServlet" method="post" enctype="multipart/form-data">
                    <input type="hidden" name="operation" value="add_product">
                    <div class="form-group">

                        <input type="text" class="form-control" name="proTitle" placeholder="Enter product title" required/>
                    </div>
<!--   product desc-->
                    <div class="form-group">

                        <textarea style="height: 150px" class="form-control "  name="proDescription" placeholder="Enter product description" required></textarea>
                    </div>
                    <!--   product price-->
                    <div class="form-group">

                        <input type="number" class="form-control" name="proPrice" placeholder="Enter product Price" required/>
                    </div>

                    <!--   product discount-->

                    <div class="form-group">

                        <input type="number" class="form-control" name="proDis" placeholder="Enter product discount" required/>
                    </div>

                    <!--   product quantity-->

                    <div class="form-group">

                        <input type="number" class="form-control" name="proQuantity" placeholder="Enter product quantity" required/>
                    </div>

                    <!--   product category-->
                    <%
                        CategoryDao cd= new CategoryDao();
                        List<Category> list=cd.getCategories();
                    %>

                    <div class="form-group">

                        <select class="form-control" name="catid" id="">
                            <%
                                for (Category c:
                                     list) {%>
                            <option value="<%=c.getCategoryId()%>"><%=c.getCategoryName()%></option>
                            <%
                                }

                            %>

                        </select>
                    </div>

                    <div class="form-group">
                        <label for="pPic">Select picture of product</label>
                        <br>
                        <input type="file" id="pPic" name="pPic" required>
                    </div>


                    <div class="container text-center ">
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>



</body>
</html>
