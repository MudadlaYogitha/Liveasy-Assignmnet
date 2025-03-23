package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LoadService {

    private final LoadRepository loadRepository;

    public LoadService(LoadRepository loadRepository) {
        this.loadRepository = loadRepository;
    }

    // Create a new Load
    public Load createLoad(Load load) {
        return loadRepository.save(load);
    }

    // Get all Loads (with optional filtering by parameters)
    public List<Load> getLoads(UUID shipperId, String truckType, String productType, String loadingPoint, String unloadingPoint) {
        if (shipperId != null) {
            return loadRepository.findByShipperId(shipperId);
        }
        if (truckType != null) {
            return loadRepository.findByTruckType(truckType);
        }
        if (productType != null) {
            return loadRepository.findByProductType(productType);
        }
        if (loadingPoint != null && unloadingPoint != null) {
            return loadRepository.findByFacility_LoadingPointAndFacility_UnloadingPoint(loadingPoint, unloadingPoint);
        }
        if (loadingPoint != null) {
            return loadRepository.findByFacility_LoadingPoint(loadingPoint);
        }
        if (unloadingPoint != null) {
            return loadRepository.findByFacility_UnloadingPoint(unloadingPoint);
        }

        return loadRepository.findAll(); // Return all loads if no filters applied
    }

    // Get Load by ID
    public Load getLoadById(UUID loadId) {
        return loadRepository.findById(loadId).orElse(null); // Directly return Load or null if not found
    }

    // Update Load details
    public Load updateLoad(UUID loadId, Load updatedLoad) {
        Optional<Load> existingLoad = loadRepository.findById(loadId);

        if (existingLoad.isPresent()) {
            Load load = existingLoad.get();
            load.setFacility(updatedLoad.getFacility());
            load.setProductType(updatedLoad.getProductType());
            load.setTruckType(updatedLoad.getTruckType());
            load.setNoOfTrucks(updatedLoad.getNoOfTrucks());
            load.setWeight(updatedLoad.getWeight());
            load.setComment(updatedLoad.getComment());
            load.setShipperId(updatedLoad.getShipperId());
            load.setDate(updatedLoad.getDate());

            return loadRepository.save(load); // Return updated load
        }

        return null; // Return null if load not found
    }

    // Delete Load by ID
    public boolean deleteLoad(UUID loadId) {
        if (loadRepository.existsById(loadId)) {
            loadRepository.deleteById(loadId);
            return true;
        }
        return false;
    }
}
