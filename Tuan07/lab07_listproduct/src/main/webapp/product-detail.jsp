<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Chi Tiết Sản Phẩm</title>
  <link rel="stylesheet">
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f4f4;
      margin: 0;
      padding: 0;
    }

    header {
      background-color: #333;
      color: white;
      padding: 20px;
      text-align: center;
    }

    .product-detail {
      display: flex;
      justify-content: center;
      padding: 30px;
    }

    .product-image {
      flex: 1;
      text-align: center;
    }

    .product-image img {
      width: 80%;
      max-width: 500px;
      border-radius: 10px;
    }

    .product-info {
      flex: 1;
      padding-left: 20px;
      max-width: 600px;
    }

    .product-info h2 {
      font-size: 28px;
      color: #333;
      margin-bottom: 10px;
    }

    .product-info p {
      font-size: 18px;
      color: #555;
      line-height: 1.6;
      margin-bottom: 20px;
    }

    .product-info .price {
      font-size: 24px;
      color: #e74c3c;
      font-weight: bold;
      margin-bottom: 20px;
    }

    .product-info .add-to-cart {
      background-color: #3498db;
      color: white;
      border: none;
      padding: 15px 25px;
      font-size: 18px;
      border-radius: 5px;
      cursor: pointer;
      transition: background-color 0.3s;
    }

    .product-info .add-to-cart:hover {
      background-color: #2980b9;
    }

    footer {
      background-color: #333;
      color: white;
      text-align: center;
      padding: 10px;
      position: fixed;
      bottom: 0;
      width: 100%;
    }
  </style>
</head>
<body>

<!-- Header -->
<header>
  <h1>Chi Tiết Sản Phẩm</h1>
</header>

<!-- Product Detail Section -->
<div class="product-detail">
  <!-- Product Image -->
  <div class="product-image">
    <img src="${p.img}" alt="Áo Thun Nam">
  </div>

  <!-- Product Info -->
  <div class="product-info">
    <h2>${p.title}</h2>
    <p></p>
    <p class="price"><f:formatNumber value="${p.price}" /></p>
    <button class="add-to-cart">Thêm vào giỏ</button>
  </div>
</div>

<!-- Footer -->
<footer>
  <p>&copy; 2024 Cửa Hàng Quần Áo. Tất cả quyền được bảo lưu.</p>
</footer>

</body>
</html>
