package vn.edu.hcmuaf.fit.lab07_listproduct.controller;  import jakarta.servlet.*; import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.lab07_listproduct.dao.model.Product;
import vn.edu.hcmuaf.fit.lab07_listproduct.services.ProductService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListProductController", value = "/list-product")
public class ListProductController extends HttpServlet {
    @Override protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService productService= new ProductService();
        List<Product> data = productService.getAll();
        request.setAttribute("data", data);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    @Override protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
