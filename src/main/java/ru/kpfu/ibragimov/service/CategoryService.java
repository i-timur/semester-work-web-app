package ru.kpfu.ibragimov.service;

import ru.kpfu.ibragimov.dao.ICategoryDAO;
import ru.kpfu.ibragimov.dao.impl.CategoryDAO;

public class CategoryService {

  private final ICategoryDAO DAO = new CategoryDAO();

  public int getID(String categoryName) {
    return DAO.get(categoryName) == null ? -1 : DAO.get(categoryName).getCategoryID();
  }
}
