package responsibility.impl;

import bean.User;
import responsibility.BaseRepository;
import responsibility.UserResponsibility;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserResponsibilityIMPL implements UserResponsibility {
    private static final String INSERT_USERS_SQL = "INSERT INTO users (name, email, country) VALUES (?, ?, ?);";
    private static final String SELECT_FIND_BY_ID = "select id from users where id =?";
    private static final String SELECT_FIND_BY_COUNTRY = "select id, name, email, country from users where country =?";
    private static final String SELECT_ALL_USERS = "select id, name, email, country from users";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";
    private static final String SORT_BY_NAME = "select id, name, email, country from users order by name";

    @Override
    public List<User> findAll() {
        List<User>users = new ArrayList<>();
        try {
            Statement statement = BaseRepository.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_USERS);
            User user = null;
            while(resultSet.next()){
                user = new User();
                    user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));
                users.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }

    @Override
    public void save(User user) {
        try {
            PreparedStatement preparedStatement = BaseRepository.connection.prepareStatement(INSERT_USERS_SQL);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteUser(Integer id) {
        try {
            PreparedStatement preparedStatement = BaseRepository.connection.prepareStatement(DELETE_USERS_SQL);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void edit(Integer id, User user) {
        try {
            PreparedStatement preparedStatement = BaseRepository.connection.prepareStatement(UPDATE_USERS_SQL);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Boolean findById(Integer id) {
        Integer id_data = 0;
        try {
            PreparedStatement pstmt = BaseRepository.connection.prepareStatement(SELECT_FIND_BY_ID);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                id_data = Integer.parseInt(rs.getString("id"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        if (id_data.equals(id)){
          return true;
        }else {
            return false;
        }
    }

    @Override
    public List<User> findByCountry(String country) {
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement pstmt = BaseRepository.connection.prepareStatement(SELECT_FIND_BY_COUNTRY);
            pstmt.setString(1, country);
            ResultSet rs = pstmt.executeQuery();
            User user = null;
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setCountry(rs.getString("country"));
                users.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }

    @Override
    public List<User> sortByName() {
        List<User>users = new ArrayList<>();
        try {
            Statement statement = BaseRepository.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SORT_BY_NAME);
            User user = null;
            while(resultSet.next()){
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));
                users.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }
}
