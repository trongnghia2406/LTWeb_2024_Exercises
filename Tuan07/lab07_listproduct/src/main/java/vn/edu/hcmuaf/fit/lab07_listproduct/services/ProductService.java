package vn.edu.hcmuaf.fit.lab07_listproduct.services;

import vn.edu.hcmuaf.fit.lab07_listproduct.dao.ProductDao;
import vn.edu.hcmuaf.fit.lab07_listproduct.dao.model.Product;

import java.util.List;

public class ProductService {
    static ProductDao productDao= new ProductDao();

    public List<Product> getAll(){
        return productDao.getAll();
    }

    public Product getDetail(String in) {
        try {
            int id = Integer.parseInt(in);
            return productDao.getById(id);
        }catch (NumberFormatException e){
            return null;
        }
    }
}
