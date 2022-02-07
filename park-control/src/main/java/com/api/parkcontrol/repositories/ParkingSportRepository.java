package com.api.parkcontrol.repositories;

import com.api.parkcontrol.models.ParkingSpotModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ParkingSportRepository  extends JpaRepository<ParkingSpotModel, UUID> {
}
