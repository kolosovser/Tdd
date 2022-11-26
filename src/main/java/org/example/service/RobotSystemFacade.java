package org.example.service;

import java.util.List;
import lombok.experimental.UtilityClass;
import org.example.model.PlatoAndRobotsDto;
import org.example.model.RobotLocationDto;

@UtilityClass
public class RobotSystemFacade {

  public static List<String> handle(List<String> inputData) {
    InputDataValidator.validateInputData(inputData);

    PlatoAndRobotsDto platoAndRobots = InputDataMapper.mapInputDataToDto(inputData);

    List<RobotLocationDto> robotsInfo = RobotMover.moveRobots(platoAndRobots);

    return ResponseMapper.mapRobotInfoToResponse(robotsInfo);
  }

}
