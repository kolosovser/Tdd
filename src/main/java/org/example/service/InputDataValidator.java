package org.example.service;

import java.util.List;
import java.util.Objects;
import lombok.experimental.UtilityClass;
import org.example.exception.InputDataException;

@UtilityClass
public class InputDataValidator {

  public static void validateInputData(List<String> inputData) {
    if (Objects.isNull(inputData) || inputData.isEmpty()) {
      throw new InputDataException("Input data is not presented");
    }

    boolean inputDataHasFieldSizeAndAllRobotsInfo = inputData.size() == 1
        || (inputData.size() - 1) % 2 != 0;

    if (inputDataHasFieldSizeAndAllRobotsInfo) {
      throw new InputDataException("Input data has wrong size");
    }

  }

}
