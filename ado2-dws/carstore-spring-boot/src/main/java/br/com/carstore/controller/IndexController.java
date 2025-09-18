package br.com.carstore.controller;

import br.com.carstore.model.CarDTO;
import br.com.carstore.model.CarResponseEntity;
import br.com.carstore.model.CarDTO;
import br.com.carstore.model.CarResponseEntity;
import br.com.carstore.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IndexController {

    private final CarService carService;

    public IndexController(CarService service) {
        this.carService = service;
    }

    @GetMapping("/api/cars")
    public ResponseEntity<CarResponseEntity> home() {
        List<br.com.carstore.model.CarDTO> allCars = carService.findAll();
        CarResponseEntity carResponseBody = new CarResponseEntity(allCars);
        return ResponseEntity.ok(carResponseBody);
    }

    @PostMapping("/api/cars")
    public ResponseEntity<br.com.carstore.model.CarDTO> createCar(@RequestBody br.com.carstore.model.CarDTO car) {
        this.carService.save(new br.com.carstore.model.CarDTO());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/api/cars/{id}")
    public ResponseEntity<br.com.carstore.model.CarDTO> deleteCar(@PathVariable String id) {
        this.carService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/api/cars/{id}")
    public ResponseEntity<br.com.carstore.model.CarDTO> updateCar(@PathVariable String id, @RequestBody br.com.carstore.model.CarDTO carDTO) {
        this.carService.update(id, carDTO);
        return ResponseEntity.ok(carDTO);
    }


}