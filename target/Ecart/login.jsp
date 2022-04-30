
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Login</title>
    <%@include file="components/common_css_js.jsp"%>
</head>
<body>
<%@include file="components/navbar.jsp"%>

<div class="container">
    <div class="row">
        <div class="col-md-6 offset-md-3">

            <div class="card">

                <div class="card-header bg-dark bg-custom text-white" >
                    <h3> Login Here</h3>
                </div>
                <%@include file="components/message.jsp"%>

                <div class="card-body">
                    <form action="LoginServlet" method="post">
                        <div class="form-group">
                            <label for="exampleInputEmail1">Email address</label>
                            <input name="email_user" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Password</label>
                            <input name="password_user" type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                        </div>
                        <div class="container text-center ">
                            <a href="register.jsp" class="text-center d-block mb-3">If not register click here </a>
                            <button type="submit" class="btn btn-primary">Submit</button>
                            <button type="reset" class="btn btn-outline-warning">Reset</button>
                        </div>

                    </form>


                </div>
                <div class="card-footer">

                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
