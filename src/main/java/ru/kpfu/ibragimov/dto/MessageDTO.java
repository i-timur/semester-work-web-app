package ru.kpfu.ibragimov.dto;

public class MessageDTO {
  private String messageAuthor;
  private String text;
  private String createdAt;

  public MessageDTO(String messageAuthor, String text, String createdAt) {
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
