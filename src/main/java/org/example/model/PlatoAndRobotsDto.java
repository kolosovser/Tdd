package org.example.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PlatoAndRobotsDto {

  PlatoDto platoDto;
  List<RobotDto> robots;

}
