package ru.kpfu.ibragimov.controller;

import ru.kpfu.ibragimov.dao.DAO;
import ru.kpfu.ibragimov.dao.impl.ContributionDAO;
import ru.kpfu.ibragimov.model.Contribution;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/contribution/*")
public class ContributionServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String contributionFileName = req.getRequestURI().substring(req.getContextPath().length()).substring("contribution".length() + 1) + ".ftl";
    req.getRequestDispatcher("/WEB-INF/views/contribution" + contributionFileName).forward(req, resp);
  }
}
