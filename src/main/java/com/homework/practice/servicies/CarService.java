package com.homework.practice.servicies;

import com.homework.practice.entities.Car;
import com.homework.practice.entities.CarDTO;
import com.homework.practice.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<CarDTO> getAllCars() {
        return carRepository.findAll()
                .stream()
                .map(Car::toDTO)
                .collect(Collectors.toList());
    }

    public CarDTO getCarById(Long carId) {
        Optional<Car> car = carRepository.findById(carId);
        if (car.isPresent()) {
            return CarDTO.builder()
                    .id(car.get().getCarId())
                    .carBrand(car.get().getCarBrand())
                    .carModel(car.get().getCarModel())
                    .carColor(car.get().getCarColor())
                    .carPrice(car.get().getCarPrice())
                    .build();
        }
        return CarDTO.builder().build();
    }


    public void updateCar(CarDTO carDTO) {
        if (carDTO != null) {
            Car car = carRepository.findById(carDTO.getId()).orElse(null);
            if (car != null) {
                car.setCarBrand(carDTO.getCarBrand());
                car.setCarModel(carDTO.getCarModel());
                car.setCarColor(carDTO.getCarColor());
                car.setCarPrice(carDTO.getCarPrice());
                car.setCurrency(carDTO.getCurrency());
                carRepository.save(car);
            }
        }
    }


    public void deleteCarById(Long carId) {
        if (carId != null) {
            carRepository.deleteById(carId);
        }
    }

    public void insertCar(CarDTO carDTO) {
        if (carDTO != null) {
            Car car = carRepository.findById(carDTO.getId()).orElse(null);
            if (car != null) {
                car.setCarBrand(carDTO.getCarBrand());
                car.setCarModel(carDTO.getCarModel());
                car.setCarColor(carDTO.getCarColor());
                car.setCarPrice(carDTO.getCarPrice());
                car.setCurrency(carDTO.getCurrency());
                carRepository.save(car);
            }
        }
    }
}
