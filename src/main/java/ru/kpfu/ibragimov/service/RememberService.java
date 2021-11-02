package ru.kpfu.ibragimov.service;

import ru.kpfu.ibragimov.Utils;
import ru.kpfu.ibragimov.dao.DAO;
import ru.kpfu.ibragimov.dao.impl.UserDAO;
import ru.kpfu.ibragimov.helper.PasswordHelper;
import ru.kpfu.ibragimov.model.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class RememberService {

  private static final int COOKIE_LIFE_TIME = 60 * 60 * 24 * 30;

  private static final DAO<User> DAO = new UserDAO();

  public static boolean remember(HttpServletResponse resp, String login) {
    String userToken = PasswordHelper.encrypt(Utils.randomString());
    if (DAO.change(new User(login, userToken))) {
      Cookie tokenCookie = new Cookie("token", userToken);
      tokenCookie.setMaxAge(COOKIE_LIFE_TIME);
      resp.addCookie(tokenCookie);
      Cookie userCookie = new Cookie("username", login);
      userCookie.setMaxAge(COOKIE_LIFE_TIME);
      resp.addCookie(userCookie);
      return true;
    }
    return false;
  }
}
