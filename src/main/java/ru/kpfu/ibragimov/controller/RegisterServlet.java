package ru.kpfu.ibragimov.controller;

import ru.kpfu.ibragimov.service.RegisterService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.getRequestDispatcher("/WEB-INF/views/register.html").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String login = req.getParameter("login");
    String password = req.getParameter("password");

    if (RegisterService.register(req, login, password)) {
      resp.sendRedirect(getServletContext().getContextPath() + "/profile");
      return;
    }

    req.getRequestDispatcher("/WEB-INF/views/register.html").forward(req, resp);
  }
}
