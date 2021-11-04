package ru.kpfu.ibragimov.filter;

import ru.kpfu.ibragimov.dto.UserDTO;
import ru.kpfu.ibragimov.service.SecurityService;
import ru.kpfu.ibragimov.service.UserService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class SecurityFilter extends HttpFilter {

  private final UserService userService = new UserService();
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

    String username = null;
    String token = null;
    Cookie[] cookies = req.getCookies();
    if (cookies != null) {
      for (Cookie c : cookies) {
        if ("username".equals(c.getName())) {
          username = c.getValue();
        }
        if ("token".equals(c.getName())) {
          token = c.getValue();
        }
      }
  }

    if (username != null && token != null) {
      UserDTO user = userService.get(new UserDTO(username));
      if (user.getUserToken() == token) {
        SecurityService.login(req, res, username, user.getPassword(), "on");
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
