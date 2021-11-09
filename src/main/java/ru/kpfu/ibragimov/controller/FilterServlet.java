package ru.kpfu.ibragimov.controller;

import ru.kpfu.ibragimov.dto.ContributionDTO;
import ru.kpfu.ibragimov.service.ContributionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/filter")
public class FilterServlet extends HttpServlet {

  ContributionService contributionService = new ContributionService();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String category = req.getParameter("category");
    String search = req.getParameter("search");

    resp.setContentType("text/plain");
    resp.setCharacterEncoding("UTF-8");
    String html = contributionService.getAsText(contributionService.filter(category, search));
    resp.getWriter().write(html);
  }
}
