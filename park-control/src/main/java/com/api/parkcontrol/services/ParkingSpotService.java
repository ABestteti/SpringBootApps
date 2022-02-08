package com.api.parkcontrol.services;

import com.api.parkcontrol.models.ParkingSpotModel;
import com.api.parkcontrol.repositories.ParkingSpotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ParkingSpotService {

    private final ParkingSpotRepository parkingSpotRepository;

    // Always add the annotation @Transaction for save and delete methods!
    @Transactional
    public ParkingSpotModel save(ParkingSpotModel parkingSportModel) {
        return parkingSpotRepository.save(parkingSportModel);
    }

    public boolean existsByLicensePlateCar(String licensePlateCar) {
        return parkingSpotRepository.existsByLicensePlateCar(licensePlateCar);
    }

    public boolean existsByParkingSpotNumber(String parkingSpotNumber) {
        return parkingSpotRepository.existsByParkingSpotNumber(parkingSpotNumber);
    }

    public boolean existsByApartmentAndBlock(String apartment, String block) {
        return parkingSpotRepository.existsByApartmentAndBlock(apartment, block);
    }

    public List<ParkingSpotModel> findAll() {
        return parkingSpotRepository.findAll();
    }

    public Optional<ParkingSpotModel> findById(UUID id) {
        return parkingSpotRepository.findById(id);
    }

    // Always add the annotation @Transaction for save and delete methods!
    @Transactional
    public void delete(ParkingSpotModel parkingSpotModel) {
        parkingSpotRepository.deleteById(parkingSpotModel.getId());
    }
}
