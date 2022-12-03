package org.example.service;

import java.util.List;
import lombok.experimental.UtilityClass;
import org.example.Robot;

@UtilityClass
public class RobotSystemFacade {

  public static List<String> handle(List<String> inputData) {
    InputDataValidator.validateInputData(inputData);

    List<Robot> robots = InputDataMapper.mapInputDataToRobots(inputData);

    robots.forEach(Robot::move);

    return ResponseMapper.mapRobotInfoToResponse(robots);
  }

}
