package ru.kpfu.ibragimov.filters;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpFilter;

@WebServlet("/*")
public class SecurityFilter extends HttpFilter {

}
