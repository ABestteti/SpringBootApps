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
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

  @GetMapping
  public ResponseEntity<List<ParkingSpotModel>> getAllParkingSpots() {
    return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Object> getOneParkingSpots(@PathVariable(value = "id") UUID id) {
    Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findById(id);

    if (!parkingSpotModelOptional.isPresent()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking spot not found.");
    }
    return ResponseEntity.status(HttpStatus.OK).body(parkingSpotModelOptional.get());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deleteParkingSpots(@PathVariable(value = "id") UUID id) {
    Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findById(id);

    if (!parkingSpotModelOptional.isPresent()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking spot not found.");
    }

    parkingSpotService.delete(parkingSpotModelOptional.get());

    return ResponseEntity.status(HttpStatus.OK).body("Parking Spot deleted successfully.");
  }
}
