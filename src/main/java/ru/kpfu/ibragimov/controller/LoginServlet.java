package ru.kpfu.ibragimov.controller;

import ru.kpfu.ibragimov.service.SecurityService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.getRequestDispatcher("/WEB-INF/views/login.ftl").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String login = req.getParameter("login");
    String password = req.getParameter("password");
    String rememberMe = req.getParameter("checkbox");

    if (login != null && password != null) {
      if (SecurityService.login(req, resp, login, password, rememberMe)) {
        resp.sendRedirect(getServletContext().getContextPath() + "/");
        return;
      }
    }

    req.getRequestDispatcher("/WEB-INF/views/login.ftl").forward(req, resp);
  }
}
