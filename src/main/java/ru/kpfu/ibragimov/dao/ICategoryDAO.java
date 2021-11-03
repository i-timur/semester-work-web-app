package ru.kpfu.ibragimov.dao;

import ru.kpfu.ibragimov.model.Category;

public interface ICategoryDAO {
  Category get(String cateogryName);
}
