<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="vi">
<%-- Tạo trang list product
b1: tạo class Product implement Serializeble, có các thuộc tính, gettersetter,
constructor rỗng và ko rỗng
b2: tạo productdao, hiện dùng dữ liệu cứng trong map
b3: hàm getAll lấy ra tất cả sản phẩm, getById lấy thông tin của từng sản phẩm
b4: tạo listproductcontroller, đổi value list-product để dễ nhìn, gọi
request.getRequestDispatcher("list-product.jsp").forward(request, response); để gửi
dữ liệu qua trang list-product.jsp (ở đây là index.jsp)
b5: tạo productservice: productdao dùng để lấy dữ liệu, productservice dùng để xử lí
b6: qua controller gọi productservice, gọi hàm getall, đưa dữ liệu vào request
b7: tìm jstl, past vào file pom.xml, reload maven
b8: tìm jstl core, copy paste vào trang list product (ở đây là index.jsp)
b9: xóa hết sản phẩm, để lại 1sp duy nhất, dùng vòng lặp for lặp qua tất cả sản phẩm
để hiển thị tất cả sản phẩm ra
b10: tạo trang productdetail, đưa vào href của button chuyển hướng
b11: tạo controller cho productdetail, tạo điều hướng đúng id sản phẩm được chọn
b12: qua productlist đặt href="product?id=${p.id}" để đi tới đúng id sản phẩm
b13: hiển thị lại thông tin trên trang productdetail cho đúng

--%>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cửa Hàng Quần Áo</title>
    <link rel="stylesheet" href="styles.css">
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

        header h1 {
            margin: 0;
        }

        .search-bar input {
            width: 80%;
            padding: 10px;
            margin-top: 10px;
            font-size: 16px;
        }

        .products {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            padding: 20px;
        }

        .product-item {
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            margin: 15px;
            width: 200px;
            padding: 15px;
            text-align: center;
            transition: transform 0.3s;
        }

        .product-item:hover {
            transform: scale(1.05);
        }

        .product-item img {
            width: 100%;
            height: auto;
            border-radius: 8px;
        }

        .product-item h3 {
            font-size: 18px;
            margin: 10px 0;
        }

        .product-item .price {
            font-size: 16px;
            color: #e74c3c;
            margin-bottom: 15px;
        }

        .product-item .add-to-cart {
            background-color: #3498db;
            color: white;
            border: none;
            padding: 10px 20px;
            font-size: 16px;
            border-radius: 5px;
            cursor: pointer;
        }

        .product-item .add-to-cart:hover {
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
    <h1>Cửa Hàng Quần Áo</h1>
    <div class="search-bar">
        <input type="text" placeholder="Tìm kiếm sản phẩm...">
    </div>
</header>

<!-- Main Content: Products -->
<main>
    <section class="products">
        <!-- Product 1 -->
        <c:forEach var="p" items="${data}">
            <div class="product-item">
                <img src="${p.img}" alt="Áo Thun Nam">
                <h3>${p.title}</h3>
                <p class="price"><f:formatNumber currencySymbol="đ"  value="${p.price}"/></p>
                <a href="product?id=${p.id}"><button class="add-to-cart" style="background-color: darkorange">Chi tiết</button></a>
                <button class="add-to-cart">Thêm vào giỏ</button>
            </div>
        </c:forEach>

    </section>
</main>

<!-- Footer -->
<footer>
    <p>&copy; 2024 Cửa Hàng Quần Áo. Tất cả quyền được bảo lưu.</p>
</footer>

</body>
</html>