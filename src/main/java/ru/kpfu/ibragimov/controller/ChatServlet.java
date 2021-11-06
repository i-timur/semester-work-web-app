package ru.kpfu.ibragimov.controller;

import ru.kpfu.ibragimov.dto.MessageDTO;
import ru.kpfu.ibragimov.dto.MessageMessageAuthorTextDTO;
import ru.kpfu.ibragimov.service.MessageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/chat")
public class ChatServlet extends HttpServlet {

  public final MessageService messageService = new MessageService();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    List<MessageDTO> messages = messageService.getAll();
    req.setAttribute("messages", messages);
    req.setAttribute("username", req.getSession().getAttribute("username"));

    req.getRequestDispatcher("/WEB-INF/views/chat.ftl").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String login = (String) (req.getSession().getAttribute("username"));
    String message = req.getParameter("message");

    messageService.save(new MessageMessageAuthorTextDTO(login, message));
    resp.sendRedirect("/chat");
  }
}
