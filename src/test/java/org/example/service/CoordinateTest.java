package org.example.service;


import org.example.model.Coordinate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CoordinateTest {

  @Test
  void robotCoordinateTest() {

    //given
    int expectedX = 1;
    int expectedY = 2;

    //when
    Coordinate coordinate = new Coordinate(expectedX, expectedY);

    //then
    Assertions.assertEquals(expectedX, coordinate.getX());
    Assertions.assertEquals(expectedY, coordinate.getY());

  }

}
