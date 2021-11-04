package ru.kpfu.ibragimov.dto;

public class ContributionTitleTextDTO {
  private String title;
  private String text;

  public ContributionTitleTextDTO(String title, String text) {
    this.title = title;
    this.text = text;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}
