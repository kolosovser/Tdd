package org.example.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import org.example.exception.InputDataException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RobotSystemFacadeNegativeValidationTest {

  @MethodSource("getTestData")
  @DisplayName("Ошибка входных данных")
  @ParameterizedTest(name = "{0}")
  void validateInputData(String testName, List<String> inputData, String errorReason) {

    //when
    InputDataException exception = assertThrows(
        InputDataException.class,
        () -> RobotSystemFacade.handle(inputData)
    );

    //then
    assertSame(InputDataException.class, exception.getClass());
    assertSame(errorReason, exception.getMessage());
  }

  private static Stream<Arguments> getTestData() {
    return Stream.of(
        Arguments.of("Входные данные отсутствуют", null, "Input data is not presented"),
        Arguments.of("Входные данные пустые", Collections.emptyList(), "Input data is not presented"),
        Arguments.of("Передан только размер поля", List.of(1), "Input data has wrong size"),
        Arguments.of("Передан размер поля и неполная информация об одном единственном роботе", List.of(2),
            "Input data has wrong size"),
        Arguments.of("Передан размер поля и неполная информация об одном роботе из кучи роботов", List.of(15),
            "Input data has wrong size")
    );
  }

}