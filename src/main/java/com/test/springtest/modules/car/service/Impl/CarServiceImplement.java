package com.test.springtest.modules.car.service.Impl;

import com.test.springtest.modules.car.api.model.CarRequest;
import com.test.springtest.modules.car.persistence.entity.Car;
import com.test.springtest.modules.car.persistence.repository.CarRepository;
import com.test.springtest.modules.car.service.CarService;
import com.test.springtest.modules.person.exception.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImplement implements CarService {


    @Autowired
    CarRepository carRepository;

    @Override
    public Page<Car> getAll(CarRequest searchRequest, Specification<Car> specification) {
        Pageable pageable;
        if(searchRequest.sortDirection){
            pageable =   PageRequest.of(searchRequest.page
                    ,searchRequest.size,
                    Sort.by(Sort.Direction.ASC,
                            searchRequest.sortBy));
        }else {
            pageable =   PageRequest.of(searchRequest.page
                    ,searchRequest.size,
                    Sort.by(Sort.Direction.DESC,
                            searchRequest.sortBy));
        }
        return carRepository.findAll(specification,pageable);
    }

    @Override
    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car getCarById(Long id) {
        return carRepository.findById(id).orElseThrow(PersonNotFoundException::new);
    }

    @Override
    public Car updateCar(Car car)
    {
        if (car.getId() == null) {

            throw new PersonNotFoundException();
        }
        Car carDb = carRepository.findById(car.getId())
                .orElseThrow(PersonNotFoundException::new);

        return carRepository.save(carDb);
    }

    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

}
