package ru.kpfu.ibragimov.service;

import ru.kpfu.ibragimov.dao.DAO;
import ru.kpfu.ibragimov.dao.impl.ContributionDAO;
import ru.kpfu.ibragimov.dto.ContributionDTO;
import ru.kpfu.ibragimov.dto.ContributionTitleDTO;
import ru.kpfu.ibragimov.model.Contribution;

import java.util.List;
import java.util.stream.Collectors;

public class ContributionService {

  private final DAO<Contribution> DAO = new ContributionDAO();

  public List<ContributionDTO> getAll() {
    List<Contribution> contributions = DAO.getAll();
    return contributions.stream()
      .map((u) -> new ContributionDTO(u.getId(), u.getTitle()))
      .collect(Collectors.toList());
  }

  public List<ContributionTitleDTO> getAllTitles() {
    List<Contribution> contributions = DAO.getAll();
    return contributions.stream()
      .map((u) -> new ContributionTitleDTO(u.getTitle()))
      .collect(Collectors.toList());
  }

  public List<ContributionDTO> filter(String category, String search) {
    List<Contribution> contributions = DAO.getCertain(category, search);
    return contributions.stream()
      .map((u) -> new ContributionDTO(u.getId(), u.getText()))
      .collect(Collectors.toList());
  }

  public void save(String title, String text) {
    DAO.save(new Contribution(title, text));
  }

  public int saveAndGetID(String title, String text) {
    return DAO.saveThenRetrieve(new Contribution(title, text)).getId();
  }
}
