package com.api.parkcontrol.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Setter
@Getter
public class ParkingSportDto {

  @NotBlank(message = "Parking spot number must be informed.")
  @Size(max = 10)
  private String parkingSpotNumber;

  @NotBlank
  @Size(max = 7)
  private String licensePlateCar;

  @NotBlank
  @Size(max = 70)
  private String brandCar;

  @NotBlank
  @Size(max = 70)
  private String modelCar;

  @NotBlank
  @Size(max = 70)
  private String colorCar;

  @NotBlank private String responsibleName;

  @NotBlank private String apartment;

  @NotBlank
  @Size(max = 30)
  private String block;
}
