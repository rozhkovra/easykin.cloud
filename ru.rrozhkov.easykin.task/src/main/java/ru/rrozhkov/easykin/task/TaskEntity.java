package ru.rrozhkov.easykin.task;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "task")
@Data
public class TaskEntity implements ITask {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CREATEDATE")
    private Date createDate;

    @Column(name = "PLANDATE")
    private Date planDate;

    @Column(name = "CLOSEDATE")
    private Date closeDate;

    @Column(name = "STATUSID")
    private Integer status;

    @Column(name = "PRIORITYID")
    private Integer priority;

    @Column(name = "CATEGORYID")
    private Integer category;
}
