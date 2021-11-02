package ru.kpfu.ibragimov;

import java.util.UUID;

public class Utils {

  public static String randomString() {
    return UUID.randomUUID().toString();
  }
}
