package ru.kpfu.ibragimov.dao;

import ru.kpfu.ibragimov.model.Message;

import java.util.List;

public interface IMessageDAO {
  void save(Message message);
  List<Message> getAll();
}
