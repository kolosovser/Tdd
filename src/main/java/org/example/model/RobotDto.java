package org.example.model;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RobotDto {

  RobotLocationDto robotLocationDto;
  List<RobotInstruction> robotInstructions;

}
