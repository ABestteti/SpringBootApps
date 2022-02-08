package com.api.parkcontrol.controllers;

import com.api.parkcontrol.dtos.ParkingSportDto;
import com.api.parkcontrol.models.ParkingSpotModel;
import com.api.parkcontrol.services.ParkingSpotService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parking-spot")
@RequiredArgsConstructor
public class ParkingSpotController {

  final ParkingSpotService parkingSpotService;

  @PostMapping
  public ResponseEntity<Object> saveParkingSport(
      @RequestBody @Valid ParkingSportDto parkingSportDto) {

    //  Validations, see Custom Validations to improve the code
    if (parkingSpotService.existsByLicensePlateCar(parkingSportDto.getLicensePlateCar())) {
      return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: License Plate Car is already in use.");
    }

    if (parkingSpotService.existsByParkingSpotNumber(parkingSportDto.getParkingSpotNumber())) {
      return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Parking Spot Number is already in use.");
    }

    if (parkingSpotService.existsByApartmentAndBlock(parkingSportDto.getApartment(), parkingSportDto.getBlock())) {
      return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Apartment and Block are already registered.");
    }

    var parkingSpotModel = new ParkingSpotModel();
    BeanUtils.copyProperties(parkingSportDto, parkingSpotModel);
    parkingSpotModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
    return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.save(parkingSpotModel));
  }
}
