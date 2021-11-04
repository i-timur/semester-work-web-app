package ru.kpfu.ibragimov.dao.impl;

import ru.kpfu.ibragimov.dao.IContributionCategoryDAO;
import ru.kpfu.ibragimov.helper.PostgresConnectionHelper;
import ru.kpfu.ibragimov.model.ContributionCategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContributionCategoryDAO implements IContributionCategoryDAO {

  private static final Connection connection = PostgresConnectionHelper.getConnection();

  @Override
  public boolean save(ContributionCategory contributionCategory) {
    if (contributionCategory.getCategoryID() == -1) {
      return true;
    }
    String query = "INSERT INTO contribution_category (contribution_id, category_id) VALUES (?, ?);";
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      preparedStatement.setInt(1, contributionCategory.getContributionID());
      preparedStatement.setInt(2, contributionCategory.getCategoryID());

      preparedStatement.executeUpdate();
      return true;
    } catch (SQLException throwables) {
      throwables.printStackTrace();
      return false;
    }
  }
}
