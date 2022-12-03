package org.example.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.experimental.UtilityClass;
import org.example.Robot;
import org.example.model.Coordinate;
import org.example.model.RobotCameraDirection;
import org.example.model.RobotInstruction;

@UtilityClass
public class InputDataMapper {

  public static List<Robot> mapInputDataToDto(List<String> inputData) {

    String[] platoInfo = inputData.get(0).split(" ");
    List<String> robotInfo = inputData.stream().skip(1).collect(Collectors.toList());

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
                  .direction(RobotCameraDirection.valueOf(cameraList.get(2)))
                  .platoSize(new Coordinate(Integer.parseInt(platoInfo[0]), Integer.parseInt(platoInfo[1])))
                  .build();
            }
        )
        .collect(Collectors.toList());
  }

}
