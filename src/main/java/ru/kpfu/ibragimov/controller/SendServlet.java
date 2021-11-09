package ru.kpfu.ibragimov.controller;

import ru.kpfu.ibragimov.dto.MessageMessageAuthorTextDTO;
import ru.kpfu.ibragimov.service.MessageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/send")
public class SendServlet extends HttpServlet {

  MessageService messageService = new MessageService();

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String author = (String) req.getSession().getAttribute("username");
    String message = req.getParameter("message");

    messageService.save(new MessageMessageAuthorTextDTO(author, message));

    resp.setContentType("text/plain");
    resp.setCharacterEncoding("UTF-8");
    String html = messageService.getAsText(messageService.getAll());
    resp.getWriter().write(html);
  }
}
