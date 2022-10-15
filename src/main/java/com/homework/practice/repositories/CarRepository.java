package com.homework.practice.repositories;

import com.homework.practice.entities.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface CarRepository extends CrudRepository <Car, Long> {
    List<Car> findAll();
}
