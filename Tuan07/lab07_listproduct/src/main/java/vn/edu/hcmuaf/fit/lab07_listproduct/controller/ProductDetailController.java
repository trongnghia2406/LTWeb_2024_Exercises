package vn.edu.hcmuaf.fit.lab07_listproduct.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.lab07_listproduct.dao.model.Product;
import vn.edu.hcmuaf.fit.lab07_listproduct.services.ProductService;

import java.io.IOException;

@WebServlet(name = "ProductDetailController", value = "/product")
public class ProductDetailController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // mọi thứ gửi trong post và get đều lấy ra theo hàm getParameter()
        // lấy id sản phẩm
        String id = request.getParameter("id");
        ProductService service  = new ProductService();
        Product detail = service.getDetail(id);
        request.setAttribute("p", detail);
        request.getRequestDispatcher("product-detail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}