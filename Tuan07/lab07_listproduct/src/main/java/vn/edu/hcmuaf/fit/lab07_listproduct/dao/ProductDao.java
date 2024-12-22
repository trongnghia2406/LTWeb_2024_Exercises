package vn.edu.hcmuaf.fit.lab07_listproduct.dao;

import org.jdbi.v3.core.Jdbi;
import vn.edu.hcmuaf.fit.lab07_listproduct.dao.db.DBConnect;
import vn.edu.hcmuaf.fit.lab07_listproduct.dao.db.JdbiConnect;
import vn.edu.hcmuaf.fit.lab07_listproduct.dao.model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
lab8: database
 * Tạo dssp liên kết tới database
 * 1. tạo file db.properties trong resources
 * 2. tạo class DBProperties trong db
 * 3. tạo class DBConnect trong db
 * 4. Nhớ thêm dependencies mysql, reload maven (chuột phải project, maven, reload maven)
 * 5. Tạo dữ liệu cho database
 * 6. thực hiện result set để lấy dữ liệu
 * 7. Triển khai các hàm get trong product Dao
 -> tới đây có thể hoàn thành load dữ liệu lên với jdbc
 TRIỂN KHAI VỚI JDBI
 1. search maven repository, search jdbicore, jdbi3core, cái mới nhất, copy dependencies
 2. paste vào file pom.xml, reload maven
 3. Tạo class JDBI Connect trong db
 4. copy chỉnh sửa hàm getall, getbyid trong productdao cho phù hợp với jdbi
 * */
public class ProductDao {

    static Map<Integer, Product> data = new HashMap<>();

    static {
//        data.put(1, new Product(1, "Áo Thun Nam T1", 300000, "https://product.hstatic.net/1000197303/product/pro_xam_01_1_ce28be9e7c2341adbe4831cc27b7a3bf_grande.jpg"));
//        data.put(2, new Product(2, "Áo Sơ Mi Nữ T1", 450000, "https://product.hstatic.net/1000197303/product/pro_den_1_d7bcfaf8be9044188091392122c74153_grande.jpg"));
//        data.put(3, new Product(3, "Áo Polo Nam", 400000, "https://product.hstatic.net/1000197303/product/pro_da_01_2_fbab52be715148d6b4f8f88c82825e2b_grande.jpg"));
//        data.put(4, new Product(4, "Váy Liền Nữ T1", 350000, "https://product.hstatic.net/1000197303/product/pro_xanh_duong_01_1_885439296bc14e52a9edab153308517a_grande.jpg"));
//        data.put(5, new Product(5, "Quần Jean Nam T1", 500000, "https://product.hstatic.net/1000197303/product/pro_xanh_duong_2_cee0752f029441a4a41634667ed9afbd_grande.jpg"));
//        data.put(6, new Product(6, "Áo Sơ Mi Kẻ T1", 550000, "https://product.hstatic.net/1000197303/product/pro_den_1_d7bcfaf8be9044188091392122c74153_grande.jpg"));
//        data.put(7, new Product(7, "Áo Khoác Nam T1", 750000, "https://product.hstatic.net/1000197303/product/pro_da_01_2_fbab52be715148d6b4f8f88c82825e2b_grande.jpg"));
//        data.put(8, new Product(8, "Váy Dự Tiệc Nữ T1", 900000, "https://product.hstatic.net/1000197303/product/pro_den_1_d7bcfaf8be9044188091392122c74153_grande.jpg"));
//        data.put(9, new Product(9, "Quần Tây Nữ T1", 600000, "https://product.hstatic.net/1000197303/product/pro_xanh_duong_01_1_885439296bc14e52a9edab153308517a_grande.jpg"));
//        data.put(10, new Product(10, "Áo Len Nam T1", 650000, "https://product.hstatic.net/1000197303/product/pro_da_01_2_fbab52be715148d6b4f8f88c82825e2b_grande.jpg"));
//        data.put(11, new Product(11, "Áo Hoodie T1", 700000, "https://product.hstatic.net/1000197303/product/pro_den_1_d7bcfaf8be9044188091392122c74153_grande.jpg"));
//        data.put(12, new Product(12, "Quần Short Nữ T1", 250000, "https://product.hstatic.net/1000197303/product/pro_xanh_duong_2_cee0752f029441a4a41634667ed9afbd_grande.jpg"));
//        data.put(13, new Product(13, "Váy Đầm Dài T1", 800000, "https://product.hstatic.net/1000197303/product/pro_xanh_duong_01_1_885439296bc14e52a9edab153308517a_grande.jpg"));
//        data.put(14, new Product(14, "Áo Thun Trơn T1", 280000, "https://product.hstatic.net/1000197303/product/pro_da_01_2_fbab52be715148d6b4f8f88c82825e2b_grande.jpg"));
//        data.put(15, new Product(15, "Quần Kaki Nam T1", 420000, "https://product.hstatic.net/1000197303/product/pro_den_1_d7bcfaf8be9044188091392122c74153_grande.jpg"));
    }

    public List<Product> getAll() {
//        return new ArrayList<>(data.values()); // lab 7: hard code
        // lab8: database: jdbc
//        Statement statement = DBConnect.get();
//        ResultSet rs = null;
//        ArrayList<Product> re = new ArrayList<>();
//        try {
//            rs = statement.executeQuery("select  * from products");
//
//            while (rs.next()) {
//                re.add(new Product(rs.getInt(1), rs.getString(2),
//                rs.getDouble(3), rs.getString(4)));
//            }
//            return re;
//        } catch (SQLException e) {
//            return re;
//        }

        // lab8: jdbi
        Jdbi jdbi = JdbiConnect.get();
        return jdbi.withHandle(handle -> handle.createQuery("select * from products").mapToBean(Product.class).list());
            // vì product viết đã là bean
    }

    public Product getById(int id) {
        // lab7: hard code
//        if (!data.containsKey(id)) return null;
//        return data.get(id);

        //lab8: database: jdbc
//        Statement statement = DBConnect.get();
//        ResultSet rs = null;
//        try {
//            rs = statement.executeQuery("select  * from products");
//
//            if (rs.next()) {
//                return new Product(rs.getInt(1), rs.getString(2),
//                        rs.getDouble(3), rs.getString(4));
//            }
//            return null;
//        } catch (SQLException e) {
//            return null;
//        }
        //lab8: jdbi
        Jdbi jdbi = JdbiConnect.get();
        return jdbi.withHandle(handle ->
                handle.createQuery("select * from products where id = :id")
                        .bind("id", id)
                        .mapToBean(Product.class).findOne().orElse(null));
        // trả về product, ko có trả về null
    }

    public static void main(String[] args) {
        data.values().forEach(System.out::println);
    }
}
