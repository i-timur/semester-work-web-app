package ru.kpfu.ibragimov.model;

public class Contribution {
  private int id;
  private String title;
  private String text;

  public Contribution(int id, String title, String text) {
    this.id = id;
    this.title = title;
    this.text = text;
  }

  public Contribution(String title, String text) {
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

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}
