package org.example.service;


import java.util.List;
import org.example.Robot;
import org.example.model.Coordinate;
import org.example.model.RobotCameraDirection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.example.model.RobotInstruction.L;
import static org.example.model.RobotInstruction.M;

class RobotMoveTest {

  @Test
  void robotCoordinateTest() {

    //given
    Robot initRobot = Robot.builder()
        .coordinate(new Coordinate(1, 2))
        .direction(RobotCameraDirection.N)
        .platoSize(new Coordinate(5, 5))
        .instructions(List.of(L, M, L, M, L, M, L, M, M))
        .build();

    Robot expectedRobot = Robot.builder()
        .coordinate(new Coordinate(1, 3))
        .direction(RobotCameraDirection.N)
        .build();

    //when
    Robot actualRobot = initRobot.move(initRobot);

    //then
    Assertions.assertEquals(expectedRobot.getCoordinate(), actualRobot.getCoordinate());
    Assertions.assertEquals(expectedRobot.getDirection(), actualRobot.getDirection());
  }

}
