package ru.kpfu.ibragimov.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileService {
  private String fs = System.getProperty("file.separator");

  public void createFile(String fileName, String title, String text, String category) {
    String absolutePath = fs + "Users" + fs + "timuribragimov" + fs + "main" + fs + "itis2021" + fs +
      "cs" + fs + "semester-work-web-app" + fs + "src" + fs + "main" + fs + "webapp" + fs +"WEB-INF" +
      fs + "views" + fs + "contribution" + fs + fileName;
    File file = new File(absolutePath);
    try {
      if (file.createNewFile()) {
        FileWriter fw = new FileWriter(file);
        fw.write(String.format("<#include \"contribution-base.ftl\"><#macro title>%s</#macro><#macro text>%s</#macro><#macro category>Category: %s</#macro>",title, text, category));
        fw.close();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
