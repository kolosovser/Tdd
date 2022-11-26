package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class RobotLocationDto {

  Integer x;
  Integer y;
  RobotCameraDirection cameraDirection;

}
