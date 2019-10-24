package manager;

import db.DBConnectionProvider;
import models.UserEntity;

import java.sql.*;

public class UserManager {

    private Connection connection;

    public UserManager(){
        connection = DBConnectionProvider.getInstance().getConnection();
    }

//    public List<Number> getNumberr() {
//        PreparedStatement preparedStatement = null;
//        List<Number> userEntitys = new LinkedList<Number>();
//        try {
//            preparedStatement = connection.prepareStatement("SELECT * FROM userEntity");
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()){
//                Number userEntity = new Number();
//                userEntity.setId(resultSet.getInt("id"));
//                userEntity.setOddNumber(resultSet.getInt("odd_userEntity"));
//                userEntity.setEvenNumber(resultSet.getInt("even_userEntity"));
//                userEntitys.add(userEntity);
//            }
//            return  userEntitys;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return  userEntitys;
//    }

    public UserEntity add(UserEntity userEntity)  {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement
                    ("Insert into users(email,first_name, last_name,password) Values(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,userEntity.getEmail());
            statement.setString(2,userEntity.getFirstName());
            statement.setString(3,userEntity.getLastName());
            statement.setString(4,userEntity.getPassword());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()){
                int id = resultSet.getInt(1);
                userEntity.setId(id);
                userEntity.setPicName(resultSet.getString("pic_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userEntity;
    }
}
