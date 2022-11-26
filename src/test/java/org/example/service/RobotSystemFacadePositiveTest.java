package org.example.service;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RobotSystemFacadePositiveTest {

  @MethodSource("getTestData")
  @DisplayName("Успешный сценарий")
  @ParameterizedTest(name = "{0}")
  void goodScenarioTest(String testName, List<String> inputData, List<String> expectedResult) {

    //when
    List<String> result = RobotSystemFacade.handle(inputData);

    //then
    Assertions.assertNotNull(result);
    Assertions.assertEquals(expectedResult.size(), result.size());
    Assertions.assertTrue(expectedResult.containsAll(result));
  }

  private static Stream<Arguments> getTestData() {
    return Stream.of(
        Arguments.of(
            "Пример из ТЗ",
            List.of(
                "5 5",
                "1 2 N",
                "LMLMLMLMM",
                "3 3 E",
                "MMRMMRMRRM"
            ),
            List.of(
                "1 3 N",
                "5 1 E"
            )
        ),
        Arguments.of(
            "Робот упёрся в стену",
            List.of(
                "5 5",
                "5 5 E",
                "MMMMMMMLLM"
            ),
            List.of("4 5 W")
        )

    );
  }

}