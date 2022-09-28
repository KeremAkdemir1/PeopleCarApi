package com.test.springtest.modules.car.persistence.specification;

import com.test.springtest.modules.car.api.model.CarRequest;
import com.test.springtest.modules.car.persistence.entity.Car;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class CarSpecification {

    public static Specification<Car> search(CarRequest request){
        return new Specification<Car>() {
            List<Predicate> predicates = new ArrayList<>();
            public Predicate toPredicate(Root<Car> root,
                                         CriteriaQuery<?> query,
                                         CriteriaBuilder criteriaBuilder) {
                if(request.name != null && request.name != ""){
                    predicates.add(
                            criteriaBuilder.like(
                                    root.get("name"),
                                    request.name
                            )
                    );
                }
                if (request.color != null){
                    predicates.add(
                            criteriaBuilder.equal(
                                    root.get("color"),
                                    request.color
                            )
                    );
                }
                if(request.engine !=null){
                    predicates.add(
                            criteriaBuilder.equal(
                                    root.get("engine"),
                                    request.engine
                            )
                    );
                }
                if(request.seat !=null){
                    predicates.add(
                            criteriaBuilder.equal(
                                    root.get("seat"),
                                    request.seat
                            )
                    );
                }
                if(request.type !=null){
                    predicates.add(
                            criteriaBuilder.equal(
                                    root.get("type"),
                                    request.type
                            )
                    );
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));

            }


        };
    }

}
