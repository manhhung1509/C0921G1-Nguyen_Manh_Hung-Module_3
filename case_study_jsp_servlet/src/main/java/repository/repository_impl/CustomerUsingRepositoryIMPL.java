package repository.repository_impl;

import bean.*;
import repository.BaseRepository;
import repository.CustomerUsingRepository;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerUsingRepositoryIMPL implements CustomerUsingRepository {
    private static final String SELECT_ALL = "SELECT * FROM customer \n" +
            "join contract on customer.customer_id= contract.customer_id\n" +
            "join contract_detail on contract.contract_id= contract_detail.contract_id\n" +
            "join attach_service on contract_detail.attach_service_id= attach_service.attach_service_id\n" +
            "group by customer.customer_id";
    @Override
    public List<ContractDetail> selectAll() {
        List<ContractDetail> customerList = new ArrayList<>();
        try {
            Statement statement = BaseRepository.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL);
            ContractDetail contractDetail = null;
            while(resultSet.next()){
                contractDetail = new ContractDetail();
                contractDetail.setContractDetailId(resultSet.getInt("contract_detail_id"));
                contractDetail.setQuantity(resultSet.getInt("quantity"));
                int customerId = resultSet.getInt("customer_id");
                int customerTypeId = resultSet.getInt("customer_type_id");
                CustomerType customerType = new CustomerType(customerTypeId);
                String customerName = resultSet.getString("customer_name");
                Date customerBirthday = resultSet.getDate("customer_birthday");
                String customerIdCard = resultSet.getString("customer_id_card");
                String customerPhone = resultSet.getString("customer_phone");
                String customerEmail = resultSet.getString("customer_email");
                String customerAddress = resultSet.getString("customer_address");
                String cGender = "";
                if ("1".equals(resultSet.getString("customer_gender"))){
                    cGender= "Male";
                }else{
                    cGender= "Female";
                }
                Customer customer = new Customer(customerId,customerType,customerName,customerBirthday,cGender,customerIdCard,customerPhone,customerEmail,customerAddress);
                Contract contract = new Contract(customer);
                int attachServiceId = resultSet.getInt("attach_service_id");
                String attachServiceName = resultSet.getString("attach_service_name");
                double attachServiceCost = resultSet.getDouble("attach_service_cost");
                String attachServiceUnit = resultSet.getString("attach_service_unit");
                String attachServiceStatus = resultSet.getString("attach_service_status");
                AttachService attachService = new AttachService(attachServiceId,attachServiceName,attachServiceCost,attachServiceUnit,attachServiceStatus);
                contractDetail.setContract(contract);
                contractDetail.setAttachService(attachService);
                customerList.add(contractDetail);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }

//    private static final String INSERT_SQL = "INSERT INTO customer" + "  (name, id_card," +
//            " phone, id_customer_type) VALUES " +
//            " (?, ?, ?, ?);";
//
//    private static final String SELECT_ALL = "SELECT * FROM customer join customer_type" +
//            " on customer_type.id_customer_type= customer.id_customer_type";
//
//    private static final String SELECT_BY_ID = "SELECT customer.id, customer.name, customer.id_card, " +
//            " customer.phone, customer_type.customer_type_name, customer_type.id_customer_type" +
//            " FROM customer join customer_type " +
//            " on customer_type.id_customer_type = customer.id_customer_type " +
//            " where customer.id = ? ";
//
//
//    private static final String DELETE_SQL = "delete from customer where id = ?;";
//
//    private static final String UPDATE_SQL = "update customer set name = ?, id_card = ?," +
//            " phone = ?, id_customer_type = ? where id = ?;";
//
//    public Customer findById(int id) {
//        Customer customer = null;
//        Connection connectionSQL = new ConnectionSQL().getConnection();
//        PreparedStatement preparedStatement = null;
//        try {
//            preparedStatement = connectionSQL.prepareStatement(SELECT_BY_ID);
//            preparedStatement.setInt(1, id);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()){
//                String name = resultSet.getString("name");
//                String idCard = resultSet.getString("id_card");
//                String phone = resultSet.getString("phone");
//                int idCustomerType = resultSet.getInt("id_customer_type");
//                String nameCusType = resultSet.getString("customer_type_name");
//                customer = new Customer(id, name, idCard, phone, new CustomerType(idCustomerType, nameCusType));
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        } finally {
//            ConnectionSQL.close();
//        }
//        return customer;
//    }
//// "delete from customer where id = ?;";
//    public void delete(int id){
//        try {
//            Connection connection = new ConnectionSQL().getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SQL);
//            preparedStatement.setInt(1, id);
//            preparedStatement.executeUpdate();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        } finally {
//            ConnectionSQL.close();
//        }
//    }
//
//    public boolean update(Customer customer) throws SQLException {
//        boolean rowUpdate;
//        try (Connection connection = new ConnectionSQL().getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL)){
//            preparedStatement.setString(1, customer.getName());
//            preparedStatement.setString(2, customer.getIdCard());
//            preparedStatement.setString(3, customer.getPhone());
//            preparedStatement.setInt(4, customer.getCustomerType().getId());
//            preparedStatement.setInt(5, customer.getId());
//            System.out.println(preparedStatement);
//            rowUpdate = preparedStatement.executeUpdate() > 0;
//        }finally {
//            ConnectionSQL.close();
//        }
//        return rowUpdate;
//    }
//
//    public void insert(Customer customer) throws SQLException {
//        try (Connection connection = new ConnectionSQL().getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL)) {
//            preparedStatement.setString(1, customer.getName());
//            preparedStatement.setString(2, customer.getIdCard());
//            preparedStatement.setString(3, customer.getPhone());
//            preparedStatement.setInt(4, customer.getCustomerType().getId());
//            System.out.println(preparedStatement);
//            preparedStatement.executeUpdate();
//        } catch (SQLException ignored) {
//            printSQLException(ignored);
//        } finally {
//            ConnectionSQL.close();
//        }
//    }
//
//    public List<Customer> selectAll() {
//        List<Customer> customerList = new ArrayList<>();
//        Connection connectionSQL = new ConnectionSQL().getConnection();
//        PreparedStatement preparedStatement = null;
//        try {
//             preparedStatement = connectionSQL.prepareStatement(SELECT_ALL);
//             ResultSet resultSet = preparedStatement.executeQuery();
//             while (resultSet.next()){
//                 int id = resultSet.getInt("id");
//                 String name = resultSet.getString("name");
//                 String idCard = resultSet.getString("id_card");
//                 String phone = resultSet.getString("phone");
//                 int idCustomerType = resultSet.getInt("id_customer_type");
//                 String nameCusType = resultSet.getString("customer_type_name");
//                 customerList.add(new Customer(id, name, idCard, phone,
//                         new CustomerType(idCustomerType, nameCusType)));
//             }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        } finally {
//            ConnectionSQL.close();
//        }
//        return customerList;
//    }
//
//    private void printSQLException(SQLException e) {
//    }
}
