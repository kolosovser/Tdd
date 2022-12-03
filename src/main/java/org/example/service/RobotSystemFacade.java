package org.example.service;

import java.util.List;
import java.util.stream.Collectors;
import lombok.experimental.UtilityClass;
import org.example.Robot;

@UtilityClass
public class RobotSystemFacade {

  public static List<String> handle(List<String> inputData) {
    InputDataValidator.validateInputData(inputData);

    List<Robot> initRobots = InputDataMapper.mapInputDataToDto(inputData);

    List<Robot> movedRobots = initRobots.stream()
        .map(Robot::move)
        .collect(Collectors.toList());

    return ResponseMapper.mapRobotInfoToResponse(movedRobots);
  }

}
