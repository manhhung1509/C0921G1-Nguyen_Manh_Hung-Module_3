package service;


import bean.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    String save(String name, String email, String country);

    String deleteUser(Integer id);

    void edit(Integer idKey,String name, String email, String country);

    List<User>  finByCountry(String country);

    List<User> sortByName();
}