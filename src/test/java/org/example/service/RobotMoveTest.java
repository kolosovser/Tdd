package org.example.service;


import java.util.List;
import org.example.Robot;
import org.example.model.Coordinate;
import org.example.model.RobotDirection;
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
        .direction(RobotDirection.N)
        .instructions(List.of(L, M, L, M, L, M, L, M, M))
        .build();

    Robot expectedRobot = Robot.builder()
        .coordinate(new Coordinate(1, 3))
        .direction(RobotDirection.N)
        .build();

    //when
    initRobot.move(new Coordinate(5, 5));

    //then
    Assertions.assertEquals(expectedRobot.getCoordinate(), initRobot.getCoordinate());
    Assertions.assertEquals(expectedRobot.getDirection(), initRobot.getDirection());
  }

}
