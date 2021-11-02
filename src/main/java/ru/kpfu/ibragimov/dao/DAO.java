package ru.kpfu.ibragimov.dao;

import java.util.List;

public interface DAO <T> {
  T get(String login);
  List<T> getAll();
  boolean save(T t);
  boolean change(T t);
}
