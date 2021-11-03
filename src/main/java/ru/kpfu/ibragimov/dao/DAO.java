package ru.kpfu.ibragimov.dao;

import java.util.List;

public interface DAO <T> {
  T get(String login);
  List<T> getAll();
  List<T> getCertain(String category, String search);
  boolean save(T t);
  boolean change(T t);
  T saveThenRetrieve(T t);
}
