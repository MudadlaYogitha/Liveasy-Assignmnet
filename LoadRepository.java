package com.example.demo;

import com.example.demo.Load;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.UUID;

public interface LoadRepository extends JpaRepository<Load, UUID> {

    List<Load> findByShipperId(UUID shipperId);
    List<Load> findByTruckType(String truckType);
    List<Load> findByProductType(String productType);

    // Custom queries to find by loading and unloading points in the embedded Facility object
    List<Load> findByFacility_LoadingPoint(String loadingPoint);
    List<Load> findByFacility_UnloadingPoint(String unloadingPoint);

    // Custom query for combined loading and unloading points
    @Query("SELECT l FROM Load l WHERE l.facility.loadingPoint = :loadingPoint AND l.facility.unloadingPoint = :unloadingPoint")
    List<Load> findByFacility_LoadingPointAndFacility_UnloadingPoint(String loadingPoint, String unloadingPoint);
}
