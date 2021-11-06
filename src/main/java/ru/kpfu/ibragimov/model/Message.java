package ru.kpfu.ibragimov.model;

public class Message {
  private String messageAuthor;
  private String text;
  private String createdAt;

  public Message(String messageAuthor, String text, String createdAt) {
    this.messageAuthor = messageAuthor;
    this.text = text;
    this.createdAt = createdAt;
  }

  public String getMessageAuthor() {
    return messageAuthor;
  }

  public void setMessageAuthor(String messageAuthor) {
    this.messageAuthor = messageAuthor;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }
}
