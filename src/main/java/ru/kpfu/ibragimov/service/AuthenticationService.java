package ru.kpfu.ibragimov.service;

import ru.kpfu.ibragimov.dao.IUserDAO;
import ru.kpfu.ibragimov.dao.impl.UserDAO;
import ru.kpfu.ibragimov.dto.UserLoginPasswordDTO;
import ru.kpfu.ibragimov.helper.PasswordHelper;
import ru.kpfu.ibragimov.model.User;

import java.util.List;

public class AuthenticationService {

  private static final IUserDAO DAO = new UserDAO();
  private static final List<User> users = DAO.getAll();

  public static boolean isUser(UserLoginPasswordDTO userDTO) {
    return users.stream()
      .anyMatch((user) -> user.getLogin().equals(userDTO.getLogin()) && user.getPassword().equals(PasswordHelper.encrypt(userDTO.getPassword())));
  }

}
