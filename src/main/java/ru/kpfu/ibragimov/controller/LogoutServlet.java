package ru.kpfu.ibragimov.controller;

import ru.kpfu.ibragimov.service.SecurityService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    SecurityService.logout(req);
    Cookie[] cookies = req.getCookies();
    if (cookies != null) {
      for (Cookie c : cookies) {
        if ("username".equals(c.getName())) {
          c.setMaxAge(1);
          resp.addCookie(c);
        }
        if ("token".equals(c.getName())) {
          c.setMaxAge(1);
          resp.addCookie(c);
        }
      }
    }
    resp.sendRedirect("/");
  }
}
