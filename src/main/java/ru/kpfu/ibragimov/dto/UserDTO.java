package ru.kpfu.ibragimov.dto;

public class UserDTO {
  private String login;
  private String password;
  private String firstName;
  private String lastName;
  private String userToken;

  public UserDTO(String login, String password, String firstName, String lastName, String userToken) {
    this.login = login;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.userToken = userToken;
  }

  public UserDTO(String login, String firstName, String lastName) {
    this.login = login;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public UserDTO(String login, String userToken) {
    this.login = login;
    this.userToken = userToken;
  }

  public UserDTO(String login) {
    this.login = login;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getUserToken() {
    return userToken;
  }

  public void setUserToken(String userToken) {
    this.userToken = userToken;
  }
}
