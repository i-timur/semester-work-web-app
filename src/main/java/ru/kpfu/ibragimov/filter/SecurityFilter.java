package ru.kpfu.ibragimov.filter;

import ru.kpfu.ibragimov.service.SecurityService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class SecurityFilter extends HttpFilter {
  protected final String[] paths = {"/profile", "/create"};

  @Override
  protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
    boolean flag = false;
    for (String path : paths) {
      if (path.equals(req.getRequestURI().substring(req.getContextPath().length()))) {
        flag = true;
        break;
      }
    }
    if (flag && !SecurityService.isLogged(req)) {
      res.sendRedirect("/login");
      return;
    } else {
      if (SecurityService.isLogged(req)) {
        req.setAttribute("username", req.getSession().getAttribute("username"));
      }
    }
    chain.doFilter(req, res);
  }
}
