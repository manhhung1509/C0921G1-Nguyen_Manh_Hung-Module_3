package service.impl;

import bean.User;
import responsibility.UserResponsibility;
import responsibility.impl.UserResponsibilityIMPL;
import service.UserService;

import java.util.ArrayList;
import java.util.List;

public class UserServiceIMPL  implements UserService {

    private UserResponsibility userResponsibility = new UserResponsibilityIMPL();

    @Override
    public List<User> findAll() {
        List<User> users = userResponsibility.findAll();
        return users;
    }

    @Override
    public String save(String name, String email, String country) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setCountry(country);
        userResponsibility.save(user);
        return "thêm thành Công";
    }

    @Override
    public String deleteProduct(Integer id) {
        if (userResponsibility.findById(id) == true){
            userResponsibility.deleteUser(id);
            return "Xóa thành Công";
        }else{
            return "không tìm thấy sản phẩm";
        }
    }

    @Override
    public String edit(Integer idKey, String name, String email, String country) {
        if (userResponsibility.findById(idKey) == true){
            User user = new User();
            user.setName(name);
            user.setEmail(email);
            user.setCountry(country);
            userResponsibility.edit(idKey,user);

            return "Sửa thành Công";
        }else{
            return "Id user cần chỉnh sửa không đúng";
        }
    }

    @Override
    public List<User> finByCountry(String country) {
        List<User> users = userResponsibility.findByCountry(country);
        return users;
    }

    @Override
    public List<User> sortByName() {
        List<User> users = userResponsibility.sortByName();
        return users;
    }


//
//    @Override
//    public List<User> search(String name) {
//        List<User> listUsers = userResponsibility.findAll();
//        List<User> users =new ArrayList<>();
//
//        for (User user : listUsers) {
//            if (user.getName().equals(name)){
//                users.add(user);
//            }
//        }
//        return users;
//    }
}

