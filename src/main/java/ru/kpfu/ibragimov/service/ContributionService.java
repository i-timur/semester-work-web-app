package ru.kpfu.ibragimov.service;

import ru.kpfu.ibragimov.dao.IContributionDAO;
import ru.kpfu.ibragimov.dao.impl.ContributionDAO;
import ru.kpfu.ibragimov.dto.ContributionDTO;
import ru.kpfu.ibragimov.dto.ContributionTitleTextDTO;
import ru.kpfu.ibragimov.model.Contribution;

import java.util.List;
import java.util.stream.Collectors;

public class ContributionService {

  private final IContributionDAO DAO = new ContributionDAO();

  public List<ContributionDTO> getAll() {
    List<Contribution> contributions = DAO.getAll();
    return contributions.stream()
      .map((u) -> new ContributionDTO(u.getId(), u.getTitle(), u.getText()))
      .collect(Collectors.toList());
  }

  public List<ContributionDTO> filter(String category, String search) {
    List<Contribution> contributions = DAO.filter(category, search);
    return contributions.stream()
      .map((u) -> new ContributionDTO(u.getId(), u.getTitle(), u.getText()))
      .collect(Collectors.toList());
  }

  public void save(ContributionTitleTextDTO contribution) {
    DAO.save(new Contribution(contribution.getTitle(), contribution.getText()));
  }

  public int saveAndGetID(ContributionTitleTextDTO contribution) {
    return DAO.saveAndRetrieve(new Contribution(contribution.getTitle(), contribution.getText())).getId();
  }

  public String getAsText(List<ContributionDTO> contributions) {
    List<String> stringContributions = contributions.stream()
      .map((c) -> "<div class=\"main-block__item\">" + "<a href=\"/contribution/"+ Integer.toString(c.getId()) +"\" class=\"main-block__link\">"+ c.getTitle() +"</a></div>" )
      .collect(Collectors.toList());
    return String.join("", stringContributions);
  }
}
