package ru.kpfu.ibragimov.dao.impl;

import ru.kpfu.ibragimov.dao.IUserDAO;
import ru.kpfu.ibragimov.helper.PasswordHelper;
import ru.kpfu.ibragimov.helper.PostgresConnectionHelper;
import ru.kpfu.ibragimov.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {

  private static final Connection connection = PostgresConnectionHelper.getConnection();

  public User get(String login) {
    try {
      Statement statement = connection.createStatement();
      String query = String.format("SELECT * FROM \"user\" WHERE user_login = \'%s\';", login);
      ResultSet resultSet = statement.executeQuery(query);
      resultSet.next();

      return new User(
        resultSet.getString("user_login"),
        resultSet.getString("user_password"),
        resultSet.getString("first_name"),
        resultSet.getString("last_name"),
        resultSet.getString("user_token")
      );
    } catch (SQLException throwables) {
      throwables.printStackTrace();
      return null;
    }
  }

  @Override
  public void set(User user) {
    String query = "UPDATE \"user\" SET user_login = ?, user_password = ?, first_name = ?, last_name = ?, user_token = ? WHERE user_login = ?;";

    try {
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      preparedStatement.setString(1, user.getLogin());
      preparedStatement.setString(2, user.getPassword());
      preparedStatement.setString(3, user.getFirstName());
      preparedStatement.setString(4, user.getLastName());
      preparedStatement.setString(5, user.getUserToken());
      preparedStatement.setString(6, user.getLogin());

      preparedStatement.executeUpdate();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  public List<User> getAll() {
    try {
      Statement statement = connection.createStatement();
      String query = "SELECT * FROM \"user\";";
      ResultSet resultSet = statement.executeQuery(query);

      List<User> users = new ArrayList<>();

      while (resultSet.next()) {
        users.add(new User(
          resultSet.getString("user_login"),
          resultSet.getString("user_password"),
          resultSet.getString("first_name"),
          resultSet.getString("last_name")
        ));
      }

      return users;
    } catch (SQLException throwables) {
      throwables.printStackTrace();
      return new ArrayList<>();
    }

  }

  @Override
  public boolean save(User user) {
    String query = "INSERT INTO \"user\" (user_login, user_password, first_name, last_name, user_token) VALUES (?, ?, ?, ?, ?);";

    try {
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      preparedStatement.setString(1, user.getLogin());
      preparedStatement.setString(2, PasswordHelper.encrypt(user.getPassword()));
      preparedStatement.setString(3, user.getFirstName());
      preparedStatement.setString(4, user.getLastName());
      preparedStatement.setString(5, user.getUserToken());

      preparedStatement.executeUpdate();
      return true;
    } catch (SQLException throwables) {
      throwables.printStackTrace();
      return false;
    }
  }
}
