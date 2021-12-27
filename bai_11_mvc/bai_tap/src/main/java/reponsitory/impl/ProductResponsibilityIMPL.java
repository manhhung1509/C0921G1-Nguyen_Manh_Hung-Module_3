package reponsitory.impl;

import bean.Product;
import reponsitory.ProductResponsibility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductResponsibilityIMPL implements ProductResponsibility {
    private static Map<Integer, Product> product;

    static {
        product = new HashMap<>();
        product.put(1, new Product("John", 1, "john@codegym.vn", "Hanoi"));
        product.put(2, new Product("Bill", 2, "bill@codegym.vn", "Danang"));
        product.put(3, new Product("Alex", 3, "alex@codegym.vn", "Saigon"));
        product.put(4, new Product("Adam", 4, "adam@codegym.vn", "Beijin"));
        product.put(5, new Product("Adam", 5, "sophia@codegym.vn", "Miami"));
        product.put(6, new Product("Rose", 6, "rose@codegym.vn", "Newyork"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(product.values());
    }

    @Override
    public void save(Product product) {
        ProductResponsibilityIMPL.product.put(product.getId(), product);
    }

    @Override
    public void deleteProduct(Integer id) {

    }

    @Override
    public void edit(Integer id, Product product) {

    }
}
