package ru.kpfu.ibragimov.dto;

public class ContributionDTO {
  private int id;
  private String title;
  private String text;

  public ContributionDTO(int id, String title, String text) {
    this.id = id;
    this.title = title;
    this.text = text;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }
}
