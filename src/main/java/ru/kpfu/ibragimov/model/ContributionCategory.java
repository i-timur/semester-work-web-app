package ru.kpfu.ibragimov.model;

public class ContributionCategory {
  private int contributionID;
  private int categoryID;

  public ContributionCategory(int contributionID, int categoryID) {
    this.contributionID = contributionID;
    this.categoryID = categoryID;
  }

  public int getContributionID() {
    return contributionID;
  }

  public void setContributionID(int contributionID) {
    this.contributionID = contributionID;
  }

  public int getCategoryID() {
    return categoryID;
  }

  public void setCategoryID(int categoryID) {
    this.categoryID = categoryID;
  }
}
