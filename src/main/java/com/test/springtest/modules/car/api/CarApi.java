package com.test.springtest.modules.car.api;

import com.test.springtest.modules.car.mapper.CarMapper;
import com.test.springtest.modules.car.api.model.CarRequest;
import com.test.springtest.modules.car.persistence.entity.Car;
import com.test.springtest.modules.car.persistence.specification.CarSpecification;
import com.test.springtest.modules.car.service.CarService;
import com.test.springtest.modules.car.service.dto.CarDto;
import com.test.springtest.util.PagingModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/car")
@RestController
public class CarApi {

    @Autowired
    private CarMapper carMapper;
    @Autowired
    private CarService carService;



    @PostMapping("/search")
    public ResponseEntity<PagingModel<CarDto>> getAll(@RequestBody CarRequest request){
        Page pageData = carService.getAll(
                request,
                CarSpecification.search(request)
        );

        PagingModel carPage = new PagingModel();
        carPage.setTotalItems(pageData.getTotalElements());
        carPage.setCurrentPage(pageData.getNumber());
        carPage.setTotalPage(pageData.getTotalPages());
        carPage.setData(carMapper.convert(pageData.getContent()));

        return new ResponseEntity(carPage,new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CarDto> save(@RequestBody CarRequest carRequest){
        return new ResponseEntity(carService.createCar(carMapper.convertToEntity(carRequest)),
                new HttpHeaders(),
                HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<CarDto> getPersonById(@PathVariable Long id){
        return new ResponseEntity<>(carMapper.convert(carService.getCarById(id))
                ,new HttpHeaders(),
                HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<CarDto> updatePerson(@RequestBody CarRequest carRequest){
        Car car = carService.getCarById(carRequest.id);

        carMapper.convert(carRequest,car);

        return new ResponseEntity<>(carMapper.convert(carService.updateCar(car))
                ,new HttpHeaders(),
                HttpStatus.ACCEPTED);
    }

    @DeleteMapping
    public void deletePerson(@PathVariable Long id){
        carService.deleteCar(id);
    }

}
