package ru.kpfu.ibragimov;

import ru.kpfu.ibragimov.helper.PasswordHelper;

public class Application {
  public static void main(String[] args) {
    System.out.println(PasswordHelper.encrypt("admin"));
  }
}
