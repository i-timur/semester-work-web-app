package ru.kpfu.ibragimov.service;


import ru.kpfu.ibragimov.dao.IContributionCategoryDAO;
import ru.kpfu.ibragimov.dao.impl.ContributionCategoryCategoryDAO;
import ru.kpfu.ibragimov.model.ContributionCategory;

public class ContributionCategoryService {

  private final IContributionCategoryDAO contributionCategoryCategoryDAO= new ContributionCategoryCategoryDAO();

  public boolean save(int contributionID, int categoryID) {
    return contributionCategoryCategoryDAO.save(new ContributionCategory(contributionID, categoryID));
  }
}
