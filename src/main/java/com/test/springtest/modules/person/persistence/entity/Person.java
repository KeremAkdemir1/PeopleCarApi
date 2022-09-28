package com.test.springtest.modules.person.persistence.entity;

import com.test.springtest.common.persistence.entity.BaseEntity;
import com.test.springtest.modules.car.persistence.entity.Car;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "person")
public class Person extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false)
    public Long id;

    @Column(name = "name",nullable = false)
    public String name;

    @Column(name = "age",nullable = false)
    public Integer age;

    @Column(name = "sick",nullable = false)
    public Boolean sick;

    @Column(name = "has_license",nullable = false)
    public Boolean hasLicense;

    @Column(name = "married",nullable = false)
    public Boolean married;

    @OneToMany(targetEntity = Car.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "car_fk",nullable = false,referencedColumnName = "id")
    public List<Car> cars;

}