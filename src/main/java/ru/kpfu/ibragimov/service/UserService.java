package ru.kpfu.ibragimov.service;

import ru.kpfu.ibragimov.dao.IUserDAO;
import ru.kpfu.ibragimov.dao.impl.UserDAO;
import ru.kpfu.ibragimov.dto.UserDTO;
import ru.kpfu.ibragimov.model.User;

public class UserService {

  private final IUserDAO DAO = new UserDAO();

  public UserDTO get(UserDTO userDTO) {
    User user = DAO.get(userDTO.getLogin());
    return new UserDTO(
      user.getLogin(),
      user.getPassword(),
      user.getFirstName(),
      user.getLastName(),
      user.getUserToken()
    );
  }

  public void set(UserDTO userDTO) {
    User user = DAO.get(userDTO.getLogin());
    user.setFirstName(userDTO.getFirstName());
    user.setLastName(userDTO.getLastName());
    DAO.set(user);
  }

  public void change(UserDTO userDTO) {
    UserDTO user = get(userDTO);
    DAO.set(new User(
      user.getLogin(),
      user.getPassword(),
      user.getFirstName(),
      user.getLastName(),
      userDTO.getUserToken()
    ));
  }
}
