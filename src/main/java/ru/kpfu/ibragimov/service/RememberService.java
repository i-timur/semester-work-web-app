package ru.kpfu.ibragimov.service;

import ru.kpfu.ibragimov.Utils;
import ru.kpfu.ibragimov.dto.UserDTO;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class RememberService {

  private static final int COOKIE_LIFE_TIME = 60 * 60 * 24 * 30;

  private final UserService userService = new UserService();

  public void remember(HttpServletResponse resp, UserDTO user) {
    String userToken = Utils.randomString();
    userService.change(new UserDTO(user.getLogin(), userToken));

    Cookie tokenCookie = new Cookie("token", userToken);
    tokenCookie.setMaxAge(COOKIE_LIFE_TIME);
    resp.addCookie(tokenCookie);
    Cookie userCookie = new Cookie("username", user.getLogin());
    userCookie.setMaxAge(COOKIE_LIFE_TIME);
    resp.addCookie(userCookie);
  }
}
