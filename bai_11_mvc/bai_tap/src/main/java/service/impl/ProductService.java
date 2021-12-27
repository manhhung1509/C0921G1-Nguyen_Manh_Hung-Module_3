package service.impl;

import bean.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    String save(String name, Integer id, String address, String email);

    String deleteProduct(Integer id);

    String edit(Integer idKey,String name, Integer id, String address, String email);

    List<Product> showDetail(Integer id);

    List<Product> search(String name);
}
