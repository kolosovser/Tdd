package org.example.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.experimental.UtilityClass;
import org.example.Robot;
import org.example.model.Coordinate;
import org.example.model.Plato;
import org.example.model.RobotDirection;
import org.example.model.RobotInstruction;

@UtilityClass
public class InputDataMapper {

  public static Plato mapInputDataToRobots(List<String> inputData) {

    String[] platoInfo = inputData.get(0).split(" ");
    List<String> robotInfo = inputData.stream().skip(1).collect(Collectors.toList());

    List<Robot> robots = mapRobots(robotInfo);

    Coordinate pratoCoordinate = new Coordinate(Integer.parseInt(platoInfo[0]), Integer.parseInt(platoInfo[1]));

    return new Plato(pratoCoordinate, robots);
  }

  private static List<Robot> mapRobots(List<String> robotInfo) {
    return IntStream.range(0, (robotInfo.size() + 2 - 1) / 2)
        .mapToObj(i -> robotInfo.subList(i * 2, Math.min(2 * (i + 1), robotInfo.size())))
        .map(it -> {
              var cameraList = Arrays.stream(it.get(0).split(" "))
                  .collect(Collectors.toList());

              Coordinate camera = Coordinate.builder()
                  .x(Integer.valueOf(cameraList.get(0)))
                  .y(Integer.valueOf(cameraList.get(1)))
                  .build();

              var instruction = Arrays.stream(it.get(1).split(""))
                  .map(RobotInstruction::valueOf)
                  .collect(Collectors.toList());

              return Robot.builder()
                  .coordinate(camera)
                  .instructions(instruction)
                  .direction(RobotDirection.valueOf(cameraList.get(2)))
                  .build();
            }
        )
        .collect(Collectors.toList());
  }

}
