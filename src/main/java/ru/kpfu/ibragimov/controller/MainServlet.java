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

@WebServlet("")
public class MainServlet extends HttpServlet {

  private final ContributionService  contributionService= new ContributionService();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    List<ContributionDTO> contributions = contributionService.getAll();

    req.setAttribute("contributions", contributions);
    req.setAttribute("username", req.getSession().getAttribute("username"));
    req.getRequestDispatcher("/WEB-INF/views/index.ftl").forward(req, resp);
  }
}
