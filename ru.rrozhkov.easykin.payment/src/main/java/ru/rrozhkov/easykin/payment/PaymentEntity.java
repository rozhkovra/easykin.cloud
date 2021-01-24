package ru.rrozhkov.easykin.payment;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "payment")
@Data
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "COMMENT")
    private String comment;

    @Column(name = "CREATEDATE")
    private Date createDate;

    @Column(name = "CATEGORYID")
    private int categoryId;

    @Column(name = "CLOSEDATE")
    private Date closeDate;

    @Column(name = "STATUSID")
    private int statusId;

    @Column(name = "AMOUNT")
    private Double amount;
}
