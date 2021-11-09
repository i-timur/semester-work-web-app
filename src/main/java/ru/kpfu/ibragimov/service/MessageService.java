package ru.kpfu.ibragimov.service;

import ru.kpfu.ibragimov.Utils;
import ru.kpfu.ibragimov.dao.IMessageDAO;
import ru.kpfu.ibragimov.dao.impl.MessageDAO;
import ru.kpfu.ibragimov.dto.MessageDTO;
import ru.kpfu.ibragimov.dto.MessageMessageAuthorTextDTO;
import ru.kpfu.ibragimov.model.Message;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class MessageService {

  private final IMessageDAO DAO = new MessageDAO();

  public List<MessageDTO> getAll() {
    List<Message> messages = DAO.getAll();
    return messages.stream()
      .map((m) -> new MessageDTO(m.getMessageAuthor(), m.getText(), m.getCreatedAt()))
      .collect(Collectors.toList());
  }

  public void save(MessageMessageAuthorTextDTO message) {
    DAO.save(new Message(message.getMessageAuthor(), message.getText(), Utils.getTimeStamp(new Date())));
  }

  public String getAsText(List<MessageDTO> messages) {
    List<String> stringMessages = messages.stream()
      .map((m) -> "<div class=\"chat__message message\"><div class=\"message__author\">" + m.getMessageAuthor() + "</div>" + "<div class=\"message__text\">" + m.getText() + "</div>" + "<div class=\"message__date\">" + m.getCreatedAt() + "</div></div>")
      .collect(Collectors.toList());
    return String.join("", stringMessages);
  }
}
