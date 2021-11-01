package ru.kpfu.ibragimov.service;

import ru.kpfu.ibragimov.dao.DAO;
import ru.kpfu.ibragimov.dao.impl.UserDAO;
import ru.kpfu.ibragimov.helper.PasswordHelper;
import ru.kpfu.ibragimov.model.User;

import java.util.List;

public class AuthenticationService {

  private static final DAO<User> DAO = new UserDAO();
  private static final List<User> users = DAO.getAll();

  public static boolean isUser(String login, String password) {
    return users.stream()
      .anyMatch((user) -> user.getLogin().equals(login) && user.getPassword().equals(PasswordHelper.encrypt(password)));
  }

}
