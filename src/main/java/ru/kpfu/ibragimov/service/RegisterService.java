package ru.kpfu.ibragimov.service;

import ru.kpfu.ibragimov.dao.DAO;
import ru.kpfu.ibragimov.dao.impl.UserDAO;
import ru.kpfu.ibragimov.model.User;

import javax.servlet.http.HttpServletRequest;

public class RegisterService {

  private static final ru.kpfu.ibragimov.dao.DAO<User> DAO = new UserDAO();

  public static boolean register(HttpServletRequest req, String login, String password) {
    if (DAO.save(new User(login, password, null, null, null))) {
      req.getSession().setAttribute("username", login);
      return true;
    }
    return false;
  }
}
