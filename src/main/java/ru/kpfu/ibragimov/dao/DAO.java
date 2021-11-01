package ru.kpfu.ibragimov.dao;

import java.util.List;

public interface DAO <T> {
  T get();
  List<T> getAll();
}
