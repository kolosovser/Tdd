package org.example.service;

import java.util.List;
import java.util.stream.Collectors;
import lombok.experimental.UtilityClass;
import org.example.Robot;

@UtilityClass
public class ResponseMapper {

  public static List<String> mapRobotInfoToResponse(List<Robot> robotsInfo) {
    return robotsInfo.stream()
        .map(it -> it.getCoordinate().getX() + " " + it.getCoordinate().getY() + " " + it.getDirection())
        .collect(Collectors.toList());
  }

}
