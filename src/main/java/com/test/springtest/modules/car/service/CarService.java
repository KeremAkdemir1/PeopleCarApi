package com.test.springtest.modules.car.service;

import com.test.springtest.modules.car.api.model.CarRequest;
import com.test.springtest.modules.car.persistence.entity.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;

public interface CarService {

    Page<Car> getAll(CarRequest searchRequest, Specification<Car> specification);

    Car createCar(Car car);

    Car getCarById(Long id);

    Car updateCar(Car car);

    void deleteCar(Long id);
}
