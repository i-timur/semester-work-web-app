package ru.kpfu.ibragimov.service;

import ru.kpfu.ibragimov.dao.IUserDAO;
import ru.kpfu.ibragimov.dao.impl.UserDAO;
import ru.kpfu.ibragimov.model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterService {

  private static final IUserDAO DAO = new UserDAO();

  private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";

  public static boolean register(HttpServletRequest req, String login, String password) {
    Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
    Matcher matcher = pattern.matcher(password);
    if (matcher.find()) {
      if (DAO.save(new User(login, password, null, null, null))) {
        req.getSession().setAttribute("username", login);
        return true;
      }
    }
    return false;
  }
}
