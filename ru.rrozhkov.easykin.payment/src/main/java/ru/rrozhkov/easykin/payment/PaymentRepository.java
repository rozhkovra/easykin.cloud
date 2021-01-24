package ru.rrozhkov.easykin.payment;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends CrudRepository<PaymentEntity, Long>, JpaSpecificationExecutor<PaymentEntity> {
}
