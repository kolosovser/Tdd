package org.example;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import org.example.model.Coordinate;
import org.example.model.RobotCameraDirection;
import org.example.model.RobotInstruction;

@Data
@Builder
public class Robot {

  Coordinate coordinate;
  Coordinate platoSize;
  RobotCameraDirection direction;
  List<RobotInstruction> instructions;

  public Robot move(Robot robot) {
    robot.getInstructions().forEach(it -> {
      switch (it) {
        case L -> changeDirectionToLeft(robot);
        case R -> changeDirectionToRight(robot);
        case M -> makeStep(robot);
      }
    });
    return robot;
  }

  private void changeDirectionToLeft(Robot robot) {
    switch (robot.getDirection()) {
      case E -> robot.setDirection(RobotCameraDirection.N);
      case N -> robot.setDirection(RobotCameraDirection.W);
      case W -> robot.setDirection(RobotCameraDirection.S);
      case S -> robot.setDirection(RobotCameraDirection.E);
    }
  }

  private void changeDirectionToRight(Robot robot) {
    switch (robot.getDirection()) {
      case E -> robot.setDirection(RobotCameraDirection.S);
      case S -> robot.setDirection(RobotCameraDirection.W);
      case W -> robot.setDirection(RobotCameraDirection.N);
      case N -> robot.setDirection(RobotCameraDirection.E);
    }
  }

  private void makeStep(Robot robot) {
    switch (robot.getDirection()) {
      case E -> {
        if (robot.getCoordinate().getX() < platoSize.getX()) {
          robot.getCoordinate().setX(robot.getCoordinate().getX() + 1);
        }
      }
      case W -> {
        if (robot.getCoordinate().getX() > 0) {
          robot.getCoordinate().setX(robot.getCoordinate().getX() - 1);
        }
      }
      case N -> {
        if (robot.getCoordinate().getY() < platoSize.getY()) {
          robot.getCoordinate().setY(robot.getCoordinate().getY() + 1);
        }
      }
      case S -> {
        if (robot.getCoordinate().getY() > 0) {
          robot.getCoordinate().setY(robot.getCoordinate().getY() - 1);
        }
      }
    }

  }

}
