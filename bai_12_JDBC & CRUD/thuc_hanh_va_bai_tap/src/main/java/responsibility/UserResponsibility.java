package responsibility;

import bean.User;

import java.util.List;

public interface UserResponsibility {

        List<User> findAll();

        void save(User user);

        void deleteUser(Integer id);

        void edit(Integer id, User user);

        Boolean findById( Integer id);

        List<User> findByCountry(String country);

        List<User> sortByName();
}
