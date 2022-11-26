package org.example.service;

import java.util.List;
import java.util.stream.Collectors;
import lombok.experimental.UtilityClass;
import org.example.model.PlatoAndRobotsDto;
import org.example.model.PlatoDto;
import org.example.model.RobotCameraDirection;
import org.example.model.RobotInstruction;
import org.example.model.RobotLocationDto;

@UtilityClass
public class RobotMover {

  public static List<RobotLocationDto> moveRobots(PlatoAndRobotsDto platoAndRobotsDto) {
    return platoAndRobotsDto.getRobots().stream()
        .map(robot -> {
          RobotLocationDto robotLocationDto = robot.getRobotLocationDto();
          robotLocationDto.setX(robot.getRobotLocationDto().getX());
          robotLocationDto.setY(robot.getRobotLocationDto().getY());
          return moveRobot(robotLocationDto, robot.getRobotInstructions(), platoAndRobotsDto.getPlatoDto());
        })
        .collect(Collectors.toList());
  }

  private static RobotLocationDto moveRobot(
      RobotLocationDto robotLocationDto, List<RobotInstruction> robotInstructions, PlatoDto platoDto) {
    robotInstructions.forEach(it -> {
      switch (it) {
        case L -> changeDirectionToLeft(robotLocationDto);
        case R -> changeDirectionToRight(robotLocationDto);
        case M -> makeStep(robotLocationDto, platoDto);
      }
    });
    return robotLocationDto;
  }

  private static void changeDirectionToLeft(RobotLocationDto robotLocationDto) {
    switch (robotLocationDto.getCameraDirection()) {
      case E -> robotLocationDto.setCameraDirection(RobotCameraDirection.N);
      case N -> robotLocationDto.setCameraDirection(RobotCameraDirection.W);
      case W -> robotLocationDto.setCameraDirection(RobotCameraDirection.S);
      case S -> robotLocationDto.setCameraDirection(RobotCameraDirection.E);
    }
  }

  private static void changeDirectionToRight(RobotLocationDto robotLocationDto) {
    switch (robotLocationDto.getCameraDirection()) {
      case E -> robotLocationDto.setCameraDirection(RobotCameraDirection.S);
      case S -> robotLocationDto.setCameraDirection(RobotCameraDirection.W);
      case W -> robotLocationDto.setCameraDirection(RobotCameraDirection.N);
      case N -> robotLocationDto.setCameraDirection(RobotCameraDirection.E);
    }
  }

  private static void makeStep(RobotLocationDto robotLocationDto, PlatoDto platoDto) {
    switch (robotLocationDto.getCameraDirection()) {
      case E -> {
        if (robotLocationDto.getX() < platoDto.getX()) {
          robotLocationDto.setX(robotLocationDto.getX() + 1);
        }
      }
      case W -> {
        if (robotLocationDto.getX() > 0) {
          robotLocationDto.setX(robotLocationDto.getX() - 1);
        }
      }
      case N -> {
        if (robotLocationDto.getY() < platoDto.getY()) {
          robotLocationDto.setY(robotLocationDto.getY() + 1);
        }
      }
      case S -> {
        if (robotLocationDto.getY() > 0) {
          robotLocationDto.setY(robotLocationDto.getY() - 1);
        }
      }
    }

  }

}
