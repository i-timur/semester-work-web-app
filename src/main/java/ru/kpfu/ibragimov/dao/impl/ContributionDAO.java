package ru.kpfu.ibragimov.dao.impl;

import ru.kpfu.ibragimov.dao.IContributionDAO;
import ru.kpfu.ibragimov.helper.PostgresConnectionHelper;
import ru.kpfu.ibragimov.model.Contribution;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContributionDAO implements IContributionDAO {

  private static final Connection connection = PostgresConnectionHelper.getConnection();

  @Override
  public Contribution get(int id) {
    try {
      Statement statement = connection.createStatement();
      String query = String.format("SELECT * FROM contribution WHERE contribution_id = %s;", Integer.toString(id));
      ResultSet resultSet = statement.executeQuery(query);
      resultSet.next();

      return new Contribution(
        resultSet.getString("contribution_title"),
        resultSet.getString("contribution_text")
      );
    } catch (SQLException throwables) {
      throwables.printStackTrace();
      return null;
    }

  }

  @Override
  public List<Contribution> getAll() {
    try {
      Statement statement = connection.createStatement();
      String query = "SELECT * FROM contribution;";
      ResultSet resultSet = statement.executeQuery(query);

      List<Contribution> contributions = new ArrayList<>();

      while (resultSet.next()) {
        contributions.add(new Contribution(
          resultSet.getInt("contribution_id"),
          resultSet.getString("contribution_title"),
          resultSet.getString("contribution_text")
        ));
      }

      return contributions;
    } catch (SQLException throwables) {
      throwables.printStackTrace();
      return new ArrayList<>();
    }
  }

  @Override
  public List<Contribution> filter(String category, String search) {
    String query;
    if (!category.equals("all")) {
      query = "select con.contribution_id, contribution_title, contribution_text from(select c.category_id, category_name, contribution_id from category c inner join contribution_category cc on c.category_id = cc.category_id where category_name = \'" + category + "\') ccc inner join contribution con on ccc.contribution_id = con.contribution_id where contribution_title like \'" + search + "%\' or contribution_text like \'%" + search + "%\';";
    } else {
      query = "select contribution_id, contribution_title, contribution_text from contribution where contribution_title like \'%"+search+"%\' or contribution_text like \'%"+search+"%\';";
    }

    try {
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(query);

      List<Contribution> contributions = new ArrayList<>();

      while(resultSet.next()) {
        contributions.add(new Contribution(
          resultSet.getInt("contribution_id"),
          resultSet.getString("contribution_title"),
          resultSet.getString("contribution_text")
        ));
      }

      return contributions;
    } catch (SQLException throwables) {
      throwables.printStackTrace();
      return new ArrayList<>();
    }
  }

  @Override
  public boolean save(Contribution contribution) {
    String query = "INSERT INTO contribution (contribution_title, contribution_text) VALUES (?, ?);";

    try {
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      preparedStatement.setString(1, contribution.getTitle());
      preparedStatement.setString(2, contribution.getText());

      preparedStatement.executeUpdate();
      return true;
    } catch (SQLException throwables) {
      throwables.printStackTrace();
      return false;
    }
  }

  @Override
  public Contribution saveAndRetrieve(Contribution contribution) {
    String query = "INSERT INTO contribution (contribution_title, contribution_text) VALUES (?, ?) RETURNING *;";

    try {
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      preparedStatement.setString(1, contribution.getTitle());
      preparedStatement.setString(2, contribution.getText());

      ResultSet resultSet = preparedStatement.executeQuery();
      resultSet.next();

      return new Contribution(
        resultSet.getInt("contribution_id"),
        resultSet.getString("contribution_title"),
        resultSet.getString("contribution_text")
      );
    } catch (SQLException throwables) {
      throwables.printStackTrace();
      return null;
    }
  }
}
