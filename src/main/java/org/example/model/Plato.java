package org.example.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.example.Robot;

@Data
@Builder
@AllArgsConstructor
public class Plato {

  Coordinate coordinate;
  List<Robot> robots;

}
