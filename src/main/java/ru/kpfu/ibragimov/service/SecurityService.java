package ru.kpfu.ibragimov.service;


import javax.servlet.http.HttpServletRequest;

public class SecurityService {

  public static boolean isLogged(HttpServletRequest req) {
    return req.getSession().getAttribute("username") != null;
  }

  public static boolean login(HttpServletRequest req, String login, String password) {
    if (AuthenticationService.isUser(login, password)) {
      req.getSession().setAttribute("username", login);
      req.getSession().setMaxInactiveInterval(60 * 60);
      return true;
    }
    return false;
  }

}
