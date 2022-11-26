package org.example.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.experimental.UtilityClass;
import org.example.model.PlatoAndRobotsDto;
import org.example.model.PlatoDto;
import org.example.model.RobotCameraDirection;
import org.example.model.RobotDto;
import org.example.model.RobotInstruction;
import org.example.model.RobotLocationDto;

@UtilityClass
public class InputDataMapper {

  public static PlatoAndRobotsDto mapInputDataToDto(List<String> inputData) {
    List<String> robotInfo = inputData.stream().skip(1).collect(Collectors.toList());

    List<RobotDto> robots = IntStream.range(0, (robotInfo.size() + 2 - 1) / 2)
        .mapToObj(i -> robotInfo.subList(i * 2, Math.min(2 * (i + 1), robotInfo.size())))
        .map(it -> {
          var cameraList = Arrays.stream(it.get(0).split(" "))
              .collect(Collectors.toList());

          RobotLocationDto camera = RobotLocationDto.builder()
              .x(Integer.valueOf(cameraList.get(0)))
              .y(Integer.valueOf(cameraList.get(1)))
              .cameraDirection(RobotCameraDirection.valueOf(cameraList.get(2)))
              .build();

          var instruction = Arrays.stream(it.get(1).split(""))
              .map(RobotInstruction::valueOf)
              .collect(Collectors.toList());

          return RobotDto.builder()
              .robotLocationDto(camera)
              .robotInstructions(instruction)
              .build();
        })
        .collect(Collectors.toList());

    String[] platoInfo = inputData.get(0).split(" ");
    PlatoDto platoDto = new PlatoDto(Integer.parseInt(platoInfo[0]), Integer.parseInt(platoInfo[1]));

    return new PlatoAndRobotsDto(platoDto, robots);
  }

}
