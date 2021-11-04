package ru.kpfu.ibragimov.dao;

import ru.kpfu.ibragimov.model.User;

import java.util.List;

public interface IUserDAO {
  User get(String login);
  void set(User user);
  List<User> getAll();
  boolean save(User user);
}
