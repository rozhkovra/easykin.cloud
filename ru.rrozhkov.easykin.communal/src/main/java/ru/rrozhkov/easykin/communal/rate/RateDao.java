package ru.rrozhkov.easykin.communal.rate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Predicate;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class RateDao {
  @Autowired
  RateRepository rateRepository;

  public Iterable<RateEntity> findByDateAndType(LocalDate date, String rateType) {
    return rateRepository.findAll((Specification<RateEntity>) (root, query, criteriaBuilder) -> {
      List<Predicate> predicates = new ArrayList<>();
      predicates.add(criteriaBuilder.and(criteriaBuilder.greaterThanOrEqualTo(root.get("dateTo"), date)));
      predicates.add(criteriaBuilder.and(criteriaBuilder.lessThanOrEqualTo(root.get("dateFrom"), date)));
      if (rateType != null) {
        predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("rateType"), rateType)));
      }
      return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
    });
  }
}
