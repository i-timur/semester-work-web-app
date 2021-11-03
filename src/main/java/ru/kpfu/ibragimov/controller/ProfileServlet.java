package ru.kpfu.ibragimov.controller;

import ru.kpfu.ibragimov.dto.UserDTO;
import ru.kpfu.ibragimov.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

  private final UserService userService = new UserService();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    UserDTO user = userService.getUser((String) req.getSession().getAttribute("username"));
    req.setAttribute("username", user.getLogin());
    req.setAttribute("firstName", user.getFirstName());
    req.setAttribute("lastName", user.getLastName());
    req.getRequestDispatcher("/WEB-INF/views/profile.ftl").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String login = (String) req.getSession().getAttribute("username");
    String firstName = req.getParameter("firstName");
    String lastName = req.getParameter("lastName");

    userService.setByLogin(login, firstName, lastName);
    resp.sendRedirect("/profile");
  }
}
