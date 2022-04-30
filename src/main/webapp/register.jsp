
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New User</title>
    <%@include file="components/common_css_js.jsp"%>
</head>
<body>

    <%@include file="components/navbar.jsp"%>
    <div class="container-fluid">
    <div class="row mt-5">
        <div class="col-md-4 offset-md-4">
            <%@include file="components/message.jsp"%>
          <div class="card">
              <div class=" card-body px-5">
                  <h3 class="text-center my-3 bg-dark bg-custom text-white">Sign Up Here</h3>
                  <form action="RegisterServlet" method="post">
                      <div class="form-group">
                          <label for="name">User Name</label>
                          <input name="user_name" type="name" class="form-control" id="name" aria-describedby="Help" placeholder="Enter value">
                      </div>
                      <div class="form-group">
                          <label for="email">User Email</label>
                          <input name="user_email" type="email" class="form-control" id="email" aria-describedby="Help" placeholder="Enter value">
                      </div>
                      <div class="form-group">
                          <label for="password">User Password</label>
                          <input name="user_password" type="password" class="form-control" id="password" aria-describedby="Help" placeholder="Enter value">
                      </div>
                      <div class="form-group">
                          <label for="phone">Contact</label>
                          <input name="user_phone" type="number" class="form-control" id="phone" aria-describedby="Help" placeholder="Enter value">
                      </div>

                      <div class="form-group">
                          <label for="address">User address</label>
                          <textarea name="user_address" style=" height: 200px" class="form-control" id="address" placeholder="Enter your address"></textarea>
                      </div>

                      <div class="container text-center">
                          <button type= "submit"class="btn btn-outline-success">Register</button>
                          <button type="reset" class="btn btn-outline-warning">Reset</button>
                      </div>

                  </form>
              </div>
          </div>
        </div>
    </div>
    </div>
</body>
</html>
