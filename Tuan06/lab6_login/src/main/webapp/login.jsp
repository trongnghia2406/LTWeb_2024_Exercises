<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login Form</title>
  <%-- Tạo trang login:
 b1: tạo name cho input: name="username"
 b2: tạo method cho form, action (nơi dữ liệu gửi tới): method="post", action="login"
 b3: tạo controller (pakage controller) => new Servlet
 b4: đổi value = /login (trùng với action của form). Khi này dữ liệu bên login.jsp nhập vào
 form sẽ được gửi qua servlet để xử lí
 b5: tạo package services => AuthService, tạo hàm checkLogin
 b6: cần lớp dao truy cập csdl, new pakage dao, tạo class userdao
 b7: tạo pakage model, chứa class user implemenet serializable
 b8: triển khai hàm checklogin, triển khai xác thực user trong logincontroller (Dùng authservice) - hàm do post
 b9: triển khai báo lỗi trong controller,
 b10: triển khai string error trong login.jsp nhớ đặt value="<%= username %>"

  --%>
  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container d-flex justify-content-center align-items-center vh-100">
  <div class="card p-4 shadow" style="max-width: 400px; width: 100%;">
    <h2 class="text-center mb-4">Login</h2>
<%-- thông báo lỗi --%>
    <%
      String error = (String) request.getAttribute("error");
      String username = request.getParameter("username");
      if (error == null) error = "";
      if (username == null) username = "";
    %>
    <p><%= error %></p>
    <form method="post" action="login">
      <!-- Username Field -->
      <div class="mb-3">
        <label for="username" class="form-label">Username</label>
        <input type="text" class="form-control" id="username" placeholder="Enter your username" value="<%= username %>" name="username" required>
      </div>

      <!-- Password Field -->
      <div class="mb-3">
        <label for="password" class="form-label">Password</label>
        <input type="password" class="form-control" id="password" placeholder="Enter your password" name="password" required>
      </div>

      <!-- Remember Me Checkbox -->
      <div class="mb-3 form-check">
        <input type="checkbox" class="form-check-input" id="rememberMe">
        <label class="form-check-label" for="rememberMe">Remember me</label>
      </div>

      <!-- Submit Button -->
      <button type="submit" class="btn btn-primary w-100">Login</button>
    </form>
  </div>
</div>

<!-- Bootstrap JavaScript Bundle (includes Popper) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
