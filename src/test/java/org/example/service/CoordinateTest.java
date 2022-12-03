package org.example.service;


import org.example.model.Coordinate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CoordinateTest {

  @Test
  @DisplayName("Two Coordinates are equal when the coordinates are the same")
  void robotCoordinatePositiveTest() {

    //given
    int initX = 1;
    int initY = 2;

    //when
    Coordinate coordinate = new Coordinate(initX, initY);

    //then
    Assertions.assertEquals(initX, coordinate.getX());
    Assertions.assertEquals(initY, coordinate.getY());

  }

  @Test
  @DisplayName("Two Coordinates are not equal when the coordinates are not the same")
  void robotCoordinateNegativeTest() {

    //given
    int initX = 1;
    int initY = 2;
    int unexpectedX = 3;
    int unexpectedY = 4;

    //when
    Coordinate coordinate = new Coordinate(initX, initY);

    //then
    Assertions.assertNotEquals(unexpectedX, coordinate.getX());
    Assertions.assertNotEquals(unexpectedY, coordinate.getY());

  }

}
