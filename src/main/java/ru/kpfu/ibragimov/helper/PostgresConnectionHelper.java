package ru.kpfu.ibragimov.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnectionHelper {

  private static Connection connection;
  private static final String DRIVER = "org.postgresql.Driver";
  private static final String URL = "jdbc:postgresql://localhost:5432/semester_work_web_app";
  private static final String USER = "timuribragimov";
  private static final String PASSWORD = "admin";

  public static Connection getConnection() {
    if (connection == null) {
      try {
        Class.forName(DRIVER);
        connection = DriverManager.getConnection(
          URL,
          USER,
          PASSWORD
        );
      } catch (ClassNotFoundException e) {
        e.printStackTrace();
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
    }
    return connection;
  }
}
