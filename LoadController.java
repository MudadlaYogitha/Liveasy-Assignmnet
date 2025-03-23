package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/load")
public class LoadController {

    private final LoadService loadService;

    public LoadController(LoadService loadService) {
        this.loadService = loadService;
    }

    // 1. Create a Load (POST /load)
    @PostMapping
    public ResponseEntity<Load> createLoad(@RequestBody Load load) {
        // Log the received load to check if the facility is included
        System.out.println("Received Load: " + load);
        // Log the facility
        System.out.println("Facility: " + load.getFacility());
        
        // Create the load and return the saved load
        Load savedLoad = loadService.createLoad(load);
        return ResponseEntity.status(201).body(savedLoad);
    }

    // 2. Get all Loads with filters (GET /load?shipperId=&truckType=&productType=&loadingPoint=&unloadingPoint=)
    @GetMapping
    public ResponseEntity<List<Load>> getLoads(
            @RequestParam(required = false) UUID shipperId,
            @RequestParam(required = false) String truckType,
            @RequestParam(required = false) String productType,
            @RequestParam(required = false) String loadingPoint,
            @RequestParam(required = false) String unloadingPoint) {
        
        // Get loads from the service with applied filters
        List<Load> loads = loadService.getLoads(shipperId, truckType, productType, loadingPoint, unloadingPoint);
        
        // Return loads in the response
        return ResponseEntity.ok(loads);
    }

    // 3. Get Load by ID (GET /load/{loadId})
    @GetMapping("/{loadId}")
    public ResponseEntity<Load> getLoadById(@PathVariable UUID loadId) {
        Load load = loadService.getLoadById(loadId);
        return ResponseEntity.ok(load);
    }

    // 4. Update Load (PUT /load/{loadId})
    @PutMapping("/{loadId}")
    public ResponseEntity<Load> updateLoad(@PathVariable UUID loadId, @RequestBody Load loadDetails) {
        // Log the load details to check if the facility data is included
        System.out.println("Updating Load with ID: " + loadId);
        System.out.println("New Load Details: " + loadDetails);
        
        // Update the load and return the updated load
        Load updatedLoad = loadService.updateLoad(loadId, loadDetails);
        return ResponseEntity.ok(updatedLoad);
    }

    // 5. Delete Load (DELETE /load/{loadId})
    @DeleteMapping("/{loadId}")
    public ResponseEntity<String> deleteLoad(@PathVariable UUID loadId) {
        loadService.deleteLoad(loadId);
        return ResponseEntity.ok("Load deleted successfully.");
    }
}
