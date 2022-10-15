package com.homework.practice.endpoints;

import com.homework.practice.entities.CarDTO;
import com.homework.practice.servicies.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarEndpoints {

    @Autowired
    private CarService carService;

    @GetMapping("/car")
    public List<CarDTO> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/car/{carId}")
    public CarDTO getCarById(@PathVariable Long carId) {
        return carService.getCarById(carId);
    }

    @PutMapping("/car")
    public void updateCar(@RequestBody CarDTO carDTO) {
        carService.updateCar(carDTO);
    }

    @DeleteMapping("/car/{carId}")
    public void deleteCarByID(@PathVariable Long carId) {
        carService.deleteCarById(carId);
    }

    @PostMapping("/car")
    public void insertCar(@RequestBody CarDTO carDTO) {
        carService.insertCar(carDTO);
    }
}
