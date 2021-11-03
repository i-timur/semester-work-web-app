package ru.kpfu.ibragimov.service;

import ru.kpfu.ibragimov.dao.DAO;
import ru.kpfu.ibragimov.dao.impl.UserDAO;
import ru.kpfu.ibragimov.dto.UserDTO;
import ru.kpfu.ibragimov.model.User;

public class UserService {

  private final DAO<User> DAO = new UserDAO();

  public UserDTO getUser(String login) {
    User user = DAO.get(login);
    return new UserDTO(
      user.getLogin(),
      user.getFirstName(),
      user.getLastName()
    );
  }

  public void setByLogin(String login, String firstName, String lastName) {
    DAO.set(login, firstName, lastName);
  }
}
