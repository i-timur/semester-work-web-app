package ru.kpfu.ibragimov.dao.impl;

import ru.kpfu.ibragimov.dao.IMessageDAO;
import ru.kpfu.ibragimov.helper.PostgresConnectionHelper;
import ru.kpfu.ibragimov.model.Message;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MessageDAO implements IMessageDAO {

  private static final Connection connection = PostgresConnectionHelper.getConnection();


  @Override
  public void save(Message message) {
    String query = "INSERT INTO \"message\" (message_author, message_text, created_at) VALUES (?, ?, ?);";

    try {
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      preparedStatement.setString(1, message.getMessageAuthor());
      preparedStatement.setString(2, message.getText());
      preparedStatement.setString(3, message.getCreatedAt());

      preparedStatement.executeUpdate();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  @Override
  public List<Message> getAll() {
    try {
      Statement statement = connection.createStatement();
      String query = "SELECT * FROM \"message\";";
      ResultSet resultSet = statement.executeQuery(query);

      List<Message> messages = new ArrayList<>();

      while (resultSet.next()) {
        messages.add(new Message(
          resultSet.getString("message_author"),
          resultSet.getString("message_text"),
          resultSet.getString("created_at")
        ));
      }

      return messages;
    } catch (SQLException throwables) {
      throwables.printStackTrace();
      return new ArrayList<>();
    }
  }
}
