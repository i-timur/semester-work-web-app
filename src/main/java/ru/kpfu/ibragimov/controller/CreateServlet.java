package ru.kpfu.ibragimov.controller;

import ru.kpfu.ibragimov.dto.ContributionTitleTextDTO;
import ru.kpfu.ibragimov.model.ContributionCategory;
import ru.kpfu.ibragimov.service.CategoryService;
import ru.kpfu.ibragimov.service.ContributionCategoryService;
import ru.kpfu.ibragimov.service.ContributionService;
import ru.kpfu.ibragimov.service.FileService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create")
public class CreateServlet extends HttpServlet {

  private final ContributionService contributionService = new ContributionService();
  private final ContributionCategoryService contributionCategoryService = new ContributionCategoryService();
  private final CategoryService categoryService = new CategoryService();
  private final FileService fileService = new FileService();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.getRequestDispatcher("/WEB-INF/views/create.ftl").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String title = req.getParameter("title");
    String text = req.getParameter("text");
    String select = req.getParameter("select");

    int contributionID = contributionService.saveAndGetID(new ContributionTitleTextDTO(title, text));

    if (contributionCategoryService.save(contributionID, categoryService.getID(select))) {
      fileService.createFile(Integer.toString(contributionID) + ".ftl", title, text, select);
      req.setAttribute("username", req.getSession().getAttribute("username"));
      resp.sendRedirect("/");
      return;
    }
    resp.sendRedirect("/");
  }
}
