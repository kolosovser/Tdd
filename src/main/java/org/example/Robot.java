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

  public Robot move() {
    getInstructions().forEach(it -> {
      switch (it) {
        case L -> changeDirectionToLeft();
        case R -> changeDirectionToRight();
        case M -> makeStep();
      }
    });
    return this;
  }

  private void changeDirectionToLeft() {
    switch (direction) {
      case E -> direction = RobotCameraDirection.N;
      case N -> direction = RobotCameraDirection.W;
      case W -> direction = RobotCameraDirection.S;
      case S -> direction = RobotCameraDirection.E;
    }
  }

  private void changeDirectionToRight() {
    switch (direction) {
      case E -> direction = RobotCameraDirection.S;
      case S -> direction = RobotCameraDirection.W;
      case W -> direction = RobotCameraDirection.N;
      case N -> direction = RobotCameraDirection.E;
    }
  }

  private void makeStep() {
    switch (direction) {
      case E -> {
        if (coordinate.getX() < platoSize.getX()) {
          coordinate.setX(coordinate.getX() + 1);
        }
      }
      case W -> {
        if (coordinate.getX() > 0) {
          coordinate.setX(coordinate.getX() - 1);
        }
      }
      case N -> {
        if (coordinate.getY() < platoSize.getY()) {
          coordinate.setY(coordinate.getY() + 1);
        }
      }
      case S -> {
        if (coordinate.getY() > 0) {
          coordinate.setY(coordinate.getY() - 1);
        }
      }
    }

  }

}
