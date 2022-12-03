package org.example.service;

import java.util.List;
import lombok.experimental.UtilityClass;
import org.example.Robot;
import org.example.model.Plato;

@UtilityClass
public class RobotSystemFacade {

  public static List<String> handle(List<String> inputData) {
    InputDataValidator.validateInputData(inputData);

    Plato plato = InputDataMapper.mapInputDataToPojo(inputData);
    List<Robot> robots = plato.getRobots();

    robots.forEach(robot -> robot.move(plato.getCoordinate()));

    return ResponseMapper.mapRobotInfoToResponse(robots);
  }

}
