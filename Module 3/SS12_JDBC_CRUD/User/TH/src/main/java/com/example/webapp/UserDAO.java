package com.example.webapp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {

    private String URL = "jdbc:mysql://localhost:3306/demo";
    private String USERNAME = "root";
    private String PASSWORD = "0905775514";
    private static final String INSERT = "insert into users" + "(name,email,country) values(?,?,?);";
    private static final String SELECT_BY_ID = " select * from users where users.id = ?; ";
    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String DELETE = "delete from users where id=?;";
    private static final String UPDATE = "update users set users.name=?,users.email=?,users.country=? where id=?;";
    private static final String SEARCH = "select * from users where users.country =?;";
    private static final String SORT = "select * from users order by users.name asc;";
    private static final String SELECT_ALL_SP="call find_all();";
   // Gọi Stored Procedures từ JDBC sử dụng CallableStatement cho chức năng sửa thông tin user
    private static final String UPDATE_SP="CALL updateInfo(?,?,?,?);";
    //Gọi Stored Procedures từ JDBC sử dụng CallableStatement cho chức năng xoá user
    private static final String DELETE_SP="call deleteUser(?);";

    //Gọi Stored Procedures từ JDBC sử dụng CallableStatement cho chức năng tìm user theo id
    private static final String SELECT_BY_ID_SP ="call find_user_by_id(?);";
    //Gọi Stored Procedures từ JDBC sử dụng CallableStatement cho chức năng thêm mới user


    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void insertUser(User user) {
        System.out.println(INSERT);
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public List<User> search(String COUNTRY) {
        List<User> userList=new ArrayList<>();
        User user = null;
        Connection connection = getConnection();
        Statement statement = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH);

            preparedStatement.setString(1, COUNTRY);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                user = new User(id, name, email, country);
            userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return userList;
    }

    @Override
    public List<User> sort() {
        List<User> userList=new ArrayList<>();
        User user=null;
        Connection connection=getConnection();
            try {
                PreparedStatement preparedStatement=connection.prepareStatement(SORT);
                ResultSet rs=preparedStatement.executeQuery();
                while(rs.next()){
                    int id=rs.getInt("id");
                    String name=rs.getString("name");
                    String email=rs.getString("email");
                    String country=rs.getString("country");
                    user = new User(id,name,email,country);
                    userList.add(user);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        return userList;
    }

    @Override
    public List<User> selectAllUsers() {
//        List<User> users = new ArrayList<>();
//        Connection connection = getConnection();
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);
//            System.out.println(preparedStatement);
//
//            ResultSet rs = preparedStatement.executeQuery();
//
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//                String email = rs.getString("email");
//                String country = rs.getString("country");
//                users.add(new User(id, name, email, country));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return users;
        List<User> list=new ArrayList<>();
        Connection connection=getConnection();
        User user;
        try {
            CallableStatement callableStatement=connection.prepareCall(SELECT_ALL_SP);
            ResultSet rs=callableStatement.executeQuery();
            while(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String email=rs.getString("email");
                String country=rs.getString("country");
                user =new User(id,name,email,country);
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
//        boolean rowDeleted;
//        Connection connection = getConnection();
//        PreparedStatement statement = connection.prepareStatement(DELETE);
//        statement.setInt(1, id);
//        rowDeleted = statement.executeUpdate() > 0;
//        return rowDeleted;
        boolean rowDeleted;
        Connection connection=getConnection();
        CallableStatement callableStatement=connection.prepareCall(DELETE_SP);
        callableStatement.setInt(1,id);
        rowDeleted =callableStatement.executeUpdate()>0;
        return rowDeleted;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
//        boolean rowUpdated;
//        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE);) {
//            statement.setString(1, user.getName());
//            statement.setString(2, user.getEmail());
//            statement.setString(3, user.getCountry());
//            statement.setInt(4, user.getId());
//            rowUpdated = statement.executeUpdate() > 0;
//        }
//        return rowUpdated;
        boolean rowUpdated;
        Connection connection =getConnection();
        CallableStatement callableStatement=connection.prepareCall(UPDATE_SP);
//        CALL updateInfo(7,"Lan","lan@gmail.com","NewYork");
        callableStatement.setInt(1,user.getId());
        callableStatement.setString(2,user.getName());
        callableStatement.setString(3, user.getEmail());
        callableStatement.setString(4, user.getCountry());
         rowUpdated = callableStatement.executeUpdate()>0;
         return rowUpdated;
    }



    public User selectUser(int id) {
        User user = null;
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                user = new User(id, name, email, country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }



    @Override
    public List<User> selectUserID(int id) {
//        User user = null;
//        Connection connection = getConnection();
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
//            preparedStatement.setInt(1, id);
//            System.out.println(preparedStatement);
//            ResultSet rs = preparedStatement.executeQuery();
//            while (rs.next()) {
//                String name = rs.getString("name");
//                String email = rs.getString("email");
//                String country = rs.getString("country");
//                user = new User(id, name, email, country);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return user;
        Connection connection=getConnection();
        List<User> list=new ArrayList<>();
        CallableStatement callableStatement= null;
        try {
            callableStatement = connection.prepareCall(SELECT_BY_ID_SP);
            callableStatement.setInt(1,id);
            ResultSet rs=callableStatement.executeQuery();
            while(rs.next()){
                String name=rs.getString("name");
                String email=rs.getString("email");
                String country=rs.getString("country");
                User user =new User(id,name,email,country);
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        UserDAO user =new UserDAO();
        System.out.println(user.search("VietNam"));
    }


    @Override
    public void addUserTransaction(User user, int[] permision) {
        Connection connection=null;
        PreparedStatement preparedStatement= null;
        PreparedStatement assignment=null;
        ResultSet rs =null;

        try {
            connection=getConnection();
            connection.setAutoCommit(false);
            preparedStatement=connection.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.setString(3,user.getCountry());
            int rowEffect=preparedStatement.executeUpdate();
            rs=preparedStatement.getGeneratedKeys();
            int userID=0;
            if(rs.next()){
                userID=rs.getInt(1);
                if(rowEffect==1){
                    String sqlPivot="insert into user_permision(id_user,id_permision) values (?,?);";
                    assignment=connection.prepareStatement(sqlPivot);
                    for(int permisionID: permision){
                        assignment.setInt(1,userID);
                        assignment.setInt(2,permisionID);
                        assignment.executeUpdate();

                    }
                    connection.commit();
                } else {
                    connection.rollback();
                }
            }
        } catch (SQLException e) {
            try {

                if (connection != null)

                    connection.rollback();

            } catch (SQLException ex) {

                System.out.println(ex.getMessage());

            }

            System.out.println(e.getMessage());
        }
        finally {
            try {

                if (rs != null) rs.close();

                if (preparedStatement != null) preparedStatement.close();

                if (assignment != null) assignment.close();

                if (connection != null) connection.close();

            } catch (SQLException e) {

                System.out.println(e.getMessage());

            }
        }
    }

}
