package org.example;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import org.example.model.Coordinate;
import org.example.model.RobotDirection;
import org.example.model.RobotInstruction;

@Data
@Builder
public class Robot {

  Coordinate coordinate;
  RobotDirection direction;
  List<RobotInstruction> instructions;

  public void move(Coordinate platoCoordinate) {
    getInstructions().forEach(it -> {
      switch (it) {
        case L -> changeDirectionToLeft();
        case R -> changeDirectionToRight();
        case M -> makeStep(platoCoordinate);
      }
    });
  }

  private void changeDirectionToLeft() {
    switch (direction) {
      case E -> direction = RobotDirection.N;
      case N -> direction = RobotDirection.W;
      case W -> direction = RobotDirection.S;
      case S -> direction = RobotDirection.E;
    }
  }

  private void changeDirectionToRight() {
    switch (direction) {
      case E -> direction = RobotDirection.S;
      case S -> direction = RobotDirection.W;
      case W -> direction = RobotDirection.N;
      case N -> direction = RobotDirection.E;
    }
  }

  private void makeStep(Coordinate platoCoordinate) {
    switch (direction) {
      case E -> {
        if (coordinate.getX() < platoCoordinate.getX()) {
          coordinate.setX(coordinate.getX() + 1);
        }
      }
      case W -> {
        if (coordinate.getX() > 0) {
          coordinate.setX(coordinate.getX() - 1);
        }
      }
      case N -> {
        if (coordinate.getY() < platoCoordinate.getY()) {
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
