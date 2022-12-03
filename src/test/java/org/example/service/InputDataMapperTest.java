package org.example.service;

import java.util.List;
import java.util.stream.Stream;
import org.example.Robot;
import org.example.model.Coordinate;
import org.example.model.RobotDirection;
import org.example.model.RobotInstruction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class InputDataMapperTest {

  @MethodSource("getTestData")
  @DisplayName("Маппинг введенных в консоль данных на класс Robot")
  @ParameterizedTest(name = "{0}")
  void mapOneRobotPositiveTest(String testName, List<String> initData, List<Robot> expectedResult) {

    //when
    List<Robot> actualResult = InputDataMapper.mapInputDataToRobots(initData);

    //then
    Assertions.assertNotNull(actualResult);
    Assertions.assertEquals(expectedResult.size(), actualResult.size());
    Assertions.assertTrue(expectedResult.containsAll(actualResult));
  }

  private static Stream<Arguments> getTestData() {
    return Stream.of(
        Arguments.of(
            "Маппинг введенных в консоль данных на класс Robot",
            List.of(
                "5 5",
                "1 2 N",
                "LM"
            ),
            List.of(
                Robot.builder()
                    .coordinate(new Coordinate(1, 2))
                    .direction(RobotDirection.N)
                    .instructions(List.of(RobotInstruction.L, RobotInstruction.M))
                    .platoSize(new Coordinate(5, 5))
                    .build()
            )
        )
    );
  }

}