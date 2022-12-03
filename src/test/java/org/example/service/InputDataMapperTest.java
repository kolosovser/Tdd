package org.example.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import org.example.Robot;
import org.example.model.Coordinate;
import org.example.model.Plato;
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
  void mapOneRobotPositiveTest(String testName, List<String> initData, Plato expectedResult) {

    //when
    Plato actualResult = InputDataMapper.mapInputDataToPojo(initData);

    //then
    Assertions.assertNotNull(actualResult);
    Assertions.assertEquals(expectedResult.getRobots().size(), actualResult.getRobots().size());
    Assertions.assertTrue(expectedResult.getRobots().containsAll(actualResult.getRobots()));
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
            new Plato(
                new Coordinate(5, 5),
                Collections.singletonList(Robot.builder()
                    .coordinate(new Coordinate(1, 2))
                    .direction(RobotDirection.N)
                    .instructions(List.of(RobotInstruction.L, RobotInstruction.M))
                    .build())
            )
        )
    );
  }

}