package service.impl;

import bean.Product;
import reponsitory.ProductResponsibility;
import reponsitory.impl.ProductResponsibilityIMPL;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceIMPL implements ProductService {

    private ProductResponsibility productResponsibility = new ProductResponsibilityIMPL();

    @Override
    public List<Product> findAll() {
        return productResponsibility.findAll();
    }

    @Override
    public String save(String name, Integer id, String address, String email) {
        Product product = new Product();
        product.setName(name);
        product.setId(id);
        product.setAddress(address);
        product.setEmail(email);
        productResponsibility.save(product);
        return "thêm thành Công";
    }

    @Override
    public String deleteProduct(Integer id) {
        boolean flag = false;
        List<Product> productList = productResponsibility.findAll();
        for (Product product : productList) {
            if (product.getId().equals(id)){
                flag = true;
                break;
            }
        }
        if (!flag){
            return "không tìm thấy sản phẩm";
        }
        return "Xóa thành công";
    }

    @Override
    public String edit(Integer idKey,String name, Integer id, String address, String email) {
        boolean flag = false;
        List<Product> productList = productResponsibility.findAll();
        for (Product product : productList) {
            if (product.getId().equals(idKey)){
                flag = true;
                break;
            }
        }
        if (!flag){
            return "Id sản phầm cần chỉnh sửa không đúng";
        }
        Product product = new Product();
        product.setName(name);
        product.setId(id);
        product.setAddress(address);
        product.setEmail(email);
        productResponsibility.save(product);

        return "Sửa thành Công";
    }

    @Override
    public  List<Product> showDetail(Integer id) {
        List<Product> productList = productResponsibility.findAll();
        List<Product> product_obj = new ArrayList<>();
        for (Product product : productList) {
            if (product.getId().equals(id)){
                product_obj.add(product);
            }
        }
        return product_obj;
    }

    @Override
    public List<Product> search(String name) {
        List<Product> productList = productResponsibility.findAll();
        List<Product> products =new ArrayList<>();

        for (Product product : productList) {
            if (product.getName().equals(name)){
                products.add(product);
            }
        }
        return products;
    }
}
