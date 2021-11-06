package ru.kpfu.ibragimov.dto;

public class MessageMessageAuthorTextDTO {
  private String messageAuthor;
  private String text;

  public MessageMessageAuthorTextDTO(String messageAuthor, String text) {
    this.messageAuthor = messageAuthor;
    this.text = text;
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
}
