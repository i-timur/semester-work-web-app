package ru.kpfu.ibragimov.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecurityService {

  public static boolean isLogged(HttpServletRequest req) {
    return req.getSession().getAttribute("username") != null;
  }

  public static boolean login(HttpServletRequest req, HttpServletResponse resp, String login, String password, String rememberMe) {
    if (AuthenticationService.isUser(login, password)) {
      if (rememberMe != null && rememberMe.equals("on")) {
        RememberService.remember(resp, login);
      }
      req.getSession().setAttribute("username", login);
      req.getSession().setMaxInactiveInterval(60 * 60);
      return true;
    }
    return false;
  }

  public static void logout(HttpServletRequest req) {
    req.getSession().removeAttribute("username");
  }

}
