package org.example.service;

import java.util.List;
import org.example.Robot;
import org.example.model.Coordinate;
import org.example.model.RobotDirection;
import org.example.model.RobotInstruction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ResponseMapperTest {

  @Test
  void mapRobotInfoToResponsePositiveTest() {

    //given
    Robot robot = Robot.builder()
        .coordinate(new Coordinate(1, 2))
        .direction(RobotDirection.N)
        .instructions(List.of(RobotInstruction.L, RobotInstruction.M))
        .build();

    String expectedResult = "1 2 N";

    //when
    List<String> result = ResponseMapper.mapRobotInfoToResponse(List.of(robot));

    //then
    Assertions.assertEquals(expectedResult, result.get(0));

  }

}