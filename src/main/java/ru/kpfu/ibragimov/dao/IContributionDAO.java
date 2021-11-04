package ru.kpfu.ibragimov.dao;

import ru.kpfu.ibragimov.model.Contribution;

import java.util.List;

public interface IContributionDAO {
  Contribution get(int id);
  List<Contribution> getAll();
  List<Contribution> filter(String category, String search);
  boolean save(Contribution contribution);
  Contribution saveAndRetrieve(Contribution contribution);
}
