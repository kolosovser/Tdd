package org.example.service;


import org.example.model.Coordinate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CoordinateTest {

  @Test
  void robotCoordinateTest() {

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
