package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.Data;
import org.example.service.RobotSystemFacade;

@Data
public class Main {

  public static void main(String[] args) {
    List<String> initData = getInitData();
    RobotSystemFacade.handle(initData);
  }

  private static List<String> getInitData() {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    return IntStream.range(0, 5)
        .mapToObj(it -> {
          try {
            return reader.readLine();
          } catch (Exception e) {
            throw new IllegalArgumentException(e);
          }
        })
        .collect(Collectors.toList());
  }

}