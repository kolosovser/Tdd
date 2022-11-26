package org.example.service;

import java.util.List;
import java.util.stream.Collectors;
import lombok.experimental.UtilityClass;
import org.example.model.RobotLocationDto;

@UtilityClass
public class ResponseMapper {

  public static List<String> mapRobotInfoToResponse(List<RobotLocationDto> robotsInfo) {
    return robotsInfo.stream()
        .map(it -> it.getX() + " " + it.getY() + " " + it.getCameraDirection())
        .collect(Collectors.toList());
  }

}
