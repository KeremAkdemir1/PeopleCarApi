package com.test.springtest.modules.person.persistence.specification;

import com.test.springtest.modules.person.api.model.PersonRequest;
import com.test.springtest.modules.person.persistence.entity.Person;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class PersonSpecification {
    public static Specification<Person> search(PersonRequest request){
        return new Specification<Person>() {
            List<Predicate> predicates = new ArrayList<>();
            public Predicate toPredicate(Root<Person> root,
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
                if (request.age != null){
                    predicates.add(
                            criteriaBuilder.equal(
                                    root.get("age"),
                                    request.age
                            )
                    );
                }
                if(request.sick !=null){
                    predicates.add(
                            criteriaBuilder.equal(
                                    root.get("sick"),
                                    request.sick
                            )
                    );
                }
                if(request.hasLicense !=null){
                    predicates.add(
                            criteriaBuilder.equal(
                                    root.get("hasLicense"),
                                    request.hasLicense
                            )
                    );
                }
                if(request.married !=null){
                    predicates.add(
                            criteriaBuilder.equal(
                                    root.get("married"),
                                    request.married
                            )
                    );
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));

            }


        };
    }
}
