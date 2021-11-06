package ru.kpfu.ibragimov.dao.impl;

import ru.kpfu.ibragimov.dao.ICategoryDAO;
import ru.kpfu.ibragimov.helper.PostgresConnectionHelper;
import ru.kpfu.ibragimov.model.Category;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CategoryDAO implements ICategoryDAO {

  private static final Connection connection = PostgresConnectionHelper.getConnection();

  @Override
  public Category get(String categoryName) {
    if ("all".equals(categoryName)) {
      return null;
    }

    try {
      Statement statement = connection.createStatement();

      String query = String.format("SELECT * FROM category WHERE category_name = \'%s\';", categoryName);

      ResultSet resultSet = statement.executeQuery(query);
      resultSet.next();

      return new Category(
        resultSet.getInt("category_id"),
        resultSet.getString("category_name")
      );
    } catch (SQLException throwables) {
      throwables.printStackTrace();
      return null;
    }

  }
}
