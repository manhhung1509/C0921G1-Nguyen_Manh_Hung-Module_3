package reponsitory;

import bean.Product;

import java.util.List;

public interface ProductResponsibility {
    List<Product> findAll();

    void save(Product product);

    void deleteProduct(Integer id);

    void edit(Integer id, Product product);
}
