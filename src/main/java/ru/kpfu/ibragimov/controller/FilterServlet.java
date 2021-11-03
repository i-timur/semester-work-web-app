package ru.kpfu.ibragimov.controller;

import ru.kpfu.ibragimov.dto.ContributionTitleDTO;
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
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String option = req.getParameter("select");
    String search = req.getParameter("search");

    List<ContributionTitleDTO> titles = contributionService.filterTitles(option, search);
    req.setAttribute("titles", titles);
    req.setAttribute("username", req.getSession().getAttribute("username"));
    req.getRequestDispatcher("/WEB-INF/views/index.ftl").forward(req, resp);
  }
}
